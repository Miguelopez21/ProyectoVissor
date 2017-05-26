package com.app.modelo.vo;

public class CompromisoVO implements IreglasVO {

    private int idCompromiso;
    private int idReunion;
    private String descripcion;
    private String url;
    private boolean estado;

    public CompromisoVO() {
    }

    public CompromisoVO(int idCompromiso, int idReunion, String descripcion, String url, boolean estado) {
        this.idCompromiso = idCompromiso;
        this.idReunion = idReunion;
        this.descripcion = descripcion;
        this.url = url;
        this.estado = estado;
    }

    public int getIdCompromiso() {
        return idCompromiso;
    }

    public void setIdCompromiso(int idCompromiso) {
        this.idCompromiso = idCompromiso;
    }

    public int getIdReunion() {
        return idReunion;
    }

    public void setIdReunion(int idReunion) {
        this.idReunion = idReunion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

}
