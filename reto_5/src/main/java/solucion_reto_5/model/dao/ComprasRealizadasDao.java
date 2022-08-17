package solucion_reto_5.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import solucion_reto_5.model.vo.ComprasRealizadasVo;
import solucion_reto_5.util.JDBCUtilidades;

/**
 * It's a DAO class that returns a list of ComprasRealizadasVo objects
 */

public class ComprasRealizadasDao {
    public List<ComprasRealizadasVo> listar() throws SQLException {
        ArrayList<ComprasRealizadasVo> respuesta = new ArrayList<ComprasRealizadasVo>();
        Connection conn = JDBCUtilidades.getConnection();
        Statement stm = null;
        ResultSet rs = null;
        String consulta = "SELECT ID_Compra as id, p.Constructora, p.Banco_Vinculado as banco FROM Compra c JOIN Proyecto p ON c.ID_Proyecto = p.ID_Proyecto WHERE Proveedor = 'Homecenter' AND p.Ciudad = 'Salento'";
        try {
            stm = conn.createStatement();
            rs = stm.executeQuery(consulta);
            while (rs.next()) {
                ComprasRealizadasVo vo = new ComprasRealizadasVo();
                vo.setId(rs.getInt("id"));
                vo.setConstructora(rs.getString("constructora"));
                vo.setBanco(rs.getString("banco"));
                respuesta.add(vo);
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return respuesta;
    }
}
