package com.example.conakry.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.conakry.modele.Ordinateur;

@Repository
public interface OrdinateurRepository extends JpaRepository<Ordinateur, Long> {
}
