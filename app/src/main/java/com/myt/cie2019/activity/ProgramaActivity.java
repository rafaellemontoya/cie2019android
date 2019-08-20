package com.myt.cie2019.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.myt.cie2019.Adapters.PoneneciasMagistralesAdapter;
import com.myt.cie2019.Adapters.ProgramaDiaSeleccionadoAdapter;
import com.myt.cie2019.Interfaces.IfFirebaseLoadDone;
import com.myt.cie2019.Model.Fecha;
import com.myt.cie2019.Model.Ponencia;
import com.myt.cie2019.Model.PonenciaMagistral;
import com.myt.cie2019.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Nullable;

import static com.myt.cie2019.R.color.jueves;
import static com.myt.cie2019.R.color.lunes;
import static com.myt.cie2019.R.color.martes;
import static com.myt.cie2019.R.color.miercoles;
import static com.myt.cie2019.R.color.viernes;

public class ProgramaActivity  extends AppCompatActivity implements IfFirebaseLoadDone {

    Fecha diaSeleccionado;
    TextView diaSeleccionadoTV;
    ListView lista;
    ProgramaDiaSeleccionadoAdapter adapter;
    ArrayList<Ponencia> alInfo ;
    LinearLayout layoutTituloDiaSeleccionado;
    Date dateInicio, dateFin;

    String datetoSavedInicio ;
    String datetoSavedFin;
    int colorLetra;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_programa);

        diaSeleccionado = (Fecha) getIntent().getExtras().getSerializable("diaSeleccionado");
        //UI
        diaSeleccionadoTV = findViewById(R.id.dia_seleccionado_tv);
        diaSeleccionadoTV.setText(diaSeleccionado.getNombreFecha());
        layoutTituloDiaSeleccionado=findViewById(R.id.layout_color_dia_seleccionado);
        colorLetra = R.color.negro;

        switch (diaSeleccionado.getId()){
            case 1:
                layoutTituloDiaSeleccionado.setBackgroundResource(R.drawable.background_lunes);
                datetoSavedInicio = "2019-09-09T00:00:00Z";
                datetoSavedFin = "2019-09-09T23:59:50Z";
                colorLetra = lunes;
                break;
            case 2:
                layoutTituloDiaSeleccionado.setBackgroundResource(R.drawable.background_martes);
                datetoSavedInicio = "2019-09-10T00:00:00Z";
                datetoSavedFin = "2019-09-10T23:59:50Z";
                colorLetra = martes;
                break;
            case 3:
                layoutTituloDiaSeleccionado.setBackgroundResource(R.drawable.background_miercoles);
                datetoSavedInicio = "2019-09-11T00:00:00Z";
                datetoSavedFin = "2019-09-11T23:59:50Z";
                colorLetra = miercoles;
                break;
            case 4:
                layoutTituloDiaSeleccionado.setBackgroundResource(R.drawable.background_jueves);
                datetoSavedInicio = "2019-09-12T00:00:00Z";
                datetoSavedFin = "2019-09-12T23:59:50Z";
                colorLetra = jueves;
                break;
            case 5:
                layoutTituloDiaSeleccionado.setBackgroundResource(R.drawable.background_viernes);
                datetoSavedInicio = "2019-09-13T00:00:00Z";
                datetoSavedFin = "2019-09-13T23:59:50Z";
                colorLetra = viernes;
                break;

        }



        lista = findViewById(R.id.contenido_dia_seleccionado);
        //Lleno la informacion de base de datos
        alInfo = new ArrayList();

        adapter = new ProgramaDiaSeleccionadoAdapter(getApplicationContext(), alInfo, colorLetra);
        lista.setAdapter(adapter);


         SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");

        try {
            dateInicio = format.parse(datetoSavedInicio);
            dateFin = format.parse(datetoSavedFin);

        } catch (ParseException e) {
            e.printStackTrace();
        }

//Init DB
        FirebaseFirestore db = FirebaseFirestore.getInstance();





        db.collection("programa")
                .orderBy("fecha").startAt(dateInicio).endAt(dateFin)
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
                        if (e != null) {
                            System.err.println("Listen failed:" + e);
                            return;
                        }


                        for (DocumentSnapshot document : queryDocumentSnapshots) {
                            Ponencia ponencia = new Ponencia();
                            if (document.get("nombrePonente") != null) {

                                alInfo.add(new Ponencia(document.getString("nombrePonente"),
                                        document.getString("nombrePonencia"),
                                        document.getString("sala"),
                                        document.getTimestamp("fecha"),
                                        document.getString("ponenciaid")));
                            }else{
                                ponencia.setNombrePonencia(document.getString("nombrePonencia"));
                                ponencia.setNombrePonente("");
                                ponencia.setFechaPonencia(document.getTimestamp("fechaPonencia"));
                                ponencia.setSala("");
                                alInfo.add(ponencia);
                            }

                        }

                        onFirebaseLoadSuccess();
                        // [START_EXCLUDE silent]

                        // [END_EXCLUDE]
                    }


                        // [END_EXCLUDE]

                });



    }

    @Override
    public void onFirebaseLoadSuccess() {
        adapter.notifyDataSetChanged();
    }
}
