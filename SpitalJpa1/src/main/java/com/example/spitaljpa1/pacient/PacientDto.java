package com.example.spitaljpa1.pacient;

public class PacientDto {
    private String numePacient;
    private String prenumePacient;
    private Long varsta;
    private char sex;
    private String numarTelefon;

    public PacientDto() {
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
}
