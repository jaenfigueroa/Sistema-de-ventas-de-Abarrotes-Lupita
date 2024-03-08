package app;

import clases.Cliente;
import clases.Producto;
import clases.Venta;
import frames.DashboardFrame;
import managers.ClienteManager;
import managers.ProductoManager;
import managers.VentaManager;

public class Main {

	// atributos
	public static ClienteManager clienteManager = new ClienteManager();
	public static ProductoManager productoManager = new ProductoManager();
	public static VentaManager ventaManager = new VentaManager();

	// Lanzar la aplicación
	public static void main(String[] args) {
		try {
			DashboardFrame frame = new DashboardFrame();
			frame.setVisible(true);
			
			// RELLENAR DE DATA LA APLICACIÓN
			
			clienteManager.ingresar(new Cliente("Maria", "Salvatore", "MZ B LT 4", "945645258", "12345678"));
			clienteManager.ingresar(new Cliente("Pablo", "Pinto", "MZ G LT 12", "98545555", "987654321"));
			clienteManager.ingresar(new Cliente("Luis", "Urbina", "MZ E LT 6", "4848484848", "115155151"));
			clienteManager.ingresar(new Cliente("Luciana", "Pinto", "MZ H LT 7", "15484884", "944949494"));
			clienteManager.ingresar(new Cliente("Ana", "Martinez", "MZ F LT 10", "986547854", "369852147"));
			clienteManager.ingresar(new Cliente("Diego", "Garcia", "MZ D LT 5", "978563214", "258741369"));
			clienteManager.ingresar(new Cliente("Laura", "Lopez", "MZ J LT 15", "967854321", "123456789"));
			clienteManager.ingresar(new Cliente("Sofia", "Rodriguez", "MZ C LT 8", "954875236", "987654321"));
			clienteManager.ingresar(new Cliente("Carlos", "Sanchez", "MZ I LT 13", "965874123", "654321987"));

			productoManager.ingresar(new Producto("Atún", 3.5, 80, 10, 200));
			productoManager.ingresar(new Producto("Aceite", 8.5, 80, 10, 200));
			productoManager.ingresar(new Producto("Yogurt", 5, 80, 10, 200));
			productoManager.ingresar(new Producto("Arroz", 4, 80, 10, 200));
			productoManager.ingresar(new Producto("Leche", 2.8, 80, 10, 200));
			productoManager.ingresar(new Producto("Huevos", 6, 80, 10, 200));
			productoManager.ingresar(new Producto("Pan", 1.5, 80, 10, 200));
			productoManager.ingresar(new Producto("Pasta", 2.2, 80, 10, 200));
			productoManager.ingresar(new Producto("Jugo", 4.7, 5, 10, 200));
			productoManager.ingresar(new Producto("Cereal", 3.8, 3, 10, 200));

			ventaManager.ingresar(new Venta(1001, 2001, 5));
			ventaManager.ingresar(new Venta(1002, 2002, 10));
			ventaManager.ingresar(new Venta(1003, 2003, 5));
			ventaManager.ingresar(new Venta(1004, 2004, 10));
			ventaManager.ingresar(new Venta(1001, 2001, 5));
			ventaManager.ingresar(new Venta(1002, 2002, 10));
			ventaManager.ingresar(new Venta(1003, 2001, 5));
			ventaManager.ingresar(new Venta(1004, 2004, 10));
			ventaManager.ingresar(new Venta(1001, 2004, 5));
			ventaManager.ingresar(new Venta(1002, 2003, 10));
			ventaManager.ingresar(new Venta(1003, 2001, 5));
			ventaManager.ingresar(new Venta(1004, 2001, 10));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}