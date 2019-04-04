package VISTA;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SwingConstants;

import DB.Kontsultak;
import javax.swing.JList;
import javax.swing.JTextArea;

public class Lehioa2 extends JFrame {

	private JPanel contentPanel;
	private JSpinner spinerGauKopurua = new JSpinner();
	private JLabel lblGauKopurua = new JLabel("GAU KOPURUA");
	private JComboBox comboHiria = new JComboBox();
	private ArrayList hotelak = new ArrayList();
	private JLabel lblHotelak = new JLabel("HOTELAK");
	private JLabel lblAukeratu = new JLabel("HIRIA AUKERATU");
	JComboBox comboHotelak = new JComboBox();
	/**
	 * Create the frame.
	 */
	public Lehioa2() {
		this.setSize(478, 300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(550, 200, 635, 455);
		getContentPane().setLayout(null);
		
		spinerGauKopurua.setBounds(237, 325, 168, 31);
		getContentPane().add(spinerGauKopurua);
		
		lblGauKopurua.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblGauKopurua.setHorizontalAlignment(SwingConstants.CENTER);
		lblGauKopurua.setBounds(227, 264, 168, 50);
		getContentPane().add(lblGauKopurua);
		
		comboHiria.setBounds(10, 180, 168, 31);
		getContentPane().add(comboHiria);
		
		lblHotelak.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHotelak.setHorizontalAlignment(SwingConstants.CENTER);
		lblHotelak.setBounds(10, 129, 168, 28);
		getContentPane().add(lblHotelak);
		
		lblAukeratu.setHorizontalAlignment(SwingConstants.CENTER);
		lblAukeratu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAukeratu.setBounds(63, 61, 215, 41);
		getContentPane().add(lblAukeratu);
		
		comboHotelak.setBounds(265, 65, 168, 31);
		getContentPane().add(comboHotelak);
		hotelak = Kontsultak.hotelPantailaratu();
		comboHotelak.add(hotelak);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(227, 135, 364, 103);
		getContentPane().add(textArea);
	}
}
