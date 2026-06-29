package data.dao.mysql.prodaja_vozila;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connection.ConnectionPool;
import data.dao.prodaja_vozila.IndividualnoLiceDAO;
import data.dto.prodaja_vozila.IndividualnoLiceDTO;
import javafx.collections.ObservableList;
import utility.DBUtilities;

public class MySQLIndividualnoLiceDAO implements IndividualnoLiceDAO {

	@Override
	public IndividualnoLiceDTO individualnoLice(int idKategorija) {
		return null;
	}

	@Override
	public ObservableList<IndividualnoLiceDTO> individualnoLice() {
		return null;
	}

	@Override
	public boolean dodajIndividualnoLice(IndividualnoLiceDTO individualnoLice) {
		boolean retVal = false;
		Connection conn = null;
		PreparedStatement ps = null;

		String query = "call kreiraj_individualno_lice" + "(?, ?, ?, ?)";
		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			ps.setInt(1, individualnoLice.getKategorijaKlijenta().getIdKategorija());
			ps.setString(2, individualnoLice.getIme());
			ps.setString(3, individualnoLice.getPrezime());
			ps.setString(4, individualnoLice.getPol());

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
	public boolean azurirajIndividualnoLice(IndividualnoLiceDTO individualnoLice) {
		return false;
	}

	@Override
	public boolean obrisiIndividualnoLice(int idKategorija) {
		return false;
	}

}
