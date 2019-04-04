package VISTA;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

import APP.MetodoakVista;
import DB.Kontsultak;
import javax.swing.JList;
import javax.swing.JTextArea;

public class Lehioa2 extends JFrame {
	/**
	 * Frame-aren atributu eta komponente guztiak sortu 
	 */
	private ActionListener al;
	private JPanel contentPanel;
	private JSpinner spinerGauKopurua = new JSpinner();
	private JLabel lblGauKopurua = new JLabel("GAU KOPURUA");
	private JComboBox comboHiria = new JComboBox();
	private ArrayList hotelak = new ArrayList();
	private JLabel lblHotelak = new JLabel("HOTELAK");
	private JLabel lblAukeratu = new JLabel("HIRIA AUKERATU");
	private JComboBox comboHotelak = new JComboBox();
	private JTextArea hotelInfo = new JTextArea();
	private JButton btnAurrera = new JButton("AURRERA");
	private JButton btnAtzera = new JButton("ATZERA");
	/**
	 * Frame-aren komponente guztiak
	 */
	public Lehioa2() {
		setForeground(Color.DARK_GRAY);
		getContentPane().setForeground(Color.DARK_GRAY);
		this.setSize(478, 300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(550, 200, 635, 455);
		getContentPane().setLayout(null);
		spinerGauKopurua.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		
<<<<<<< HEAD
		spinerGauKopurua.setBounds(237, 325, 168, 31);
=======
		spinerGauKopurua.setBounds(63, 276, 168, 31);
>>>>>>> e9f03bf7ac2bce711e990efd9382be0b96824cd0
		getContentPane().add(spinerGauKopurua);
		
		lblGauKopurua.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblGauKopurua.setHorizontalAlignment(SwingConstants.CENTER);
<<<<<<< HEAD
		lblGauKopurua.setBounds(227, 264, 168, 50);
		getContentPane().add(lblGauKopurua);
		
		comboHiria.setBounds(10, 180, 168, 31);
		getContentPane().add(comboHiria);
		
		lblHotelak.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHotelak.setHorizontalAlignment(SwingConstants.CENTER);
		lblHotelak.setBounds(10, 129, 168, 28);
=======
		lblGauKopurua.setBounds(63, 224, 168, 41);
		getContentPane().add(lblGauKopurua);
		
		comboHotelak.setBounds(63, 182, 168, 31);
		getContentPane().add(comboHotelak);
		
		lblHotelak.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHotelak.setHorizontalAlignment(SwingConstants.CENTER);
		lblHotelak.setBounds(63, 143, 168, 28);
>>>>>>> e9f03bf7ac2bce711e990efd9382be0b96824cd0
		getContentPane().add(lblHotelak);
		
		lblAukeratu.setHorizontalAlignment(SwingConstants.CENTER);
		lblAukeratu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAukeratu.setBounds(63, 61, 215, 41);
		getContentPane().add(lblAukeratu);
		
		comboHiria.setBounds(265, 65, 168, 31);
		getContentPane().add(comboHiria);
		hotelak = Kontsultak.hotelPantailaratu();
<<<<<<< HEAD
		comboHotelak.add(hotelak);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(227, 135, 364, 103);
		getContentPane().add(textArea);
=======
		comboHiria.addItem(hotelak);
		hotelInfo.setBackground(Color.LIGHT_GRAY);
		
		hotelInfo.setBounds(288, 149, 274, 158);
		getContentPane().add(hotelInfo);
		hotelInfo.setText("KAKADELAVACA");
		
		btnAurrera.setBounds(530, 393, 89, 23);
		getContentPane().add(btnAurrera);
		al = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MetodoakVista.hirugarrenera();
			}
		};
		
		btnAtzera.setBounds(0, 0, 89, 23);
		getContentPane().add(btnAtzera);
		al = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MetodoakVista.bueltatuLehena();
			}
		};
>>>>>>> e9f03bf7ac2bce711e990efd9382be0b96824cd0
	}
}
