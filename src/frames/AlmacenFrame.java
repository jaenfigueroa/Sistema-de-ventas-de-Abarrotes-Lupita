package frames;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class AlmacenFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the frame.
	 */
	public AlmacenFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1092, 664);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(141, 35, 96, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Codigo del producto");
		lblNewLabel.setBounds(10, 38, 124, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblCantidadDeUnidades = new JLabel("Cantidad de unidades");
		lblCantidadDeUnidades.setBounds(10, 80, 124, 13);
		contentPane.add(lblCantidadDeUnidades);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(141, 77, 96, 19);
		contentPane.add(textField_1);
		
		JButton btnNewButton = new JButton("Ingresar nuevo stock");
		btnNewButton.setBounds(852, 34, 169, 21);
		contentPane.add(btnNewButton);
	}

	// Metodos
	
	
}
