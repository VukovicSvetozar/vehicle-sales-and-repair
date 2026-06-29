use psv;

delimiter $$
create procedure kreiraj_zaposleni(in JMB varchar(30), in Ime varchar(30), in Prezime varchar(30), in  DatumRodjenja date, in DatumZaposljavanja date, in Funkcija varchar(30), in Satnica double(8,2), in LijecnickiPregled date, in DatumIstekaUgovora date, in Fotografija varchar(1024))
begin
	insert into zaposleni values(JMB, Ime, Prezime, DatumRodjenja, DatumZaposljavanja, Funkcija, Satnica, LijecnickiPregled, DatumIstekaUgovora, Fotografija);
end$$
delimiter ;

delimiter $$
create procedure kreiraj_kontakt_zaposlenog(in IdKontakt int, in Grad varchar(30), Adresa varchar(30), Telefon varchar(30), Email varchar(30), PJMB varchar(30))
begin
	insert into kontakt_zaposlenog values(IdKontakt, Grad, Adresa, Telefon, Email, (SELECT JMB FROM zaposleni WHERE JMB=PJMB));
end$$
delimiter ;

delimiter $$
create procedure kreiraj_menadzer(in PJMB varchar(30), in Sifra varchar(30))
begin
	insert into menadzer values((SELECT JMB FROM zaposleni WHERE JMB=PJMB), Sifra);
end$$
delimiter ;

delimiter $$
create procedure kreiraj_prodavac(in PJMB varchar(30), in BrojProdatihVozila int, in Sifra varchar(30))
begin
	insert into prodavac values((SELECT JMB FROM zaposleni WHERE JMB=PJMB), BrojProdatihVozila, Sifra);
end$$
delimiter ;

delimiter $$
create procedure kreiraj_rukovodilac_servisa(in PJMB varchar(30), in LicniBroj varchar(30))
begin
	insert into rukovodilac_servisa values((SELECT JMB FROM zaposleni WHERE JMB=PJMB), LicniBroj);
end$$
delimiter ;

delimiter $$
create procedure kreiraj_rukovodilac_skladista(in PJMB varchar(30), in LicniBroj varchar(30))
begin
	insert into rukovodilac_skladista values((SELECT JMB FROM zaposleni WHERE JMB=PJMB), LicniBroj);
end$$
delimiter ;

delimiter $$
create procedure kreiraj_mehanicar(in PJMB varchar(30), in BrojSmjene varchar(30), in TrenutniBrojAktivnosti int)
begin
	insert into mehanicar values((SELECT JMB FROM zaposleni WHERE JMB=PJMB), BrojSmjene, TrenutniBrojAktivnosti);
end$$
delimiter ;

delimiter $$
create procedure kreiraj_banka (in JIB varchar(30), in Sjediste varchar(30), in Naziv varchar(30), in ZiroRacunBanke varchar(30))
begin
	insert into banka values(JIB, Sjediste, Naziv, ZiroRacunBanke);
end$$
delimiter ;

delimiter $$
create procedure kreiraj_ziro_racun_preduzeca(in BrojZiroRacunaPreduzeca varchar(30),
  in PJIB varchar(30))
begin
	insert into ziro_racun_preduzeca values(BrojZiroRacunaPreduzeca,(SELECT JIB FROM banka WHERE JIB=PJIB));
end$$
delimiter ;

delimiter $$
create procedure kreiraj_ziro_racun_preduzeca_menadzer(in PBrojZiroRacunaPreduzeca varchar(30),
  in PJMB varchar(30))
begin
	insert into ziro_racun_preduzeca_menadzer values((SELECT BrojZiroRacunaPreduzeca FROM ziro_racun_preduzeca WHERE BrojZiroRacunaPreduzeca=PBrojZiroRacunaPreduzeca),(SELECT JMB FROM menadzer WHERE JMB=PJMB));
end$$
delimiter ;

delimiter $$
create procedure kreiraj_servisni_radovi (in VrstaServisnihRadova varchar(100), in Koeficijent double(8,2))
begin
	insert into servisni_radovi values(VrstaServisnihRadova, Koeficijent);
end$$
delimiter ;

delimiter $$
create procedure kreiraj_kvalifikacija (in PVrstaServisnihRadova varchar(100), in PJMB varchar(30), in Opis varchar(100))
begin
	insert into kvalifikacija values((SELECT VrstaServisnihRadova FROM servisni_radovi WHERE VrstaServisnihRadova=PVrstaServisnihRadova)
, (SELECT JMB FROM mehanicar WHERE JMB=PJMB)
, Opis);
end$$
delimiter ;

delimiter $$
create procedure kreiraj_kategorija_klijenta (in IdKategorija int, in TipKategorije varchar(30))
begin
	insert into kategorija_klijenta values(IdKategorija, TipKategorije);
end$$
delimiter ;

delimiter $$
create procedure kreiraj_klijent(in IdKlijenta int, in PIdKategorija int, in TipKlijenta varchar(30), in Adresa varchar(30), in Grad varchar(30), in Drzava varchar(30), in E_mail varchar(30))
begin
	insert into klijent values(IdKlijenta,(SELECT IdKategorija FROM kategorija_klijenta WHERE IdKategorija=PIdKategorija), TipKlijenta, Adresa, Grad, Drzava, E_mail);
end$$
delimiter ;

delimiter $$
create procedure kreiraj_telefon_klijenta (in PIdKlijenta int, in BrojTelefona varchar(30), in Opis varchar(30))
begin
	insert into telefon_klijenta values((SELECT IdKlijenta FROM klijent WHERE IdKlijenta=PIdKlijenta), BrojTelefona, Opis);
end$$
delimiter ;

delimiter $$
create procedure kreiraj_ziro_racun_klijenta(in BrojZiroRacunaKlijenta varchar(30), in PIdKlijenta int)
begin
	insert into ziro_racun_klijenta values(BrojZiroRacunaKlijenta, (SELECT IdKlijenta FROM klijent WHERE IdKlijenta=PIdKlijenta));
end$$
delimiter ;

delimiter $$
create procedure kreiraj_individualno_lice (in PIdKategorija int, in Ime varchar(30), in Prezime varchar(30), in Pol varchar(30))
begin
	insert into individualno_lice values((SELECT IdKategorija FROM kategorija_klijenta WHERE IdKategorija=PIdKategorija), Ime, Prezime, Pol);
end$$
delimiter ;

delimiter $$
create procedure kreiraj_kompanija (in PIdKategorija int, in Naziv varchar(30), in InternetStranica varchar (100))
begin
	insert into kompanija values((SELECT IdKategorija FROM kategorija_klijenta WHERE IdKategorija=PIdKategorija), Naziv, InternetStranica);
end$$
delimiter ;

delimiter $$
create procedure kreiraj_vozila(in IdVozila int, in TipVozila varchar(30), in Proizvodjac varchar(30), in Model varchar(30), Kilometraza int, in GodinaProizvodnje int, in Boja varchar(30), in VrstaGoriva varchar(30), in BrojRegistracije varchar(30), in DatumRegistracije date, in Fotografija varchar(1024))
begin
	insert into vozila values(IdVozila, TipVozila, Proizvodjac, Model, Kilometraza, GodinaProizvodnje, Boja, VrstaGoriva,  BrojRegistracije, DatumRegistracije, Fotografija);
end$$
delimiter ;

delimiter $$
create procedure kreiraj_vozila_u_vlasnistvu (in PIdVozila int, in DatumNabavke date, in CijenaNabavke double(8,2), in Status_Za_Prodaju varchar(30), in TehnickaProvjera varchar(30), in PIdKlijenta int, in BrojGaraze int, in Ocarinjeno varchar(30), StanjeVozila varchar(30))
begin
	insert into vozila_u_vlasnistvu values((SELECT IdVozila FROM vozila WHERE IdVozila=PIdVozila), DatumNabavke, CijenaNabavke, Status_Za_Prodaju, TehnickaProvjera, (SELECT IdKlijenta FROM kupac WHERE IdKlijenta=PIdKlijenta), BrojGaraze, Ocarinjeno, StanjeVozila);
end$$
delimiter ;

delimiter $$
create procedure kreiraj_kupac (in PIdKlijenta int)
begin
	insert into kupac values((SELECT IdKlijenta FROM klijent WHERE IdKlijenta=PIdKlijenta));
end$$
delimiter ;

delimiter $$
create procedure kreiraj_prodata_vozila (in PIdVozila int, in CijenaProdaje double(8,2), in PeriodGarancije int)
begin
	insert into prodata_vozila values((SELECT IdVozila FROM vozila WHERE IdVozila=PIdVozila), CijenaProdaje, PeriodGarancije);
end$$
delimiter ;

delimiter $$
create procedure kreiraj_ugovor (in IdUgovora int, in DatumSklapanjaUgovora date, in PJMB varchar(30))
begin
	insert into ugovor values(IdUgovora, DatumSklapanjaUgovora, (SELECT JMB FROM menadzer WHERE JMB=PJMB)
);
end$$
delimiter ;

delimiter $$
create procedure kreiraj_prodaja (in IdProdaja int, in PIdKlijenta int, in PIdVozila int, in PJMB varchar(30), in NacinPlacanja varchar(30), in UkupnoNaplaceno double(8,2), in Status_za_naplatu varchar(30), in DatumProdaje date, in SledecaUplata varchar(30), in PIdUgovora int)
begin
	insert into prodaja values(IdProdaja, (SELECT IdKlijenta FROM kupac WHERE IdKlijenta=PIdKlijenta), (SELECT IdVozila FROM prodata_vozila WHERE IdVozila=PIdVozila), (SELECT JMB FROM prodavac WHERE JMB=PJMB), NacinPlacanja, UkupnoNaplaceno, Status_za_naplatu, DatumProdaje, SledecaUplata, (SELECT IdUgovora FROM ugovor WHERE IdUgovora=PIdUgovora));
end$$
delimiter ;

delimiter $$
create procedure kreiraj_kredit (in IdKredit int, in IznosRateKredita double(8,2), in BrojRata int, in PJIB varchar(30), in PIdProdaja int)
begin
	insert into kredit values(IdKredit, IznosRateKredita, BrojRata, (SELECT JIB FROM banka WHERE JIB=PJIB)
, (SELECT IdProdaja FROM prodaja WHERE IdProdaja=PIdProdaja));
end$$
delimiter ;

delimiter $$
create procedure kreiraj_osiguravajucedrustvo (in JIB varchar(30), in Naziv varchar(30))
begin
	insert into osiguravajuce_drustvo values(JIB, Naziv);
end$$
delimiter ;

delimiter $$
create procedure kreiraj_polisa_osiguranja (in IdPolisa int, in OdobrenIznos double(8,2), in PeriodReklamacije int, in PJIB varchar(30), in PIdProdaja int)
begin
	insert into polisaosiguranja values(IdPolisa, OdobrenIznos, PeriodReklamacije, (SELECT JIB FROM osiguravajuce_drustvo WHERE JIB=PJIB), (SELECT IdProdaja FROM prodaja WHERE IdProdaja=PIdProdaja) );
end$$
delimiter ;


delimiter $$
create procedure kreiraj_naplata_kupovine (in BrojNaplateKupovine int, in PIdProdaja int, in PBrojZiroRacunaPreduzeca varchar(30), in DatumNaplate date)
begin
	insert into naplata_kupovine values(BrojNaplateKupovine,  (SELECT IdProdaja FROM prodaja WHERE IdProdaja=PIdProdaja), (SELECT BrojZiroRacunaPreduzeca FROM ziro_racun_preduzeca WHERE BrojZiroRacunaPreduzeca=PBrojZiroRacunaPreduzeca), DatumNaplate);
end$$
delimiter ;

delimiter $$
create procedure kreiraj_distributeri_vozila(in PIdKlijenta int, in Rejting varchar(60))
begin
	insert into distributer_vozila values((SELECT IdKlijenta FROM klijent WHERE IdKlijenta=PIdKlijenta), Rejting);
end$$
delimiter ;

delimiter $$
create procedure kreiraj_korisnici_servisa(in PIdKlijenta int, in NapomenaOKorisniku varchar(60))
begin
	insert into korisnici_servisa values((SELECT IdKlijenta FROM klijent WHERE IdKlijenta=PIdKlijenta), NapomenaOKorisniku);
end$$
delimiter ;

delimiter $$
create procedure kreiraj_zahtjev(in BrojZahtjeva int, in PIdKlijenta int, in DatumZahtjeva date, KrajnjiRok date, PJMB varchar(30))
begin
	insert into zahtjev values(BrojZahtjeva,(SELECT IdKlijenta FROM korisnici_servisa WHERE IdKlijenta=PIdKlijenta), DatumZahtjeva, KrajnjiRok,(SELECT JMB FROM rukovodilac_servisa WHERE JMB=PJMB));
end$$
delimiter ;

delimiter $$
create procedure kreiraj_servisna_knjiga_vozila(in BrojKarticeVozila int, in PIdVozila int, in PBrojZahtjeva int, in UkupanBrojServisa int, in DatumPoslednjegServisa date, in OpisRanijihPopravki varchar(100), in Status varchar(30), in OpisProblema varchar(100))
begin
	insert into servisna_knjiga_vozila values(BrojKarticeVozila,(SELECT IdVozila FROM vozila WHERE IdVozila=PIdVozila), (SELECT BrojZahtjeva FROM zahtjev WHERE BrojZahtjeva=PBrojZahtjeva), UkupanBrojServisa, DatumPoslednjegServisa, OpisRanijihPopravki, Status, OpisProblema);
end$$
delimiter ;

delimiter $$
create procedure kreiraj_dobavljac (in PIdKlijenta int, in InternetStranica varchar(100))
begin
	insert into dobavljac values((SELECT IdKlijenta FROM klijent WHERE IdKlijenta=PIdKlijenta), InternetStranica);
end$$
delimiter ;

delimiter $$
create procedure kreiraj_vozilo_na_servisu(in IdVozilaNaServisu int,
  in PJMB varchar(30), in PIdKarticaVozila int, in DatumPrijemaVozila date,
  ProcjenaTroSkova double(8,2), ProcjenaZavrsetkaRadova date)
begin
	insert into vozilo_na_servisu values(IdVozilaNaServisu,(SELECT JMB FROM rukovodilac_servisa WHERE JMB=PJMB), (SELECT IdKarticaVozila FROM servisna_knjiga_vozila WHERE IdKarticaVozila=PIdKarticaVozila), DatumPrijemaVozila, ProcjenaTroSkova, ProcjenaZavrsetkaRadova);
end$$
delimiter ;

delimiter $$
create procedure kreiraj_dijelovi_i_materijali (in NazivDijela varchar(30), in Cijena int, in Tip varchar(30), in Proizvodjac varchar(30), in KolicinaNaSkladistu int)
begin
	insert into dijelovi_i_materijali values(NazivDijela, Cijena, Tip, Proizvodjac, KolicinaNaSkladistu);
end$$
delimiter ;

delimiter $$
create procedure kreiraj_dodatne_usluge (in TipUsluge varchar(30), in CijenaDodatneUsluge int)
begin
	insert into dodatne_usluge values(TipUsluge, CijenaDodatneUsluge);
end$$
delimiter ;

delimiter $$
create procedure kreiraj_naplata_servisa (in BrojNaplateServisa int, in Popust double(8,2), in PIdVozilaNaServisu int, in DatumNaplate date, in Iznos double(8,2), in PBrojZiroRacunaPreduzeca varchar(30), in UkupnaCijenaDodatnihUsluga double(8,2), in Status varchar(30))
begin
	insert into naplata_servisa values(BrojNaplateServisa, Popust, (SELECT IdVozilaNaServisu FROM vozilo_na_servisu WHERE IdVozilaNaServisu=PIdVozilaNaServisu), DatumNaplate, Iznos, (SELECT BrojZiroRacunaPreduzeca FROM ziro_racun_preduzeca WHERE BrojZiroRacunaPreduzeca=PBrojZiroRacunaPreduzeca), UkupnaCijenaDodatnihUsluga, Status);
end$$
delimiter ;

delimiter $$
create procedure kreiraj_radni_nalog (in IdRadniNalog int, in PIdVozilaNaServisu int, in PVrstaServisnihRadova varchar(100), in Termin varchar(30))
begin
	insert into radni_nalog values(IdRadniNalog, (SELECT IdVozilaNaServisu FROM vozilo_na_servisu WHERE IdVozilaNaServisu=PIdVozilaNaServisu), (SELECT VrstaServisnihRadova FROM servisni_radovi WHERE VrstaServisnihRadova=PVrstaServisnihRadova), Termin);
end$$
delimiter ;

delimiter $$
create procedure kreiraj_realizacija (in PIdRadniNalog int, in PJMB varchar(30), in DatumRealizacije date)
begin
	insert into realizacija values((SELECT IdRadniNalog FROM radni_nalog WHERE IdRadniNalog=PIdRadniNalog)
, (SELECT JMB FROM mehanicar WHERE JMB=PJMB)
, DatumRealizacije);
end$$
delimiter ;

delimiter $$
create procedure kreiraj_usluga (in BrojUsluge int, in PIdRadniNalog int, in PBrojNaplateServisa int, in CijenaUsluge double(8,2), in BrojUtrošenihSati double(8,2), in KoeficijentRadova double(8,2), in CijenaDijelova double(8,2))
begin
	insert into usluga values(BrojUsluge, (SELECT IdRadniNalog FROM radni_nalog WHERE IdRadniNalog=PIdRadniNalog)
, (SELECT BrojNaplateServisa FROM naplata_servisa WHERE BrojNaplateServisa=PBrojNaplateServisa)
, CijenaUsluge, BrojUtrošenihSati, KoeficijentRadova, CijenaDijelova);
end$$
delimiter ;

delimiter $$
create procedure kreiraj_izdavanje (in PJMB varchar(30), in PNazivDijela varchar(30), in PBrojUsluge int, in PBrojNaplateServisa int, in KolicinaUtrosenogDijela int)
begin
	insert into izdavanje values((SELECT JMB FROM rukovodilac_skladista WHERE JMB=PJMB)
, (SELECT NazivDijela FROM dijelovi_i_materijali WHERE NazivDijela=PNazivDijela)
, (SELECT BrojUsluge FROM usluga WHERE BrojUsluge=PBrojUsluge AND BrojNaplateServisa=PBrojNaplateServisa), (SELECT BrojNaplateServisa FROM usluga WHERE BrojUsluge=PBrojUsluge AND BrojNaplateServisa=PBrojNaplateServisa), KolicinaUtrosenogDijela);
end$$
delimiter ;

delimiter $$
create procedure kreiraj_nabavka_vozila (in PIdVozila int, in DatumNabavke date, in CijenaNabavke double(8,2), in PIdKlijenta int)
begin
	insert into nabavka_vozila values((SELECT IdVozila FROM vozila_u_vlasnistvu WHERE IdVozila=PIdVozila), DatumNabavke, CijenaNabavke, (SELECT IdKlijenta FROM distributer_vozila WHERE IdKlijenta=PIdKlijenta) );
end$$
delimiter ;

create view prikaz_kupaca as
	select IdKlijenta, TipKategorije, Ime, Prezime, Naziv, Adresa, Grad, E_mail 
	from kategorija_klijenta kk	
		inner join klijent kl on kk.IdKategorija=kl.IdKategorija left outer join individualno_lice il
		on il.IdKategorija=kk.IdKategorija left outer join kompanija ko
		on ko.IdKategorija=kk.IdKategorija 
	where TipKlijenta='kupac' ;

create view prikaz_vozila_u_vlasnistvu as
	select IdVozila, TipVozila, concat(Proizvodjac, ' ' , Model) as 'Proizvodjac i model', GodinaProizvodnje, DatumNabavke, 	CijenaNabavke, Status_Za_Prodaju
	from vozila natural join vozila_u_vlasnistvu ;

create view prikaz_klijenata as				
	select IdKlijenta, TipKlijenta, TipKategorije, Ime, Prezime, Naziv, Adresa, Grad, E_mail 
	from kategorija_klijenta kk	inner join klijent kl on kk.IdKategorija=kl.IdKategorija left outer join individualno_lice il
		on il.IdKategorija=kk.IdKategorija left outer join kompanija ko	on ko.IdKategorija=kk.IdKategorija;	

create view prikaz_vozila as					
	select vozila.IdVozila, TipVozila, Proizvodjac, Model, GodinaProizvodnje, VrstaGoriva, BrojRegistracije, Fotografija, 	
		Status_Za_Prodaju, CijenaNabavke 
	from vozila left outer join vozila_u_vlasnistvu on vozila.IdVozila=vozila_u_vlasnistvu.IdVozila;
			
create view prikaz_vozila_2 as					
	select vozila.IdVozila, TipVozila, Proizvodjac, Model, GodinaProizvodnje, VrstaGoriva, BrojRegistracije, Fotografija, 	
		Status_Za_Prodaju, CijenaNabavke, CijenaProdaje 
	from vozila left outer join vozila_u_vlasnistvu on vozila.IdVozila=vozila_u_vlasnistvu.IdVozila 
		left outer join prodata_vozila on vozila.IdVozila=prodata_vozila.IdVozila
	where Status_Za_Prodaju!="Prodato" or Status_Za_Prodaju is null;
			

drop trigger if exists azuriraj_prodaju ;
create trigger azuriraj_prodaju before insert
	on prodaja
	for each row
	update prodavac
	set brojProdatihVozila=brojProdatihVozila+1
	where JMB=new.JMB;
	
drop trigger if exists obrisi_aktivnost_mehanicaru ;
create trigger obrisi_aktivnost_mehanicaru before delete
	on realizacija
	for each row
	update mehanicar
	set trenutniBrojAktivnosti=trenutniBrojAktivnosti-1
	where JMB=OLD.JMB;
			