package com.app.utils.exceptions;

import com.app.utils.enums.EErroresAplicacion;

public class ProyectoException extends Exception {

    private int codigo;
    private String mensaje;
    private Object datos;

    public ProyectoException(EErroresAplicacion mensaje) {
        this.codigo = mensaje.getCodigo();
        this.mensaje = mensaje.getMensajes();
    }

    public ProyectoException(EErroresAplicacion mensaje, Object datos) {
        this.codigo = mensaje.getCodigo();
        this.mensaje = mensaje.getMensajes();
        this.datos = datos;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Object getDatos() {
        return datos;
    }

    public void setDatos(Object datos) {
        this.datos = datos;
    }

}
