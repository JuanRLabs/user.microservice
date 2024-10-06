package com.user.user.adapters.driven.jpa.mysql.adapter;

import com.user.user.adapters.driven.jpa.mysql.entity.PrincipalUser;
import com.user.user.adapters.driven.jpa.mysql.entity.RoleEntity;
import com.user.user.adapters.driven.jpa.mysql.entity.UserEntity;
import com.user.user.adapters.driven.jpa.mysql.repository.IUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private final IUserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("user not found"));
        List<UserEntity> usersEntity= userRepository.findAllById(userEntity.getId());
        if(usersEntity.isEmpty()){
            throw new UsernameNotFoundException("Username not found with email: " + username);
        }
        List<RoleEntity> roles = new ArrayList<>();
        for (UserEntity user : usersEntity){
            roles.add(user.getIdRole());
        }
        return PrincipalUser.build(userEntity, roles);
    }
}
