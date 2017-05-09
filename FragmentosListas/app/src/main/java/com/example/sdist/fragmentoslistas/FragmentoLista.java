package com.example.sdist.fragmentoslistas;


import android.app.ListFragment;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentoLista extends ListFragment {

    InterfazBD iBD;   //clase donde se maneja la bd
    Cursor res;   //lector que tiene los datos de una busqueda
    SimpleCursorAdapter sca;   //conexion entre los datos y el fragmento
    ListView lv;


    public FragmentoLista() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= super.onCreateView(inflater, container, savedInstanceState);
        //nombre de las columnas en la bd
        String[] arregloColumnas= {"_id", "datos"};
        //TextViews del renglon donde se guardan los datos y los metes a un arreglo
        int[]to= {R.id.texto1, R.id.texto2};
        //crear la conexion con la bd
        iBD= new InterfazBD(this.getActivity());
        //crear el cuersor de la bd con los resultados de la tabla
        res=iBD.traerDatos();
        sca= new SimpleCursorAdapter(this.getActivity(), R.layout.formato_renglon, res, arregloColumnas, to, 0);
        this.setListAdapter(sca);


        return v;
    }

}
