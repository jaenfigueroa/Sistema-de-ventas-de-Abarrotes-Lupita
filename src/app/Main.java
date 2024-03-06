package app;
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

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

}