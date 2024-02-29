package managers;

import java.util.ArrayList;

import clases.Cliente;

public class ClienteManager {
	
	// Variables de clase
	private static ArrayList<Cliente> clientes;
	
	// Bloque de inicialización static
	static {
		clientes = new ArrayList<Cliente>();
	}
	
	// Metodos
	public static Cliente agregarCliente(Cliente cliente) {
		ClienteManager.clientes.add(cliente);
		return cliente;
	}
	
	public static Cliente modificarCliente(int codigoCliente, String nombres, String apellidos, String direccion, String telefono, String dni) {
		
		for (int i = 0; i < ClienteManager.clientes.size(); i++) {

            if (ClienteManager.clientes.get(i).getCodigoCliente() == codigoCliente) {
            	
            	Cliente clienteEncontrado = ClienteManager.clientes.get(i);
            	clienteEncontrado.setNombres(nombres);
            	clienteEncontrado.setApellidos(apellidos);
            	clienteEncontrado.setDireccion(direccion);
            	clienteEncontrado.setTelefono(telefono);
            	clienteEncontrado.setDni(dni);
            	
            	return clienteEncontrado;
            }
		}
		return null;
	}
	
	public static Cliente consultarCliente(int codigoClienteBuscado) {
		
		Cliente clienteEncontrado = null;

        for (Cliente cliente : ClienteManager.clientes) {
            if (cliente.getCodigoCliente() == codigoClienteBuscado) {
            	clienteEncontrado = cliente;
                break;
            }
        }
        
     // devolver el usuario actualizado
        return clienteEncontrado;
	}
	

	public static void eliminarCliente(int codigoClienteAEliminar) {
		
		//Cliente clienteEliminado = null;
		
		for (int i = 0; i < ClienteManager.clientes.size(); i++) {
            if (ClienteManager.clientes.get(i).getCodigoCliente() == codigoClienteAEliminar) {
            	
            	//clienteEliminado = ClienteManager.clientes.get(codigoClienteAEliminar);
            	
            	ClienteManager.clientes.remove(i);
                break;
            }
		}
		
		// devolver el usuario actualizado
		//return clienteEliminado;
	}

	public static ArrayList<Cliente> listarClientes() {
		return ClienteManager.clientes;
	}
	
	// Metodos auxiliares
	
//	public static int buscarIndice() {
//		
//	}

}
