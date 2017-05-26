package com.app.modelo.vo;

public class AsistenciaVO implements IreglasVO {

    private int idAsistencia;
    private int idReunion;
    private String asistentes;
    private boolean estado;

    public AsistenciaVO() {
    }

    public AsistenciaVO(int idAsistencia, int idReunion, String asistentes, boolean estado) {
        this.idAsistencia = idAsistencia;
        this.idReunion = idReunion;
        this.asistentes = asistentes;
        this.estado = estado;
    }

    public int getIdAsistencia() {
        return idAsistencia;
    }

    public void setIdAsistencia(int idAsistencia) {
        this.idAsistencia = idAsistencia;
    }

    public int getIdReunion() {
        return idReunion;
    }

    public void setIdReunion(int idReunion) {
        this.idReunion = idReunion;
    }

    public String getAsistentes() {
        return asistentes;
    }

    public void setAsistentes(String asistentes) {
        this.asistentes = asistentes;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

}
