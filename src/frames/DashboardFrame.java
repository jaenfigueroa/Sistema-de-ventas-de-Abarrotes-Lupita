package frames;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class DashboardFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public DashboardFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(DashboardFrame.class.getResource("/assets/lupita-logo.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 759, 613);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Sistema de ventas de abarrotes Lupita");

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton_1 = new JButton("Ventas");
		btnNewButton_1.setFont(new Font("Arial", Font.PLAIN, 14));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentasFrame frame = new VentasFrame();
				frame.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(345, 42, 113, 43);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_1_1 = new JButton("Almacenamiento");
		btnNewButton_1_1.setFont(new Font("Arial", Font.PLAIN, 14));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AlmacenFrame frame = new AlmacenFrame();
				frame.setVisible(true);
			}
		});
		btnNewButton_1_1.setBounds(468, 42, 139, 43);
		contentPane.add(btnNewButton_1_1);

		JButton btnNewButton_1_2 = new JButton("Reportes");
		btnNewButton_1_2.setFont(new Font("Arial", Font.PLAIN, 14));
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReportesFrame frame = new ReportesFrame();
				frame.setVisible(true);
			}
		});
		btnNewButton_1_2.setBounds(617, 42, 113, 43);
		contentPane.add(btnNewButton_1_2);

		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(10, 10, 325, 93);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton btnClientes = new JButton("Clientes");
		btnClientes.setFont(new Font("Arial", Font.PLAIN, 14));
		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClientesFrame frame = new ClientesFrame();
				frame.setVisible(true);
			}
		});
		btnClientes.setBounds(20, 33, 134, 42);
		panel.add(btnClientes);

		JButton btnNewButton_2_1 = new JButton("Productos");
		btnNewButton_2_1.setFont(new Font("Arial", Font.PLAIN, 14));
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProductosFrame frame = new ProductosFrame();
				frame.setVisible(true);
			}
		});
		btnNewButton_2_1.setBounds(169, 33, 134, 42);
		panel.add(btnNewButton_2_1);

		JLabel lblNewLabel_1 = new JLabel("Mantenimiento");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(87, 10, 132, 13);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(DashboardFrame.class.getResource("/assets/lupita-logo.png")));
		lblNewLabel.setBounds(10, 113, 725, 434);
		contentPane.add(lblNewLabel);
	}
}
