package data.dao.mysql.prodaja_vozila;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.ConnectionPool;
import data.dao.prodaja_vozila.ProdajaDAO;
import data.dto.prodaja_vozila.KupacDTO;
import data.dto.prodaja_vozila.ProdajaDTO;
import data.dto.prodaja_vozila.ProdataVozilaDTO;
import data.dto.prodaja_vozila.UgovorDTO;
import data.dto.zaposleni.ProdavacDTO;
import javafx.collections.ObservableList;
import utility.DBUtilities;
import utility.PSVUtilities;

public class MySQLProdajaDAO implements ProdajaDAO {

	@Override
	public ProdajaDTO prodaja(int idProdaja) {
		ProdajaDTO retVal = null;

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String query = "SELECT * from prodaja where IdProdaja=?  ";

		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			ps.setInt(1, idProdaja);
			rs = ps.executeQuery();

			if (rs.next()) {
				KupacDTO kupac = PSVUtilities.getDAOFactory().getKupacDAO().kupac(rs.getInt(2));
				ProdataVozilaDTO prodatoVozilo = PSVUtilities.getDAOFactory().getProdataVozilaDAO()
						.prodataVozila(rs.getInt(3));
				ProdavacDTO prodavac = PSVUtilities.getDAOFactory().getProdavacDAO().prodavac(rs.getString(4));
				UgovorDTO ugovor = PSVUtilities.getDAOFactory().getUgovorDAO().ugovor(rs.getInt(10));
				retVal = new ProdajaDTO(rs.getInt(1), kupac, prodatoVozilo, prodavac, rs.getString(5), rs.getDouble(6),
						rs.getString(7), rs.getDate(8), rs.getString(9), ugovor);
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
	public ObservableList<ProdajaDTO> prodaja() {
		return null;
	}

	@Override
	public int dodajProdaja(ProdajaDTO prodaja) {
			
		Connection conn = null;
		PreparedStatement ps = null;
		int id = 0;
//		String query = "call kreiraj_prodaja" + "(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		String query = "insert into prodaja values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		try {
			conn = ConnectionPool.getInstance().checkOut();
			PreparedStatement pst1 = conn.prepareStatement("select max(IdProdaja)+1 from prodaja");
			ResultSet rs = pst1.executeQuery();

			while (rs.next()) {
				id = rs.getInt(1);
			}
					
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ps.setInt(2, prodaja.getKupac().getKlijent().getIdKlijenta());
			ps.setInt(3, prodaja.getProdatoVozilo().getVozila().getIdVozila());
			ps.setString(4, prodaja.getProdavac().getZaposleni().getJmb());
			ps.setString(5, prodaja.getNacinPlacanja());
			ps.setDouble(6, prodaja.getUkupnoNaplaceno());
			ps.setString(7, prodaja.getStatus_za_naplatu());
			ps.setDate(8, prodaja.getDatumProdaje());
			ps.setString(9, prodaja.getSledecaUplata());
			ps.setInt(10, prodaja.getUgovor().getIdUgovora());

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
	public boolean azurirajProdaja(ProdajaDTO prodaja) {
		boolean retVal = false;
		Connection conn = null;
		PreparedStatement ps = null;

		String query = "UPDATE prodaja SET " + "NacinPlacanja=?, Status_za_naplatu=?, SledecaUplata=?, UkupnoNaplaceno=? "
				+ "WHERE IdKlijenta=? and IdVozila=? ";
		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			ps.setString(1, prodaja.getNacinPlacanja());
			ps.setString(2, prodaja.getStatus_za_naplatu());
			ps.setString(3, prodaja.getSledecaUplata());
			ps.setDouble(4, prodaja.getUkupnoNaplaceno());
			ps.setInt(5, prodaja.getKupac().getKlijent().getIdKlijenta());
			ps.setInt(6, prodaja.getProdatoVozilo().getVozila().getIdVozila());

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
	public boolean obrisiProdaja(int idProdaja) {
		return false;
	}

}
