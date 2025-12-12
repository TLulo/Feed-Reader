package namedEntity.Classes.Lugar;

public class Pais extends Lugar {
	private String nombre;
	private int poblacion;
	private String idioma;

	public Pais(String nombre) {
		super(nombre, "Pais");
		this.nombre = nombre;
		this.poblacion = 0;
		this.idioma = "";
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public int getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(int poblacion) {
		this.poblacion = poblacion;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();

		String poblacion = (this.poblacion > 0) ? String.valueOf(this.poblacion) : "Desconocida";
		String idioma = (this.idioma != null && !this.idioma.isEmpty()) ? this.idioma : "Desconocido";
		
		sb.append("Población: ").append(poblacion).append("\n");
		sb.append("Idioma: ").append(idioma).append("\n");
		return super.toString() + sb.toString();
	}

	public void prettyPrint() {
		System.out.println(this.toString());
	}

	public static void main(String[] args) {
		Pais Argentina = new Pais("Argentina");
		Argentina.setPoblacion(50000000);
		Argentina.setIdioma("Español");

		Argentina.prettyPrint();
	}
}
