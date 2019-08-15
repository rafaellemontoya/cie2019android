package com.myt.cie2019.Model;

public class PonenciaMagistral {
    private String nombrePonencia, nombrePonente, foto;

    public PonenciaMagistral() {
    }

    public PonenciaMagistral(String nombrePonencia, String nombrePonente, String foto) {
        this.nombrePonencia = nombrePonencia;
        this.nombrePonente = nombrePonente;
        this.foto = foto;
    }

    public String getNombrePonencia() {
        return nombrePonencia;
    }

    public void setNombrePonencia(String nombrePonencia) {
        this.nombrePonencia = nombrePonencia;
    }

    public String getNombrePonente() {
        return nombrePonente;
    }

    public void setNombrePonente(String nombrePonente) {
        this.nombrePonente = nombrePonente;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
