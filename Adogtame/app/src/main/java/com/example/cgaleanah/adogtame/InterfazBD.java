package com.example.cgaleanah.adogtame;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.view.View;
import android.widget.Toast;

/**
 * Created by CGALEANAH on 09/05/2017.
 */

/*
    private String createUsuarios = "create table usuarios(usuario text primary key, contraseña text, nombre text, telefono text, direccion text)";
    private String createPerros = "create table perros(_id integer primary key autoincrement, nombre text, sexo text, raza text, edad text)";
    private String createSolicitudes = "create table solicitudes(_id integer primary key autoincrement, rem text, dest text)";
 */

public class InterfazBD {

    private ConexionBD con;
    private SQLiteDatabase db;

    public InterfazBD(Context context) {
        con = new ConexionBD(context);
    }

    public void open() throws SQLiteException {
        con.getWritableDatabase();
    }

    public void close() throws SQLiteException {
        con.close();
    }

    public void insertaUsuario(String user, String contra, String nom, String tel, String dir){
        ContentValues valores = new ContentValues();
        open();

        valores.put("usuario", user);
        valores.put("contra", contra);
        valores.put("nombre", nom);
        valores.put("telefono", tel);
        valores.put("direccion", dir);

        db.insert("usuarios", null, valores);
        close();
    }

    public int modificaUsuario(String column, String usuario, String newValue){
        int ret;
        ContentValues valores = new ContentValues();
        open();
        valores.put(column, newValue);
        ret = db.update("usuarios", valores, "usuario =" + usuario, null);
        close();
        return ret;
    }

    public Cursor datosUsuario(String usuario){
        Cursor res;
        open();

        String query = "select * from usuarios where usuario =" + usuario;
        res = db.rawQuery(query, null);
        close();
        return res;
    }

    public boolean loginUsuario(String usuario, String contra){
        open();
        Cursor fila = db.rawQuery("select * from usuarios where usuario =" + usuario + " and contra =" + contra, null);
        close();
        return fila.moveToFirst();
    }

    public void insertaPerro(String nombre, String owner, String sexo, String raza, String edad){
        ContentValues valores = new ContentValues();
        open();

        valores.put("nombre", nombre);
        valores.put("owner", owner);
        valores.put("sexo", sexo);
        valores.put("raza", raza);
        valores.put("edad", edad);

        db.insert("perros", null, valores);
        close();
    }

    public Cursor buscaPerros(String usuario, String sexo, String raza, int edad){
        Cursor res;
        open();

        //select * from perros where owner != usuario and sexo like 'sexo%' and raza like 'raza%' and edad <= edad
        String query = "select * from perros where owner !=" + usuario + " and sexo like '" + sexo + "%' and raza like'" + raza + "%' and edad <=" + edad;
        res = db.rawQuery(query, null);
        close();
        return res;
    }

    // private String createSolicitudes = "create table solicitudes(_id integer primary key autoincrement, remitente text, destinatario text)";

    public void insertarSolicitud(String remitente, String destinatario){
        ContentValues valores = new ContentValues();
        open();

        valores.put("remitente", remitente);
        valores.put("destinatario", destinatario);

        db.insert("solicitudes", null, valores);
        close();
    }

    public void eliminaSolicitud(int id){
        open();
        db.delete("solicitudes", "_id =" + id, null);
        close();
    }

    public Cursor solicitudes(String usuario){
        Cursor res;
        open();

        String query = "select solicitudes.*, perros.nombre from solicitudes, perros where destinatario = owner and destinatario =" + usuario;
        res = db.rawQuery(query, null);
        close();
        return res;
    }

}
