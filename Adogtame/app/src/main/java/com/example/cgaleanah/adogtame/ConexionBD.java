package com.example.cgaleanah.adogtame;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class ConexionBD extends SQLiteOpenHelper {

    String cadenaCreate="create table if not exists tablaprueba(_id integer primary key autoincrement, datos text not null)";
    private String createUsuarios = "create table if not exists usuarios(usuario text primary key, contra text, nombre text, telefono text, direccion text)";
    private String createPerros = "create table if not exists perros(_id integer primary key autoincrement, string owner, nombre text, sexo text, raza text, edad integer)";
    private String createSolicitudes = "create table if not exists solicitudes(_id integer primary key autoincrement, remitente text, destinatario text)";

    private String updateUsuarios = "drop table if exists usuarios";
    private String updatePerros = "drop table if exists perros";
    private String updateSolicitudes = "drop table if exists solicitudes";

    public ConexionBD(Context context) {
        super(context, "baseDatos", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createUsuarios);
        db.execSQL(createPerros);
        db.execSQL(createSolicitudes);
        db.execSQL(cadenaCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(updateUsuarios);
        db.execSQL(updatePerros);
        db.execSQL(updateSolicitudes);
        String cadenaUpdate="drop table if exists tablaprueba";
        db.execSQL(cadenaUpdate);
        onCreate(db);
    }

}
