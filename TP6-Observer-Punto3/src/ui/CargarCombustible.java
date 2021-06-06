package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import modelo.EstacionDeServicio;
import modelo.ValidarException;

public class CargarCombustible extends JFrame {

	private JPanel contentPane;
	private JTextField litros;
	private JTextField montoTextField;
	private JTextField emailTextField;

	public CargarCombustible(EstacionDeServicio estacion) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(550, 300, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		setTitle("Carga de Combustible");

		JLabel lblNewLabel = new JLabel("LitrosCargados:");
		lblNewLabel.setBounds(32, 60, 144, 14);
		contentPane.add(lblNewLabel);

		litros = new JTextField();
		litros.setBounds(214, 57, 86, 20);
		contentPane.add(litros);
		litros.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("TipoDeNafta:");
		lblNewLabel_1.setBounds(32, 117, 75, 14);
		contentPane.add(lblNewLabel_1);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(139, 112, 86, 24);
		contentPane.add(comboBox);
		comboBox.addItem("Comun");
		comboBox.addItem("Super");

		JButton btnNewButton = new JButton("ConsultarMontoTotal");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String tipo = comboBox.getSelectedItem().toString();

					if (Integer.parseInt(litros.getText()) > 0) {

						montoTextField.setText(String.valueOf(estacion.realizarMontoTotal(tipo,
								Integer.parseInt(litros.getText()), LocalDateTime.now())));

					} else {
						JOptionPane.showMessageDialog(null, "La cantidad de Litros no puede ser 0", "Error",
								JOptionPane.ERROR_MESSAGE);
					}

				} catch (ValidarException exp) {
					JOptionPane.showMessageDialog(null, exp.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		btnNewButton.setBounds(10, 164, 181, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("ConfirmarPago");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String tipo = comboBox.getSelectedItem().toString();

					estacion.realizarVenta(tipo, Integer.parseInt(litros.getText()), emailTextField.getText());

					JOptionPane.showMessageDialog(null, "Se guardo la Venta con exito", "Informe",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (ValidarException exp) {
					JOptionPane.showMessageDialog(null, exp.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				} catch (Exception exp) {
					JOptionPane.showMessageDialog(null, exp.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(10, 227, 155, 23);
		contentPane.add(btnNewButton_1);

		montoTextField = new JTextField();
		montoTextField.setBounds(214, 165, 86, 20);
		contentPane.add(montoTextField);
		montoTextField.setColumns(10);

		JButton btnNewButton_2 = new JButton("Cancelar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton_2.setBounds(268, 227, 89, 23);
		contentPane.add(btnNewButton_2);

		JLabel email = new JLabel("Para Email:");
		email.setBounds(20, 202, 75, 14);
		contentPane.add(email);

		emailTextField = new JTextField();
		emailTextField.setBounds(130, 196, 149, 20);
		contentPane.add(emailTextField);
		emailTextField.setColumns(10);
	}
}
