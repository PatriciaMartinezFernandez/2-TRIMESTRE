package ejercicioUsuarios;

import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);
	static final String ROJO = "\u001B[31m";
	static final String RESET = "\u001B[0m";

	private static void mostrarUsuarios(Usuario[] matrizUsuarios) {
		System.out.println("\nUsuarios registrados:");
		for (Usuario usuario : matrizUsuarios) {
			System.out.println(usuario);
		}
	}

	public static void main(String[] args) {

		Usuario[] matrizUsuarios = new Usuario[5];

		cargarMatrizUsuarios(matrizUsuarios);

		mostrarUsuarios(matrizUsuarios);
	}

	private static void cargarMatrizUsuarios(Usuario[] matrizUsuarios) {
		for (int i = 0; i < matrizUsuarios.length; i++) {
			System.out.println("==== Usuario #" + (i + 1) + " ====");
			matrizUsuarios[i] = new Usuario();
			System.out.print("Nombre de usuario: ");
			matrizUsuarios[i].setNombre(sc.next());

			boolean contraseniaValida = false;
			do {
				System.out.print("Contraseña: ");
				String contrasenia1 = sc.next();
				System.out.print("Repetir contraseña: ");
				String contrasenia2 = sc.next();

				if (contrasenia1.equals(contrasenia2) && contrasenia1.length() >= Usuario.MIN_LONGITUD_CONTRASENIA) {
					matrizUsuarios[i].setContrasenia(contrasenia1);
					contraseniaValida = true;
				} else {
					System.out.println(ROJO + "Las contraseñas no coinciden o no cumplen con la longitud mínima (8 caracteres)." + RESET);
				}
			} while (!contraseniaValida);
		}
	}

}