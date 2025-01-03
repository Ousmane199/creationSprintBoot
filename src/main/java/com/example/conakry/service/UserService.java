package com.example.conakry.service;

import com.example.conakry.modele.User;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface UserService {

    List<User> listeUsers();
    User recupererUser(Long id);
    User ajouterUser(User user);
    User supprimerUser(Long id);
    User modifierUser(User user, Long id);
}