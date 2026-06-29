package data.dao.mysql.prodaja_vozila;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.ConnectionPool;
import data.dao.prodaja_vozila.PolisaOsiguranjaDAO;
import data.dto.prodaja_vozila.PolisaOsiguranjaDTO;
import javafx.collections.ObservableList;
import utility.DBUtilities;

public class MySQLPolisaOsiguranjaDAO implements PolisaOsiguranjaDAO {

	@Override
	public PolisaOsiguranjaDTO polisaOsiguranja(int idPolisa) {
		return null;
	}

	@Override
	public ObservableList<PolisaOsiguranjaDTO> polisaOsiguranja() {
		return null;
	}

	@Override
	public boolean dodajPolisaOsiguranja(PolisaOsiguranjaDTO polisaOsiguranja) {
		boolean retVal = false;
		Connection conn = null;
		PreparedStatement ps = null;
		int id = 0;
		String query = "call kreiraj_polisa_osiguranja" + "(?, ?, ?, ?, ?)";
		try {
			conn = ConnectionPool.getInstance().checkOut();
			PreparedStatement pst1 = conn.prepareStatement("select max(IdPolisa)+1 from polisaosiguranja");
			ResultSet rs = pst1.executeQuery();

			while (rs.next()) {
				id = rs.getInt(1);
			}
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ps.setDouble(2, polisaOsiguranja.getOdobrenIznos());
			ps.setInt(3, polisaOsiguranja.getPeriodReklamacije());
			ps.setString(4, polisaOsiguranja.getOsiguravajuceDrustvo().getJib());
			ps.setInt(5, polisaOsiguranja.getProdaja().getIdProdaja());
			
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
	public boolean azurirajPolisaOsiguranja(PolisaOsiguranjaDTO polisaOsiguranja) {
		return false;
	}

	@Override
	public boolean obrisiPolisaOsiguranja(int idPolisa) {
		return false;
	}

}
