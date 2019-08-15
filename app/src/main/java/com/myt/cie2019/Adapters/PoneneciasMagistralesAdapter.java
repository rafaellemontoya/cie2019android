package com.myt.cie2019.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.myt.cie2019.Model.PonenciaMagistral;
import com.myt.cie2019.R;

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

        Glide.with(context).load(datos.get(position).getFoto()).into(imagen);

        Glide.with(context)
                .load("https://i2.wp.com/www.siasat.com/wp-content/uploads/2018/03/Rosamund-Pike.jpeg?fit=600%2C421&ssl=1")
                .into(imagen);

        TextView fechaConferencia = (TextView) item.findViewById(R.id.fecha);
        fechaConferencia.setText(datos.get(position).getFoto());
        TextView nombreConferencia = (TextView) item.findViewById(R.id.nombre_conferencia);
        nombreConferencia.setText(datos.get(position).getNombrePonencia());
        TextView nombrePonente = (TextView) item.findViewById(R.id.nombre_ponente);
        nombrePonente.setText(datos.get(position).getNombrePonente());

        return item;

    }
}