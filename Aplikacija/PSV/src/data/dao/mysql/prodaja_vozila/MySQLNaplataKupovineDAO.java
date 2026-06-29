package data.dao.mysql.prodaja_vozila;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.ConnectionPool;
import data.dao.prodaja_vozila.NaplataKupovineDAO;
import data.dto.prodaja_vozila.NaplataKupovineDTO;
import javafx.collections.ObservableList;
import utility.DBUtilities;

public class MySQLNaplataKupovineDAO implements NaplataKupovineDAO {

	@Override
	public NaplataKupovineDTO naplataKupovine(int brojNaplateKupovine) {
		return null;
	}

	@Override
	public ObservableList<NaplataKupovineDTO> naplataKupovine() {
		return null;
	}

	@Override
	public boolean dodajNaplataKupovine(NaplataKupovineDTO naplataKupovine) {
		boolean retVal = false;
		Connection conn = null;
		PreparedStatement ps = null;
		int id = 0;
		String query = "call kreiraj_naplata_kupovine" + "(?, ?, ?, ?)";
		try {
			conn = ConnectionPool.getInstance().checkOut();
			PreparedStatement pst1 = conn.prepareStatement("select max(BrojNaplateKupovine)+1 from naplata_kupovine");
			ResultSet rs = pst1.executeQuery();

			while (rs.next()) {
				id = rs.getInt(1);
			}
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ps.setInt(2, naplataKupovine.getProdaja().getIdProdaja());
			ps.setString(3, naplataKupovine.getZiroracunpreduzeca().getBrojZiroRacunaPreduzeca());
			ps.setDate(4, naplataKupovine.getDatumNaplate());
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
	public boolean azurirajNaplataKupovine(NaplataKupovineDTO naplataKupovine) {
		return false;
	}

	@Override
	public boolean obrisiNaplataKupovine(int brojNaplateKupovine) {
		return false;
	}

}
