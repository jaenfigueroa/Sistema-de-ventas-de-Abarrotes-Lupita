import clases.Cliente;
import clases.Producto;
import frames.DashboardFrame;
import managers.ClienteManager;
import managers.ProductoManager;
import managers.VentaManager;

public class Main {	

	// Lanzar la aplicación
	public static void main(String[] args) {
	    try {
	        DashboardFrame frame = new DashboardFrame();
	        frame.setVisible(true);
	        
			ClienteManager.agregarCliente(new Cliente("Maria", "Salvatore", "MZ B LT 4", "945645258", "12345678"));
			ClienteManager.agregarCliente(new Cliente("Pablo", "Pinto", "MZ G LT 12", "98545555", "987654321"));
			ClienteManager.agregarCliente(new Cliente("Luis", "Urbina", "MZ E LT 6", "4848484848", "115155151"));
			ClienteManager.agregarCliente(new Cliente("Luciana", "Pinto", "MZ H LT 7", "15484884", "944949494"));
			ClienteManager.agregarCliente(new Cliente("Ana", "Martinez", "MZ F LT 10", "986547854", "369852147"));
			ClienteManager.agregarCliente(new Cliente("Diego", "Garcia", "MZ D LT 5", "978563214", "258741369"));
			ClienteManager.agregarCliente(new Cliente("Laura", "Lopez", "MZ J LT 15", "967854321", "123456789"));
			ClienteManager.agregarCliente(new Cliente("Sofia", "Rodriguez", "MZ C LT 8", "954875236", "987654321"));
			ClienteManager.agregarCliente(new Cliente("Carlos", "Sanchez", "MZ I LT 13", "965874123", "654321987"));
	        
			ProductoManager.agregarProducto(new Producto("Atún", 3.5, 5, 10, 200));
			ProductoManager.agregarProducto(new Producto("Aceite", 8.5, 10, 10, 200));
			ProductoManager.agregarProducto(new Producto("Yogurt", 5, 3, 10, 200));
			ProductoManager.agregarProducto(new Producto("Arroz", 4, 50, 10, 200));
			ProductoManager.agregarProducto(new Producto("Leche", 2.8, 8, 10, 200));
			ProductoManager.agregarProducto(new Producto("Huevos", 6, 80, 10, 200));
			ProductoManager.agregarProducto(new Producto("Pan", 1.5, 25, 10, 200));
			ProductoManager.agregarProducto(new Producto("Pasta", 2.2, 30, 10, 200));
			ProductoManager.agregarProducto(new Producto("Jugo", 4.7, 7, 10, 200));
			ProductoManager.agregarProducto(new Producto("Cereal", 3.8, 65, 10, 200));
	        
			VentaManager.agregarVenta(1001, 2001, 5);
			VentaManager.agregarVenta(1002, 2002, 10);
			VentaManager.agregarVenta(1003, 2003, 5);
			VentaManager.agregarVenta(1004, 2004, 10);
			VentaManager.agregarVenta(1001, 2001, 5);
			VentaManager.agregarVenta(1002, 2002, 10);
			VentaManager.agregarVenta(1003, 2001, 5);
			VentaManager.agregarVenta(1004, 2004, 10);
			VentaManager.agregarVenta(1001, 2004, 5);
			VentaManager.agregarVenta(1002, 2003, 10);
			VentaManager.agregarVenta(1003, 2001, 5);
			VentaManager.agregarVenta(1004, 2001, 10);

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

}