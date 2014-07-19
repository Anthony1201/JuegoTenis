package tenis;

/**
 * Created by Admin on 18/07/14.
 */
abstract class Idiomas {
    public Idioma getIdioma(){
        if (idiomaSeleccionado() == "En") {
            return new ingles();
        } else if (idiomaSeleccionado() == "Fr") {
            return new French();
        } else if (idiomaSeleccionado() == "De") {
            return new Deutsch();
        } else if(idiomaSeleccionado() == "Es"){
            return new Espanol();
        }else{
            return null;
        }
    }
    public abstract String idiomaSeleccionado();
}
