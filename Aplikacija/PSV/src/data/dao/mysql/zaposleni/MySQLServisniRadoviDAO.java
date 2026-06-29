package data.dao.mysql.zaposleni;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.ConnectionPool;
import data.dao.zaposleni.ServisniRadoviDAO;
import data.dto.zaposleni.ServisniRadoviDTO;
import javafx.collections.ObservableList;
import utility.DBUtilities;

public class MySQLServisniRadoviDAO implements ServisniRadoviDAO {

	@Override
	public ServisniRadoviDTO servisniRadovi(String vrstaServisnihRadova) {
		ServisniRadoviDTO retVal = null;

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String query = "SELECT * from servisni_radovi where VrstaServisnihRadova=? ";

		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			ps.setString(1, vrstaServisnihRadova);
			rs = ps.executeQuery();

			if (rs.next()) 
				retVal = new ServisniRadoviDTO(rs.getString(1), rs.getDouble(2));
		}

		catch (SQLException e) {
			e.printStackTrace();
			DBUtilities.getInstance().showSQLException(e);
		} finally {
			ConnectionPool.getInstance().checkIn(conn);
			DBUtilities.getInstance().close(ps, rs);
		}

		return retVal;
	}

	@Override
	public ObservableList<ServisniRadoviDTO> servisniRadovi() {
		return null;
	}

	@Override
	public boolean dodajServisniRadovi(ServisniRadoviDTO servisniRadovi) {
		return false;
	}

	@Override
	public boolean azurirajServisniRadovi(ServisniRadoviDTO servisniRadovi) {
		return false;
	}

	@Override
	public boolean obrisiServisniRadovi(String vrstaServisnihRadova) {
		return false;
	}

}
