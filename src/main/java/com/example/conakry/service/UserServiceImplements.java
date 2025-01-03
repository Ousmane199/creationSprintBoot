package com.example.conakry.service;

import com.example.conakry.exception.ExceptionErreur;
import com.example.conakry.modele.User;
import com.example.conakry.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
@Transactional

public class UserServiceImplements implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<User> listeUsers() {
        return userRepository.findAll();
    }

    @Override
    public User recupererUser(Long id) {

        //si on ne trouve pas l'utilisateur, On retourne null

        /* 

        return userRepository
                .findById(id)
                .orElseThrow(() -> new ExceptionErreur("Utilisateur non trouvé avec l'ID : " + id)); */
        
        return userRepository
            .findById(id)
            .orElse(null);

    }

    @Override
    public User ajouterUser(User user) {
        return userRepository.save(user);  // Crée un nouvel utilisateur
    }

    @Override
    public User supprimerUser(Long id) {
        User user = recupererUser(id);
        if (user == null) {
            //throw new ExceptionErreur("Utilisateur non trouvé avec l'ID : " + id);
            return null;
        }
        userRepository.delete(user);
        return user;
    }

    @Override
    public User modifierUser(User user, Long id) {
        User userExistant = recupererUser(id);
        userExistant.setNom(user.getNom());
        userExistant.setPrenom(user.getPrenom());
        userExistant.setAge(user.getAge());
        userExistant.setEmail(user.getEmail());
        return userRepository.save(userExistant);  // Modifie l'utilisateur et le sauvegarde
    }
}