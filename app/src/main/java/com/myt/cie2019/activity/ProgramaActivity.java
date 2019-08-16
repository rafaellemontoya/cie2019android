package com.myt.cie2019.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
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

import static com.myt.cie2019.R.color.jueves;
import static com.myt.cie2019.R.color.lunes;
import static com.myt.cie2019.R.color.martes;
import static com.myt.cie2019.R.color.miercoles;
import static com.myt.cie2019.R.color.viernes;

public class ProgramaActivity  extends AppCompatActivity {

    Fecha diaSeleccionado;
    TextView diaSeleccionadoTV;
    ListView lista;
    ProgramaDiaSeleccionadoAdapter adapter;
    ArrayList<Ponencia> alInfo ;
    LinearLayout layoutTituloDiaSeleccionado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_programa);

        diaSeleccionado = (Fecha) getIntent().getExtras().getSerializable("diaSeleccionado");
        //UI
        diaSeleccionadoTV = findViewById(R.id.dia_seleccionado_tv);
        diaSeleccionadoTV.setText(diaSeleccionado.getNombreFecha());
        layoutTituloDiaSeleccionado=findViewById(R.id.layout_color_dia_seleccionado);
        switch (diaSeleccionado.getId()){
            case 1:
                layoutTituloDiaSeleccionado.setBackgroundResource(lunes);
                break;
            case 2:
                layoutTituloDiaSeleccionado.setBackgroundResource(martes);
                break;
            case 3:
                layoutTituloDiaSeleccionado.setBackgroundResource(miercoles);
                break;
            case 4:
                layoutTituloDiaSeleccionado.setBackgroundResource(jueves);
                break;
            case 5:
                layoutTituloDiaSeleccionado.setBackgroundResource(viernes);
                break;

        }



        lista = findViewById(R.id.contenido_dia_seleccionado);
        //Lleno la informacion de base de datos
        alInfo = new ArrayList();

        alInfo.add(new Ponencia("Dr. Camilo Arancibia", "Concentradores solares", "Sala 1", new Date(2019, 10,9),new Date(2019, 10,9)));
        alInfo.add(new Ponencia("Dr. Julio César García Martínez", "Diseño de reactores", "Sala 5", new Date(2019, 10,9),new Date(2019, 10,9)));

        adapter = new ProgramaDiaSeleccionadoAdapter(getApplicationContext(), alInfo, R.color.lunes);
        lista.setAdapter(adapter);



    }
}
