package com.app.modelo.dao;

import com.app.modelo.vo.ProyectoVO;
import com.app.modelo.dto.ProyectoUsuarioDTO;
import com.app.modelo.vo.FichasVO;
import com.app.modelo.vo.ProgramaFormacionVO;
import com.app.modelo.vo.UsuarioVO;
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
        procedure.setInt(1, vo.getIdFichas());
        procedure.setString(2, vo.getNombreProyecto());
        procedure.setString(3, vo.getDescripcion());
        procedure.setDate(4, new Date(vo.getFechaInicio().getTime()));
        procedure.setDate(5, new Date(vo.getFechaFin().getTime()));
        ResultSet resultado = procedure.executeQuery();
        if (resultado.next()) {
            vo.setIdProyecto(resultado.getInt("idProyecto"));
            vo.setFechaInicio(resultado.getDate("fechaIncio"));
            vo.setFechaFin(resultado.getDate("fechaFin"));
        }
        return vo;

    }

    public ProyectoVO ModificarProyecto(ProyectoVO vo) throws SQLException {

        CallableStatement procedure = this.cnn.prepareCall("{ call modificarProyecto(?,?,?,?,?,?,?)}");
        int i = 1;
        procedure.setInt(i++, vo.getIdFichas());
        procedure.setString(i++, vo.getNombreProyecto());
        procedure.setString(i++, vo.getDescripcion());
        procedure.setDate(i++, new Date(vo.getFechaInicio().getTime()));
        procedure.setDate(i++, new Date(vo.getFechaFin().getTime()));
        procedure.setInt(i++, vo.getPorcentaje());
        procedure.setInt(i++, vo.getIdProyecto());
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

    public List<ProyectoUsuarioDTO> ListarProyecto() throws SQLException {

        ProyectoUsuarioDTO pu = new ProyectoUsuarioDTO();

        CallableStatement procedure = this.cnn.prepareCall("{ call listarProyecto ()}");
        ResultSet resultado = procedure.executeQuery();
        List<ProyectoUsuarioDTO> lista = new ArrayList();
        while (resultado.next()) {
            pu.setPv(new ProyectoVO());
            pu.setPf(new ProgramaFormacionVO());
            pu.setFv(new FichasVO());
            pu.getPv().setIdProyecto(resultado.getInt("idProyecto"));
            pu.getPf().setPrograma(resultado.getString("programa"));
            pu.getFv().setNumero(resultado.getString("numero"));
            pu.getPv().setNombreProyecto(resultado.getString("nombreProyecto"));
            pu.getPv().setFechaInicio(resultado.getDate("fechaInicio"));
            pu.getPv().setFechaFin(resultado.getDate("fechaFin"));
            pu.getPv().setPorcentaje(resultado.getInt("porcentaje"));
            lista.add(pu);
        }
        return lista;
    }

    public List<ProyectoUsuarioDTO> listarProyectoCreado(int idProyecto) throws SQLException {

        ProyectoUsuarioDTO pu = new ProyectoUsuarioDTO();

        CallableStatement procedure = this.cnn.prepareCall("{ call listarProyectoCreado (?)}");
        int i = 1;
        procedure.setInt(i++, idProyecto);
        ResultSet resultado = procedure.executeQuery();
        List<ProyectoUsuarioDTO> lista = new ArrayList();
        while (resultado.next()) {
            pu.setPv(new ProyectoVO());
            pu.setUv(new UsuarioVO());
            pu.getPv().setIdProyecto(resultado.getInt("idProyecto"));
            pu.getPv().setNombreProyecto(resultado.getString("nombreProyecto"));
            pu.getPv().setDescripcion(resultado.getString("descripcion"));
            pu.getPv().setFechaInicio(resultado.getDate("fechaInicio"));
            pu.getPv().setFechaFin(resultado.getDate("fechaFin"));
            pu.getPv().setPorcentaje(resultado.getInt("porcentaje"));
            pu.getPv().setEstado(resultado.getBoolean("estado"));
            pu.getUv().setIdUsuario(resultado.getInt("idUsuario"));
            pu.getUv().setNumeroIdentificacion(resultado.getInt("numeroIdentificacion"));
            pu.getUv().setNombres(resultado.getString("nombres"));
            pu.getUv().setPrimerApellido(resultado.getString("primerApellido"));
            lista.add(pu);
        }
        return lista;
    }

    public ProyectoUsuarioDTO UsuarioProyecto(ProyectoUsuarioDTO vo) throws SQLException {

        ProyectoUsuarioDTO pu = vo;

        CallableStatement procedure = this.cnn.prepareCall("{ call usuarioProyecto(?,?,?,?)}");
        procedure.setInt(1, pu.getUv().getIdUsuario());
        procedure.setInt(2, pu.getPv().getIdProyecto());
        procedure.setDate(3, new Date(pu.getPv().getFechaFin().getTime()));
        procedure.setDate(4, new Date(pu.getPv().getFechaFin().getTime()));
        procedure.execute();
        return vo;

    }

    public ProyectoUsuarioDTO eliminarUsuarioProyecto(ProyectoUsuarioDTO vo) throws SQLException {

        ProyectoUsuarioDTO pu = vo;

        CallableStatement procedure = this.cnn.prepareCall("{ call eliminarUsuarioProyecto(?,?)}");
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
