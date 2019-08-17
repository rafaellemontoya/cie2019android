package com.myt.cie2019.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.myt.cie2019.Adapters.PatrocinadoresAdapter;
import com.myt.cie2019.Adapters.PoneneciasMagistralesAdapter;
import com.myt.cie2019.Interfaces.IfFirebaseLoadDone;
import com.myt.cie2019.Model.Patrocinador;
import com.myt.cie2019.Model.PonenciaMagistral;
import com.myt.cie2019.R;

import java.util.ArrayList;

public class PatrocinadoresFragment extends Fragment implements IfFirebaseLoadDone {
    View rootView;
    ListView lista;
    PatrocinadoresAdapter adapter;
    ArrayList<Patrocinador> alInfo ;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_patrocinadores
                , container, false);

        lista = rootView.findViewById(R.id.lista_patrocinadores);

        //Lleno la informacion de base de datos
        alInfo = new ArrayList();
        //Init DB
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        db.collection("patrocinadores")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {

                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d("hola2", document.getId() + " => " + document.getData());

                                alInfo.add(new Patrocinador(document.getString("nombre"), document.getString("logo"), document.getString("ligapagina")));
                            }
                            onFirebaseLoadSuccess();
                        } else {
                            Log.w("ERROR", "Error getting documents.", task.getException());
                        }
                    }
                });

        adapter = new PatrocinadoresAdapter(rootView.getContext(), alInfo);
        lista.setAdapter(adapter);
        return rootView;
    }

    @Override
    public void onFirebaseLoadSuccess() {
        adapter.notifyDataSetChanged();
    }
}
