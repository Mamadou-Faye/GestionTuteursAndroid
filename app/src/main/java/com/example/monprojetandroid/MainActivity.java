package com.example.monprojetandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txtLogin, txtPassword;
    Button btnEnvoi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtLogin = (EditText) findViewById(R.id.editLogin);
        txtPassword = (EditText) findViewById(R.id.editPassword);
        btnEnvoi = (Button) findViewById(R.id.btnEnvoyer);
        btnEnvoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtLogin.getText().toString().equals("faye") &&  txtPassword.getText().toString().equals("123")){
                    Intent activity2 = new Intent(getApplicationContext(), MainActivity2.class);
                    startActivity(activity2);
                    Toast.makeText(getApplicationContext(), "Vous êtes bien connecté !", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Echec ! Veuillez saisir correctement votre login et mot de passe !",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}