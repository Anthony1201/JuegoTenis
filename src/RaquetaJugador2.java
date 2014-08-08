/**
 * Created by Admin on 30/07/14.
 */
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
public class RaquetaJugador2 {

        private static final int WIDTH = 10;
        static final int HEIGHT = 100;
        int y = 0, x=585;
        int ya = 0, xa = 0;
        private Tennis game;

        public RaquetaJugador2(Tennis game) {
            this.game = game;
        }

        public void move() {
            if (y + ya > 0 && y + ya < game.getHeight() - HEIGHT)
                y += ya;
            if (x+xa > (game.getWidth()/2) && x + xa < game.getWidth() -WIDTH)
                x -= xa;
        }

        public void paint(Graphics2D g) {
            g.fillRect(x, y, WIDTH, HEIGHT);
        }

        public void keyReleased(KeyEvent e) {
            ya = 0;
            xa = 0;
        }

        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_UP)
                ya = -game.getSpeedx();
            if (e.getKeyCode() == KeyEvent.VK_DOWN)
                ya = game.getSpeedx();
            if (e.getKeyCode() == KeyEvent.VK_RIGHT)
                xa = -game.getSpeedx();
            if (e.getKeyCode() == KeyEvent.VK_LEFT)
                xa = game.getSpeedx();
        }

        public Rectangle getBounds() {
            return new Rectangle(x, y, WIDTH, HEIGHT);
        }

        public int getTopX() {
            return x - WIDTH;
        }

    }
