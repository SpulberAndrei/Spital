package com.example.spitaljpa1.angajat;

import com.example.spitaljpa1.consultatie.Consultatie;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
public class Angajat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long angajatId;
//    @NotBlank()
    @Size(min = 2, max = 32)
    private String numeAngajat;
    private String prenumeAngajat;
    private String numarTelefon;
    private String email;
    private int salariu;
    private Long functieId;
    private Long sectieId;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "angajatId", referencedColumnName = "angajatId")
    private Set<Consultatie> consultatie;

    public Angajat() {
    }

    public Angajat(String numeAngajat, String prenumeAngajat, String numarTelefon,
                   String email, int salariu, Long functieId, Long sectieId) {
        this.numeAngajat = numeAngajat;
        this.prenumeAngajat = prenumeAngajat;
        this.numarTelefon = numarTelefon;
        this.email = email;
        this.salariu = salariu;
        this.functieId = functieId;
        this.sectieId = sectieId;
    }

    public String getNumeAngajat() {
        return numeAngajat;
    }

    public void setNumeAngajat(String numeAngajat) {
        this.numeAngajat = numeAngajat;
    }

    public String getPrenumeAngajat() {
        return prenumeAngajat;
    }

    public void setPrenumeAngajat(String prenumeAngajat) {
        this.prenumeAngajat = prenumeAngajat;
    }

    public String getNumarTelefon() {
        return numarTelefon;
    }

    public void setNumarTelefon(String numarTelefon) {
        this.numarTelefon = numarTelefon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getSalariu() {
        return salariu;
    }

    public void setSalariu(int salariu) {
        this.salariu = salariu;
    }

    public Long getFunctieId() {
        return functieId;
    }

    public void setFunctieId(Long functieId) {
        this.functieId = functieId;
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
}
