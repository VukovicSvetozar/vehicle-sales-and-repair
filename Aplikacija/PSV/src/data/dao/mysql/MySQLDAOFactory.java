package data.dao.mysql;

import data.dao.DAOFactory;
import data.dao.mysql.prodaja_vozila.*;
import data.dao.mysql.servis_vozila.*;
import data.dao.mysql.zaposleni.*;
import data.dao.prodaja_vozila.*;
import data.dao.servis_vozila.*;
import data.dao.zaposleni.*;

public class MySQLDAOFactory extends DAOFactory {

	@Override
	public KategorijaKlijentaDAO getKategorijaKlijentaDAO() {
		return new MySQLKategorijaKlijentaDAO();
	}

	@Override
	public IndividualnoLiceDAO getIndividualnoLiceDAO() {
		return new MySQLIndividualnoLiceDAO();
	}

	@Override
	public KompanijaDAO getKompanijaDAO() {
		return new MySQLKompanijaDAO();
	}

	@Override
	public KlijentDAO getKlijentDAO() {
		return new MySQLKlijentDAO();
	}

	@Override
	public TelefonKlijentaDAO getTelefonKlijentaDAO() {
		return new MySQLTelefonKlijentaDAO();
	}

	@Override
	public KorisniciServisaDAO getKorisniciServisaDAO() {
		return new MySQLKorisniciServisaDAO();
	}

	@Override
	public ZahtjevDAO getZahtjevDAO() {
		return new MySQLZahtjevDAO();
	}

	@Override
	public ZiroRacunKlijentaDAO getZiroRacunKlijentaDAO() {
		return new MySQLZiroRacunKlijentaDAO();
	}

//	@Override
//	public KarticaVozilaDAO getKarticaVozilaDAO() {
//		return new MySQLKarticaVozilaDAO();
//	}

	@Override
	public VozilaDAO getVozilaDAO() {
		return new MySQLVozilaDAO();
	}

	@Override
	public VoziloNaServisuDAO getVoziloNaServisuDAO() {
		return new MySQLVoziloNaServisuDAO();
	}

	@Override
	public BankaDAO getBankaDAO() {
		return new MySQLBankaDAO();
	}

	@Override
	public NabavkaVozilaDAO getNabavkaVozilaDAO() {
		return new MySQLNabavkaVozilaDAO();
	}
	
//	@Override
//	public DobavljacDAO getDobavljacDAO() {
//		return new MySQLDobavljacDAO();
//	}

	@Override
	public KreditDAO getKreditDAO() {
		return new MySQLKreditDAO();
	}

	@Override
	public KupacDAO getKupacDAO() {
		return new MySQLKupacDAO();
	}

	@Override
	public NaplataKupovineDAO getNaplataKupovineDAO() {
		return new MySQLNaplataKupovineDAO();
	}

	@Override
	public OsiguravajuceDrustvoDAO getOsiguravajuceDrustvoDAO() {
		return new MySQLOsiguravajuceDrustvoDAO();
	}

	@Override
	public PolisaOsiguranjaDAO getPolisaOsiguranjaDAO() {
		return new MySQLPolisaOsiguranjaDAO();
	}

	@Override
	public ProdajaDAO getProdajaDAO() {
		return new MySQLProdajaDAO();	}

	@Override
	public ProdataVozilaDAO getProdataVozilaDAO() {
		return new MySQLProdataVozilaDAO();
	}

	@Override
	public ProdavacDAO getProdavacDAO() {
		return new MySQLProdavacDAO();
	}

//	@Override
//	public DijeloviIMaterijaliDAO getDijeloviIMaterijaliDAO() {
//		return new MySQLDijeloviIMaterijaliDAO();
//	}
//
//	@Override
//	public DodatneUslugeDAO getDodatneUslugeDAO() {
//		return new MySQLDodatneUslugeDAO();
//	}
//
//	@Override
//	public IzdavanjeDAO getIzdavanjeDAO() {
//		return new MySQLIzdavanjeDAO();
//	}

	@Override
	public KvalifikacijaDAO getKvalifikacijaDAO() {
		return new MySQLKvalifikacijaDAO();
	}

//	@Override
//	public NaplataServisaDAO getNaplataServisaDAO() {
//		return new MySQLNaplataServisaDAO();
//	}

	@Override
	public RadniNalogDAO getRadniNalogDAO() {
		return new MySQLRadniNalogDAO();
	}

//	@Override
//	public RealizacijaDAO getRealizacijaDAO() {
//		return new MySQLRealizacijaDAO();
//	}
//
	@Override
	public ServisnaKnjigaVozilaDAO getServisnaKnjigaVozilaDAO() {
		return new MySQLServisnaKnjigaVozilaDAO();
	}

	@Override
	public ServisniRadoviDAO getServisniRadoviDAO() {
		return new MySQLServisniRadoviDAO();
	}

	@Override
	public UgovorDAO getUgovorDAO() {
		return new MySQLUgovorDAO();
	}
//
//	@Override
//	public UslugaDAO getUslugaDAO() {
//		return new MySQLUslugaDAO();	
//	}

	@Override
	public VoziloUVlasnistvuDAO getVoziloUVlasnistvuDAO() {
		return new MySQLVoziloUVlasnistvuDAO();
	}

	@Override
	public ZiroRacunPreduzecaDAO getZiroRacunPreduzecaDAO() {
		return new MySQLZiroRacunPreduzecaDAO();
	}

	@Override
	public MehanicarDAO getMehanicarDAO() {
		return new MySQLMehanicarDAO();
	}

	@Override
	public MenadzerDAO getMenadzerDAO() {
		return new MySQLMenadzerDAO();
	}

	@Override
	public RukovodilacSkladistaDAO getRukovodilacSkladistaDAO() {
		return new MySQLRukovodilacSkladistaDAO();
	}
	
	@Override
	public RukovodilacServisaDAO getRukovodilacServisaDAO() {
		return new MySQLRukovodilacServisaDAO();
	}
	
	@Override
	public KontaktZaposlenogDAO getKontaktZaposlenogDAO() {
		return new MySQLKontaktZaposlenogDAO();
	}

	@Override
	public ZaposleniDAO getZaposleniDAO() {
		return new MySQLZaposleniDAO();
	}
	
	@Override
	public ZiroRacunPreduzecaMenadzerDAO getZiroRacunPreduzecaMenadzerDAO() {
		return new MySQLZiroRacunPreduzecaMenadzerDAO();
	}

	@Override
	public DistributerVozilaDAO getDistributerVozilaDAO() {
		return new MySQLDistributerVozilaDAO();
	}

}
