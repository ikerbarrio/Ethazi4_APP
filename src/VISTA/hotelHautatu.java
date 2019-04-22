

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
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.SpinnerModel;



public class hotelHautatu extends JFrame {
	/**
	 * Frame-aren atributu eta komponente guztiak sortu 
	 */
	Metodoak m = new Metodoak();
	private ActionListener al;
	private ActionListener alAtzera;
	private ActionListener alLogelak;
	private ActionListener alBanakakoa;
	private ActionListener alBinakakoa;
	private JPanel contentPanel;
	private JSpinner spinerGauKopurua = new JSpinner();
	private JSpinner SpinnerLogelaKop = new JSpinner();
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
	private int logelaKopurua;
	private String hotela =" ";
	private JLabel lblLogelaKopurua = new JLabel("LOGELA KOPURUA");
	private JLabel lblGelaMota = new JLabel("Gela mota");
	private JRadioButton rdbtnBanakakoa = new JRadioButton("Banakakoa");

	private JRadioButton rdbtnBinakakoa = new JRadioButton("Bikoitza");
	private String gelaMota; //CREO VARIABLE PARA SABER EL TIPO DE GELA


	private boolean ondo = true ;
	
	

	/**
	 * Frame-aren komponente guztiak
	 */
	public hotelHautatu() {
		
		setForeground(Color.DARK_GRAY);
		getContentPane().setForeground(Color.DARK_GRAY);
		this.setSize(478, 300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(550, 200, 635, 455);
		getContentPane().setLayout(null);
		
		spinerGauKopurua.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), new Integer(10), new Integer(1)));
		spinerGauKopurua.setBounds(26, 163, 168, 31);
		getContentPane().add(spinerGauKopurua);
		
		
		lblGauKopurua.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblGauKopurua.setHorizontalAlignment(SwingConstants.CENTER);
		lblGauKopurua.setBounds(26, 107, 168, 50);
		getContentPane().add(lblGauKopurua);
		
		comboHiria.setBounds(412, 74, 168, 31);
		getContentPane().add(comboHiria);
		hiriak = Metodoak.hiriakPantailaratu();
		comboHiria.addItem("Aukeratu");
		for(int n = 0; n < hiriak.size(); n++) {
			comboHiria.addItem(hiriak.get(n));
		}
		
		al = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboHotelak.removeAllItems();
				
				hotelak=Metodoak.hotelIzenaPantailaratu(comboHiria.getSelectedItem().toString());
				
				for(int n = 0; n < hotelak.size(); n++) {
					comboHotelak.addItem(hotelak.get(n));
				}
				
			}
		};
		comboHiria.addActionListener(al);
		
		lblHotelak.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHotelak.setHorizontalAlignment(SwingConstants.CENTER);
		lblHotelak.setBounds(26, 28, 190, 28);

		comboHotelak.setBounds(32, 65, 168, 31);
		
		for(int n = 0; n < hotelak.size(); n++) {
			comboHotelak.addItem(hotelak.get(n));
		}
		al = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(comboHotelak.getItemCount()!=0) {		
					
					
					//AQUI PASAMOS UN VALOR NULO GELAMOTA QUE AUN  NO ESTA ASIGNADO POR QUE EL VALOR SE LO DAMOS MAS ABAJO EN EL BOTON AURRERA
							
					txtInformazioa.setText(Metodoak.hotelInformazioaPantailaratu(comboHotelak.getSelectedItem().toString()));
					
					SpinnerLogelaKop.setModel(new SpinnerNumberModel(0,0, Kontsultak.logelaKopuruaLortu(comboHotelak.getSelectedItem().toString(), gelaMota),1));
					
					logelaKopurua = Kontsultak.logelaKopuruaLortu(comboHotelak.getSelectedItem().toString(), gelaMota);
					
					
				}
				
			btnAurrera.setEnabled(true);
			}
		};
		comboHotelak.addActionListener(al);
		getContentPane().add(comboHotelak);
		

		getContentPane().add(lblHotelak);
		
		lblAukeratu.setHorizontalAlignment(SwingConstants.CENTER);
		lblAukeratu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAukeratu.setBounds(226, 22, 215, 41);
		getContentPane().add(lblAukeratu);
		
		comboHiria.setBounds(265, 65, 168, 31);
		getContentPane().add(comboHiria);
		
		
		btnAurrera.setBounds(530, 393, 89, 23);
		getContentPane().add(btnAurrera);
		al = new ActionListener() {
			
			/*
			 * LE ESTAMOS DANDO EL VALOR AL TIPO DE GELA TARDE EN ELÑ BOTON 
			DE AURRERA CUANDO EN REALIDAD SE TE TIENE QUE DAR ANTES YA QUE DEPENDIENDO DEL BOTON (DEL TIPO DE LOGELA)
			TIENE QUE SALIR UN HOTEL U OTRO
			
			*/
			
			
			public void actionPerformed(ActionEvent e) {
				gauKopurua=(int)spinerGauKopurua.getValue();

				System.out.println(gauKopurua);
				
				if (rdbtnBanakakoa.isSelected()) {
					gelaMota= "Banakakoa"; //LE ASIGNO EL VALOR SEGUN EL BOTON SELECCIONADO
					prezioFinala=(20*gauKopurua);
					
				}else if (rdbtnBinakakoa.isSelected()) {
					gelaMota = "Bikoitza"; //LE ASIGNO EL VALOR SEGUN EL BOTON SELECCIONADO

				System.out.println(gauKopurua);
			
				}else {
					JOptionPane.showMessageDialog(null, "Logela mota aukeratu");
					ondo = false;
				}
				System.out.println(prezioFinala);
				
				for(int i=0;i<hotelak.size();i++) {
					if(comboHotelak.getSelectedItem().equals(hotelak.get(i))) {
						
						m.fitxeroaIdatzi(hotelak.get(i).toString(), prezioFinala);
						hotela = hotelak.get(i);

					}
				}
				
//				if (comboHotelak.getSelectedItem() == null){
//					btnAurrera.setEnabled(false);
//				}else{
//					btnAurrera.setEnabled(true);
//				}
				
				if(ondo) {
					m.FitxeroaIrakurri();
					dispose();
					MetodoakVista.saihoaHastera(prezioFinala);
					m.hotelLogelakKalkulatu((int) SpinnerLogelaKop.getValue(), hotela, gelaMota );
				}
				
				
				
			}
		};
		btnAurrera.addActionListener(al);
		btnAurrera.setEnabled(false);
		
		alAtzera = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MetodoakVista.bueltatuLehena();
			}
		};
		btnAtzera.addActionListener(alAtzera);
		btnAtzera.setBounds(0, 0, 89, 23);
		getContentPane().add(btnAtzera);
		
		
		txtInformazioa.setEditable(false);
		txtInformazioa.setBounds(265, 136, 315, 123);
		getContentPane().add(txtInformazioa);
		txtInformazioa.setColumns(10);
//		SpinnerLogelaKop.setModel(new SpinnerNumberModel(new Integer(0), null, null, new Integer(1)));
		
		
//		m.hotelLogelakKalkulatu(DB.Kontsultak.logelaKopuruaLortu((String) comboHotelak.getSelectedItem()), (String) comboHotelak.getSelectedItem())
//		SpinnerLogelaKop.setModel(new SpinnerNumberModel(0, 0, 10, 1));
		SpinnerLogelaKop.setBounds(32, 252, 153, 31);
		getContentPane().add(SpinnerLogelaKop);
		
		
		lblLogelaKopurua.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLogelaKopurua.setBounds(36, 205, 196, 36);
		getContentPane().add(lblLogelaKopurua);
		
		
		rdbtnBanakakoa.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnBanakakoa.setBounds(26, 334, 109, 23);
		getContentPane().add(rdbtnBanakakoa);
		
		rdbtnBinakakoa.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnBinakakoa.setBounds(137, 334, 109, 23);
		getContentPane().add(rdbtnBinakakoa);
		
		lblGelaMota.setHorizontalAlignment(SwingConstants.CENTER);
		lblGelaMota.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblGelaMota.setBounds(26, 296, 168, 31);
		getContentPane().add(lblGelaMota);
		
		alBanakakoa = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				rdbtnBanakakoa.setSelected(true);
				rdbtnBinakakoa.setSelected(false);
				

			}
		};
		rdbtnBanakakoa.addActionListener(alBanakakoa);
		
		alBinakakoa = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				rdbtnBinakakoa.setSelected(true);
				rdbtnBanakakoa.setSelected(false);

			}
		};
		rdbtnBinakakoa.addActionListener(alBinakakoa);
				
		
		
	}
}

