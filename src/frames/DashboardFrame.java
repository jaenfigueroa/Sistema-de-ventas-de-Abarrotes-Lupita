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

		// RELLENAR DE DATA LA APLICACIÓN

		Main.clienteManager.ingresar(new Cliente("Maria", "Salvatore", "MZ B LT 4", "945645258", "12345678"));
		Main.clienteManager.ingresar(new Cliente("Pablo", "Pinto", "MZ G LT 12", "98545555", "987654321"));
		Main.clienteManager.ingresar(new Cliente("Luis", "Urbina", "MZ E LT 6", "4848484848", "115155151"));
		Main.clienteManager.ingresar(new Cliente("Luciana", "Pinto", "MZ H LT 7", "15484884", "944949494"));
		Main.clienteManager.ingresar(new Cliente("Ana", "Martinez", "MZ F LT 10", "986547854", "369852147"));
		Main.clienteManager.ingresar(new Cliente("Diego", "Garcia", "MZ D LT 5", "978563214", "258741369"));
		Main.clienteManager.ingresar(new Cliente("Laura", "Lopez", "MZ J LT 15", "967854321", "123456789"));
		Main.clienteManager.ingresar(new Cliente("Sofia", "Rodriguez", "MZ C LT 8", "954875236", "987654321"));
		Main.clienteManager.ingresar(new Cliente("Carlos", "Sanchez", "MZ I LT 13", "965874123", "654321987"));

		Main.productoManager.ingresar(new Producto("Atún", 3.5, 80, 10, 200));
		Main.productoManager.ingresar(new Producto("Aceite", 8.5, 80, 10, 200));
		Main.productoManager.ingresar(new Producto("Yogurt", 5, 80, 10, 200));
		Main.productoManager.ingresar(new Producto("Arroz", 4, 80, 10, 200));
		Main.productoManager.ingresar(new Producto("Leche", 2.8, 80, 10, 200));
		Main.productoManager.ingresar(new Producto("Huevos", 6, 80, 10, 200));
		Main.productoManager.ingresar(new Producto("Pan", 1.5, 80, 10, 200));
		Main.productoManager.ingresar(new Producto("Pasta", 2.2, 80, 10, 200));
		Main.productoManager.ingresar(new Producto("Jugo", 4.7, 80, 10, 200));
		Main.productoManager.ingresar(new Producto("Cereal", 3.8, 80, 10, 200));

		Main.ventaManager.ingresar(new Venta(1001, 2001, 5));
		Main.ventaManager.ingresar(new Venta(1002, 2002, 10));
		Main.ventaManager.ingresar(new Venta(1003, 2003, 5));
		Main.ventaManager.ingresar(new Venta(1004, 2004, 10));
		Main.ventaManager.ingresar(new Venta(1001, 2001, 5));
		Main.ventaManager.ingresar(new Venta(1002, 2002, 10));
		Main.ventaManager.ingresar(new Venta(1003, 2001, 5));
		Main.ventaManager.ingresar(new Venta(1004, 2004, 10));
		Main.ventaManager.ingresar(new Venta(1001, 2004, 5));
		Main.ventaManager.ingresar(new Venta(1002, 2003, 10));
		Main.ventaManager.ingresar(new Venta(1003, 2001, 5));
		Main.ventaManager.ingresar(new Venta(1004, 2001, 10));
	}
}
