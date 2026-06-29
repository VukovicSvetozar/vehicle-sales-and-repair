package data.dao.mysql.prodaja_vozila;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import connection.ConnectionPool;
import data.dao.prodaja_vozila.VozilaDAO;
import data.dto.prodaja_vozila.VozilaDTO;
import javafx.collections.ObservableList;
import utility.DBUtilities;

public class MySQLVozilaDAO implements VozilaDAO {
	
	@Override
	public VozilaDTO vozila(int idVozila) {
		VozilaDTO retVal = null;

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String query = "SELECT * from vozila where IdVozila=? ";

		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			ps.setInt(1, idVozila);
			rs = ps.executeQuery();

			if (rs.next())
				retVal = new VozilaDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),
						rs.getInt(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getDate(10), rs.getString(11));
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
	public ObservableList<VozilaDTO> vozila() {
		return null;
	}

	@Override
	public int dodajVozila(VozilaDTO vozila) {
		Connection conn = null;
		PreparedStatement ps = null;
		int id = 0;
		String query = "call kreiraj_vozila" + "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			conn = ConnectionPool.getInstance().checkOut();

			PreparedStatement pst1 = conn.prepareStatement("select max(IdVozila)+1 from vozila");
			ResultSet rs = pst1.executeQuery();

			while (rs.next()) {
				id = rs.getInt(1);
			}
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ps.setString(2, vozila.getTipVozila());
			ps.setString(3, vozila.getProizvodjac());
			ps.setString(4, vozila.getModel());
			ps.setInt(5, vozila.getKilometraza());
			ps.setInt(6, vozila.getGodinaProizvodnje());
			ps.setString(7, vozila.getBoja());
			ps.setString(8, vozila.getVrstaGoriva());
			ps.setString(9, vozila.getBrojRegistracije());
			ps.setDate(10, vozila.getDatumRegistracije());
			ps.setBinaryStream(11, null);

			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			DBUtilities.getInstance().showSQLException(e);
		} finally {
			ConnectionPool.getInstance().checkIn(conn);
			DBUtilities.getInstance().close(ps);
		}
		return id;
	}

	@Override
	public boolean azurirajVozila(VozilaDTO vozila) {
		return false;
	}

	@Override
	public boolean obrisiVozila(int idVozila) {
		return false;
	}

}
