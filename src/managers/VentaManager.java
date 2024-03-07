package managers;

import app.Main;
import clases.Producto;
import clases.Venta;
import clasesPadre.Manager;

public class VentaManager extends Manager<Venta> {
	
	public Venta ingresar(int codigoCliente, int codigoProducto, int cantidad) {
		
		// double precio = ProductoManager.consultarProducto(codigoProducto).getPrecio();
		Venta ventaNueva = new Venta(codigoCliente, codigoProducto, cantidad);
		
		super.ingresar(ventaNueva);
		
		// actualiza el stock actual del producto
		Producto producto = Main.productoManager.consultar(codigoProducto);
		
		
		int nuevoStockActual = producto.getStockActual() - cantidad;
		producto.setStockActual(nuevoStockActual);
		
		// actualizar la cantidad unidades vendidas
		int nuevaCantidadVentas = producto.getCantidadVentasAcumuladas() + cantidad;
		producto.setCantidadVentasAcumuladas( nuevaCantidadVentas );
		
		// actualizar la cantidad importe total acumulado
		double nuevaCantidadImporteAcumulado = producto.getCantidadImporteAcumulado() + ventaNueva.getImporteTotalPagar();
		producto.setCantidadImporteAcumulado(nuevaCantidadImporteAcumulado);
		
		return ventaNueva;
	}
}
