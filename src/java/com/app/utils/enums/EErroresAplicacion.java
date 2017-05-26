package com.app.utils.enums;

public enum EErroresAplicacion {

    ERROR_CONEXION_BD(101, "Error en la conexion a la Base de Datos"),
    ERROR_INSERTAR(102, "Error al Insertar Registro."),
    ERROR_MODIFICAR(103, "Error al Modificar Registro."),
    ERROR_CONSULTAR(104, "Error al Consultar Registro."),
    ERROR_ELIMINAR(105, "Error al Eliminar Registro."),
    //Codigos 200 Error en datos
    ERROR_DATOS_INCOMPLETOS(201, "Error Faltan Datos"),
    ERROR_DATOS_FECHA_ERRORENA(202, "Error Faltan Datos"),
    ERROR_DATOS_TIPO(203, "Error en los tipos de Datos"),
    ERROR_DATOS_DUPLICADOS(204, "Error Datos Duplicados"),;

    private final int codigo;
    private final String mensaje;

    private EErroresAplicacion(int codigo, String mensaje) {
        this.codigo = codigo;
        this.mensaje = mensaje;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getMensaje() {
        return mensaje;
    }
}
