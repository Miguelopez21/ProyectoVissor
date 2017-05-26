package com.app.controlador;

import com.app.modelo.vo.IreglasVO;
import com.app.modelo.dao.IreglasDAO;
import com.app.utils.enums.EErroresAplicacion;
import com.app.utils.exceptions.ProyectoException;
import java.sql.SQLException;
import java.util.List;

public class ControladorGenerico<DAO extends IreglasDAO, VO extends IreglasVO> {

    DAO dao;

    public void insertar(VO vo) throws ProyectoException {

        try {
            dao.insertar(vo);
        } catch (SQLException e) {
            ProyectoException excep = new ProyectoException(EErroresAplicacion.ERROR_INSERTAR, e);
            throw excep;
        }

    }

    public void modificar(VO vo) throws ProyectoException {
        try {
            dao.modificar(vo);
        } catch (SQLException ex) {
            ProyectoException excep = new ProyectoException(EErroresAplicacion.ERROR_MODIFICAR, ex);
            throw excep;
        }
    }

    public void eliminar(VO vo) throws ProyectoException {
        try {
            dao.modificar(vo);
        } catch (SQLException ex) {
            ProyectoException excep = new ProyectoException(EErroresAplicacion.ERROR_MODIFICAR, ex);
            throw excep;
        }
    }

    public void consultar(VO vo) throws ProyectoException {
        try {
            dao.consultar(vo);
        } catch (SQLException ex) {
            ProyectoException excep = new ProyectoException(EErroresAplicacion.ERROR_CONSULTAR, ex);
            throw excep;
        }
    }
    
     public VO consultar(int id) throws ProyectoException {
        try {
            dao.consultar(id);
        } catch (SQLException ex) {
            ProyectoException excep = new ProyectoException(EErroresAplicacion.ERROR_CONSULTAR, ex);
            throw excep;
        }
        return null;
    }

    public List<VO> consultar() throws ProyectoException {
        try {
            return dao.consultar();
        } catch (SQLException ex) {
            ProyectoException excep = new ProyectoException(EErroresAplicacion.ERROR_CONSULTAR, ex);
            throw excep;
        }
    }

}
