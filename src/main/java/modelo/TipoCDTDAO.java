package modelo;

import java.util.ArrayList;

public class TipoCDTDAO {

    public static ArrayList<TipoCDT> lista_T = new ArrayList<TipoCDT>();

    public static void cargaDatos() {
        if (lista_T.isEmpty()) {
            lista_T.add(new TipoCDT(0, "CDT Corto Plazo (30-179 días)",   0.07));
            lista_T.add(new TipoCDT(1, "CDT Mediano Plazo (180-359 días)", 0.10));
            lista_T.add(new TipoCDT(2, "CDT Largo Plazo (360-720 días)",   0.12));
            lista_T.add(new TipoCDT(3, "CDT Premium (más de 720 días)",    0.14));
        }
    }
}

