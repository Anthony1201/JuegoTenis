import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Admin on 08/08/14.
 */
public class principal {
    private JComboBox comboBox1;
    private JTextField textField1;
    private JTextField textField2;
    private JButton comenzarButton;
    public JPanel principal;
    private TennisGame set = TennisGame.getInstance();


    public principal(){
        comboBox1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String idioma_cadena = comboBox1.getSelectedItem().toString();
                set.setIdioma(getIdioma(idioma_cadena));
            }
        });

        comenzarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(textField1.getText() == "" || textField2.getText() == "")
                    JOptionPane.showMessageDialog(null,"Nombre de Jugadores Vacios");
                else{
                    set.setNombreJugador1(textField1.getText());
                    set.setNombreJugador2(textField2.getText());
                    set.setEstado(true);
                }
                System.out.print("algo");
            }
        });
    }

    public Idioma getIdioma(String idioma_cadena){
        if (idioma_cadena == "Ingles") {
            return new Ingles();
        } else if (idioma_cadena == "Frances") {
            return new French();
        } else if (idioma_cadena == "Aleman") {
            return new Deutsch();
        } else if(idioma_cadena == "Espanol"){
            return new Espanol();
        }else{
            return null;
        }
    }
}
