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
    
    private int puntosJugador2;
    private int puntosJugador1;
    private String nombreJugador1;
    private String nombreJugador2;
    private String[] frases;
    public Set2(String nombreJugador1, String nombreJugador2, String idioma) {
        this.nombreJugador1 = nombreJugador1;
        this.nombreJugador2 = nombreJugador2;
       setIdioma(idioma);
    }
    
    public void setIdioma(String idioma){
        int intIdioma = idioma.equalsIgnoreCase("Es")?1:idioma.equalsIgnoreCase("En")?2:idioma.equalsIgnoreCase("Fr")?3:4;
        switch (intIdioma){
            case 1:
                this.frases = (new Espanol()).getIdioma();
                break;
            case 2:
                this.frases = (new ingles()).getIdioma();
                break;
            case 3:
                this.frases = (new French()).getIdioma();
                break;
            case 4:
                this.frases = (new Deutsch()).getIdioma();
                break;
        }
    }
    
    public void setScoreCero() {
        puntosJugador1 = 0;
        puntosJugador2 = 0;
    }

    public String getScore() {
        String s;
        if (puntosJugador1 < 4 && puntosJugador2 < 4 && !(puntosJugador1 + puntosJugador2 == 6)) {
            s = frases[puntosJugador1];
            return (empate(puntosJugador1,puntosJugador2)) ? s + frases[4] : s + "-" + frases[puntosJugador2];
        } else {
            if (empate(puntosJugador1,puntosJugador2))
                return frases[5];
            s = puntosJugador1 > puntosJugador2 ? nombreJugador1 : nombreJugador2;
            return (Math.abs(puntosJugador1 - puntosJugador2) == 1) ? frases[6] + s : frases[7] + s;
        }
    }
    private boolean empate(int numero1,int numero2){
        if(numero1 == numero2){
            return  true;
        }else{
            return  false;
        }
    }
    public void setPunto(String jugador) {
        if (jugador == "player1")
            this.puntosJugador1 += 1;
        else
            this.puntosJugador2 += 1;
        
    }

    public String getPuntosJugador1(){
        return puntosJugador1+"";
    }

    public String getPuntosJugador2(){
        return puntosJugador2+"";
    }

    public void setPuntosJugador1(int points) {
        puntosJugador1 =points;
    }

    public void setPuntosJugador2(int points) {
        puntosJugador2 =points;
    }

    public void setNombreJugador1(String nombreJugador1) {
        this.nombreJugador1 = nombreJugador1;
    }

    public void setNombreJugador2(String nombreJugador2) {
        this.nombreJugador2 = nombreJugador2;
    }
}
