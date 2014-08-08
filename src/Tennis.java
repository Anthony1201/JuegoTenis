/**
 * Created by Admin on 30/07/14.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Tennis extends JPanel{

    private static final long serialVersionUID = 1L;
    private Pelota ball = new Pelota(this);
    private RaquetaJugador1 racquet1 = new RaquetaJugador1(this);
    private RaquetaJugador2 racquet2 = new RaquetaJugador2(this);
    private TennisGame set = TennisGame.getInstance();
    private int speedx = 2;
    private int speedy = 0;
    private int score = 0;

    public Tennis() {
        this.setBackground(Color.darkGray);
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if ((e.getKeyCode()== KeyEvent.VK_A)
                        || (e.getKeyCode()== KeyEvent.VK_S)
                            || (e.getKeyCode()== KeyEvent.VK_W)
                                || (e.getKeyCode()== KeyEvent.VK_D))
                    racquet1.keyReleased(e);
                if ((e.getKeyCode()== KeyEvent.VK_UP)
                        || (e.getKeyCode()== KeyEvent.VK_DOWN)
                            || (e.getKeyCode()== KeyEvent.VK_LEFT)
                                || (e.getKeyCode()== KeyEvent.VK_RIGHT))
                    racquet2.keyReleased(e);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if ((e.getKeyCode()== KeyEvent.VK_A)
                        || (e.getKeyCode()== KeyEvent.VK_S)
                            || (e.getKeyCode()== KeyEvent.VK_W)
                                || (e.getKeyCode()== KeyEvent.VK_D))
                    racquet1.keyPressed(e);
                if ((e.getKeyCode()== KeyEvent.VK_UP)
                        || (e.getKeyCode()== KeyEvent.VK_DOWN)
                            || (e.getKeyCode()== KeyEvent.VK_LEFT)
                                || (e.getKeyCode()== KeyEvent.VK_RIGHT))
                    racquet2.keyPressed(e);
            }
        });
        setFocusable(true);
    }

    public void move() {
        ball.move();
        racquet1.move();
        racquet2.move();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.WHITE);
        g2d.fillRect(getWidth()/2,0,1,getHeight());
        g2d.setColor(Color.RED);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        ball.paint(g2d);
        racquet1.paint(g2d);
        racquet2.paint(g2d);
    }

    public void gameOver() {
        JOptionPane.showMessageDialog(this, "your score is: ",
                "Game Over", JOptionPane.YES_NO_OPTION);
        System.exit(ABORT);
    }

    public void setPoint(String jugador){
        set.setPunto(jugador);
        if(jugador == "player1"){
            racquet1.x = 0;
            racquet1.y = 0;
            ball.x = racquet1.WIDTH;
            ball.y = 0;
            ball.xa = getSpeedx();
            ball.ya = getSpeedx();
        }else if(jugador == "player2"){
            racquet2.x = 585;
            racquet2.y = 0;
            ball.x = 555;
            ball.y = 0;
            ball.xa = -getSpeedx();
            ball.ya = getSpeedx();
        }
    }

    public int getSpeedx(){return speedx;}
    public void setSpeedx(int i){speedx = i;}
    public int getSpeedy(){return speedy;}
    public void setSpeedy(int i){speedy = i;}
    public RaquetaJugador1 getRacquet1(){return racquet1;}
    public RaquetaJugador2 getRacquet2(){return racquet2;}
}