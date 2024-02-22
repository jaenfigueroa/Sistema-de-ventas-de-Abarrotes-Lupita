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
	private JTextArea ta_resultados;

	/**
	 * Create the frame.
	 */
	public ProductosFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1092, 664);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNombre.setBounds(10, 28, 96, 13);
		contentPane.add(lblNombre);
		
		tf_nombres = new JTextField();
		tf_nombres.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tf_nombres.setBounds(209, 24, 189, 19);
		contentPane.add(tf_nombres);
		tf_nombres.setColumns(10);
		
		tf_precio = new JTextField();
		tf_precio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tf_precio.setColumns(10);
		tf_precio.setBounds(209, 55, 95, 19);
		contentPane.add(tf_precio);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPrecio.setBounds(10, 67, 96, 13);
		contentPane.add(lblPrecio);
		
		tf_StockActual = new JTextField();
		tf_StockActual.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tf_StockActual.setColumns(10);
		tf_StockActual.setBounds(209, 105, 85, 19);
		contentPane.add(tf_StockActual);
		
		JLabel lblStock = new JLabel("Stock Actual");
		lblStock.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblStock.setBounds(10, 109, 96, 13);
		contentPane.add(lblStock);
		
		JLabel lblNewLabel_1_1 = new JLabel("Stock Maximo");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(10, 197, 113, 13);
		contentPane.add(lblNewLabel_1_1);
		
		tf_StockMaximo = new JTextField();
		tf_StockMaximo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tf_StockMaximo.setColumns(10);
		tf_StockMaximo.setBounds(209, 193, 85, 19);
		contentPane.add(tf_StockMaximo);
		
		tf_StockMinimo = new JTextField();
		tf_StockMinimo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tf_StockMinimo.setColumns(10);
		tf_StockMinimo.setBounds(209, 154, 85, 19);
		contentPane.add(tf_StockMinimo);
		
		JLabel lblTelefono = new JLabel("Stock Minimo");
		lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTelefono.setBounds(10, 158, 96, 13);
		contentPane.add(lblTelefono);
		
		JLabel lblCodigo = new JLabel("Codigo de cliente");
		lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCodigo.setBounds(581, 31, 133, 13);
		contentPane.add(lblCodigo);
		
		tf_codigoCliente = new JTextField();
		tf_codigoCliente.setText("0");
		tf_codigoCliente.setEditable(false);
		tf_codigoCliente.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tf_codigoCliente.setColumns(10);
		tf_codigoCliente.setBounds(715, 28, 96, 19);
		contentPane.add(tf_codigoCliente);
		
		JComboBox cb_opciones = new JComboBox();
		cb_opciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int opcionElegida = cb_opciones.getSelectedIndex();
				
				if(opcionElegida == 1 || opcionElegida == 2 || opcionElegida == 3) {
					tf_codigoCliente.setEditable(true);
				}
				else {tf_codigoCliente.setEditable(false); }
			}
		});
		cb_opciones.setModel(new DefaultComboBoxModel(new String[] {"Crear", "Modificar", "Consultar", "Eliminar", "Listar"}));
		cb_opciones.setBounds(867, 26, 180, 19);
		contentPane.add(cb_opciones);
		
		JButton btn_ok = new JButton("OK");
		btn_ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Recoger los valores ingresados por el usuario
				String nombres = tf_nombres.getText();
				double precio = Double.parseDouble(tf_precio.getText());
				int stockActual = Integer.parseInt(tf_StockActual.getText());
				int stockMinimo = Integer.parseInt(tf_StockMinimo.getText());
				int stockMaximo = Integer.parseInt(tf_StockMaximo.getText());
				
				// Recoger la accion a realizar
				int accionARealizar = cb_opciones.getSelectedIndex();
				

				// Elegir la accion a realizar
				
//				
				
				
				
				int codigoProducto = Integer.parseInt(tf_codigoCliente.getText());
				
				switch (accionARealizar) {
					
					// CREAR
				
					case 0:
						
						Producto producto = new Producto(nombres, precio, stockActual, stockMinimo, stockMaximo);
						ProductoManager.agregarProducto(producto);
						
						// Mostrar el codigo de cliente recién creado
						tf_codigoCliente.setText(producto.getCodigoProducto() + "");

						limpiar();
						mostrarDatosProducto(producto);
						break;
					
					// MODIFICAR
					case 1:
						Producto productoModificado = ProductoManager.modificarProducto( codigoProducto, nombres, precio, stockActual, stockMinimo, stockMaximo);
						limpiar();
						mostrarDatosProducto(productoModificado);
						break;
						
					// CONSULTAR
					case 2:
						Producto productoEncontrado = ProductoManager.consultarProducto(codigoProducto);
						limpiar();
						mostrarDatosProducto(productoEncontrado);
						break;
						
					// ELIMINAR
					case 3:
						ProductoManager.eliminarProducto(codigoProducto);
						limpiar();
						ta_resultados.setText("Producto eliminado");
						break;
						
					// LISTAR
					case 4:
						ArrayList<Producto> productosEncontrados = ProductoManager.listarProductos();

						limpiar();
						if( productosEncontrados.size() > 0) {
							for (int i = 0; i < productosEncontrados.size(); i++) {
								mostrarDatosProducto(productosEncontrados.get(i));
								ta_resultados.append("\n----------------------------------------------\n");
							}
						} else { ta_resultados.append("No hay productos para mostrar");}
					
						
						
						break;
				}
				
			}
		});
		btn_ok.setBounds(437, 195, 85, 21);
		contentPane.add(btn_ok);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 230, 1016, 371);
		contentPane.add(scrollPane);
		
		ta_resultados = new JTextArea();
		scrollPane.setViewportView(ta_resultados);
	}
	
	// Metodos
	public void mostrarDatosProducto(Producto producto) {
		
		if(producto != null) {
			String mensaje = "Codigo del producto: " + producto.getCodigoProducto();
			mensaje += "\nNombre: " + producto.getNombre();	
			mensaje += "\nPrecio: " + producto.getPrecio();
			mensaje += "\nStock Actualn: " + producto.getStockActual();
			mensaje += "\nStock Minimo: " + producto.getStockMinimo();
			mensaje += "\nStock Maximo: " + producto.getStockMaximo();
			
			ta_resultados.append(mensaje);
		} else {
			ta_resultados.append("no existe");
		}
	}

	public void limpiar() {
		ta_resultados.setText("");
	}
}
