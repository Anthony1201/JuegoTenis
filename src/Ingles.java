/**
 * Created by Admin on 08/08/14.
 */
public class Ingles implements Idioma {
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
