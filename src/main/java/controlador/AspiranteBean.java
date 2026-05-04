package controlador;

//Nombre: Gabriela Reyes Luna - Codigo: 20241578123 - Grupo:302

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

import jakarta.inject.Named;
import modelo.Aspirante;
import modelo.AspiranteDAO;
import modelo.ProgAcad;
import modelo.ProgAcadDAO;
import jakarta.enterprise.context.RequestScoped;

@Named("asp")
@RequestScoped
public class AspiranteBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Aspirante dto = new Aspirante();

	private ArrayList<Aspirante> listaAs = AspiranteDAO.lista_A;

	private ArrayList<ProgAcad> listaPa = ProgAcadDAO.lista_P;

	private String mensaje = "";

	public AspiranteBean() {
		ProgAcadDAO.cargaDatos();
	}

	public Aspirante getDto() {
		return dto;
	}

	public void setDto(Aspirante dto) {
		this.dto = dto;
	}

	public ArrayList<Aspirante> getListaAs() {
		return listaAs;
	}

	public void setListaAs(ArrayList<Aspirante> listaAs) {
		this.listaAs = listaAs;
	}

	public ArrayList<ProgAcad> getListaPa() {
		return listaPa;
	}

	public void setListaPa(ArrayList<ProgAcad> listaPa) {
		this.listaPa = listaPa;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public void registrar() {
		// Asigna la fecha del sistema como fecha de registro
		dto.setFecha_reg(LocalDate.now());

		// Resuelve el programa academico seleccionado usando el indice del
		// selectOneMenu
		int idx = dto.getPro_acad().getCod();
		if (idx >= 0 && idx < listaPa.size()) {

			dto.setPro_acad(listaPa.get(idx));
		} else {
			dto.setPro_acad(null);
			mensaje = "Por favor seleccione un programa académico válido.";
			return;
		}
		listaAs.add(dto);
		System.out.println("Aspirante registrado: " + dto.toString());

		mensaje = "Aspirante registrado exitosamente!";
		dto = new Aspirante();
	}


}
