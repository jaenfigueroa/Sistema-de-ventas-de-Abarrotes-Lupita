package frames;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class ProductosFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tf_nombre;
	private JTextField tf_precio;
	private JTextField tf_stockActual;
	private JTextField tf_stockMaximo;
	private JTextField tf_stockMinimo;
	private JTextField tf_codigoProducto;

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
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 28, 96, 13);
		contentPane.add(lblNewLabel);
		
		tf_nombre = new JTextField();
		tf_nombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tf_nombre.setBounds(136, 25, 260, 19);
		contentPane.add(tf_nombre);
		tf_nombre.setColumns(10);
		
		tf_precio = new JTextField();
		tf_precio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tf_precio.setColumns(10);
		tf_precio.setBounds(136, 64, 260, 19);
		contentPane.add(tf_precio);
		
		JLabel lblApellidos = new JLabel("Precio");
		lblApellidos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblApellidos.setBounds(10, 67, 96, 13);
		contentPane.add(lblApellidos);
		
		tf_stockActual = new JTextField();
		tf_stockActual.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tf_stockActual.setColumns(10);
		tf_stockActual.setBounds(136, 106, 260, 19);
		contentPane.add(tf_stockActual);
		
		JLabel lblDireccin = new JLabel("Stock Actual");
		lblDireccin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDireccin.setBounds(10, 109, 96, 13);
		contentPane.add(lblDireccin);
		
		JLabel lblNewLabel_1_1 = new JLabel("Stock Maximo");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(10, 197, 116, 13);
		contentPane.add(lblNewLabel_1_1);
		
		tf_stockMaximo = new JTextField();
		tf_stockMaximo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tf_stockMaximo.setColumns(10);
		tf_stockMaximo.setBounds(136, 194, 260, 19);
		contentPane.add(tf_stockMaximo);
		
		tf_stockMinimo = new JTextField();
		tf_stockMinimo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tf_stockMinimo.setColumns(10);
		tf_stockMinimo.setBounds(136, 155, 260, 19);
		contentPane.add(tf_stockMinimo);
		
		JLabel lblTelefono = new JLabel("Stock Minimo");
		lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTelefono.setBounds(10, 158, 96, 13);
		contentPane.add(lblTelefono);
		
		JLabel lblCodigo = new JLabel("Codigo producto");
		lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCodigo.setBounds(556, 31, 158, 26);
		contentPane.add(lblCodigo);
		
		tf_codigoProducto = new JTextField();
		tf_codigoProducto.setEditable(false);
		tf_codigoProducto.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tf_codigoProducto.setColumns(10);
		tf_codigoProducto.setBounds(715, 28, 96, 29);
		contentPane.add(tf_codigoProducto);
		
		JComboBox cb_opciones = new JComboBox();
		cb_opciones.setModel(new DefaultComboBoxModel(new String[] {"Crear", "Modificar", "Consultar", "Eliminar", "Listar"}));
		cb_opciones.setBounds(867, 26, 180, 19);
		contentPane.add(cb_opciones);
		
		JButton btn_ok = new JButton("OK");
		btn_ok.setBounds(437, 195, 85, 21);
		contentPane.add(btn_ok);
		
		JTextArea ta_resultados = new JTextArea();
		ta_resultados.setBounds(10, 240, 1037, 377);
		contentPane.add(ta_resultados);
	}
}
