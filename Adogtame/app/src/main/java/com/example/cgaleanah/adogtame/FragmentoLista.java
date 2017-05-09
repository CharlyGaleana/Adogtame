package com.example.cgaleanah.adogtame;

import android.app.ListFragment;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by CGALEANAH on 09/05/2017.
 */

public class FragmentoLista extends ListFragment{

    private String usuario, sexo, raza, edad;
    private InterfazBD iBD;   //clase donde se maneja la bd
    private Cursor res;   //lector que tiene los datos de una busqueda
    private SimpleCursorAdapter sca;   //conexion entre los datos y el fragmento

    public FragmentoLista(){
        //
    }

    public FragmentoLista(String usuario, String sexo, String raza, String edad) {
        this.usuario = usuario;
        this.sexo = sexo;
        this.raza = raza;
        this.edad = edad;
    }

//   private String createPerros = "create table if not exists perros(_id integer primary key autoincrement, string owner, nombre text, sexo text, raza text, edad integer)";

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
        res = iBD.buscaPerros(usuario, sexo, raza, Integer.parseInt(edad));
        sca = new SimpleCursorAdapter(this.getActivity(), R.layout.fragmento_renglon, res, arregloColumnas, to, 0);
        this.setListAdapter(sca);

        return v;
    }

}
