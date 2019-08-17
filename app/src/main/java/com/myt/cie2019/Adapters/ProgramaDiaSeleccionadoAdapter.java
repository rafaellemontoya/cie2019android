package com.myt.cie2019.Adapters;

import android.content.Context;

import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import android.widget.TextView;
import com.myt.cie2019.Model.Ponencia;
import com.myt.cie2019.R;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class ProgramaDiaSeleccionadoAdapter extends ArrayAdapter {
    private Context context;
    private ArrayList<Ponencia> datos;
    private int colorTitulo;


    public ProgramaDiaSeleccionadoAdapter(Context context, ArrayList datos, int color){
        super(context, R.layout.renglon_dia_seleccionado, datos);
    this.colorTitulo = color;
        this.context = context;
        this.datos = datos;
    }

    @Override
    public View getView (int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = LayoutInflater.from(context);
        View item = inflater.inflate(R.layout.renglon_dia_seleccionado,null);


        Date date = datos.get(position).getFechaPonencia().toDate();
        SimpleDateFormat dateFormat = new SimpleDateFormat("h:mm ");
        String creationDate = dateFormat.format(date);


        TextView horaConferencia = (TextView) item.findViewById(R.id.hora_ponencia);
        horaConferencia.setText(creationDate);
        TextView nombreConferencia = (TextView) item.findViewById(R.id.nombre_conferencia_dia);
        nombreConferencia.setTextColor(ContextCompat.getColor(context, colorTitulo));
        nombreConferencia.setText(datos.get(position).getNombrePonencia());
        TextView nombrePonente = (TextView) item.findViewById(R.id.nombre_ponente_dia);
        nombrePonente.setText(datos.get(position).getNombrePonente());
        TextView sala = (TextView) item.findViewById(R.id.sala_dia);
        sala.setText(datos.get(position).getSala());


        return item;

    }

}