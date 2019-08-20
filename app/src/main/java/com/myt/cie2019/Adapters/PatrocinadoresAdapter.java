package com.myt.cie2019.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.firestore.FirebaseFirestore;
import com.myt.cie2019.Model.Fecha;
import com.myt.cie2019.Model.Patrocinador;
import com.myt.cie2019.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PatrocinadoresAdapter extends ArrayAdapter {
    private Context context;
    private ArrayList<Patrocinador> datos;


    public PatrocinadoresAdapter(Context context, ArrayList datos){
        super(context, R.layout.renglon_patrocinadores, datos);

        this.context = context;
        this.datos = datos;
    }

    @Override
    public View getView (int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = LayoutInflater.from(context);
        View item = inflater.inflate(R.layout.renglon_patrocinadores,null);

        ImageView imagen = (ImageView) item.findViewById(R.id.imagen_patrocinador);



        Picasso.get().load(datos.get(position).getUrlFoto()).into(imagen);




        return item;

    }
}