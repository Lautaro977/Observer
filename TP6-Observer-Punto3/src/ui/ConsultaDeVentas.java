package ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import modelo.EstacionDeServicio;
import modelo.Venta;

public class ConsultaDeVentas extends JFrame {

	private JPanel contentPane;
	private JTable table;
	DefaultTableModel modelo;

	public ConsultaDeVentas(EstacionDeServicio estacion) {
		String[] titulos = { "FECHA", "LIBROS", "MONTO", "EMAIL" };
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 587, 515);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setTitle("Listado de Ventas");

		JTable table = new JTable();
		table.setBounds(1, 30, 420, 0);

		modelo = new DefaultTableModel(new Object[][] {}, titulos);

		table.setModel(modelo);
		contentPane.add(table, BorderLayout.CENTER);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(13, 42, 422, 218);
		getContentPane().add(scrollPane);

		JButton btnNewButton = new JButton("Salir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		contentPane.add(btnNewButton);

		List<Venta> ventas = new ArrayList<Venta>();
		try {
			ventas = estacion.recuperarVentasEntreDosFechas(LocalDateTime.of(2021, 05, 5, 0, 0),
					LocalDateTime.of(2021, 12, 31, 23, 59));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (Venta ven : ventas) {
			modelo.addRow(new Object[] { ven.obtenerfecha(), ven.obtenerLitrosCargados(), ven.obtenerMontoFactura(),
					ven.obtenerEmail() });
		}

	}
}
