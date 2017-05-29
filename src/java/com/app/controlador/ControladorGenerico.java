package com.app.controlador;

import com.app.modelo.vo.IreglasVO;
import com.app.modelo.dao.IreglasDAO;
import com.app.utils.enums.EErroresAplicacion;
import com.app.utils.exceptions.ProyectoException;
import java.sql.SQLException;
import java.util.List;

public class ControladorGenerico<DAO extends IreglasDAO, VO extends IreglasVO> {

    DAO dao;

    public void Insertar(VO vo) throws ProyectoException {

        try {
            dao.Insertar(vo);
        } catch (SQLException e) {
            ProyectoException excep = new ProyectoException(EErroresAplicacion.ERROR_INSERTAR, e);
            throw excep;
        }

    }

    public void Modificar(VO vo) throws ProyectoException {
        try {
            dao.Modificar(vo);
        } catch (SQLException ex) {
            ProyectoException excep = new ProyectoException(EErroresAplicacion.ERROR_MODIFICAR, ex);
            throw excep;
        }
    }

    public void Eliminar(VO vo) throws ProyectoException {
        try {
            dao.Modificar(vo);
        } catch (SQLException ex) {
            ProyectoException excep = new ProyectoException(EErroresAplicacion.ERROR_MODIFICAR, ex);
            throw excep;
        }
    }

    public void Consultar(VO vo) throws ProyectoException {
        try {
            dao.Consultar(vo);
        } catch (SQLException ex) {
            ProyectoException excep = new ProyectoException(EErroresAplicacion.ERROR_CONSULTAR, ex);
            throw excep;
        }
    }
    
     public VO Consultar(int id) throws ProyectoException {
        try {
            dao.Consultar(id);
        } catch (SQLException ex) {
            ProyectoException excep = new ProyectoException(EErroresAplicacion.ERROR_CONSULTAR, ex);
            throw excep;
        }
        return null;
    }

    public List<VO> Consultar() throws ProyectoException {
        try {
            return dao.Consultar();
        } catch (SQLException ex) {
            ProyectoException excep = new ProyectoException(EErroresAplicacion.ERROR_CONSULTAR, ex);
            throw excep;
        }
    }

}
