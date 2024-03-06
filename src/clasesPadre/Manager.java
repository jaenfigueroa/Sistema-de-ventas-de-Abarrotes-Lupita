package clasesPadre;

import java.util.ArrayList;

public abstract class Manager<T extends Item> {
	
	// Atributos
	protected ArrayList<T> items = new ArrayList<T>();

	// Metodos abstractos
	public void ingresar(T item) { // Ingresar solo uno
		items.add(item);
	};

	// Metodos
	public T consultar(int codigo) {	// usando el codigo	000x
		for (int i = 0; i < items.size(); i++) {
			
			if(items.get(i).codigo == codigo) {
				return items.get(i);
			}
		}
		
		return null;
	};
	
	public void eliminar(int codigo) {	 // usando el codigo 000x
		for (int i = 0; i < items.size(); i++) {
			
			if(items.get(i).codigo == codigo) {
				items.remove(i);
			}
		}
	};

	public ArrayList<T> listar() {
		return items;
	}
	
//	public void modificar(int codigo, T item) { // recibe el codigo xxx1 , nuevo objeto
//		
//		System.out.println(codigo);
//		
//		for (int i = 0; i < items.size(); i++) {
//			System.out.println(items.get(i).codigo);
//		}
//		
//		Item x = consultar(codigo);
//		int indice = items.indexOf(x);
//		
//		items.add(indice, item); // loa actualiza usando el indice y el nuevo objeto
//	};
	
	//public abstract T modificar(int codigo, Object x);
}
