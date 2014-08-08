/**
 * Created by Admin on 30/07/14.
 */

import java.awt.Graphics2D;
import java.awt.Rectangle;
public class Pelota {
    private static final int DIAMETER = 30;

    int x = 0;
    int y = 0;
    int xa = 0;
    int ya = 0;
    private Tennis game;
    private int raqueta = 0;

    public Pelota(Tennis game) {
        this.game = game;
        xa = game.getSpeedx();
        ya = game.getSpeedy();
    }

    public void move() {
        if (x + xa < 0) {
            //xa = game.getSpeedx();
            game.setPoint("player2");
        }
        else if (x + xa > game.getWidth() - DIAMETER) {
            game.setPoint("player1");
            //xa = -game.getSpeedx();
        }
        else if (y + ya < 0) {
            if(getBounds().getCenterX() < game.getWidth()/2)
                game.setPoint("player2");
            else if(getBounds().getCenterX() > game.getWidth()/2)
                game.setPoint("player1");
            else
                ya = game.getSpeedy();
        }
        else if (y + ya > game.getHeight() - DIAMETER){
            if(getBounds().getCenterX() < game.getWidth()/2)
                game.setPoint("player2");
            else if(getBounds().getCenterX() > game.getWidth()/2)
                game.setPoint("player1");
            else
                ya = -game.getSpeedy();
        }
        else if (collision()){
            if (raqueta == 1){
                xa = game.getSpeedx();
                x = game.getRacquet1().getTopX() + DIAMETER;
            }else if (raqueta == 2){
                xa = -game.getSpeedx();
                x = game.getRacquet2().getTopX() - DIAMETER;
            }
                        /*ya = -game.getSpeed();
                        y = game.getRacquet().getTopY() - DIAMETER;
                        game.setScore(game.getScore()+1);
                        if ((game.getScore() % 2) == 0) game.setSpeed(game.getSpeed()+1);*/
        }
        x = x + xa;
        y = y + ya;
    }

    private boolean collision() {
        if (game.getRacquet1().getBounds().intersects(getBounds())) {
            double intersect = getBounds().getCenterY() - (game.getRacquet1().getBounds().getCenterY()-(game.getRacquet1().HEIGHT/2));
            if(Math.abs(intersect) < (game.getRacquet1().HEIGHT/3)){
                ya = -1;
            }else if(Math.abs(intersect) > (game.getRacquet1().HEIGHT/3)*2) {
                ya = 1;
            }
            else {
                ya = 0;
            }
            System.out.println(intersect);
            raqueta = 1;
            return true;
        }else if (game.getRacquet2().getBounds().intersects(getBounds())){
            double intersect = getBounds().getCenterY()-(game.getRacquet2().getBounds().getCenterY()-(game.getRacquet2().HEIGHT/2));
            if(Math.abs(intersect) < (game.getRacquet2().HEIGHT/3)){
                ya = 1;
            }else if(Math.abs(intersect) > (game.getRacquet2().HEIGHT/3)*2) {
                ya = -1;
            }
            else {
                ya = 0;
            }
            raqueta = 2;
            return true;
        }else return false;
    }

    public void paint(Graphics2D g) {
        g.fillOval(x, y, DIAMETER, DIAMETER);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, DIAMETER, DIAMETER);
    }

}
