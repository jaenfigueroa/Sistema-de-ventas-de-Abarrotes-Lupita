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
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 614, 304);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Almacénamiento");

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Stock actual antes");
		lblNewLabel.setBounds(399, 16, 108, 13);
		contentPane.add(lblNewLabel);
		
		tf_stockactualantes = new JTextField();
		tf_stockactualantes.setEditable(false);
		tf_stockactualantes.setBounds(517, 13, 72, 19);
		contentPane.add(tf_stockactualantes);
		tf_stockactualantes.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Cantidad de productos");
		lblNewLabel_1.setBounds(10, 46, 136, 13);
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
		btnNewButton.setBounds(190, 70, 124, 21);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1_1 = new JLabel("Código producto");
		lblNewLabel_1_1.setBounds(10, 13, 136, 19);
		contentPane.add(lblNewLabel_1_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 111, 579, 146);
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
		 tf_codigo.setBounds(154, 14, 160, 19);
		 contentPane.add(tf_codigo);
		 tf_codigo.setColumns(10);
		 
		 tf_cantidad = new JTextField();
		 tf_cantidad.setColumns(10);
		 tf_cantidad.setBounds(154, 43, 160, 19);
		 contentPane.add(tf_cantidad);
		 
		 tf_stockactualahora = new JTextField();
		 tf_stockactualahora.setEditable(false);
		 tf_stockactualahora.setColumns(10);
		 tf_stockactualahora.setBounds(517, 39, 72, 19);
		 contentPane.add(tf_stockactualahora);
		 
		 JLabel lblStockActualAhora = new JLabel("Stock actual ahora");
		 lblStockActualAhora.setBounds(399, 39, 108, 19);
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
