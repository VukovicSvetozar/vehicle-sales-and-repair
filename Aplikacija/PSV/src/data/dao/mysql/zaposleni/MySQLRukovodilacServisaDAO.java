package data.dao.mysql.zaposleni;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.ConnectionPool;
import data.dao.zaposleni.RukovodilacServisaDAO;
import data.dto.zaposleni.RukovodilacServisaDTO;
import data.dto.zaposleni.ZaposleniDTO;
import javafx.collections.ObservableList;
import utility.DBUtilities;
import utility.PSVUtilities;

public class MySQLRukovodilacServisaDAO implements RukovodilacServisaDAO {

	@Override
	public RukovodilacServisaDTO rukovodilacServisa(String jmb) {
		RukovodilacServisaDTO retVal = null;

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String query = "SELECT * from rukovodilac_servisa where JMB=? ";

		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			ps.setString(1, jmb);
			rs = ps.executeQuery();

			ZaposleniDTO zap = PSVUtilities.getDAOFactory().getZaposleniDAO().zaposleni(jmb);

			if (rs.next())
				retVal = new RukovodilacServisaDTO(zap, rs.getString(2));
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
	public ObservableList<RukovodilacServisaDTO> rukovodilacServisa() {
		return null;
	}

	@Override
	public boolean dodajRukovodilacServisa(RukovodilacServisaDTO rukovodilacServisa) {
		boolean retVal = false;
		Connection conn = null;
		PreparedStatement ps = null;

		String query = "call kreiraj_rukovodilac_servisa" + "(?, ?)";
		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			ps.setString(1, rukovodilacServisa.getZaposleni().getJmb());
			ps.setString(2, rukovodilacServisa.getLicniBroj());

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
	public boolean azurirajRukovodilacServisa(RukovodilacServisaDTO rukovodilacServisa) {
		boolean retVal = false;
		Connection conn = null;
		PreparedStatement ps = null;

		String query = "UPDATE rukovodilac_servisa SET " + "LicniBroj=? " + "WHERE JMB=? ";
		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			ps.setString(1, rukovodilacServisa.getLicniBroj());
			ps.setString(2, rukovodilacServisa.getZaposleni().getJmb());

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
	public boolean obrisiRukovodilacServisa(String JMB) {
		return false;
	}
	
}
