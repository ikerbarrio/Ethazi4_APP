

package VISTA;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

import com.toedter.calendar.JDateChooser;

import APP.Metodoak;
import APP.MetodoakVista;
import DB.Kontsultak;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.SpinnerModel;
import com.toedter.calendar.JDateChooser;



public class hotelHautatu extends JFrame {
	/**
	 * Frame-aren atributu eta komponente guztiak sortu 
	 */
	Metodoak m = new Metodoak();
	DB.Kontsultak k = new DB.Kontsultak ();
	private ActionListener al;
	private ActionListener alAtzera;
	private ActionListener alLogelak;
	private ActionListener alBanakakoa;
	private ActionListener alBinakakoa;
	private ActionListener alUmeentzat;
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
	private JRadioButton rdbtnUmeentzat = new JRadioButton("Umeentzat");
	private String gelaMota; //CREO VARIABLE PARA SABER EL TIPO DE GELA
	private JDateChooser dateChooser = new JDateChooser();	
	private JButton btnGorde = new JButton("GORDE");
	private int cod_logela;
	private boolean ondo = true ;
	private int kop;
	
	

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
		spinerGauKopurua.setBounds(26, 149, 168, 31);
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
					

							
					txtInformazioa.setText(Metodoak.hotelInformazioaPantailaratu(comboHotelak.getSelectedItem().toString()));
					
//					SpinnerLogelaKop.setModel(new SpinnerNumberModel(0,0, Kontsultak.logelaKopuruaLortu(comboHotelak.getSelectedItem().toString(), gelaMota),1));
					
					
					
					
				}
				rdbtnUmeentzat.setSelected(false);
				rdbtnBanakakoa.setSelected(false);
				rdbtnBinakakoa.setSelected(false);
				rdbtnUmeentzat.setEnabled(true);
				rdbtnBanakakoa.setEnabled(true);
				rdbtnBinakakoa.setEnabled(true);
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
			public void actionPerformed(ActionEvent e) {
				dispose();
				MetodoakVista.saihoaHastera(prezioFinala);
				
				//ESTA PUESTO EN EL BOTON DE GORDE 
	//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
				
//				gauKopurua=(int)spinerGauKopurua.getValue();
//
//				System.out.println(gauKopurua);
//				
//				if (rdbtnBanakakoa.isSelected()) {
//					prezioFinala=(20*gauKopurua);
//					
//				}else if (rdbtnBinakakoa.isSelected()) {
//					prezioFinala=(40*gauKopurua);
//				
//				}else if (rdbtnUmeentzat.isSelected()) {
//					prezioFinala=(10*gauKopurua);
//					
//				}else {
//					JOptionPane.showMessageDialog(null, "Logela mota aukeratu");
//					ondo = false;
//				}
//				System.out.println(prezioFinala);
//				
////				for(int i=0;i<hotelak.size();i++) {
////					if(comboHotelak.getSelectedItem().equals(hotelak.get(i))) {
////						
////					m.fitxeroaIdatzi(hotelak.get(i).toString(), prezioFinala);
////					hotela = hotelak.get(i);
////
////					}
////				}
				

				
//				
//				if(ondo) {
//					cod_logela = Metodoak.selectCod_logela(comboHotelak.getSelectedItem().toString());
//					Metodoak.logelaKopAldatu(cod_logela, gelaMota,(int) SpinnerLogelaKop.getValue());
//					m.FitxeroaIrakurri();
//					dispose();
//					MetodoakVista.saihoaHastera(prezioFinala);
//
//				}
				
				
				
//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
				
				
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
		txtInformazioa.setBounds(265, 103, 315, 123);
		getContentPane().add(txtInformazioa);
		txtInformazioa.setColumns(10);
		SpinnerLogelaKop.setEnabled(false);
//		SpinnerLogelaKop.setModel(new SpinnerNumberModel(new Integer(0), null, null, new Integer(1)));
		
		
//		m.hotelLogelakKalkulatu(DB.Kontsultak.logelaKopuruaLortu((String) comboHotelak.getSelectedItem()), (String) comboHotelak.getSelectedItem())
//		SpinnerLogelaKop.setModel(new SpinnerNumberModel(0, 0, 10, 1));
		SpinnerLogelaKop.setBounds(41, 361, 153, 31);
		getContentPane().add(SpinnerLogelaKop);
		
		
		lblLogelaKopurua.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLogelaKopurua.setBounds(33, 315, 183, 36);
		getContentPane().add(lblLogelaKopurua);
		rdbtnBanakakoa.setEnabled(false);
		
		
		rdbtnBanakakoa.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnBanakakoa.setBounds(26, 233, 109, 23);
		getContentPane().add(rdbtnBanakakoa);
		rdbtnBinakakoa.setEnabled(false);
		
		rdbtnBinakakoa.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnBinakakoa.setBounds(139, 233, 89, 23);
		getContentPane().add(rdbtnBinakakoa);
		
		lblGelaMota.setHorizontalAlignment(SwingConstants.CENTER);
		lblGelaMota.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblGelaMota.setBounds(36, 195, 168, 31);
		getContentPane().add(lblGelaMota);
		
		
		rdbtnUmeentzat.setEnabled(false);
		rdbtnUmeentzat.setBounds(82, 265, 103, 23);
		getContentPane().add(rdbtnUmeentzat);
		
		//EL BOTON DE GUARDADO

		btnGorde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				

			
			//AL DARLE AL BOTON DE GORDE SE GUARDAN LOS DATOS EN EL FITXERO FALTARIA AÑADIR LOS DATOS QUE QUERAMOS GUARDAR
				
				
				gauKopurua=(int)spinerGauKopurua.getValue();

				System.out.println(gauKopurua);
				
				if (rdbtnBanakakoa.isSelected()) {
					prezioFinala=(20*gauKopurua);
					
				}else if (rdbtnBinakakoa.isSelected()) {
					prezioFinala=(40*gauKopurua);
				
				}else if (rdbtnUmeentzat.isSelected()) {
					prezioFinala=(10*gauKopurua);
					
				}else {
					JOptionPane.showMessageDialog(null, "Logela mota aukeratu");
					ondo = false;
				}
				System.out.println(prezioFinala);
				
		
				for(int i=0;i<hotelak.size();i++) {
					if(comboHotelak.getSelectedItem().equals(hotelak.get(i))) {
						
																						
					m.fitxeroaIdatzi(hotelak.get(i).toString(), prezioFinala, gelaMota); 
					hotela = hotelak.get(i);
					}
				}
				
				//HACEMOS LA INSERT DE LAS HABITACIONES
				if(ondo) {
					System.out.println(SpinnerLogelaKop.getValue());
					cod_logela = Metodoak.selectCod_logela(comboHotelak.getSelectedItem().toString(), gelaMota);
					Metodoak.logelaKopAldatu(cod_logela, gelaMota,(int) SpinnerLogelaKop.getValue());
				m.FitxeroaIrakurri();


				}
				try {
				Date dateInit = dateChooser.getDate();
				String dateStr = DateFormat.getInstance().format(dateInit);
				System.out.println(dateStr);
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null, "Data aukeratu");
				}
			}
		});
		
		
		btnGorde.setBounds(275, 370, 97, 25);
		getContentPane().add(btnGorde);
		
		LocalDate minDate = LocalDate.now();
		Date hasieraDate = Date.from(minDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		dateChooser.setBounds(344, 293, 141, 31);
		getContentPane().add(dateChooser);
		
		((JTextField) dateChooser.getDateEditor()).setEditable(false);  
		dateChooser.setSelectableDateRange(hasieraDate, null);
		
		
		alBanakakoa = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				rdbtnBanakakoa.setSelected(true);
				rdbtnBinakakoa.setSelected(false);
				rdbtnUmeentzat.setSelected(false);
				SpinnerLogelaKop.setEnabled(true);
				gelaMota=rdbtnBanakakoa.getText();
				
				SpinnerLogelaKop.setModel(new SpinnerNumberModel(0,0, Kontsultak.logelaKopuruaLortu(comboHotelak.getSelectedItem().toString(), gelaMota),1));

			}
		};
		rdbtnBanakakoa.addActionListener(alBanakakoa);
		
		alBinakakoa = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				rdbtnBinakakoa.setSelected(true);
				rdbtnBanakakoa.setSelected(false);
				rdbtnUmeentzat.setSelected(false);
				SpinnerLogelaKop.setEnabled(true);
				gelaMota=rdbtnBinakakoa.getText();
				
				SpinnerLogelaKop.setModel(new SpinnerNumberModel(0,0, Kontsultak.logelaKopuruaLortu(comboHotelak.getSelectedItem().toString(), gelaMota),1));
			}
		};
		rdbtnBinakakoa.addActionListener(alBinakakoa);
		
		alUmeentzat = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				rdbtnUmeentzat.setSelected(true);
				rdbtnBinakakoa.setSelected(false);
				rdbtnBanakakoa.setSelected(false);
				SpinnerLogelaKop.setEnabled(true);
				gelaMota=rdbtnUmeentzat.getText();
				
				SpinnerLogelaKop.setModel(new SpinnerNumberModel(0,0, Kontsultak.logelaKopuruaLortu(comboHotelak.getSelectedItem().toString(), gelaMota),1));
			}
		};
		rdbtnUmeentzat.addActionListener(alUmeentzat);
				
		
		
	}
}

