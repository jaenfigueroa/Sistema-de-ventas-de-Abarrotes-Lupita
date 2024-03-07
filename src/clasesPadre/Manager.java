package clasesPadre;
import java.util.ArrayList;

public abstract class Manager<T extends Item> {

	// Atributos
	protected ArrayList<T> items = new ArrayList<T>();

	// Metodos
	public void ingresar(T item) {
		items.add(item);
	};

	public T consultar(int codigo) { // usando el codigo 000x
		for (int i = 0; i < items.size(); i++) {

			if (items.get(i).codigo == codigo) {
				return items.get(i);
			}
		}

		return null;
	};

	public boolean eliminar(int codigo) { // usando el codigo 000x
		for (int i = 0; i < items.size(); i++) {

			if (items.get(i).codigo == codigo) {
				items.remove(i);
				
				return true;
			}
		}
		return false;
	};

	public ArrayList<T> listar() {
		return items;
	}
}
