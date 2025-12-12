package namedEntity.Classes.Lugar;

import namedEntity.NamedEntity;

public class Direccion extends Lugar {
	private String direccion;
	private Ciudad ciudad;

	public Direccion(String direccion) {
		super(direccion, "Direccion");
		this.ciudad = null;
		this.direccion = direccion;
	}

	public String getDireccion() {
		return direccion;
	}

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();

		String ciudadName = (ciudad != null) ? ciudad.getName() : "Desconocida";
		
		sb.append("Dirección: ").append(direccion).append("\n");
		sb.append("Ciudad: ").append(ciudadName).append("\n");
		return super.toString() + sb.toString();
	}

	public void prettyPrint() {
		System.out.println(this.toString());
	}

	public static void main(String[] args) {
		Direccion direc = new Direccion("Viamoente 322");
		Ciudad cordoba = new Ciudad("Cordoba");
		direc.setCiudad(cordoba);

		direc.prettyPrint();
	}
}
