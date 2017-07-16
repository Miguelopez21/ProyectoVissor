package com.app.modelo.dao;

import com.app.modelo.dto.ReunionDTO;
import com.app.modelo.vo.AsistenciaVO;
import com.app.modelo.vo.CompromisoVO;
import com.app.modelo.vo.ReunionVO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReunionDAO implements IreglasDAO<ReunionVO> {

    Connection cnn;

    public ReunionDAO(Connection cnn) {
        this.cnn = cnn;
    }

    public ReunionDTO CrearReunion(ReunionDTO vo) throws SQLException {

        ReunionDTO rd = new ReunionDTO();

        CallableStatement procedure = this.cnn.prepareCall("{ call crearReunion (?,?,?,?,?,?,?,?)}");
        procedure.setInt(1, rd.getPv().getIdProyecto());
        procedure.setInt(2, rd.getTr().getIdTipoReunion());
        procedure.setInt(3, rd.getTv().getIdTrimestre());
        procedure.setString(4, rd.getRv().getNombre());
        procedure.setString(5, rd.getRv().getLugar());
        procedure.setString(6, rd.getRv().getAmbiente());
        procedure.setDate(7, (Date) rd.getRv().getFechaIncio());
        procedure.setDate(8, (Date) rd.getRv().getFechaIncio());
        ResultSet resultado = procedure.executeQuery();
        if (resultado.next()) {
            rd.setRv(new ReunionVO());
            rd.getRv().setIdReunion(resultado.getInt("idReunion"));
        }

        return vo;

    }

    public ReunionDTO CrearAsistentes(ReunionDTO vo) throws SQLException {

        ReunionDTO rd = new ReunionDTO();

        CallableStatement procedure = this.cnn.prepareCall("{ call crearAsistencia (?,?)}");
        procedure.setInt(1, rd.getAv().getIdReunion());
        procedure.setString(2, rd.getAv().getAsistentes());
        procedure.execute();
        return vo;

    }

    public ReunionDTO CrearDetalle(ReunionDTO vo) throws SQLException {

        ReunionDTO rd = new ReunionDTO();

        CallableStatement procedure = this.cnn.prepareCall("{ call crearDetalle (?,?,?)}");
        procedure.setInt(1, rd.getDv().getIdReunion());
        procedure.setString(2, rd.getDv().getDetalle());
        procedure.setString(3, rd.getDv().getDescripcion());
        procedure.execute();
        return vo;

    }

    public ReunionDTO CrearCompromiso(ReunionDTO vo) throws SQLException {

        ReunionDTO rd = new ReunionDTO();

        CallableStatement procedure = this.cnn.prepareCall("{ call crearCompromiso (?,?,?)}");
        procedure.setInt(1, rd.getCv().getIdReunion());
        procedure.setString(2, rd.getCv().getDescripcion());
        procedure.setString(3, rd.getCv().getUrl());
        procedure.execute();
        return vo;

    }

    public ReunionDTO EliminarAsistencia(ReunionDTO vo) throws SQLException {

        ReunionDTO rd = new ReunionDTO();

        CallableStatement procedure = this.cnn.prepareCall("{ call eliminarAsistencia (?)}");
        procedure.setInt(1, rd.getAv().getIdAsistencia());
        procedure.execute();
        return vo;
    }

    public ReunionDTO EliminarReunion(ReunionDTO vo) throws SQLException {

        ReunionDTO rd = new ReunionDTO();

        CallableStatement procedure = this.cnn.prepareCall("{ call eliminarReunion (?)}");
        procedure.setInt(1, rd.getRv().getIdProyecto());
        procedure.execute();
        return vo;
    }

    public List<ReunionDTO> ListarCompromisos() throws SQLException {

        ReunionDTO rd = new ReunionDTO();

        CallableStatement procedure = this.cnn.prepareCall("{ call listarCompromisos (?,?)}");
        procedure.setInt(1, rd.getCv().getIdCompromiso());
        procedure.setInt(2, rd.getCv().getIdReunion());
        ResultSet resultado = procedure.executeQuery();
        List<ReunionDTO> lista = new ArrayList();
        while (resultado.next()) {
            rd.setCv(new CompromisoVO());
            rd.getCv().setIdCompromiso(resultado.getInt("idcompromiso"));
            rd.getCv().setDescripcion(resultado.getString("descripcion"));
            rd.getCv().setUrl(resultado.getString("url"));
            lista.add(rd);
        }
        return lista;
    }

    public List<ReunionDTO> listarReunionCreada() throws SQLException {

        ReunionDTO rd = new ReunionDTO();

        CallableStatement procedure = this.cnn.prepareCall("{ call listarReunionCreada ()}");
        ResultSet resultado = procedure.executeQuery();
        List<ReunionDTO> lista = new ArrayList();
        while (resultado.next()) {
            rd.setRv(new ReunionVO());
            rd.getRv().setIdReunion(resultado.getInt("idReunion"));
            rd.getRv().setNombre(resultado.getString("nombre"));
            rd.getRv().setLugar(resultado.getString("lugar"));
            rd.getRv().setAmbiente(resultado.getString("ambiente"));
            rd.getRv().setFechaIncio(resultado.getDate("fechaIncio"));
            rd.getRv().setFechaFin(resultado.getDate("fechaFin"));
            lista.add(rd);
        }
        return lista;
    }

    public ReunionDTO ModificarReunion(ReunionDTO vo) throws SQLException {

        ReunionDTO pu = vo;
        
        CallableStatement procedure = this.cnn.prepareCall("{ call modificarReunion(?,?,?,?,?,?)}");
        int i = 1;
        procedure.setString(i++, pu.getRv().getNombre());
        procedure.setString(i++, pu.getRv().getLugar());
        procedure.setString(i++, pu.getRv().getAmbiente());
        procedure.setDate(i++, new Date(pu.getRv().getFechaIncio().getTime()));
        procedure.setDate(i++, new Date(pu.getRv().getFechaFin().getTime()));
        procedure.setInt(i++, pu.getRv().getIdReunion());
        procedure.execute();
        return vo;
    }
    
      public List<ReunionDTO> listarAsistentes(int idAsistentes) throws SQLException {

        ReunionDTO rd = new ReunionDTO();
        
        CallableStatement procedure = this.cnn.prepareCall("{ call listarAsistentes (?)}");
        procedure.setInt(1, idAsistentes);
        ResultSet resultado = procedure.executeQuery();
        List<ReunionDTO> lista = new ArrayList();
        while (resultado.next()) {
            rd.setAv(new AsistenciaVO());
            rd.getAv().setIdAsistencia(resultado.getInt("idAsistencia"));
            rd.getAv().setAsistentes(resultado.getString("asistentes"));
            rd.getAv().setEstado(resultado.getBoolean("estado"));
            lista.add(rd);
        }
        return lista;
    }
    
    
    @Override
    public void Insertar(ReunionVO vo) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Modificar(ReunionVO vo) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Eliminar(ReunionVO vo) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Consultar(ReunionVO vo) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ReunionVO> Consultar() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ReunionVO Consultar(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
