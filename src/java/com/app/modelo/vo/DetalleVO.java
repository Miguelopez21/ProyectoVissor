
package com.app.modelo.vo;

public class DetalleVO implements IreglasVO{
    
    private int idDetalle;
    private int idReunion;
    private String detalle;
    private String descripcion;

    public DetalleVO() {
    }

    public DetalleVO(int idDetalle, int idReunion, String detalle, String descripcion) {
        this.idDetalle = idDetalle;
        this.idReunion = idReunion;
        this.detalle = detalle;
        this.descripcion = descripcion;
    }

    public int getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }

    public int getIdReunion() {
        return idReunion;
    }

    public void setIdReunion(int idReunion) {
        this.idReunion = idReunion;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
