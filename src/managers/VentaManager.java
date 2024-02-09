package managers;

import java.util.ArrayList;

import clases.Venta;

public class VentaManager {
	// Variables de clase
	private static ArrayList<Venta> ventas;
	
	// Bloque de inicialización static
	static {
		ventas = new ArrayList<>();
	}

	// Getters y Setters para las variables de clase
	public static ArrayList<Venta> getVentas() {
		return VentaManager.ventas;
	}

	public static void setVentas(ArrayList<Venta> ventas) {
		VentaManager.ventas = ventas;
	}
	
	// Metodos
	public static Venta getVenta(int codigoVentaBuscado) {
		
		Venta ventaEncontrada = null;

        for (Venta cliente : VentaManager.ventas) {
            if (cliente.getCodigoCliente() == codigoVentaBuscado) {
            	ventaEncontrada = cliente;
                break;
            }
        }
        
        return ventaEncontrada;
	}
}
