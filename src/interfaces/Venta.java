package interfaces;

public interface Venta {
	int codigo = 0; // Autogenerado y correlativo a partir de 3001
	int codigoCliente = 0;
	int codigoProducto = 0;
	int cantidad = 0;
	double precio = 0.0;
	String fecha = ""; // Formato: mm/dd/aaaa
}
