package tenis;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;


/**
 * Created by Admin on 16/07/14.
 */
public class posicion {
    private JTable table1;
    private JPanel panel;
    private final DefaultTableModel modelo;

    public posicion(String nombre1,String nombre2, String idioma) {
        final Set2 set = Set2.getInstance(nombre1,nombre2,idioma);
        modelo =  (DefaultTableModel)table1.getModel();
        modelo.addColumn(nombre1);
        modelo.addColumn(nombre2);
        modelo.addColumn( "Score");
        modelo.addRow(new String[]{set.getPuntosJugador1(),set.getPuntosJugador2(),set.getScore()});
    }

    public JPanel getPanel() {
        return panel;
    }

    public DefaultTableModel getModelo() {
        return modelo;
    }

    public JTable getTable1() {
        return table1;
    }
}
