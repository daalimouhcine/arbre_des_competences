package com.brief.arbre_des_competences.users;

import com.brief.arbre_des_competences.utils.HashPassword;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public String loginService(String email, String password) {
        String status = "500";
        String message = "login invalid";
        UserEntity user = userRepository.getUserByEmail(email);
        if (HashPassword.check(password, user.getPassword())) {
            status = "200";
            message = "login successfully";
        }
        HashMap<String, String> response = new HashMap<>();
        response.put("status", status);
        response.put("message", message);
        return new Gson().toJson(response);

    }

}
