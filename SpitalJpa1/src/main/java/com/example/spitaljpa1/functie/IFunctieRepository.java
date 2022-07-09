package com.example.spitaljpa1.functie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IFunctieRepository extends JpaRepository<Functie,Long> {
    Optional<Functie> findFunctieByNumeFunctie(String numeFunctie);
}
