package com.app.modelo.vo;

public class EntregablesVO implements IreglasVO {

    private int idEntregables;
    private int idTarea;
    private int idProyecto;
    private String url;
    private int porcentaje;
    private boolean estado;

    public EntregablesVO() {
    }

    public EntregablesVO(int idEntregables, int idTarea, int idProyecto, String url, int porcentaje, boolean estado) {
        this.idEntregables = idEntregables;
        this.idTarea = idTarea;
        this.idProyecto = idProyecto;
        this.url = url;
        this.porcentaje = porcentaje;
        this.estado = estado;
    }

    public int getIdEntregables() {
        return idEntregables;
    }

    public void setIdEntregables(int idEntregables) {
        this.idEntregables = idEntregables;
    }

    public int getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(int idTarea) {
        this.idTarea = idTarea;
    }

    public int getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
