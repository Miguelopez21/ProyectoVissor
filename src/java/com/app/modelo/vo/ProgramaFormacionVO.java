package com.app.modelo.vo;

public class ProgramaFormacionVO implements IreglasVO {

    private int idProgramaFormacion;
    private String programa;
    private Boolean estado;

    public ProgramaFormacionVO() {
    }

    public ProgramaFormacionVO(int idProgramaFormacion, String programa, Boolean estado) {
        this.idProgramaFormacion = idProgramaFormacion;
        this.programa = programa;
        this.estado = estado;
    }

    public int getIdProgramaFormacion() {
        return idProgramaFormacion;
    }

    public void setIdProgramaFormacion(int idProgramaFormacion) {
        this.idProgramaFormacion = idProgramaFormacion;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

}
