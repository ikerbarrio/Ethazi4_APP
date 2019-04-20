package VISTA;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SwingConstants;

import APP.Metodoak;
import APP.MetodoakVista;

public class SaioaSortu extends JFrame {

	private JPanel contentPane;
	private ActionListener alBAurrera;
	private ActionListener alBAtzera;
	private ActionListener alBHasiera;
	private ActionListener alGizona;
	private ActionListener alEmakumea;
	private JTextField txtIzena;
	private JTextField txtAbizena;
	private JTextField txtNAN;
	private JButton btnAurrera = new JButton("AURRERA");
	private JRadioButton rdbtnGizona = new JRadioButton("GIZONA");
	private JRadioButton rdbtnEmakumea = new JRadioButton("EMAKUMEA");
	private JLabel lblSaioaSortu = new JLabel("SAIOA SORTU");
	private JLabel lblAbizena = new JLabel("Abizena");
	private JLabel lblIzena = new JLabel("Izena");
	private JLabel lblPasahitza = new JLabel("Pasahitza");
	private JLabel lblNan = new JLabel("NAN");
	private JPasswordField pasahitza;
	private final JLabel lblJaiotze = new JLabel("Jaiotze data");
	private JButton btnHasiera = new JButton("HASIERA");
	private JButton btnAtzera = new JButton("ATZERA");
	private final JLabel lblPasahitzaErrepikatu = new JLabel("Pasahitza errepikatu");
	private String pasahitzaEnkriptatuta;
	private String sexua;
	private String data;
	private JPasswordField pasahitzaErrepikatu;
	private final JSpinner jaioData = new JSpinner();

	/**
	 * Create the frame.
	 */
	public SaioaSortu(double prezioFinala) {
		this.setSize(478, 300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(550, 200, 635, 455);
		getContentPane().setLayout(null);
		btnAurrera.setBounds(520, 382, 89, 23);
		getContentPane().add(btnAurrera);
		
		

		txtIzena = new JTextField();
		txtIzena.setBounds(264, 57, 182, 36);
		getContentPane().add(txtIzena);
		txtIzena.setColumns(10);

		lblSaioaSortu.setHorizontalAlignment(SwingConstants.CENTER);
		lblSaioaSortu.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblSaioaSortu.setBounds(230, 10, 160, 36);
		getContentPane().add(lblSaioaSortu);

		lblIzena.setHorizontalAlignment(SwingConstants.CENTER);
		lblIzena.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblIzena.setBounds(179, 55, 75, 36);
		getContentPane().add(lblIzena);

		txtAbizena = new JTextField();
		txtAbizena.setColumns(10);
		txtAbizena.setBounds(264, 104, 182, 36);
		getContentPane().add(txtAbizena);

		lblAbizena.setHorizontalAlignment(SwingConstants.CENTER);
		lblAbizena.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAbizena.setBounds(179, 102, 75, 36);
		getContentPane().add(lblAbizena);

		rdbtnGizona.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnGizona.setBounds(154, 335, 109, 23);
		getContentPane().add(rdbtnGizona);

		rdbtnEmakumea.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnEmakumea.setBounds(337, 335, 109, 23);
		getContentPane().add(rdbtnEmakumea);
		
		alGizona = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				rdbtnGizona.setSelected(true);
				rdbtnEmakumea.setSelected(false);
				

			}
		};
		rdbtnGizona.addActionListener(alGizona);
		
		alEmakumea = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				rdbtnGizona.setSelected(false);
				rdbtnEmakumea.setSelected(true);

			}
		};
		rdbtnEmakumea.addActionListener(alEmakumea);

		txtNAN = new JTextField();
		txtNAN.setBounds(264, 151, 182, 36);
		getContentPane().add(txtNAN);
		txtNAN.setColumns(10);
		lblPasahitza.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPasahitza.setHorizontalAlignment(SwingConstants.CENTER);
		lblPasahitza.setBounds(154, 196, 100, 36);

		getContentPane().add(lblPasahitza);

		alBAurrera = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				boolean ondo = true;//balidazioak egiteko
				
				//Izena balidatzen du
				Pattern p1 = Pattern.compile("[A-Z]([a-z]*)+$");
				Matcher m1 = p1.matcher(txtIzena.getText());
				if(!m1.matches()) {
					JOptionPane.showMessageDialog(null, "Izena txarto dago");
					ondo = false;
				}
				
				//Abizena balidatzen du
				Pattern p2 = Pattern.compile("[A-Z]([a-z]*)+$");
				m1 = p2.matcher(txtAbizena.getText());
				if(!m1.matches()) {
					JOptionPane.showMessageDialog(null, "Abizena txarto dago");
					ondo = false;
				}
				
				//NAN balidatzen du
				Pattern p3 = Pattern.compile("[0-9]{8}[A-Z]");
				m1 = p3.matcher(txtNAN.getText());
				if(m1.matches()) {//NAN pattern expresioa betetzen badu letra begiratzen dugu
					if(Metodoak.NANbalidatu(txtNAN.getText())) {
					}else {
						JOptionPane.showMessageDialog(null, "NAN letra txarto dago");
						ondo = false;
					}
				}else {
					JOptionPane.showMessageDialog(null, "NAN txarto dago");
					ondo = false;//NAN-aren letra txarto badago ondo=false
				}
				
				//Pasahitza hutsik badago begiratzen du
				if(pasahitza.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Pasahitza bat sartu");
					ondo=false;
				}
				
				//Pasahitzak berdinak diren begiratzen du
				if(!pasahitza.getText().equals(pasahitzaErrepikatu.getText())) {
					JOptionPane.showMessageDialog(null, "Pasahitzak desberdinak dira");
					ondo = false;
				}else {
					pasahitzaEnkriptatuta = Metodoak.getMD5(pasahitza.getText());//Pasahitza enkriptatzen du
				}
				
				//Gizona edo emakumea aukeratu duen begiratzen du
				if(!rdbtnEmakumea.isSelected() && !rdbtnGizona.isSelected()) {
					JOptionPane.showMessageDialog(null, "Aukeratu sexua");
					ondo = false;
				}else if(rdbtnGizona.isSelected()){
						sexua="V";
					}else {
						sexua="M";
					}
				
				//JaioData to String
				data = new SimpleDateFormat("yyyy/MM/dd").format(jaioData.getValue());
				
				//Dena ondo badago erabiltzailea sartzen du
				if(ondo) {
					Metodoak.sartuErabiltzailea(txtNAN.getText(), txtIzena.getText(), txtAbizena.getText(), data, sexua, pasahitzaEnkriptatuta);
					MetodoakVista.ordainketaLeihora(prezioFinala);
					dispose();
				}
				
			}
		};
		btnAurrera.addActionListener(alBAurrera);

		jaioData.setFont(new Font("Tahoma", Font.PLAIN, 20));

		jaioData.setModel(new SpinnerDateModel(new Date(1546297200000L), null, null, Calendar.DAY_OF_YEAR));
		jaioData.setBounds(264, 292, 182, 36);

		getContentPane().add(jaioData);

		pasahitza = new JPasswordField();
		pasahitza.setBounds(264, 198, 182, 36);
		getContentPane().add(pasahitza);
		lblJaiotze.setHorizontalAlignment(SwingConstants.CENTER);
		lblJaiotze.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblJaiotze.setBounds(154, 292, 100, 36);

		getContentPane().add(lblJaiotze);

		btnAtzera.setBounds(520, 348, 89, 23);
		getContentPane().add(btnAtzera);

		alBAtzera = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				MetodoakVista.saihoaHastera(prezioFinala);
				dispose();

			}
		};
		btnAtzera.addActionListener(alBAtzera);

		btnHasiera.setBounds(520, 314, 89, 23);
		getContentPane().add(btnHasiera);
		alBHasiera = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				MetodoakVista.bueltatuLehena();
				dispose();

			}
		};
		btnHasiera.addActionListener(alBHasiera);
		
		
		lblNan.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNan.setHorizontalAlignment(SwingConstants.CENTER);
		lblNan.setBounds(153, 149, 101, 36);
		getContentPane().add(lblNan);
		lblPasahitzaErrepikatu.setHorizontalAlignment(SwingConstants.CENTER);
		lblPasahitzaErrepikatu.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPasahitzaErrepikatu.setBounds(72, 246, 182, 36);
		
		getContentPane().add(lblPasahitzaErrepikatu);
		
		pasahitzaErrepikatu = new JPasswordField();
		pasahitzaErrepikatu.setBounds(264, 245, 182, 36);
		getContentPane().add(pasahitzaErrepikatu);
	}
}
