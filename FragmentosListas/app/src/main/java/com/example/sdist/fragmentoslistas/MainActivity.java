package com.example.sdist.fragmentoslistas;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fm= getFragmentManager();
        FragmentTransaction ft= fm.beginTransaction();

        Fragment f1 = new FragmentoLista();
        ft.add(R.id.actividadPrincipal, f1);
        ft.commit();

        Fragment f2= new BlankFragment();
        ft= fm.beginTransaction();
        ft.add(R.id.fragmento_agregar, f2);
        ft.commit();

    }
}
