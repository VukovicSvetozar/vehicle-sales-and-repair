package data.dao.mysql.zaposleni;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.ConnectionPool;
import data.dao.zaposleni.RukovodilacSkladistaDAO;
import data.dto.zaposleni.RukovodilacSkladistaDTO;
import data.dto.zaposleni.ZaposleniDTO;
import javafx.collections.ObservableList;
import utility.DBUtilities;
import utility.PSVUtilities;

public class MySQLRukovodilacSkladistaDAO implements RukovodilacSkladistaDAO {

	@Override
	public RukovodilacSkladistaDTO rukovodilacSkladista(String jmb) {
		RukovodilacSkladistaDTO retVal = null;

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String query = "SELECT * from rukovodilac_skladista where JMB=? ";

		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			ps.setString(1, jmb);
			rs = ps.executeQuery();

			ZaposleniDTO zap = PSVUtilities.getDAOFactory().getZaposleniDAO().zaposleni(jmb);

			if (rs.next())
				retVal = new RukovodilacSkladistaDTO(zap, rs.getString(2));
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
	public ObservableList<RukovodilacSkladistaDTO> rukovodilacSkladista() {
		return null;
	}

	@Override
	public boolean dodajRukovodilacSkladista(RukovodilacSkladistaDTO rukovodilacSkladista) {
		boolean retVal = false;
		Connection conn = null;
		PreparedStatement ps = null;

		String query = "call kreiraj_rukovodilac_skladista" + "(?, ?)";
		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			ps.setString(1, rukovodilacSkladista.getZaposleni().getJmb());
			ps.setString(2, rukovodilacSkladista.getLicniBroj());

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
	public boolean azurirajRukovodilacSkladista(RukovodilacSkladistaDTO rukovodilacSkladista) {
		boolean retVal = false;
		Connection conn = null;
		PreparedStatement ps = null;

		String query = "UPDATE rukovodilac_skladista SET " + "LicniBroj=? " + "WHERE JMB=? ";
		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			ps.setString(1, rukovodilacSkladista.getLicniBroj());
			ps.setString(2, rukovodilacSkladista.getZaposleni().getJmb());

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
	public boolean obrisiRukovodilacSkladista(String jmb) {
		return false;
	}

}
