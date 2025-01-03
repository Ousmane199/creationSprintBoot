package com.example.conakry.modele;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table
@Data  // Génère les getters, setters et le constructeur par défaut
public class Ordinateur {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String marque;
    @Column(nullable = false)
    private String processeur;
    @Column(nullable = false)
    private Integer prix;

}
