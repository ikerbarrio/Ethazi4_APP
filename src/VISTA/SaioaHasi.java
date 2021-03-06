package VISTA;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import APP.*;
import DB.*;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class SaioaHasi extends JFrame {

	private JTextField txtDNI = new JTextField();
	private JLabel lblDNI = new JLabel("DNI:");
	private JLabel lblPasahitza = new JLabel("Pasahitza:");
	private JButton btnAurrera = new JButton("Aurrera");
	private JButton btnAtzera = new JButton("Atzera");
	private JButton btnIrten = new JButton("IRTEN");
	private String DNI;
	private boolean DNIkonprobatu;
	private String pasahitzaEnkriptatuta;
	private boolean pasahitzaKonprobatu;
	private JPasswordField passwordField;
	private ActionListener alBAurrera;
	private ActionListener alBAtzera;
	private ActionListener alBIrten;
	private ActionListener alBSaioaSortu;
	private JButton btnSaioaSortu = new JButton("Saioa sortu");
	private JLabel lblSaioaHasi = new JLabel("SAIOA HASI");

	
	public SaioaHasi(double prezioFinala,String hotela,String gelaMota) {
		this.setSize(478, 300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(550, 200, 635, 455);
		getContentPane().setLayout(null);
		
		lblDNI.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblDNI.setBounds(139, 106, 108, 87);
		getContentPane().add(lblDNI);
		
		
		txtDNI.setBounds(240, 127, 193, 43);
		getContentPane().add(txtDNI);
		txtDNI.setColumns(10);
		
		
		lblPasahitza.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblPasahitza.setBounds(82, 204, 193, 103);
		getContentPane().add(lblPasahitza);
		
		
		alBAurrera = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pasahitzaEnkriptatuta = Metodoak.getMD5(passwordField.getText());
				pasahitzaKonprobatu = Metodoak.pasahitzaKomprobaketa(pasahitzaEnkriptatuta);
				System.out.println(pasahitzaEnkriptatuta);
				
				DNI = Metodoak.getMD5(txtDNI.getText());
				DNIkonprobatu = Metodoak.nanKomprobaketa(DNI);
			
				if(DNIkonprobatu==true && pasahitzaKonprobatu==true) {
					MetodoakVista.ordainketaLeihora(prezioFinala,hotela,gelaMota);
					dispose();
				}else {
					JOptionPane.showMessageDialog(null, "Ez da existitzen\n Saiatu berriro");
				}
			}

			
		};
		
		btnAurrera.setEnabled(true);
		btnAurrera.addActionListener(alBAurrera);
		btnAurrera.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAurrera.setBounds(510, 373, 113, 44);
		getContentPane().add(btnAurrera);

		
		alBAtzera = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MetodoakVista.hostatuaAukeratzera();
				dispose();
			}
		};
		btnAtzera.addActionListener(alBAtzera);
		btnAtzera.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAtzera.setBounds(0, 0, 89, 33);
		getContentPane().add(btnAtzera);
		
		
		alBIrten = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MetodoakVista.bueltatuLehena();
				dispose();
			}
		};
		btnIrten.addActionListener(alBIrten);
		btnIrten.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnIrten.setBounds(524, 0, 99, 33);
		getContentPane().add(btnIrten);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(277, 232, 183, 43);
		getContentPane().add(passwordField);
		
		alBSaioaSortu = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MetodoakVista.saioaSortzera(prezioFinala,hotela,gelaMota);
				dispose();
			}
		};
		btnSaioaSortu.addActionListener(alBSaioaSortu);
		btnSaioaSortu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSaioaSortu.setBounds(186, 335, 177, 33);
		getContentPane().add(btnSaioaSortu);
		
		
		lblSaioaHasi.setHorizontalAlignment(SwingConstants.CENTER);
		lblSaioaHasi.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblSaioaHasi.setBounds(184, 50, 249, 45);
		getContentPane().add(lblSaioaHasi);
		
		}
}