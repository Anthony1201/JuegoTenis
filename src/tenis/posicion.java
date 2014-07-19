package tenis;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by Admin on 16/07/14.
 */
public class posicion extends Idiomas{
    private JTable table1;
    private JPanel panel;
    private JComboBox comboBox1;
    private final DefaultTableModel modelo;
    private Set2 set;

    public posicion(String nombre1,String nombre2) {
        set = Set2.getInstance(nombre1,nombre2,getIdioma());
        modelo =  (DefaultTableModel)table1.getModel();
        modelo.addColumn(nombre1);
        modelo.addColumn(nombre2);
        modelo.addColumn( "Score");
        modelo.addRow(new String[]{set.getPuntosJugador1(),set.getPuntosJugador2(),set.getScore()});
        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                set.setIdioma(getIdioma());
                for (int i = getModelo().getRowCount()-1; i >=0 ; i--) {
                    cambiarPuntos(Integer.parseInt((String) getModelo().getValueAt(i, 0)),Integer.parseInt((String) getModelo().getValueAt(i, 1)));
                    getModelo().setValueAt(set.getScore(),i,2);
                }
            }
        });
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

    public String idiomaSeleccionado(){
        return comboBox1.getSelectedItem().toString();
    }

    private void cambiarPuntos(int jugador1, int jugador2){
        set.setPuntosJugador1(jugador1);
        set.setPuntosJugador2(jugador2);
    }
}
