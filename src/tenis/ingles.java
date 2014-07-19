package tenis;

/**
 * Created by Admin on 11/07/14.
 */
public class ingles implements Idioma {
    private String[] frases = new String[]{"Love", "Fifteen", "Thirty", "Forty"};

    @Override
    public String getFrase(int posicion) {
        return frases[posicion];
    }

    @Override
    public String getIguales() {
        return "-All";
    }

    @Override
    public String getEmpate() {
        return "Deuce";
    }

    @Override
    public String getVentaja() {
        return "Advantage ";
    }

    @Override
    public String getGana() {
        return "Win for ";
    }
}
