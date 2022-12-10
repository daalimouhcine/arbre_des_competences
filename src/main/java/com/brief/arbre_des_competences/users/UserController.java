package com.brief.arbre_des_competences.users;

import com.brief.arbre_des_competences.utils.Sout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String loginController(@RequestBody UserEntity user) {
        return  userService.loginService(user.getEmail(), user.getPassword());
    }

    @GetMapping("/all")
    public String allUsersController() {
        return userService.getAllUsers();
    }


}
