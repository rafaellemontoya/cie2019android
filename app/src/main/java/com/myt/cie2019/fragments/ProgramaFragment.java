package com.myt.cie2019.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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
        rootView = inflater.inflate(R.layout.fragment_ponencias_magistrales
                , container, false);

        lista = rootView.findViewById(R.id.lista_ponentes);

        //Lleno la informacion de base de datos
        alInfo = new ArrayList();

        alInfo.add(new Fecha("Lunes", new Date(2019, 10,9),1));
        alInfo.add(new Fecha("Martes", new Date(2019, 10,10),2));
        alInfo.add(new Fecha("Miércoles", new Date(2019, 10,11),3));
        alInfo.add(new Fecha("Jueves", new Date(2019, 10,12),4));
        alInfo.add(new Fecha("Viernes", new Date(2019, 10,13),5));

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
