package data.dao.mysql.prodaja_vozila;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.ConnectionPool;
import data.dao.prodaja_vozila.ProdataVozilaDAO;
import data.dto.prodaja_vozila.ProdataVozilaDTO;
import data.dto.prodaja_vozila.VozilaDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utility.DBUtilities;
import utility.PSVUtilities;

public class MySQLProdataVozilaDAO implements ProdataVozilaDAO {

	@Override
	public ProdataVozilaDTO prodataVozila(int idVozila) {
		ProdataVozilaDTO retVal = null;

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String query = "SELECT * from prodata_vozila where IdVozila=? ";

		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			ps.setInt(1, idVozila);
			rs = ps.executeQuery();

			if (rs.next()) {
				VozilaDTO vozilo = PSVUtilities.getDAOFactory().getVozilaDAO().vozila(idVozila);
				retVal = new ProdataVozilaDTO(vozilo, rs.getDouble(2), rs.getInt(3));
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
	public ObservableList<ProdataVozilaDTO> prodataVozila() {
		ObservableList<ProdataVozilaDTO> retVal = FXCollections.observableArrayList();
/*
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String query = "SELECT * from prodata_vozila ";
		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next()) {
				retVal.add(new ProdataVozilaDTO(new VozilaDTO(rs.getInt(1)), rs.getDouble(2), rs.getInt(3)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			DBUtilities.getInstance().showSQLException(e);
		} finally {
			ConnectionPool.getInstance().checkIn(conn);
			DBUtilities.getInstance().close(ps, rs);
		}
*/
		return retVal;

	}

	@Override
	public boolean dodajProdataVozila(ProdataVozilaDTO prodataVozila) {
		boolean retVal = false;
		Connection conn = null;
		PreparedStatement ps = null;

		String query = "call kreiraj_prodata_vozila" + "(?, ?, ?)";
		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			ps.setInt(1, prodataVozila.getVozila().getIdVozila());
			ps.setDouble(2, prodataVozila.getCijenaProdaje());
			ps.setInt(3, prodataVozila.getPeriodGarancije());
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
	public boolean azurirajProdataVozila(ProdataVozilaDTO prodataVozila) {
		boolean retVal = false;
		Connection conn = null;
		PreparedStatement ps = null;

		String query = "UPDATE prodata_vozila SET " + "CijenaProdaje=? " + "WHERE IdVozila=? ";
		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			ps.setDouble(1, prodataVozila.getCijenaProdaje());
			ps.setInt(2, prodataVozila.getVozila().getIdVozila());

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
	public boolean obrisiProdataVozila(int idVozila) {
		return false;
	}

}
