package managers;

import java.util.ArrayList;

import clases.Cliente;

public class ClienteManager {
	
	// Variables de clase
	private static ArrayList<Cliente> clientes;
	
	// Bloque de inicialización static
	static {
		clientes = new ArrayList<>();
	}
	
	// Metodos
	public static Cliente agregarCliente(Cliente cliente) {
		ClienteManager.clientes.add(cliente);
		
		return ClienteManager.clientes.get(cliente.getCodigoCliente());
	}
	
	public static Cliente modificarCliente(Cliente clienteConCambios) {
		
		for (int i = 0; i < ClienteManager.clientes.size(); i++) {
            if (ClienteManager.clientes.get(i).getCodigoCliente() == clienteConCambios.getCodigoCliente()) {
            	
            	ClienteManager.clientes.set(i, clienteConCambios);

                break;
            }
		}
		
		return ClienteManager.clientes.get(clienteConCambios.getCodigoCliente());
	}
	
	public static Cliente consultarCliente(int codigoClienteBuscado) {
		
		Cliente clienteEncontrado = null;

        for (Cliente cliente : ClienteManager.clientes) {
            if (cliente.getCodigoCliente() == codigoClienteBuscado) {
            	clienteEncontrado = cliente;
                break;
            }
        }
        
        return clienteEncontrado;
	}
	

	public static Cliente eliminarCliente(int codigoClienteAEliminar) {
		
		Cliente clienteEliminado = null;
		
		for (int i = 0; i < ClienteManager.clientes.size(); i++) {
            if (ClienteManager.clientes.get(i).getCodigoCliente() == codigoClienteAEliminar) {
            	
            	clienteEliminado = ClienteManager.clientes.get(codigoClienteAEliminar);
            	
            	ClienteManager.clientes.remove(i);
                break;
            }
		}
		
		return clienteEliminado;
	}

	public static ArrayList<Cliente> listarClientes() {
		return ClienteManager.clientes;
	}

}
