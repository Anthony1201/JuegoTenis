import java.util.Observable;

/**
 * Created by Admin on 07/08/14.
 */
public class TennisGame extends Observable{

    private int puntosJugador2;
    private int puntosJugador1;
    private String nombreJugador1;
    private String nombreJugador2;
    private Idioma frases;
    private static TennisGame instancia;
    private boolean estado = false;
    private TennisGame() {
    }

    public void setScoreCero() {
        puntosJugador1 = 0;
        puntosJugador2 = 0;
    }

    public String getScore() {
        String s;
        if (puntosJugador1 < 4 && puntosJugador2 < 4 && !(puntosJugador1 + puntosJugador2 == 6)) {
            s = frases.getFrase(puntosJugador1);
            return (empate(puntosJugador1,puntosJugador2)) ? s + frases.getIguales() : s + "-" + frases.getFrase(puntosJugador2);
        } else {
            if (empate(puntosJugador1,puntosJugador2))
                return frases.getEmpate();
            s = puntosJugador1 > puntosJugador2 ? nombreJugador1 : nombreJugador2;
            if (Math.abs(puntosJugador1 - puntosJugador2) == 1){ return frases.getVentaja() + s; }else{ estado = false; return frases.getGana() + s;}
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

        setChanged();
        notifyObservers();

    }

    public void setIdioma(Idioma idioma){
        frases = idioma;
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

    public String getPuntosJugador1(){
        return puntosJugador1+"";
    }

    public String getPuntosJugador2(){
        return puntosJugador2+"";
    }

    public static TennisGame getInstance(){
        if(instancia == null){
            instancia = new TennisGame();
        }
        return instancia;
    }
    public boolean isEstado() {
        return estado;
    }
    public void setEstado(boolean estado){
        this.estado = estado;
    }
}
