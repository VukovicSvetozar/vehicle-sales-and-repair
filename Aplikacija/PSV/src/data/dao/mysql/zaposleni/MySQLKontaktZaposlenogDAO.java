package data.dao.mysql.zaposleni;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import connection.ConnectionPool;
import data.dao.zaposleni.KontaktZaposlenogDAO;
import data.dto.zaposleni.KontaktZaposlenogDTO;
import data.dto.zaposleni.ZaposleniDTO;
import javafx.collections.ObservableList;
import utility.DBUtilities;
import utility.PSVUtilities;

public class MySQLKontaktZaposlenogDAO implements KontaktZaposlenogDAO {

	@Override
	public KontaktZaposlenogDTO kontakt(String jmb) {

		KontaktZaposlenogDTO retVal = null;

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String query = "SELECT * from kontakt_zaposlenog where JMB=? ";

		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			ps.setString(1, jmb);
			rs = ps.executeQuery();
			ZaposleniDTO zap = PSVUtilities.getDAOFactory().getZaposleniDAO().zaposleni(jmb);

			if (rs.next())
				retVal = new KontaktZaposlenogDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), zap);
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
	public ObservableList<KontaktZaposlenogDTO> kontakt() {
		return null;
	}

	@Override
	public boolean dodajKontaktZaposlenog(KontaktZaposlenogDTO KontaktZaposlenog) {
		boolean retVal = false;
		Connection conn = null;
		PreparedStatement ps = null;
		int id = 0;
		String query = "call kreiraj_kontakt_zaposlenog" + "(?, ?, ?, ?, ?, ?)";
		try {
			conn = ConnectionPool.getInstance().checkOut();
			PreparedStatement pst1 = conn.prepareStatement("select max(IdKontakt)+1 from kontakt_zaposlenog");
			ResultSet rs = pst1.executeQuery();

			while (rs.next()) {
				id = rs.getInt(1);
			}
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ps.setString(2, KontaktZaposlenog.getGrad());
			ps.setString(3, KontaktZaposlenog.getAdresa());
			ps.setString(4, KontaktZaposlenog.getTelefon());
			ps.setString(5, KontaktZaposlenog.getEmail());
			ps.setString(6, KontaktZaposlenog.getZaposleni().getJmb());

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
	public boolean azurirajKontaktZaposlenog(KontaktZaposlenogDTO KontaktZaposlenog) {
		boolean retVal = false;
		Connection conn = null;
		PreparedStatement ps = null;

		String query = "UPDATE kontakt_zaposlenog SET " + "Grad=?, Adresa=?, Telefon=?, " + "Email=? "
				+ "WHERE IdKontakt=? ";
		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			ps.setString(1, KontaktZaposlenog.getGrad());
			ps.setString(2, KontaktZaposlenog.getAdresa());
			ps.setString(3, KontaktZaposlenog.getTelefon());
			ps.setString(4, KontaktZaposlenog.getEmail());
			ps.setInt(5, KontaktZaposlenog.getIdKontak());

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
	public boolean obrisiKontaktZaposlenog(int idKontakt) {
		return false;
	}

}
