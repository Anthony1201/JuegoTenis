package tenis;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;

/**
 * Created by Admin on 11/07/14.
 **/
public class tenis {
    private JPanel ventana;
    private JTable table1;
    private final DefaultTableModel modelo;

    public tenis(String nombre1, String nombre2, String idioma) {
        final Set2 set = Set2.getInstance(nombre1,nombre2,idioma);
        modelo =  (DefaultTableModel)table1.getModel();
        modelo.addColumn(nombre1);
        modelo.addColumn(nombre2);
        modelo.addColumn( "Score");
        table1.getColumnModel().getColumn(2).setPreferredWidth(200);
        modelo.addRow(new String[]{set.getPuntosJugador1(),set.getPuntosJugador2(),set.getScore()});
    }

    public JPanel getVentana() {
        return ventana;
    }

    public DefaultTableModel getModelo() {
        return modelo;
    }

    public JTable getTable1() {
        return table1;
    }
}
