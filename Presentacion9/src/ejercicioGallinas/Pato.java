package ejercicioGallinas;

public class Pato extends Gallina {
	
	private int numero;
	
	public Pato(int numero, double peso) {
        super(String.valueOf(numero), peso);
        this.numero = numero;
    }
    
    public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public void comerPato(double cantidad) {
        if (verificarPeso(cantidad / 3)) {
            double aumentoPeso = cantidad / 3;
            setPeso(getPeso()+ aumentoPeso);
            System.out.println(Gallina.AMARILLO + "El pato %d ha engordado %.2f gramos, ahora su peso es de %.2f kg.".formatted(numero, aumentoPeso, getPeso()) + Gallina.RESET);
        } else {
            System.out.println(Gallina.ROJO + "El pato %d no puede comer más.".formatted(numero) + Gallina.RESET);
        }
    }
    
    public void cuacCuac() {
    	System.out.println("%s ha graznado! Cuac, cuac".formatted(getNombre()));
    }
}
	