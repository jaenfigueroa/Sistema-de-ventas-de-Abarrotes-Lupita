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
	private static int cantidadClientes;
	
	// Constantes de clase
	private static final int CODIGO_CORRELATIVO_A_PARTIR;
	
	// Bloque de inicializacion static
	static {
		cantidadClientes = 0;
		CODIGO_CORRELATIVO_A_PARTIR = 1001;
	}
	
	// Contructores
	public Cliente(String nombres, String apellidos, String direccion, String telefono, String dni) {
		this.codigoCliente = Cliente.CODIGO_CORRELATIVO_A_PARTIR + Cliente.cantidadClientes;
		
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.telefono = telefono;
		this.dni = dni;
		
		Cliente.cantidadClientes++;
	}

	// Getters y Setters para atributos
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
	
	// Getters y Setters para variables de clase
	public static int getCantidadClientes() {
		return Cliente.cantidadClientes;
	}

	public static void setCantidadClientes(int cantidadClientes) {
		Cliente.cantidadClientes = cantidadClientes;
	}

	// Getters para contantes de clase
	public static int getCodigoCorrelativoAPartir() {
		return Cliente.CODIGO_CORRELATIVO_A_PARTIR;
	}
	
	// Metodos

	
}
