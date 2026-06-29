package data.dao.mysql.zaposleni;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import connection.ConnectionPool;
import data.dao.zaposleni.MehanicarDAO;
import data.dto.zaposleni.MehanicarDTO;
import data.dto.zaposleni.ZaposleniDTO;
import javafx.collections.ObservableList;
import utility.DBUtilities;
import utility.PSVUtilities;

public class MySQLMehanicarDAO implements MehanicarDAO {

	@Override
	public MehanicarDTO mehanicar(String jmb) {
		MehanicarDTO retVal = null;

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String query = "SELECT * from mehanicar where JMB=? ";

		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			ps.setString(1, jmb);
			rs = ps.executeQuery();
			ZaposleniDTO zap = PSVUtilities.getDAOFactory().getZaposleniDAO().zaposleni(jmb);

			if (rs.next())
				retVal = new MehanicarDTO(zap, rs.getString(2), rs.getInt(3));
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
	public ObservableList<MehanicarDTO> mehanicar() {
		return null;
	}

	@Override
	public boolean dodajMehanicar(MehanicarDTO mehanicar) {
		boolean retVal = false;
		Connection conn = null;
		PreparedStatement ps = null;

		String query = "call kreiraj_mehanicar" + "(?, ?, ?)";
		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			ps.setString(1, mehanicar.getZaposleni().getJmb());
			ps.setString(2, mehanicar.getBrojSmjene());
			ps.setInt(3, 0);

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
	public boolean azurirajMehanicar(MehanicarDTO mehanicar) {
		boolean retVal = false;
		Connection conn = null;
		PreparedStatement ps = null;

		String query = "UPDATE mehanicar SET " + "BrojSmjene=? " + "WHERE JMB=? ";
		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			ps.setString(1, mehanicar.getBrojSmjene());
			ps.setString(2, mehanicar.getZaposleni().getJmb());

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
	public boolean obrisiMehanicar(String jmb) {
		return false;
	}

}
