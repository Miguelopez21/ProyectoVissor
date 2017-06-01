
package com.app.modelo.dto;

import com.app.modelo.vo.FichasVO;
import com.app.modelo.vo.IreglasVO;
import com.app.modelo.vo.ProgramaFormacionVO;

public class FichasProgramaDTO implements IreglasVO{
    
    FichasVO fv;
    ProgramaFormacionVO pf;

    public FichasVO getFv() {
        return fv;
    }

    public void setFv(FichasVO fv) {
        this.fv = fv;
    }

    public ProgramaFormacionVO getPf() {
        return pf;
    }

    public void setPf(ProgramaFormacionVO pf) {
        this.pf = pf;
    }
    
}
