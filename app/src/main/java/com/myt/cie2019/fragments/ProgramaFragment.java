package com.myt.cie2019.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.myt.cie2019.Adapters.PoneneciasMagistralesAdapter;
import com.myt.cie2019.Adapters.ProgramaDiasAdapter;
import com.myt.cie2019.Model.Fecha;
import com.myt.cie2019.Model.PonenciaMagistral;
import com.myt.cie2019.R;
import com.myt.cie2019.activity.ProgramaActivity;

import java.util.ArrayList;
import java.util.Date;

public class ProgramaFragment extends Fragment {

    View rootView;
    ListView lista;
    ProgramaDiasAdapter adapter;
    ArrayList<Fecha> alInfo ;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_programa
                , container, false);

        Button botonDescarga = rootView.findViewById(R.id.descargar_programa);
        botonDescarga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://amexen.org/iec/2019/docs/programa_cie19.pdf");
                Intent intentayuda = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intentayuda);
            }
        });

        lista = rootView.findViewById(R.id.contenido);


        //Lleno la informacion de base de datos
        alInfo = new ArrayList();

        alInfo.add(new Fecha("Lunes \n 9 de septiembre", new Date(2019, 10,9),1));
        alInfo.add(new Fecha("Martes\n 10 de septiembre", new Date(2019, 10,10),2));
        alInfo.add(new Fecha("Miércoles\n 11 de septiembre", new Date(2019, 10,11),3));
        alInfo.add(new Fecha("Jueves\n 12 de septiembre", new Date(2019, 10,12),4));
        alInfo.add(new Fecha("Viernes\n 13 de septiembre", new Date(2019, 10,13),5));


        adapter = new ProgramaDiasAdapter(rootView.getContext(), alInfo);
        lista.setAdapter(adapter);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                alInfo.get(i);
                Intent intent = new Intent(getContext(), ProgramaActivity.class);
                intent.putExtra("diaSeleccionado", alInfo.get(i));
                startActivity(intent);


            }
        });

        return rootView;
    }
    private boolean loadFragment(Fragment fragment){
        if(fragment != null){
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
            return true;
        }else{
            return false;
        }
    }
}
