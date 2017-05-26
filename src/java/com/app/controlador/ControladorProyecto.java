package com.app.controlador;

import com.app.modelo.dao.ProyectoDAO;
import com.app.modelo.dto.ProyectoUsuarioDTO;
import com.app.modelo.vo.ProyectoVO;
import com.app.utils.enums.EErroresAplicacion;
import com.app.utils.exceptions.ProyectoException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ControladorProyecto extends ControladorGenerico<ProyectoDAO, ProyectoVO> {

    Connection cnn;

    public ControladorProyecto(Connection cnn) {
        dao = new ProyectoDAO(cnn);
        this.cnn = cnn;
    }

    public ProyectoVO crearProyecto(ProyectoVO vo) throws ProyectoException {

        try {
            ProyectoVO crearProyecto = dao.crearProyecto(vo);
            return crearProyecto;
        } catch (SQLException e) {
            ProyectoException prex = new ProyectoException(EErroresAplicacion.ERROR_INSERTAR, e);
            throw prex;
        }
    }

    public ProyectoVO modificarProyecto(ProyectoVO vo) throws ProyectoException {

        try {
            ProyectoVO modificarProyecto = dao.modificarProyecto(vo);
            return modificarProyecto;
        } catch (SQLException e) {
            ProyectoException prex = new ProyectoException(EErroresAplicacion.ERROR_MODIFICAR, e);
            throw prex;
        }
    }

    public ProyectoVO eliminarProyecto(ProyectoVO vo) throws ProyectoException {

        try {
            ProyectoVO eliminarProyecto = dao.eliminarProyecto(vo);
            return eliminarProyecto;
        } catch (SQLException e) {
            ProyectoException prex = new ProyectoException(EErroresAplicacion.ERROR_MODIFICAR, e);
            throw prex;
        }
    }

    public ProyectoVO habilitarProyecto(ProyectoVO vo) throws ProyectoException {

        try {
            ProyectoVO habilitarProyecto = dao.habilitarProyecto(vo);
            return habilitarProyecto;
        } catch (SQLException e) {
            ProyectoException prex = new ProyectoException(EErroresAplicacion.ERROR_MODIFICAR, e);
            throw prex;
        }
    }

    public ProyectoVO evaluarProyecto(ProyectoVO vo) throws ProyectoException {

        try {
            ProyectoVO evaluarProyecto = dao.evaluarProyecto(vo);
            return evaluarProyecto;
        } catch (SQLException e) {
            ProyectoException prex = new ProyectoException(EErroresAplicacion.ERROR_MODIFICAR, e);
            throw prex;
        }
    }

    public List<ProyectoVO> listarProyecto(ProyectoVO vo) throws ProyectoException {
        try {
            return dao.listarProyecto(vo.getIdProyecto());
        } catch (SQLException e) {
            throw new ProyectoException(EErroresAplicacion.ERROR_CONSULTAR, e);
        }
    }

    public List<ProyectoVO> listarProyectos(ProyectoVO vo) throws ProyectoException {
        try {
            return dao.listarProyectos(vo.getIdFichas());
        } catch (SQLException e) {
            throw new ProyectoException(EErroresAplicacion.ERROR_CONSULTAR, e);
        }
    }

    public ProyectoUsuarioDTO usuarioProyecto(ProyectoUsuarioDTO vo) throws ProyectoException {

        try {
            ProyectoUsuarioDTO usuarioProyecto = dao.usuarioProyecto(vo);
            return usuarioProyecto;
        } catch (SQLException e) {
            ProyectoException prex = new ProyectoException(EErroresAplicacion.ERROR_MODIFICAR, e);
            throw prex;
        }
    }

    public ProyectoUsuarioDTO usuarioEliminar(ProyectoUsuarioDTO vo) throws ProyectoException {

        try {
            ProyectoUsuarioDTO usuarioEliminar = dao.usuarioEliminar(vo);
            return usuarioEliminar;
        } catch (SQLException e) {
            ProyectoException prex = new ProyectoException(EErroresAplicacion.ERROR_MODIFICAR, e);
            throw prex;
        }
    }

}
