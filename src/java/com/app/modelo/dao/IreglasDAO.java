package com.app.modelo.dao;

import com.app.modelo.vo.IreglasVO;
import java.sql.SQLException;
import java.util.List;

public interface IreglasDAO<VO extends IreglasVO> {

    public void Insertar(VO vo) throws SQLException;

    public void Modificar(VO vo) throws SQLException;

    public void Eliminar(VO vo) throws SQLException;

    public void Consultar(VO vo) throws SQLException;

    public List<VO> Consultar() throws SQLException;
    
    public VO Consultar(int id) throws SQLException;

}
