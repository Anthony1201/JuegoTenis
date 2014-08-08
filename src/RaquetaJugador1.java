import java.awt.*;
import java.awt.event.KeyEvent;
/**
 * Created by Admin on 30/07/14.
 */
public class RaquetaJugador1 {

    static final int WIDTH = 10;
    static final int HEIGHT = 100;
    int y = 0,x=0;
    int ya = 0,xa=0;
    private Tennis game;

    public RaquetaJugador1(Tennis game) {
        this.game = game;
    }

    public void move() {
        if (y + ya > 0 && y + ya < game.getHeight() - HEIGHT)
            y += ya;
        if (x+xa > 0 && x + xa < (game.getWidth()/2)-WIDTH)
            x += xa;
    }

    public void paint(Graphics2D g) {
        g.fillRect(x, y, WIDTH, HEIGHT);
    }

    public void keyReleased(KeyEvent e) {
        ya = 0;
        xa = 0;
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W)
            ya = -game.getSpeedx();
        if (e.getKeyCode() == KeyEvent.VK_S)
            ya = game.getSpeedx();
        if (e.getKeyCode() == KeyEvent.VK_A)
            xa = -game.getSpeedx();
        if (e.getKeyCode() == KeyEvent.VK_D)
            xa = game.getSpeedx();
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, WIDTH, HEIGHT);
    }

    public int getTopX() {
        return x - WIDTH;
    }

}