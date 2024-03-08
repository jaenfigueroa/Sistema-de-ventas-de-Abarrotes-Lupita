package frames;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import app.Main;
import clases.Producto;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

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
		setBounds(100, 100, 640, 353);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Almacénamiento");

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Stock antes");
		lblNewLabel.setBounds(311, 17, 76, 13);
		contentPane.add(lblNewLabel);
		
		tf_stockactualantes = new JTextField();
		tf_stockactualantes.setEditable(false);
		tf_stockactualantes.setBounds(397, 14, 72, 19);
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
				
				try {
					// recoger el codigo y la cantidad
					int codigo = Integer.parseInt(tf_codigo.getText());
					int cantidad = Integer.parseInt(tf_cantidad.getText());
					
					Producto producto = Main.productoManager.consultar(codigo);
					
					if(producto == null) {
						mostrarMensaje("EL producto con el codigo " + codigo + " no existe");
					} else {
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
				} catch (Exception e2) {
					mostrarMensaje("Revisa los campos ingresados, todos deben ser numeros");
				}
			}
		});
		btnNewButton.setBounds(155, 75, 128, 21);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1_1 = new JLabel("Código producto");
		lblNewLabel_1_1.setBounds(10, 13, 136, 19);
		contentPane.add(lblNewLabel_1_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 143, 608, 163);
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
		 tf_codigo.setBounds(155, 17, 128, 19);
		 contentPane.add(tf_codigo);
		 tf_codigo.setColumns(10);
		 
		 tf_cantidad = new JTextField();
		 tf_cantidad.setColumns(10);
		 tf_cantidad.setBounds(155, 46, 128, 19);
		 contentPane.add(tf_cantidad);
		 
		 tf_stockactualahora = new JTextField();
		 tf_stockactualahora.setEditable(false);
		 tf_stockactualahora.setColumns(10);
		 tf_stockactualahora.setBounds(397, 40, 72, 19);
		 contentPane.add(tf_stockactualahora);
		 
		 JLabel lblStockActualAhora = new JLabel("Stock ahora");
		 lblStockActualAhora.setBounds(311, 40, 76, 19);
		 contentPane.add(lblStockActualAhora);
		 
		 JLabel lblNewLabel_2 = new JLabel("");
		 lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		 lblNewLabel_2.setIcon(new ImageIcon(AlmacenFrame.class.getResource("/assets/almacenamiento-96.png")));
		 lblNewLabel_2.setBounds(479, 17, 124, 104);
		 contentPane.add(lblNewLabel_2);
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
