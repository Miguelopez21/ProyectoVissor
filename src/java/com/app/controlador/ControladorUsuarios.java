package com.app.controlador;

import com.app.modelo.dao.UsuarioDAO;
import com.app.modelo.vo.UsuarioVO;
import com.app.utils.enums.EErroresAplicacion;
import com.app.utils.exceptions.ProyectoException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ControladorUsuarios extends ControladorGenerico<UsuarioDAO, UsuarioVO> {

    Connection cnn;

    public ControladorUsuarios(Connection cnn) {
        dao = new UsuarioDAO(cnn);
        this.cnn = cnn;
    }

    public List<UsuarioVO> listarAprendices(UsuarioVO vo) throws ProyectoException, SQLException {

        try {
            return dao.listarAprendices(vo);
        } catch (SQLException e) {
            throw new ProyectoException(EErroresAplicacion.ERROR_CONSULTAR, e);
        }
    }
}
