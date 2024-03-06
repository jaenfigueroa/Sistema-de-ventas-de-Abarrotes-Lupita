package managers;

import clases.Cliente;
import clasesPadre.Manager;

public class ClienteManager extends Manager<Cliente> {
	
	public Cliente modificar(int codigo, String nombres, String apellidos, String direccion, String telefono, String dni) {

		for (int i = 0; i < items.size(); i++) {

            if (items.get(i).getCodigoCliente() == codigo) {
            	
            	Cliente cliente = items.get(i);

            	cliente.setNombres(nombres);
            	cliente.setApellidos(apellidos);
            	cliente.setDireccion(direccion);
            	cliente.setTelefono(telefono);
            	cliente.setDni(dni);
            	
            	return cliente;
            }
		}
		return null;
	}
}
