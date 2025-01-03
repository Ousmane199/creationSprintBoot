package com.example.conakry.controller;

import com.example.conakry.modele.User;
import com.example.conakry.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/liste")
    public List<User> getAllUsers() {
        return userService.listeUsers();
    }

    @GetMapping("/utilisateur/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.recupererUser(id);
    }

    @PostMapping("/cUser")
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody User user) {
        return userService.ajouterUser(user);
    }

    @PutMapping("/mUser/{id}")
    public User updateUser(@RequestBody User user, @PathVariable Long id) {
        return userService.modifierUser(user, id);
    }

    @DeleteMapping("/supprimer/{id}")
    public User deleteUser(@PathVariable Long id) {
        return userService.supprimerUser(id);
    }

    
}