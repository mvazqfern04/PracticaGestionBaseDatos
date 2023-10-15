package com.example.practicagestionbasedatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Insets;
import android.os.Bundle;
import android.service.voice.VoiceInteractionSession;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button botonRegistrar, botonMostrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this,"bd_usuarios",null,1);

        botonRegistrar = findViewById(R.id.idBotonRegistrar);
        botonRegistrar.setOnClickListener(view -> pantallaRegistro());
        botonMostrar = findViewById(R.id.idMostrarRegistros);
        botonMostrar.setOnClickListener(v -> mostrarRegistros());
    }

    private void mostrarRegistros() {
        Intent intent = new Intent(this, ConsultarUsuarioActivity.class);
        this.startActivity(intent);
    }

    private void pantallaRegistro() {
        Intent intent = new Intent(this, RegistrarUsuarioActivity.class);
        this.startActivity(intent);
    }
}