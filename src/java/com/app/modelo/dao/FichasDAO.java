package com.app.modelo.dao;

import com.app.modelo.dto.FichasProgramaDTO;
import com.app.modelo.vo.FichasVO;
import com.app.modelo.vo.ProgramaFormacionVO;
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

    public List<FichasProgramaDTO> ListarFichas() throws SQLException {

        CallableStatement procedure = this.cnn.prepareCall("{ call listarFichas ()}");
        ResultSet resultado = procedure.executeQuery();
        List<FichasProgramaDTO> lista = new ArrayList();
        while (resultado.next()) {
            FichasProgramaDTO fp = new FichasProgramaDTO();
            fp.setPf(new ProgramaFormacionVO());
            fp.setFv(new FichasVO());
            fp.getFv().setIdFichas(resultado.getInt("idFichas"));
            fp.getPf().setPrograma(resultado.getString("programa"));
            fp.getFv().setNumero(resultado.getString("numero"));
            fp.getFv().setFechaInicio(resultado.getDate("fechaIncio"));
            fp.getFv().setFechaFin(resultado.getDate("fechaFin"));
            lista.add(fp);
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
