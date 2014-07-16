package tenis;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;

/**
 * Created by Admin on 11/07/14.
 **/
public class tenis {
    private JButton jugador1Button;
    private JButton jugador2Button;
    private JButton resetButton;
    private JComboBox comboBox1;
    private JPanel ventana;
    private JTable table1;
    private DefaultTableModel modelo;

    public tenis(String nombre1, String nombre2) {
        final Set2 set = new Set2(nombre1,nombre2,comboBox1.getSelectedItem().toString());
        modelo =  (DefaultTableModel)table1.getModel();
        modelo.addColumn(nombre1);
        modelo.addColumn(nombre2);
        modelo.addColumn( "Score");
        jugador1Button.setText(nombre1);
        jugador2Button.setText(nombre2);
        table1.getColumnModel().getColumn(2).setPreferredWidth(200);
        modelo.addRow(new String[]{set.getPuntosJugador1(),set.getPuntosJugador2(),set.getScore()});
        jugador1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                set.setPunto("player1");
                modelo.addRow(new String[]{set.getPuntosJugador1(),set.getPuntosJugador2(),set.getScore()});
            }
        });
        jugador2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                set.setPunto("player2");
                modelo.addRow(new String[]{set.getPuntosJugador1(),set.getPuntosJugador2(),set.getScore()});
            }
        });
        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                set.setIdioma(comboBox1.getSelectedItem().toString());
                for (int i = 0; i < modelo.getRowCount(); i++) {
                    set.setPuntosJugador1(Integer.parseInt((String) modelo.getValueAt(i, 0)));
                    set.setPuntosJugador2(Integer.parseInt((String) modelo.getValueAt(i, 1)));
                    modelo.setValueAt(set.getScore(),i,2);
                }
            }
        });
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                set.setScoreCero();
                modelo.setNumRows(0);
                modelo.addRow(new String[]{set.getPuntosJugador1(),set.getPuntosJugador2(),set.getScore()});
            }
        });
        table1.addComponentListener(new ComponentAdapter() {
        });
        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                int fila = table1.getSelectedRow();
                set.setPuntosJugador1(Integer.parseInt((String) modelo.getValueAt(fila, 0)));
                set.setPuntosJugador2(Integer.parseInt((String) modelo.getValueAt(fila, 1)));
                modelo.setNumRows(fila+1);
                //System.out.println();
            }
        });
    }

    public JPanel getVentana() {
        return ventana;
    }
}
