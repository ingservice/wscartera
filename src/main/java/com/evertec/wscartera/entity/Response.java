package com.evertec.wscartera.entity;

import java.util.*;
/**
* @author Oswaldo Tuberquia
**/
public class Response implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String codigo;
	private String mensaje;
	private List<Cartera> objeto;

	public Response() {
	}

	public Response(String codigo, String mensaje, List<Cartera> obj) {
		super();
		this.codigo = codigo;
		this.mensaje = mensaje;
		this.objeto = obj;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo.trim();
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje.trim();
	}

	public List<Cartera> getObjeto() {
		return objeto;
	}

	public void setObjeto(List<Cartera> obj) {
		this.objeto = obj;
	}
	
	

}
