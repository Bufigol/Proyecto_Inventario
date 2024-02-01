package com.bufigol.model;

public class Bodega {
	private int idBodega;
	private String nombre;

	/**
	 * @param idBodega
	 * @param nombre
	 */
	public Bodega(int idBodega, String nombre) {
		this.idBodega = idBodega;
		this.nombre = nombre;
	}

	public int getIdBodega() {
		return idBodega;
	}

	public void setIdBodega(int idBodega) {
		this.idBodega = idBodega;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
