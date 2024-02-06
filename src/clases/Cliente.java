package clases;


public class Cliente {
	
	// Atributos
	private int codigoCliente; // Autogenerado y correlativo a partir de 1001
	private String nombres;
	private String apellidos;
	private String direccion;
	private String telefono;
	private String dni;
	
	// Variables de clase
	private static int codigoCorrelativoAPartir;
	private static int cantidadClientes;
	
	// Bloque de inicializacion static
	static {
		codigoCorrelativoAPartir = 1001;
		cantidadClientes = 0;
	}
	
	// Contructor
	public Cliente(String nombres, String apellidos, String direccion, String telefono, String dni) {
		this.codigoCliente = Cliente.codigoCorrelativoAPartir + Cliente.cantidadClientes;
		
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.telefono = telefono;
		this.dni = dni;
		
		cantidadClientes++;
	}

	// Getters y Setters
	public int getCodigoCliente() {
		return this.codigoCliente;
	}

	public void setCodigoCliente(int codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
	


	
}
