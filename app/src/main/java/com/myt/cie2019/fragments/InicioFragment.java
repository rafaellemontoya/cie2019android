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
import com.myt.cie2019.Adapters.InicioAdapter;
import com.myt.cie2019.Adapters.PatrocinadoresAdapter;
import com.myt.cie2019.Interfaces.IfFirebaseLoadDone;
import com.myt.cie2019.Model.Aviso;
import com.myt.cie2019.Model.Patrocinador;
import com.myt.cie2019.R;

import java.util.ArrayList;

public class InicioFragment extends Fragment  implements IfFirebaseLoadDone {
    View rootView;
    ListView lista;
    InicioAdapter adapter;
    ArrayList<Aviso> alInfo ;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_inicio
                , container, false);

        lista = rootView.findViewById(R.id.lista_inicio);

        //Lleno la informacion de base de datos
        alInfo = new ArrayList();
        //Init DB
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        db.collection("inicio")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {

                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d("hola2", document.getId() + " => " + document.getData());

                                alInfo.add(new Aviso(document.getString("color"),
                                        document.getString("contenido"),
                                        document.getString("link"),
                                        document.getString("titulo"),
                                        Integer.valueOf(document.getLong("estado").intValue())));
                            }
                            onFirebaseLoadSuccess();
                        } else {
                            Log.w("ERROR", "Error getting documents.", task.getException());
                        }
                    }
                });

        adapter = new InicioAdapter(rootView.getContext(), alInfo);
        lista.setAdapter(adapter);
        return rootView;
    }

    @Override
    public void onFirebaseLoadSuccess() {
        adapter.notifyDataSetChanged();
    }
}
