package modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class CDT extends Persona implements Serializable {

    private static final long serialVersionUID = 1L;

    private LocalDate fecha_reg;
    private double inversion;
    private double interes;
    private double plazo;
    private double ganancia;
    private double valorFuturo;
    private double impuesto;
    private TipoCDT tipo_cdt;

    private static final double ANIO = 360;

    public CDT() {
        super();
        tipo_cdt = new TipoCDT();
    }

    public CDT(long id_p, String nombres, String apellidos, String telefono, String correo,
               LocalDate fecha_reg, double inversion, double interes, double plazo, TipoCDT tipo_cdt) {
        super(id_p, nombres, apellidos, telefono, correo);
        this.fecha_reg = fecha_reg;
        this.inversion = inversion;
        this.interes   = interes;
        this.plazo     = plazo;
        this.tipo_cdt  = tipo_cdt;
    }

    public LocalDate getFecha_reg() { return fecha_reg; }
    public void setFecha_reg(LocalDate fecha_reg) { this.fecha_reg = fecha_reg; }

    public double getInversion() { return inversion; }
    public void setInversion(double inversion) { this.inversion = inversion; }

    public double getInteres() { return interes; }
    public void setInteres(double interes) { this.interes = interes; }

    public double getPlazo() { return plazo; }
    public void setPlazo(double plazo) { this.plazo = plazo; }

    public double getGanancia() { return ganancia; }
    public void setGanancia(double ganancia) { this.ganancia = ganancia; }

    public double getValorFuturo() { return valorFuturo; }
    public void setValorFuturo(double valorFuturo) { this.valorFuturo = valorFuturo; }

    public double getImpuesto() { return impuesto; }
    public void setImpuesto(double impuesto) { this.impuesto = impuesto; }

    public TipoCDT getTipo_cdt() { return tipo_cdt; }
    public void setTipo_cdt(TipoCDT tipo_cdt) { this.tipo_cdt = tipo_cdt; }

    public void calcular() {
        ganancia    = inversion * (interes * (plazo / ANIO));
        valorFuturo = inversion + ganancia;
        impuesto    = ganancia * 0.04;
    }

    @Override
    public int hashCode() {
        return 31 * super.hashCode() + Objects.hash(fecha_reg, inversion, tipo_cdt);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!super.equals(obj) || getClass() != obj.getClass()) return false;
        CDT other = (CDT) obj;
        return Objects.equals(fecha_reg, other.fecha_reg)
                && Double.compare(inversion, other.inversion) == 0
                && Objects.equals(tipo_cdt, other.tipo_cdt);
    }

    @Override
    public String toString() {
        return "CDT [nombres=" + getNombres() + ", apellidos=" + getApellidos()
                + ", inversion=" + inversion + ", ganancia=" + ganancia + ", tipo_cdt=" + tipo_cdt + "]";
    }
}

