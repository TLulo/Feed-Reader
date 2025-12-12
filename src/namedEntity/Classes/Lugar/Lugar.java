package namedEntity.Classes.Lugar;

import namedEntity.NamedEntity;
import subscription.Counter;

public class Lugar extends NamedEntity {
	private int id;
	private Counter counter = new Counter();

	public Lugar(String name, String category) {
		super(name, category, 1);
		this.id = counter.getValue();
		counter.increment();
	}

	public int getId() {
		return id;
	}

	public int getCounter() {
		return counter.getValue();
	}

	public String toString() {
		return super.toString() + "ID: " + id + "\n";
	}

	public void prettyPrint() {
		System.out.println(this.toString());
	}

	public static void main(String[] args) {
		Lugar lugar = new Lugar("Cordoba", "Ciudad");
		Lugar lugar1 = new Lugar("Cordoba", "Ciudad");
		lugar.prettyPrint();
		lugar1.prettyPrint();
		System.out.println("Id de lugar: " + lugar.getId());
		System.out.println("Id de lugar1: " + lugar1.getId());

		Lugar lugar2 = new Lugar("Colombia", "Pais");
		lugar2.prettyPrint();
		System.out.println("Id de lugar2: " + lugar2.getId());
		System.out.println("Total lugares creados: " + lugar.getCounter());
	}
}
