package com.example.practicagestionbasedatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.practicagestionbasedatos.utilidades.Utilidades;

public class RegistrarUsuarioActivity extends AppCompatActivity {

    EditText campoId,campoNombre,campoTelefono;
    Button botonRegistrar,botonSalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_usuario);

        campoId=findViewById(R.id.idDelId);
        campoNombre=findViewById(R.id.idNombre);
        campoTelefono=findViewById(R.id.idNumeroTelefono);
        botonRegistrar=findViewById(R.id.idBotonGuardarUsuario);
        botonSalir=findViewById(R.id.idBotonSalir);

        botonSalir.setOnClickListener(v -> salirRegistros());
        botonRegistrar.setOnClickListener(v -> registrarUsuarios());
    }

    private void registrarUsuarios() {
        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this,"bd_usuarios",null,1);

        //Creamos objeto para manipular la base de datos
        SQLiteDatabase db = conn.getWritableDatabase();

        //Creamos el content values para introducir los valores
        ContentValues values = new ContentValues();
        values.put(Utilidades.CAMPO_ID,campoId.getText().toString());
        values.put(Utilidades.CAMPO_NOMBRE,campoNombre.getText().toString());
        values.put(Utilidades.CAMPO_TELEFONO,campoTelefono.getText().toString());

        //Insertamos los valores, esto devuelve un dato long
        Long idResultante = db.insert(Utilidades.TABLA_NOMBRE,Utilidades.CAMPO_ID,values);
        Toast.makeText(getApplicationContext(),"Id registro: "+idResultante,Toast.LENGTH_SHORT).show();
    }

    private void salirRegistros() {
        this.finish();
    }


}