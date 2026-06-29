package data.dao.mysql.prodaja_vozila;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.ConnectionPool;
import data.dao.prodaja_vozila.KupacDAO;
import data.dto.prodaja_vozila.KlijentDTO;
import data.dto.prodaja_vozila.KupacDTO;
import javafx.collections.ObservableList;
import utility.DBUtilities;
import utility.PSVUtilities;

public class MySQLKupacDAO implements KupacDAO {

	@Override
	public KupacDTO kupac(int idKlijent) {
		KupacDTO retVal = null;

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String query = "SELECT * from kupac where IdKlijenta=? ";

		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			ps.setInt(1, idKlijent);
			rs = ps.executeQuery();

			if (rs.next()) {
				KlijentDTO kl = PSVUtilities.getDAOFactory().getKlijentDAO().klijent(rs.getInt(1));
				retVal = new KupacDTO(kl);
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

	@Override
	public ObservableList<KupacDTO> kupac() {
		return null;
	}

	@Override
	public boolean dodajKupac(KupacDTO kupac) {
		boolean retVal = false;
		Connection conn = null;
		PreparedStatement ps = null;

		String query = "call kreiraj_kupac" + "(?)";
		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			ps.setInt(1, kupac.getKlijent().getIdKlijenta());

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
	public boolean azurirajKupac(KupacDTO kupac) {
		return false;
	}

	@Override
	public boolean obrisiKupac(int idKlijenta) {
		return false;
	}

}
