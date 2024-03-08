package frames;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import clases.Cliente;
import clases.Producto;
import clases.Venta;
import app.Main;
import javax.swing.border.EtchedBorder;

public class DashboardFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public DashboardFrame() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 583, 160);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Aplicación");

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton_1 = new JButton("Ventas");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentasFrame frame = new VentasFrame();
				frame.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(172, 48, 113, 21);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_1_1 = new JButton("Almacenamiento");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AlmacenFrame frame = new AlmacenFrame();
				frame.setVisible(true);
			}
		});
		btnNewButton_1_1.setBounds(295, 48, 139, 21);
		contentPane.add(btnNewButton_1_1);

		JButton btnNewButton_1_2 = new JButton("Reportes");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReportesFrame frame = new ReportesFrame();
				frame.setVisible(true);
			}
		});
		btnNewButton_1_2.setBounds(443, 48, 113, 21);
		contentPane.add(btnNewButton_1_2);

		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(10, 10, 152, 101);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton btnClientes = new JButton("Clientes");
		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClientesFrame frame = new ClientesFrame();
				frame.setVisible(true);
			}
		});
		btnClientes.setBounds(10, 38, 134, 21);
		panel.add(btnClientes);

		JButton btnNewButton_2_1 = new JButton("Productos");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProductosFrame frame = new ProductosFrame();
				frame.setVisible(true);
			}
		});
		btnNewButton_2_1.setBounds(10, 69, 134, 21);
		panel.add(btnNewButton_2_1);

		JLabel lblNewLabel_1 = new JLabel("Mantenimiento");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 10, 132, 13);
		panel.add(lblNewLabel_1);
	}
}
