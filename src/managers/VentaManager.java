package managers;

import java.util.ArrayList;

import clases.Producto;
import clases.Venta;

public class VentaManager {
	// Variables de clase
	private static ArrayList<Venta> ventas;
	
	// Bloque de inicialización static
	static {
		ventas = new ArrayList<>();
		
		agregarVenta(1001, 2001, 5);
		agregarVenta(1002, 2002, 10);
		agregarVenta(1003, 2003, 5);
		agregarVenta(1004, 2004, 10);
	}

	// Getters y Setters para las variables de clase
	public static ArrayList<Venta> getVentas() {
		return VentaManager.ventas;
	}

	// Metodos

	// metodo que se va encargar de realizar la venta
	
	public static Venta agregarVenta(int codigoCliente, int codigoProducto, int cantidad) {
		
//		double precio = ProductoManager.consultarProducto(codigoProducto).getPrecio();
		Venta ventaNueva = new Venta(codigoCliente, codigoProducto, cantidad);
		ventas.add(ventaNueva);
		
		// actualiza el stock actual del producto
		
		Producto producto = ProductoManager.consultarProducto(codigoProducto);
		int nuevoStockActual = producto.getStockActual() - cantidad;
		
		producto.setStockActual(nuevoStockActual);
		
		return ventaNueva;
	}
	
	
}
