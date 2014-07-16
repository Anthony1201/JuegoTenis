package tenis;

/**
 * Created by Admin on 11/07/14.
 */
public class ingles implements Idioma {
    private String[] p = new String[]{"Love", "Fifteen", "Thirty", "Forty","-All","Deuce","Advantage ","Win for "};

    @Override
    public String[] getIdioma() {
        return p;
    }
}
