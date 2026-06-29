package data.dao.mysql.zaposleni;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.ConnectionPool;
import data.dao.zaposleni.ProdavacDAO;
import data.dto.zaposleni.ProdavacDTO;
import data.dto.zaposleni.ZaposleniDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utility.DBUtilities;
import utility.PSVUtilities;

public class MySQLProdavacDAO implements ProdavacDAO {

	@Override
	public ProdavacDTO prodavac(String jmb) {
		ProdavacDTO retVal = null;

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String query = "SELECT * from prodavac where JMB=? ";

		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			ps.setString(1, jmb);
			rs = ps.executeQuery();

			ZaposleniDTO zap = PSVUtilities.getDAOFactory().getZaposleniDAO().zaposleni(jmb);

			if (rs.next())
				retVal = new ProdavacDTO(zap, rs.getInt(2), rs.getString(3));
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
	public ProdavacDTO prodavacSifra(String sifra) {
		ProdavacDTO retVal = null;

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String query = "SELECT * from prodavac where Sifra=? ";

		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			ps.setString(1, sifra);
			rs = ps.executeQuery();

			if (rs.next()) {
				ZaposleniDTO zap = PSVUtilities.getDAOFactory().getZaposleniDAO().zaposleni(rs.getString(1));
				retVal = new ProdavacDTO(zap, rs.getInt(2), rs.getString(3));
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
	public ObservableList<ProdavacDTO> prodavac() {
		ObservableList<ProdavacDTO> retVal = FXCollections.observableArrayList();

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String query = "SELECT * " + "FROM prodavac ";
		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next()) {
				ZaposleniDTO zap = PSVUtilities.getDAOFactory().getZaposleniDAO().zaposleni(rs.getString(1));
				retVal.add(new ProdavacDTO(zap, rs.getInt(2), rs.getString(3)));
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
	public boolean dodajProdavac(ProdavacDTO prodavac) {
		boolean retVal = false;
		Connection conn = null;
		PreparedStatement ps = null;

		String query = "call kreiraj_prodavac" + "(?, ?, ?)";
		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			ps.setString(1, prodavac.getZaposleni().getJmb());
			ps.setInt(2, 0);
			ps.setString(3, prodavac.getSifra());

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
	public boolean azurirajProdavac(ProdavacDTO prodavac) {
		boolean retVal = false;
		Connection conn = null;
		PreparedStatement ps = null;

		String query = "UPDATE prodavac SET " + "Sifra=?, BrojProdatihVozila=? " + "WHERE JMB=? ";
		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			ps.setString(1, prodavac.getSifra());
			ps.setInt(2, prodavac.getBrojProdatihVozila());
			ps.setString(3, prodavac.getZaposleni().getJmb());

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
	public boolean obrisiProdavac(String jmb) {
		return false;
	}

}
