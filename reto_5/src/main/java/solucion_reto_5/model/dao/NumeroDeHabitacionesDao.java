package solucion_reto_5.model.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import solucion_reto_5.model.vo.NumeroDeHabitacionesVo;
import solucion_reto_5.util.JDBCUtilidades;



public class NumeroDeHabitacionesDao {
    public List<NumeroDeHabitacionesVo> listar() throws SQLException {
        ArrayList<NumeroDeHabitacionesVo> respuesta = new ArrayList<NumeroDeHabitacionesVo>();
        Connection conn = JDBCUtilidades.getConnection();
        Statement stm = null;
        ResultSet rs = null;
        String consulta = "select ID_Proyecto as id, Constructora, Numero_Habitaciones as hab,Ciudad from Proyecto p where Clasificacion = 'Casa Campestre' and Ciudad in('Santa Marta','Cartagena','Barranquilla')";
        try {
            stm = conn.createStatement();
            rs = stm.executeQuery(consulta);
            while (rs.next()) {
                NumeroDeHabitacionesVo vo = new NumeroDeHabitacionesVo();
                vo.setId(rs.getInt("id"));
                vo.setConstructora(rs.getString("constructora"));
                vo.setHabitaciones(rs.getInt("hab"));
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
