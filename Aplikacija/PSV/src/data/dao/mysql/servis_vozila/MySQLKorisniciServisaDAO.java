package data.dao.mysql.servis_vozila;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import connection.ConnectionPool;
import data.dao.servis_vozila.KorisniciServisaDAO;
import data.dto.prodaja_vozila.KlijentDTO;
import data.dto.servis_vozila.KorisniciServisaDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utility.DBUtilities;
import utility.PSVUtilities;

public class MySQLKorisniciServisaDAO implements KorisniciServisaDAO {


	@Override
	public KorisniciServisaDTO korisniciServisa(int idKlijent) {
		KorisniciServisaDTO retVal = null;

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String query = "SELECT * from korisnici_servisa where IdKlijenta=? ";

		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			ps.setInt(1, idKlijent);
			rs = ps.executeQuery();

			if (rs.next()) {
				KlijentDTO kl = PSVUtilities.getDAOFactory().getKlijentDAO().klijent(rs.getInt(1));
				retVal = new KorisniciServisaDTO(kl, rs.getString(2));
			}

		} catch (SQLException e) {
			e.printStackTrace();
			DBUtilities.getInstance().showSQLException(e);
		} finally {
			ConnectionPool.getInstance().checkIn(conn);
			DBUtilities.getInstance().close(ps, rs);
		}

		return retVal;
	}
	
	@Override
	public ObservableList<KorisniciServisaDTO> korisniciServisa() {
		ObservableList<KorisniciServisaDTO> retVal = FXCollections.observableArrayList();
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String query = "SELECT IdKlijenta"
				+ "FROM korisnici_servisa ";
		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			//ps.setInt(1, IdKlijenta);
			rs = ps.executeQuery();

			while (rs.next())
				;//retVal.add(new KorisniciServisaDTO(rs.getInt(1),rs.getString(2),rs.getString(3)));
		}  
		catch (SQLException e) {
			e.printStackTrace();
			DBUtilities.getInstance().showSQLException(e);
		}
		finally {
			ConnectionPool.getInstance().checkIn(conn);
			DBUtilities.getInstance().close(ps, rs);
		}

		return retVal;
	}
	
	@Override
	public boolean dodajKorisniciServisa(KorisniciServisaDTO korisniciServisa) {
		boolean retVal = false;
		Connection conn = null;
		PreparedStatement ps = null;

		String query = "call kreiraj_korisnici_servisa"
				+ "(?, ?)";
		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			ps.setInt(1, korisniciServisa.getKlijent().getIdKlijenta());
			ps.setString(2, korisniciServisa.getNapomenaKorisnika());
			
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
	public boolean azurirajKorisniciServisa(KorisniciServisaDTO korisniciServisa) {
		return false;
	}

	@Override
	public boolean obrisiKorisniciServis(int idKlijenta) {
		return false;
	}

}
