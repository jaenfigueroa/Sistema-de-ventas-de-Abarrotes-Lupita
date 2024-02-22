package frames;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import clases.Producto;
import managers.ProductoManager;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class AlmacenFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JSpinner sp_codigoProducto;
	private JSpinner sp_cantidadUnidades;

	/**
	 * Create the frame.
	 */
	public AlmacenFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1092, 664);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Codigo del producto");
		lblNewLabel.setBounds(10, 38, 124, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblCantidadDeUnidades = new JLabel("Cantidad de unidades");
		lblCantidadDeUnidades.setBounds(10, 80, 124, 13);
		contentPane.add(lblCantidadDeUnidades);
		
		JButton btn_agregarStock = new JButton("Ingresar nuevo stock");
		btn_agregarStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int codigoProducto = (int) sp_codigoProducto.getValue();
				int cantidadUnidades = (int) sp_cantidadUnidades.getValue();
				
				ingresarNuevoStock(codigoProducto,cantidadUnidades );
			}
		});
		btn_agregarStock.setBounds(852, 34, 169, 21);
		contentPane.add(btn_agregarStock);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 137, 1019, 467);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
			},
			new String[] {
				"Codigo", "Nombre", "Precio", "Stock minimo", "Stock actual", "Stock maximo"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, Double.class, Integer.class, Integer.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		
		sp_codigoProducto = new JSpinner();
		sp_codigoProducto.setModel(new SpinnerNumberModel(Integer.valueOf(0), null, null, Integer.valueOf(1)));
		sp_codigoProducto.setBounds(142, 35, 124, 20);
		contentPane.add(sp_codigoProducto);
		
		sp_cantidadUnidades = new JSpinner();
		sp_cantidadUnidades.setBounds(144, 77, 124, 20);
		contentPane.add(sp_cantidadUnidades);
	}

	// Metodos
	public void ingresarNuevoStock(int codigoProducto, int cantidadUnidades) {
		Producto producto = ProductoManager.consultarProducto(codigoProducto);
		
		int stockNuevo = producto.getStockActual() + cantidadUnidades;
		boolean comprobacion = stockNuevo <= producto.getStockMaximo();
		
		if(comprobacion) {
			producto.setStockActual(stockNuevo);
		} 
		else {
			producto.setStockActual(producto.getStockMaximo());
		}
	}
}
