package com.app.modelo.vo;

public class TareaVO implements IreglasVO {

    private int idTarea;
    private int idProyecto;
    private String nombre;
    private String descripcion;
    private boolean estado;

    public TareaVO() {
    }

    public TareaVO(int idTarea, int idProyecto, String nombre, String descripcion, boolean estado) {
        this.idTarea = idTarea;
        this.idProyecto = idProyecto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

}
