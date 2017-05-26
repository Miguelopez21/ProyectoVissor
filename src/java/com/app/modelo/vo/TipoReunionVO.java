
package com.app.modelo.vo;

public class TipoReunionVO implements IreglasVO{
    
    private int idTipoReunion;
    private String nombreTipo;
    private String descripcion;

    public TipoReunionVO() {
    }

    public TipoReunionVO(int idTipoReunion, String nombreTipo, String descripcion) {
        this.idTipoReunion = idTipoReunion;
        this.nombreTipo = nombreTipo;
        this.descripcion = descripcion;
    }

    public int getIdTipoReunion() {
        return idTipoReunion;
    }

    public void setIdTipoReunion(int idTipoReunion) {
        this.idTipoReunion = idTipoReunion;
    }

    public String getNombreTipo() {
        return nombreTipo;
    }

    public void setNombreTipo(String nombreTipo) {
        this.nombreTipo = nombreTipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
}
