package VISTA;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import com.mysql.fabric.xmlrpc.base.Data;

import APP.Metodoak;
import APP.MetodoakVista;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;

public class SaioaSortu extends JFrame {

	private JTextField txtDNI = new JTextField();
	private JTextField txtIzena = new JTextField();
	private JTextField txtAbizena = new JTextField();
	private JPasswordField passwordPasahitza = new JPasswordField();
	private JPasswordField passwordPasahitza2 = new JPasswordField();
	private JLabel lblDni = new JLabel("DNI:");
	private JLabel lblIzena = new JLabel("Izena:");
	private JLabel lblAbizena = new JLabel("Abizena:");
	private JLabel lblSexua = new JLabel("Sexua:");
	private JRadioButton rdbtnGizona = new JRadioButton("Gizona");
	private JRadioButton rdbtnEmakumea = new JRadioButton("Emakumea");
	private JButton btnAtzera = new JButton("Atzera");
	private JLabel lblPasahitza = new JLabel("Pasahitza:");
	private JLabel lblPasahitzaBaieztatu = new JLabel("Pasahitza errepikatu");
	private JButton btnAurrera = new JButton("Aurrera");
	private ActionListener alBAurrera;
	private ActionListener alBAtzera;
	private JSpinner Data = new JSpinner();
	private JLabel lblJaiotzeData = new JLabel("Jaiotze data:");
	
	
	public SaioaSortu() {
		this.setSize(478, 300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(550, 200, 635, 455);
		getContentPane().setLayout(null);
		
		
		lblDni.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblDni.setBounds(56, 76, 69, 36);
		getContentPane().add(lblDni);
		
		
		txtDNI.setBounds(123, 76, 156, 36);
		getContentPane().add(txtDNI);
		txtDNI.setColumns(10);
		
		
		lblIzena.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblIzena.setBounds(56, 145, 83, 36);
		getContentPane().add(lblIzena);
		
		
		txtIzena.setBounds(149, 150, 126, 31);
		getContentPane().add(txtIzena);
		txtIzena.setColumns(10);
		
		
		lblAbizena.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblAbizena.setBounds(56, 217, 106, 31);
		getContentPane().add(lblAbizena);
		
		
		txtAbizena.setBounds(172, 217, 156, 31);
		getContentPane().add(txtAbizena);
		txtAbizena.setColumns(10);
		
		
		lblSexua.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblSexua.setBounds(346, 94, 88, 31);
		getContentPane().add(lblSexua);
		
		
		rdbtnGizona.setFont(new Font("Tahoma", Font.PLAIN, 21));
		rdbtnGizona.setBounds(440, 85, 109, 23);
		getContentPane().add(rdbtnGizona);
		
		
		rdbtnEmakumea.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnEmakumea.setBounds(440, 114, 126, 23);
		getContentPane().add(rdbtnEmakumea);
		
		alBAtzera = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				MetodoakVista.bigarrenera();
			}
			
		};
		btnAtzera.addActionListener(alBAtzera);
		btnAtzera.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAtzera.setBounds(0, 0, 106, 31);
		getContentPane().add(btnAtzera);
		
		
		passwordPasahitza.setBounds(180, 278, 170, 31);
		getContentPane().add(passwordPasahitza);
		
		
		lblPasahitza.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblPasahitza.setBounds(56, 278, 113, 31);
		getContentPane().add(lblPasahitza);
		
		
		lblPasahitzaBaieztatu.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblPasahitzaBaieztatu.setBounds(89, 319, 232, 31);
		getContentPane().add(lblPasahitzaBaieztatu);
		
		
		alBAurrera = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				MetodoakVista.hirugarrenera();
			}
			
		};
		btnAurrera.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAurrera.addActionListener(alBAurrera);
		btnAurrera.setBounds(513, 386, 106, 31);
		getContentPane().add(btnAurrera);
		
		
		passwordPasahitza2.setBounds(99, 361, 204, 31);
		getContentPane().add(passwordPasahitza2);
		
		
		Data.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Data.setModel(new SpinnerDateModel(new Date(1546297200000L), null, null, Calendar.DAY_OF_YEAR));
		Data.setBounds(440, 267, 144, 23);
		getContentPane().add(Data);
		
		
		lblJaiotzeData.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblJaiotzeData.setBounds(440, 220, 144, 36);
		getContentPane().add(lblJaiotzeData);

		
	}
}
