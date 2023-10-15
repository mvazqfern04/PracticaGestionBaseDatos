package com.example.practicagestionbasedatos.utilidades;

public class Utilidades {

    //Constantes
    public final static String TABLA_NOMBRE="usuarios";
    public final static String CAMPO_ID="id";
    public final static String CAMPO_NOMBRE="nombre";
    public final static String CAMPO_TELEFONO="telefono";

    public final static String CREAR_TABLA="CREATE TABLE IF NOT EXISTS "+
            TABLA_NOMBRE+" ("+
            CAMPO_ID+" INTEGER, "+
            CAMPO_NOMBRE+" TEXT, "+
            CAMPO_TELEFONO+" TEXT)";
}
