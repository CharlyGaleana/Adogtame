package com.example.cgaleanah.adogtame;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class Adoptar extends AppCompatActivity {

    private String usuario;
    private EditText raza, edad, sexo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adoptar);

        Bundle bundle = getIntent().getExtras();
        usuario = bundle.get("usuario").toString();

        raza = (EditText) findViewById(R.id.etRaza);
        edad = (EditText) findViewById(R.id.etEdad);
        sexo = (EditText) findViewById(R.id.etSexo);

        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        Fragment f1 = new FragmentoLista(usuario, sexo.getText().toString(), raza.getText().toString(), edad.getText().toString());
        ft.add(R.id.actividadPrincipal, f1);
        ft.commit();


    }
}
