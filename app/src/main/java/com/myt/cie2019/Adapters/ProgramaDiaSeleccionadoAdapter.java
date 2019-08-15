package com.myt.cie2019.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.myt.cie2019.Model.Ponencia;
import com.myt.cie2019.Model.PonenciaMagistral;
import com.myt.cie2019.R;

import java.util.ArrayList;

import static com.myt.cie2019.R.drawable.lunes;

public class ProgramaDiaSeleccionadoAdapter extends ArrayAdapter {
    private Context context;
    private ArrayList<Ponencia> datos;


    public ProgramaDiaSeleccionadoAdapter(Context context, ArrayList datos){
        super(context, R.layout.renglon_dia_seleccionado, datos);

        this.context = context;
        this.datos = datos;
    }

    @Override
    public View getView (int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = LayoutInflater.from(context);
        View item = inflater.inflate(R.layout.renglon_dia_seleccionado,null);



        TextView horaConferencia = (TextView) item.findViewById(R.id.hora_ponencia);
        horaConferencia.setText("09:00-10:00");
        TextView nombreConferencia = (TextView) item.findViewById(R.id.nombre_conferencia_dia);
        nombreConferencia.setText(datos.get(position).getNombrePonencia());
        TextView nombrePonente = (TextView) item.findViewById(R.id.nombre_ponente_dia);
        nombrePonente.setText(datos.get(position).getNombrePonente());
        TextView sala = (TextView) item.findViewById(R.id.sala_dia);
        sala.setText(datos.get(position).getSala());

        return item;

    }
}