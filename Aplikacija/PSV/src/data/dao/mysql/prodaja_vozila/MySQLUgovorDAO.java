package data.dao.mysql.prodaja_vozila;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.ConnectionPool;
import data.dao.prodaja_vozila.UgovorDAO;
import data.dto.prodaja_vozila.UgovorDTO;
import data.dto.zaposleni.MenadzerDTO;
import javafx.collections.ObservableList;
import utility.DBUtilities;
import utility.PSVUtilities;

public class MySQLUgovorDAO implements UgovorDAO {

	@Override
	public UgovorDTO ugovor(int idUgovora) {
		UgovorDTO retVal = null;

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String query = "SELECT * from ugovor where IdUgovora=? ";

		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			ps.setInt(1, idUgovora);
			rs = ps.executeQuery();

			if (rs.next()) {
				MenadzerDTO menadzer = PSVUtilities.getDAOFactory().getMenadzerDAO().menadzer(rs.getString(3));
				retVal = new UgovorDTO(rs.getInt(1), rs.getDate(2), menadzer);
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
	public ObservableList<UgovorDTO> ugovor() {
		return null;
	}

	@Override
	public int dodajUgovor(UgovorDTO ugovor) {
		int retVal = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		int id = 0;
		String query = "call kreiraj_ugovor" + "(?, ?, ?)";
		try {
			conn = ConnectionPool.getInstance().checkOut();
			PreparedStatement pst1 = conn.prepareStatement("select max(IdUgovora)+1 from ugovor");
			ResultSet rs = pst1.executeQuery();

			while (rs.next()) {
				id = rs.getInt(1);
			}
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ps.setDate(2, ugovor.getDatumSklapanjaUgovora());
			ps.setString(3, ugovor.getMenadzer().getZaposleni().getJmb());
			ps.executeUpdate();
			retVal = id;
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
	public boolean azurirajUgovor(UgovorDTO ugovor) {
		return false;
	}

	@Override
	public boolean obrisiUgovor(int idUgovora) {
		return false;
	}

}
