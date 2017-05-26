package com.app.modelo.dto;

import com.app.modelo.vo.IreglasVO;
import com.app.modelo.vo.UsuarioVO;
import com.app.modelo.vo.ProyectoVO;

public class ProyectoUsuarioDTO implements IreglasVO {

    UsuarioVO uv;
    ProyectoVO pv;

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

}
