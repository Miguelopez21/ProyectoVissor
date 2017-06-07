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
    ERROR_DATOS_DUPLICADOS(204, "Error Datos Duplicados"),
    INSERTO(1, "Inserto exitosamente los datos"),
    CONSULTO(1, "Su consulta a sido un exito"),
    ELIMINO(1, "Sus datos se eliminaron correctamente"),
    MODIFICAR(1, "Sus datos fueron modificados correctamente"),
    EXITO(1, "Su operacion fue un exito"),
    VALIDACION(0, "Usuario o Contraseña invalidos"),;

    private int codigo;
    private String Mensajes;

    private EErroresAplicacion(int codigo, String mensajes) {
        this.codigo = codigo;
        this.Mensajes = mensajes;

    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getMensajes() {
        return Mensajes;
    }

    public void setMensajes(String Mensajes) {
        this.Mensajes = Mensajes;
    }
}
