package com.myt.cie2019.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

import com.myt.cie2019.Adapters.PoneneciasMagistralesAdapter;
import com.myt.cie2019.Adapters.ProgramaDiaSeleccionadoAdapter;
import com.myt.cie2019.Model.Fecha;
import com.myt.cie2019.Model.Ponencia;
import com.myt.cie2019.Model.PonenciaMagistral;
import com.myt.cie2019.R;

import java.util.ArrayList;
import java.util.Date;

public class ProgramaActivity  extends AppCompatActivity {

    Fecha diaSeleccionado;
    TextView diaSeleccionadoTV;
    ListView lista;
    ProgramaDiaSeleccionadoAdapter adapter;
    ArrayList<Ponencia> alInfo ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programa);

        diaSeleccionado = (Fecha) getIntent().getExtras().getSerializable("diaSeleccionado");
        //UI
        diaSeleccionadoTV = findViewById(R.id.dia_seleccionado_tv);
        diaSeleccionadoTV.setText(diaSeleccionado.getNombreFecha());

        lista = findViewById(R.id.contenido_dia_seleccionado);
        //Lleno la informacion de base de datos
        alInfo = new ArrayList();

        alInfo.add(new Ponencia("Dr. Camilo Arancibia", "Concentradores solares", "Sala 1", new Date(2019, 10,9),new Date(2019, 10,9)));
        alInfo.add(new Ponencia("Dr. Julio César García Martínez", "Diseño de reactores", "Sala 5", new Date(2019, 10,9),new Date(2019, 10,9)));

        adapter = new ProgramaDiaSeleccionadoAdapter(getApplicationContext(), alInfo);
        lista.setAdapter(adapter);



    }
}
