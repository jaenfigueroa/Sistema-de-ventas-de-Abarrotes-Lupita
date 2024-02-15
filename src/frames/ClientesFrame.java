package frames;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import clases.Cliente;
import managers.ClienteManager;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class ClientesFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tf_nombres;
	private JTextField tf_apellidos;
	private JTextField tf_direccion;
	private JTextField tf_dni;
	private JTextField tf_telefono;
	private JTextField tf_codigoCliente;	
	private JTable tb_resultados;

	/**
	 * Create the frame.
	 */
	public ClientesFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1092, 664);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombres");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 28, 96, 13);
		contentPane.add(lblNewLabel);
		
		tf_nombres = new JTextField();
		tf_nombres.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tf_nombres.setBounds(107, 25, 289, 19);
		contentPane.add(tf_nombres);
		tf_nombres.setColumns(10);
		
		tf_apellidos = new JTextField();
		tf_apellidos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tf_apellidos.setColumns(10);
		tf_apellidos.setBounds(107, 64, 289, 19);
		contentPane.add(tf_apellidos);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblApellidos.setBounds(10, 67, 96, 13);
		contentPane.add(lblApellidos);
		
		tf_direccion = new JTextField();
		tf_direccion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tf_direccion.setColumns(10);
		tf_direccion.setBounds(107, 106, 289, 19);
		contentPane.add(tf_direccion);
		
		JLabel lblDireccin = new JLabel("Dirección");
		lblDireccin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDireccin.setBounds(10, 109, 96, 13);
		contentPane.add(lblDireccin);
		
		JLabel lblNewLabel_1_1 = new JLabel("DNI");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(10, 197, 96, 13);
		contentPane.add(lblNewLabel_1_1);
		
		tf_dni = new JTextField();
		tf_dni.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tf_dni.setColumns(10);
		tf_dni.setBounds(107, 194, 289, 19);
		contentPane.add(tf_dni);
		
		tf_telefono = new JTextField();
		tf_telefono.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tf_telefono.setColumns(10);
		tf_telefono.setBounds(107, 155, 289, 19);
		contentPane.add(tf_telefono);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTelefono.setBounds(10, 158, 96, 13);
		contentPane.add(lblTelefono);
		
		JLabel lblCodigo = new JLabel("Codigo de cliente");
		lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCodigo.setBounds(581, 31, 133, 13);
		contentPane.add(lblCodigo);
		
		tf_codigoCliente = new JTextField();
		tf_codigoCliente.setEditable(false);
		tf_codigoCliente.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tf_codigoCliente.setColumns(10);
		tf_codigoCliente.setBounds(715, 28, 96, 19);
		contentPane.add(tf_codigoCliente);
		
		JComboBox cb_opciones = new JComboBox();
		cb_opciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int opcionElegida = cb_opciones.getSelectedIndex();
				
				if(opcionElegida == 1) {
					tf_codigoCliente.setEditable(true);
				}
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
				String apellidos = tf_apellidos.getText();
				String direccion = tf_direccion.getText();
				String telefono = tf_telefono.getText();
				String dni = tf_dni.getText();
				int codigoCliente = Integer.parseInt(tf_codigoCliente.getText());
				
				// Recoger la accion a realizar
				int accionARealizar = cb_opciones.getSelectedIndex();
				
				// Elegir la accion a realizar
				
				Cliente cliente = null;
				
				switch (accionARealizar) {
					// CREAR
					case 0:
						cliente = new Cliente(nombres, apellidos, direccion, telefono, dni);
						
						ClienteManager.agregarCliente(cliente);
						
						// Mostrar el codigo de cliente recién creado
						tf_codigoCliente.setText(cliente.getCodigoCliente() + "");

						mostrarDatosCliente(cliente);
						break;
					
					// MODIFICAR
					case 1:
						cliente = new Cliente(nombres, apellidos, direccion, telefono, dni);

						Cliente clienteModificado = ClienteManager.modificarCliente(cliente);
						
						mostrarDatosCliente(clienteModificado);
						break;
						
					// CONSULTAR
					case 2:
						Cliente clienteEncontrado = ClienteManager.consultarCliente(codigoCliente);

						mostrarDatosCliente(clienteEncontrado);
						break;
						
					// ELIMINAR
					case 3:
						Cliente clienteEliminado = ClienteManager.eliminarCliente(codigoCliente);
						mostrarDatosCliente(clienteEliminado);
						break;
						
					// LISTAR
					case 4:
						ClienteManager.listarClientes();
						break;
				}
				
			}
		});
		btn_ok.setBounds(437, 195, 85, 21);
		contentPane.add(btn_ok);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 262, 974, 309);
		contentPane.add(scrollPane);
		
		tb_resultados = new JTable();
		scrollPane.setViewportView(tb_resultados);
		
		
		tb_resultados.setModel(new DefaultTableModel(
			new Object[][] {
				{new Integer(11111111), "Maria", "Fernandez", "Arequipa", "9999999999", "77777777777"},
				{new Integer(2222222), "Jose", "Perez", "Lima", "888888888", null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"Codigo", "Nombres", "Apellidos", "Direcci\u00F3n", "Telefono", "DNI"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
	}
	
	// Metodos
	public void mostrarDatosCliente(Cliente cliente) {
		String mensaje = "DATOS DEL CLIENTE\n";
			mensaje += "\nCodigo del cliente: " + cliente.getCodigoCliente();
			mensaje += "\nNombres: " + cliente.getNombres();	
			mensaje += "\nApellidos: " + cliente.getApellidos();
			mensaje += "\nDireccion: " + cliente.getDireccion();
			mensaje += "\nTelefono: " + cliente.getTelefono();
			mensaje += "\nDNI: " + cliente.getDni();
			
			mensaje += "\n\nCantidad de cliente: " + Cliente.getCantidadClientes();
			
			//ta_resultados.setText(mensaje);
	}
}
