package com.myt.cie2019.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.myt.cie2019.Adapters.PoneneciasMagistralesAdapter;
import com.myt.cie2019.Model.PonenciaMagistral;
import com.myt.cie2019.R;

import java.util.ArrayList;

public class PonenciasMagistralesFragment extends Fragment {

    View rootView;
    ListView lista;
    PoneneciasMagistralesAdapter adapter;
    ArrayList<PonenciaMagistral> alInfo ;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        rootView = inflater.inflate(R.layout.fragment_ponencias_magistrales
                , container, false);

        lista = rootView.findViewById(R.id.lista_ponentes);

        //Lleno la informacion de base de datos
        alInfo = new ArrayList();

        alInfo.add(new PonenciaMagistral("Recent developments in Linear concentration for CSP plants with storage", "Dr. Manuel Pedro Ivens Collares-Pereira", "Miércoles 11, 9:00-10:00"));
        alInfo.add(new PonenciaMagistral("Los Retos a mediano y largo plazo de las Energías Limpias, Energía Hidroeléctrica", "Dr. Humberto Marengo Mogollón", "Miércoles 11, 10:00-11:00"));
        alInfo.add(new PonenciaMagistral("Towards the development of new materials, novel process designs and optimal operation for Chemical Looping Combustion: A Process Systems Engineering Perspective", "Dr. Luis Ricardez-Sandoval", "Jueves 12, 9:00- 10:00"));
        alInfo.add(new PonenciaMagistral("Modelos de planeación", "Dra. Cecilia Martín del Campo Márquez", "Jueves 12, 10:00- 11:00"));
        alInfo.add(new PonenciaMagistral("ALMACENAMIENTO DE ENERGÍA: DISEÑO, CONSTRUCCIÓN Y ENSAMBLAJE DE BATERÍAS DE IONES ALCALINOS", "Dr. Ignacio González Martínez", "Viernes 13, 9:00- 10:00"));
        alInfo.add(new PonenciaMagistral("PANORAMA DE APLICACIONES DE LA ENERGÍA SOLAR CONCENTRADA", "Dr. Camilo Arancibia Bulnes", "Viernes 13, 10:00- 11:00"));
        alInfo.add(new PonenciaMagistral("", "", ""));

        adapter = new PoneneciasMagistralesAdapter(rootView.getContext(), alInfo);
        lista.setAdapter(adapter);
        return rootView;
    }
}
