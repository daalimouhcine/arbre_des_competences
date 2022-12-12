package com.brief.arbre_des_competences.users;

import com.brief.arbre_des_competences.utils.HashPassword;
import com.brief.arbre_des_competences.utils.Sout;
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
        String status = "401";
        String message = "login invalid";
        UserEntity userLogin = userRepository.getUserByEmail(email);
        if(userLogin != null) {
            if (HashPassword.check(password, userLogin.getPassword())) {
                status = "200";
                message = "login successfully";
            }
        }
        HashMap<String, String> response = new HashMap<>();
        response.put("status", status);
        response.put("message", message);
        return new Gson().toJson(response);
    }

    public String getAllUsers() {
        List<UserEntity> userList = userRepository.allUsers();
        for(UserEntity user : userList) user.setPassword("");
        return new Gson().toJson(userList);
    }

}
