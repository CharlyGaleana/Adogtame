package com.example.cgaleanah.adogtame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class PantallaInicio extends AppCompatActivity {

    private String usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_inicio);

        Bundle bundle = this.getIntent().getExtras();
        usuario = bundle.get("usuario").toString();
    }

    public void modificar(View view){
        Intent intent = new Intent(PantallaInicio.this, Modificar.class);
        startActivity(intent);
    }

    public void adoptar(View view){
        Intent intent = new Intent(PantallaInicio.this, Adoptar.class);
        startActivity(intent);
    }

    public void agregarPerro(View view){
        Intent intent = new Intent(PantallaInicio.this, AgregarPerro.class);
        startActivity(intent);
    }

    public void solicitudes(View view){
        Intent intent = new Intent(PantallaInicio.this, Solicitudes.class);
        startActivity(intent);
    }

    public void salir(View view){
        Intent intent = new Intent(PantallaInicio.this, MainActivity.class);
        startActivity(intent);
    }
}
