package namedEntity.Classes;

import namedEntity.NamedEntity;
import java.util.List;
import java.util.ArrayList;

public class Otro extends NamedEntity {
	private List<String> comentarios;
	private String formaCanonica;

	public Otro(String formaCanonica) {
		super(formaCanonica, "Otro", 1);
		this.formaCanonica = formaCanonica;
		this.comentarios = new ArrayList<>();
	}

	public List<String> getComentarios() {
		return comentarios;
	}

	public void addComentario(String comentario) {
		this.comentarios.add(comentario);
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("Forma canónica: ").append(formaCanonica).append("\n");
		sb.append("Comentarios: ").append(comentarios).append("\n");
		return super.toString() + sb.toString();
	}

	public void prettyPrint() {
		System.out.println(this.toString());
	}

	public static void main(String[] args) {
		Otro otro = new Otro("Jijo");
		otro.addComentario("Comentario 1");
		otro.addComentario("Comentario 2");
		otro.prettyPrint();
	}
}
