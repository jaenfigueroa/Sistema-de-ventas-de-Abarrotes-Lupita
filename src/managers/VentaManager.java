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
	}

	// Getters y Setters para las variables de clase
	public static ArrayList<Venta> getVentas() {
		return VentaManager.ventas;
	}

	// Metodos
//	public static Venta getVenta(int codigoVentaBuscado) {
//		
//		Venta ventaEncontrada = null;
//
//        for (Venta cliente : VentaManager.ventas) {
//            if (cliente.getCodigoCliente() == codigoVentaBuscado) {
//            	ventaEncontrada = cliente;
//                break;
//            }
//        }
//        
//        return ventaEncontrada;
//	}
	
	
	// metodo que se va encargar de realizar la venta
	
	public static Venta agregarVenta(int codigoCliente, int codigoProducto, int cantidad, double precio) {
		Venta ventaNueva = new Venta(codigoCliente, codigoProducto, cantidad, precio);
		ventas.add(ventaNueva);
		
		// actualiza el stock actual del producto
		
		Producto producto = ProductoManager.consultarProducto(codigoProducto);
		int nuevoStockActual = producto.getStockActual() - cantidad;
		
		producto.setStockActual(nuevoStockActual);
		
		return ventaNueva;
	}
	
	
}
