
/**
 * Created by Admin on 11/07/14.
 */
public class Deutsch implements Idioma{
    private String[] p = {"Liebe", "Fünfzehn" , "Dreißig", "Vierzig"};

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
        return "Gleichstand";
    }

    @Override
    public String getVentaja() {
        return "Vorteil";
    }

    @Override
    public String getGana() {
        return "Gewinnen";
    }
}
