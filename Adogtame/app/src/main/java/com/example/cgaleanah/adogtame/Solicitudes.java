package com.example.cgaleanah.adogtame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Solicitudes extends AppCompatActivity {

    private EditText ID;
    private InterfazBD iBD = new InterfazBD(this);
    private String usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitudes);

        Bundle bundle = this.getIntent().getExtras();
        usuario = bundle.get("usuario").toString();
        ID = (EditText) findViewById(R.id.etID);
    }

    public void confirmar(View v){
        String id = ID.getText().toString();
        if(!id.equals("")){
            if(iBD.miSolicitud(usuario, id)) {
                iBD.eliminaSolicitud(id);
                Toast.makeText(this, "La solicitud ha sido aceptada!!", Toast.LENGTH_SHORT).show();
            }else
                Toast.makeText(this, "Asegúrate de que el id que ingresaste aparezca en tu lista de solicitudes.", Toast.LENGTH_SHORT).show();
        } else
            Toast.makeText(this, "Escribe un id.", Toast.LENGTH_SHORT).show();
    }

    public void eliminar(View v){
        String id = ID.getText().toString();
        if(!id.equals("")){
            if(iBD.miSolicitud(usuario, id)) {
                iBD.eliminaSolicitud(id);
                Toast.makeText(this, "La solicitud ha sido Eliminada", Toast.LENGTH_SHORT).show();
            }else
                Toast.makeText(this, "Asegúrate de que el id que ingresaste aparezca en tu lista de solicitudes.", Toast.LENGTH_SHORT).show();
        } else
            Toast.makeText(this, "Escribe un id.", Toast.LENGTH_SHORT).show();
    }
}
