package APP;

import java.util.ArrayList;

import VISTA.*;

public class MetodoakVista {
	public static void bueltatuLehena() {
		OngiEtorri OngiEtorri = new OngiEtorri();
		OngiEtorri.setVisible(true);
		OngiEtorri.setBounds(550, 200, 642, 467);
}

	public static void bigarrenera() {
		SaioaHasi SaioaHasi = new SaioaHasi();
		SaioaHasi.setVisible(true);
		SaioaHasi.setBounds(550, 200, 642, 467);
	}
	
	public static void hirugarrenera() {
		hotelHautatu hotelHautatu = new hotelHautatu();
		hotelHautatu.setVisible(true);
		hotelHautatu.setBounds(550, 200, 642, 467);
	}
	
	public static void laugarrenera(double prezioFinala) {
		Ordainketa Ordainketa = new Ordainketa(prezioFinala);
		Ordainketa.setVisible(true);
		Ordainketa.setBounds(550, 200, 642, 467);
	}
	
	public static void saioaSortu() {
		SaioaSortu SaioaSortu = new SaioaSortu();
		SaioaSortu.setVisible(true);
		SaioaSortu.setBounds(550, 200, 642, 467);
	}
	
}
