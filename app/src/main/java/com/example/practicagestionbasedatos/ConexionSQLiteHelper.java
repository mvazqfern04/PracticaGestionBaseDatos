package com.example.practicagestionbasedatos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.example.practicagestionbasedatos.utilidades.Utilidades;


public class ConexionSQLiteHelper extends SQLiteOpenHelper {

    private Context context;


    public ConexionSQLiteHelper(Context contextoAplicacion, String nombreTabla, SQLiteDatabase.CursorFactory factory, int version) {
        super(contextoAplicacion, nombreTabla, factory, version);
        context=contextoAplicacion;
    }

    @Override
    public void onCreate(SQLiteDatabase baseDeDatos) {
        try {
            baseDeDatos.execSQL(Utilidades.CREAR_TABLA);
        } catch (Exception e){
            Toast.makeText(context, "No se ha podido crear la base de datos", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAntigua, int versionNueva) {
        db.execSQL("DROP TABLE IF EXISTS " + Utilidades.TABLA_NOMBRE);
        onCreate(db);
    }
}
