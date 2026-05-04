package controlador;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

import modelo.CDT;
import modelo.CDTDAO;
import modelo.TipoCDT;
import modelo.TipoCDTDAO;

import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;

@Named("cdtBean")
@RequestScoped
public class CDTBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private CDT dto = new CDT();
    private ArrayList<CDT> listaCdt = CDTDAO.lista_C;
    private ArrayList<TipoCDT> listaTipo = TipoCDTDAO.lista_T;
    private String mensaje = "";

    public CDTBean() {
        TipoCDTDAO.cargaDatos();
    }

    public CDT getDto() { return dto; }
    public void setDto(CDT dto) { this.dto = dto; }

    public ArrayList<CDT> getListaCdt() { return listaCdt; }
    public void setListaCdt(ArrayList<CDT> listaCdt) { this.listaCdt = listaCdt; }

    public ArrayList<TipoCDT> getListaTipo() { return listaTipo; }
    public void setListaTipo(ArrayList<TipoCDT> listaTipo) { this.listaTipo = listaTipo; }

    public String getMensaje() { return mensaje; }
    public void setMensaje(String mensaje) { this.mensaje = mensaje; }

    public void registrar() {
        dto.setFecha_reg(LocalDate.now());
        int idx = dto.getTipo_cdt().getCod();
        if (idx >= 0 && idx < listaTipo.size()) {
            dto.setTipo_cdt(listaTipo.get(idx));
        } else {
            mensaje = "Por favor seleccione un tipo de CDT válido.";
            return;
        }
        dto.calcular();
        listaCdt.add(dto);
        mensaje = "CDT registrado exitosamente!";
        dto = new CDT();
    }
}

