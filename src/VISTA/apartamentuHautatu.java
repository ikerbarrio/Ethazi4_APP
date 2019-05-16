package VISTA;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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



public class apartamentuHautatu extends JFrame {
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
	private ActionListener alCheckin;
	private JPanel contentPanel;
	private JSpinner SpinnerLogelaKop = new JSpinner();
	private JComboBox comboHiria = new JComboBox();
	private ArrayList <String>apartamentuak = new ArrayList();
	private ArrayList hiriak = new ArrayList();
	private JLabel lblApartamentuak = new JLabel("APARTAMENTUA AUKERATU");
	private JLabel lblAukeratu = new JLabel("HIRIA AUKERATU");
	private JComboBox comboApartamentuak = new JComboBox();
	private JButton btnAurrera = new JButton("AURRERA");
	private JButton btnAtzera = new JButton("ATZERA");
	private JTextField txtInformazioa = new JTextField();
	private int gauKopurua;
	private double prezioFinala;
	private String hotela =" ";
	private JLabel lblLogelaKopurua = new JLabel("LOGELA KOPURUA");
	private JLabel lblGelaMota = new JLabel("Gela mota");
	private JRadioButton rdbtnBanakakoa = new JRadioButton("Banakakoa");
	private JRadioButton rdbtnBinakakoa = new JRadioButton("Bikoitza");
	private JRadioButton rdbtnUmeentzat = new JRadioButton("Umeentzat");
	private String gelaMota; //CREO VARIABLE PARA SABER EL TIPO DE GELA
	private JDateChooser hasieraDateChooser = new JDateChooser();	
	private int prezioLogela;
	private boolean ondo = true ;
	private int logela_kop;
	//private int id = Kontsultak.hotelIdLortu(hotela);
	private int cod_logela=0;
	private Date dateChooser;
	private String dateStr;
	private Date dateInit;
	private JDateChooser amaieraDateChooser = new JDateChooser();
	private final JButton btnCheckinaGorde = new JButton("Checkin-a gorde");
	private DateFormat dateFormat;
	private String strDateHasiera;
	private String strDateAmaiera;
	private String apartamentuIzena;
	private String mota;
	private int codLogela=0;
	private int logelaKop;
	private JSpinner SpinnerPisua = new JSpinner();
	private int pisua=0;
	private int prezioApartamentua=0;
	
	
	
	/**
	 * Frame-aren komponente guztiak
	 */
	public apartamentuHautatu() {
		
		setForeground(Color.DARK_GRAY);
		getContentPane().setForeground(Color.DARK_GRAY);
		this.setSize(478, 300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(550, 200, 635, 455);
		getContentPane().setLayout(null);
		
	
		comboHiria.setBounds(41, 61, 168, 31);
		getContentPane().add(comboHiria);
		hiriak = Metodoak.hiriakPantailaratu();
		comboHiria.addItem("Aukeratu");
		for(int n = 0; n < hiriak.size(); n++) {
			comboHiria.addItem(hiriak.get(n));
		}
		
		al = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboApartamentuak.removeAllItems();
				
				apartamentuak = Metodoak.apartamentuIzenaPantailaratu(comboHiria.getSelectedItem().toString());
				
				for(int n = 0; n < apartamentuak.size(); n++) {
					comboApartamentuak.addItem(apartamentuak.get(n));
				}
				
			}
		};
		comboHiria.addActionListener(al);
		
		lblApartamentuak.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblApartamentuak.setHorizontalAlignment(SwingConstants.CENTER);
		lblApartamentuak.setBounds(251, 30, 206, 28);

		comboApartamentuak.setBounds(265, 61, 168, 31);
		
		for(int n = 0; n < apartamentuak.size(); n++) {
			comboApartamentuak.addItem(apartamentuak.get(n));
		}
		al = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(comboApartamentuak.getItemCount()!=0) {		
					

							
					txtInformazioa.setText(Metodoak.informazioaPantailaratu(comboApartamentuak.getSelectedItem().toString(),"apartamentua"));
					
//					SpinnerLogelaKop.setModel(new SpinnerNumberModel(0,0, Kontsultak.logelaKopuruaLortu(comboHotelak.getSelectedItem().toString(), gelaMota),1));
					apartamentuIzena = comboApartamentuak.getSelectedItem().toString();
				
					
					
				}
				rdbtnUmeentzat.setSelected(false);
				rdbtnBanakakoa.setSelected(false);
				rdbtnBinakakoa.setSelected(false);
				rdbtnUmeentzat.setEnabled(true);
				rdbtnBanakakoa.setEnabled(true);
				rdbtnBinakakoa.setEnabled(true);
			}
			
		};
		comboApartamentuak.addActionListener(al);
		getContentPane().add(comboApartamentuak);
		

		getContentPane().add(lblApartamentuak);
		
		lblAukeratu.setHorizontalAlignment(SwingConstants.CENTER);
		lblAukeratu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAukeratu.setBounds(26, 22, 215, 41);
		getContentPane().add(lblAukeratu);
		
		
		
		btnAurrera.setBounds(530, 393, 89, 23);
		getContentPane().add(btnAurrera);
		al = new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {

				dateFormat = new SimpleDateFormat("dd/MM/yyyy");  
				//String strDateHasiera = dateFormat.format(hasieraDateChooser.getDate());
				//String strDateAmaiera = dateFormat.format(amaieraDateChooser.getDate());
				
				ondo = true;
				
			
					

					System.out.println(gauKopurua);
					
					/*if (rdbtnBanakakoa.isSelected() | rdbtnBinakakoa.isSelected() | rdbtnUmeentzat.isSelected()) {
						
					}else {
						JOptionPane.showMessageDialog(null, "Logela mota aukeratu");
						ondo = false;
					}*/
					System.out.println(prezioFinala);
					

								
					for(int i=0;i<apartamentuak.size();i++) {
						if(comboApartamentuak.getSelectedItem().equals(apartamentuak.get(i))) {
							
																							
						
						hotela = apartamentuak.get(i);
						}
					}
					
					
					try {			
						hasieraDateChooser.getDate().toString();
						amaieraDateChooser.getDate().toString();
						
				
						System.out.println(strDateHasiera);
						System.out.println(strDateAmaiera);
						
						
					
					
					}catch(Exception a) {
						JOptionPane.showMessageDialog(null, "Data aukeratu");
						ondo = false;
					}
					
					
					/*if((int)SpinnerLogelaKop.getValue()==0) {
						JOptionPane.showMessageDialog(null, "Ez duzu logelarik aukeratu");
						ondo = false;
					}*/
					//PARA QUE NO PETE ESTE IF TIENE QUE ESTAR AQUI ABAJO//
					if(ondo) {
						strDateHasiera = dateFormat.format(hasieraDateChooser.getDate());
						strDateAmaiera = dateFormat.format(amaieraDateChooser.getDate());
						System.out.println(strDateHasiera);
						if(strDateHasiera.equals(strDateAmaiera)) {
							JOptionPane.showMessageDialog(null, "Ezin duzu egun berdinean erreserbatu");
							ondo = false;
						}
						
					}
					if (!ondo) {
						hasieraDateChooser.setEnabled(true);
						amaieraDateChooser.setEnabled(false);
					}
					/////////////////////////////////////
				if(ondo) {
		
					dateFormat = new SimpleDateFormat("dd/MM/yyyy");  
					
					
					prezioApartamentua=Kontsultak.selectPrezioApartamentu(comboApartamentuak.getSelectedItem().toString());
					prezioFinala=prezioApartamentua* m.datenKenketa(strDateHasiera, strDateAmaiera); //marka
					
					logela_kop = (int) SpinnerLogelaKop.getValue();
					dispose();
					
					
					m.fitxeroaIdatzi(hotela, prezioFinala, gelaMota,strDateHasiera,m.datenKenketa(strDateHasiera, strDateHasiera));																					//0los id de papartamentuy y etxea
					m.datenKenketa(strDateHasiera, strDateAmaiera);
				
					//para el metodo de calcular el precio 
					if(rdbtnBanakakoa.isSelected()) {
						
						mota = "Banakakoa";
						codLogela=	Kontsultak.selectCodLogelaApartamentu(apartamentuIzena, mota);
						
					}else if(rdbtnBinakakoa.isSelected()) {
						
						mota = "Bikoitza";
					codLogela=	Kontsultak.selectCodLogelaApartamentu(apartamentuIzena, mota);
						
					}else if(rdbtnUmeentzat.isSelected()) {
						
						mota = "Umeentzat";
						codLogela=	Kontsultak.selectCodLogelaApartamentu(apartamentuIzena, mota);
					}
					
					String temporada = Metodoak.kalkulatuDenboraldia(strDateHasiera, strDateAmaiera);
					if (temporada.equals("alta")) {
						prezioFinala = (prezioLogela * m.datenKenketa(strDateHasiera, strDateAmaiera)
								* (int) SpinnerLogelaKop.getValue());
						prezioFinala = prezioFinala + 50;// marka
					} else if (temporada.equals("baja")) {
						prezioFinala = prezioLogela * m.datenKenketa(strDateHasiera, strDateAmaiera)
								* (int) SpinnerLogelaKop.getValue(); // marka
					}
					//prezioFinala = m.prezioKalk(SpinnerLogelaKop.getComponentCount(), mota); // cambiar el mota
					
					
					//prezioFinala = m.prezioKalk(logelaKop, mota);
					MetodoakVista.saihoaHastera(prezioFinala,hotela,gelaMota,logela_kop);
					Kontsultak.ReserbaDatuakGordeApartamentua(apartamentuIzena,0, prezioFinala, gelaMota, codLogela, strDateHasiera, strDateHasiera, logela_kop,0, Kontsultak.apartamentuIdLortu(comboApartamentuak.getSelectedItem().toString()),SpinnerPisua.getComponentCount() );
					pisua = (int)SpinnerPisua.getValue();
					System.out.println("PISUA: "+pisua);
					
					Kontsultak.ReserbaDatuakGordeApartamentua(apartamentuIzena,0, prezioFinala, gelaMota, codLogela, strDateHasiera, strDateAmaiera, logela_kop,0, Kontsultak.apartamentuIdLortu(comboApartamentuak.getSelectedItem().toString()),pisua);
					//marka
			
				}
				
				btnCheckinaGorde.setEnabled(true);
			}
		};
		
		btnAurrera.addActionListener(al);
		
		alAtzera = new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();
				MetodoakVista.hostatuaAukeratzera();

			}
		};
		btnAtzera.addActionListener(alAtzera);
		btnAtzera.setBounds(0, 0, 89, 23);
		getContentPane().add(btnAtzera);
		
		
		txtInformazioa.setEditable(false);
		txtInformazioa.setBounds(265, 103, 315, 123);
		getContentPane().add(txtInformazioa);
		txtInformazioa.setColumns(10);
		SpinnerLogelaKop.setModel(new SpinnerNumberModel(1, 1, 10, 1));
		SpinnerLogelaKop.setEnabled(false);
		
		
//		m.hotelLogelakKalkulatu(DB.Kontsultak.logelaKopuruaLortu((String) comboHotelak.getSelectedItem()), (String) comboHotelak.getSelectedItem())
//		SpinnerLogelaKop.setModel(new SpinnerNumberModel(0, 0, 10, 1));
		SpinnerLogelaKop.setBounds(41, 361, 153, 31);
		getContentPane().add(SpinnerLogelaKop);
		
		
		lblLogelaKopurua.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLogelaKopurua.setBounds(33, 315, 183, 36);
		getContentPane().add(lblLogelaKopurua);
		rdbtnBanakakoa.setEnabled(false);
		
		
		rdbtnBanakakoa.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnBanakakoa.setBounds(36, 157, 109, 23);
		getContentPane().add(rdbtnBanakakoa);
		rdbtnBinakakoa.setEnabled(false);
		
		rdbtnBinakakoa.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnBinakakoa.setBounds(31, 210, 103, 23);
		getContentPane().add(rdbtnBinakakoa);
		
		lblGelaMota.setHorizontalAlignment(SwingConstants.CENTER);
		lblGelaMota.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblGelaMota.setBounds(32, 119, 168, 31);
		getContentPane().add(lblGelaMota);
		
		
		rdbtnUmeentzat.setEnabled(false);
		rdbtnUmeentzat.setBounds(49, 261, 96, 23);
		getContentPane().add(rdbtnUmeentzat);
		
		
		Date dateInit = null;
		LocalDate minDate = LocalDate.now();
		Date hasieraDate = Date.from(minDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		
				
		btnCheckinaGorde.setBounds(265, 279, 141, 31);
		getContentPane().add(btnCheckinaGorde);
		hasieraDateChooser.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		hasieraDateChooser.setBounds(265, 237, 141, 31);
		getContentPane().add(hasieraDateChooser);
		((JTextField) hasieraDateChooser.getDateEditor()).setEditable(false);
		hasieraDateChooser.setSelectableDateRange(hasieraDate, null);
		

		amaieraDateChooser.setBounds(439, 237, 141, 31);
		((JTextField) amaieraDateChooser.getDateEditor()).setEditable(false); 
		getContentPane().add(amaieraDateChooser);
		amaieraDateChooser.setEnabled(false);
		SpinnerPisua.setModel(new SpinnerNumberModel(1, 1, 10, 1));
		
		
		SpinnerPisua.setBounds(291, 361, 142, 31);
		getContentPane().add(SpinnerPisua);
		
		JLabel lblPisua = new JLabel("PISUA");
		lblPisua.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblPisua.setBounds(291, 316, 142, 31);
		getContentPane().add(lblPisua);
		
		alCheckin = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ondo = true;
				try {
					hasieraDateChooser.getDate().toString();
					
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null, "Data aukeratu");
					ondo = false;
				}
				if(ondo) {
					amaieraDateChooser.setSelectableDateRange(hasieraDateChooser.getDate(), null);
					amaieraDateChooser.setEnabled(true);
					hasieraDateChooser.setEnabled(false);
					btnCheckinaGorde.setEnabled(false);
				}
			
			}
		};
		btnCheckinaGorde.addActionListener(alCheckin);
		
		
		alBanakakoa = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				rdbtnBanakakoa.setSelected(true);
				rdbtnBinakakoa.setSelected(false);
				rdbtnUmeentzat.setSelected(false);
				SpinnerLogelaKop.setEnabled(true);
				gelaMota=rdbtnBanakakoa.getText();					
				
				SpinnerLogelaKop.setModel(new SpinnerNumberModel(0,0, Kontsultak.logelaKopuruaLortuApartamentu(comboApartamentuak.getSelectedItem().toString(), gelaMota),1));

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
				
				SpinnerLogelaKop.setModel(new SpinnerNumberModel(0,0, Kontsultak.logelaKopuruaLortuApartamentu(comboApartamentuak.getSelectedItem().toString(), gelaMota),1));
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
				

			

				SpinnerLogelaKop.setModel(new SpinnerNumberModel(0,0, Kontsultak.logelaKopuruaLortuApartamentu(comboApartamentuak.getSelectedItem().toString(), gelaMota),1));

			}
		};
		rdbtnUmeentzat.addActionListener(alUmeentzat);
				
		
		
	
	}
}