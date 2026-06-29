package data.dao.mysql.servis_vozila;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.ConnectionPool;
import data.dao.servis_vozila.VoziloNaServisuDAO;
import data.dto.prodaja_vozila.VozilaDTO;
import data.dto.servis_vozila.ServisnaKnjigaVozilaDTO;
import data.dto.servis_vozila.VoziloNaServisuDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utility.DBUtilities;
import utility.PSVUtilities;

public class MySQLVoziloNaServisuDAO implements VoziloNaServisuDAO {

	@Override
	public VoziloNaServisuDTO voziloNaServisu(int IdVozilaNaServisu) {
		VoziloNaServisuDTO retVal = null;

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String query = "SELECT * from vozilo_na_servisu where IdVozilaNaServisu=? ";

		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			ps.setInt(1, IdVozilaNaServisu);
			rs = ps.executeQuery();

			if (rs.next()) {
				VozilaDTO v = PSVUtilities.getDAOFactory().getVozilaDAO().vozila(rs.getInt(2));
				ServisnaKnjigaVozilaDTO skv = PSVUtilities.getDAOFactory().getServisnaKnjigaVozilaDAO().servisnaKnjigaVozila(rs.getInt(3), rs.getInt(2));
				retVal = new VoziloNaServisuDTO(rs.getInt(1), v, skv, rs.getDate(4), rs.getDouble(5), rs.getDate(6));
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
	public ObservableList<VoziloNaServisuDTO> voziloNaServisu() {
		ObservableList<VoziloNaServisuDTO> retVal = FXCollections.observableArrayList();

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String query = "SELECT * from vozilo_na_servisu";
		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next()) {
				VozilaDTO v = PSVUtilities.getDAOFactory().getVozilaDAO().vozila(rs.getInt(2));
				ServisnaKnjigaVozilaDTO skv = PSVUtilities.getDAOFactory().getServisnaKnjigaVozilaDAO().servisnaKnjigaVozila(rs.getInt(3), rs.getInt(2));
				retVal.add(new VoziloNaServisuDTO(rs.getInt(1), v, skv, rs.getDate(4), rs.getDouble(5), rs.getDate(6)));
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
	public boolean dodajVoziloNaServisu(VoziloNaServisuDTO voziloNaServisu) {
		return false;
	}

	@Override
	public boolean azurirajVoziloNaServisu(VoziloNaServisuDTO voziloNaServisu) {
		return false;
	}

	@Override
	public boolean obrisiVoziloNaServisu(int IdVozilaNaServisu) {
		return false;
	}

}
