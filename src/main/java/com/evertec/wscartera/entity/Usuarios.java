package com.evertec.wscartera.entity;

/**
* @author Oswaldo Tuberquia
**/
public class Usuarios implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idusuario;
	private String usuario;
	private String clave;
	private String nombres;
	private String correo;
	
	public Usuarios(int idusuario, String usuario, String clave, 
			String nombres, String correo) {		
		this.idusuario = idusuario;
		this.usuario = usuario;
		this.clave = clave;
		this.nombres = nombres;
		this.correo = correo;
	}
	
	public Usuarios() {}

	public int getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	
	
}
