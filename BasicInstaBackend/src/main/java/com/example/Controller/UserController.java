package com.example.Controller;

import com.example.Entity.User;
import com.example.Service.AuthTokenUserService;
import com.example.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    AuthTokenUserService authTokenUserService;


    @PostMapping("user/signUp")
    public String signUpUser(@RequestBody User user){
          return userService.signUpUser(user);
    }

    @PostMapping("user/signIn")
    public String signInUser(@RequestParam String userEmail , @RequestParam String password ){
        return userService.signInUser(userEmail , password);
    }

    @DeleteMapping("user/signOut")
    public String signOut(@RequestParam String email , @RequestParam String authToken){
        if(authTokenUserService.authenticate(email , authToken)){
            return userService.signOut(email);
        }else{
            return "You are not valid user sign in first to signOut";
        }
    }

    @PutMapping("user/instaId")
    public String updateProfile(@RequestParam String email , @RequestParam String token , @RequestParam String instaId ){
        if(authTokenUserService.authenticate(email , token))
        {
            return userService.updateProfile(instaId , email);
        }else {
            return "Your are not authorize user..Please create your account or sing in if you have existing one..";
        }

    }
}
