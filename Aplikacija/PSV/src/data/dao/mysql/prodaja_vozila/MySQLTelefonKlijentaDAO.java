package data.dao.mysql.prodaja_vozila;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connection.ConnectionPool;
import data.dao.prodaja_vozila.TelefonKlijentaDAO;
import data.dto.prodaja_vozila.TelefonKlijentaDTO;
import javafx.collections.ObservableList;
import utility.DBUtilities;

public class MySQLTelefonKlijentaDAO implements TelefonKlijentaDAO {

	@Override
	public TelefonKlijentaDTO telefonKlijenta(String brojTelefona, int idKlijenta) {
		return null;
	}

	@Override
	public ObservableList<TelefonKlijentaDTO> telefonKlijenta() {
		return null;
	}

	@Override
	public boolean dodajTelefonKlijenta(TelefonKlijentaDTO telefonKlijenta) {
		boolean retVal = false;
		Connection conn = null;
		PreparedStatement ps = null;

		String query = "call kreiraj_telefon_klijenta" + "(?, ?, ?)";
		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			ps.setInt(1, telefonKlijenta.getKlijent().getIdKlijenta());
			ps.setString(2, telefonKlijenta.getBrojTelefona());
			ps.setString(3, telefonKlijenta.getOpis());
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
	public boolean azurirajTelefonKlijenta(TelefonKlijentaDTO telefonKlijenta) {
		return false;
	}

	@Override
	public boolean obrisiTelefonKlijenta(String brojTelefona, int idKlijenta) {
		return false;
	}

}
