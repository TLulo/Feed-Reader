package namedEntity.Classes.Lugar;

public class Ciudad extends Lugar {
	private String nombre;
	private Pais pais;
	private Boolean isCapital;
	private int poblacion;

	public Ciudad(String nombre) {
		super(nombre, "Ciudad");
		this.nombre = nombre;
		this.pais = null;
		this.isCapital = null;
		this.poblacion = 0;
	}

	public String getNombre() {
		return this.nombre;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public Boolean getIsCapital() {
		return isCapital;
	}

	public void setIsCapital(Boolean isCapital) {
		this.isCapital = isCapital;
	}

	public int getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(int poblacion) {
		this.poblacion = poblacion;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		String paisName = (pais != null) ? pais.getName() : "Desconocido";
		String isCapital = (this.isCapital != null) ? this.isCapital.toString() : "Desconocido";
		String poblacion = (this.poblacion > 0) ? String.valueOf(this.poblacion) : "Desconocida";

		sb.append("Pais: ").append(paisName).append("\n");
		sb.append("Is Capital: ").append(isCapital).append("\n");
		sb.append("Población: ").append(poblacion).append("\n");
		return super.toString() + sb.toString();
	}

	public void prettyPrint() {
		System.out.println(this.toString());
	}

	public static void main(String[] args) {
		Ciudad cordoba = new Ciudad("Cordoba");
		cordoba.setIsCapital(false);
		cordoba.setPoblacion(1000000);

		Pais Argentina = new Pais("Argentina");
		cordoba.setPais(Argentina);

		cordoba.prettyPrint();
	}
}
