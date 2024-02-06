package clases;

public class Venta {
	
	// Atributos
	private int codigoVenta;
	private int codigoCliente;
	private int codigoProducto;
	private int cantidad;
	private double precio;
	private String fecha;
	
	// Contructor
	public Venta(int codigoVenta, int codigoCliente, int codigoProducto, int cantidad, double precio, String fecha) {
		this.codigoVenta = codigoVenta;
		this.codigoCliente = codigoCliente;
		this.codigoProducto = codigoProducto;
		this.cantidad = cantidad;
		this.precio = precio;
		this.fecha = fecha;
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
	

	
	
	
}
