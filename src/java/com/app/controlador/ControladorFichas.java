
package com.app.controlador;

import com.app.modelo.dao.FichasDAO;
import com.app.modelo.vo.FichasVO;
import com.app.utils.enums.EErroresAplicacion;
import com.app.utils.exceptions.ProyectoException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ControladorFichas extends ControladorGenerico<FichasDAO,FichasVO>{
    
    Connection cnn;

    public ControladorFichas(Connection cnn) {
        dao = new FichasDAO(cnn);
        this.cnn = cnn;
    }
    
    public List<FichasVO> FiltrarFichas(FichasVO vo) throws ProyectoException {
        try {
            return dao.FiltrarFichas();
        } catch (SQLException e) {
            throw new ProyectoException(EErroresAplicacion.ERROR_CONSULTAR, e);
        }
    }
}
