package data.dao.mysql.prodaja_vozila;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import connection.ConnectionPool;
import data.dao.prodaja_vozila.KlijentDAO;
import data.dto.prodaja_vozila.KategorijaKlijentaDTO;
import data.dto.prodaja_vozila.KlijentDTO;
import javafx.collections.ObservableList;
import utility.DBUtilities;
import utility.PSVUtilities;

public class MySQLKlijentDAO implements KlijentDAO {
	
	@Override
	public KlijentDTO klijent(int idKlijenta) {

		KlijentDTO retVal = null;

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String query = "SELECT * from klijent where IdKlijenta=? ";

		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			ps.setInt(1, idKlijenta);
			rs = ps.executeQuery();
			
			if (rs.next()) {
				KategorijaKlijentaDTO kk = PSVUtilities.getDAOFactory().getKategorijaKlijentaDAO().kategorijaKlijenta(rs.getInt(2));
				retVal = new KlijentDTO(rs.getInt(1), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), kk);
			}
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
	public ObservableList<KlijentDTO> klijent() {
		return null;
	}

	@Override
	public int dodajKlijent(KlijentDTO klijent) {
		Connection conn = null;
		PreparedStatement ps = null;
		int user_id = 0;
		String query = "call kreiraj_klijent" + "(?, ?, ?, ?, ?, ?, ?)";
		try {
			conn = ConnectionPool.getInstance().checkOut();
			PreparedStatement pst1 = conn.prepareStatement("select max(IdKlijenta)+1 from klijent");
			ResultSet rs = pst1.executeQuery();

			while (rs.next()) {
				user_id = rs.getInt(1);
			}
			ps = conn.prepareStatement(query);
			ps.setInt(1, user_id);
			ps.setInt(2, klijent.getKategorijaKlijenta().getIdKategorija());
			ps.setString(3, klijent.getTipKlijenta());
			ps.setString(4, klijent.getAdresa());
			ps.setString(5, klijent.getGrad());
			ps.setString(6, klijent.getDrzava());
			ps.setString(7, klijent.getEmail());
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
	public boolean azurirajKlijent(KlijentDTO klijent) {
		return false;
	}

	@Override
	public boolean obrisiKlijent(int idKlijenta) {
		return false;
	}

}
