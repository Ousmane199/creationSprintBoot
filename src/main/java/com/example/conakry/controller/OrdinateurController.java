package com.example.conakry.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.example.conakry.modele.Ordinateur;
import com.example.conakry.service.OrdinateurService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/ordinateurs")
@AllArgsConstructor
public class OrdinateurController {

    private final OrdinateurService ordinateurService;

    // Récupérer la liste de tous les ordinateurs
    @GetMapping
    public List<Ordinateur> liste() {
        return ordinateurService.listeOrdinateurs();
    }

    // Récupérer un ordinateur par ID
    @GetMapping("/{id}")
    public Ordinateur recupererOrdinateur(@PathVariable Long id) {
        return ordinateurService.recupererOrdinateur(id);
    }

    // Créer un nouvel ordinateur
    @PostMapping
    public void creation(@RequestBody Ordinateur ordinateur) {
        ordinateurService.ajouterOrdinateur(ordinateur);
    }

    // Modifier un ordinateur existant
    @PutMapping("/{id}")
    public void modification(@RequestBody Ordinateur ordinateur, @PathVariable Long id) {
        ordinateurService.modifierOrdinateur(ordinateur, id);
    }

    // Supprimer un ordinateur par ID
    @DeleteMapping("/{id}")
    public void suppression(@PathVariable Long id) {
        ordinateurService.supprimerOrdinateur(id);
    }
}
