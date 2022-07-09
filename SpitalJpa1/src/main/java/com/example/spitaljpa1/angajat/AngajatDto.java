package com.example.spitaljpa1.angajat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class AngajatDto {
//    @NotBlank()
    @Size(min = 2, max = 32, message = "Name must be between 2 and 32 characters long")
    private String numeAngajat;
    private String prenumeAngajat;
    private String numarTelefon;
    private String email;
    private int salariu;
    private Long functieId;
    private Long sectieId;

    public AngajatDto() {
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
}