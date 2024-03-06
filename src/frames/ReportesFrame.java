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

import app.Main;
import clases.Producto;
import clases.Venta;
import managers.ProductoManager;
import managers.VentaManager;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class ReportesFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextArea ta_salida;

	private DefaultTableModel modelo_1;
	private DefaultTableModel modelo_2;

	/**
	 * Create the frame.
	 */
	public ReportesFrame() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 646, 510);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Reportes");

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JComboBox cb_tipoReporte = new JComboBox();
		cb_tipoReporte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// recogemos el tipo de reporte del combo box
				int accionARealizar = cb_tipoReporte.getSelectedIndex();
				
				String reporte = "";

				switch (accionARealizar) {
					case 0:
						reporte += generarReporte1(Main.ventaManager.listar());
						break;
					case 1:
						reporte += generarReporte2(Main.productoManager.listar());
						break;
					case 2:
						reporte += generarReporte3(Main.productoManager.listar());
						break;
					case 3:
						reporte += generarReporte4(Main.productoManager.listar());
						break;
				}
				
				ta_salida.setText(reporte);
			}

		});
		cb_tipoReporte.setModel(new DefaultComboBoxModel(new String[] { "Listado general de ventas",
				"Listado de productos cuyo stock se encuentra por debajo del stock mínimo",
				"Listado de productos por unidades vendidas acumuladas",
				"Listado de productos por importe total acumulado" }));
		cb_tipoReporte.setBounds(116, 10, 505, 21);
		contentPane.add(cb_tipoReporte);

		JLabel lblNewLabel = new JLabel("Tipo de reporte");
		lblNewLabel.setBounds(10, 10, 104, 21);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 44, 611, 407);
		contentPane.add(scrollPane);
		
		ta_salida = new JTextArea();
		scrollPane.setViewportView(ta_salida);

		modelo_1 = new DefaultTableModel();
		modelo_1.addColumn("Código venta");
		modelo_1.addColumn("Codigo cliente");
		modelo_1.addColumn("Codigo producto");
		modelo_1.addColumn("Fecha");
		modelo_1.addColumn("Importe subtotal");
		modelo_1.addColumn("Importe impuesto");
		modelo_1.addColumn("Importe total");

		modelo_2 = new DefaultTableModel();
		modelo_2.addColumn("Codigo producto");
		modelo_2.addColumn("Nombre producto");
		modelo_2.addColumn("Precio producto");
		modelo_2.addColumn("Stock actual");
		modelo_2.addColumn("Stock minimo");
		modelo_2.addColumn("Stock maximo");
		
		// generar el reporte 1 por defecto
		ta_salida.setText(generarReporte1(Main.ventaManager.listar()));
	}
	
	// metodos
	public void limpiarTabla(DefaultTableModel modelo) {
		while (modelo.getRowCount() > 0) {
			modelo.removeRow(0);
		}
	}
	
	public void rellenarTabla(ArrayList<Producto> productos, DefaultTableModel modelo) {
		for (int i = 0; i < productos.size(); i++) {

			modelo.setRowCount(i);
			Object[] fila = { productos.get(i).getCodigoProducto(), productos.get(i).getNombre(),
					productos.get(i).getPrecio(), productos.get(i).getStockActual(), productos.get(i).getStockMinimo(),
					productos.get(i).getStockMaximo(), };
			modelo.addRow(fila);
		}
	}
	
	// reportes
	public String generarReporte1(ArrayList<Venta> ventas) {
		String reporte = "REPORTE\n\n";
		
		for (Venta venta : ventas) {
			reporte += "Codigo de venta: " + venta.getCodigoVenta() + "\n";
			reporte += "Codigo de cliente: " + venta.getCodigoCliente() + "\n";
			reporte += "Codigo producto: " + venta.getCodigoProducto() + "\n";
			reporte += "Fecha de venta: " + venta.getFecha() + "\n";
			
//			reporte += "Cantidad: " + venta.getCantidad() + "\n";
//			reporte += "Precio unitario: " + venta.getPrecio() + "\n";
			
			reporte += "Importe subototal: S/. " + venta.getImporteSubtotal() + "\n";
			reporte += "Importe impuesto: S/. " + venta.getImpuestoPagar() + "\n";
			reporte += "Importe total: S/. " + venta.getImporteTotalPagar() + "\n\n";
		}
		
		return reporte;
	}
	
	public String generarReporte2(ArrayList<Producto> productos) {
		
		String reporte = "REPORTE\n\n";
		
		for (Producto producto : productos) {
			if(producto.getStockActual() < producto.getStockMinimo()) {
				reporte += "Codigo: " + producto.getCodigoProducto() + "\n";
				reporte += "Nombre: " + producto.getNombre() + "\n";
				reporte += "Stock actual: " + producto.getStockActual() + "\n";
				reporte += "Stock minimo: " + producto.getStockMinimo() + "\n\n";
			}
		}
		
		return reporte;
	}
	
	public String generarReporte3(ArrayList<Producto> productos) {
		String reporte = "REPORTE\n\n";
		
		for (Producto producto : productos) {
			reporte += "Codigo: " + producto.getCodigoProducto() + "\n";
			reporte += "Nombre: " + producto.getNombre() + "\n";
			reporte += "Unidades vendidas acumuladas: " + producto.getCantidadVentasAcumuladas() + "\n\n";
		}
		
		return reporte;
	}
	
	public String generarReporte4(ArrayList<Producto> productos) {
		String reporte = "REPORTE\n\n";
		
		for (Producto producto : productos) {
			reporte += "Codigo: " + producto.getCodigoProducto() + "\n";
			reporte += "Nombre: " + producto.getNombre() + "\n";
			reporte += "Importe total acumulado: " + producto.getCantidadImporteAcumulado() + "\n\n";
		}
		
		return reporte;
	}
	
	
}
