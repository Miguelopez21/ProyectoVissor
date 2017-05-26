package com.app.modelo.conexion;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConexionBD {

    public static Connection getConexionBD() throws NamingException, SQLException {
        InitialContext contexto = new InitialContext();
        DataSource origenDatos = (DataSource) contexto.lookup("jdbc/vissor");
        Connection cnn = origenDatos.getConnection();
        cnn.setAutoCommit(false);
        return cnn;
    }

    public static void desconectarBD(Connection cnn) throws SQLException {
        if (cnn != null) {
            cnn.commit();
            cnn.close();
        }
        cnn = null;
    }

    public static void reversarBD(Connection cnn) throws SQLException {
        if (cnn != null) {
            cnn.rollback();
            cnn.close();
        }
        cnn = null;
    }

}
