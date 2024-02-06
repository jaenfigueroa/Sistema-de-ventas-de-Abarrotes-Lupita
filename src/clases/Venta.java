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
	private static final int CODIGO_CORRELATIVO_A_PARTIR;
	
	// Bloque de inicializacion static
	static {
		cantidadVentas = 0;
		CODIGO_CORRELATIVO_A_PARTIR = 3001;
	}
	
	// Contructores
	public Venta(int codigoCliente, int codigoProducto, int cantidad, double precio) {
		this.codigoVenta = Venta.CODIGO_CORRELATIVO_A_PARTIR + Venta.cantidadVentas;

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
	
	// Getters y Setters para variables de clase
	public static int getCantidadVentas() {
		return Venta.cantidadVentas;
	}

	public static void setCantidadVentas(int cantidadVentas) {
		Venta.cantidadVentas = cantidadVentas;
	}

	// Getters para constantes de clase
	public static int getCodigoCorrelativoAPartir() {
		return Venta.CODIGO_CORRELATIVO_A_PARTIR;
	}
	
	// Metodos
	
	
	
}
