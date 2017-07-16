package com.app.controlador;

import com.app.modelo.dao.ReunionDAO;
import com.app.modelo.dto.ReunionDTO;
import com.app.modelo.vo.ReunionVO;
import com.app.utils.enums.EErroresAplicacion;
import com.app.utils.exceptions.ProyectoException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ControladorReunion extends ControladorGenerico<ReunionDAO, ReunionVO> {

    Connection cnn;

    public ControladorReunion(Connection cnn) {
        dao = new ReunionDAO(cnn);
        this.cnn = cnn;
    }

    public ReunionDTO CrearReunion(ReunionDTO vo) throws ProyectoException {

        try {
            ReunionDTO CrearReunion = dao.CrearReunion(vo);
            return CrearReunion;
        } catch (SQLException e) {
            ProyectoException prex = new ProyectoException(EErroresAplicacion.ERROR_INSERTAR, e);
            throw prex;
        }
    }

    public ReunionDTO CrearAsistentes(ReunionDTO vo) throws ProyectoException {

        try {
            ReunionDTO CrearAsistentes = dao.CrearAsistentes(vo);
            return CrearAsistentes;
        } catch (SQLException e) {
            ProyectoException prex = new ProyectoException(EErroresAplicacion.ERROR_INSERTAR, e);
            throw prex;
        }
    }

    public ReunionDTO CrearDetalle(ReunionDTO vo) throws ProyectoException {

        try {
            ReunionDTO CrearDetalle = dao.CrearDetalle(vo);
            return CrearDetalle;
        } catch (SQLException e) {
            ProyectoException prex = new ProyectoException(EErroresAplicacion.ERROR_INSERTAR, e);
            throw prex;
        }
    }

    public ReunionDTO CrearCompromiso(ReunionDTO vo) throws ProyectoException {

        try {
            ReunionDTO CrearCompromiso = dao.CrearCompromiso(vo);
            return CrearCompromiso;
        } catch (SQLException e) {
            ProyectoException prex = new ProyectoException(EErroresAplicacion.ERROR_INSERTAR, e);
            throw prex;
        }
    }

    public ReunionDTO EliminarAsistencia(ReunionDTO vo) throws ProyectoException {

        try {
            ReunionDTO EliminarAsistencia = dao.EliminarAsistencia(vo);
            return EliminarAsistencia;
        } catch (SQLException e) {
            ProyectoException prex = new ProyectoException(EErroresAplicacion.ERROR_MODIFICAR, e);
            throw prex;
        }
    }

    public ReunionDTO EliminarReunion(ReunionDTO vo) throws ProyectoException {

        try {
            ReunionDTO EliminarReunion = dao.EliminarReunion(vo);
            return EliminarReunion;
        } catch (SQLException e) {
            ProyectoException prex = new ProyectoException(EErroresAplicacion.ERROR_MODIFICAR, e);
            throw prex;
        }
    }

    public List<ReunionDTO> ListarCompromisos(ReunionDTO vo) throws ProyectoException {
        try {
            return dao.ListarCompromisos();
        } catch (SQLException e) {
            throw new ProyectoException(EErroresAplicacion.ERROR_CONSULTAR, e);
        }
    }

    public List<ReunionDTO> listarReunionCreada(ReunionDTO vo) throws ProyectoException {
        try {
            return dao.listarReunionCreada();
        } catch (SQLException e) {
            throw new ProyectoException(EErroresAplicacion.ERROR_CONSULTAR, e);
        }
    }
    
     public List<ReunionDTO> listarAsistentes(ReunionDTO vo) throws ProyectoException {
        try {
            return dao.listarAsistentes(vo.getRv().getIdReunion());
        } catch (SQLException e) {
            throw new ProyectoException(EErroresAplicacion.ERROR_CONSULTAR, e);
        }
    }
    
       public ReunionDTO ModificarReunion(ReunionDTO vo) throws ProyectoException {

        try {
            ReunionDTO ModificarReunion = dao.ModificarReunion(vo);
            return ModificarReunion;
        } catch (SQLException e) {
            ProyectoException prex = new ProyectoException(EErroresAplicacion.ERROR_MODIFICAR, e);
            throw prex;
        }
    }

}
