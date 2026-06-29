package data.dao.mysql.prodaja_vozila;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connection.ConnectionPool;
import data.dao.prodaja_vozila.ZiroRacunKlijentaDAO;
import data.dto.prodaja_vozila.ZiroRacunKlijentaDTO;
import javafx.collections.ObservableList;
import utility.DBUtilities;

public class MySQLZiroRacunKlijentaDAO implements ZiroRacunKlijentaDAO {

	@Override
	public ZiroRacunKlijentaDTO ziroRacunKlijenta(String brojZiroRacuna) {
		return null;
	}

	@Override
	public ObservableList<ZiroRacunKlijentaDTO> ziroRacunKlijenta() {
		return null;
	}

	@Override
	public boolean dodajZiroRacunKlijenta(ZiroRacunKlijentaDTO ziroRacunKlijenta) {
		boolean retVal = false;
		Connection conn = null;
		PreparedStatement ps = null;

		String query = "call kreiraj_ziro_racun_klijenta" + "(?, ?)";
		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			ps.setString(1, ziroRacunKlijenta.getBrojZiroRacuna());
			ps.setInt(2, ziroRacunKlijenta.getKlijent().getIdKlijenta());

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
	public boolean azurirajZiroRacunKlijenta(ZiroRacunKlijentaDTO ziroRacunKlijenta) {
		return false;
	}

	@Override
	public boolean obrisiZiroRacunKlijenta(String brojZiroRacuna) {
		return false;
	}

}
