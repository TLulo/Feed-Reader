package namedEntity.Classes.Persona;

import java.util.ArrayList;
import java.util.List;

import namedEntity.NamedEntity;

public class Nombre extends Persona {
	private String formaCanonica;
	private String origen;
	private List<String> formasAlternativas;

	public Nombre(String formaCanonica) {
		super(formaCanonica, "Nombre");
		this.formaCanonica = formaCanonica;
		this.origen = "Desconocido";
		this.formasAlternativas = null;
	}

	public String getFormaCanonica() {
		return formaCanonica;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public List<String> getFormasAlternativas() {
		return formasAlternativas;
	}

	public void setFormasAlternativas(List<String> formasAlternativas) {
		this.formasAlternativas = formasAlternativas;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("Forma canónica: ").append(formaCanonica).append("\n");
		sb.append("Origen: ").append(origen).append("\n");
		sb.append("Formas alternativas: ").append(formasAlternativas).append("\n");
		return super.toString() + sb.toString();
	}

	public void prettyPrint() {
		System.out.println(this.toString());
	}

	public static void main(String[] args) {
		Nombre nombre = new Nombre("Sebastian");
		List<String> formasAlternativas = List.of("Sebas", "Seba");
		nombre.setFormasAlternativas(formasAlternativas);
		nombre.setOrigen("Colombia");
		nombre.prettyPrint();

		Nombre nombre2 = new Nombre("Luciano");
		nombre2.setFormasAlternativas(List.of("Lulo", "Lalo"));
		nombre2.setOrigen("Argentina");
		nombre2.prettyPrint();
	}
}
