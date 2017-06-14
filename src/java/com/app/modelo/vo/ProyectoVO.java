package com.app.modelo.vo;

import java.util.Date;

public class ProyectoVO implements IreglasVO {

    private int idProyecto;
    private int idFichas;
    private String nombreProyecto;
    private String descripcion;
    private Date fechaInicio;
    private Date fechaFin;
    private int porcentaje;
    private boolean estado;

    public ProyectoVO() {

    }

    public ProyectoVO(int idProyecto, int idFichas, String nombreProyecto, String descripcion, Date fechaInicio, Date fechaFin, int porcentaje, boolean estado) {
        this.idProyecto = idProyecto;
        this.idFichas = idFichas;
        this.nombreProyecto = nombreProyecto;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.porcentaje = porcentaje;
        this.estado = estado;
    }

    public int getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }

    public int getIdFichas() {
        return idFichas;
    }

    public void setIdFichas(int idFichas) {
        this.idFichas = idFichas;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

}
