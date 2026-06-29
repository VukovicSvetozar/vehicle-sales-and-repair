package table;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.ConnectionPool;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utility.DBUtilities;

public class MySQLTableKlijent {

	public static TableKlijent tabelaKlijenata(int idKlijent) {
		TableKlijent retVal = null;

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String query = "SELECT * from prikaz_klijenata where IdKlijenta=? ";

		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			ps.setInt(1, idKlijent);
			rs = ps.executeQuery();

			if (rs.next()) {
				
				String naziv = "";
				if (rs.getString(3).equals("Individualno lice"))
					naziv = rs.getString(4) + " " + rs.getString(5);
				else
					naziv = rs.getString(6);
				
				retVal = new TableKlijent(rs.getInt(1), rs.getString(2), rs.getString(3), naziv, rs.getString(7) + " " + rs.getString(8),
						rs.getString(9));
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

	public static ObservableList<TableKlijent> tabelaKlijenata() {
		ObservableList<TableKlijent> retVal = FXCollections.observableArrayList();

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String query = "SELECT * from prikaz_klijenata";
		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next()) {
				TableKlijent kupac = new TableKlijent();

				kupac.setIdKlijenta(rs.getInt(1));
				kupac.setTipKlijenta(rs.getString(2));
				kupac.setTipKategorije(rs.getString(3));
				if (kupac.getTipKategorije().equals("Individualno lice"))
					kupac.setNaziv(rs.getString(4) + " " + rs.getString(5));
				else
					kupac.setNaziv(rs.getString(6));
				kupac.setAdresaKupca(rs.getString(7) + " " + rs.getString(8));
				kupac.setEmail(rs.getString(9));

				retVal.add(kupac);
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
