package com.example.spitaljpa1.pacient;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IPacientRepository extends JpaRepository<Pacient,Long> {
    Optional<Pacient> findPacientByNumarTelefon(String numarTelefon);
}
