package namedEntity.Classes.Persona;

import namedEntity.NamedEntity;
import subscription.Counter;

public class Persona extends NamedEntity{
	private int ID;
	private Counter counter = new Counter();

	public Persona(String name, String category) {
		super(name, category, 1);
		counter.increment();
		this.ID = counter.getValue();
	}

	public int getID() {
		return ID;
	}

	public String toString() {
		return super.toString() + "ID: " + ID + "\n";
	}

	public void prettyPrint() {
		System.out.println(this.toString());
	}


	public static void main(String[] args) {
		Persona person = new Persona("Juan Perez", "Persona");
		person.prettyPrint();

		Persona person2 = new Persona("Maria Lopez", "Persona");
		person2.prettyPrint();

		System.out.println("Total personas creadas: " + person.counter.getValue());
	}
}
