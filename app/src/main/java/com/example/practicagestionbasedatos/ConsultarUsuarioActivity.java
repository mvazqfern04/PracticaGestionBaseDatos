package com.example.practicagestionbasedatos;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.practicagestionbasedatos.utilidades.Utilidades;

public class ConsultarUsuarioActivity extends AppCompatActivity {
    EditText campoId, campoNombre, campoTelefono;
    Button botonSalir, botonMostar, botonLimpiar;

    ConexionSQLiteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_usuario);

        conn = new ConexionSQLiteHelper(getApplicationContext(), "bd_usuarios", null, 1);

        campoId = findViewById(R.id.idDelId2);
        campoNombre = findViewById(R.id.idNombre2);
        campoTelefono = findViewById(R.id.idNumeroTelefono2);
        botonSalir = findViewById(R.id.idBotonSalir2);
        botonMostar = findViewById(R.id.idBotonMostrar);
        botonLimpiar = findViewById(R.id.idBotonLimpiar);

        botonLimpiar.setOnClickListener(v -> limpiarResultado());
        botonSalir.setOnClickListener(v -> salirRegistros());
        botonMostar.setOnClickListener(v -> mostarUsuari());
    }

    private void limpiarResultado() {
        campoNombre.setText("");
        campoTelefono.setText("");
    }

    private void mostarUsuari() {
        SQLiteDatabase db = conn.getReadableDatabase();
        //Cuales son los parametros de consulta:
        String[] parametros = {campoId.getText().toString()};
        //Cuales son los campo que queremos ver:
        String[] campos = {Utilidades.CAMPO_NOMBRE, Utilidades.CAMPO_TELEFONO};

        try {
            //Lo que necesitamos para enviarle la señal a la base de datos:
            Cursor cursor = db.query(Utilidades.TABLA_NOMBRE, campos, Utilidades.CAMPO_ID + "=?", parametros, null, null, null);
            cursor.moveToFirst();

            //Asignamos lo obtenido
            campoNombre.setText(cursor.getString(0));
            campoTelefono.setText(cursor.getString(1));
            cursor.close();
        } catch (Exception e) {
            Toast.makeText(this,"No se pudieron obtener los datos",Toast.LENGTH_SHORT).show();
            limpiarResultado();
        }

    }

    private void salirRegistros() {
        this.finish();
    }
}