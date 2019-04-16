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
import javax.swing.JRadioButton;



public class hotelHautatu extends JFrame {
	/**
	 * Frame-aren atributu eta komponente guztiak sortu 
	 */
	Metodoak m = new Metodoak();
	private ActionListener al;
	private ActionListener alAtzera;
	private ActionListener alLogelak;
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
	private int logelaKopurua =  m.hotelLogelakKalkulatu(DB.Kontsultak.logelaKopuruaLortu((String) comboHotelak.getSelectedItem()), (String) comboHotelak.getSelectedItem());
	private String hotela =" ";
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
		
		spinerGauKopurua.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinerGauKopurua.setBounds(26, 163, 168, 31);
		getContentPane().add(spinerGauKopurua);
		
		
		lblGauKopurua.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblGauKopurua.setHorizontalAlignment(SwingConstants.CENTER);
		lblGauKopurua.setBounds(26, 107, 168, 50);
		getContentPane().add(lblGauKopurua);
		
		comboHiria.setBounds(412, 74, 168, 31);
		getContentPane().add(comboHiria);
		hiriak = Metodoak.hiriakPantailaratu();
		
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
			public void actionPerformed(ActionEvent e) {
				gauKopurua=(int)spinerGauKopurua.getValue();
				System.out.println(gauKopurua);
				prezioFinala=20*gauKopurua;
				System.out.println(prezioFinala);
				
				for(int i=0;i<hotelak.size();i++) {
					if(comboHotelak.getSelectedItem().equals(hotelak.get(i))) {
						
						m.fitxeroaIdatzi(hotelak.get(i).toString(), prezioFinala);
						hotela = hotelak.get(i);

					}
				}
				
				if (comboHotelak.getSelectedItem() == null){
					btnAurrera.setEnabled(false);
				}else{
					btnAurrera.setEnabled(true);
				}
		
				m.FitxeroaIrakurri();
				dispose();
				MetodoakVista.saihoaHastera(prezioFinala);
				m.hotelLogelakKalkulatu((int) SpinnerLogelaKop.getValue(), hotela );
				
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
		
//		m.hotelLogelakKalkulatu(DB.Kontsultak.logelaKopuruaLortu((String) comboHotelak.getSelectedItem()), (String) comboHotelak.getSelectedItem())
//		SpinnerLogelaKop.setModel(new SpinnerNumberModel(0, 0, 10, 1));
		SpinnerLogelaKop.setBounds(32, 252, 153, 31);
		getContentPane().add(SpinnerLogelaKop);
		
		JLabel lblLogelaKopurua = new JLabel("LOGELA KOPURUA");
		lblLogelaKopurua.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLogelaKopurua.setBounds(36, 205, 196, 36);
		getContentPane().add(lblLogelaKopurua);
		
		JRadioButton rdbtnBanakakoa = new JRadioButton("Banakakoa");
		rdbtnBanakakoa.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnBanakakoa.setBounds(26, 334, 109, 23);
		getContentPane().add(rdbtnBanakakoa);
		
		JRadioButton rdbtnBinakakoa = new JRadioButton("Binakakoa");
		rdbtnBinakakoa.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnBinakakoa.setBounds(137, 334, 109, 23);
		getContentPane().add(rdbtnBinakakoa);
		
		JRadioButton rdbtnSuite = new JRadioButton("Suite");
		rdbtnSuite.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnSuite.setBounds(248, 334, 109, 23);
		getContentPane().add(rdbtnSuite);
		
		JLabel lblGelaMota = new JLabel("Gela mota");
		lblGelaMota.setHorizontalAlignment(SwingConstants.CENTER);
		lblGelaMota.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblGelaMota.setBounds(26, 296, 168, 31);
		getContentPane().add(lblGelaMota);
				
		
		al = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MetodoakVista.bueltatuLehena();
			}
		};
	}
}
