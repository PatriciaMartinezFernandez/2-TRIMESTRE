package boletinGallina;

import java.util.Scanner;

public class Main {

	public static boolean leerRespuesta(String respuesta, boolean irte) {

		if (respuesta.toLowerCase().equals("s") || respuesta.toLowerCase().equals("y")) {
			irte = true;
		} else
			irte = false;

		return irte;
	}

	public static void main(String[] args) {

		int maxGallinasEnGranja;
		int gallinasEnGranja;
		int gallinasNuevas;
		String nombre;
		double peso;
		double trigo;
		boolean irte = false;
		String respuesta;

		Scanner sc = new Scanner(System.in);

		System.out.println("\n¿Cuál es el máximo de gallinas que puede tener tu granja?");
		maxGallinasEnGranja = sc.nextInt();

		System.out.println("\n¿Cuántas gallinas tiene tu granja?");
		gallinasEnGranja = sc.nextInt();

		Gallina granja[] = new Gallina[maxGallinasEnGranja];

		while (irte != true) {

			for (int i = 0; i < gallinasEnGranja; i++) {

				System.out.println("====== #" + (i + 1) + " ======");
				System.out.print("Nombre: ");
				nombre = sc.next();
				System.out.print("Peso en gramos: ");
				peso = sc.nextDouble();

				granja[i] = new Gallina(nombre, peso);

			}

			System.out.println("\n¿Cuántos gramos de trigo vas a echarles para alimentarlas?");
			trigo = sc.nextDouble();

			for (int i = 0; i < gallinasEnGranja; i++) {

				granja[i].comer(trigo);
				granja[i].esPosiblePonerHuevo();

			}

			for (int i = 0; i < gallinasEnGranja; i++) {

				granja[i].infoGallina();

				System.out.println("\nTotal de Huevos: " + granja[i].totalHuevos());
			}
			

			System.out.println("\n¿Cuántas gallinas nuevas han llegado?");
			gallinasNuevas = sc.nextInt();
			gallinasEnGranja += granja[gallinasEnGranja - 1].anadirGallina(gallinasEnGranja, maxGallinasEnGranja, gallinasNuevas);

			System.out.println(gallinasEnGranja);

			System.out.println("¿Quieres salir de tu granja? S/N");
			respuesta = sc.next();
			irte = leerRespuesta(respuesta, irte);
		}

	}

}
