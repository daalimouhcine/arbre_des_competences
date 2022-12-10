package com.brief.arbre_des_competences.users;

import com.brief.arbre_des_competences.utils.HashPassword;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public String loginService(String email, String password) {
        LoginUserResponse response = new LoginUserResponse();
        response.status = "300";
        response.message = "login invalid";
        UserEntity userLogin = userRepository.getUserByEmail(email);
        if (HashPassword.check(password, userLogin.getPassword())) {
            response.status = "200";
            response.message = "login successfully";
            response.user = userLogin;
        }
        return new Gson().toJson(response);
    }

    public String getAllUsers() {
        List<UserEntity> userList = userRepository.allUsers();
        for(UserEntity user : userList) user.setPassword("");
        return new Gson().toJson(userList);
    }

}
