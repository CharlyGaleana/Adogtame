package com.example.cgaleanah.adogtame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText usuario;
    private EditText contra;
    private InterfazBD iBD = new InterfazBD(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usuario = (EditText) findViewById(R.id.etUsuario);
        contra = (EditText) findViewById(R.id.etContra);
    }

    public void registrar(View v){
        Intent intent = new Intent(MainActivity.this, Registro.class);
        startActivity(intent);
    }

    public void iniciaSesion(View v){
        String u = usuario.getText().toString(), c = contra.getText().toString();
        if(!u.equals("") && !c.equals("")) {
            if (iBD.loginUsuario(u, c)) {
                Intent intent = new Intent(MainActivity.this, PantallaInicio.class);
                Bundle b = new Bundle();
                b.putString("usuario", usuario.getText().toString());
                intent.putExtras(b);
                startActivity(intent);
            } else {
                Toast.makeText(this, "Asegúrate de que el usuario y la contraseña ingresada sean correctas.", Toast.LENGTH_SHORT).show();
            }
        } else Toast.makeText(this, "Asegúrate de llenar ambos campos.", Toast.LENGTH_SHORT).show();
    }
}
