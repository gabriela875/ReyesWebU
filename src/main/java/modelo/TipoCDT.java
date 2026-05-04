package modelo;

import java.io.Serializable;
import java.util.Objects;

public class TipoCDT implements Serializable {

    private static final long serialVersionUID = 1L;

    private int cod;
    private String nombre_tipo;
    private double tasa_referencia;

    public TipoCDT() {}

    public TipoCDT(int cod, String nombre_tipo, double tasa_referencia) {
        this.cod = cod;
        this.nombre_tipo = nombre_tipo;
        this.tasa_referencia = tasa_referencia;
    }

    public int getCod() { return cod; }
    public void setCod(int cod) { this.cod = cod; }

    public String getNombre_tipo() { return nombre_tipo; }
    public void setNombre_tipo(String nombre_tipo) { this.nombre_tipo = nombre_tipo; }

    public double getTasa_referencia() { return tasa_referencia; }
    public void setTasa_referencia(double tasa_referencia) { this.tasa_referencia = tasa_referencia; }

    @Override
    public int hashCode() { return Objects.hash(cod, nombre_tipo, tasa_referencia); }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        TipoCDT other = (TipoCDT) obj;
        return cod == other.cod
                && Objects.equals(nombre_tipo, other.nombre_tipo)
                && Double.compare(tasa_referencia, other.tasa_referencia) == 0;
    }

    @Override
    public String toString() {
        return "TipoCDT [cod=" + cod + ", nombre_tipo=" + nombre_tipo + "]";
    }
}

