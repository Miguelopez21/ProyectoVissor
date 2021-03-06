/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.modelo.dao;

import com.app.modelo.vo.UsuarioVO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO implements IreglasDAO<UsuarioVO> {

    Connection cnn;

    public UsuarioDAO(Connection cnn) {
        this.cnn = cnn;
    }

    public List<UsuarioVO> listarAprendices() throws SQLException {

        CallableStatement procedure = this.cnn.prepareCall("{ call listarAprendices ()}");
        ResultSet resultado = procedure.executeQuery();
        List<UsuarioVO> lista = new ArrayList();
        while (resultado.next()) {
            UsuarioVO us = new UsuarioVO();
            us.setIdUsuario(resultado.getInt("idUsuario"));
            us.setNumeroIdentificacion(resultado.getInt("numeroIdentificacion"));
            us.setNombres(resultado.getString("nombres"));
            us.setPrimerApellido(resultado.getString("primerApellido"));
            us.setSegundoApellido(resultado.getString("segundoApellido"));
            lista.add(us);
        }
        return lista;
    }

    @Override
    public void Insertar(UsuarioVO vo) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Modificar(UsuarioVO vo) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Eliminar(UsuarioVO vo) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Consultar(UsuarioVO vo) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<UsuarioVO> Consultar() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UsuarioVO Consultar(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
