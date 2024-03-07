package clases;

import clasesPadre.Item;

public class Producto extends Item implements interfaces.Producto {
	
	// Atributos
	private String nombre;
	private double precio;
	private int stockActual;
	private int stockMinimo;
	private int stockMaximo;
	
	private int cantidadVentasAcumuladas;
	private double cantidadImporteAcumulado;
	
	// Variables de clase
	private static int cantidadProductos;
	
	// Constantes de clase
	private static final int CODIGO_CORRELATIVO_A_PARTIR;
	
	// Bloque de inicializacion static
	static {
		cantidadProductos = 0;
		CODIGO_CORRELATIVO_A_PARTIR = 2001;
	}
	
	// Contructor
	public Producto(String nombre, double precio, int stockActual, int stockMinimo, int stockMaximo) {		
		super(CODIGO_CORRELATIVO_A_PARTIR, cantidadProductos);
		
		this.nombre = nombre;
		this.precio = precio;
		this.stockActual = stockActual;
		this.stockMinimo = stockMinimo;
		this.stockMaximo = stockMaximo;
		
		Producto.cantidadProductos++;
	}
	
	// Getters y Setters
	public int getCodigoProducto() {
		return super.codigo;
	}

	public void setCodigoProducto(int codigoProducto) {
		super.codigo = codigoProducto;
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
	
	public int getCantidadVentasAcumuladas() {
		return cantidadVentasAcumuladas;
	}

	public void setCantidadVentasAcumuladas(int cantidadVentasAcumuladas) {
		this.cantidadVentasAcumuladas = cantidadVentasAcumuladas;
	}

	public double getCantidadImporteAcumulado() {
		return cantidadImporteAcumulado;
	}

	public void setCantidadImporteAcumulado(double cantidadImporteAcumulado) {
		this.cantidadImporteAcumulado = cantidadImporteAcumulado;
	}

	// Getters y setters para variables de clase
	public static int getCantidadProductos() {
		return Producto.cantidadProductos;
	}

	public static void setCantidadProductos(int cantidadProductos) {
		Producto.cantidadProductos = cantidadProductos;
	}

	// Getters para contantes de clase
	public static int getCodigoCorrelativoAPartir() {
		return Producto.CODIGO_CORRELATIVO_A_PARTIR;
	}	
	
}
