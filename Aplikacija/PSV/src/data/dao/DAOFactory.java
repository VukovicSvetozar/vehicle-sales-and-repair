package data.dao;

import data.dao.mysql.MySQLDAOFactory;
import data.dao.prodaja_vozila.*;
import data.dao.servis_vozila.KorisniciServisaDAO;
import data.dao.servis_vozila.RadniNalogDAO;
import data.dao.servis_vozila.ServisnaKnjigaVozilaDAO;
import data.dao.servis_vozila.VoziloNaServisuDAO;
import data.dao.servis_vozila.ZahtjevDAO;
import data.dao.zaposleni.*;

public abstract class DAOFactory {
	
//	public abstract DobavljacDAO getDobavljacDAO();
//	public abstract DijeloviIMaterijaliDAO getDijeloviIMaterijaliDAO();
//	public abstract DodatneUslugeDAO getDodatneUslugeDAO();
//	public abstract IzdavanjeDAO getIzdavanjeDAO();
	public abstract KorisniciServisaDAO getKorisniciServisaDAO();
//	public abstract NaplataServisaDAO getNaplataServisaDAO();
	public abstract RadniNalogDAO getRadniNalogDAO();
//	public abstract RealizacijaDAO getRealizacijaDAO();
	public abstract ServisnaKnjigaVozilaDAO getServisnaKnjigaVozilaDAO();
//	public abstract UslugaDAO getUslugaDAO();
	public abstract VoziloNaServisuDAO getVoziloNaServisuDAO();
	public abstract ZahtjevDAO getZahtjevDAO();
//	public abstract KarticaVozilaDAO getKarticaVozilaDAO();
	
	public abstract NabavkaVozilaDAO getNabavkaVozilaDAO();
	public abstract DistributerVozilaDAO getDistributerVozilaDAO();
	public abstract NaplataKupovineDAO getNaplataKupovineDAO();
	public abstract UgovorDAO getUgovorDAO();
	public abstract KreditDAO getKreditDAO();
	public abstract OsiguravajuceDrustvoDAO getOsiguravajuceDrustvoDAO();
	public abstract PolisaOsiguranjaDAO getPolisaOsiguranjaDAO();
	public abstract ProdajaDAO getProdajaDAO();
	public abstract KompanijaDAO getKompanijaDAO();
	public abstract IndividualnoLiceDAO getIndividualnoLiceDAO();
	public abstract TelefonKlijentaDAO getTelefonKlijentaDAO();
	public abstract ZiroRacunKlijentaDAO getZiroRacunKlijentaDAO();
	public abstract KategorijaKlijentaDAO getKategorijaKlijentaDAO();
	public abstract KlijentDAO getKlijentDAO();	
	public abstract VozilaDAO getVozilaDAO();
	public abstract KupacDAO getKupacDAO();
	public abstract ProdataVozilaDAO getProdataVozilaDAO();
	public abstract VoziloUVlasnistvuDAO getVoziloUVlasnistvuDAO();
	
	public abstract KontaktZaposlenogDAO getKontaktZaposlenogDAO();
	public abstract BankaDAO getBankaDAO();
	public abstract ZiroRacunPreduzecaDAO getZiroRacunPreduzecaDAO();
	public abstract MehanicarDAO getMehanicarDAO();
	public abstract MenadzerDAO getMenadzerDAO();
	public abstract ProdavacDAO getProdavacDAO();
	public abstract RukovodilacServisaDAO getRukovodilacServisaDAO();
	public abstract RukovodilacSkladistaDAO getRukovodilacSkladistaDAO();
	public abstract ZaposleniDAO getZaposleniDAO();
	public abstract ServisniRadoviDAO getServisniRadoviDAO();
	public abstract KvalifikacijaDAO getKvalifikacijaDAO();
	public abstract ZiroRacunPreduzecaMenadzerDAO getZiroRacunPreduzecaMenadzerDAO();
	
	public static DAOFactory getDAOFactory() {
		return new MySQLDAOFactory();
	}
	
}
