package data.dao.mysql.prodaja_vozila;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connection.ConnectionPool;
import data.dao.prodaja_vozila.OsiguravajuceDrustvoDAO;
import data.dto.prodaja_vozila.OsiguravajuceDrustvoDTO;
import javafx.collections.ObservableList;
import utility.DBUtilities;

public class MySQLOsiguravajuceDrustvoDAO implements OsiguravajuceDrustvoDAO {

	@Override
	public OsiguravajuceDrustvoDTO osiguravajuceDrustvo(String jib) {
		return null;
	}

	@Override
	public ObservableList<OsiguravajuceDrustvoDTO> osiguravajuceDrustvo() {
		return null;
	}

	@Override
	public boolean dodajOsiguravajuceDrustvo(OsiguravajuceDrustvoDTO osiguravajuceDrustvo) {
		boolean retVal = false;
		Connection conn = null;
		PreparedStatement ps = null;

		String query = "call kreiraj_osiguravajucedrustvo" + "(?, ?)";
		try {
			conn = ConnectionPool.getInstance().checkOut();

			ps = conn.prepareStatement(query);
			ps.setString(1, osiguravajuceDrustvo.getJib());
			ps.setString(2, osiguravajuceDrustvo.getNaziv());

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
	public boolean azurirajOsiguravajuceDrustvo(OsiguravajuceDrustvoDTO osiguravajuceDrustvo) {
		boolean retVal = false;
		Connection conn = null;
		PreparedStatement ps = null;

		String query = "UPDATE osiguravajuce_drustvo SET " + "Naziv=? " + "WHERE JIB=? ";
		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			ps.setString(1, osiguravajuceDrustvo.getNaziv());
			ps.setString(2, osiguravajuceDrustvo.getJib());

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
	public boolean obrisiOsiguravajuceDrustvo(String jib) {
		return false;
	}

}
