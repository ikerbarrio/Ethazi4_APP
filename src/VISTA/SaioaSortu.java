package VISTA;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import APP.MetodoakVista;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;

public class SaioaSortu extends JFrame {

	private JPanel contentPane;
	private JButton btnAurrera = new JButton("AURRERA");
	private ActionListener alBAurrera;
	private JTextField textField;
	private JTextField textField_1;
	private JRadioButton rdbtnEmakumea = new JRadioButton("EMAKUMEA");
	/**
	 * Create the frame.
	 */
	public SaioaSortu() {
		this.setSize(478, 300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(550, 200, 635, 455);
		getContentPane().setLayout(null);
		btnAurrera.setBounds(520, 393, 89, 23);
		getContentPane().add(btnAurrera);

		textField = new JTextField();
		textField.setBounds(95, 72, 182, 36);
		getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblSaioaSortu = new JLabel("SAIOA SORTU");
		lblSaioaSortu.setHorizontalAlignment(SwingConstants.CENTER);
		lblSaioaSortu.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblSaioaSortu.setBounds(230, 10, 160, 36);
		getContentPane().add(lblSaioaSortu);

		JLabel lblIzena = new JLabel("IZENA");
		lblIzena.setHorizontalAlignment(SwingConstants.CENTER);
		lblIzena.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblIzena.setBounds(10, 70, 75, 36);
		getContentPane().add(lblIzena);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(95, 132, 182, 36);
		getContentPane().add(textField_1);

		JLabel lblAbizena = new JLabel("ABIZENA");
		lblAbizena.setHorizontalAlignment(SwingConstants.CENTER);
		lblAbizena.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAbizena.setBounds(10, 132, 75, 36);
		getContentPane().add(lblAbizena);

		JRadioButton rdbtnGizonezkoa = new JRadioButton("GIZONA");
		rdbtnGizonezkoa.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnGizonezkoa.setBounds(10, 203, 109, 23);
		getContentPane().add(rdbtnGizonezkoa);

		
		rdbtnEmakumea.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnEmakumea.setBounds(121, 203, 109, 23);
		getContentPane().add(rdbtnEmakumea);

		alBAurrera = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				MetodoakVista.hirugarrenera();
				dispose();

			};
		};
		btnAurrera.addActionListener(alBAurrera);
	}
}
