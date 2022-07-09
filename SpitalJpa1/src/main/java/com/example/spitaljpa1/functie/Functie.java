package com.example.spitaljpa1.functie;

import com.example.spitaljpa1.angajat.Angajat;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Functie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long functieId;
    private String numeFunctie;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="functieId", referencedColumnName="functieId")
    private Set<Angajat> angajati;

    public Functie() {
    }

    public Functie(String numeFunctie) {
        this.numeFunctie = numeFunctie;
    }

    public Long getFunctieId() {
        return functieId;
    }

    public String getNumeFunctie() {
        return numeFunctie;
    }

    public void setNumeFunctie(String numeFunctie) {
        this.numeFunctie = numeFunctie;
    }
}
