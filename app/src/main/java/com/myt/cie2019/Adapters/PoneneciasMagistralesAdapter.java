package com.myt.cie2019.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.myt.cie2019.Model.PonenciaMagistral;
import com.myt.cie2019.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PoneneciasMagistralesAdapter extends ArrayAdapter {
    private Context context;
    private ArrayList<PonenciaMagistral> datos;

    public PoneneciasMagistralesAdapter(Context context, ArrayList datos){
        super(context, R.layout.renglon_lista_magistrales, datos);

        this.context = context;
        this.datos = datos;
    }

    @Override
    public View getView (int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = LayoutInflater.from(context);
        View item = inflater.inflate(R.layout.renglon_lista_magistrales,null);

        ImageView imagen = (ImageView) item.findViewById(R.id.imagen_ponente);



        Picasso.get().load(datos.get(position).getFoto()).into(imagen);


        TextView fechaConferencia = (TextView) item.findViewById(R.id.fecha);
        fechaConferencia.setText(datos.get(position).getFecha());
        TextView nombreConferencia = (TextView) item.findViewById(R.id.nombre_ponente);
        nombreConferencia.setText(datos.get(position).getNombrePonencia());

        TextView nombrePonente = (TextView) item.findViewById(R.id.nombre_conferencia);
        nombrePonente.setText(datos.get(position).getNombrePonente());

        TextView sala = (TextView) item.findViewById(R.id.sala_magistral);
        sala.setText(datos.get(position).getSala());

        return item;

    }
}