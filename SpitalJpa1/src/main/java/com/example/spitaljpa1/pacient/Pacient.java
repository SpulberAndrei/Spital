package com.example.spitaljpa1.pacient;

import com.example.spitaljpa1.consultatie.Consultatie;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Pacient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pacientId;
    private String numePacient;
    private String prenumePacient;
    private Long varsta;
    private char sex;
    private String numarTelefon;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "pacientId", referencedColumnName = "pacientId")
    private Set<Consultatie> consultatie;

    public Pacient() {
    }

    public Pacient(String numePacient, String prenumePacient, Long varsta, Long pacientVarsta, char sex, String numarTelefon) {
    }

    public Pacient(String numePacient, String prenumePacient, Long varsta, char sex, String numarTelefon) {
        this.numePacient = numePacient;
        this.prenumePacient = prenumePacient;
        this.varsta = varsta;
        this.sex = sex;
        this.numarTelefon = numarTelefon;
    }

    public String getNumePacient() {
        return numePacient;
    }

    public void setNumePacient(String numePacient) {
        this.numePacient = numePacient;
    }

    public String getPrenumePacient() {
        return prenumePacient;
    }

    public void setPrenumePacient(String prenumePacient) {
        this.prenumePacient = prenumePacient;
    }

    public Long getVarsta() {
        return varsta;
    }

    public void setVarsta(Long varsta) {
        this.varsta = varsta;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getNumarTelefon() {
        return numarTelefon;
    }

    public void setNumarTelefon(String numarTelefon) {
        this.numarTelefon = numarTelefon;
    }

    public Long getPacientId() {
        return pacientId;
    }
}
