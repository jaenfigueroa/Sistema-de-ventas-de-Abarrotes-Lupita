package clases;

import app.Main;
import clasesPadre.Item;
import utilidades.Utilidades;

public class Venta extends Item implements interfaces.Venta {
	
	// Atributos
//	private int codigoVenta; // Autogenerado y correlativo a partir de 3001
	private int codigoCliente;
	private int codigoProducto;
	private int cantidad;
	private double precio;
	private String fecha; // Formato: mm/dd/aaaa
	
	private final double IMPORTE_IGV = 0.18; // 18%
	
	private double importeSubtotal;
	private double impuestoPagar;
	private double importeTotalPagar;
	
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
	public Venta(int codigoCliente, int codigoProducto, int cantidad) {
		
		super(CODIGO_CORRELATIVO_A_PARTIR, cantidadVentas);
		
		double precio = Main.productoManager.consultar(codigoProducto).getPrecio();
		
		this.codigoCliente = codigoCliente;
		this.codigoProducto = codigoProducto;
		this.cantidad = cantidad;
		this.precio = precio;

		this.fecha = Utilidades.obtenerFechaActualFormateadoMDA();
		
		Venta.cantidadVentas++;
		
		// calcular
		this.importeSubtotal = cantidad * precio;
		this.impuestoPagar = this.IMPORTE_IGV * importeSubtotal;
		this.importeTotalPagar = importeSubtotal + impuestoPagar;
	}

	// Getters y setters
	public int getCodigoVenta() {
		return super.codigo;
	}

	public void setCodigoVenta(int codigoVenta) {
		super.codigo = codigoVenta;
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
	
	
	public double getImporteSubtotal() {
		return this.importeSubtotal;
	}

	public void setImporteSubtotal(double importeSubtotal) {
		this.importeSubtotal = importeSubtotal;
	}

	public double getImpuestoPagar() {
		return this.impuestoPagar;
	}

	public void setImpuestoPagar(double impuestoPagar) {
		this.impuestoPagar = impuestoPagar;
	}

	public double getImporteTotalPagar() {
		return this.importeTotalPagar;
	}

	public void setImporteTotalPagar(double importeTotalPagar) {
		this.importeTotalPagar = importeTotalPagar;
	}
	
	public double getIMPORTE_IGV() {
		return IMPORTE_IGV;
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
	public boolean comprobarStockActual(int cantidadUnidadesComprar) {
		
		Producto productoParaComprar = Main.productoManager.listar().get(this.codigoProducto);
		
		return cantidadUnidadesComprar < productoParaComprar.getStockActual();
	}
	
	public String obtenerBoleta() {
		String boleta = "BOLETA DE PAGO\n";
		
		Cliente cliente = Main.clienteManager.consultar(this.codigoCliente);
		Producto producto = Main.productoManager.consultar(this.codigoProducto);
		
		boleta += "Código del cliente: " + this.codigoCliente;
		boleta += "Nombres y apellidos del cliente: " + cliente.getNombres();
		boleta += "Código del producto: " + this.codigoProducto;
		boleta += "Nombre del producto : " + producto.getNombre();
		boleta += "Cantidad de unidades adquiridas: " + this.cantidad;
		boleta += "Precio unitario: " + this.precio;
		boleta += "Importe subtotal: " + this.importeSubtotal;
		boleta += "Importe del IGV: " + this.impuestoPagar ;
		boleta += "Importe total a pagar: " + this.importeTotalPagar ;
		
		return boleta;
	}
	
}
