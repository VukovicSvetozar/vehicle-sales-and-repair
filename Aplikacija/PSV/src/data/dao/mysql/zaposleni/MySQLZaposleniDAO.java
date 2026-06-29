package data.dao.mysql.zaposleni;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import connection.ConnectionPool;
import data.dao.zaposleni.ZaposleniDAO;
import data.dto.zaposleni.ZaposleniDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utility.DBUtilities;

public class MySQLZaposleniDAO implements ZaposleniDAO {

	@Override
	public ZaposleniDTO zaposleni(String jmb) {
		ZaposleniDTO retVal = null;

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String query = "SELECT * from zaposleni where JMB=? ";

		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			ps.setString(1, jmb);
			rs = ps.executeQuery();

			if (rs.next())
				retVal = new ZaposleniDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4),
						rs.getDate(5), rs.getString(6), rs.getDouble(7), rs.getDate(8), rs.getDate(9),
						rs.getString(10));
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
	public ObservableList<ZaposleniDTO> zaposleni() {

		ObservableList<ZaposleniDTO> retVal = FXCollections.observableArrayList();

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String query = "SELECT JMB, Ime, Prezime, DatumRodjenja, DatumZaposljavanja, Funkcija, Satnica, LijecnickiPregled, "
				+ "DatumIstekaUgovora, Fotografija " + "FROM zaposleni ";
		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next())
				retVal.add(new ZaposleniDTO(rs.getString("JMB"), rs.getString("Ime"), rs.getString("Prezime"),
						rs.getDate("DatumRodjenja"), rs.getDate("DatumZaposljavanja"), rs.getString("Funkcija"),
						rs.getDouble("Satnica"), rs.getDate("LijecnickiPregled"), rs.getDate("DatumIstekaUgovora"),
						rs.getString("Fotografija")));
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
	public String dodajZaposleni(ZaposleniDTO zaposleni) {
		Connection conn = null;
		PreparedStatement ps = null;

		String query = "call kreiraj_zaposleni" + "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			conn = ConnectionPool.getInstance().checkOut();

			ps = conn.prepareStatement(query);
			ps.setString(1, zaposleni.getJmb());
			ps.setString(2, zaposleni.getIme());
			ps.setString(3, zaposleni.getPrezime());
			ps.setDate(4, zaposleni.getDatumRodjenja());
			ps.setDate(5, zaposleni.getDatumZaposljavanja());
			ps.setString(6, zaposleni.getFunkcija());
			ps.setDouble(7, zaposleni.getSatnica());
			ps.setDate(8, zaposleni.getLijecnickiPregled());
			ps.setDate(9, zaposleni.getDatumIstekaUgovora());
			ps.setString(10, zaposleni.getFotografija());

			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			DBUtilities.getInstance().showSQLException(e);
		} finally {
			ConnectionPool.getInstance().checkIn(conn);
			DBUtilities.getInstance().close(ps);
		}
		return zaposleni.getJmb();
	}

	@Override
	public boolean azurirajZaposleni(ZaposleniDTO zaposleni) {
		boolean retVal = false;
		Connection conn = null;
		PreparedStatement ps = null;

		String query = "UPDATE zaposleni SET " + "Ime=?, Prezime=?, " + "DatumZaposljavanja=?, "
				+ "Funkcija=?, Satnica=?, " + "LijecnickiPregled=?, DatumIstekaUgovora=?," + "Fotografija=? "
				+ " WHERE JMB=? ";
		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			ps.setString(1, zaposleni.getIme());
			ps.setString(2, zaposleni.getPrezime());
			ps.setDate(3, zaposleni.getDatumZaposljavanja());
			ps.setString(4, zaposleni.getFunkcija());
			ps.setDouble(5, zaposleni.getSatnica());
			ps.setDate(6, zaposleni.getLijecnickiPregled());
			ps.setDate(7, zaposleni.getDatumIstekaUgovora());
			ps.setString(8, zaposleni.getFotografija());
			ps.setString(9, zaposleni.getJmb());

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
	public boolean obrisiZaposleni(String JMB) {
		boolean retVal = false;
		Connection conn = null;
		PreparedStatement ps = null;

		String query = "DELETE FROM zaposleni " + "WHERE JMB=? ";
		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			ps.setString(1, JMB);

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
