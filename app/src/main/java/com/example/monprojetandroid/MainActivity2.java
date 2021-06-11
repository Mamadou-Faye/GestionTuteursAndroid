package com.example.monprojetandroid;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    Button btnAjouter;
    Button btnAfficher, btnModify, btnDelete;
    EditText editTextPrenom, editTextNom, editTextEmail, editEditFiliere, editTextId;
    DataBaseTuteur myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        myDB = new DataBaseTuteur(this);

        editTextId = (EditText) findViewById(R.id.editTextId);
        btnAjouter = (Button) findViewById(R.id.btnAjouter);
        btnAjouter.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent newIntent = new Intent(getApplicationContext(), MainActivityAjout.class);
                startActivity(newIntent);
                Toast.makeText(getApplicationContext(), "Bienvenue !", Toast.LENGTH_LONG).show();
            }
        });

        btnAfficher = (Button) findViewById(R.id.btnAfficher);
        btnAfficher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = myDB.gatAllDATA();
                if (res.getCount() == 0){
                    AfficherMessage("ERREUR", "Aucune donnée disponible !");
                }
                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()){
                    buffer.append("ID : " + res.getString(0) + ", ");
                    buffer.append("Prenom : " + res.getString(1) + ", ");
                    buffer.append("Nom : " + res.getString(2) + ", ");
                    buffer.append("Filière : " + res.getString(3) + " !\n");
                }
                AfficherMessage("Informations des Tuteurs : ", buffer.toString());
            }
        });

        editTextNom = (EditText) findViewById(R.id.editextName);
        editTextPrenom = (EditText) findViewById(R.id.editTextPrenom);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editEditFiliere = (EditText) findViewById(R.id.editTextFiliere);
        btnModify = (Button) findViewById(R.id.btnModify);
        btnModify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean IsUpdate = myDB.upDateData(editTextId.getText().toString(),
                        editTextNom.getText().toString(),
                        editTextPrenom.getText().toString(),
                        editTextEmail.getText().toString(),
                        editEditFiliere.getText().toString());
                if (IsUpdate == true){
                    Toast.makeText(getApplicationContext(), "Mise à jour éffectuée avec succès !", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Echec de la mise à jour !", Toast.LENGTH_LONG).show();
                }
            }
        });

        btnDelete = (Button) findViewById(R.id.btnSupprimer);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer delete = myDB.deleteData(editTextId.getText().toString());
                if (delete > 0){
                    Toast.makeText(getApplicationContext(), "Suppression avec succès !", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Echec de la suppression !", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public  void AfficherMessage(String titre, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(titre);
        builder.setMessage(message);
        builder.show();
    }
}







