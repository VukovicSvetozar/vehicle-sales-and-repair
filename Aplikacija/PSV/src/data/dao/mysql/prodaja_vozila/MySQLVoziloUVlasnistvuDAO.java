package data.dao.mysql.prodaja_vozila;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.ConnectionPool;
import data.dao.prodaja_vozila.VoziloUVlasnistvuDAO;
import data.dto.prodaja_vozila.KupacDTO;
import data.dto.prodaja_vozila.VozilaDTO;
import data.dto.prodaja_vozila.VoziloUVlasnistvuDTO;
import javafx.collections.ObservableList;
import utility.DBUtilities;
import utility.PSVUtilities;

public class MySQLVoziloUVlasnistvuDAO implements VoziloUVlasnistvuDAO {

	@Override
	public VoziloUVlasnistvuDTO voziloUVlasnistvu(int idVozila) {
		VoziloUVlasnistvuDTO retVal = null;

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String query = "SELECT * from vozila_u_vlasnistvu where IdVozila=? ";

		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			ps.setInt(1, idVozila);
			rs = ps.executeQuery();

			if (rs.next()) {
				VozilaDTO vozilo = PSVUtilities.getDAOFactory().getVozilaDAO().vozila(rs.getInt(1));
				KupacDTO kupac = PSVUtilities.getDAOFactory().getKupacDAO().kupac(rs.getInt(6));
				retVal = new VoziloUVlasnistvuDTO(vozilo, rs.getDate(2), rs.getDouble(3), rs.getString(4),
						rs.getString(5), kupac, rs.getInt(6), rs.getString(7), rs.getString(8));
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
	public ObservableList<VoziloUVlasnistvuDTO> voziloUVlasnistvu() {
		return null;
	}

	@Override
	public boolean dodajVoziloUVlasnistvu(VoziloUVlasnistvuDTO voziloUVlasnistvu) {
		boolean retVal = false;
		Connection conn = null;
		PreparedStatement ps = null;

		String query = "call kreiraj_vozila_u_vlasnistvu" + "(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			ps.setInt(1, voziloUVlasnistvu.getVozila().getIdVozila());
			ps.setDate(2, voziloUVlasnistvu.getDatumNabavke());
			ps.setDouble(3, voziloUVlasnistvu.getCijenaNabavke());
			ps.setString(4, voziloUVlasnistvu.getStatus_Za_Prodaju());
			ps.setString(5, voziloUVlasnistvu.getTehnickaProvjera());
			if(voziloUVlasnistvu.getKupac() == null)
				ps.setInt(6, 0);
			else
				ps.setInt(6, voziloUVlasnistvu.getKupac().getKlijent().getIdKlijenta());
			ps.setInt(7, voziloUVlasnistvu.getBrojGaraze());
			ps.setString(8, voziloUVlasnistvu.getOcarinjeno());
			ps.setString(9, voziloUVlasnistvu.getStanjeVozila());
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
	public boolean azurirajVoziloUVlasnistvu(VoziloUVlasnistvuDTO voziloUVlasnistvu) {
		boolean retVal = false;
		Connection conn = null;
		PreparedStatement ps = null;

		String query = "UPDATE vozila_u_vlasnistvu SET " + "Status_Za_Prodaju=?, IdKlijenta=? " + "WHERE IdVozila=? ";
		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			ps.setString(1, voziloUVlasnistvu.getStatus_Za_Prodaju());
			if(voziloUVlasnistvu.getKupac().getKlijent().getIdKlijenta() == 0)
				ps.setObject(2, null);
			else
				ps.setInt(2, voziloUVlasnistvu.getKupac().getKlijent().getIdKlijenta());
			ps.setInt(3, voziloUVlasnistvu.getVozila().getIdVozila());

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
	public boolean obrisiVoziloUVlasnistvu(int idVozila) {
		return false;
	}

}
