package table;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.ConnectionPool;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utility.DBUtilities;

public class MySQLTableKorisnikServisa {

	public static ObservableList<TableKorisnikServisa> tabelaKorisnikaServisa() {
		ObservableList<TableKorisnikServisa> retVal = FXCollections.observableArrayList();

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String query = "select IdKlijenta, TipKategorije, Ime, Prezime, Naziv \r\n" + 
				"	from kategorija_klijenta kk	\r\n" + 
				"		inner join klijent kl on kk.IdKategorija=kl.IdKategorija left outer join individualno_lice il\r\n" + 
				"		on il.IdKategorija=kk.IdKategorija left outer join kompanija ko\r\n" + 
				"		on ko.IdKategorija=kk.IdKategorija \r\n" + 
				"	where TipKlijenta='Korisnik servisa' ;";
		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next()) {
				TableKorisnikServisa korisnikServisa = new TableKorisnikServisa();

				korisnikServisa.setIdKlijenta(rs.getInt(1));
				korisnikServisa.setTipKategorije(rs.getString(2));
				if (korisnikServisa.getTipKategorije().equals("Individualno lice"))
					korisnikServisa.setNaziv(rs.getString(3) + " " + rs.getString(4));
				else
					korisnikServisa.setNaziv(rs.getString(5));

				retVal.add(korisnikServisa);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			DBUtilities.getInstance().showSQLException(e);
		} finally {
			ConnectionPool.getInstance().checkIn(conn);
			DBUtilities.getInstance().close(ps, rs);
		}

		return retVal;

	}

}
