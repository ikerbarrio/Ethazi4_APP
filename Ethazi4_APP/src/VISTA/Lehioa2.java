package VISTA;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSpinner;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class Lehioa2 extends JFrame {

	private JPanel contentPanel;

	/**
	 * Create the frame.
	 */
	public Lehioa2() {
		this.setSize(478, 300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(550, 200, 635, 455);
		getContentPane().setLayout(null);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(417, 278, 168, 31);
		getContentPane().add(spinner);
		
		JLabel lblGauKopurua = new JLabel("GAU KOPURUA");
		lblGauKopurua.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblGauKopurua.setHorizontalAlignment(SwingConstants.CENTER);
		lblGauKopurua.setBounds(417, 228, 168, 50);
		getContentPane().add(lblGauKopurua);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(63, 278, 168, 31);
		getContentPane().add(comboBox);
		
		JLabel lblHotelak = new JLabel("HOTELAK");
		lblHotelak.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHotelak.setHorizontalAlignment(SwingConstants.CENTER);
		lblHotelak.setBounds(63, 239, 168, 28);
		getContentPane().add(lblHotelak);
		
		JLabel lblAukeratu = new JLabel("HIRIA AUKERATU");
		lblAukeratu.setHorizontalAlignment(SwingConstants.CENTER);
		lblAukeratu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAukeratu.setBounds(63, 61, 215, 41);
		getContentPane().add(lblAukeratu);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(265, 65, 168, 31);
		getContentPane().add(comboBox_1);
		
		System.out.println("kkk");
	}
}
