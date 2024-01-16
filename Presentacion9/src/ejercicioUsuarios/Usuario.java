package ejercicioUsuarios;

public class Usuario {

	public static final int MIN_LONGITUD_CONTRASENIA = 8;

    private String nombre;
    private String contrasenia;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    @Override
    public String toString() {
        return "Usuario: " + nombre;
    }
	
}
