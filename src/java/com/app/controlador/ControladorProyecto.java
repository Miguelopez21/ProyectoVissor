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

    public ProyectoVO CrearProyecto(ProyectoVO vo) throws ProyectoException {

        try {
            ProyectoVO crearProyecto = dao.CrearProyecto(vo);
            return crearProyecto;
        } catch (SQLException e) {
            ProyectoException prex = new ProyectoException(EErroresAplicacion.ERROR_INSERTAR, e);
            throw prex;
        }
    }

    public ProyectoVO ModificarProyecto(ProyectoVO vo) throws ProyectoException {

        try {
            ProyectoVO modificarProyecto = dao.ModificarProyecto(vo);
            return modificarProyecto;
        } catch (SQLException e) {
            ProyectoException prex = new ProyectoException(EErroresAplicacion.ERROR_MODIFICAR, e);
            throw prex;
        }
    }

    public ProyectoVO EliminarProyecto(ProyectoVO vo) throws ProyectoException {

        try {
            ProyectoVO eliminarProyecto = dao.EliminarProyecto(vo);
            return eliminarProyecto;
        } catch (SQLException e) {
            ProyectoException prex = new ProyectoException(EErroresAplicacion.ERROR_MODIFICAR, e);
            throw prex;
        }
    }

    public ProyectoVO HabilitarProyecto(ProyectoVO vo) throws ProyectoException {

        try {
            ProyectoVO habilitarProyecto = dao.HabilitarProyecto(vo);
            return habilitarProyecto;
        } catch (SQLException e) {
            ProyectoException prex = new ProyectoException(EErroresAplicacion.ERROR_MODIFICAR, e);
            throw prex;
        }
    }

    public ProyectoVO EvaluarProyecto(ProyectoVO vo) throws ProyectoException {

        try {
            ProyectoVO evaluarProyecto = dao.EvaluarProyecto(vo);
            return evaluarProyecto;
        } catch (SQLException e) {
            ProyectoException prex = new ProyectoException(EErroresAplicacion.ERROR_MODIFICAR, e);
            throw prex;
        }
    }

    public List<ProyectoVO> ListarProyecto(ProyectoVO vo) throws ProyectoException {
        try {
            return dao.ListarProyecto(vo.getIdProyecto());
        } catch (SQLException e) {
            throw new ProyectoException(EErroresAplicacion.ERROR_CONSULTAR, e);
        }
    }

    public List<ProyectoVO> ListarProyectos(ProyectoVO vo) throws ProyectoException {
        try {
            return dao.ListarProyectos(vo.getIdFichas());
        } catch (SQLException e) {
            throw new ProyectoException(EErroresAplicacion.ERROR_CONSULTAR, e);
        }
    }

    public ProyectoUsuarioDTO UsuarioProyecto(ProyectoUsuarioDTO vo) throws ProyectoException {

        try {
            ProyectoUsuarioDTO usuarioProyecto = dao.UsuarioProyecto(vo);
            return usuarioProyecto;
        } catch (SQLException e) {
            ProyectoException prex = new ProyectoException(EErroresAplicacion.ERROR_MODIFICAR, e);
            throw prex;
        }
    }

    public ProyectoUsuarioDTO UsuarioEliminar(ProyectoUsuarioDTO vo) throws ProyectoException {

        try {
            ProyectoUsuarioDTO usuarioEliminar = dao.UsuarioEliminar(vo);
            return usuarioEliminar;
        } catch (SQLException e) {
            ProyectoException prex = new ProyectoException(EErroresAplicacion.ERROR_MODIFICAR, e);
            throw prex;
        }
    }

}
