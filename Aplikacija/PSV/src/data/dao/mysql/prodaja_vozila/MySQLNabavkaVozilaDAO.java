package data.dao.mysql.prodaja_vozila;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.ConnectionPool;
import data.dao.prodaja_vozila.NabavkaVozilaDAO;
import data.dto.prodaja_vozila.DistributerVozilaDTO;
import data.dto.prodaja_vozila.NabavkaVozilaDTO;
import data.dto.prodaja_vozila.VoziloUVlasnistvuDTO;
import javafx.collections.ObservableList;
import utility.DBUtilities;
import utility.PSVUtilities;

public class MySQLNabavkaVozilaDAO implements NabavkaVozilaDAO {

	@Override
	public NabavkaVozilaDTO nabavkaVozila(int idVozila, Date datumNabavke) {
		NabavkaVozilaDTO retVal = null;

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String query = "SELECT * from nabavka_vozila where IdVozila=? and DatumNabavke";

		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			ps.setInt(1, idVozila);
			ps.setDate(2, datumNabavke);
			rs = ps.executeQuery();

			if (rs.next()) {
				VoziloUVlasnistvuDTO vv = PSVUtilities.getDAOFactory().getVoziloUVlasnistvuDAO().voziloUVlasnistvu(rs.getInt(1));
				DistributerVozilaDTO dv = PSVUtilities.getDAOFactory().getDistributerVozilaDAO().distributer(rs.getInt(4));				
				retVal = new NabavkaVozilaDTO(vv, rs.getDate(2),rs.getDouble(3), dv);
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
	public ObservableList<NabavkaVozilaDTO> nabavkaVozila() {
		return null;
	}

	@Override
	public boolean dodajNabavka(NabavkaVozilaDTO nabavka) {
		boolean retVal = false;
		Connection conn = null;
		PreparedStatement ps = null;

		String query = "call kreiraj_nabavka_vozila" + "(?, ?, ?, ?)";
		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			ps.setInt(1, nabavka.getVoziloUVlasnistvu().getVozila().getIdVozila());
			ps.setDate(2, nabavka.getDatumNabavke());
			ps.setDouble(3, nabavka.getCijenaNabavke());
			ps.setInt(4, nabavka.getDistributer().getKlijent().getIdKlijenta());

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
	public boolean azurirajNabavka(NabavkaVozilaDTO nabavka) {
		return false;
	}

	@Override
	public boolean obrisiNabavka(int idVozila, Date datumNabavke) {
		return false;
	}

}
