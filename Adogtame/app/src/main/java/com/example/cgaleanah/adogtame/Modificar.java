package com.example.cgaleanah.adogtame;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Modificar extends AppCompatActivity {

    private InterfazBD iBD;
    private String usuario;
    private String prev;
    private EditText nombre, contra1, contra2, telefono, direccion;

    //private String createUsuarios = "create table if not exists usuarios(usuario text primary key, contra text, nombre text, telefono text, direccion text)";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar);

        Bundle bundle = this.getIntent().getExtras();
        usuario = bundle.get("usuario").toString();

        nombre = (EditText) findViewById(R.id.etNombre);
        contra1 = (EditText) findViewById(R.id.etContra1);
        contra2 = (EditText) findViewById(R.id.etContra2);
        telefono = (EditText) findViewById(R.id.etTelefono);
        direccion = (EditText) findViewById(R.id.etDireccion);
    }

    public void modificar(View v){
        String n, c, t, d;
        iBD = new 
    }
}
