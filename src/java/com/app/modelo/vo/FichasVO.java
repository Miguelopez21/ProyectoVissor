package com.app.modelo.vo;

import java.util.Date;

public class FichasVO implements IreglasVO {

    private int idFichas;
    private int idProgramaFormacion;
    private int numero;
    private Date fechaInicio;
    private Date fechaFin;
    private boolean estado;

    public FichasVO() {
    }

    public FichasVO(int idFichas, int idProgramaFormacion, int numero, Date fechaInicio, Date fechaFin, boolean estado) {
        this.idFichas = idFichas;
        this.idProgramaFormacion = idProgramaFormacion;
        this.numero = numero;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = estado;
    }

    public int getIdFichas() {
        return idFichas;
    }

    public void setIdFichas(int idFichas) {
        this.idFichas = idFichas;
    }

    public int getIdProgramaFormacion() {
        return idProgramaFormacion;
    }

    public void setIdProgramaFormacion(int idProgramaFormacion) {
        this.idProgramaFormacion = idProgramaFormacion;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
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

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

}
