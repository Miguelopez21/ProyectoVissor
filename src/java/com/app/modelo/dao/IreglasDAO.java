package com.app.modelo.dao;

import com.app.modelo.vo.IreglasVO;
import java.sql.SQLException;
import java.util.List;

public interface IreglasDAO<VO extends IreglasVO> {

    public void insertar(VO vo) throws SQLException;

    public void modificar(VO vo) throws SQLException;

    public void eliminar(VO vo) throws SQLException;

    public void consultar(VO vo) throws SQLException;

    public List<VO> consultar() throws SQLException;
    
    public VO consultar(int id) throws SQLException;

}
