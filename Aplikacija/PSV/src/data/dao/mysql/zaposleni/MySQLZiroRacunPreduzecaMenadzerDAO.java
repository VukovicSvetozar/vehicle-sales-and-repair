package data.dao.mysql.zaposleni;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.ConnectionPool;
import data.dao.zaposleni.ZiroRacunPreduzecaMenadzerDAO;
import data.dto.zaposleni.MenadzerDTO;
import data.dto.zaposleni.ZiroRacunPreduzecaDTO;
import data.dto.zaposleni.ZiroRacunPreduzecaMenadzerDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utility.DBUtilities;
import utility.PSVUtilities;

public class MySQLZiroRacunPreduzecaMenadzerDAO implements ZiroRacunPreduzecaMenadzerDAO {

	@Override
	public ZiroRacunPreduzecaMenadzerDTO ziroRacunPreduzecaMenadzer(String brojZiroRacuna, String jmb) {
		return null;
	}

	@Override
	public ObservableList<ZiroRacunPreduzecaMenadzerDTO> ziroRacunPreduzecaMenadzer() {
		ObservableList<ZiroRacunPreduzecaMenadzerDTO> retVal = FXCollections.observableArrayList();

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String query = "SELECT * " + "FROM ziro_racun_preduzeca_menadzer";
		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next()) {
				ZiroRacunPreduzecaDTO ziroRacunPreduzeca = PSVUtilities.getDAOFactory().getZiroRacunPreduzecaDAO()
						.ziroRacunPreduzeca(rs.getString(1));
				MenadzerDTO menadzer = PSVUtilities.getDAOFactory().getMenadzerDAO().menadzer(rs.getString(2));
				retVal.add(new ZiroRacunPreduzecaMenadzerDTO(ziroRacunPreduzeca, menadzer));
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
	public boolean dodajZiroRacunPreduzecaMenadzer(ZiroRacunPreduzecaMenadzerDTO ziroRacunPreduzecaMenadzer) {
		boolean retVal = false;
		Connection conn = null;
		PreparedStatement ps = null;

		String query = "call kreiraj_ziro_racun_preduzeca_menadzer" + "(?, ?)";
		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			ps.setString(1, ziroRacunPreduzecaMenadzer.getZiroRacunPreduzeca().getBrojZiroRacunaPreduzeca());
			ps.setString(2, ziroRacunPreduzecaMenadzer.getMenader().getZaposleni().getJmb());

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
	public boolean azurirajZiroRacunPreduzecaMenadzer(ZiroRacunPreduzecaMenadzerDTO ziroRacunPreduzecaMenadzer) {
		return false;
	}

	@Override
	public boolean obrisiZiroRacunPreduzecaMenadzer(String brojZiroRacuna, String jmb) {
		boolean retVal = false;
		Connection conn = null;
		PreparedStatement ps = null;

		String query = "DELETE FROM ziro_racun_preduzeca_menadzer " + "WHERE BrojZiroRacunaPreduzeca=? and JMB=? ";
		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			ps.setString(1, brojZiroRacuna);
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
	public boolean obrisiZiroRacunPreduzecaMenadzer(String jmb) {
		boolean retVal = false;
		Connection conn = null;
		PreparedStatement ps = null;

		String query = "DELETE FROM ziro_racun_preduzeca_menadzer " + "WHERE JMB=? ";
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
