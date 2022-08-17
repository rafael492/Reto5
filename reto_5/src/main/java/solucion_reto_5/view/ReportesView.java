package solucion_reto_5.view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.plaf.DimensionUIResource;
import javax.swing.table.DefaultTableModel;

import solucion_reto_5.controller.ReportesController;
import solucion_reto_5.model.vo.*;
import java.util.List;

public class ReportesView extends JFrame implements ActionListener {
    private ReportesController controller;
    private JMenuBar mMenuBar;
    private JMenu menu;
    private JMenuItem i1, i2, i3;
    private DefaultTableModel modelo;
    private JTable table;
    private JLabel lblTitulo, lblConsulta;

    public ReportesView() {
        controller = new ReportesController();
        menu();
        etiqueta1();
        etiqueta2();
        tabla();
    }

    public void etiqueta1() {
        lblTitulo = new JLabel("Seleccione el informe a consultar");
        lblTitulo.setPreferredSize(new Dimension(500, 30));
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 20));
        add(lblTitulo);

    }

    public void etiqueta2() {
        lblConsulta = new JLabel();
        lblConsulta.setPreferredSize(new DimensionUIResource(500, 30));
        lblConsulta.setFont(new Font("Arial", Font.BOLD, 14));
        add(lblConsulta);

    }

    public void tabla() {
        table = new JTable(modelo);
        table.setPreferredScrollableViewportSize(new Dimension(500, 200));
        add(table);
        JScrollPane pane = new JScrollPane(table);
        add(pane);
    }

    public void menu() {
        mMenuBar = new JMenuBar();
        setJMenuBar(mMenuBar);
        menu = new JMenu("Informes");
        mMenuBar.add(menu);
        i1 = new JMenuItem("Informe Lideres");
        i2 = new JMenuItem("Informe Proyectos");
        i3 = new JMenuItem("Informe Compras");
        menu.add(i1);
        menu.add(i2);
        menu.add(i3);
        i1.addActionListener(this);
        i2.addActionListener(this);
        i3.addActionListener(this);
    }

    public void proyectosFinanciadosPorBanco() {
        try {
            List<NumeroDeHabitacionesVo> proyectos = controller.listarNumeroDeHabitacionesHome();
            modelo = new DefaultTableModel();
            modelo.addColumn("Id Proyecto");
            modelo.addColumn("Constructora");
            modelo.addColumn("Habitaciones");
            modelo.addColumn("Ciudad");
            for (NumeroDeHabitacionesVo proy : proyectos) {
                Object[] fila = new Object[4];
                fila[0] = proy.getId();
                fila[1] = proy.getConstructora();
                fila[2] = proy.getHabitaciones();
                fila[3] = proy.getCiudad();
                modelo.addRow(fila);
            }
            table.setModel(modelo);
            modelo.fireTableDataChanged();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void totalAdeudadoPorProyectosSuperioresALimite() {
        try {
            List<ComprasRealizadasVo> compras = controller.listarComprasRealizadasPorBanco();
            modelo = new DefaultTableModel();
            modelo.addColumn("Id compra");
            modelo.addColumn("Constructora");
            modelo.addColumn("Banco");
            for (ComprasRealizadasVo compra : compras) {
                Object[] fila = new Object[3];
                fila[0] = compra.getId();
                fila[1] = compra.getConstructora();
                fila[2] = compra.getBanco();
                modelo.addRow(fila);
            }
            table.setModel(modelo);
            modelo.fireTableDataChanged();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void lideresQueMasGastan() {
        try {
            List<LiderVo> compras = controller.listarLideresProyecto();
            // creación del modelo
            modelo = new DefaultTableModel();
            modelo.addColumn("Id");
            modelo.addColumn("Nombre");
            modelo.addColumn("Apellido");
            modelo.addColumn("Ciudad");
            for (LiderVo com : compras) {
                Object[] fila = new Object[4];
                fila[0] = com.getId();
                fila[1] = com.getNombre();
                fila[2] = com.getApellido();
                fila[3] = com.getCiudad();
                modelo.addRow(fila);
            }
            table.setModel(modelo);
            modelo.fireTableDataChanged();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == i1) {
            lideresQueMasGastan();
            lblConsulta.setText("Consultas Lideres");
        }
        if (e.getSource() == i2) {
            proyectosFinanciadosPorBanco();
            lblConsulta.setText("Consultas Proyectos Casas Campestres");
        }
        if (e.getSource() == i3) {
            totalAdeudadoPorProyectosSuperioresALimite();
            lblConsulta.setText("Consultas Compras por proveedor Homecenter");
        }
    }
}
