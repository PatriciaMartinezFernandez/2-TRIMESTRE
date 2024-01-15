package ejercicioAlumnos;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		String nombre;
		String apellidos;
		String email;
		int edad;
		String telefono;

		Scanner sc = new Scanner(System.in);
		Alumno alumno = new Alumno();
		Alumno alumnos[] = new Alumno[2];

		for (int i = 0; i < alumnos.length; i++) {

			System.out.print("Nombre: ");
			nombre = sc.next();
			System.out.print("Apellidos: ");
			apellidos = sc.next();
			System.out.print("Email: ");
			email = sc.next();
			System.out.print("Edad: ");
			edad = sc.nextInt();
			System.out.print("Teléfono: ");
			telefono = sc.next();

			alumnos[i] = new Alumno(nombre, apellidos, email, edad, telefono);

			System.out.println("¿Es mayor de edad?: " + alumno.MayorEdad(edad));

		}

		Alumno alumnoMasJoven = Alumno.encontrarAlumnoMasJoven(alumnos);

        if (alumnoMasJoven != null) {
            System.out.println("El alumno más joven es: " + alumnoMasJoven.getNombre() + " " + alumnoMasJoven.getApellidos());
        } else {
            System.out.println("No hay alumnos en el array.");
        }

		sc.close();

	}

}
