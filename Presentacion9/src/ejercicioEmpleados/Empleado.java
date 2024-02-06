package ejercicioEmpleados;

public class Empleado {

	private String nif;
	private String nombre;
	private double sueldoBase;
	private int horasExtras;
	private double tipoIRPF;
	private String casado;
	private int numeroHijos;
	private static double pagoPorHoraExtra;

	public Empleado() {
	}

	public Empleado(String nif) {
		this.nif = nif;
	}

	public Empleado(String nif, String nombre, double sueldoBase, int horasExtras, double tipoIRPF, String casado,
			int numeroHijos) {
		this.nif = nif;
		this.nombre = nombre;
		this.sueldoBase = sueldoBase;
		this.horasExtras = horasExtras;
		this.tipoIRPF = tipoIRPF;
		this.casado = casado;
		this.numeroHijos = numeroHijos;
	}

	public String getCasado() {
		return casado;
	}

	public void setCasado(String casado) {
		this.casado = casado;
	}

	public int getHorasExtras() {
		return horasExtras;
	}

	public void setHorasExtras(int horasExtras) {
		this.horasExtras = horasExtras;
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

	public int getNumeroHijos() {
		return numeroHijos;
	}

	public void setNumeroHijos(int numeroHijos) {
		this.numeroHijos = numeroHijos;
	}

	public double getSueldoBase() {
		return sueldoBase;
	}

	public void setSueldoBase(double sueldoBase) {
		this.sueldoBase = sueldoBase;
	}

	public double getTipoIRPF() {
		return tipoIRPF;
	}

	public void setTipoIRPF(double tipoIRPF) {
		this.tipoIRPF = tipoIRPF;
	}

	public static double getPagoPorHoraExtra() {
		return pagoPorHoraExtra;
	}

	public static void setPagoPorHoraExtra(double pagoPorHoraExtra) {
		Empleado.pagoPorHoraExtra = pagoPorHoraExtra;
	}

	public double calcularImporteHorasExtras() {
		return horasExtras * pagoPorHoraExtra;
	}

	public double calcularSueldoBruto() {
		return sueldoBase + calcularImporteHorasExtras();
	}

	public double calcularRetencionIrpf() {

        double retencion = 0;
        final double porcentaje=100;
        double IRPF;

        if(this.casado.equals("S")) {
            IRPF=(tipoIRPF - 2- numeroHijos) / porcentaje;
        } 
        else {
            IRPF=(tipoIRPF - numeroHijos) / porcentaje;
        }
        
        retencion=calcularSueldoBruto()*IRPF;


        return retencion;
    }

	public double calcularSueldo() {
		return calcularSueldoBruto() - calcularRetencionIrpf();
	}

	public String toString() {
		return String.format(
				"%s %s\nSueldo Base: %.2f\nHoras Extras: %d\ntipo IRPF: %.1f\nCasado: %c\nNúmero de Hijos: %d", nif,
				nombre, sueldoBase, horasExtras, tipoIRPF, casado, numeroHijos);
	}
}
