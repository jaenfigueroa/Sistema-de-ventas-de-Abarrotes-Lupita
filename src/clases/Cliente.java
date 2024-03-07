package clases;

import clasesPadre.Item;

public class Cliente extends Item implements interfaces.Cliente  {
	
	// Atributos
	private String nombres;
	private String apellidos;
	private String direccion;
	private String telefono;
	private String dni;
	
	private static int cantidadClientes;
	
	// Constantes de clase
	private static final int CODIGO_CORRELATIVO_A_PARTIR;
	
	static {
		cantidadClientes = 0;
		CODIGO_CORRELATIVO_A_PARTIR = 1001;
	}
	
	// Contructores
	public Cliente( String nombres, String apellidos, String direccion, String telefono, String dni) {
		super(CODIGO_CORRELATIVO_A_PARTIR, cantidadClientes);

		this.nombres = nombres;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.telefono = telefono;
		this.dni = dni;
		
		Cliente.cantidadClientes++;
	}

	// Getters y Setters para atributos
	public int getCodigoCliente() {
		return super.codigo;
	}

	public void setCodigoCliente(int codigoCliente) {
		super.codigo = codigoCliente;
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
