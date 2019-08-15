package com.myt.cie2019.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.myt.cie2019.Model.Fecha;
import com.myt.cie2019.Model.PonenciaMagistral;
import com.myt.cie2019.R;

import java.util.ArrayList;

public class ProgramaDiasAdapter extends ArrayAdapter {
    private Context context;
    private ArrayList<Fecha> datos;

    public ProgramaDiasAdapter(Context context, ArrayList datos){
        super(context, R.layout.renglon_programa_dias, datos);

        this.context = context;
        this.datos = datos;
    }

    @Override
    public View getView (int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = LayoutInflater.from(context);
        View item = inflater.inflate(R.layout.renglon_programa_dias,null);

        if(position == 0){

            item.setBackgroundResource(R.color.azul_academia);
        }else if(position == 1){

            item.setBackgroundResource(R.color.verde_academia);
        }else if(position == 2){

            item.setBackgroundResource(R.color.azul_academia);
        }else if(position == 3){

            item.setBackgroundResource(R.color.verde_academia);
        }else if(position == 4){

            item.setBackgroundResource(R.color.azul_academia);
        }

        TextView nombreConferencia = (TextView) item.findViewById(R.id.nombre_dia_tv);
        nombreConferencia.setText(datos.get(position).getNombreFecha());


        return item;

    }
}