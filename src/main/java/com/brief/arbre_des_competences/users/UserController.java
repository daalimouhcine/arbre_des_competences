package com.brief.arbre_des_competences.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String loginController(@RequestBody String email, @RequestBody String password) {
        System.out.println(email);
        return userService.loginService(email, password);

    }



}
