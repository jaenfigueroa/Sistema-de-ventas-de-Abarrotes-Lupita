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

public class ReportesFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

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
		
		JTextArea ta_resultados = new JTextArea();
		ta_resultados.setBounds(10, 80, 1058, 537);
		contentPane.add(ta_resultados);
	}
	
	// Metodos
	
	
	

}
