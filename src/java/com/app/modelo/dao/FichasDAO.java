package com.app.modelo.dao;

import com.app.modelo.vo.FichasVO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FichasDAO implements IreglasDAO<FichasVO> {

    Connection cnn;

    public FichasDAO(Connection cnn) {
        this.cnn = cnn;
    }

    public List<FichasVO> FiltrarFichas() throws SQLException {

        FichasVO vo = new FichasVO();
        CallableStatement procedure = this.cnn.prepareCall("{ call filtrarFichas (?)}");
        int i = 1;
        procedure.setString(i++, vo.getNumero());
        ResultSet resultado = procedure.executeQuery();
        List<FichasVO> lista = new ArrayList();
        while (resultado.next()) {
            vo.setIdFichas(resultado.getInt("idFichas"));
            vo.setIdProgramaFormacion(resultado.getInt("idProgramaFormacion"));
            vo.setNumero(resultado.getString("numero"));
            vo.setFechaInicio(resultado.getDate("fechainicio"));
            vo.setFechaFin(resultado.getDate("fechafin"));
            vo.setEstado(resultado.getBoolean("estado"));
            lista.add(vo);
        }
        return lista;
    }

    @Override
    public void Insertar(FichasVO vo) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Modificar(FichasVO vo) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Eliminar(FichasVO vo) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Consultar(FichasVO vo) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<FichasVO> Consultar() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public FichasVO Consultar(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
