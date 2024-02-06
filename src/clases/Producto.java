package clases;


public class Producto {
	
	// Atributos
	private int codigoProducto; // Autogenerado y correlativo a partir de 2001 
	private String nombre;
	private double precio;
	private int stockActual;
	private int stockMinimo;
	private int stockMaximo;
	
	// Variables de clase
	private static int cantidadProductos;
	
	// Constantes de clase
	private static final int codigoCorrelativoAPartir;
	
	// Bloque de inicializacion static
	static {
		cantidadProductos = 0;
		codigoCorrelativoAPartir = 2001;
	}
	
	// COntructores
	public Producto(String nombre, double precio, int stockActual, int stockMinimo, int stockMaximo) {
		this.codigoProducto =  Producto.codigoCorrelativoAPartir + Producto.cantidadProductos;
		
		this.nombre = nombre;
		this.precio = precio;
		this.stockActual = stockActual;
		this.stockMinimo = stockMinimo;
		this.stockMaximo = stockMaximo;
		
		Producto.cantidadProductos++;
	}

	// Getters y Setters
	public int getCodigoProducto() {
		return this.codigoProducto;
	}

	public void setCodigoProducto(int codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return this.precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getStockActual() {
		return this.stockActual;
	}

	public void setStockActual(int stockActual) {
		this.stockActual = stockActual;
	}

	public int getStockMinimo() {
		return this.stockMinimo;
	}

	public void setStockMinimo(int stockMinimo) {
		this.stockMinimo = stockMinimo;
	}

	public int getStockMaximo() {
		return this.stockMaximo;
	}

	public void setStockMaximo(int stockMaximo) {
		this.stockMaximo = stockMaximo;
	}
	
	// Metodos
	
	
	
}
