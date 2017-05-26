
package com.app.modelo.vo;

public class TipoUsuarioVO implements IreglasVO{
    
    private int idTipoUsuario;
    private int tipoUsuario;
    private boolean estado;

    public TipoUsuarioVO() {
    }

    public TipoUsuarioVO(int idTipoUsuario, int tipoUsuario, boolean estado) {
        this.idTipoUsuario = idTipoUsuario;
        this.tipoUsuario = tipoUsuario;
        this.estado = estado;
    }

    public int getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(int idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    public int getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(int tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
}
