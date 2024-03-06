package clasesPadre;

public class Item {
	protected int codigo = 0;

	public Item(int CODIGO_CORRELATIVO, int cantidad) {
		int codigo = CODIGO_CORRELATIVO + cantidad;
		
		this.codigo = codigo;
	}
	 
}
