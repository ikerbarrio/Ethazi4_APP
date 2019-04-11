package VISTA;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SwingConstants;

import APP.MetodoakVista;

public class SaioaSortu extends JFrame {

	private JPanel contentPane;
	private ActionListener alBAurrera;
	private ActionListener alBAtzera;
	private ActionListener alBHasiera;
	private JTextField txtIzena;
	private JTextField txtAbizena;
	private JTextField txtEposta;
	private JButton btnAurrera = new JButton("AURRERA");
	private JRadioButton rdbtnGizonezkoa = new JRadioButton("GIZONA");
	private JRadioButton rdbtnEmakumea = new JRadioButton("EMAKUMEA");
	private JLabel lblSaioaSortu = new JLabel("SAIOA SORTU");
	private JLabel lblAbizena = new JLabel("Abizena");
	private JLabel lblIzena = new JLabel("Izena");
	private final JLabel lblPasahitza = new JLabel("Pasahitza");
	private JLabel lblEposta = new JLabel("E-posta");
	private final JLabel lblErabiltzailea = new JLabel("Erabiltzailea");
	private final JSpinner jaioData = new JSpinner();
	private JTextField erabiltzaile;
	private JPasswordField pasahitza;
	private final JLabel lblJaiotze = new JLabel("Jaiotze data");
	private JButton btnHasiera = new JButton("HASIERA");

	/**
	 * Create the frame.
	 */
	public SaioaSortu() {
		this.setSize(478, 300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(550, 200, 635, 455);
		getContentPane().setLayout(null);
		btnAurrera.setBounds(520, 382, 89, 23);
		getContentPane().add(btnAurrera);

		txtIzena = new JTextField();
		txtIzena.setBounds(121, 57, 182, 36);
		getContentPane().add(txtIzena);
		txtIzena.setColumns(10);

		lblSaioaSortu.setHorizontalAlignment(SwingConstants.CENTER);
		lblSaioaSortu.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblSaioaSortu.setBounds(230, 10, 160, 36);
		getContentPane().add(lblSaioaSortu);

		lblIzena.setHorizontalAlignment(SwingConstants.CENTER);
		lblIzena.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblIzena.setBounds(27, 57, 75, 36);
		getContentPane().add(lblIzena);

		txtAbizena = new JTextField();
		txtAbizena.setColumns(10);
		txtAbizena.setBounds(121, 104, 182, 36);
		getContentPane().add(txtAbizena);

		lblAbizena.setHorizontalAlignment(SwingConstants.CENTER);
		lblAbizena.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAbizena.setBounds(27, 104, 75, 36);
		getContentPane().add(lblAbizena);

		rdbtnGizonezkoa.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnGizonezkoa.setBounds(15, 352, 109, 23);
		getContentPane().add(rdbtnGizonezkoa);

		rdbtnEmakumea.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnEmakumea.setBounds(173, 352, 109, 23);
		getContentPane().add(rdbtnEmakumea);

		txtEposta = new JTextField();
		txtEposta.setBounds(121, 151, 182, 36);
		getContentPane().add(txtEposta);
		txtEposta.setColumns(10);

		lblEposta.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEposta.setHorizontalAlignment(SwingConstants.CENTER);
		lblEposta.setBounds(27, 151, 75, 36);
		getContentPane().add(lblEposta);

		lblErabiltzailea.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblErabiltzailea.setHorizontalAlignment(SwingConstants.CENTER);
		lblErabiltzailea.setBounds(15, 198, 100, 36);

		getContentPane().add(lblErabiltzailea);
		lblPasahitza.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPasahitza.setHorizontalAlignment(SwingConstants.CENTER);
		lblPasahitza.setBounds(15, 245, 100, 41);

		getContentPane().add(lblPasahitza);

		alBAurrera = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				MetodoakVista.hirugarrenera();
				dispose();
<<<<<<< HEAD

			};

=======
			
			}
>>>>>>> fe5de7412c9ec50e1e4a752e01f40e650a17e41a
		};
		btnAurrera.addActionListener(alBAurrera);

		jaioData.setFont(new Font("Tahoma", Font.PLAIN, 20));

		jaioData.setModel(new SpinnerDateModel(new Date(1546297200000L), null, null, Calendar.DAY_OF_YEAR));
		jaioData.setBounds(121, 292, 182, 36);

		getContentPane().add(jaioData);

		pasahitza = new JPasswordField();
		pasahitza.setBounds(121, 245, 182, 36);
		getContentPane().add(pasahitza);
		lblJaiotze.setHorizontalAlignment(SwingConstants.CENTER);
		lblJaiotze.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblJaiotze.setBounds(15, 292, 100, 36);

		getContentPane().add(lblJaiotze);

		erabiltzaile = new JTextField();
		erabiltzaile.setBounds(121, 198, 182, 36);
		getContentPane().add(erabiltzaile);
		erabiltzaile.setColumns(10);

		JButton btnAtzera = new JButton("ATZERA");
		btnAtzera.setBounds(520, 348, 89, 23);
		getContentPane().add(btnAtzera);

		alBAtzera = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				MetodoakVista.bigarrenera();
				dispose();

			};
		};
		btnAurrera.addActionListener(alBAtzera);
		
		btnHasiera.setBounds(520, 314, 89, 23);
		getContentPane().add(btnHasiera);
		alBHasiera = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				MetodoakVista.bigarrenera();
				dispose();

			};
		};
		btnAurrera.addActionListener(alBHasiera);
	}
}
