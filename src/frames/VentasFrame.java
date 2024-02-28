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

import clases.Cliente;
import clases.Producto;
import clases.Venta;
import managers.ClienteManager;
import managers.ProductoManager;
import managers.VentaManager;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class VentasFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tf_stockActualAnterior;
	private DefaultTableModel modelo;
	private JTextField tf_codigoProducto;
	private JTextField tf_cantidad;
	private JTextField tf_codigoCliente;
	private JTextArea ta_salida;
	private JTextField tf_stockActualAhora;

	/**
	 * Create the frame.
	 */
	public VentasFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 614, 406);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Stock actual antes");
		lblNewLabel.setBounds(398, 17, 105, 13);
		contentPane.add(lblNewLabel);
		
		tf_stockActualAnterior = new JTextField();
		tf_stockActualAnterior.setEditable(false);
		tf_stockActualAnterior.setBounds(513, 14, 76, 19);
		contentPane.add(tf_stockActualAnterior);
		tf_stockActualAnterior.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Cantidad de productos");
		lblNewLabel_1.setBounds(10, 59, 132, 25);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Vender");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// recoger el codigo y cantidad a vender
				int codigoCliente = Integer.parseInt(tf_codigoCliente.getText());
				int codigoProducto = Integer.parseInt(tf_codigoProducto.getText());
				int cantidad = Integer.parseInt(tf_cantidad.getText());
				
				// conseguir el producto
				Producto producto = ProductoManager.consultarProducto(codigoProducto);
				
				// mostrar el stock actual
				tf_stockActualAnterior.setText(producto.getStockActual() + "");
				
				// comprobar el stock
				if(cantidad <= producto.getStockActual()) {
					// dejar hacer la venta
					Venta venta = VentaManager.agregarVenta(
							codigoCliente,
							producto.getCodigoProducto(),
							cantidad
						);
					
					// mostrar boleta
					tf_stockActualAhora.setText(producto.getStockActual() + "");
					mostrarBoleta(venta);
					
				} else {
					// mostrar mensaje
					mostrarMensaje("La cantidad que se quiere vender supera el stock actual");
				}
			}
		});
		btnNewButton.setBounds(232, 91, 87, 21);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1_1 = new JLabel("Código producto");
		lblNewLabel_1_1.setBounds(10, 36, 132, 22);
		contentPane.add(lblNewLabel_1_1);
		
		
		 tf_codigoProducto = new JTextField();
		 tf_codigoProducto.setBounds(152, 36, 167, 19);
		 contentPane.add(tf_codigoProducto);
		 tf_codigoProducto.setColumns(10);
		 
		 tf_cantidad = new JTextField();
		 tf_cantidad.setColumns(10);
		 tf_cantidad.setBounds(152, 62, 167, 19);
		 contentPane.add(tf_cantidad);
		 
		 JScrollPane scrollPane = new JScrollPane();
		 scrollPane.setBounds(10, 126, 579, 229);
		 contentPane.add(scrollPane);
		 
		 ta_salida = new JTextArea();
		 scrollPane.setViewportView(ta_salida);
		 
		 tf_codigoCliente = new JTextField();
		 tf_codigoCliente.setColumns(10);
		 tf_codigoCliente.setBounds(152, 14, 167, 19);
		 contentPane.add(tf_codigoCliente);
		 
		 JLabel lblNewLabel_1_1_1 = new JLabel("Código cliente");
		 lblNewLabel_1_1_1.setBounds(10, 10, 132, 25);
		 contentPane.add(lblNewLabel_1_1_1);
		 
		 tf_stockActualAhora = new JTextField();
		 tf_stockActualAhora.setEditable(false);
		 tf_stockActualAhora.setColumns(10);
		 tf_stockActualAhora.setBounds(513, 40, 76, 19);
		 contentPane.add(tf_stockActualAhora);
		 
		 JLabel lblStockActualAhora = new JLabel("Stock actual ahora");
		 lblStockActualAhora.setBounds(398, 40, 105, 18);
		 contentPane.add(lblStockActualAhora);
	}
	
	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje, "Mensaje", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void mostrarBoleta(Venta venta) {
		
		Producto producto = ProductoManager.consultarProducto(venta.getCodigoProducto());
		Cliente cliente = ClienteManager.consultarCliente(venta.getCodigoCliente());
		
		String boleta = "BOLETA DE VENTA\n\n";
		boleta += "Fecha: " + venta.getFecha() + "\n\n";
		
		boleta += "Codigo del cliente: " + venta.getCodigoCliente() + "\n";
		boleta += "Nombres y apellidos del cliente: " + cliente.getNombres() + " " + cliente.getApellidos() + "\n";
		boleta += "Codigo del producto: " + venta.getCodigoProducto() + "\n";
		boleta += "Nombre del producto: " + producto.getNombre() + "\n";
		boleta += "Cantidad de unidades adquiridas: " + venta.getCantidad() + "\n";
		boleta += "Precio unitario: S/. " + venta.getPrecio() + "\n";
		boleta += "Importe subtotal: S/. " + venta.getImporteSubtotal() + "\n";
		boleta += "Importe del IGV: S/. " + venta.getImpuestoPagar() + "\n";
		boleta += "Importe total a pagar: S/. " + venta.getImporteTotalPagar();
		
		ta_salida.setText(boleta);
	}
}
