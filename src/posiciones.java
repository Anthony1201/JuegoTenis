import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Admin on 07/08/14.
 */
public class posiciones implements Observer{
    public JPanel posiciones;
    private JTable table1;
    private DefaultTableModel modelo;
    private TennisGame set;

    public posiciones() {
        modelo = (DefaultTableModel) table1.getModel();
        modelo.addColumn("Jugador 1");
        modelo.addColumn("Jugador 2");
        modelo.addColumn("Score");
        set = TennisGame.getInstance();
        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                int fila = table1.getSelectedRow();
                if (fila >= 0) {
                    set.setPuntosJugador1(Integer.parseInt((String) modelo.getValueAt(fila, 0)));
                    set.setPuntosJugador2(Integer.parseInt((String) modelo.getValueAt(fila, 1)));
                    modelo.setNumRows(fila + 1);
                }
            }
        });
    }

    @Override
    public void update(Observable observable, Object o) {
        modelo.addRow(new String[]{set.getPuntosJugador1(),set.getPuntosJugador2(),set.getScore()});

    }
}
