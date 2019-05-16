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
import javax.swing.JFormattedTextField;
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
import javax.swing.JFormattedTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class hotelHautatu extends JFrame {
	/**
	 * Frame-aren atributu eta komponente guztiak sortu
	 */
	Metodoak m = new Metodoak();
	DB.Kontsultak k = new DB.Kontsultak();
	private ActionListener al;
	private ActionListener alAtzera;
	private ActionListener alLogelak;
	private ActionListener alBanakakoa;
	private ActionListener alBinakakoa;
	private ActionListener alUmeentzat;
	private ActionListener alCheckin;
	private JPanel contentPanel;

	private JSpinner SpinnerLogelaKop = new JSpinner();

	// private JLabel lblGauKopurua = new JLabel("GAU KOPURUA");
	private JComboBox comboHiria = new JComboBox();
	private ArrayList<String> hotelak = new ArrayList();
	private ArrayList hiriak = new ArrayList();
	private JLabel lblHotelak = new JLabel("HOTELA AUKERATU");
	private JLabel lblAukeratu = new JLabel("HIRIA AUKERATU");
	private JComboBox comboHotelak = new JComboBox();
	private JButton btnAurrera = new JButton("AURRERA");
	private JButton btnAtzera = new JButton("ATZERA");
	private JTextField txtInformazioa = new JTextField();
	private int gauKopurua;
	private double prezioFinala;
	private String hotela = " ";
	private JLabel lblLogelaKopurua = new JLabel("LOGELA KOPURUA");
	private JLabel lblGelaMota = new JLabel("Gela mota");
	private JRadioButton rdbtnBanakakoa = new JRadioButton("Banakakoa");
	private JRadioButton rdbtnBinakakoa = new JRadioButton("Bikoitza");
	private JRadioButton rdbtnUmeentzat = new JRadioButton("Umeentzat");
	private String gelaMota; // CREO VARIABLE PARA SABER EL TIPO DE GELA
	private JDateChooser hasieraDateChooser = new JDateChooser();
	private int prezioLogela;
	private boolean ondo = true;
	private int logela_kop;
	// private int id = Kontsultak.hotelIdLortu(hotela);
	private int cod_logela = 0;
	private Date dateChooser;
	private String dateStr;
	private Date dateInit;
	private JDateChooser amaieraDateChooser = new JDateChooser();
	private final JButton btnCheckinaGorde = new JButton("Checkin-a gorde");
	private DateFormat dateFormat;
	private String strDateHasiera;
	private String strDateAmaiera;

	/**
	 * Frame-aren komponente guztiak
	 */
	public hotelHautatu() {
		getContentPane().setEnabled(false);

		setForeground(Color.DARK_GRAY);
		getContentPane().setForeground(Color.DARK_GRAY);
		this.setSize(478, 300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(550, 200, 635, 455);

		getContentPane().setLayout(null);

//		lblGauKopurua.setFont(new Font("Tahoma", Font.PLAIN, 20));
//		lblGauKopurua.setHorizontalAlignment(SwingConstants.CENTER);
//		lblGauKopurua.setBounds(26, 107, 168, 50);
//		getContentPane().add(lblGauKopurua);
//		
		comboHiria.setBounds(35, 65, 168, 31);
		getContentPane().add(comboHiria);

		hiriak = Metodoak.hiriakPantailaratu();
		comboHiria.addItem("Aukeratu");
		for (int n = 0; n < hiriak.size(); n++) {
			comboHiria.addItem(hiriak.get(n));
		}

		al = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboHotelak.removeAllItems();

				hotelak = Metodoak.hotelIzenaPantailaratu(comboHiria.getSelectedItem().toString());

				for (int n = 0; n < hotelak.size(); n++) {
					comboHotelak.addItem(hotelak.get(n));
				}

			}
		};
		comboHiria.addActionListener(al);
		lblHotelak.setBounds(262, 32, 190, 28);

		lblHotelak.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHotelak.setHorizontalAlignment(SwingConstants.CENTER);

		comboHotelak.setBounds(32, 90, 168, 31);

		for (int n = 0; n < hotelak.size(); n++) {
			comboHotelak.addItem(hotelak.get(n));
		}
		al = new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (comboHotelak.getItemCount() != 0) {

					txtInformazioa.setText(Metodoak.informazioaPantailaratu(comboHotelak.getSelectedItem().toString(),"hotelak"));

//					SpinnerLogelaKop.setModel(new SpinnerNumberModel(0,0, Kontsultak.logelaKopuruaLortu(comboHotelak.getSelectedItem().toString(), gelaMota),1));

				}
				rdbtnUmeentzat.setSelected(false);
				rdbtnBanakakoa.setSelected(false);
				rdbtnBinakakoa.setSelected(false);
				rdbtnUmeentzat.setEnabled(true);
				rdbtnBanakakoa.setEnabled(true);
				rdbtnBinakakoa.setEnabled(true);
			}
		};
		comboHotelak.setBounds(270, 65, 168, 31);
		comboHotelak.addActionListener(al);
		lblAukeratu.setBounds(10, 26, 215, 41);

		lblAukeratu.setHorizontalAlignment(SwingConstants.CENTER);
		lblAukeratu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		al = new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {

				dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			
				// gauKopurua=(int)spinerGauKopurua.getValue();

				ondo = true;

				System.out.println(gauKopurua);

				if (rdbtnBanakakoa.isSelected() | rdbtnBinakakoa.isSelected() | rdbtnUmeentzat.isSelected()) {

				} else {
					JOptionPane.showMessageDialog(null, "Logela mota aukeratu");
					ondo = false;
				}
				System.out.println(prezioFinala);

				for (int i = 0; i < hotelak.size(); i++) {
					if (comboHotelak.getSelectedItem().equals(hotelak.get(i))) {

						hotela = hotelak.get(i);
					}
				}

				try {
					hasieraDateChooser.getDate().toString();
					amaieraDateChooser.getDate().toString();

					System.out.println(strDateHasiera);
					System.out.println(strDateAmaiera);

				} catch (Exception a) {
					JOptionPane.showMessageDialog(null, "Data aukeratu");
					ondo = false;
				}

				if ((int) SpinnerLogelaKop.getValue() == 0) {
					JOptionPane.showMessageDialog(null, "Ez duzu logelarik aukeratu");
					ondo = false;
				}
				// PARA QUE NO PETE ESTE IF TIENE QUE ESTAR AQUI ABAJO//
				if (ondo) {
					strDateHasiera = dateFormat.format(hasieraDateChooser.getDate());
					strDateAmaiera = dateFormat.format(amaieraDateChooser.getDate());
					System.out.println(strDateHasiera);
					if (strDateHasiera.equals(strDateAmaiera)) {
						JOptionPane.showMessageDialog(null, "Ezin duzu egun berdinean erreserbatu");
						ondo = false;
					}
					if (!m.reserbaFechaKalkulatuHotel(strDateHasiera, strDateAmaiera, (int) SpinnerLogelaKop.getValue(),
							hotela, gelaMota)) {
						JOptionPane.showMessageDialog(null, "Reserba data okupatuta");
						ondo = false;
						amaieraDateChooser.setEnabled(false);
						amaieraDateChooser.setDate(null);
					}
				}
				if (!ondo) {
					hasieraDateChooser.setEnabled(true);
					amaieraDateChooser.setEnabled(false);
				}
				/////////////////////////////////////

				if (ondo) {
					dateFormat = new SimpleDateFormat("dd/MM/yyyy");

					cod_logela = Kontsultak.selectCod_logelaHotel(hotela, gelaMota);
					prezioLogela = Kontsultak.selectPrezioa(cod_logela);

					prezioFinala = prezioLogela * m.datenKenketa(strDateHasiera, strDateAmaiera)
							* (int) SpinnerLogelaKop.getValue(); // marka

					logela_kop = (int) SpinnerLogelaKop.getValue();
					dispose();

					String temporada = Metodoak.kalkulatuDenboraldia(strDateHasiera, strDateAmaiera);
					if (temporada.equals("alta")) {
						prezioFinala = (prezioLogela * m.datenKenketa(strDateHasiera, strDateAmaiera)
								* (int) SpinnerLogelaKop.getValue());
						prezioFinala = prezioFinala + 50;// marka
					} else if (temporada.equals("baja")) {
						prezioFinala = prezioLogela * m.datenKenketa(strDateHasiera, strDateAmaiera)
								* (int) SpinnerLogelaKop.getValue(); // marka
					}

					MetodoakVista.terminoEtaCondizioetara(prezioFinala, hotela, gelaMota, logela_kop);

					m.fitxeroaIdatzi(hotela, prezioFinala, gelaMota, strDateHasiera, m.datenKenketa(strDateHasiera, strDateHasiera));
					m.datenKenketa(strDateHasiera, strDateAmaiera);
					k.ReserbaDatuakGorde(hotela, Kontsultak.hotelIdLortu(hotela), prezioFinala, gelaMota,
							Kontsultak.selectCod_logelaHotel(hotela, gelaMota), strDateHasiera, strDateAmaiera,
							(int) SpinnerLogelaKop.getValue(), 0, 0);

				}

				btnCheckinaGorde.setEnabled(true);
			}
		};
		btnAurrera.setBounds(530, 393, 89, 23);

		btnAurrera.addActionListener(al);

		alAtzera = new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();
				MetodoakVista.hostatuaAukeratzera();

			}
		};
		btnAtzera.setBounds(0, 0, 89, 23);
		btnAtzera.addActionListener(alAtzera);
		txtInformazioa.setBounds(265, 103, 315, 123);

		txtInformazioa.setEditable(false);

		txtInformazioa.setColumns(10);
		SpinnerLogelaKop.setBounds(32, 279, 153, 31);
		SpinnerLogelaKop.setModel(new SpinnerNumberModel(1, null, 10, 1));
		lblLogelaKopurua.setBounds(32, 312, 183, 36);

		txtInformazioa.setBounds(265, 103, 315, 123);
		getContentPane().add(txtInformazioa);
		txtInformazioa.setColumns(10);
		SpinnerLogelaKop.setEnabled(false);

//		m.hotelLogelakKalkulatu(DB.Kontsultak.logelaKopuruaLortu((String) comboHotelak.getSelectedItem()), (String) comboHotelak.getSelectedItem())
//		SpinnerLogelaKop.setModel(new SpinnerNumberModel(0, 0, 10, 1));
		SpinnerLogelaKop.setBounds(41, 361, 153, 31);
		getContentPane().add(SpinnerLogelaKop);
//		((JSpinner.DefaultEditor)SpinnerLogelaKop.getEditor()).getTextField().setEditable(false);t

		lblLogelaKopurua.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnBanakakoa.setEnabled(false);

		rdbtnBanakakoa.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnBanakakoa.setBounds(36, 157, 109, 23);
		getContentPane().add(rdbtnBanakakoa);

		rdbtnBinakakoa.setEnabled(false);

		rdbtnBinakakoa.setHorizontalAlignment(SwingConstants.CENTER);

		rdbtnBinakakoa.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnBinakakoa.setBounds(36, 210, 103, 23);
		getContentPane().add(rdbtnBinakakoa);

		lblGelaMota.setHorizontalAlignment(SwingConstants.CENTER);

		lblGelaMota.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblGelaMota.setBounds(32, 119, 168, 31);
		getContentPane().add(lblGelaMota);

		rdbtnUmeentzat.setEnabled(false);

		rdbtnUmeentzat.setBounds(36, 261, 103, 23);
		getContentPane().add(rdbtnUmeentzat);

		Date dateInit = null;
		LocalDate minDate = LocalDate.now();
		Date hasieraDate = Date.from(minDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		((JTextField) hasieraDateChooser.getDateEditor()).setEditable(false);
		hasieraDateChooser.setBounds(265, 237, 141, 31);
		hasieraDateChooser.setSelectableDateRange(hasieraDate, null);
		((JTextField) amaieraDateChooser.getDateEditor()).setEditable(false);
		amaieraDateChooser.setBounds(439, 237, 141, 31);
		amaieraDateChooser.setEnabled(false);
		getContentPane().setLayout(null);
		getContentPane().add(comboHiria);
		getContentPane().add(comboHotelak);
		getContentPane().add(lblHotelak);
		getContentPane().add(lblAukeratu);
		getContentPane().add(btnAurrera);
		getContentPane().add(btnAtzera);
		getContentPane().add(txtInformazioa);
		getContentPane().add(SpinnerLogelaKop);
		getContentPane().add(lblLogelaKopurua);
		getContentPane().add(rdbtnBanakakoa);
		getContentPane().add(rdbtnBinakakoa);
		getContentPane().add(lblGelaMota);
		getContentPane().add(rdbtnUmeentzat);
		btnCheckinaGorde.setBounds(265, 279, 141, 31);
		getContentPane().add(btnCheckinaGorde);
		getContentPane().add(hasieraDateChooser);
		getContentPane().add(amaieraDateChooser);

		hasieraDateChooser.setEnabled(true);
		amaieraDateChooser.setEnabled(false);
		btnCheckinaGorde.setEnabled(true);

		alCheckin = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ondo = true;
				try {
					hasieraDateChooser.getDate().toString();

				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Data aukeratu");
					ondo = false;
				}
				if (ondo) {
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

				gelaMota = rdbtnBanakakoa.getText();

				SpinnerLogelaKop.setModel(new SpinnerNumberModel(0, 0,
						Kontsultak.logelaKopuruaLortu(comboHotelak.getSelectedItem().toString(), gelaMota), 1));

			}
		};
		rdbtnBanakakoa.addActionListener(alBanakakoa);

		alBinakakoa = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				rdbtnBinakakoa.setSelected(true);
				rdbtnBanakakoa.setSelected(false);
				rdbtnUmeentzat.setSelected(false);
				SpinnerLogelaKop.setEnabled(true);
				gelaMota = rdbtnBinakakoa.getText();

				SpinnerLogelaKop.setModel(new SpinnerNumberModel(0, 0,
						Kontsultak.logelaKopuruaLortu(comboHotelak.getSelectedItem().toString(), gelaMota), 1));
			}
		};
		rdbtnBinakakoa.addActionListener(alBinakakoa);

		alUmeentzat = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				rdbtnUmeentzat.setSelected(true);
				rdbtnBinakakoa.setSelected(false);
				rdbtnBanakakoa.setSelected(false);
				SpinnerLogelaKop.setEnabled(true);
				gelaMota = rdbtnUmeentzat.getText();

				SpinnerLogelaKop.setModel(new SpinnerNumberModel(0, 0,
						Kontsultak.logelaKopuruaLortu(comboHotelak.getSelectedItem().toString(), gelaMota), 1));
			}
		};
		rdbtnUmeentzat.addActionListener(alUmeentzat);

	}

}