package VISTA;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import APP.MetodoakVista;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class hostatuaAukeratu extends JFrame {

	private JPanel contentPane;
	private JButton btnHotel = new JButton("HOTELA");
	private JButton btnEtxea = new JButton("ETXEA");
	private JButton btnApartamentua = new JButton("APARTAMENTUA");
	private JLabel lblAukeratuHostatua = new JLabel("AUKERATU HOSTATUA");
	private ActionListener alBtnHotel;
	private ActionListener alBtnEtxea;
	private ActionListener alBtnApartamentua;


	public hostatuaAukeratu() {
		setForeground(Color.DARK_GRAY);
		getContentPane().setForeground(Color.DARK_GRAY);
		getContentPane().setLayout(null);
		
		
		alBtnHotel = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MetodoakVista.hotelaErostera();
				dispose();
			}
		};
		btnHotel.addActionListener(alBtnHotel);
		btnHotel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnHotel.setBounds(217, 129, 195, 43);
		getContentPane().add(btnHotel);
		
		
		alBtnEtxea = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MetodoakVista.etxeaErostera();
				dispose();
			}
		};
		btnEtxea.addActionListener(alBtnEtxea);
		btnEtxea.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnEtxea.setBounds(217, 212, 195, 43);
		getContentPane().add(btnEtxea);
		
		
		alBtnApartamentua = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MetodoakVista.apartamentuaErostera();
				dispose();
			}
		};
		btnApartamentua.addActionListener(alBtnApartamentua);
		btnApartamentua.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnApartamentua.setBounds(217, 297, 195, 43);
		getContentPane().add(btnApartamentua);
		
		
		lblAukeratuHostatua.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblAukeratuHostatua.setHorizontalAlignment(SwingConstants.CENTER);
		lblAukeratuHostatua.setBounds(157, 35, 310, 43);
		getContentPane().add(lblAukeratuHostatua);
		this.setSize(478, 300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(550, 200, 635, 455);
		
		
	}
}