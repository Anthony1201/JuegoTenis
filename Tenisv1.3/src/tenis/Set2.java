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


public class Set2 {
    
    private int p2;
    private int p1;
    private String p1N;
    private String p2N;
    private String[] p;
    private Idioma i;
    public Set2(String p1N, String p2N, String idioma) {
        this.p1N = p1N;
        this.p2N = p2N;
       setIdioma(idioma);
    }
    
    public void setIdioma(String idioma){
        int intIdioma = idioma.equalsIgnoreCase("Es")?1:idioma.equalsIgnoreCase("En")?2:idioma.equalsIgnoreCase("Fr")?3:4;
        switch (intIdioma){
            case 1:
                i = new Espanol();
                this.p = i.getIdioma();
                break;
            case 2:
                i = new ingles();
                this.p = i.getIdioma();
                break;
            case 3:
                i = new French();
                this.p = i.getIdioma();
                break;
            case 4:
                i = new Deutsch();
                this.p = i.getIdioma();
                break;
        }
    }
    
    public void resetScore () {
        p1 = 0;
        p2 = 0;
    }

    public String getScore() {
        String s;
        
        if (p1 < 4 && p2 < 4 && !(p1 + p2 == 6)) {
            s = p[p1];
            return (p1 == p2) ? s + p[4] : s + "-" + p[p2];
        } else {
            if (p1 == p2)
                return p[5];
            s = p1 > p2 ? p1N : p2N;
            return ((p1-p2)*(p1-p2) == 1) ? p[6] + s : p[7] + s;
        }
    }
    
    public void wonPoint(String playerName) {
        if (playerName == "player1")
            this.p1 += 1;
        else
            this.p2 += 1;
        
    }

    public String getPlayer1(){
        return p1+"";
    }

    public String getPlayer2(){
        return p2+"";
    }

    public void setPlayer1(int points) {
        p1=points;
    }

    public void setPlayer2(int points) {
        p2=points;
    }
}
