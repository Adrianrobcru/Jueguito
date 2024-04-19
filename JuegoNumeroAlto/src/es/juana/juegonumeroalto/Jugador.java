package es.juana.juegonumeroalto;

public class Jugador {
	private String usuario;
	private String contraseña;
	private String nombre;
	
	public Jugador(String usuario, String contraseña, String nombre) {
		this.usuario = usuario;
		this.contraseña = contraseña;
		this.nombre = nombre;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
}
