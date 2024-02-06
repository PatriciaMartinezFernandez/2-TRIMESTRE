package ejercicioGallinas;

import java.time.LocalTime;
import java.util.Scanner;

public class Main {

	public static boolean leerRespuesta(String respuesta, boolean irte) {

		if (respuesta.toLowerCase().equals("s") || respuesta.toLowerCase().equals("y")) {
			irte = true;
		} else
			irte = false;

		return irte;
	}

	public static void totalHuevos(Gallina granja[], int gallinasEnGranja) {
		int totalHuevos = 0;

		for (int i = 0; i < gallinasEnGranja; i++) {
			totalHuevos += granja[i].getcontadorHuevos();
		}

		System.out.println("\nTotal de Huevos: " + totalHuevos);

	}

	public static boolean compruebaDia() {
		LocalTime ahora = LocalTime.now();
		final LocalTime NOCHE = LocalTime.MAX;
		final LocalTime DIA = LocalTime.of(06, 00, 00);
		boolean dia;

		if (ahora.isBefore(DIA) && ahora.isAfter(NOCHE)) {
			dia = false;
		} else {
			dia = true;
		}

		return dia;
	}

	public static void main(String[] args) {

		int maxAnimalesEnGranja, animalesEnGranja, animalesNuevos, menu, numero = 0;
		String nombre;
		double peso, trigo;
		boolean salir = false;

		Scanner sc = new Scanner(System.in);

		if (compruebaDia() == true) {

			System.out.println("==== DIA ====");

			while (!salir) {

				System.out.println("1) Gallinas");
				System.out.println("2) Patos");
				System.out.println("3) Codornices");
				menu = sc.nextInt();

				switch (menu) {

				case 1:
					System.out.println("\n¿Cuál es el máximo de gallinas que puede tener tu granja?");
					maxAnimalesEnGranja = sc.nextInt();

					System.out.println("\n¿Cuántas gallinas tiene tu granja?");
					animalesEnGranja = sc.nextInt();

					Gallina granja[] = new Gallina[maxAnimalesEnGranja];

					for (int i = 0; i < animalesEnGranja; i++) {

						System.out.println("====== #" + (i + 1) + " ======");
						System.out.print("Nombre: ");
						nombre = sc.next();
						System.out.print("Peso en gramos: ");
						peso = sc.nextDouble();

						granja[i] = new Gallina(nombre, peso);

					}

					System.out.println("\n¿Cuántos gramos de trigo vas a echarles para alimentarlas?");
					trigo = sc.nextDouble();

					for (int i = 0; i < animalesEnGranja; i++) {

						granja[i].comer(trigo);
						granja[i].esPosiblePonerHuevo();

					}

					for (int i = 0; i < animalesEnGranja; i++) {

						granja[i].infoGallina();

					}

					totalHuevos(granja, animalesEnGranja);

					System.out.println("\n¿Cuántas gallinas nuevas han llegado?");
					animalesNuevos = sc.nextInt();
					animalesEnGranja += granja[animalesEnGranja - 1].anadirGallina(animalesEnGranja,
							maxAnimalesEnGranja, animalesNuevos);
					break;

					
				case 2:
					
					System.out.println("\n¿Cuál es el máximo de patos que puede tener tu granja?");
					maxAnimalesEnGranja = sc.nextInt();

					System.out.println("\n¿Cuántos patos tiene tu granja?");
					animalesEnGranja = sc.nextInt();

					Pato granjaPato[] = new Pato[maxAnimalesEnGranja];

					for (int i = 0; i < animalesEnGranja; i++) {
						numero++;
						System.out.println("====== #" + (i + 1) + " ======");
						System.out.print("Peso en gramos: ");
						peso = sc.nextDouble();

						granjaPato[i] = new Pato(numero, peso);

					}

					System.out.println("\n¿Cuántos gramos de trigo vas a echarles para alimentarlos?");
					trigo = sc.nextDouble();

					for (int i = 0; i < animalesEnGranja; i++) {

						granjaPato[i].comerPato(trigo);
						granjaPato[i].esPosiblePonerHuevo();
						granjaPato[i].cuacCuac();

					}

					for (int i = 0; i < animalesEnGranja; i++) {

						granjaPato[i].infoGallina();

					}

					totalHuevos(granjaPato, animalesEnGranja);

					System.out.println("\n¿Cuántos patos nuevos han llegado?");
					animalesNuevos = sc.nextInt();
					animalesEnGranja += granjaPato[animalesEnGranja - 1].anadirGallina(animalesEnGranja,
							maxAnimalesEnGranja, animalesNuevos);
					break;
					
				case 3:
					
					System.out.println("\n¿Cuál es el máximo de codornices que puede tener tu granja?");
					maxAnimalesEnGranja = sc.nextInt();

					System.out.println("\n¿Cuántas codornices tiene tu granja?");
					animalesEnGranja = sc.nextInt();

					Codorniz granjaCodorniz[] = new Codorniz[maxAnimalesEnGranja];

					for (int i = 0; i < animalesEnGranja; i++) {
						numero++;
						System.out.println("====== #" + (i + 1) + " ======");
						System.out.print("Nombre: ");
						nombre = sc.next();
						System.out.print("Peso en gramos: ");
						peso = sc.nextDouble();

						granjaCodorniz[i] = new Codorniz(nombre, peso);

					}

					System.out.println("\n¿Cuántos gramos de trigo vas a echarles para alimentarlas?");
					trigo = sc.nextDouble();

					for (int i = 0; i < animalesEnGranja; i++) {

						granjaCodorniz[i].comer(trigo);
						granjaCodorniz[i].esPosiblePonerHuevo();
						granjaCodorniz[i].cuchichiCuchichi();

					}

					for (int i = 0; i < animalesEnGranja; i++) {

						granjaCodorniz[i].infoGallina();

					}

					totalHuevos(granjaCodorniz, animalesEnGranja);

					System.out.println("\n¿Cuántas codornices nuevas han llegado?");
					animalesNuevos = sc.nextInt();
					animalesEnGranja += granjaCodorniz[animalesEnGranja - 1].anadirGallina(animalesEnGranja,
							maxAnimalesEnGranja, animalesNuevos);
					break;
				}

			}
		} else {
			System.out.println("==== NOCHE ====");
			System.out.println("Los animales están dormidos, vuelve después de las 6AM");
		}

	}

}
