package table;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.ConnectionPool;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utility.DBUtilities;

public class MySQLTableKupac {

	public static TableKupac tabelaKupaca(int idKlijent) {
		TableKupac retVal = null;

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String query = "SELECT * from prikaz_kupaca where IdKlijenta=? ";

		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			ps.setInt(1, idKlijent);
			rs = ps.executeQuery();

			if (rs.next()) {
				String naziv = "";
				if (rs.getString(2).equals("Individualno lice"))
					naziv = rs.getString(3) + " " + rs.getString(4);
				else
					naziv = rs.getString(5);
				
				retVal = new TableKupac(rs.getInt(1), rs.getString(2), naziv, rs.getString(6) + " " + rs.getString(7),
						rs.getString(8));
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

	public static ObservableList<TableKupac> tabelaKupaca() {
		ObservableList<TableKupac> retVal = FXCollections.observableArrayList();

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String query = "SELECT * from prikaz_kupaca";
		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next()) {
				TableKupac kupac = new TableKupac();

				kupac.setIdKlijenta(rs.getInt(1));
				kupac.setTipKategorije(rs.getString(2));
				if (kupac.getTipKategorije().equals("Individualno lice"))
					kupac.setNaziv(rs.getString(3) + " " + rs.getString(4));
				else
					kupac.setNaziv(rs.getString(5));
				kupac.setAdresaKupca(rs.getString(6) + " " + rs.getString(7));
				kupac.setEmail(rs.getString(8));

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
