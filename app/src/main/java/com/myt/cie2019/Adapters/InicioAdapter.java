package com.myt.cie2019.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.myt.cie2019.Model.Aviso;
import com.myt.cie2019.Model.Patrocinador;
import com.myt.cie2019.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import static android.graphics.Color.parseColor;

public class InicioAdapter  extends ArrayAdapter {
    private Context context;
    private ArrayList<Aviso> datos;
    private String color;


    public InicioAdapter(Context context, ArrayList datos){
        super(context, R.layout.renglon_inicio, datos);

        this.context = context;
        this.datos = datos;

    }

    @Override
    public View getView (int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = LayoutInflater.from(context);
        View item = inflater.inflate(R.layout.renglon_inicio,null);

        LinearLayout layout = item.findViewById(R.id.fondo_inicio);
        layout.setBackgroundColor(Color.parseColor ( datos.get(position).getColor()));


        TextView titulo = (TextView) item.findViewById(R.id.titulo_inicio);
        titulo.setText(datos.get(position).getTitulo());

        TextView contenido = (TextView) item.findViewById(R.id.contenido_inicio);
        contenido.setText(datos.get(position).getContenido());


        return item;

    }
}