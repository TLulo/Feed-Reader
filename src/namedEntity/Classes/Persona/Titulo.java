package namedEntity.Classes.Persona;

import namedEntity.NamedEntity;

public class Titulo extends Persona {
	private String formaCanonica;
	private String profesion;

	public Titulo(String formaCanonica) {
		super(formaCanonica, "Titulo");
		this.formaCanonica = formaCanonica;
		this.profesion = "Desconocida";
	}

	public String getFormaCanonica() {
		return formaCanonica;
	}

	public void setFormaCanonica(String formaCanonica) {
		this.formaCanonica = formaCanonica;
	}

	public String getProfesion() {
		return profesion;
	}

	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("Forma canónica: ").append(formaCanonica).append("\n");
		sb.append("Profesión: ").append(profesion).append("\n");
		return super.toString() + sb.toString();
	}

	public void prettyPrint() {
		System.out.println(this.toString());
	}

	public static void main(String[] args) {
		Titulo titulo = new Titulo("licenciado");
		titulo.setProfesion("Computologo");
		titulo.prettyPrint();

		Titulo titulo2 = new Titulo("Ingeniero");
		titulo2.setProfesion("Ingeniero");
		titulo2.prettyPrint();
	}
}
