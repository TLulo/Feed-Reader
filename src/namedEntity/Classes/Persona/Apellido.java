package namedEntity.Classes.Persona;

import namedEntity.NamedEntity;

public class Apellido extends Persona {
	private String formaCanonica;
	private String origen;

	public Apellido(String formaCanonica) {
		super(formaCanonica, "Apellido");
		this.formaCanonica = formaCanonica;
		this.origen = "Desconocido";
	}

	public String getFormaCanonica() {
		return formaCanonica;
	}

	public void setFormaCanonica(String formaCanonica) {
		this.formaCanonica = formaCanonica;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("Forma canónica: ").append(formaCanonica).append("\n");
		sb.append("Origen: ").append(origen).append("\n");
		return super.toString() + sb.toString();
	}

	public void prettyPrint() {
		System.out.println(this.toString());
	}

	public static void main(String[] args) {
		Apellido apellido = new Apellido("Sierra");
		apellido.setOrigen("Colombia");
		apellido.prettyPrint();

		Apellido apellido2 = new Apellido("Tula");
		apellido2.setOrigen("Argentina");
		apellido2.prettyPrint();
	}
}
