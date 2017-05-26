package com.app.modelo.dto;

import com.app.modelo.vo.IreglasVO;
import com.app.modelo.vo.TipoUsuarioVO;
import com.app.modelo.vo.RolVO;

public class UsuarioRolDTO implements IreglasVO {

    TipoUsuarioVO tu;
    RolVO rv;

    public TipoUsuarioVO getTu() {
        return tu;
    }

    public void setTu(TipoUsuarioVO tu) {
        this.tu = tu;
    }

    public RolVO getRv() {
        return rv;
    }

    public void setRv(RolVO rv) {
        this.rv = rv;
    }

}
