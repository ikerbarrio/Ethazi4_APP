package APP;

import VISTA.*;

public class MetodoakVista {
	public static void bueltatuLehena() {
		OngiEtorri ongiEtorri = new OngiEtorri();
		ongiEtorri.setVisible(true);
		ongiEtorri.setBounds(550, 200, 642, 467);
}

	public static void saioaHastera(double prezioFinala,String hotela,String gelaMota,int logela_kop) {
		SaioaHasi saioaHasi = new SaioaHasi(prezioFinala,hotela,gelaMota,logela_kop);
		saioaHasi.setVisible(true);
		saioaHasi.setBounds(550, 200, 642, 467);
	}
	
	public static void hotelaErostera() {
		hotelHautatu hotelHautatu = new hotelHautatu();
		hotelHautatu.setVisible(true);
		hotelHautatu.setBounds(550, 200, 642, 467);
	}
	
	public static void ordainketaLeihora(double prezioFinala,String hotela,String gelaMota,int logela_kop) {
		Ordainketa ordainketa = new Ordainketa(prezioFinala,hotela,gelaMota,logela_kop);
		ordainketa.setVisible(true);
		ordainketa.setBounds(550, 200, 642, 467);
	}
	
	public static void azkenera() {
		LehioaAzkena azkena = new LehioaAzkena();
		azkena.setVisible(true);
		azkena.setBounds(550, 200, 642, 467);
	}
	
	public static void saioaSortzera(double prezioFinala,String hotela,String gelaMota,int logela_kop) {
		SaioaSortu SaioaSortu = new SaioaSortu(prezioFinala,hotela,gelaMota,logela_kop);
		SaioaSortu.setVisible(true);
		SaioaSortu.setBounds(550, 200, 642, 467);
	}
	
	public static void hostatuaAukeratzera() {
		hostatuaAukeratu hostatuaAukeratu = new hostatuaAukeratu();
		hostatuaAukeratu.setVisible(true);
		hostatuaAukeratu.setBounds(550, 200, 642, 467);
	}
	
	public static void apartamentuaErostera() {
		apartamentuHautatu apartamentuHautatu = new apartamentuHautatu();
		apartamentuHautatu.setVisible(true);
		apartamentuHautatu.setBounds(550, 200, 642, 467);
	}
	
	public static void etxeaErostera() {
		etxeHautatu etxeHautatu = new etxeHautatu();
		etxeHautatu.setVisible(true);
		etxeHautatu.setBounds(550, 200, 642, 467);
	}
	
	public static void terminoEtaCondizioetara(double prezioFinala, String hotela, String gelaMota, int logela_kop) {
		terminosCondiciones terminosCondiciones = new terminosCondiciones(prezioFinala, hotela, gelaMota, logela_kop);
		terminosCondiciones.setVisible(true);
		terminosCondiciones.setBounds(550, 200, 642, 467);
	}
}