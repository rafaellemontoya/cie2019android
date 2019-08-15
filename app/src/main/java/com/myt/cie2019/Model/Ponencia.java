package com.myt.cie2019.Model;

import java.util.Date;

public class Ponencia {
    private String nombrePonente, nombrePonencia, sala;
    private Date fechaPonencia, horaPonencia;

    public Ponencia(String nombrePonente, String nombrePonencia, String sala, Date fechaPonencia, Date horaPonencia) {
        this.nombrePonente = nombrePonente;
        this.nombrePonencia = nombrePonencia;
        this.sala = sala;
        this.fechaPonencia = fechaPonencia;
        this.horaPonencia = horaPonencia;
    }

    public String getNombrePonente() {
        return nombrePonente;
    }

    public void setNombrePonente(String nombrePonente) {
        this.nombrePonente = nombrePonente;
    }

    public String getNombrePonencia() {
        return nombrePonencia;
    }

    public void setNombrePonencia(String nombrePonencia) {
        this.nombrePonencia = nombrePonencia;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public Date getFechaPonencia() {
        return fechaPonencia;
    }

    public void setFechaPonencia(Date fechaPonencia) {
        this.fechaPonencia = fechaPonencia;
    }

    public Date getHoraPonencia() {
        return horaPonencia;
    }

    public void setHoraPonencia(Date horaPonencia) {
        this.horaPonencia = horaPonencia;
    }
}
