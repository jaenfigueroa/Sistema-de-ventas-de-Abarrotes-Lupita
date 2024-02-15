package frames;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class ReportesFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTable table_1;

	/**
	 * Create the frame.
	 */
	public ReportesFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1092, 664);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox cb_tipoReporte = new JComboBox();
		cb_tipoReporte.setModel(new DefaultComboBoxModel(new String[] {"Listado general de ventas", "Listado de productos cuyo stock se encuentra por debajo del stock mínimo", "Listado de productos por unidades vendidas acumuladas", "Listado de productos por importe total acumulado"}));
		cb_tipoReporte.setBounds(104, 31, 723, 21);
		contentPane.add(cb_tipoReporte);
		
		JLabel lblNewLabel = new JLabel("Tipo de reporte");
		lblNewLabel.setBounds(10, 31, 117, 21);
		contentPane.add(lblNewLabel);
		
		JButton btn_generarReporte = new JButton("Generar reporte");
		btn_generarReporte.setBounds(871, 31, 147, 21);
		contentPane.add(btn_generarReporte);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 90, 1025, 170);
		contentPane.add(scrollPane_1);
		
		table = new JTable();
		scrollPane_1.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
			},
			new String[] {
				"Codigo de venta", "Codigo cliente", "Codigo producto", "cantidad", "precio", "fecha"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, Integer.class, Integer.class, Integer.class, Double.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(99);
		table.getColumnModel().getColumn(1).setPreferredWidth(95);
		table.getColumnModel().getColumn(2).setPreferredWidth(95);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 343, 1025, 237);
		contentPane.add(scrollPane);
		
		table_1 = new JTable();
		scrollPane.setViewportView(table_1);
		table_1.setModel(new DefaultTableModel(
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
	}
	
	// Metodos
	
	
	

}
