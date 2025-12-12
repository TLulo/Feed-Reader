package namedEntity.Classes;

import namedEntity.NamedEntity;

public class Fecha extends NamedEntity {
	private String precisa;
	private String canonica;

	public Fecha(String canonica){
		super(canonica, "Fecha", 1);
		this.precisa = "Desconocida";
		this.canonica = canonica;
	}

	public String getPrecisa() {
		return precisa;
	}

	public void setPrecisa(String precisa) {
		this.precisa = precisa;
	}

	public String getCanonica() {
		return canonica;
	}

	public void setCanonica(String canonica) {
		this.canonica = canonica;
	}

	public String toString() {
        StringBuilder sb = new StringBuilder();
		
        sb.append("Precisa: ").append(precisa).append("\n");
        sb.append("Canónica: ").append(canonica).append("\n");
        return super.toString() + sb.toString();
	}

	public void prettyPrint(){
		System.out.println(this.toString());
	}

	public static void main(String[] args){
		Fecha fecha = new Fecha("2023-10-01");
		fecha.setPrecisa("01 de octubre de 2023");
		fecha.setCanonica("2023-10-01");

		fecha.prettyPrint();
	}
}
