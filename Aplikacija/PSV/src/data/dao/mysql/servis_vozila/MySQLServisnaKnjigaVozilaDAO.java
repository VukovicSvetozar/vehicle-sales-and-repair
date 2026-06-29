package data.dao.mysql.servis_vozila;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.ConnectionPool;
import data.dao.servis_vozila.ServisnaKnjigaVozilaDAO;
import data.dto.prodaja_vozila.VozilaDTO;
import data.dto.servis_vozila.ServisnaKnjigaVozilaDTO;
import data.dto.servis_vozila.ZahtjevDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utility.DBUtilities;
import utility.PSVUtilities;

public class MySQLServisnaKnjigaVozilaDAO implements ServisnaKnjigaVozilaDAO {

	@Override
	public ServisnaKnjigaVozilaDTO servisnaKnjigaVozila(int BrojKarticeVozila, int IdVozila) {
		ServisnaKnjigaVozilaDTO retVal = null;

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String query = "SELECT * from servisna_knjiga_vozila where BrojKarticeVozila=? and IdVozila=? ";

		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			ps.setInt(1, BrojKarticeVozila);
			ps.setInt(2, IdVozila);
			rs = ps.executeQuery();

			if (rs.next()) {
				VozilaDTO v = PSVUtilities.getDAOFactory().getVozilaDAO().vozila(rs.getInt(2));
				ZahtjevDTO z = PSVUtilities.getDAOFactory().getZahtjevDAO().zahtjev(rs.getInt(3));
				retVal = new ServisnaKnjigaVozilaDTO(rs.getInt(1), v, z, rs.getInt(4), rs.getDate(5), rs.getString(6),
						rs.getString(7), rs.getString(8), v.getIdVozila());
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
	public ObservableList<ServisnaKnjigaVozilaDTO> servisnaKnjigaVozila() {
		ObservableList<ServisnaKnjigaVozilaDTO> retVal = FXCollections.observableArrayList();

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String query = "SELECT * from servisna_knjiga_vozila";
		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next()) {
				VozilaDTO v = PSVUtilities.getDAOFactory().getVozilaDAO().vozila(rs.getInt(2));
				ZahtjevDTO z = PSVUtilities.getDAOFactory().getZahtjevDAO().zahtjev(rs.getInt(3));
				retVal.add(new ServisnaKnjigaVozilaDTO(rs.getInt(1), v, z, rs.getInt(4), rs.getDate(5), rs.getString(6),
						rs.getString(7), rs.getString(8), v.getIdVozila()));
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
	public int dodajServisnaKnjigaVozila(ServisnaKnjigaVozilaDTO servisnaKnjigaVozila) {
		Connection conn = null;
		PreparedStatement ps = null;
		int id = 0;
		String query = "call kreiraj_servisna_knjiga_vozila" + "(?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			conn = ConnectionPool.getInstance().checkOut();

			PreparedStatement pst1 = conn.prepareStatement("select max(BrojKarticeVozila)+1 from servisna_knjiga_vozila");
			ResultSet rs = pst1.executeQuery();

			while (rs.next()) {
				id = rs.getInt(1);
			}
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ps.setInt(2, servisnaKnjigaVozila.getVozila().getIdVozila());
			ps.setInt(3, servisnaKnjigaVozila.getZahtjev().getBrojZahtjeva());
			ps.setInt(4, servisnaKnjigaVozila.getUkupanBrojServisa());
			ps.setDate(5, servisnaKnjigaVozila.getDatumPoslednjegServisa());
			ps.setString(6, servisnaKnjigaVozila.getOpisRanijihPopravki());
			ps.setString(7, servisnaKnjigaVozila.getStatus());
			ps.setString(8, servisnaKnjigaVozila.getOpisProblema());
			
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
	public boolean azurirajServisnaKnjigaVozila(ServisnaKnjigaVozilaDTO servisnaKnjigaVozila) {
		return false;
	}

	@Override
	public boolean obrisiServisnaKnjigaVozila(int BrojKarticeVozila, int IdVozila) {
		return false;
	}

}
