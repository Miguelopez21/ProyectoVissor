
package com.app.modelo.vo;

public class RolVO implements IreglasVO{
    
    private int idRol;
    private String nombreRol;
    private String descripcion;
    private boolean estado;

    public RolVO() {
    }

    public RolVO(int idRol, String nombreRol, String descripcion, boolean estado) {
        this.idRol = idRol;
        this.nombreRol = nombreRol;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    
}
