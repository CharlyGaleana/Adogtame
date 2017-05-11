package com.example.sdist.fragmentoslistas;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

/**
 * Created by sdist on 04/05/2017.
 */
public class InterfazBD {

    ConexionBD con;
    SQLiteDatabase db;

    public InterfazBD(Context context){
        con= new ConexionBD(context);
    }

    public void open() throws SQLiteException{
        db= con.getWritableDatabase();
    }

    public void close() throws SQLiteException{
        con.close();
    }

    public long insertarDatos(String dato){
        ContentValues valores;
        open();
        valores= new ContentValues();
        valores.put("datos", dato);
        long clave= db.insert("tablaprueba", null,valores);
        close();
        return clave;

    }

    public void insertarDatosPrueba(){
        ContentValues valores;
        open();
        valores = new ContentValues();
        valores.put("datos", "hola");
        db.insert("tablaprueba", null, valores);
        valores.put("datos", "cara");
        db.insert("tablaprueba", null, valores);
        valores.put("datos", "de");
        db.insert("tablaprueba", null, valores);
        valores.put("datos", "bola");
        db.insert("tablaprueba", null, valores);
    }

    public String traerDato (long clave){
        open();
        String claveString = Long.toString(clave);
        String query = "select * from tablaprueba where _id="+ claveString+";";
        Cursor c =db.rawQuery(query, null);
        c.moveToNext(); //te mueve al siguiente renglón
        String res= c.getString(1);  // pones 1 porque sino te manda el id y tú quieres el segundo renglón
        c.close();
        close();
        return res;
    }

    public Cursor traerDatos(){
        Cursor res= null;
        open();
        String query= "select * from tablaprueba";
        res= db.rawQuery(query, null);
        return res;
    }
}
