package com.app.modelo.dao;

import com.app.modelo.vo.ProyectoVO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProyectoDAO implements IrreglasDAO<ProyectoVO> {

    Connection cnn;

    public ProyectoDAO(Connection cnn) {
        this.cnn = cnn;
    }

    public ProyectoVO crearProyecto(ProyectoVO vo) throws SQLException {

        CallableStatement procedure = this.cnn.prepareCall("{ call crearProyecto(?,?,?,?,?)}");
        int i = 1;
        procedure.setInt(i++, vo.getIdFichas());
        procedure.setString(i++, vo.getNombreProyecto());
        procedure.setString(i++, vo.getDescripcion());
        procedure.setDate(i++, new Date(vo.getFechaInicio().getTime()));
        procedure.setDate(i++, new Date(vo.getFechaFin().getTime()));
        ResultSet resultado = procedure.executeQuery();
        if (resultado.next()) {
            vo.setIdProyecto(resultado.getInt("idProyecto"));
        }
        return vo;

    }

    public ProyectoVO modificarProyecto(ProyectoVO vo) throws SQLException {

        CallableStatement procedure = this.cnn.prepareCall("{ call modificarProyecto(?,?,?,?,?,?)}");
        int i = 1;
        procedure.setInt(i++, vo.getIdProyecto());
        procedure.setInt(i++, vo.getIdFichas());
        procedure.setString(i++, vo.getNombreProyecto());
        procedure.setString(i++, vo.getDescripcion());
        procedure.setDate(i++, new Date(vo.getFechaInicio().getTime()));
        procedure.setDate(i++, new Date(vo.getFechaFin().getTime()));
        procedure.execute();
        return vo;

    }

    public ProyectoVO eliminarProyecto(ProyectoVO vo) throws SQLException {

        CallableStatement procedure = this.cnn.prepareCall("{ call eliminarProyecto(?)}");
        int i = 1;
        procedure.setInt(i++, vo.getIdProyecto());
        procedure.execute();
        return vo;

    }

    public ProyectoVO habilitarProyecto(ProyectoVO vo) throws SQLException {

        CallableStatement procedure = this.cnn.prepareCall("{ call habilitarProyecto(?)}");
        int i = 1;
        procedure.setInt(i++, vo.getIdProyecto());
        procedure.execute();
        return vo;

    }

    public ProyectoVO evaluarProyecto(ProyectoVO vo) throws SQLException {

        CallableStatement procedure = this.cnn.prepareCall("{ call evaluarProyecto(?,?)}");
        int i = 1;
        procedure.setInt(i++, vo.getIdProyecto());
        procedure.setInt(i++, vo.getPorcentaje());
        procedure.execute();
        return vo;

    }

    public List<ProyectoVO> listarProyecto(int idProyecto) throws SQLException {

        CallableStatement procedure = this.cnn.prepareCall("{ call listarProyecto (?)}");
        int i = 1;
        procedure.setInt(i++, idProyecto);
        ResultSet resultado = procedure.executeQuery();
        List<ProyectoVO> lista = new ArrayList();
        while (resultado.next()) {
            ProyectoVO vo = new ProyectoVO();
            vo.setIdProyecto(resultado.getInt("idProyecto"));
            vo.setIdFichas(resultado.getInt("idFichas"));
            vo.setNombreProyecto(resultado.getString("nombreProyecto"));
            vo.setDescripcion(resultado.getString("descripcion"));
            vo.setFechaInicio(resultado.getDate("fechaInicio"));
            vo.setFechaFin(resultado.getDate("fechaFin"));
            vo.setEstado(resultado.getBoolean("estado"));
            lista.add(vo);
        }
        return lista;
    }
    
    public List<ProyectoVO> listarProyectos(int idFichas) throws SQLException {

        CallableStatement procedure = this.cnn.prepareCall("{ call listarProyectos (?)}");
        int i = 1;
        procedure.setInt(i++, idFichas);
        ResultSet resultado = procedure.executeQuery();
        List<ProyectoVO> lista = new ArrayList();
        while (resultado.next()) {
            ProyectoVO vo = new ProyectoVO();
            vo.setIdProyecto(resultado.getInt("idProyecto"));
            vo.setNombreProyecto(resultado.getString("nombreProyecto"));
            vo.setFechaInicio(resultado.getDate("fechaInicio"));
            vo.setFechaFin(resultado.getDate("fechaFin"));
            vo.setEstado(resultado.getBoolean("estado"));
            lista.add(vo);
        }
        return lista;
    }

    @Override
    public void modificar(ProyectoVO vo) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(ProyectoVO vo) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void consultar(ProyectoVO vo) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ProyectoVO> consultar() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertar(ProyectoVO vo) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ProyectoVO consultar(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}