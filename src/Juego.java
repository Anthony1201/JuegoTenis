/**
 * Created by Admin on 30/07/14.
 */
import javax.swing.*;
import java.awt.*;

public class Juego {

    public static void main(String[] args) throws InterruptedException{
        JFrame tabla_posicion = new JFrame("posiciones");
        posiciones posiciones_tabla = new posiciones();
        tabla_posicion.setContentPane(posiciones_tabla.posiciones);
        tabla_posicion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tabla_posicion.pack();
        tabla_posicion.setVisible(true);

        JFrame inicio = new JFrame("Principal");
        principal ini = new principal();
        inicio.setContentPane(ini.principal);
        inicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inicio.pack();
        inicio.setVisible(true);

        TennisGame set = TennisGame.getInstance();
        set.addObserver(posiciones_tabla);

        set.setIdioma(new Ingles());

        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        JFrame frame = new JFrame("Tennis");
        Tennis game = new Tennis();
        frame.add(game);
        frame.setBounds((d.width/2)-300,(d.height/2)-200,600, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        while (true) {
            if(set.isEstado() && game.hasFocus()) {
                game.move();
                game.repaint();
            }
            Thread.sleep(10);
            //System.out.print("-*");
        }
    }
}
