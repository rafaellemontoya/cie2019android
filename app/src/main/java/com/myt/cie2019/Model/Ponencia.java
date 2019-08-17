package com.myt.cie2019.Model;

import com.google.firebase.Timestamp;

import java.util.Date;

public class Ponencia {
    private String nombrePonente, nombrePonencia, sala,id;
    private Timestamp fechaPonencia;

    public Ponencia() {
    }

    public Ponencia(String nombrePonente, String nombrePonencia, String sala, Timestamp fechaPonencia, String id) {
        this.nombrePonente = nombrePonente;
        this.nombrePonencia = nombrePonencia;
        this.sala = sala;
        this.fechaPonencia = fechaPonencia;
        this.id = id;

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Timestamp getFechaPonencia() {
        return fechaPonencia;
    }

    public void setFechaPonencia(Timestamp fechaPonencia) {
        this.fechaPonencia = fechaPonencia;
    }
}
