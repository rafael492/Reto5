package solucion_reto_5.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import solucion_reto_5.model.vo.LiderVo;
import solucion_reto_5.util.JDBCUtilidades;

public class LiderDao {
    public List<LiderVo> listar() throws SQLException {
        ArrayList<LiderVo> respuesta = new ArrayList<LiderVo>();
        Connection conn = JDBCUtilidades.getConnection();
        Statement stm = null;
        ResultSet rs = null;
        String consulta = "SELECT ID_Lider as id, Nombre, Primer_Apellido as apellido, Ciudad_Residencia as ciudad FROM Lider l order by Ciudad_Residencia";
        try {
            stm = conn.createStatement();
            rs = stm.executeQuery(consulta);
            while (rs.next()) {
                LiderVo vo = new LiderVo();
                vo.setId(rs.getInt("id"));
                vo.setNombre(rs.getString("nombre"));
                vo.setApellido(rs.getString("apellido"));
                vo.setCiudad(rs.getString("ciudad"));
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
