package com.example.spitaljpa1.consultatie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IConsultatieRepository extends JpaRepository<Consultatie,Long> {
}
