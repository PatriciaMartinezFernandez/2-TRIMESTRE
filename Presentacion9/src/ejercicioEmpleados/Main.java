package ejercicioEmpleados;

import java.util.Scanner;

public class Main {
	private static void encontrarEmpleadoMaxHorasExtra(Empleado[] empleados) {

		int maxHorasExtras = 0;
		int empleado = 0;

		for (int i = 0; i < empleados.length; i++) {

			if (empleados[i].getHorasExtras() > maxHorasExtras) {
				maxHorasExtras = empleados[i].getHorasExtras();
				empleado = i;
			}

		}
		System.out.println("\nEmpleado que con más horas extra:\n" + empleados[empleado].getNombre() + " ("
				+ maxHorasExtras + " horas)");
	}

	private static void encontrarEmpleadoMinHorasExtra(Empleado[] empleados) {

		int minHorasExtras = empleados[0].getHorasExtras();
		int empleado = 0;

		for (int i = 0; i < empleados.length; i++) {

			if (empleados[i].getHorasExtras() < minHorasExtras) {
				minHorasExtras = empleados[i].getHorasExtras();
				empleado = i;
			}

		}
		System.out.println("Empleado que con menos horas extra:\n" + empleados[empleado].getNombre() + " ("
				+ minHorasExtras + " horas)");
	}

	private static void encontrarEmpleadoMaxCobra(Empleado[] empleados) {

		double maxCobra = 0;
		int empleado = 0;

		for (int i = 0; i < empleados.length; i++) {

			if (empleados[i].calcularSueldo() > maxCobra) {
				maxCobra = empleados[i].calcularSueldo();
				empleado = i;
			}
		}

		System.out.println("\nEmpleado que más cobra:\n" + empleados[empleado].getNombre() + " (" + maxCobra + "€)");

	}

	private static void encontrarEmpleadoMinCobra(Empleado[] empleados) {

		double minCobra = empleados[0].calcularSueldo();
		int empleado = 0;

		for (int i = 0; i < empleados.length; i++) {

			if (empleados[i].calcularSueldo() < minCobra) {
				minCobra = empleados[i].calcularSueldo();
				empleado = i;
			}

		}

		System.out.println("Empleado que menos cobra:\n" + empleados[empleado].getNombre() + " (" + minCobra + "€)");
	}

	public static void empleadosOrdenadosPorSalario(Empleado[] empleados) {
		Empleado tmp;

		for (int i = 0; i < empleados.length - 1; i++) {
			int posicionMin = i;
			for (int j = i + 1; j < empleados.length; j++) {
				if (empleados[j].calcularSueldo() < empleados[posicionMin].calcularSueldo()) {
					posicionMin = j;

				}

			}
			if (posicionMin != i) {
				tmp = empleados[posicionMin];
				empleados[posicionMin] = empleados[i];
				empleados[i] = tmp;
			}
		}

		for (int i = 0; i < empleados.length; i++) {
			System.out.println(empleados[i].getNombre() + " (" + empleados[i].calcularSueldo() + "€)");
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce el número total de empleados (máximo 20): ");
		int totalEmpleados = sc.nextInt();
		sc.nextLine();

		if (totalEmpleados > 20) {
			System.out.println("Número máximo de empleados excedido. Saliendo del programa.");
			return;
		}

		Empleado[] empleados = new Empleado[totalEmpleados];

		for (int i = 0; i < totalEmpleados; i++) {

			System.out.println("======================================");
			System.out.println("Introduce el DNI del empleado " + (i + 1) + ": ");
			String dni = sc.next();

			System.out.println("Introduce el nombre del empleado " + (i + 1) + ": ");
			String nombre = sc.next();

			System.out.println("Introduce el sueldo base del empleado " + (i + 1) + ": ");
			double sueldoBase = sc.nextDouble();

			System.out.println("Introduce las horas extras que hace el empleado " + (i + 1) + ": ");
			int horasExtras = sc.nextInt();

			System.out.println("Introduce el IRPF del empleado " + (i + 1) + ": ");
			double irpf = sc.nextDouble();

			System.out.println("¿Está casado el empleado " + (i + 1) + "?: ");
			String casado = sc.next();

			System.out.println("Introduce el número de hijos del empleado " + (i + 1) + ": ");
			int numeroHijos = sc.nextInt();

			empleados[i] = new Empleado(dni, nombre, sueldoBase, horasExtras, irpf, casado, numeroHijos);

		}

		System.out.println("Introduce el importe correspondiente al pago por hora extra: ");
		double pagoPorHoraExtra = sc.nextDouble();
		Empleado.setPagoPorHoraExtra(pagoPorHoraExtra);

		encontrarEmpleadoMaxCobra(empleados);
		encontrarEmpleadoMinCobra(empleados);

		encontrarEmpleadoMaxHorasExtra(empleados);
		encontrarEmpleadoMinHorasExtra(empleados);

		System.out.println("\nTodos los empleados ordenados por salario de menor a mayor:");

		empleadosOrdenadosPorSalario(empleados);

	}

}
