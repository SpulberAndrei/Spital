package com.example.spitaljpa1.angajat;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IAngajatRepository extends JpaRepository<Angajat,Long> {
    Optional<Angajat> findAngajatByEmail(String email);
    Optional<Angajat> findAngajatByNumarTelefon(String numarTelefon);
}
