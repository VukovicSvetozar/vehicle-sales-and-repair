package data.dao.mysql.servis_vozila;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.ConnectionPool;
import data.dao.servis_vozila.RadniNalogDAO;
import data.dto.servis_vozila.RadniNalogDTO;
import data.dto.servis_vozila.VoziloNaServisuDTO;
import data.dto.zaposleni.ServisniRadoviDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utility.DBUtilities;
import utility.PSVUtilities;

public class MySQLRadniNalogDAO implements RadniNalogDAO {

	@Override
	public RadniNalogDTO radniNalog(int idRadniNalog) {
		RadniNalogDTO retVal = null;

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String query = "SELECT * from radni_nalog where idRadniNalog=? ";

		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			ps.setInt(1, idRadniNalog);
			rs = ps.executeQuery();

			if (rs.next()) {
				VoziloNaServisuDTO vns = PSVUtilities.getDAOFactory().getVoziloNaServisuDAO().voziloNaServisu(rs.getInt(2));
				ServisniRadoviDTO srd = PSVUtilities.getDAOFactory().getServisniRadoviDAO().servisniRadovi(rs.getString(3));
				retVal = new RadniNalogDTO(rs.getInt(1), vns, srd, rs.getString(4));
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
	public ObservableList<RadniNalogDTO> radniNalog() {
		ObservableList<RadniNalogDTO> retVal = FXCollections.observableArrayList();

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String query = "SELECT * from radni_nalog";
		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next()) {
				VoziloNaServisuDTO vns = PSVUtilities.getDAOFactory().getVoziloNaServisuDAO().voziloNaServisu(rs.getInt(2));
				ServisniRadoviDTO srd = PSVUtilities.getDAOFactory().getServisniRadoviDAO().servisniRadovi(rs.getString(3));
				retVal.add(new RadniNalogDTO(rs.getInt(1), vns, srd, rs.getString(4)));
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
	public boolean dodajRadniNalog(RadniNalogDTO radniNalog) {
		return false;
	}

	@Override
	public boolean azurirajRadniNalog(RadniNalogDTO radniNalog) {
		return false;
	}

	@Override
	public boolean obrisiRadniNalog(int idRadniNalog) {
		return false;
	}

}
