package frames;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class VentasFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tf_stockActual;
	private JTable tblTabla;
	private DefaultTableModel modelo;
	private JTextField tf_codigo;
	private JTextField tf_cantidad;

	/**
	 * Create the frame.
	 */
	public VentasFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 618, 465);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Stock actual del producto");
		lblNewLabel.setBounds(235, 17, 149, 13);
		contentPane.add(lblNewLabel);
		
		tf_stockActual = new JTextField();
		tf_stockActual.setEditable(false);
		tf_stockActual.setBounds(235, 36, 149, 19);
		contentPane.add(tf_stockActual);
		tf_stockActual.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Cantidad de productos");
		lblNewLabel_1.setBounds(10, 65, 105, 25);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Actualizar Stock");
		btnNewButton.setBounds(469, 13, 120, 21);
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
		 
//		 modelo.setRowCount(0);
//		 Object[] fila = { 123, "Ana", 19, 15, 17.0 };
//		 modelo.addRow(fila);
	}
}
