package data.dao.mysql.servis_vozila;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.ConnectionPool;
import data.dao.servis_vozila.ZahtjevDAO;
import data.dto.servis_vozila.KorisniciServisaDTO;
import data.dto.servis_vozila.ZahtjevDTO;
import data.dto.zaposleni.RukovodilacServisaDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utility.DBUtilities;
import utility.PSVUtilities;

public class MySQLZahtjevDAO implements ZahtjevDAO {

	@Override
	public ZahtjevDTO zahtjev(int brojZahtjeva) {
		ZahtjevDTO retVal = null;

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String query = "SELECT * from zahtjev where BrojZahtjeva=? ";

		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			ps.setInt(1, brojZahtjeva);
			rs = ps.executeQuery();

			if (rs.next()) {
				KorisniciServisaDTO ks = PSVUtilities.getDAOFactory().getKorisniciServisaDAO().korisniciServisa(rs.getInt(2));
				RukovodilacServisaDTO rsv = PSVUtilities.getDAOFactory().getRukovodilacServisaDAO().rukovodilacServisa(rs.getString(5));
				retVal = new ZahtjevDTO(rs.getInt(1), ks, rs.getDate(3), rs.getDate(4), rsv);
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
	public ObservableList<ZahtjevDTO> zahtjev() {
		ObservableList<ZahtjevDTO> retVal = FXCollections.observableArrayList();

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String query = "SELECT * from zahtjev";
		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next()) {
				KorisniciServisaDTO ks = PSVUtilities.getDAOFactory().getKorisniciServisaDAO().korisniciServisa(rs.getInt(2));
				RukovodilacServisaDTO rsv = PSVUtilities.getDAOFactory().getRukovodilacServisaDAO().rukovodilacServisa(rs.getString(5));
				retVal.add(new ZahtjevDTO(rs.getInt(1), ks, rs.getDate(3), rs.getDate(4), rsv));
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
	public int dodajZahtjev(ZahtjevDTO zahtjev) {
		Connection conn = null;
		PreparedStatement ps = null;
		int user_id = 0;
		String query = "call kreiraj_zahtjev" + "(?, ?, ?, ?, ?)";
		try {
			conn = ConnectionPool.getInstance().checkOut();

			PreparedStatement pst1 = conn.prepareStatement("select max(BrojZahtjeva)+1 from zahtjev");
			ResultSet rs = pst1.executeQuery();

			while (rs.next()) {
				user_id = rs.getInt(1);
			}
			ps = conn.prepareStatement(query);
			ps.setInt(1, user_id);
			ps.setInt(2, zahtjev.getKorisnikServisa().getKlijent().getIdKlijenta());
			ps.setDate(3, zahtjev.getDatumZahtjeva());
			ps.setDate(4, zahtjev.getKrajnjiRok());
			ps.setString(5, zahtjev.getRukovodilacServisa().getZaposleni().getJmb());

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
	public boolean azurirajZahtjev(ZahtjevDTO zahtjev) {
		return false;
	}

	@Override
	public boolean obrisiZahtjev(int brojZahtjeva) {
		return false;
	}

}
