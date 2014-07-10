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
public class Tenis {

    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;

    public Tenis(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == player1Name)//"player1")
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
                        score = "Love-All";
                    break;
                case 1:
                        score = "Fifteen-All";
                    break;
                case 2:
                        score = "Thirty-All";
                    break;
                default:
                        score = "Deuce";
                    break;
                
            }
        }
        else if (m_score1>=4 || m_score2>=4)
        {
            int minusResult = m_score1-m_score2;
            if (minusResult==1) score ="Advantage Player1";
            else if (minusResult ==-1) score ="Advantage Player2";
            else if (minusResult>=2) score = "Win for Player1";
            else score ="Win for player2";
        }
        else
        {
            for (int i=1; i<3; i++)
            {
                if (i==1) tempScore = m_score1;
                else { score+="-"; tempScore = m_score2;}
                switch(tempScore)
                {
                    case 0:
                        score+="Love";
                        break;
                    case 1:
                        score+="Fifteen";
                        break;
                    case 2:
                        score+="Thirty";
                        break;
                    case 3:
                        score+="Forty";
                        break;
                }
            }
        }
        return score;
    }
    
 public static void main (String[]args){
 Tenis juego = new Tenis("Anthony","Diego");
 juego.wonPoint("Anthony");
 System.out.println(juego.getScore());
 juego.wonPoint("Anthony");
 System.out.println(juego.getScore());
 juego.wonPoint("Anthony");
 System.out.println(juego.getScore());
 juego.wonPoint("Diego");
 System.out.println(juego.getScore());
 juego.wonPoint("Diego");
 System.out.println(juego.getScore());
 juego.wonPoint("Diego");
 System.out.println(juego.getScore());
 juego.wonPoint("Anthony");
 System.out.println(juego.getScore());
 juego.wonPoint("Diego");
 System.out.println(juego.getScore());
 juego.wonPoint("Diego");
 System.out.println(juego.getScore());
 juego.wonPoint("Anthony");
 System.out.println(juego.getScore());
 juego.wonPoint("Anthony");
 System.out.println(juego.getScore());
 juego.wonPoint("Anthony");
 System.out.println(juego.getScore());

 
 }
    
    
}
