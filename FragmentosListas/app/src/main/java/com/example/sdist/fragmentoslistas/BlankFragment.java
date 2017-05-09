package com.example.sdist.fragmentoslistas;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends android.app.Fragment {

    Button agregar;
    EditText dato;
    InterfazBD iBD;
    FragmentManager fm;



    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        //necesitas inflarlos para poder verlos la R solo está en mainActivity
        View v= inflater.inflate(R.layout.fragment_blank, container, false);
        agregar= (Button) v.findViewById(R.id.botonAgregar);
        dato= (EditText)v.findViewById(R.id.datoUsuario);
        fm= this.getActivity().getFragmentManager(); // le pasas el control para que el los pueda manejar

//Crear el escuchador del boton
        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s= dato.getText().toString();
                iBD= new InterfazBD(v.getContext());
                //insertar dato en la base de datos
                long clave= iBD.insertarDatos(s);
                //mostrar la llave primaria del dato agregado
                Toast.makeText(v.getContext(), "La llave es: "+clave, Toast.LENGTH_SHORT).show();
                FragmentTransaction ft= fm.beginTransaction();
                android.app.Fragment f1= new FragmentoLista();
                ft.replace(R.id.actividadPrincipal, f1);
                //para que los fragmentos puedan funcionar siempre llevan un commit
                ft.commit();
            }
        });



        return v;
    }

}
