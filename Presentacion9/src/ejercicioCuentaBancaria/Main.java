package ejercicioCuentaBancaria;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		String titular = null;
		double cantidad = 0;
		
		System.out.println("Nombre del titular de la cuenta:");
		titular = sc.next();
		
		System.out.println("Cantidad de la cuenta:");
		cantidad = sc.nextDouble();

		Cuenta cuenta = new Cuenta(titular, cantidad);
		
		System.out.println("¿Cuánto dinero vas a ingresar?");
		cantidad = sc.nextDouble();
		cuenta.ingresar(cantidad);
		

		System.out.println("¿Cuánto dinero vas a retirar?");
		cantidad = sc.nextDouble();
		cuenta.retirar(cantidad);
		
		System.out.println("Cuenta de " + cuenta.getTitular());
		System.out.println("Cantidad de la cuenta " + cuenta.getCantidad() + "€");
	}

}
