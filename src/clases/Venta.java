package clases;

import utilidades.Utilidades;


public class Venta {
	
	// Atributos
	private int codigoVenta; // Autogenerado y correlativo a partir de 3001
	private int codigoCliente;
	private int codigoProducto;
	private int cantidad;
	private double precio;
	private String fecha; // Formato: mm/dd/aaaa
	
	// Variables de clase
	private static int cantidadVentas;
	
	// Constantes de clase
	private static final int codigoCorrelativoAPartir;
	
	// Bloque de inicializacion static
	static {
		cantidadVentas = 0;
		codigoCorrelativoAPartir = 3001;
	}
	
	// Contructores
	public Venta(int codigoCliente, int codigoProducto, int cantidad, double precio) {
		this.codigoVenta = Venta.codigoCorrelativoAPartir + Venta.cantidadVentas;

		this.codigoCliente = codigoCliente;
		this.codigoProducto = codigoProducto;
		this.cantidad = cantidad;
		this.precio = precio;

		this.fecha = Utilidades.obtenerFechaActualFormateadoMDA();
		
		Venta.cantidadVentas++;
	}

	// Getters y setters
	public int getCodigoVenta() {
		return this.codigoVenta;
	}

	public void setCodigoVenta(int codigoVenta) {
		this.codigoVenta = codigoVenta;
	}

	public int getCodigoCliente() {
		return this.codigoCliente;
	}

	public void setCodigoCliente(int codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	public int getCodigoProducto() {
		return this.codigoProducto;
	}

	public void setCodigoProducto(int codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecio() {
		return this.precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getFecha() {
		return this.fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	// Metodos
	
	
	
}
