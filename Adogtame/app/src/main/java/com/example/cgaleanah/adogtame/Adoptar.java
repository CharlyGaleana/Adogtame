package com.example.cgaleanah.adogtame;


import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Adoptar extends AppCompatActivity {

    private String usuario;
    private EditText raza, edad, sexo, ID;
    private InterfazBD IB = new InterfazBD(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adoptar);

        Bundle bundle = getIntent().getExtras();

        //recuperamos los textViews
        usuario = bundle.get("usuario").toString();
        raza = (EditText) findViewById(R.id.etRaza);
        edad = (EditText) findViewById(R.id.etEdad);
        sexo = (EditText) findViewById(R.id.etSexo);
        ID = (EditText) findViewById(R.id.etID);
    }

    public void buscarPerro(View v){
        //agregar un fragmento, aun no funciona
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        Fragment f1 = new FragmentoLista();
        ft.add(R.id.actividadPrincipal, f1);
        ft.commit();
    }

    public void adoptar(View V){
        String id = ID.getText().toString();
        if(!id.equals("")){
            String destinatario = IB.getOwner(id);
            IB.insertarSolicitud(usuario, destinatario);
        }
    }
}
