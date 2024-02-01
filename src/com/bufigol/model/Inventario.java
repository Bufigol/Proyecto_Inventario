package com.bufigol.model;

public class Inventario {
	private Bodega bg;
	private Objeto obj;
	private int cantidad;

	/**
	 * @param bg
	 * @param obj
	 * @param cantidad
	 */
	public Inventario(Bodega bg, Objeto obj, int cantidad) {
		this.bg = bg;
		this.obj = obj;
		this.cantidad = cantidad;
	}

	public Bodega getBg() {
		return bg;
	}

	public void setBg(Bodega bg) {
		this.bg = bg;
	}

	public Objeto getObj() {
		return obj;
	}

	public void setObj(Objeto obj) {
		this.obj = obj;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
}
