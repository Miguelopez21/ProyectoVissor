package com.app.modelo.dto;

import com.app.modelo.vo.FichasVO;
import com.app.modelo.vo.IreglasVO;
import com.app.modelo.vo.UsuarioVO;
import com.app.modelo.vo.ProyectoVO;

public class ProyectoUsuarioDTO implements IreglasVO {

    UsuarioVO uv;
    ProyectoVO pv;
    FichasVO fv;

    public UsuarioVO getUv() {
        return uv;
    }

    public void setUv(UsuarioVO uv) {
        this.uv = uv;
    }

    public ProyectoVO getPv() {
        return pv;
    }

    public void setPv(ProyectoVO pv) {
        this.pv = pv;
    }

    public FichasVO getFv() {
        return fv;
    }

    public void setFv(FichasVO fv) {
        this.fv = fv;
    }

   
}
