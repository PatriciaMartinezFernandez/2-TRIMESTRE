package ejercicioEmpleados;

public class Empleado {

	private String nif;
	private String nombre;
	private double sueldoBase;
	private int horasExtras;
	private double irpf;
	private boolean casado;
	private int numHijos;
	static double importeHoraExtra;

	public Empleado(String nif, String nombre, double sueldoBase, int horasExtras, double irpf, boolean casado,
			int numHijos) {
		this.nif = nif;
		this.nombre = nombre;
		this.sueldoBase = sueldoBase;
		this.horasExtras = horasExtras;
		this.irpf = irpf;
		this.casado = casado;
		this.numHijos = numHijos;
	}

	public Empleado(String nif) {
		this.nif = nif;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getSueldoBase() {
		return sueldoBase;
	}

	public void setSueldoBase(double sueldoBase) {
		this.sueldoBase = sueldoBase;
	}

	public int getHorasExtras() {
		return horasExtras;
	}

	public void setHorasExtras(int horasExtras) {
		this.horasExtras = horasExtras;
	}

	public double getIrpf() {
		return irpf;
	}

	public void setIrpf(double irpf) {
		this.irpf = irpf;
	}

	public boolean isCasado() {
		return casado;
	}

	public void setCasado(boolean casado) {
		this.casado = casado;
	}

	public int getNumHijos() {
		return numHijos;
	}

	public void setNumHijos(int numHijos) {
		this.numHijos = numHijos;
	}

	public static double getImporteHoraExtra() {
		return importeHoraExtra;
	}

	public static void setImporteHoraExtra(double importeHoraExtra) {
		Empleado.importeHoraExtra = importeHoraExtra;
	}

	public void horasExtrasRealizadas() {
		
	}
	
}
