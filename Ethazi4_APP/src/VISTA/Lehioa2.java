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

import APP.Metodoak;
import APP.MetodoakVista;
import DB.Kontsultak;
import javax.swing.JList;
import javax.swing.JTextArea;

public class Lehioa2 extends JFrame {
	/**
	 * Frame-aren atributu eta komponente guztiak sortu 
	 */
	Metodoak m = new Metodoak();
	private ActionListener al;
	private JPanel contentPanel;
	private JSpinner spinerGauKopurua = new JSpinner();
	private JLabel lblGauKopurua = new JLabel("GAU KOPURUA");
	private JComboBox comboHiria = new JComboBox();
	private ArrayList <String>hotelak = new ArrayList();
	private ArrayList hiriak = new ArrayList();
	private JLabel lblHotelak = new JLabel("HOTELA AUKERATU");
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
		spinerGauKopurua.setBounds(237, 325, 168, 31);
		getContentPane().add(spinerGauKopurua);
		
		lblGauKopurua.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblGauKopurua.setHorizontalAlignment(SwingConstants.CENTER);
		lblGauKopurua.setBounds(227, 264, 168, 50);
		getContentPane().add(lblGauKopurua);
		
		comboHiria.setBounds(10, 180, 168, 31);
		getContentPane().add(comboHiria);
		hiriak = Kontsultak.hiriakPantailaratu();
		
		for(int n = 0; n < hiriak.size(); n++) {
			comboHiria.addItem(hiriak.get(n));
		}
		
		al = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
								
				for(int i=0;i<hiriak.size();i++) {
					if(comboHotelak.getSelectedItem().equals(hiriak.get(i))) {
						
						
					}
				}
				
			}
		};
		comboHiria.addActionListener(al);
		
		lblHotelak.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHotelak.setHorizontalAlignment(SwingConstants.CENTER);
		lblHotelak.setBounds(10, 129, 168, 28);

		lblGauKopurua.setBounds(63, 224, 168, 41);
		getContentPane().add(lblGauKopurua);
		hotelak = Kontsultak.hotelIzenaPantailaratu(getName());
		comboHotelak.setBounds(63, 182, 168, 31);
		
		for(int n = 0; n < hotelak.size(); n++) {
			comboHotelak.addItem(hotelak.get(n));
		}
		
		getContentPane().add(comboHotelak);
		
		
		lblHotelak.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHotelak.setHorizontalAlignment(SwingConstants.CENTER);
		lblHotelak.setBounds(63, 143, 168, 28);

		getContentPane().add(lblHotelak);
		
		lblAukeratu.setHorizontalAlignment(SwingConstants.CENTER);
		lblAukeratu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAukeratu.setBounds(63, 61, 215, 41);
		getContentPane().add(lblAukeratu);
		
		comboHiria.setBounds(265, 65, 168, 31);
		getContentPane().add(comboHiria);

		hotelak = Kontsultak.hotelIzenaPantailaratu("Madrid");
		

		//comboHotelak.add(hotelak);
	



//		hiriak = adfasD;
		comboHiria.addItem(hiriak);
		hotelInfo.setEditable(false);
		
		hotelInfo.setBackground(Color.LIGHT_GRAY);
		
		hotelInfo.setBounds(288, 149, 274, 158);
		getContentPane().add(hotelInfo);
		hotelInfo.setText("KAKADELAVACA");
		
		btnAurrera.setBounds(530, 393, 89, 23);
		getContentPane().add(btnAurrera);
		al = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
				for(int i=0;i<hotelak.size();i++) {
					if(comboHotelak.getSelectedItem().equals(hotelak.get(i))) {
						m.fitxeroaIdatzi(hotelak.get(i).toString());
						
					}
				}
			//	m.fitxeroaIdatzi("aeiou");
				m.FitxeroaIrakurri();
				dispose();
				MetodoakVista.hirugarrenera();
				
			}
		};
		btnAurrera.addActionListener(al);
		
		btnAtzera.setBounds(0, 0, 89, 23);
		getContentPane().add(btnAtzera);
		al = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MetodoakVista.bueltatuLehena();
			}
		};



	}
}
