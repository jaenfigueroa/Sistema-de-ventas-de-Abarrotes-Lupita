package managers;

import java.util.ArrayList;

import clases.Producto;

public class ProductoManager {

	// Variables de clase
	private static ArrayList<Producto> productos;
	
	// Bloque de inicialización static
	static {
		productos = new ArrayList<>();
	}
	
	// Getters y Setters para las variables de clase
	public static ArrayList<Producto> getProductos() {
		return ProductoManager.productos;
	}

	public static void setProductos(ArrayList<Producto> productos) {
		ProductoManager.productos = productos;
	}
	
	// METODOS
	public static Producto getProducto(int codigoProductoBuscado) {
		
		Producto productoEncontrado = null;

        for (Producto producto : ProductoManager.productos) {
            if (producto.getCodigoProducto() == codigoProductoBuscado) {
            	productoEncontrado = producto;
                break;
            }
        }
        
        return productoEncontrado;
	}
}
