package com.app.modelo.vo;

public class TipoDocumentoVO implements IreglasVO {

    private int idTipoDocumento;
    private int tipoDocumento;
    private boolean descripcion;

    public TipoDocumentoVO() {
    }

    public TipoDocumentoVO(int idTipoDocumento, int tipoDocumento, boolean descripcion) {
        this.idTipoDocumento = idTipoDocumento;
        this.tipoDocumento = tipoDocumento;
        this.descripcion = descripcion;
    }

    public int getIdTipoDocumento() {
        return idTipoDocumento;
    }

    public void setIdTipoDocumento(int idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }

    public int getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(int tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public boolean isDescripcion() {
        return descripcion;
    }

    public void setDescripcion(boolean descripcion) {
        this.descripcion = descripcion;
    }

}
