package com.example.monprojetandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivityAjout extends AppCompatActivity {
    EditText editTextName, editTextPrenom, editTextEmail, editTextFiliere;
    Button btnEnregistre;
    DataBaseTuteur maBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_ajout);
        maBase = new DataBaseTuteur(this);

        editTextName = (EditText) findViewById(R.id.editextName);
        editTextPrenom = (EditText) findViewById(R.id.editTextPrenom);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextFiliere = (EditText) findViewById(R.id.editTextFiliere);
        btnEnregistre = (Button) findViewById(R.id.btnEnregistre);
        btnEnregistre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isInsert = maBase.insert(editTextName.getText().toString(),
                        editTextPrenom.getText().toString(),
                        editTextEmail.getText().toString(),
                        editTextFiliere.getText().toString());
                if (isInsert == true){
                    Toast.makeText(getApplicationContext(), "Insertions des données avec succès !", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Echec de l'insertion des données !", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}