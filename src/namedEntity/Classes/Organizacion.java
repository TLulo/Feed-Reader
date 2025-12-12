package namedEntity.Classes;

import namedEntity.NamedEntity;

public class Organizacion extends NamedEntity {
	private String formaCanonica;
	private int numeroDeMiembros;
	private String TipoDeOrganizacion;

	public Organizacion(String formaCanonica) {
		super(formaCanonica, "Organizacion", 1);
		this.formaCanonica = formaCanonica;
		this.numeroDeMiembros = 0;
		this.TipoDeOrganizacion = "Desconocido";
	}

	public String getFormaCanonica() {
		return formaCanonica;
	}

	public void setFormaCanonica(String formaCanonica) {
		this.formaCanonica = formaCanonica;
	}

	public int getNumeroDeMiembros() {
		return numeroDeMiembros;
	}

	public void setNumeroDeMiembros(int numeroDeMiembros) {
		this.numeroDeMiembros = numeroDeMiembros;
	}

	public String getTipoDeOrganizacion() {
		return TipoDeOrganizacion;
	}

	public void setTipoDeOrganizacion(String tipoDeOrganizacion) {
		this.TipoDeOrganizacion = tipoDeOrganizacion;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();

		String numeroDeMiembros = (this.numeroDeMiembros > 0) ? String.valueOf(this.numeroDeMiembros) : "Desconocido";
		
		sb.append("Forma canónica: ").append(formaCanonica).append("\n");
		sb.append("Número de miembros: ").append(numeroDeMiembros).append("\n");
		sb.append("Tipo de organización: ").append(TipoDeOrganizacion).append("\n");
		return super.toString() + sb.toString();
	}

	public void prettyPrint() {
		System.out.println(this.toString());
	}

	public static void main(String[] args) {
		Organizacion organizacion = new Organizacion("Organizacion Mundial de la Salud");
		organizacion.setNumeroDeMiembros(194);
		organizacion.setTipoDeOrganizacion("Salud");
		organizacion.prettyPrint();
	}
}
