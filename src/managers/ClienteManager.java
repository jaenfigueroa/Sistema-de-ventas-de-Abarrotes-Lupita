package managers;

import java.util.ArrayList;

import clases.Cliente;

public class ClienteManager {
	
	// Variables de clase
	private static ArrayList<Cliente> clientes;
	
	// Bloque de inicialización static
	static {
		clientes = new ArrayList<Cliente>();
		
		Cliente cliente_1 = new Cliente("Maria", "Salvatore", "MZ B LT 4", "945645258", "12345678");
		Cliente cliente_2 = new Cliente("Pablo", "Pinto", "MZ G LT 12", "98545555", "987654321");
		Cliente cliente_3 = new Cliente("Luis", "Urbina", "MZ E LT 6", "4848484848", "115155151");
		Cliente cliente_4 = new Cliente("Luciana", "Pinto", "MZ H LT 7", "15484884", "944949494");
		
		agregarCliente(cliente_1);
		agregarCliente(cliente_2);
		agregarCliente(cliente_3);
		agregarCliente(cliente_4);
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
