package com.user.user.domain.validation;

import com.user.user.domain.exception.EmptyFieldUserException;
import com.user.user.domain.model.User;

import java.util.Calendar;

public abstract class ValidateUser {

    public static void validateUserInput(User user){
        if (user.getName().trim().isEmpty() || user.getSurname().trim().isEmpty() ){
            throw new EmptyFieldUserException(ConstantsDomain.FIELD_NAME_OR_SURNAME_IS_EMPTY_MESSAGE);
        }
        if ( user.getDni().trim().isEmpty() || validDni(user.getDni()) ){
            throw new IllegalArgumentException(ConstantsDomain.FIELD_DNI_IS_EMPTY_MESSAGE);
        }
        if ( user.getEmail().trim().isEmpty() || !validEmail(user.getEmail()) ){
            throw new IllegalArgumentException(ConstantsDomain.FIELD_EMAIL_IS_EMPTY_MESSAGE);
        }
        if ( user.getPhone().trim().isEmpty() || validPhone(user.getPhone())){
            throw new IllegalArgumentException(ConstantsDomain.FIELD_PHONE_IS_EMPTY_MESSAGE);
        }
        if ( user.getBornDate().trim().isEmpty() || validBirdDate(user.getBornDate())){
            throw new IllegalArgumentException(ConstantsDomain.FIELD_BORNDATE_IS_EMPTY_MESSAGE);
        }
        if ( user.getPassword().trim().isEmpty() || validPassword(user.getPassword())){
            throw new IllegalArgumentException(ConstantsDomain.FIELD_PASSWORD_IS_EMPTY_MESSAGE);
        }
    }

    public static boolean validEmail(String email) {
        boolean valid = true;
        String emailPattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        if (!email.matches(emailPattern)) {
            throw new IllegalArgumentException(ConstantsDomain.FIELD_EMAIL_IS_WRONG_MESSAGE);
        }
        return valid;
    }

    public static boolean validBirdDate(String bornDate) {
        boolean valid = false;
        String pattern = "^(?:19|20)\\d{2}([-/.])(0?[1-9]|1[1-2])\\1(0?[1-9]|[12][0-9]|3[01])$";
        if (!bornDate.matches(pattern)) {
            throw new IllegalArgumentException(ConstantsDomain.FIELD_BORNDATE_IS_WRONG_MESSAGE);
        }
        String[] parts = bornDate.split("-");
        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);

        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int currentMonth = Calendar.getInstance().get(Calendar.MONTH);
        int currentDay = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        final int MIN_AGE_REGISTRATION = 18;
        int age = currentYear - year;

        if (month > currentMonth  || (month == currentMonth && day > currentDay )) {
            age--;
        }
         if(age < MIN_AGE_REGISTRATION){
             throw new IllegalArgumentException(ConstantsDomain.FIELD_AGE_IS_NOT_VALID_MESSAGE);
        } return valid;
    }

    public static boolean validPhone(String phoneNumber){
            String pattern = "^\\+?\\d{7,13}$";
        if (!phoneNumber.matches(pattern)) {
            throw new IllegalArgumentException(ConstantsDomain.FIELD_PHONE_IS_NOT_VALID_MESSAGE);
        }
        return false;
    }

    public static boolean validDni(String str) {
            for (char c : str.toCharArray()) {
                if (Character.isLetter(c) && !Character.isWhitespace(c)) {
                    throw  new IllegalArgumentException(ConstantsDomain.FIELD_DNI_IS_NOT_VALID_MESSAGE);
                }
            }
            return false;
    }

    public static boolean validPassword(String password) {
        String pattern = "^(?=.*[a-zA-Z])(?=.*[0-9]).{7,}$";
        if (!password.matches(pattern)) {
            throw  new IllegalArgumentException(ConstantsDomain.FIELD_PASSWORD_IS_NOT_VALID_MESSAGE);
        }
        return false;
    }
}
