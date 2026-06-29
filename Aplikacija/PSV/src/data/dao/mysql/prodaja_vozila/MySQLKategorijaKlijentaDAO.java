package data.dao.mysql.prodaja_vozila;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.ConnectionPool;
import data.dao.prodaja_vozila.KategorijaKlijentaDAO;
import data.dto.prodaja_vozila.KategorijaKlijentaDTO;
import javafx.collections.ObservableList;
import utility.DBUtilities;

public class MySQLKategorijaKlijentaDAO implements KategorijaKlijentaDAO {

	@Override
	public KategorijaKlijentaDTO kategorijaKlijenta(int idKategorija) {

		KategorijaKlijentaDTO retVal = null;

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String query = "SELECT * from kategorija_klijenta where IdKategorija=? ";

		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			ps.setInt(1, idKategorija);
			rs = ps.executeQuery();

			if (rs.next())
				retVal = new KategorijaKlijentaDTO(rs.getInt(1), rs.getString(2));
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
	public ObservableList<KategorijaKlijentaDTO> kategorijaKlijenta() {
		return null;
	}

	@Override
	public int dodajKategorijaKlijenta(KategorijaKlijentaDTO kategorijaKlijenta) {
		Connection conn = null;
		PreparedStatement ps = null;
		int user_id = 0;
		String query = "call kreiraj_kategorija_klijenta" + "(?, ?)";
		try {
			conn = ConnectionPool.getInstance().checkOut();

			PreparedStatement pst1 = conn.prepareStatement("select max(IdKategorija)+1 from kategorija_klijenta");
			ResultSet rs = pst1.executeQuery();

			while (rs.next()) {
				user_id = rs.getInt(1);
			}
			ps = conn.prepareStatement(query);
			ps.setInt(1, user_id);
			ps.setString(2, kategorijaKlijenta.getTipKategorije());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			DBUtilities.getInstance().showSQLException(e);
		} finally {
			ConnectionPool.getInstance().checkIn(conn);
			DBUtilities.getInstance().close(ps);
		}
		return user_id;
	}

	@Override
	public boolean azurirajKategorijaKlijenta(KategorijaKlijentaDTO kategorijaKlijenta) {
		return false;
	}

	@Override
	public boolean obrisiKategorijaKlijenta(int idKategorija) {
		return false;
	}

}
