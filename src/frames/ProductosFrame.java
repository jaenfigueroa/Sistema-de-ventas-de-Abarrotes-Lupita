package frames;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import clases.Cliente;
import clases.Producto;
import managers.ClienteManager;
import managers.ProductoManager;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class ProductosFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tf_nombres;
	private JTextField tf_precio;
	private JTextField tf_StockActual;
	private JTextField tf_StockMaximo;
	private JTextField tf_StockMinimo;
	private JTextField tf_codigoCliente;
	private JTable tblTabla;
	private DefaultTableModel modelo;

	/**
	 * Create the frame.
	 */
	public ProductosFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 731, 484);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNombre.setBounds(10, 43, 96, 13);
		contentPane.add(lblNombre);

		tf_nombres = new JTextField();
		tf_nombres.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tf_nombres.setBounds(145, 39, 253, 19);
		contentPane.add(tf_nombres);
		tf_nombres.setColumns(10);

		tf_precio = new JTextField();
		tf_precio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tf_precio.setColumns(10);
		tf_precio.setBounds(145, 64, 253, 19);
		contentPane.add(tf_precio);

		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPrecio.setBounds(10, 68, 96, 13);
		contentPane.add(lblPrecio);

		tf_StockActual = new JTextField();
		tf_StockActual.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tf_StockActual.setColumns(10);
		tf_StockActual.setBounds(145, 87, 253, 19);
		contentPane.add(tf_StockActual);

		JLabel lblStock = new JLabel("Stock Actual");
		lblStock.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblStock.setBounds(10, 91, 96, 13);
		contentPane.add(lblStock);

		JLabel lblNewLabel_1_1 = new JLabel("Stock Maximo");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(10, 145, 113, 13);
		contentPane.add(lblNewLabel_1_1);

		tf_StockMaximo = new JTextField();
		tf_StockMaximo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tf_StockMaximo.setColumns(10);
		tf_StockMaximo.setBounds(145, 141, 253, 19);
		contentPane.add(tf_StockMaximo);

		tf_StockMinimo = new JTextField();
		tf_StockMinimo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tf_StockMinimo.setColumns(10);
		tf_StockMinimo.setBounds(145, 116, 253, 19);
		contentPane.add(tf_StockMinimo);

		JLabel lblTelefono = new JLabel("Stock Minimo");
		lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTelefono.setBounds(10, 120, 96, 13);
		contentPane.add(lblTelefono);

		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCodigo.setBounds(10, 14, 133, 13);
		contentPane.add(lblCodigo);

		tf_codigoCliente = new JTextField();
		tf_codigoCliente.setText("0");
		tf_codigoCliente.setEditable(false);
		tf_codigoCliente.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tf_codigoCliente.setColumns(10);
		tf_codigoCliente.setBounds(145, 10, 253, 19);
		contentPane.add(tf_codigoCliente);

		JComboBox cb_opciones = new JComboBox();
		cb_opciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int opcionElegida = cb_opciones.getSelectedIndex();

				if (opcionElegida == 1 || opcionElegida == 2 || opcionElegida == 3) {
					tf_codigoCliente.setEditable(true);
				} else {
					tf_codigoCliente.setEditable(false);
				}
			}
		});
		cb_opciones.setModel(
				new DefaultComboBoxModel(new String[] { "Crear", "Modificar", "Consultar", "Eliminar", "Listar" }));
		cb_opciones.setBounds(528, 13, 180, 19);
		contentPane.add(cb_opciones);

		JButton btn_ok = new JButton("OK");
		btn_ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Recoger la accion a realizar
				int accionARealizar = cb_opciones.getSelectedIndex();

				// Elegir la accion a realizar
				
				int codigoProducto = Integer.parseInt(tf_codigoCliente.getText());
				
				if (accionARealizar == 4) { // listar
					limpiarTabla();
					rellenartabla();

				} else {

					// Recoger los valores ingresados por el usuario
					String nombres = tf_nombres.getText();
					double precio = Double.parseDouble(tf_precio.getText());
					int stockActual = Integer.parseInt(tf_StockActual.getText());
					int stockMinimo = Integer.parseInt(tf_StockMinimo.getText());
					int stockMaximo = Integer.parseInt(tf_StockMaximo.getText());

					switch (accionARealizar) {

					// CREAR

					case 0:

						Producto producto = new Producto(nombres, precio, stockActual, stockMinimo, stockMaximo);
						ProductoManager.agregarProducto(producto);
//						
//						// Mostrar el codigo de cliente recién creado
						tf_codigoCliente.setText(producto.getCodigoProducto() + "");
						limpiarTabla();
						rellenartabla();
						break;

					// MODIFICAR
					case 1:
						Producto productoModificado = ProductoManager.modificarProducto(codigoProducto, nombres, precio,
								stockActual, stockMinimo, stockMaximo);
						limpiarTabla();
						rellenartabla();
						break;

					// CONSULTAR
					case 2:
						Producto productoEncontrado = ProductoManager.consultarProducto(codigoProducto);
						limpiarTabla();
						rellenartabla(productoEncontrado);
						break;

					// ELIMINAR
					case 3:
						ProductoManager.eliminarProducto(codigoProducto);
						limpiarTabla();
						rellenartabla();
						break;
					}

				}
		
			}
		});
		btn_ok.setBounds(623, 39, 85, 21);
		contentPane.add(btn_ok);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 189, 698, 247);
		contentPane.add(scrollPane);

		tblTabla = new JTable();
		scrollPane.setViewportView(tblTabla);

		modelo = new DefaultTableModel();
		modelo.addColumn("Código");
		modelo.addColumn("Nombre");
		modelo.addColumn("Precio");
		modelo.addColumn("Stock actual");
		modelo.addColumn("Stock minimo");
		modelo.addColumn("Stock maximo");

		tblTabla.setModel(modelo);

		rellenartabla();
	}

	// Metodos
	public void limpiarTabla() {
		while (modelo.getRowCount() > 0) {
			modelo.removeRow(0);
		}
	}

	public void rellenartabla(Producto x) {
		modelo.setRowCount(0);
		Object[] fila = { x.getCodigoProducto(), x.getNombre(), x.getPrecio(), x.getStockActual(), x.getStockMinimo(),
				x.getStockMaximo(), };
		modelo.addRow(fila);
	}

	public void rellenartabla() {
		ArrayList<Producto> productos = ProductoManager.listarProductos();

		for (int i = 0; i < productos.size(); i++) {

			modelo.setRowCount(i);
			Object[] fila = { productos.get(i).getCodigoProducto(), productos.get(i).getNombre(),
					productos.get(i).getPrecio(), productos.get(i).getStockActual(), productos.get(i).getStockMinimo(),
					productos.get(i).getStockMaximo(), };
			modelo.addRow(fila);
		}
	}
}
