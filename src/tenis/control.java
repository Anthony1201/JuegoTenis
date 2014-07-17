package tenis;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Admin on 16/07/14.
 */
public class control {
    private JPanel control;
    private JButton jugador1;
    private JButton jugador2;
    private JLabel marcador;
    private JButton resetButton;
    private JComboBox comboBox1;
    private final Set2 set;
    private tenis tabla;
    private posicion tablainversa;
    private String idioma;

    public control(String nombre1, String nombre2) {
        jugador1.setText(nombre1);
        jugador2.setText(nombre2);
        idioma = comboBox1.getSelectedItem().toString();
        tabla = new tenis(nombre1, nombre2,idioma);
        set= Set2.getInstance(nombre1,nombre2,idioma);
        marcador.setText(set.getScore());
        JFrame posicion = new JFrame("Tabla posicion");
        posicion.setContentPane(tabla.getVentana());
        posicion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        posicion.pack();
        posicion.setVisible(true);
        posicion.setSize(500, 600);

        tablainversa = new posicion(nombre1, nombre2,idioma);
        JFrame posicionInversa = new JFrame("Tabla posicion inversa");
        posicionInversa.setContentPane(tablainversa.getPanel());
        posicionInversa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        posicionInversa.pack();
        posicionInversa.setVisible(true);
        posicionInversa.setSize(500, 600);

        jugador1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                nuevoPuntaje("player1");
            }
        });
        jugador2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                nuevoPuntaje("player2");
            }
        });
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                set.setScoreCero();
                tabla.getModelo().setNumRows(0);
                tablainversa.getModelo().setNumRows(0);
                nuevoPuntaje("");
            }
        });
        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                set.setIdioma(comboBox1.getSelectedItem().toString());
                for (int i = 0; i < tabla.getModelo().getRowCount(); i++) {
                    cambiarPuntos(Integer.parseInt((String) tabla.getModelo().getValueAt(i, 0)),Integer.parseInt((String) tabla.getModelo().getValueAt(i, 1)));
                    tabla.getModelo().setValueAt(set.getScore(),i,2);
                }
                for (int i = 0; i < tablainversa.getModelo().getRowCount(); i++) {
                    cambiarPuntos(Integer.parseInt((String) tablainversa.getModelo().getValueAt(i, 0)),Integer.parseInt((String) tablainversa.getModelo().getValueAt(i, 1)));
                    tablainversa.getModelo().setValueAt(set.getScore(),i,2);
                }
            }
        });
        tablainversa.getTable1().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                int fila = tablainversa.getTable1().getSelectedRow();
                cambiarPuntos(Integer.parseInt((String) tablainversa.getModelo().getValueAt(fila, 0)),Integer.parseInt((String) tablainversa.getModelo().getValueAt(fila, 1)));
                for (int i = 0; i < fila; i++) {
                    tablainversa.getModelo().removeRow(0);
                }
                fila = tabla.getModelo().getRowCount() - fila;
                tabla.getModelo().setNumRows(fila);
                marcador.setText(set.getScore());
            }
        });
        tabla.getTable1().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                int fila = tabla.getTable1().getSelectedRow();
                cambiarPuntos(Integer.parseInt((String) tabla.getModelo().getValueAt(fila, 0)),Integer.parseInt((String) tabla.getModelo().getValueAt(fila, 1)));
                tabla.getModelo().setNumRows(fila+1);
                fila = tablainversa.getModelo().getRowCount() - (fila+1);
                for (int i = 0; i < fila; i++) {
                    tablainversa.getModelo().removeRow(0);
                }
                marcador.setText(set.getScore());
                //System.out.println();
            }
        });
    }
    public JPanel getControl(){
        return control;
    }
    private void cambiarPuntos(int jugador1, int jugador2){
        set.setPuntosJugador1(jugador1);
        set.setPuntosJugador2(jugador2);
    }
    private void nuevoPuntaje(String jugador){
        if(jugador != "")
            set.setPunto(jugador);
        marcador.setText(set.getScore());
        tabla.getModelo().addRow(new String[]{set.getPuntosJugador1(), set.getPuntosJugador2(), set.getScore()});
        tablainversa.getModelo().insertRow(0,new String[]{set.getPuntosJugador1(),set.getPuntosJugador2(),set.getScore()});
    }
}
