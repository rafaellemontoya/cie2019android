package com.myt.cie2019.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.view.MenuItem;
import android.widget.TextView;

import com.myt.cie2019.R;
import com.myt.cie2019.fragments.InicioFragment;
import com.myt.cie2019.fragments.PatrocinadoresFragment;
import com.myt.cie2019.fragments.PonenciasMagistralesFragment;
import com.myt.cie2019.fragments.ProgramaFragment;
import com.myt.cie2019.fragments.UbicacionFragment;

public class MainActivity extends AppCompatActivity {
    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    loadFragment(new InicioFragment());
                    return true;
                case R.id.navigation_programa:
                    loadFragment(new ProgramaFragment());
                    return true;
                case R.id.navigation_magistrales:
                    loadFragment(new PonenciasMagistralesFragment());
                    return true;
                case R.id.navigation_patrocinadores:
                    loadFragment(new PatrocinadoresFragment());
                    return true;
                case R.id.navigation_ubicacion:
                    loadFragment(new UbicacionFragment());
                    return true;
            }
            return false;
        }
    };

    private boolean loadFragment(Fragment fragment){
        if(fragment != null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
            return true;
        }else{
            return false;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        //mTextMessage = findViewById(R.id.message);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        loadFragment(new InicioFragment());
    }

}
