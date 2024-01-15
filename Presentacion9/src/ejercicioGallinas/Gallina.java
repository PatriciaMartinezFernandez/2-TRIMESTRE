package boletinGallina;

public class Gallina {

	private String nombre;
	private double peso;
	private int contadorHuevos = 0;

	public static final String ROJO = "\u001B[31m";
	public static final String VERDE = "\u001B[32m";
	public static final String AMARILLO = "\u001B[33m";
	public static final String RESET = "\u001B[0m";

	public Gallina(String nombre, double peso) {
		this.nombre = nombre;
		setPeso(peso);
	}

	public Gallina(double peso) {
		setPeso(peso);
	}

	public void setPeso(double peso) {
		final double PESO_MAXIMO = 3000;
		if (peso > PESO_MAXIMO) {
			this.peso = PESO_MAXIMO;
		} else
			this.peso = peso;
	}

	public void comer(double cantidad) {
		if (verificarPeso(cantidad) == true) {
			this.peso += cantidad;
			System.out.println(AMARILLO + "%s ha engordado %.2f gramos, ahora su peso es de %.2f kg."
					.formatted(this.nombre, cantidad, this.peso) + RESET);
		} else
			System.out.println(ROJO + "%s no puede comer más.".formatted(this.nombre) + RESET);
	}

	public void ponerHuevo() {
		contadorHuevos++;
		final double PERDIDA_POR_HUEVO = 100;
		this.peso -= PERDIDA_POR_HUEVO;
		System.out.println(VERDE
				+ "%s ha puesto un huevo, ahora su peso es de %.2f kg.".formatted(this.nombre, this.peso) + RESET);
	}

	public int totalHuevos() {
		int totalHuevos = 0;
		totalHuevos += contadorHuevos;
		
		return totalHuevos;

	}

	public boolean esPosiblePonerHuevo() {
		final double PESO_NECESARIO = 1000;
		boolean esPosiblePonerHuevo;

		if (this.peso >= PESO_NECESARIO) {
			esPosiblePonerHuevo = true;
			ponerHuevo();
		}

		else {
			esPosiblePonerHuevo = false;
		}

		return esPosiblePonerHuevo;
	}

	public void infoGallina() {
		System.out.println("========================");
		System.out.println("Nombre: %s".formatted(this.nombre));
		System.out.println("Peso: %.2f kg".formatted(this.peso));
		System.out.println("Huevos puestos: %d".formatted(this.contadorHuevos));

	}

	private boolean verificarPeso(double cantidad) {
		final double PESO_MAXIMO = 3000;
		boolean pesoCorrecto;

		if ((this.peso + cantidad) <= PESO_MAXIMO) {
			pesoCorrecto = true;
		} else
			pesoCorrecto = false;

		return pesoCorrecto;
	}

	private boolean verificarNumGallinas(int numGallinas, int maxGallinasEnGranja) {
		boolean gallinasCorrecto;

		if (numGallinas > maxGallinasEnGranja) {
			gallinasCorrecto = false;
		} else
			gallinasCorrecto = true;

		return gallinasCorrecto;
	}

	public int anadirGallina(int numGallinas, int maxGallinasEnGranja, int gallinasNuevas) {
		if (verificarNumGallinas(numGallinas, maxGallinasEnGranja)
				&& (numGallinas + gallinasNuevas) <= maxGallinasEnGranja) {
			numGallinas += gallinasNuevas;
			System.out.println("Se han añadido %d gallinas nuevas.".formatted(gallinasNuevas));
		} else {
			System.out.println("No es posible añadir más gallinas.");
		}
		return numGallinas;
	}

}
