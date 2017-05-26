package com.app.modelo.vo;

public class UsuarioVO implements IreglasVO {

    private int idUsuario;
    private int idTipoUsuario;
    private int idTipoDocumento;
    private String correoSena;
    private String contraseña;
    private int numeroIdentificacion;
    private String nombres;
    private String primerApellido;
    private String segundoApellido;
    private String direccion;
    private int telefono;
    private boolean estado;

    public UsuarioVO() {
    }

    public UsuarioVO(int idUsuario, int idTipoUsuario, int idTipoDocumento, String correoSena, String contraseña, int numeroIdentificacion, String nombres, String primerApellido, String segundoApellido, String direccion, int telefono, boolean estado) {
        this.idUsuario = idUsuario;
        this.idTipoUsuario = idTipoUsuario;
        this.idTipoDocumento = idTipoDocumento;
        this.correoSena = correoSena;
        this.contraseña = contraseña;
        this.numeroIdentificacion = numeroIdentificacion;
        this.nombres = nombres;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.estado = estado;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(int idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    public int getIdTipoDocumento() {
        return idTipoDocumento;
    }

    public void setIdTipoDocumento(int idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }

    public String getCorreoSena() {
        return correoSena;
    }

    public void setCorreoSena(String correoSena) {
        this.correoSena = correoSena;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public int getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(int numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

}
