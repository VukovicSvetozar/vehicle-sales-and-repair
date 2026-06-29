package data.dao.mysql.prodaja_vozila;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.ConnectionPool;
import data.dao.prodaja_vozila.DistributerVozilaDAO;
import data.dto.prodaja_vozila.DistributerVozilaDTO;
import data.dto.prodaja_vozila.KlijentDTO;
import javafx.collections.ObservableList;
import utility.DBUtilities;
import utility.PSVUtilities;

public class MySQLDistributerVozilaDAO implements DistributerVozilaDAO {

	@Override
	public DistributerVozilaDTO distributer(int idKlijent) {
		DistributerVozilaDTO retVal = null;

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String query = "SELECT * from distributer_vozila where IdKlijenta=? ";

		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			ps.setInt(1, idKlijent);
			rs = ps.executeQuery();

			if (rs.next()) {
				KlijentDTO kl = PSVUtilities.getDAOFactory().getKlijentDAO().klijent(rs.getInt(1));
				retVal = new DistributerVozilaDTO(kl, rs.getString(2));
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
	public ObservableList<DistributerVozilaDTO> distributer() {
		return null;
	}

	@Override
	public boolean dodajDistributeraVozila(DistributerVozilaDTO distributer) {
		boolean retVal = false;
		Connection conn = null;
		PreparedStatement ps = null;

		String query = "call kreiraj_distributeri_vozila" + "(?, ?)";
		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			ps.setInt(1, distributer.getKlijent().getIdKlijenta());
			ps.setString(2, distributer.getRejting());
			
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
	public boolean azurirajDistributeraVozila(DistributerVozilaDTO distributer) {
		return false;
	}

	@Override
	public boolean obrisiDistributeraVozila(int idKlijenta) {
		return false;
	}

}
