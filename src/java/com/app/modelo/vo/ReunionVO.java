
package com.app.modelo.vo;

import java.util.Date;

public class ReunionVO implements IreglasVO{
    
    private int idReunion;
    private int idProyecto;
    private int idTipoReunion;
    private String nombre;
    private String lugar;
    private String ambiente;
    private Date fechaIncio;
    private Date fechaFin;
    private boolean estado;

    public ReunionVO() {
    }

    public ReunionVO(int idReunion, int idProyecto, int idTipoReunion, String nombre, String lugar, String ambiente, Date fechaIncio, Date fechaFin, boolean estado) {
        this.idReunion = idReunion;
        this.idProyecto = idProyecto;
        this.idTipoReunion = idTipoReunion;
        this.nombre = nombre;
        this.lugar = lugar;
        this.ambiente = ambiente;
        this.fechaIncio = fechaIncio;
        this.fechaFin = fechaFin;
        this.estado = estado;
    }

    public int getIdReunion() {
        return idReunion;
    }

    public void setIdReunion(int idReunion) {
        this.idReunion = idReunion;
    }

    public int getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }

    public int getIdTipoReunion() {
        return idTipoReunion;
    }

    public void setIdTipoReunion(int idTipoReunion) {
        this.idTipoReunion = idTipoReunion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(String ambiente) {
        this.ambiente = ambiente;
    }

    public Date getFechaIncio() {
        return fechaIncio;
    }

    public void setFechaIncio(Date fechaIncio) {
        this.fechaIncio = fechaIncio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    
}
