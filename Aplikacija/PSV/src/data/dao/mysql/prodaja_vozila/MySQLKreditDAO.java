package data.dao.mysql.prodaja_vozila;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.ConnectionPool;
import data.dao.prodaja_vozila.KreditDAO;
import data.dto.prodaja_vozila.KreditDTO;
import javafx.collections.ObservableList;
import utility.DBUtilities;

public class MySQLKreditDAO implements KreditDAO {

	@Override
	public KreditDTO kredit(int IdKredit) {
		return null;
	}

	@Override
	public ObservableList<KreditDTO> kredit() {
		return null;
	}

	@Override
	public boolean dodajKredit(KreditDTO kredit) {
		boolean retVal = false;
		Connection conn = null;
		PreparedStatement ps = null;
		int id = 0;
		String query = "call kreiraj_kredit" + "(?, ?, ?, ?, ?)";
		try {
			conn = ConnectionPool.getInstance().checkOut();
			PreparedStatement pst1 = conn.prepareStatement("select max(IdKredit)+1 from kredit");
			ResultSet rs = pst1.executeQuery();

			while (rs.next()) {
				id = rs.getInt(1);
			}
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ps.setDouble(2, kredit.getIznosRateKredita());
			ps.setInt(3, kredit.getBrojRata());
			ps.setString(4, kredit.getBanka().getJib());
			ps.setInt(5, kredit.getProdaja().getIdProdaja());

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
	public boolean azurirajKredit(KreditDTO kredit) {
		return false;
	}

	@Override
	public boolean obrisiKredit(int idKredit) {
		return false;
	}

}
