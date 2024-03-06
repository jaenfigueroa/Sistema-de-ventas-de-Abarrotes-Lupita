package managers;

import clases.Producto;
import clasesPadre.Manager;

public class ProductoManager extends Manager<Producto> {

	public Producto modificar(int codigo, String nombres, double precio, int stockActual, int stockMinimo, int stockMaximo) {

		for (int i = 0; i < items.size(); i++) {

            if (items.get(i).getCodigoProducto() == codigo) {
            	
            	Producto producto = items.get(i);

            	producto.setNombre(nombres);
            	producto.setPrecio(precio);
            	producto.setStockActual(stockActual);
            	producto.setStockMinimo(stockMinimo);
            	producto.setStockMaximo(stockMaximo);
            	
            	return producto;
            }
		}
		return null;
	}
}
