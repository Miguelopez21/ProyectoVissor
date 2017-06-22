
package com.app.modelo.dto;

import com.app.modelo.vo.AsistenciaVO;
import com.app.modelo.vo.CompromisoVO;
import com.app.modelo.vo.DetalleVO;
import com.app.modelo.vo.IreglasVO;
import com.app.modelo.vo.ProyectoVO;
import com.app.modelo.vo.ReunionVO;
import com.app.modelo.vo.TipoReunionVO;
import com.app.modelo.vo.TrimestreVO;

public class ReunionDTO implements IreglasVO{
    
    ProyectoVO pv;
    TipoReunionVO tr;
    TrimestreVO tv;
    ReunionVO rv;
    AsistenciaVO av;
    DetalleVO dv;
    CompromisoVO cv;

    public ProyectoVO getPv() {
        return pv;
    }

    public void setPv(ProyectoVO pv) {
        this.pv = pv;
    }

    public TipoReunionVO getTr() {
        return tr;
    }

    public void setTr(TipoReunionVO tr) {
        this.tr = tr;
    }

    public TrimestreVO getTv() {
        return tv;
    }

    public void setTv(TrimestreVO tv) {
        this.tv = tv;
    }

    public ReunionVO getRv() {
        return rv;
    }

    public void setRv(ReunionVO rv) {
        this.rv = rv;
    }

    public AsistenciaVO getAv() {
        return av;
    }

    public void setAv(AsistenciaVO av) {
        this.av = av;
    }

    public DetalleVO getDv() {
        return dv;
    }

    public void setDv(DetalleVO dv) {
        this.dv = dv;
    }

    public CompromisoVO getCv() {
        return cv;
    }

    public void setCv(CompromisoVO cv) {
        this.cv = cv;
    }

    

}
