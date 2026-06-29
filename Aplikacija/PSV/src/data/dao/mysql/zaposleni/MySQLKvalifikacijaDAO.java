package data.dao.mysql.zaposleni;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.ConnectionPool;
import data.dao.zaposleni.KvalifikacijaDAO;
import data.dto.zaposleni.KvalifikacijaDTO;
import data.dto.zaposleni.MehanicarDTO;
import data.dto.zaposleni.ServisniRadoviDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utility.DBUtilities;
import utility.PSVUtilities;

public class MySQLKvalifikacijaDAO implements KvalifikacijaDAO {

	@Override
	public KvalifikacijaDTO kvalifikacija(String vrstaServisnihRadova, String jmb) {

		KvalifikacijaDTO retVal = null;

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String query = "SELECT * " + "FROM kvalifikacija WHERE VrstaServisnihRadova=? and JMB=? ";
		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			ps.setString(1, vrstaServisnihRadova);
			ps.setString(2, jmb);
			rs = ps.executeQuery();

			ServisniRadoviDTO sr = PSVUtilities.getDAOFactory().getServisniRadoviDAO().servisniRadovi(vrstaServisnihRadova);
			MehanicarDTO meh = PSVUtilities.getDAOFactory().getMehanicarDAO().mehanicar(jmb);
			if (rs.next())
				retVal = new KvalifikacijaDTO(sr, meh, rs.getString(3));
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
	public ObservableList<KvalifikacijaDTO> kvalifikacija() {

		ObservableList<KvalifikacijaDTO> retVal = FXCollections.observableArrayList();

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String query = "SELECT * " + "FROM kvalifikacija ";
		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next()) {
				ServisniRadoviDTO sr = PSVUtilities.getDAOFactory().getServisniRadoviDAO().servisniRadovi(rs.getString(1));
				MehanicarDTO meh = PSVUtilities.getDAOFactory().getMehanicarDAO().mehanicar(rs.getString(2));
				retVal.add(new KvalifikacijaDTO(sr, meh, rs.getString(3)));
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
	public boolean dodajKvalifikacija(KvalifikacijaDTO kvalifikacija) {
		boolean retVal = false;
		Connection conn = null;
		PreparedStatement ps = null;

		String query = "call kreiraj_kvalifikacija" + "(?, ?, ?)";
		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			ps.setString(1, kvalifikacija.getServisniRadovi().getVrstaServisnihRadova());
			ps.setString(2, kvalifikacija.getMehanicar().getZaposleni().getJmb());
			ps.setString(3, kvalifikacija.getOpis());

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
	public boolean azurirajKvalifikacija(KvalifikacijaDTO kvalifikacija) {
		return false;
	}

	@Override
	public boolean obrisiKvalifikacija(String vrstaServisnihRadova, String jmb) {
		boolean retVal = false;
		Connection conn = null;
		PreparedStatement ps = null;

		String query = "DELETE FROM kvalifikacija " + "WHERE VrstaServisnihRadova=? and JMB=?";
		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			ps.setString(1, vrstaServisnihRadova);
			ps.setString(2, jmb);

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
	public boolean obrisiKvalifikacija(String jmb) {
		boolean retVal = false;
		Connection conn = null;
		PreparedStatement ps = null;

		String query = "DELETE FROM kvalifikacija " + "WHERE JMB=?";
		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			ps.setString(1, jmb);

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
	
	
}
