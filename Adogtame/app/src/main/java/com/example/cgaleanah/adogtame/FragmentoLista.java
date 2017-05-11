package com.example.cgaleanah.adogtame;


import android.app.ListFragment;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentoLista extends ListFragment {

    String usuario, sexo, raza, edad;
    InterfazBD iBD;   //clase donde se maneja la bd
    Cursor res;   //lector que tiene los datos de una busqueda
    SimpleCursorAdapter sca;   //conexion entre los datos y el fragmento

    public FragmentoLista() {
        // Required empty public constructor
    }

    public FragmentoLista(String usuario, String sexo, String raza, String edad){
        this.usuario = usuario;
        this.sexo = sexo;
        this.raza = raza;
        this.edad = edad;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= super.onCreateView(inflater, container, savedInstanceState);
        //nombre de las columnas en la bd
        String[] arregloColumnas = {"_id", "owner", "nombre", "sexo", "raza", "edad"};
        //TextViews del renglon donde se guardan los datos y los metes a un arreglo
        int[]to = {R.id.tvid, R.id.tvown, R.id.tvnom, R.id.tvsex, R.id.tvraza, R.id.tvedad};
        //crear la conexion con la bd
        iBD = new InterfazBD(this.getActivity());
        //crear el cuersor de la bd con los resultados de la tabla
        //res = iBD.datosUsuario(usuario);
        res = iBD.buscaPerros(usuario, sexo, raza, 15);
        Toast.makeText(this.getActivity(), "hola", Toast.LENGTH_SHORT).show();
        sca = new SimpleCursorAdapter(this.getActivity(), R.layout.formato_renglon, res, arregloColumnas, to, 0);
        this.setListAdapter(sca);

        return v;
    }

}
