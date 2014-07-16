package tenis;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Admin on 15/07/14.
 */
public class inicio {
    private JTextField textField1;
    private JTextField textField2;
    private JButton iniciarButton;
    private JPanel principal;
    private JFrame ventanainicial;

    public inicio() {
        iniciarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(textField1.getText() != "" && textField2.getText() != ""){
                    ventanainicial.setVisible(false);
                    JFrame juego = new JFrame("tenis");
                    juego.setContentPane(new tenis(textField1.getText(), textField2.getText()).getVentana());
                    juego.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    juego.pack();
                    juego.setVisible(true);
                    juego.setSize(500,400);
                }else{
                    JOptionPane.showMessageDialog(null,"Falta nombre jugador");
                }
            }
        });
    }
    public void setFrame(JFrame ventanainicial){
        this.ventanainicial = ventanainicial;
    }

    public static void main(String[] args) {
        inicio ventanaprincipal = new inicio();
        JFrame inicio = new JFrame("inicio");
        ventanaprincipal.setFrame(inicio);
        inicio.setContentPane(ventanaprincipal.principal);
        inicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inicio.pack();
        inicio.setVisible(true);
    }
}
