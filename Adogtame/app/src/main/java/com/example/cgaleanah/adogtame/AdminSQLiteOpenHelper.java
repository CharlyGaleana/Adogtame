package com.example.cgaleanah.adogtame;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by CGALEANAH on 03/05/2017.
 */

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper{


    private String createUsuarios = "create table usuarios(usuario text primary key, contraseña text, nombre text, telefono text, direccion text)";
    private String createPerros = "create table perros(_id integer primary key autoincrement, nombre text, sexo text, raza text, edad text)";
    private String createSolicitudes = "create table solicitudes(_id integer primary key autoincrement, rem text, dest text)";

    private String updateUsuarios = "drop table if exists usuarios";
    private String updatePerros = "drop table if exists perros";
    private String updateSolicitudes = "drop table if exists solicitudes";

    public AdminSQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createUsuarios);
        db.execSQL(createPerros);
        db.execSQL(createSolicitudes);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(updateUsuarios);
        db.execSQL(updatePerros);
        db.execSQL(updateSolicitudes);
        onCreate(db);
    }

}
