package com.app.modelo.dto;

import com.app.utils.enums.EErroresAplicacion;

public class RespuestaDTO {

    private int codigo;
    private String mensaje;
    private Object datos;

    public RespuestaDTO() {

    }

    public RespuestaDTO(EErroresAplicacion mensaje) {
        this.codigo = mensaje.getCodigo();
        this.mensaje = mensaje.getMensajes();
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
