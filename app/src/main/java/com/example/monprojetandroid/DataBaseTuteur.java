package com.example.monprojetandroid;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.SimpleTimeZone;

public class DataBaseTuteur extends SQLiteOpenHelper {
    //Base de donnée
    private static final String DATABASE_NAME = "GestionTuteur";

    //Table tuteur
    private static final String TABLE_NAME1 = "Tuteur";
    private static final String Col1 = "ID";
    private static final String Col2 = "Nom";
    private static final String Col3 ="Prenom";
    private static final String Col4 = "Email";
    private static final String Col5 = "Filiere";

    //table filiere
    private static final String TABLE_NAME3 = "filiere";
    private static final String Col111 = "IDFILIERE";
    private static final String Col222 = "NOM";
    private static final String Col333 = "CHEFFILIERE";

    //table cours
    private static final String TABLE_NAME2 = "Cours";
    private static final String Col11 = "IDCOURS";
    private static final String Col22 = "NOM";
    private static final String Col33 = "IDFILIERE";
    private Tuteur tuteur;
    private Filiere fl;

    public DataBaseTuteur(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db =this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME1 + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, Prenom TEXT, Nom TEXT, Email TEXT, Filiere TEXT)");
        db.execSQL("create table " + TABLE_NAME3 + "(IDFILIERE INTEGER PRIMARY KEY AUTOINCREMENT, nom text, chefFiliere text)");
        db.execSQL("create table " + TABLE_NAME2 + "(IDCOURS INTEGER PRIMARY KEY AUTOINCREMENT," +
                " Nom TEXT, " +
                "CONSTRAINT Id FOREIGN KEY (Tuteur) REFERENCES TABLE_NAME1 (ID)," +
                "CONSTRAINT idFIliere FOREIGN KEY (Filiere) REFERENCES TABLE_NAME3(idFiliere))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersio) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME1);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME2);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME3);
        onCreate(db);
    }

    public boolean insert(String email, String nom, String prenom, String filiere){
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Col2, nom);
        values.put(Col3, prenom);
        values.put(Col4, email);
        values.put(Col5, filiere);
        long resultat = db.insert(TABLE_NAME1, null, values);
        Log.i("##### check insert", "result " + resultat);
        if (resultat == -1){
            return false;
        }else{
            return true;
        }
    }

    public Cursor gatAllDATA (){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME1, null);
        return res;
    }

    public boolean upDateData(String id, String nom, String prenom, String email, String filiere){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Col1, id);
        values.put(Col2, nom);
        values.put(Col3, prenom);
        values.put(Col4, email);
        values.put(Col5, filiere);
        db.update(TABLE_NAME1, values, "ID = ?", new String[]{id});
        return true;
    }

    public Integer deleteData (String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return  db.delete(TABLE_NAME1, "ID = ?", new String[]{id});
    }
}
