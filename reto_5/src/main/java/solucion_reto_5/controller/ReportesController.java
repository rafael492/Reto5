package solucion_reto_5.controller;

import java.sql.SQLException;
import java.util.List;

import solucion_reto_5.model.dao.ComprasRealizadasDao;
import solucion_reto_5.model.dao.LiderDao;
import solucion_reto_5.model.dao.NumeroDeHabitacionesDao;
import solucion_reto_5.model.vo.ComprasRealizadasVo;
import solucion_reto_5.model.vo.LiderVo;
import solucion_reto_5.model.vo.NumeroDeHabitacionesVo;

public class ReportesController {
    private ComprasRealizadasDao comprasRealizadasDao;
    private LiderDao liderDao;
    private NumeroDeHabitacionesDao numeroDeHabitacionesDao;

    public ReportesController() {
        comprasRealizadasDao = new ComprasRealizadasDao();
        liderDao = new LiderDao();
        numeroDeHabitacionesDao = new NumeroDeHabitacionesDao();
    }

    public List<ComprasRealizadasVo> listarComprasRealizadasPorBanco() throws SQLException {
        return comprasRealizadasDao.listar();
    }

    public List<LiderVo> listarLideresProyecto() throws SQLException {
        return liderDao.listar();
    }

    public List<NumeroDeHabitacionesVo> listarNumeroDeHabitacionesHome() throws SQLException {
        return numeroDeHabitacionesDao.listar();
    }
}
