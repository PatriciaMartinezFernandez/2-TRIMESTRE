package ejercicioAlumnos;

import java.util.Objects;

public class Alumno {

	private String nombre;
	private String apellidos;
	private String email;
	private int edad;
	private String telefono;

	public Alumno() {

	}

	public Alumno(String nombre, String apellidos, int edad) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
	}

	public Alumno(String nombre, String apellidos, String email, int edad, String telefono) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.edad = edad;
		this.telefono = telefono;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		if (edad < 0) {
			this.edad = 0;
		} else {
			this.edad = edad;
		}
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public int hashCode() {
		return Objects.hash(apellidos, edad, email, nombre, telefono);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alumno other = (Alumno) obj;
		return Objects.equals(apellidos, other.apellidos) && edad == other.edad && Objects.equals(email, other.email)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(telefono, other.telefono);
	}

	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", apellidos=" + apellidos + ", email=" + email + ", edad=" + edad
				+ ", telefono=" + telefono + "]";
	}

	public boolean MayorEdad(int edad) {
		boolean mayorEdad = false;
		final int MAYORIA = 18;

		if (edad >= MAYORIA) {
			mayorEdad = true;
			return mayorEdad;
		} else {
			return mayorEdad;
		}
	}

	public static Alumno encontrarAlumnoMasJoven(Alumno[] alumnos) {
		if (alumnos.length == 0) {
			return null;
		}

		Alumno masJoven = alumnos[0];

		for (int i = 1; i < alumnos.length; i++) {
			if (alumnos[i].getEdad() < masJoven.getEdad()) {
				masJoven = alumnos[i];
			}
		}

		return masJoven;
	}

}
