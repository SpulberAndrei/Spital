package com.example.spitaljpa1.consultatie;

import javax.persistence.*;

@Entity
public class Consultatie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long consultatieId;
    private Long sectieId;
    private Long angajatId;
    private Long pacientId;

    public Consultatie() {
    }

    public Consultatie(Long sectieId, Long angajatId, Long pacientId) {
        this.sectieId = sectieId;
        this.angajatId = angajatId;
        this.pacientId = pacientId;
    }

    public Long getConsultatieId() {
        return consultatieId;
    }

    public Long getSectieId() {
        return sectieId;
    }

    public void setSectieId(Long sectieId) {
        this.sectieId = sectieId;
    }

    public Long getAngajatId() {
        return angajatId;
    }

    public void setAngajatId(Long angajatId) {
        this.angajatId = angajatId;
    }

    public Long getPacientId() {
        return pacientId;
    }

    public void setPacientId(Long pacientId) {
        this.pacientId = pacientId;
    }
}
