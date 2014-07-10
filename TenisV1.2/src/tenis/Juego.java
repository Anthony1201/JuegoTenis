/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tenis;

/**
 *
 * @author Trainer Gold
 */
public interface Juego {
    
    public String getScore();
    public void resetScore();
    public void wonPoint(String s);
    
}
