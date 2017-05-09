package com.example.cgaleanah.adogtame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AgregarPerro extends AppCompatActivity {

    private InterfazBD iBD;
    private String usuario;
    private EditText nombre, raza, edad, sexo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_perro);

        Bundle bundle = this.getIntent().getExtras();
        usuario = bundle.get("usuario").toString();
        nombre = (EditText) findViewById(R.id.etNombre);
        raza = (EditText) findViewById(R.id.etRaza);
        sexo = (EditText) findViewById(R.id.etSexo);
        edad = (EditText) findViewById(R.id.etEdad);
        iBD = new InterfazBD(this);
    }

    //private String createPerros = "create table if not exists perros(_id integer primary key autoincrement, string owner, nombre text, sexo text, raza text, edad integer)";
    public void agregarPerro(View v){
        String o, n, s, r, e;
        o = usuario;
        n = nombre.getText().toString();
        s = sexo.getText().toString();
        r = raza.getText().toString();
        e = edad.getText().toString();

        iBD.insertaPerro(n, o, s, r, e);
        Toast.makeText(this, "Se agregó el perro a la base de datos.", Toast.LENGTH_SHORT).show();
    }

}
