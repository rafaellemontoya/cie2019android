package com.myt.cie2019.Model;

import java.io.Serializable;
import java.util.Date;

public class Fecha implements Serializable {
    private String nombreFecha;
    private Date fecha;
    private int id;

    public Fecha(String nombreFecha, Date fecha, int id) {
        this.nombreFecha = nombreFecha;
        this.fecha = fecha;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreFecha() {
        return nombreFecha;
    }

    public void setNombreFecha(String nombreFecha) {
        this.nombreFecha = nombreFecha;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
