package com.example.cgaleanah.adogtame;


import android.app.ListFragment;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class FragmentoLista extends ListFragment {

    String usuario, sexo, raza, edad;
    InterfazBD iBD;   //clase donde se maneja la bd
    Cursor res;   //lector que tiene los datos de una busqueda
    SimpleCursorAdapter sca;   //conexion entre los datos y el fragmento

    public FragmentoLista() {
        // Required empty public constructor
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=super.onCreateView(inflater, container, savedInstanceState);

        //Nombres de las columnas en la bd
        String []arregloColumnas={"_id","datos"};
        //Textviews del renglon donde se van a guardar los datos
        int []to={R.id.texto1,R.id.texto2};
        //crear conexion con la bd
        iBD=new InterfazBD(this.getActivity());
        //crear cursor de la bd con los resultados de la tabla
        res=iBD.traerDatos();
        //Pasarle el cursor a la actividad
        //startManagingCursor(res);
        //Crear el adaptador para mostrar los datos
        sca=new SimpleCursorAdapter(
                this.getActivity(), //Actividad papa de todos
                R.layout.formato_renglon, //Formato que se repite en la lista
                res, //Cursor que tiene los datos de la consulta
                arregloColumnas, //Nombres de las columnas de la bd
                to, //Elementos destino en el layout del renglon
                0); //Este cero no hay que pelarlo
        //Pegar el adaptador a la lista
        this.setListAdapter(sca);


        return v;
    }

}
