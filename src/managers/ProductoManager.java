package managers;

import java.util.ArrayList;

import clases.Cliente;
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
	public static Producto agregarProducto(Producto productoNuevo) {
		ProductoManager.productos.add(productoNuevo);
		
		// devolver el producto recién agregado
		return ProductoManager.productos.get(productoNuevo.getCodigoProducto());
	}
	
	public static Producto modificarProducto(Producto productoConCambios) {
		
		for (int i = 0; i < ProductoManager.productos.size(); i++) {

            if (ProductoManager.productos.get(i).getCodigoProducto() == productoConCambios.getCodigoProducto()) {
            	
            	ProductoManager.productos.set(i, productoConCambios);

                break;
            }
		}
		
		// devolver el usuario actualizado
		return ProductoManager.productos.get(productoConCambios.getCodigoProducto());
	}
	
	public static Producto consultarProducto(int codigoProductoBuscado) {
		
		Producto productoEncontrado = null;

        for (Producto producto : ProductoManager.productos) {
            if (producto.getCodigoProducto() == codigoProductoBuscado) {
            	productoEncontrado = producto;
                break;
            }
        }
        
     // devolver el producto actualizado
        return productoEncontrado;
	}
	
	public static Producto eliminarProducto(int codigoProductoAEliminar) {
		
		Producto productoEliminado = null;
		
		for (int i = 0; i < ProductoManager.productos.size(); i++) {
            if (ProductoManager.productos.get(i).getCodigoProducto() == codigoProductoAEliminar) {
            	
            	productoEliminado = ProductoManager.productos.get(codigoProductoAEliminar);
            	
            	ProductoManager.productos.remove(i);
                break;
            }
		}
		
		// devolver el producto actualizado
		return productoEliminado;
	}

	public static ArrayList<Producto> listarProductos() {
		return ProductoManager.productos;
	}
}
