package namedEntity.Classes;

import namedEntity.NamedEntity;

public class Producto extends NamedEntity {
	private String name;
	private Boolean comercial;
	private String productor;

	public Producto(String name) {
		super(name, "Producto", 1);
		this.comercial = null;
		this.productor = "Desconocido";
	}

	public Boolean getComercial() {
		return comercial;
	}

	public void setComercial(Boolean comercial) {
		this.comercial = comercial;
	}

	public String getProductor() {
		return productor;
	}

	public void setProductor(String productor) {
		this.productor = productor;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		String comercial = (this.comercial != null) ? this.comercial.toString() : "Desconocido";

		sb.append("Comercial: ").append(comercial).append("\n");
		sb.append("Productor: ").append(productor).append("\n");
		return super.toString() + sb.toString();
	}

	public void prettyPrint() {
		System.out.println(this.toString());
	}

	public static void main(String[] args) {
		Producto cocaCola = new Producto("Coca Cola");
		cocaCola.setComercial(true);
		cocaCola.setProductor("Coca Cola Company");

		cocaCola.prettyPrint();
	}
}
