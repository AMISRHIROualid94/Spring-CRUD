package com.springframework.springcrud.controller;

import com.springframework.springcrud.models.User;
import com.springframework.springcrud.repositories.UserRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class myController {

    private final UserRepository userRepository;

    public myController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @GetMapping("/")
    public String HomePage(){
        return "home";
    }

    @GetMapping("/create")
    public String RegisterPage(){
        return "userRegistration";
    }

    @PostMapping("/register")
    public String NewUser(User user){
        userRepository.save(user.toUser());
        return "redirect:/";
    }

    @GetMapping("/users")
    public String GetAllUsers(Model model){
        model.addAttribute("users",userRepository.findAll());
        return "users";
    }

    @GetMapping("/users/{id}")
    public String deleteUser(@PathVariable(value = "id") Long id){
        userRepository.deleteById(id);
        return "redirect:/users";
    }

    @GetMapping("/update/users/{id}")
    public String updateUserForm(@PathVariable Long id,Model model){
        model.addAttribute("usertoupdate",userRepository.findById(id));
        return "userUpdate";
    }

    @PostMapping("/update")
    public String UpdateUser(User user){
       User newUser = user.toUser();
       User lastUser = userRepository.findUserById(newUser.getId());
       lastUser.setUsername(newUser.getUsername());
       lastUser.setPassword(newUser.getPassword());
       lastUser.setEmail(newUser.getEmail());
       lastUser.setFullName(newUser.getFullName());
       userRepository.save(lastUser);
        return "redirect:/users";
    }

}
