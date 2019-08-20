package com.myt.cie2019.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
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

        Button botonLibroResumenes = rootView.findViewById(R.id.descargar_libro_resumenes);

        botonLibroResumenes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://amexen.org/iec/2019/docs/libro_resumenes_cie19.pdf");
                Intent intentayuda = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intentayuda);
            }
        });
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


        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Uri uri = Uri.parse(alInfo.get(i).getLink());
                Intent intentayuda = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intentayuda);
            }
        });
        lista.setAdapter(adapter);
        return rootView;
    }

    @Override
    public void onFirebaseLoadSuccess() {
        adapter.notifyDataSetChanged();
    }
}
