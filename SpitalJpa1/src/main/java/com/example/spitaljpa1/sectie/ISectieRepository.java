package com.example.spitaljpa1.sectie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ISectieRepository extends JpaRepository<Sectie ,Long> {

    Optional<Sectie> findSectieByNumeSectie(String numeSectie);
}
