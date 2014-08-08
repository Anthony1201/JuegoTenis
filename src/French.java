/**
 * Created by Admin on 11/07/14.
 */
public class French implements Idioma {
    private String[] p = new String[]{"Zèro", "Quinze" , "Trente", "Quarante"};

    @Override
    public String getFrase(int posicion) {
        return p[posicion];
    }

    @Override
    public String getIguales() {
        return "-À";
    }

    @Override
    public String getEmpate() {
        return "Égalité";
    }

    @Override
    public String getVentaja() {
        return "Avantage ";
    }

    @Override
    public String getGana() {
        return "Gagner";
    }
}


