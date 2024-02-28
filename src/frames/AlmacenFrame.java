package frames;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import clases.Producto;
import managers.ProductoManager;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AlmacenFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tf_stockactualantes;
	private JTable tblTabla;
	private DefaultTableModel modelo;
	private JTextField tf_codigo;
	private JTextField tf_cantidad;
	private JTextField tf_stockactualahora;

	/**
	 * Create the frame.
	 */
	public AlmacenFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 618, 465);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Stock actual anterior");
		lblNewLabel.setBounds(235, 17, 149, 13);
		contentPane.add(lblNewLabel);
		
		tf_stockactualantes = new JTextField();
		tf_stockactualantes.setEditable(false);
		tf_stockactualantes.setBounds(235, 36, 149, 19);
		contentPane.add(tf_stockactualantes);
		tf_stockactualantes.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Cantidad de productos");
		lblNewLabel_1.setBounds(10, 65, 174, 25);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Actualizar Stock");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();
				limpiarTabla();
				
				// recoger el codigo y la cantidad
				int codigo = Integer.parseInt(tf_codigo.getText());
				int cantidad = Integer.parseInt(tf_cantidad.getText());
				
				Producto producto = ProductoManager.consultarProducto(codigo);
				
				// mostrar valores de stock
				tf_stockactualantes.setText(producto.getStockActual() + "");
				
				// verfiicar que el nuevo stock actual no supere el stock maximo
				int nuevoStock = producto.getStockActual() + cantidad;
				
				if(nuevoStock <= producto.getStockMaximo()) {
					// agregar normal
					producto.setStockActual(nuevoStock);
					
					tf_stockactualahora.setText(producto.getStockActual() + "");
					
					rellenartabla(producto);
				} else {
					// mostra mensaje
					mostrarMensaje("El nuevo stock supera el stock máximo");
				}
			}
		});
		btnNewButton.setBounds(450, 13, 139, 21);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1_1 = new JLabel("Código");
		lblNewLabel_1_1.setBounds(10, 10, 105, 25);
		contentPane.add(lblNewLabel_1_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 135, 579, 283);
		contentPane.add(scrollPane);
		
		tblTabla = new JTable();
		tblTabla.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblTabla);
		
		 modelo = new DefaultTableModel();
		 modelo.addColumn("Código");
		 modelo.addColumn("Nombre");
		 modelo.addColumn("Precio");
		 modelo.addColumn("Stock actual");
		 modelo.addColumn("Stock minimo");
		 modelo.addColumn("Stock maximo");
		 
		 tblTabla.setModel(modelo);
		 
		 tf_codigo = new JTextField();
		 tf_codigo.setBounds(10, 36, 174, 19);
		 contentPane.add(tf_codigo);
		 tf_codigo.setColumns(10);
		 
		 tf_cantidad = new JTextField();
		 tf_cantidad.setColumns(10);
		 tf_cantidad.setBounds(10, 95, 174, 19);
		 contentPane.add(tf_cantidad);
		 
		 tf_stockactualahora = new JTextField();
		 tf_stockactualahora.setEditable(false);
		 tf_stockactualahora.setColumns(10);
		 tf_stockactualahora.setBounds(235, 95, 149, 19);
		 contentPane.add(tf_stockactualahora);
		 
		 JLabel lblStockActualAhora = new JLabel("Stock actual ahora");
		 lblStockActualAhora.setBounds(235, 76, 149, 13);
		 contentPane.add(lblStockActualAhora);
	}
	
	// metodo
	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje, "Mensaje", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void limpiar() {
		tf_stockactualantes.setText("");
		tf_stockactualahora.setText("");
	}
	
	public void limpiarTabla() {		
		while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
	}
	
	public void rellenartabla(Producto x) {		
		modelo.setRowCount(0);
		Object[] fila = {
				x.getCodigoProducto(),
				x.getNombre(),
				x.getPrecio(),
				x.getStockActual(),
				x.getStockMinimo(),
				x.getStockMaximo(),
		};
		modelo.addRow(fila);
	}
}
