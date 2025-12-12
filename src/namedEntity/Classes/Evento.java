package namedEntity.Classes;

import namedEntity.NamedEntity;
import java.util.Date;

public class Evento extends NamedEntity {
	private String formaCanonica;
	private Date fecha;
	private Boolean recurrente;

	public Evento(String formaCanonica) {
		super(formaCanonica, "Evento", 1);
		this.formaCanonica = formaCanonica;
		this.fecha = null;
		this.recurrente = null;
	}

	public String getFormaCanonica() {
		return formaCanonica;
	}

	public void setFormaCanonica(String formaCanonica) {
		this.formaCanonica = formaCanonica;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Boolean getRecurrente() {
		return recurrente;
	}

	public void setRecurrente(Boolean recurrente) {
		this.recurrente = recurrente;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		String fecha = (this.fecha != null) ? this.fecha.toString() : "Desconocida";
		String recurrente = (this.recurrente != null) ? this.recurrente.toString() : "Desconocido";

		sb.append("Forma canónica: ").append(formaCanonica).append("\n");
		sb.append("Fecha: ").append(fecha).append("\n");
		sb.append("Recurrente: ").append(recurrente).append("\n");
		return super.toString() + sb.toString();
	}

	public void prettyPrint() {
		System.out.println(this.toString());
	}

	public static void main(String[] args) {
		Evento evento = new Evento("Cumpleaños");
		evento.setFecha(new Date());
		evento.setRecurrente(true);
		evento.prettyPrint();

		Evento evento2 = new Evento("Aniversario");
		evento2.setFecha(new Date());
		evento2.setRecurrente(false);
		evento2.prettyPrint();
	}
}
