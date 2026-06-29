package data.dao.mysql.zaposleni;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.ConnectionPool;
import data.dao.zaposleni.BankaDAO;
import data.dto.zaposleni.BankaDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utility.DBUtilities;

public class MySQLBankaDAO implements BankaDAO {

	@Override
	public BankaDTO banka(String jib) {
		BankaDTO retVal = null;

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String query = "SELECT * from banka where JIB=? ";

		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			ps.setString(1, jib);
			rs = ps.executeQuery();

			if (rs.next())
				retVal = new BankaDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
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
	public ObservableList<BankaDTO> banka() {
		ObservableList<BankaDTO> retVal = FXCollections.observableArrayList();

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String query = "SELECT * from banka ";
		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next()) {
				retVal.add(new BankaDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
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
	public boolean dodajBanka(BankaDTO banka) {
		boolean retVal = false;
		Connection conn = null;
		PreparedStatement ps = null;

		String query = "call kreiraj_banka" + "(?, ?, ?, ?)";
		try {
			conn = ConnectionPool.getInstance().checkOut();

			ps = conn.prepareStatement(query);
			ps.setString(1, banka.getJib());
			if(banka.getSjediste() == null)
				ps.setString(2, "Nepoznato");
			else
				ps.setString(2, banka.getSjediste());
			ps.setString(3, banka.getNaziv());
			ps.setString(4, banka.getZiroRacunBanke());

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
	public boolean azurirajBanka(BankaDTO banka) {
		boolean retVal = false;
		Connection conn = null;
		PreparedStatement ps = null;

		String query = "UPDATE banka SET " + "Sjediste=?, Naziv=?, ZiroRacunBanke=? " + "WHERE JIB=? ";
		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			ps.setString(1, banka.getSjediste());
			ps.setString(2, banka.getNaziv());
			ps.setString(3, banka.getZiroRacunBanke());
			ps.setString(4, banka.getJib());

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
	public boolean obrisiBanka(String jib) {
		return false;
	}

}
