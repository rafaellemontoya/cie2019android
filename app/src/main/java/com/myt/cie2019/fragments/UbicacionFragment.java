package com.myt.cie2019.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.maps.MapView;
import com.myt.cie2019.R;

import java.util.ArrayList;

public class UbicacionFragment extends Fragment {



    View rootView;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        rootView =  inflater.inflate(R.layout.fragment_ubicacion, container, false);

        Button btn = rootView.findViewById(R.id.btn_liga);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://www.google.com/maps/place/Centro+Cultural+Universitario/@19.7028126,-101.1970569,17z/data=!3m1!4b1!4m5!3m4!1s0x842ef371b4fd077d:0x27434b495acac0ad!8m2!3d19.7028126!4d-101.1948682");
                Intent intentayuda = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intentayuda);
            }
        });
        return rootView;
    }
}
