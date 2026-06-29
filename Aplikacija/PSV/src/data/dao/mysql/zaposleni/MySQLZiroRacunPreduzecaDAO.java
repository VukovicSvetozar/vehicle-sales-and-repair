package data.dao.mysql.zaposleni;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.ConnectionPool;
import data.dao.zaposleni.ZiroRacunPreduzecaDAO;
import data.dto.zaposleni.BankaDTO;
import data.dto.zaposleni.ZiroRacunPreduzecaDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utility.DBUtilities;
import utility.PSVUtilities;

public class MySQLZiroRacunPreduzecaDAO implements ZiroRacunPreduzecaDAO {

	@Override
	public ZiroRacunPreduzecaDTO ziroRacunPreduzeca(String brojZiroRacuna) {
		ZiroRacunPreduzecaDTO retVal = null;

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String query = "SELECT * from ziro_racun_preduzeca where BrojZiroRacunaPreduzeca=? ";

		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			ps.setString(1, brojZiroRacuna);
			rs = ps.executeQuery();

			if (rs.next()) {
				BankaDTO banka = PSVUtilities.getDAOFactory().getBankaDAO().banka(rs.getString(2));
				retVal = new ZiroRacunPreduzecaDTO(rs.getString(1), banka);
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
	public ObservableList<ZiroRacunPreduzecaDTO> ziroRacunPreduzeca() {
		ObservableList<ZiroRacunPreduzecaDTO> retVal = FXCollections.observableArrayList();

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String query = "SELECT * " + "FROM ziro_racun_preduzeca";
		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next()) {
				BankaDTO banka = PSVUtilities.getDAOFactory().getBankaDAO().banka(rs.getString(2));
				retVal.add(new ZiroRacunPreduzecaDTO(rs.getString(1), banka));
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
	public boolean dodajZiroRacunPreduzeca(ZiroRacunPreduzecaDTO ziroRacunPreduzeca) {
		boolean retVal = false;
		Connection conn = null;
		PreparedStatement ps = null;

		String query = "call kreiraj_ziro_racun_preduzeca" + "(?, ?)";
		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			ps.setString(1, ziroRacunPreduzeca.getBrojZiroRacunaPreduzeca());
			ps.setString(2, ziroRacunPreduzeca.getBanka().getJib());

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
	public boolean azurirajZiroRacunPreduzeca(ZiroRacunPreduzecaDTO ziroRacunPreduzeca) {
		return false;
	}

	@Override
	public boolean obrisiZiroRacunPreduzeca(String brojZiroRacuna) {
		boolean retVal = false;
		Connection conn = null;
		PreparedStatement ps = null;

		String query = "DELETE FROM ziro_racun_preduzeca " + "WHERE BrojZiroRacunaPreduzeca=? ";
		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			ps.setString(1, brojZiroRacuna);

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
