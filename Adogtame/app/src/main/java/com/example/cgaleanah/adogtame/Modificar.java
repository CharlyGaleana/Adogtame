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

        iBD = new InterfazBD(this);
        nombre = (EditText) findViewById(R.id.etNombre);
        contra1 = (EditText) findViewById(R.id.etContra1);
        contra2 = (EditText) findViewById(R.id.etContra2);
        telefono = (EditText) findViewById(R.id.etTelefono);
        direccion = (EditText) findViewById(R.id.etDireccion);
    }

    public void modificar(View v){
        String n, c1, c2, t, d;

        n = nombre.getText().toString();
        c1 = contra1.getText().toString();
        c2 = contra2.getText().toString();
        t = telefono.getText().toString();
        d = direccion.getText().toString();

        if(!n.equals("")) //si se modificó este campo, modifica la informacion en la base de datos
            iBD.modificaUsuario("nombre", usuario, n);

        if(!c1.equals("") && c1.equals(c2))
            iBD.modificaUsuario("contra", usuario, c1);

        if(!t.equals(""))
            iBD.modificaUsuario("telefono", usuario, t);

        if(!d.equals(""))
            iBD.modificaUsuario("direccion", usuario, d);

        Toast.makeText(this, "Tus datos fueron modificados", Toast.LENGTH_LONG).show();

    }
}
