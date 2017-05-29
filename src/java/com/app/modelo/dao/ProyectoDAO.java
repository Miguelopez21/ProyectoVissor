package com.app.modelo.dao;

import com.app.modelo.vo.ProyectoVO;
import com.app.modelo.dto.ProyectoUsuarioDTO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProyectoDAO implements IreglasDAO<ProyectoVO> {

    Connection cnn;

    public ProyectoDAO(Connection cnn) {
        this.cnn = cnn;
    }

    public ProyectoVO CrearProyecto(ProyectoVO vo) throws SQLException {

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

    public ProyectoVO ModificarProyecto(ProyectoVO vo) throws SQLException {

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

    public ProyectoVO EliminarProyecto(ProyectoVO vo) throws SQLException {

        CallableStatement procedure = this.cnn.prepareCall("{ call eliminarProyecto(?)}");
        int i = 1;
        procedure.setInt(i++, vo.getIdProyecto());
        procedure.execute();
        return vo;

    }

    public ProyectoVO HabilitarProyecto(ProyectoVO vo) throws SQLException {

        CallableStatement procedure = this.cnn.prepareCall("{ call habilitarProyecto(?)}");
        int i = 1;
        procedure.setInt(i++, vo.getIdProyecto());
        procedure.execute();
        return vo;

    }

    public ProyectoVO EvaluarProyecto(ProyectoVO vo) throws SQLException {

        CallableStatement procedure = this.cnn.prepareCall("{ call evaluarProyecto(?,?)}");
        int i = 1;
        procedure.setInt(i++, vo.getIdProyecto());
        procedure.setInt(i++, vo.getPorcentaje());
        procedure.execute();
        return vo;

    }

    public List<ProyectoVO> ListarProyecto(int idProyecto) throws SQLException {

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

    public List<ProyectoVO> ListarProyectos(int idFichas) throws SQLException {

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

    public ProyectoUsuarioDTO UsuarioProyecto(ProyectoUsuarioDTO vo) throws SQLException {

        ProyectoUsuarioDTO pu = vo;

        CallableStatement procedure = this.cnn.prepareCall("{ call usuarioProyecto(?,?,?,?)}");
        int i = 1;
        procedure.setInt(i++, pu.getUv().getIdUsuario());
        procedure.setInt(i++, pu.getPv().getIdProyecto());
        procedure.setDate(i++, new Date(pu.getPv().getFechaFin().getTime()));
        procedure.setDate(i++, new Date(pu.getPv().getFechaFin().getTime()));
        procedure.execute();
        return vo;

    }

    public ProyectoUsuarioDTO UsuarioEliminar(ProyectoUsuarioDTO vo) throws SQLException {

        ProyectoUsuarioDTO pu = vo;

        CallableStatement procedure = this.cnn.prepareCall("{ call usuarioEliminar(?,?)}");
        int i = 1;
        procedure.setInt(i++, pu.getUv().getIdUsuario());
        procedure.setInt(i++, pu.getPv().getIdProyecto());
        procedure.execute();
        return vo;

    }

    @Override
    public void Modificar(ProyectoVO vo) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Eliminar(ProyectoVO vo) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Consultar(ProyectoVO vo) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ProyectoVO> Consultar() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Insertar(ProyectoVO vo) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ProyectoVO Consultar(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
