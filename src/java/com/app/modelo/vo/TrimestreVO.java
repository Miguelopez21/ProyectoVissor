
package com.app.modelo.vo;

public class TrimestreVO implements IreglasVO{
    
    private int idTrimestre;
    private String trimesre;
    private String descripcion;

    public TrimestreVO() {
    }

    public TrimestreVO(int idTrimestre, String trimesre, String descripcion) {
        this.idTrimestre = idTrimestre;
        this.trimesre = trimesre;
        this.descripcion = descripcion;
    }

    public int getIdTrimestre() {
        return idTrimestre;
    }

    public void setIdTrimestre(int idTrimestre) {
        this.idTrimestre = idTrimestre;
    }

    public String getTrimesre() {
        return trimesre;
    }

    public void setTrimesre(String trimesre) {
        this.trimesre = trimesre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
