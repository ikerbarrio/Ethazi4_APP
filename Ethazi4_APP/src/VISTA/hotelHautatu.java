<<<<<<< HEAD:Ethazi4_APP/src/VISTA/Lehioa3.java
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
import javax.swing.JTextField;

public class Lehioa3 extends JFrame {
	/**
	 * Frame-aren atributu eta komponente guztiak sortu 
	 */
	Metodoak m = new Metodoak();
	private ActionListener al;
	private ActionListener alAtzera;
	private JPanel contentPanel;
	private JSpinner spinerGauKopurua = new JSpinner();
	private JLabel lblGauKopurua = new JLabel("GAU KOPURUA");
	private JComboBox comboHiria = new JComboBox();
	private ArrayList <String>hotelak = new ArrayList();
	private ArrayList hiriak = new ArrayList();
	private JLabel lblHotelak = new JLabel("HOTELA AUKERATU");
	private JLabel lblAukeratu = new JLabel("HIRIA AUKERATU");
	private JComboBox comboHotelak = new JComboBox();
	private JButton btnAurrera = new JButton("AURRERA");
	private JButton btnAtzera = new JButton("ATZERA");
	private JTextField txtInformazioa = new JTextField();
	private int gauKopurua;
	private double prezioFinala;
	/**
	 * Frame-aren komponente guztiak
	 */
	public Lehioa3() {
		
		setForeground(Color.DARK_GRAY);
		getContentPane().setForeground(Color.DARK_GRAY);
		this.setSize(478, 300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(550, 200, 635, 455);
		getContentPane().setLayout(null);
		
		spinerGauKopurua.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinerGauKopurua.setBounds(30, 312, 168, 31);
		getContentPane().add(spinerGauKopurua);
		
		
		lblGauKopurua.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblGauKopurua.setHorizontalAlignment(SwingConstants.CENTER);
		lblGauKopurua.setBounds(20, 251, 168, 50);
		getContentPane().add(lblGauKopurua);
		
		comboHiria.setBounds(10, 180, 168, 31);
		getContentPane().add(comboHiria);
		hiriak = Kontsultak.hiriakPantailaratu();
		
		for(int n = 0; n < hiriak.size(); n++) {
			comboHiria.addItem(hiriak.get(n));
		}
		
		al = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboHotelak.removeAllItems();
				
				hotelak=Kontsultak.hotelIzenaPantailaratu(comboHiria.getSelectedItem().toString());
				
				for(int n = 0; n < hotelak.size(); n++) {
					comboHotelak.addItem(hotelak.get(n));
				}
				
			}
		};
		comboHiria.addActionListener(al);
		
		lblHotelak.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHotelak.setHorizontalAlignment(SwingConstants.CENTER);
		lblHotelak.setBounds(10, 143, 190, 28);

		comboHotelak.setBounds(20, 182, 168, 31);
		
		for(int n = 0; n < hotelak.size(); n++) {
			comboHotelak.addItem(hotelak.get(n));
		}
		al = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(comboHotelak.getItemCount()!=0) {						
							
					txtInformazioa.setText(Kontsultak.hotelInformazioaPantailaratu(comboHotelak.getSelectedItem().toString()));
				}
				
			
			}
		};
		comboHotelak.addActionListener(al);
		getContentPane().add(comboHotelak);
		

		getContentPane().add(lblHotelak);
		
		lblAukeratu.setHorizontalAlignment(SwingConstants.CENTER);
		lblAukeratu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAukeratu.setBounds(63, 61, 215, 41);
		getContentPane().add(lblAukeratu);
		
		comboHiria.setBounds(265, 65, 168, 31);
		getContentPane().add(comboHiria);
		
		
		btnAurrera.setBounds(530, 393, 89, 23);
		getContentPane().add(btnAurrera);
		al = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gauKopurua=(int)spinerGauKopurua.getValue();
				System.out.println(gauKopurua);
				prezioFinala=20*gauKopurua;
				System.out.println(prezioFinala);
				
				for(int i=0;i<hotelak.size();i++) {
					if(comboHotelak.getSelectedItem().equals(hotelak.get(i))) {
						
						m.fitxeroaIdatzi(hotelak.get(i).toString(), prezioFinala);
						

					}
				}
				
				if (comboHotelak.getSelectedItem() == null){
					btnAurrera.setEnabled(false);
				}else{
					btnAurrera.setEnabled(true);
				}
			//	m.fitxeroaIdatzi("aeiou");
				m.FitxeroaIrakurri();
				dispose();
				MetodoakVista.laugarrenera(prezioFinala);
				
			}
		};
		btnAurrera.addActionListener(al);
		
		alAtzera = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MetodoakVista.bigarrenera();
			}
		};
		btnAtzera.addActionListener(alAtzera);
		btnAtzera.setBounds(0, 0, 89, 23);
		getContentPane().add(btnAtzera);

		
		txtInformazioa.setEditable(false);
		txtInformazioa.setBounds(265, 136, 315, 123);
		getContentPane().add(txtInformazioa);
		txtInformazioa.setColumns(10);
		
		
		al = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MetodoakVista.bueltatuLehena();
			}
		};



	}
}
=======
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
import javax.swing.JTextField;

public class Lehioa3 extends JFrame {
	/**
	 * Frame-aren atributu eta komponente guztiak sortu 
	 */
	Metodoak m = new Metodoak();
	private ActionListener al;
	private ActionListener alAtzera;
	private JPanel contentPanel;
	private JSpinner spinerGauKopurua = new JSpinner();
	private JLabel lblGauKopurua = new JLabel("GAU KOPURUA");
	private JComboBox comboHiria = new JComboBox();
	private ArrayList <String>hotelak = new ArrayList();
	private ArrayList hiriak = new ArrayList();
	private JLabel lblHotelak = new JLabel("HOTELA AUKERATU");
	private JLabel lblAukeratu = new JLabel("HIRIA AUKERATU");
	private JComboBox comboHotelak = new JComboBox();
	private JButton btnAurrera = new JButton("AURRERA");
	private JButton btnAtzera = new JButton("ATZERA");
	private JTextField txtInformazioa = new JTextField();
	private int gauKopurua;
	private double prezioFinala;
	/**
	 * Frame-aren komponente guztiak
	 */
	public Lehioa4() {
		
		setForeground(Color.DARK_GRAY);
		getContentPane().setForeground(Color.DARK_GRAY);
		this.setSize(478, 300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(550, 200, 635, 455);
		getContentPane().setLayout(null);
		
		spinerGauKopurua.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinerGauKopurua.setBounds(30, 312, 168, 31);
		getContentPane().add(spinerGauKopurua);
		
		
		lblGauKopurua.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblGauKopurua.setHorizontalAlignment(SwingConstants.CENTER);
		lblGauKopurua.setBounds(20, 251, 168, 50);
		getContentPane().add(lblGauKopurua);
		
		comboHiria.setBounds(10, 180, 168, 31);
		getContentPane().add(comboHiria);
		hiriak = Kontsultak.hiriakPantailaratu();
		
		for(int n = 0; n < hiriak.size(); n++) {
			comboHiria.addItem(hiriak.get(n));
		}
		
		al = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboHotelak.removeAllItems();
				
				hotelak=Kontsultak.hotelIzenaPantailaratu(comboHiria.getSelectedItem().toString());
				
				for(int n = 0; n < hotelak.size(); n++) {
					comboHotelak.addItem(hotelak.get(n));
				}
				
			}
		};
		comboHiria.addActionListener(al);
		
		lblHotelak.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHotelak.setHorizontalAlignment(SwingConstants.CENTER);
		lblHotelak.setBounds(10, 143, 190, 28);

		comboHotelak.setBounds(20, 182, 168, 31);
		
		for(int n = 0; n < hotelak.size(); n++) {
			comboHotelak.addItem(hotelak.get(n));
		}
		al = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(comboHotelak.getItemCount()!=0) {						
							
					txtInformazioa.setText(Kontsultak.hotelInformazioaPantailaratu(comboHotelak.getSelectedItem().toString()));
				}
				
			
			}
		};
		comboHotelak.addActionListener(al);
		getContentPane().add(comboHotelak);
		

		getContentPane().add(lblHotelak);
		
		lblAukeratu.setHorizontalAlignment(SwingConstants.CENTER);
		lblAukeratu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAukeratu.setBounds(63, 61, 215, 41);
		getContentPane().add(lblAukeratu);
		
		comboHiria.setBounds(265, 65, 168, 31);
		getContentPane().add(comboHiria);
		
		
		btnAurrera.setBounds(530, 393, 89, 23);
		getContentPane().add(btnAurrera);
		al = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gauKopurua=(int)spinerGauKopurua.getValue();
				System.out.println(gauKopurua);
				prezioFinala=20*gauKopurua;
				System.out.println(prezioFinala);
				
				for(int i=0;i<hotelak.size();i++) {
					if(comboHotelak.getSelectedItem().equals(hotelak.get(i))) {
						
						m.fitxeroaIdatzi(hotelak.get(i).toString(), prezioFinala);
						

					}
				}
				
				if (comboHotelak.getSelectedItem() == null){
					btnAurrera.setEnabled(false);
				}else{
					btnAurrera.setEnabled(true);
				}
			//	m.fitxeroaIdatzi("aeiou");
				m.FitxeroaIrakurri();
				dispose();
				MetodoakVista.laugarrenera(prezioFinala);
				
			}
		};
		btnAurrera.addActionListener(al);
		
		alAtzera = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MetodoakVista.bigarrenera();
			}
		};
<<<<<<< HEAD
		btnAtzera.addActionListener(alAtzera);
		btnAtzera.setBounds(0, 0, 89, 23);
		getContentPane().add(btnAtzera);
=======
		btnEzabatu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEzabatu.setBounds(427, 373, 91, 38);
		getContentPane().add(btnEzabatu);
		
		btnEzabatu.addActionListener(ezabatu);
		
		listBueltak.setModel(list);
		
		alBErosi = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				list.clear();
//				DoubleTextDiruTot = Double.parseDouble(textDiruTot.getText());
//				DoubleTextOrdainketa = Double.parseDouble(textOrdainketa.getText());
				bueltak = Metodoak.diruarenBueltak(textDiruTot.getText(), textOrdainketa.getText());
				
			for(int i=0;i<bueltak.length;i++) {
				list.addElement(bueltak[i]);
			}
			if (bueltak[0]=="0") {
				listMezua = "Ez daude bueltak";
				list.addElement(listMezua);
				lblErositakoa.setText("FALTA DEN DIRUA");
				btnAurrera.setEnabled(true);
			}
			if (bueltak[0]=="") {
				kenketaMetodo = Metodoak.kenketa(textDiruTot.getText(), textOrdainketa.getText());
				textOrdainketa.setText("");
				listMezua = "Dirua falta da";
				list.addElement(listMezua);
				textDiruTot.setText(kenketaMetodo);
				lblErositakoa.setText("FALTA DEN DIRUA");
				btnEzabatu.setEnabled(true);
			}
			if (bueltak[0]!="") {
				textDiruTot.setText("0");
				btnAurrera.setEnabled(true);
				btnEzabatu.setEnabed(false);
			}
			btnErosi.setEnabled(false);
			button0.setEnabed(false);
			button1.setEnabed(false);
			button2.setEnabed(false);
			button3.setEnabed(false);
			button4.setEnabed(false);
			button5.setEnabed(false);
			button6.setEnabed(false);
			button7.setEnabed(false);
			button8.setEnabed(false);
			button9.setEnabed(false);
			}
			
			};
		
		btnErosi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnErosi.addActionListener(alBErosi);		
		btnErosi.setBounds(329, 266, 91, 145);
		getContentPane().add(btnErosi);
		btnErosi.setEnabled(false);
>>>>>>> c19f2c56e67f4c84cd64cca537d528cee72e83f9
		
		
		txtInformazioa.setEditable(false);
		txtInformazioa.setBounds(265, 136, 315, 123);
		getContentPane().add(txtInformazioa);
		txtInformazioa.setColumns(10);
		
		
		al = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MetodoakVista.bueltatuLehena();
			}
		};



	}
}
>>>>>>> ef47450f8f7a977d3f9bea0c555524623664885a:Ethazi4_APP/src/VISTA/hotelHautatu.java
