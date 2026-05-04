package modelo;

//Nombre: Gabriela Reyes Luna - Codigo: 20241578123 - Grupo:302

import java.util.ArrayList;

public class ProgAcadDAO {

    public static ArrayList<ProgAcad> lista_P = new ArrayList<ProgAcad>();

    // Carga los programas academicos ofertados solo si la lista esta vacia 
    public static void cargaDatos() {
        if (lista_P.isEmpty()) {
            System.out.println("Cargando programas academicos...");
            lista_P.add(new ProgAcad(0, "Ingeniería de Sistemas"));
            lista_P.add(new ProgAcad(1, "Ingeniería Industrial"));
            lista_P.add(new ProgAcad(2, "Matemática"));
            lista_P.add(new ProgAcad(3, "Administración de Empresas"));
            lista_P.add(new ProgAcad(4, "Derecho"));
            lista_P.add(new ProgAcad(5, "Ingeniería Telemática"));
        }
    }
}

