package ejercicioGallinas;

public class Codorniz extends Gallina {

	public Codorniz(String nombre, double peso) {
		super(nombre, peso);
	}
	
    public void cuchichiCuchichi() {
    	System.out.println("%s ha trinado! Cuchichi, cuchichi".formatted(getNombre()));
    }
	
}
