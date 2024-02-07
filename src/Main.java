import clases.Cliente;
import frames.DashboardFrame;

public class Main {
	
	// 
	public static Cliente[] clientes;
	
	
	
	
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