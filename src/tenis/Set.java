/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tenis;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
/**
 *
 * @author Trainer Gold
 */
public class Set implements Juego {

    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;

    public Set(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }
    
    public void resetScore (){
    m_score1 = 0;
    m_score2 = 0;
    }

    public void wonPoint(String playerName) {
        if (playerName == player1Name)
            m_score1 += 1;
        else
            m_score2 += 1;
    }

    public String getScore() {
        String score = "";
        int tempScore=0;
        if (m_score1==m_score2)
        {
            switch (m_score1)
            {
                case 0:
                        score = "Cero-Iguales";
                    break;
                case 1:
                        score = "Quince-Iguales";
                    break;
                case 2:
                        score = "Treinta-Iguales";
                    break;
                default:
                        score = "Empate";
                    break;
                
            }
        }
        else if (m_score1>=4 || m_score2>=4)
        {
            int minusResult = m_score1-m_score2;
            if (minusResult==1) score ="Ventaja para Jugador 1";
            else if (minusResult ==-1) score ="Ventaja para Jugador 2";
            else if (minusResult>=2) score = "Gana Jugador 1";
            else score ="Gana Jugador 2";
        }
        else
        {
            for (int cicloscore=1; cicloscore<3; cicloscore++)
            {
                if (cicloscore==1) tempScore = m_score1;
                else { score+="-"; tempScore = m_score2;}
                switch(tempScore)
                {
                    case 0:
                        score+="Cero";
                        break;
                    case 1:
                        score+="Quince";
                        break;
                    case 2:
                        score+="Treinta";
                        break;
                    case 3:
                        score+="Cuarenta";
                        break;
                }
            }
        }
        return score;
    } 
}
