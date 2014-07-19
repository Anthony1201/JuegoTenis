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
    private final Set2 set;
    private tenis tabla;
    private posicion tablainversa;

    public control(String nombre1, String nombre2) {
        jugador1.setText(nombre1);
        jugador2.setText(nombre2);
        tabla = new tenis(nombre1, nombre2);
        set= Set2.getInstance(nombre1,nombre2,tabla.getIdioma());

        marcador.setText(set.getScore());
        JFrame posicion = new JFrame("Tabla posicion");
        posicion.setContentPane(tabla.getVentana());
        posicion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        posicion.setLocation(420,0);
        posicion.pack();
        posicion.setVisible(true);
        posicion.setSize(400, 400);

        tablainversa = new posicion(nombre1, nombre2);
        JFrame posicionInversa = new JFrame("Tabla posicion inversa");
        posicionInversa.setContentPane(tablainversa.getPanel());
        posicionInversa.setLocation(900,0);
        posicionInversa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        posicionInversa.pack();
        posicionInversa.setVisible(true);
        posicionInversa.setSize(400, 400);

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
        set.setIdioma(tabla.getIdioma());
        marcador.setText(set.getScore());
        tabla.getModelo().addRow(new String[]{set.getPuntosJugador1(), set.getPuntosJugador2(), set.getScore()});
        set.setIdioma(tablainversa.getIdioma());
        tablainversa.getModelo().insertRow(0,new String[]{set.getPuntosJugador1(),set.getPuntosJugador2(),set.getScore()});
    }
}
