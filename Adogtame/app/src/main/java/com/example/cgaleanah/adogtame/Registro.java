package com.example.cgaleanah.adogtame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Registro extends AppCompatActivity {

    private InterfazBD iBD;
    private EditText usuario;
    private EditText contra1, contra2;
    private EditText nombre;
    private EditText tel;
    private EditText direccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        usuario = (EditText) findViewById(R.id.etUsuario);
        contra1 = (EditText) findViewById(R.id.etContra1);
        contra2 = (EditText) findViewById(R.id.etContra2);
        nombre = (EditText) findViewById(R.id.etNombre);
        tel = (EditText) findViewById(R.id.etTelefono);
        direccion = (EditText) findViewById(R.id.etDireccion);
    }

    public void agregarUsuario(View view) {
        String u = usuario.getText().toString();
        String c1 = contra1.getText().toString();
        String c2 = contra2.getText().toString();
        String n = nombre.getText().toString();
        String t = tel.getText().toString();
        String d = direccion.getText().toString();
        iBD = new InterfazBD(this);

        if(u != "" && c1 != "" && c2 != "" && n != "" && t != "" && d != ""){
            if(c1 == c2){

            } else Toast.makeText(this, "Las contraseñas no coinciden.", Toast.LENGTH_SHORT).show();
        } else Toast.makeText(this, "Asegurate de que todos los campos esten llenos.", Toast.LENGTH_SHORT).show();
    }
}
