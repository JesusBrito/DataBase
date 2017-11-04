package com.example.jesus.bd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by jesus on 24/10/17.
 */

public class MiAuxSQL extends SQLiteOpenHelper {

    public MiAuxSQL(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        String query = "CREATE TABLE Persona (nombre TEXT, " +
                                              "edad TEXT, " +
                                              "carrera TEXT)";
        DB.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int vAnt, int vNva) {

    }
}
