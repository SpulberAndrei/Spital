package com.example.spitaljpa1.sectie;

import com.example.spitaljpa1.angajat.Angajat;
import com.example.spitaljpa1.consultatie.Consultatie;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Sectie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sectieId;

    @OneToMany(cascade= CascadeType.ALL)
    @JoinColumn(name="sectieId", referencedColumnName="sectieId")
    private Set<Angajat> angajati;

    private String numeSectie;
    private String locDisponibil;
    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="sectieId", referencedColumnName="sectieId")
    private Set<Consultatie> consultatie;

    public Sectie() {
    }

    public Sectie(String numeSectie, String locDisponibil) {
        this.numeSectie = numeSectie;
        this.locDisponibil = locDisponibil;
    }

    public Long getSectieId() {
        return sectieId;
    }

    public String getNumeSectie() {
        return numeSectie;
    }

    public void setNumeSectie(String numeSectie) {
        this.numeSectie = numeSectie;
    }

    public String getLocDisponibil() {
        return locDisponibil;
    }

    public void setLocDisponibil(String locDisponibil) {
        this.locDisponibil = locDisponibil;
    }
}
