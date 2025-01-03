package com.example.conakry.service;

import java.util.List;

import com.example.conakry.modele.Ordinateur;


public interface OrdinateurService {

    public List<Ordinateur> listeOrdinateurs ();
    public Ordinateur recupererOrdinateur (Long id);
    public void ajouterOrdinateur (Ordinateur ordinateur);
    public void supprimerOrdinateur (Long id);
    public void modifierOrdinateur (Ordinateur ordinateur,Long id);// On cherche son id pour le modifier sinon le creer automatiquement
}
