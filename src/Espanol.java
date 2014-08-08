/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

 *
 * @author Trainer Gold
 */
public class Espanol implements Idioma {
    private String[] p = new String[]{"Cero", "Quince", "Treinta", "Cuarenta"};

    @Override
    public String getFrase(int posicion) {
        return p[posicion];
    }

    @Override
    public String getIguales() {
        return "-iguales";
    }

    @Override
    public String getEmpate() {
        return "Empate";
    }

    @Override
    public String getVentaja() {
        return "Ventaja ";
    }

    @Override
    public String getGana() {
        return "Gana ";
    }
}
