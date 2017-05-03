package com.example.cgaleanah.adogtame;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by CGALEANAH on 03/05/2017.
 */

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper{

    public AdminSQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table usuarios(usuario text primary key, contraseña text, nombre text, telefono text, direccion text)");
        db.execSQL("create table perros(nombre text, sexo text, raza text, edad text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists usuarios");
        db.execSQL("create table usuarios(usuario text primary key, nombre text, telefono text, direccion text)");
        db.execSQL("drop table if exists perros");
        db.execSQL("create table perros(nombre text, sexo text, raza text, edad text)");
    }

}
