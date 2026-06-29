DROP SCHEMA IF EXISTS psv;
CREATE SCHEMA psv DEFAULT CHARACTER SET utf8 DEFAULT COLLATE utf8_unicode_ci;
USE psv;


CREATE TABLE kategorija_klijenta (
  IdKategorija int,
  TipKategorije varchar(30) NOT NULL,
  PRIMARY KEY (IdKategorija)
);
	
CREATE TABLE klijent (
  IdKlijenta int,
  IdKategorija int NOT NULL,
  TipKlijenta varchar(30) NOT NULL,
  Adresa varchar(30) NOT NULL,
  Grad varchar(30) NOT NULL, 
  Drzava varchar(30) DEFAULT 'Bosna i Hercegovina' NOT NULL,
  E_mail varchar(30) DEFAULT NULL,
  PRIMARY KEY (IdKlijenta),
  CONSTRAINT FK_klijent_kategorija_klijenta 
  FOREIGN KEY (IdKategorija) 
  REFERENCES kategorija_klijenta (IdKategorija)
);

CREATE TABLE ziro_racun_klijenta
(
  BrojZiroRacunaKlijenta varchar(30),
  IdKlijenta int NOT NULL,
  PRIMARY KEY (BrojZiroRacunaKlijenta),
  CONSTRAINT FK_ziro_racun_klijenta_klijent
  FOREIGN KEY (IdKlijenta)
  REFERENCES klijent (IdKlijenta)
);

CREATE TABLE telefon_klijenta (
  IdKlijenta int,
  BrojTelefona varchar(30),
  Opis varchar(30) NOT NULL,  
  PRIMARY KEY (IdKlijenta, BrojTelefona),
  CONSTRAINT FK_telefon_klijenta_klijent 
  FOREIGN KEY (IdKlijenta) 
  REFERENCES klijent (IdKlijenta)
);

CREATE TABLE individualno_lice (
  IdKategorija int,
  Ime varchar(30) NOT NULL,
  Prezime varchar(30) NOT NULL,
  Pol varchar(30) NOT NULL,
  PRIMARY KEY (IdKategorija),
  CONSTRAINT FK_individualno_lice_kategorija_klijenta
  FOREIGN KEY (IdKategorija) 
  REFERENCES kategorija_klijenta (IdKategorija) 
  ON DELETE CASCADE
);

CREATE TABLE kompanija (
  IdKategorija int,
  Naziv varchar(30) NOT NULL,
  InternetStranica varchar(100) DEFAULT NULL,
  PRIMARY KEY (IdKategorija),
  CONSTRAINT FK_kompanija_kategorija_klijenta
  FOREIGN KEY (IdKategorija) 
  REFERENCES kategorija_klijenta (IdKategorija) 
  ON DELETE CASCADE
);

CREATE TABLE korisnici_servisa (
  IdKlijenta int,
  NapomenaOKorisniku varchar(60) DEFAULT NULL,
  PRIMARY KEY (IdKlijenta),
  CONSTRAINT FK_korisnici_servisa_klijenti 
  FOREIGN KEY (IdKlijenta) 
  REFERENCES klijent (IdKlijenta) 
  ON DELETE CASCADE
);

CREATE TABLE distributer_vozila (
  IdKlijenta int,
  Rejting varchar(60) DEFAULT NULL,
  PRIMARY KEY (IdKlijenta),
  CONSTRAINT FK_distributer_vozila_klijenti
  FOREIGN KEY (IdKlijenta) 
  REFERENCES klijent (IdKlijenta) 
  ON DELETE CASCADE
);

CREATE TABLE vozila (
  IdVozila int,
  TipVozila varchar(30) NOT NULL,
  Proizvodjac varchar(30) NOT NULL,
  Model varchar(30) NOT NULL,
  Kilometraza int NOT NULL,
  GodinaProizvodnje int NOT NULL,
  Boja varchar(30) DEFAULT NULL,
  VrstaGoriva varchar(30) DEFAULT NULL,
  BrojRegistracije varchar(30) DEFAULT NULL,
  DatumRegistracije date DEFAULT NULL,
  Fotografija varchar(1024) DEFAULT NULL, 
  PRIMARY KEY (IdVozila)
);

CREATE TABLE zaposleni (
  JMB varchar(30),
  Ime varchar(30) NOT NULL,
  Prezime varchar(30) NOT NULL,
  DatumRodjenja date NOT NULL,
  DatumZaposljavanja date NOT NULL,
  Funkcija varchar(30) NOT NULL,
  Satnica double(8,2) NOT NULL,
  LijecnickiPregled date DEFAULT NULL,
  DatumIstekaUgovora date NOT NULL,
  Fotografija varchar(1024) DEFAULT NULL, 
  PRIMARY KEY (JMB)
);

CREATE TABLE kontakt_zaposlenog (
  IdKontakt int,
  Grad varchar(30) NOT NULL,
  Adresa varchar(30) NOT NULL,
  Telefon varchar(30) DEFAULT NULL,
  Email varchar(30) DEFAULT NULL,
  JMB varchar(30) NOT NULL,
  PRIMARY KEY (IdKontakt),
  CONSTRAINT FK_kontakt_zaposlenog_zaposleni 
  FOREIGN KEY (JMB) 
  REFERENCES zaposleni (JMB)
  ON DELETE CASCADE
);

CREATE TABLE rukovodilac_servisa (
  JMB varchar(30),
  LicniBroj varchar(30) UNIQUE NOT NULL,
  StrucnaSprema varchar(30),
  BrojOdobrenihZahtjeva int,
  PRIMARY KEY (JMB),
  CONSTRAINT FK_rukovodilac_servisa_zaposleni 
  FOREIGN KEY (JMB) 
  REFERENCES zaposleni (JMB)
  ON DELETE CASCADE
);

CREATE TABLE rukovodilac_skladista (
  JMB varchar(30),
  LicniBroj varchar(30) UNIQUE NOT NULL,
  PRIMARY KEY (JMB),
  CONSTRAINT FK_rukovodilac_skladista_zaposleni
  FOREIGN KEY (JMB) 
  REFERENCES zaposleni (JMB)
  ON DELETE CASCADE
);

CREATE TABLE prodavac (
  JMB varchar(30),
  BrojProdatihVozila int NOT NULL,
  Sifra varchar(30) UNIQUE NOT NULL,
  PRIMARY KEY (JMB),
  CONSTRAINT FK_prodavac_zaposleni
  FOREIGN KEY (JMB) 
  REFERENCES zaposleni (JMB) 
  ON DELETE CASCADE
);

CREATE TABLE menadzer (
  JMB varchar(30),
  Sifra varchar(30) UNIQUE NOT NULL,
  PRIMARY KEY (JMB),
  CONSTRAINT FK_menadzer_zaposleni
  FOREIGN KEY (JMB) 
  REFERENCES zaposleni (JMB) 
  ON DELETE CASCADE
);

CREATE TABLE mehanicar (
  JMB varchar(30),
  BrojSmjene varchar(30) DEFAULT NULL,
  TrenutniBrojAktivnosti int DEFAULT NULL,
  PRIMARY KEY (JMB),
  CONSTRAINT FK_mehanicar_zaposleni
  FOREIGN KEY (JMB) 
  REFERENCES zaposleni (JMB) 
  ON DELETE CASCADE
);

CREATE TABLE zahtjev (
  BrojZahtjeva int,
  IdKlijenta int NOT NULL,
  DatumZahtjeva date NOT NULL,
  KrajnjiRok date NOT NULL,
  JMB varchar(30) NOT NULL,
  PRIMARY KEY (BrojZahtjeva),
  CONSTRAINT FK_zahtjev_korisnici_servisa 
  FOREIGN KEY (IdKlijenta) 
  REFERENCES korisnici_servisa (IdKlijenta),
  CONSTRAINT FK_zahtjev_rukovodilac_servisa 
  FOREIGN KEY (JMB) 
  REFERENCES rukovodilac_servisa (JMB)
);

CREATE TABLE servisna_knjiga_vozila (
  BrojKarticeVozila int,
  IdVozila int,
  BrojZahtjeva int NOT NULL,
  UkupanBrojServisa int NOT NULL,
  DatumPoslednjegServisa date DEFAULT NULL,
  OpisRanijihPopravki varchar(100) DEFAULT NULL,
  Status varchar(30) NOT NULL,
  OpisProblema varchar(100) DEFAULT NULL,
  PRIMARY KEY (BrojKarticeVozila, IdVozila),
  CONSTRAINT  FK_servisna_knjiga_vozila_vozila
  FOREIGN KEY (IdVozila) 
  REFERENCES vozila (IdVozila),
  CONSTRAINT  FK_servisna_knjiga_vozila_zahtjev
  FOREIGN KEY (BrojZahtjeva) 
  REFERENCES zahtjev (BrojZahtjeva)
);

CREATE TABLE vozilo_na_servisu (
  IdVozilaNaServisu int,
  IdVozila int,
  BrojKarticeVozila int NOT NULL,
  DatumPrijemaVozila date DEFAULT NULL,
  ProcjenaTroskova double(8,2) DEFAULT NULL,
  ProcjenaZavrsetkaRadova date DEFAULT NULL,
  PRIMARY KEY (IdVozilaNaServisu),
  CONSTRAINT FK_vozilo_na_servisu_servisna_knjiga_vozila 
  FOREIGN KEY (BrojKarticeVozila) 
  REFERENCES servisna_knjiga_vozila (BrojKarticeVozila),
  CONSTRAINT  FK_vozilo_na_servisu_vozila
  FOREIGN KEY (IdVozila) 
  REFERENCES vozila (IdVozila)
);

CREATE TABLE banka (
  JIB varchar(30),
  Sjediste varchar(30),
  Naziv varchar(30) NOT NULL,
  ZiroRacunBanke varchar(30),
  PRIMARY KEY (JIB)
);

CREATE TABLE ziro_racun_preduzeca (
  BrojZiroRacunaPreduzeca varchar(30),
  JIB varchar(30) NOT NULL,
  PRIMARY KEY (BrojZiroRacunaPreduzeca),
  CONSTRAINT FK_ziro_racun_preduzeca_banka
  FOREIGN KEY (JIB) 
  REFERENCES banka (JIB)
);

CREATE TABLE ziro_racun_preduzeca_menadzer (
  BrojZiroRacunaPreduzeca varchar(30),
  JMB varchar(30),
  PRIMARY KEY (BrojZiroRacunaPreduzeca,JMB),
  CONSTRAINT FK_ziro_racun_preduzeca_menadzer_ziro_racun_preduzeca
  FOREIGN KEY (BrojZiroRacunaPreduzeca) 
  REFERENCES ziro_racun_preduzeca (BrojZiroRacunaPreduzeca),
  CONSTRAINT FK_ziro_racun_preduzeca_menadzer_menadzer
  FOREIGN KEY (JMB) 
  REFERENCES menadzer (JMB) 
  ON DELETE CASCADE
);

CREATE TABLE dijelovi_i_materijali (
  NazivDijela varchar(30),
  Cijena int NOT NULL,
  Tip varchar(30) NOT NULL,
  Proizvodjac varchar(30) DEFAULT NULL,
  KolicinaNaSkladistu int DEFAULT NULL,
  PRIMARY KEY (NazivDijela)
);

CREATE TABLE dodatne_usluge (
  TipUsluge varchar(30),
  CijenaDodatneUsluge int NOT NULL,
  PRIMARY KEY (TipUsluge)
);

CREATE TABLE dobavljac (
  IdKlijenta int,
  InternetStranica varchar(100) DEFAULT NULL,
  PRIMARY KEY (IdKlijenta),
  CONSTRAINT FK_dobavljac_klijent
  FOREIGN KEY (IdKlijenta) 
  REFERENCES klijent (IdKlijenta) 
  ON DELETE CASCADE
);
CREATE TABLE kupac (
  IdKlijenta int NOT NULL,
  PRIMARY KEY (IdKlijenta),
  CONSTRAINT FK_kupac_klijent
  FOREIGN KEY (IdKlijenta) 
  REFERENCES klijent (IdKlijenta) 
  ON DELETE CASCADE
);

CREATE TABLE osiguravajuce_drustvo (
  JIB varchar(30) NOT NULL,
  Naziv varchar(30) DEFAULT NULL,
  PRIMARY KEY (JIB)
);

CREATE TABLE prodata_vozila (
  IdVozila int,
  CijenaProdaje double(8,2) NOT NULL,
  PeriodGarancije int NOT NULL,
  PRIMARY KEY (IdVozila),
  CONSTRAINT FK_prodata_vozila_vozila
  FOREIGN KEY (IdVozila) 
  REFERENCES vozila (IdVozila) 
  ON DELETE CASCADE
);

CREATE TABLE servisni_radovi (
  VrstaServisnihRadova varchar(100),
  Koeficijent double(8,2) NOT NULL,
  PRIMARY KEY (VrstaServisnihRadova)
);

CREATE TABLE ugovor (
  IdUgovora int,
  DatumSklapanjaUgovora date NOT NULL,
  JMB varchar(30),
  PRIMARY KEY (IdUgovora),
  CONSTRAINT ugovor_menadzer
  FOREIGN KEY (JMB) 
  REFERENCES menadzer (JMB)
  ON DELETE SET NULL
);

CREATE TABLE radni_nalog (
  IdRadniNalog int,
  IdVozilaNaServisu int NOT NULL,
  VrstaServisnihRadova varchar(100) NOT NULL,
  Termin varchar(30) NOT NULL,
  PRIMARY KEY (IdRadniNalog),
  CONSTRAINT FK_radni_nalog_vozilo_na_servisu 
  FOREIGN KEY (IdVozilaNaServisu) 
  REFERENCES vozilo_na_servisu (IdVozilaNaServisu),
  CONSTRAINT FK_radni_nalog_servisni_radovi 
  FOREIGN KEY (VrstaServisnihRadova) 
  REFERENCES servisni_radovi (VrstaServisnihRadova)
);

CREATE TABLE vozila_u_vlasnistvu (
  IdVozila int NOT NULL,
  DatumNabavke date NOT NULL,				-- redundantno zbog potrebe za velikim promjenama u aplikaciji
  CijenaNabavke double(8,2) NOT NULL,		-- redundantno zbog potrebe za velikim promjenama u aplikaciji
  Status_Za_Prodaju varchar(30) NOT NULL,
  TehnickaProvjera varchar(30) NOT NULL,
  IdKlijenta int DEFAULT NULL,
  BrojGaraze int DEFAULT 1,
  Ocarinjeno varchar(30) DEFAULT 'Ocarinjeno',
  StanjeVozila varchar(30) DEFAULT 'Novo',
  PRIMARY KEY (IdVozila),
  CONSTRAINT FK_vozila_u_vlasnistvu_vozila 
  FOREIGN KEY (IdVozila) 
  REFERENCES vozila (IdVozila), 
  CONSTRAINT FK_vozila_u_vlasnistvu_kupac
  FOREIGN KEY (IdKlijenta) 
  REFERENCES kupac (IdKlijenta) 
  ON DELETE CASCADE
);

CREATE TABLE realizacija (
  IdRadniNalog int NOT NULL,
  JMB varchar(30) NOT NULL,
  DatumRealizacije date NOT NULL,
  PRIMARY KEY (IdRadniNalog,JMB),
  CONSTRAINT realizacija_radni_nalog
  FOREIGN KEY (IdRadniNalog) 
  REFERENCES radni_nalog (IdRadniNalog),
  CONSTRAINT realizacija_mehanicar
  FOREIGN KEY (JMB) 
  REFERENCES mehanicar (JMB)
);

CREATE TABLE prodaja (
  IdProdaja int,
  IdKlijenta int NOT NULL,
  IdVozila int NOT NULL,
  JMB varchar(30),
  NacinPlacanja varchar(30) DEFAULT NULL,
  UkupnoNaplaceno double(8,2) NOT NULL,
  Status_za_naplatu varchar(30) NOT NULL,
  DatumProdaje date NOT NULL,
  SledecaUplata varchar(30) NOT NULL,
  IdUgovora int NOT NULL,
  PRIMARY KEY (IdProdaja),
  CONSTRAINT FK_prodaja_kupac 
  FOREIGN KEY (IdKlijenta) 
  REFERENCES kupac (IdKlijenta),
  CONSTRAINT FK_prodaja_prodata_vozila 
  FOREIGN KEY (IdVozila) 
  REFERENCES prodata_vozila (IdVozila),
  CONSTRAINT FK_prodaja_prodavac 
  FOREIGN KEY (JMB) 
  REFERENCES prodavac (JMB)
  ON DELETE SET NULL,
  CONSTRAINT FK_prodaja_ugovor 
  FOREIGN KEY (IdUgovora) 
  REFERENCES ugovor (IdUgovora)
);

CREATE TABLE kredit (
  IdKredit int,
  IznosRateKredita double(8,2) DEFAULT NULL,
  BrojRata int DEFAULT NULL,
  JIB varchar(30) NOT NULL,
  IdProdaja int NOT NULL,
  PRIMARY KEY (IdKredit),
  CONSTRAINT FK_kredit_banka
  FOREIGN KEY (JIB) 
  REFERENCES banka (JIB),
  CONSTRAINT FK_kredit_prodaja
  FOREIGN KEY (IdProdaja) 
  REFERENCES prodaja (IdProdaja)
);

CREATE TABLE kvalifikacija (
  VrstaServisnihRadova varchar(100),
  JMB varchar(30) NOT NULL,
  Opis varchar(100) DEFAULT NULL,
  PRIMARY KEY (VrstaServisnihRadova,JMB),
  CONSTRAINT FK_kvalifikacija_servisni_radovi
  FOREIGN KEY (VrstaServisnihRadova) 
  REFERENCES servisni_radovi (VrstaServisnihRadova),
  CONSTRAINT FK_kvalifikacija_mehanicar
  FOREIGN KEY (JMB) 
  REFERENCES mehanicar (JMB)
  ON DELETE CASCADE
);

CREATE TABLE polisaosiguranja (
  IdPolisa int,
  OdobrenIznos double(8,2) NOT NULL,
  PeriodReklamacije int NOT NULL,
  JIB varchar(30) NOT NULL,
  IdProdaja int NOT NULL,
  PRIMARY KEY (IdPolisa),
  CONSTRAINT FK_polisaosiguranja_osiguravajuce_drustvo
  FOREIGN KEY (JIB) 
  REFERENCES osiguravajuce_drustvo (JIB),
  CONSTRAINT FK_polisaosiguranja_prodaja
  FOREIGN KEY (IdProdaja) 
  REFERENCES prodaja (IdProdaja)
);

CREATE TABLE naplata_kupovine (
  BrojNaplateKupovine int,
  IdProdaja int NOT NULL,
  BrojZiroRacunaPreduzeca varchar(30) NOT NULL,
  DatumNaplate date NOT NULL,
  PRIMARY KEY (BrojNaplateKupovine),
  CONSTRAINT FK_naplata_kupovine_prodaja 
  FOREIGN KEY (IdProdaja) 
  REFERENCES prodaja (IdProdaja),
  CONSTRAINT FK_naplata_kupovine_ziro_racun_klijenta 
  FOREIGN KEY (BrojZiroRacunaPreduzeca) 
  REFERENCES ziro_racun_preduzeca (BrojZiroRacunaPreduzeca)
);

CREATE TABLE naplata_servisa (
  BrojNaplateServisa int,
  Popust double(8,2) DEFAULT 0.0,
  IdVozilaNaServisu int NOT NULL,
  DatumNaplate date DEFAULT NULL,
  Iznos double(8,2)  DEFAULT 0.0,
  BrojZiroRacunaPreduzeca varchar(30) NOT NULL,
  UkupnaCijenaDodatnihUsluga double(8,2)  DEFAULT 0.0,
  Status varchar(30) DEFAULT "Neisplaceno",
  PRIMARY KEY (BrojNaplateServisa),
  CONSTRAINT FK_naplata_servisa_vozilo_na_servisu
  FOREIGN KEY (IdVozilaNaServisu) 
  REFERENCES vozilo_na_servisu (IdVozilaNaServisu),
  CONSTRAINT FK_naplata_servisa_ziro_racun_preduzeca
  FOREIGN KEY (BrojZiroRacunaPreduzeca) 
  REFERENCES ziro_racun_preduzeca (BrojZiroRacunaPreduzeca)
);

CREATE TABLE usluga (
  BrojUsluge int, 
  IdRadniNalog int NOT NULL,
  BrojNaplateServisa int NOT NULL,
  CijenaUsluge double(8,2) NOT NULL,
  BrojUtrošenihSati double(8,2) NOT NULL,
  KoeficijentRadova double(8,2) NOT NULL,
  CijenaDijelova double(8,2) NOT NULL,
  PRIMARY KEY (BrojUsluge,BrojNaplateServisa),
  CONSTRAINT FK_usluga_radni_nalog 
  FOREIGN KEY (IdRadniNalog) 
  REFERENCES radni_nalog (IdRadniNalog),
  CONSTRAINT FK_usluga_naplata_servisa 
  FOREIGN KEY (BrojNaplateServisa) 
  REFERENCES naplata_servisa (BrojNaplateServisa)
);

CREATE TABLE izdavanje (
  JMB varchar(30) NOT NULL,
  NazivDijela varchar(30) NOT NULL,
  BrojUsluge int NOT NULL,
  BrojNaplateServisa int NOT NULL,
  KolicinaUtrosenogDijela int NOT NULL,
  PRIMARY KEY (JMB,NazivDijela,BrojUsluge,BrojNaplateServisa),
  CONSTRAINT FK_izdavanje_usluga 
  FOREIGN KEY (BrojUsluge, BrojNaplateServisa) 
  REFERENCES usluga (BrojUsluge, BrojNaplateServisa),
  CONSTRAINT FK_izdavanje_rukovodilac_skladista 
  FOREIGN KEY (JMB) 
  REFERENCES rukovodilac_skladista (JMB),
  CONSTRAINT FK_izdavanje_dijelovi_i_materijali
  FOREIGN KEY (NazivDijela) 
  REFERENCES dijelovi_i_materijali (NazivDijela)
);

CREATE TABLE nabavka_vozila (
  IdVozila int,
  DatumNabavke date,
  CijenaNabavke double(8,2) NOT NULL,
  IdKlijenta int NOT NULL,
  PRIMARY KEY (IdVozila, DatumNabavke),
  CONSTRAINT FK_nabavka_vozila_vozila_u_vlasnistvu
  FOREIGN KEY (IdVozila) 
  REFERENCES vozila_u_vlasnistvu (IdVozila),
  CONSTRAINT FK_nabavka_vozila_distributer_vozila
  FOREIGN KEY (IdKlijenta) 
  REFERENCES distributer_vozila (IdKlijenta)
);
