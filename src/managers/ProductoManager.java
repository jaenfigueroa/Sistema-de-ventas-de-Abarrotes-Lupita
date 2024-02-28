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
		
		Producto producto_1 = new Producto("Atún", 3.5, 5, 10, 50);
		Producto producto_2 = new Producto("Aceite", 8.5, 10, 10, 50);
		Producto producto_3 = new Producto("Yogurt", 5, 3, 10, 50);
		Producto producto_4 = new Producto("Arroz", 4, 20, 10, 50);
		
		agregarProducto(producto_1);
		agregarProducto(producto_2);
		agregarProducto(producto_3);
		agregarProducto(producto_4);
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
		
		return productoNuevo;
	}
	
public static Producto modificarProducto(int codigoProducto, String nombres, double precio, int stockActual, int stockMinimo, int stockMaximo) {
		
		for (int i = 0; i < ProductoManager.productos.size(); i++) {

            if (ProductoManager.productos.get(i).getCodigoProducto() == codigoProducto) {
            	
            	Producto productoEncontrado = ProductoManager.productos.get(i);
            	productoEncontrado.setNombre(nombres);
            	productoEncontrado.setPrecio(precio);
            	productoEncontrado.setStockActual(stockActual);
            	productoEncontrado.setStockMinimo(stockMinimo);
            	productoEncontrado.setStockMaximo(stockMaximo);
            	
            	return productoEncontrado;
            }
		}
		return null;
	
		
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
	
public static void eliminarProducto(int codigoProductoAEliminar) {
		
		//Cliente productoEliminado = null;
		
		for (int i = 0; i < ProductoManager.productos.size(); i++) {
            if (ProductoManager.productos.get(i).getCodigoProducto() == codigoProductoAEliminar) {
            	
            	//clienteEliminado = ClienteManager.clientes.get(codigoClienteAEliminar);
            	
            	ProductoManager.productos.remove(i);
                break;
            }
		}
		
		// devolver el usuario actualizado
		//return clienteEliminado;
	}

	public static ArrayList<Producto> listarProductos() {
		return ProductoManager.productos;
	}
}
