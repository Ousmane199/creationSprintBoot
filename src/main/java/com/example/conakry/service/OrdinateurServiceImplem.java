package com.example.conakry.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.conakry.exception.ExceptionErreur;
import com.example.conakry.modele.Ordinateur;
import com.example.conakry.repository.OrdinateurRepository;

@Service
@Transactional
public class OrdinateurServiceImplem implements OrdinateurService {

    private final OrdinateurRepository ordinateurRepository;

    // Constructeur pour l'injection de dépendances
    public OrdinateurServiceImplem(OrdinateurRepository ordinateurRepository) {
        this.ordinateurRepository = ordinateurRepository;
    }

    @Override
    public List<Ordinateur> listeOrdinateurs() {
        // Retourne la liste des ordinateurs depuis la base de données
        return ordinateurRepository.findAll();
    }

    @Override
    public Ordinateur recupererOrdinateur(Long id) {
        // Retourne un ordinateur par son ID ou lève une exception si non trouvé
        return ordinateurRepository.findById(id)
                .orElseThrow(() -> new ExceptionErreur("Ordinateur non trouvé avec l'ID : " + id));
    }

    @Override
    public void ajouterOrdinateur(Ordinateur ordinateur) {
        // Sauvegarde un nouvel ordinateur dans la base
        ordinateurRepository.save(ordinateur);
    }

    @Override
    public void supprimerOrdinateur(Long id) {
        // Vérifie si l'ordinateur existe, puis le supprime
        if (ordinateurRepository.existsById(id)) {
            ordinateurRepository.deleteById(id);
        } else {
            throw new ExceptionErreur("Ordinateur non trouvé avec l'ID : " + id);
        }
    }

    @Override
    public void modifierOrdinateur(Ordinateur ordinateur, Long id) {
        // Mise à jour des informations d'un ordinateur existant
        Ordinateur existingOrdinateur = recupererOrdinateur(id);
        existingOrdinateur.setMarque(ordinateur.getMarque());
        existingOrdinateur.setProcesseur(ordinateur.getProcesseur());
        existingOrdinateur.setPrix(ordinateur.getPrix());
        ordinateurRepository.save(existingOrdinateur);
    }
}
