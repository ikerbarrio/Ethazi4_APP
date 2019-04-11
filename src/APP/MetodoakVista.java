package APP;

import VISTA.LehioaAzkena;
import VISTA.OngiEtorri;
import VISTA.Ordainketa;
import VISTA.SaioaHasi;
import VISTA.SaioaSortu;
import VISTA.hotelHautatu;

public class MetodoakVista {
	public static void bueltatuLehena() {
		OngiEtorri ongiEtorri = new OngiEtorri();
		ongiEtorri.setVisible(true);
		ongiEtorri.setBounds(550, 200, 642, 467);
}

	public static void bigarrenera() {
		SaioaHasi saioaHasi = new SaioaHasi();
		saioaHasi.setVisible(true);
		saioaHasi.setBounds(550, 200, 642, 467);
	}
	
	public static void hirugarrenera() {
		hotelHautatu hotelHautatu = new hotelHautatu();
		hotelHautatu.setVisible(true);
		hotelHautatu.setBounds(550, 200, 642, 467);
	}
	
	public static void laugarrenera(double prezioFinala) {
		Ordainketa ordainketa = new Ordainketa(prezioFinala);
		ordainketa.setVisible(true);
		ordainketa.setBounds(550, 200, 642, 467);
	}
	
	public static void azkenera() {
		LehioaAzkena azkena = new LehioaAzkena();
		azkena.setVisible(true);
		azkena.setBounds(550, 200, 642, 467);
	}
	
	public static void saioaSortu() {
		SaioaSortu SaioaSortu = new SaioaSortu();
		SaioaSortu.setVisible(true);
		SaioaSortu.setBounds(550, 200, 642, 467);
	}
}