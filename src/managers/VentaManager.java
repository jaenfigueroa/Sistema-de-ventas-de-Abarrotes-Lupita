package managers;

import app.Main;
import clases.Producto;
import clases.Venta;
import clasesPadre.Manager;

public class VentaManager extends Manager<Venta> {
	
	@Override
	public void ingresar(Venta venta) {
		super.ingresar(venta);
		
		Producto producto = Main.productoManager.consultar(venta.getCodigoProducto());
		
		// actualiza el stock actual del producto
		int nuevoStockActual = producto.getStockActual() - venta.getCantidad();
		producto.setStockActual(nuevoStockActual);
		
		// actualizar la cantidad unidades vendidas		
		int nuevaCantidadVentas = producto.getCantidadVentasAcumuladas() + venta.getCantidad();
		producto.setCantidadVentasAcumuladas( nuevaCantidadVentas );
		
		// actualizar la cantidad importe total acumulado
		double nuevaCantidadImporteAcumulado = producto.getCantidadImporteAcumulado() + venta.getImporteTotalPagar();
		producto.setCantidadImporteAcumulado(nuevaCantidadImporteAcumulado);
	}
}
