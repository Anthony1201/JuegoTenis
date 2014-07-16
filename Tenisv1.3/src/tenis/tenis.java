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
    private JLabel marcador;
    private JPanel ventana;
    private JTable table1;
    private DefaultTableModel modelo;

    public tenis() {

        final Set2 set = new Set2("Jugador 1","Jugador 2",comboBox1.getSelectedItem().toString());
        marcador.setText(set.getScore());
        modelo =  (DefaultTableModel)table1.getModel();
        modelo.addColumn("Jugador 1");
        modelo.addColumn("Jugador 2");
        modelo.addColumn( "Score");
        table1.getColumnModel().getColumn(2).setPreferredWidth(200);
        modelo.addRow(new String[]{set.getPlayer1(),set.getPlayer2(),set.getScore()});
        jugador1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                set.wonPoint("player1");
                modelo.addRow(new String[]{set.getPlayer1(),set.getPlayer2(),set.getScore()});
                marcador.setText(set.getScore());
            }
        });
        jugador2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                set.wonPoint("player2");
                modelo.addRow(new String[]{set.getPlayer1(),set.getPlayer2(),set.getScore()});
                marcador.setText(set.getScore());
            }
        });
        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                set.setIdioma(comboBox1.getSelectedItem().toString());
                for (int i = 0; i < modelo.getRowCount(); i++) {
                    set.setPlayer1(Integer.parseInt((String) modelo.getValueAt(i, 0)));
                    set.setPlayer2(Integer.parseInt((String) modelo.getValueAt(i, 1)));
                    modelo.setValueAt(set.getScore(),i,2);
                }
                marcador.setText(set.getScore());
            }
        });
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                set.resetScore();
                modelo.setNumRows(0);
                modelo.addRow(new String[]{set.getPlayer1(),set.getPlayer2(),set.getScore()});
                marcador.setText(set.getScore());
            }
        });
        table1.addComponentListener(new ComponentAdapter() {
        });
        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                int fila = table1.getSelectedRow();
                set.setPlayer1(Integer.parseInt((String) modelo.getValueAt(fila, 0)));
                set.setPlayer2(Integer.parseInt((String) modelo.getValueAt(fila, 1)));
                modelo.setNumRows(fila+1);
                //System.out.println();
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Tenis");
        frame.setContentPane(new tenis().ventana);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(500,400);
    }
}
