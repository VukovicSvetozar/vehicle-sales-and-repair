package data.dao.mysql.prodaja_vozila;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import connection.ConnectionPool;
import data.dao.prodaja_vozila.KompanijaDAO;
import data.dto.prodaja_vozila.KompanijaDTO;
import javafx.collections.ObservableList;
import utility.DBUtilities;

public class MySQLKompanijaDAO implements KompanijaDAO {

	@Override
	public KompanijaDTO kompanija(int idKategorija) {
		return null;
	}

	@Override
	public ObservableList<KompanijaDTO> kompanija() {
		return null;
	}

	@Override
	public boolean dodajKompanija(KompanijaDTO kompanija) {
		boolean retVal = false;
		Connection conn = null;
		PreparedStatement ps = null;

		String query = "call kreiraj_kompanija" + "(?, ?, ?)";
		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			ps.setInt(1, kompanija.getKategorijaKlijenta().getIdKategorija());
			ps.setString(2, kompanija.getNaziv());
			ps.setString(3, kompanija.getInternetStranica());

			retVal = ps.executeUpdate() == 1;
		} catch (SQLException e) {
			e.printStackTrace();
			DBUtilities.getInstance().showSQLException(e);
		} finally {
			ConnectionPool.getInstance().checkIn(conn);
			DBUtilities.getInstance().close(ps);
		}
		return retVal;
	}

	@Override
	public boolean azurirajKompanija(KompanijaDTO kompanija) {
		return false;
	}

	@Override
	public boolean obrisiKompanija(int idKategorija) {
		return false;
	}

}
