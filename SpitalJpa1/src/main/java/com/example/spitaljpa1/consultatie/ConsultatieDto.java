package com.example.spitaljpa1.consultatie;

public class ConsultatieDto {
    private Long sectieId;
    private Long angajatId;
    private Long pacientId;

    public ConsultatieDto() {
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
