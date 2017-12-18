package com.example.carlosrkm.bio_pappelscribe.utilidades;

/**
 * Created by carlosrkm on 12/11/17.
 */

public class Utilidades {

    // Constantes campos de la tabla usuarios
    public static final String TABLA_USUARIO="usuario";
    public static final String CAMPO_ID="id";
    public static final String CAMPO_NOMBRE="nombre";
    public static final String CAMPO_DEPARTAMENTO="departamento";
    public static final String CAMPO_DIRECCIONIP="direccionip";
    public static final String CAMPO_MARCAMONITOR="marcamonitor";
    public static final String CAMPO_MODELOMONITOR="modelomonitor";
    public static final String CAMPO_SERIEMONITOR="seriemonitor";
    public static final String CAMPO_MARCACPU="marcacpu";
    public static final String CAMPO_MODELOCPU="modelocpu";
    public static final String CAMPO_SERIECPU="seriecpu";
    public static final String CAMPO_MARCATECLADO="marcateclado";
    public static final String CAMPO_MODELOTECLADO="modeloteclado";
    public static final String CAMPO_SERIETECLADO="serieteclado";
    public static final String CAMPO_MARCAMOUSE="marcamouse";
    public static final String CAMPO_MODELOMOUSE="modelomouse";
    public static final String CAMPO_SERIEMOUSE="seriemouse";

    public static final String CREAR_TABLA_USUARIO="CREATE TABLE IF NOT EXISTS "+TABLA_USUARIO+" ("+CAMPO_ID+" TEXT, "+CAMPO_NOMBRE+" TEXT, "+CAMPO_DEPARTAMENTO+" TEXT, "+CAMPO_DIRECCIONIP+" TEXT, "+CAMPO_MARCAMONITOR+" TEXT, "+CAMPO_MODELOMONITOR+" TEXT, "+CAMPO_SERIEMONITOR+" TEXT, "+CAMPO_MARCACPU+" TEXT, "+CAMPO_MODELOCPU+" TEXT, "+CAMPO_SERIECPU+" TEXT, "+CAMPO_MARCATECLADO+" TEXT, "+CAMPO_MODELOTECLADO+" TEXT, "+CAMPO_SERIETECLADO+" TEXT, "+CAMPO_MARCAMOUSE+" TEXT, "+CAMPO_MODELOMOUSE+" TEXT, "+CAMPO_SERIEMOUSE+" TEXT)";


}
