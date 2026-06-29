package data.dao.mysql.servis_vozila;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import connection.ConnectionPool;
import data.dao.servis_vozila.KarticaVozilaDAO;
import data.dto.servis_vozila.KarticaVozilaDTO;
import javafx.collections.ObservableList;
import utility.DBUtilities;

public class MySQLKarticaVozilaDAO implements KarticaVozilaDAO {

	@Override
	public boolean dodajKarticaVozila(KarticaVozilaDTO karticaVozila) {
		boolean retVal = false;
		Connection conn = null;
		PreparedStatement ps = null;
		int id = 0;
		String query = "call kreiraj_kartica_vozila"
				+ "(?, ?, ?, ?, ?, ?, ?)";
		try {
			conn = ConnectionPool.getInstance().checkOut();
			PreparedStatement pst1 = conn.prepareStatement("select max(IdKarticaVozila)+1 from kartica_vozila");
		    ResultSet rs = pst1.executeQuery();
		    
		    while(rs.next()){
		    	id = rs.getInt(1);
		    }			
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ps.setInt(2, karticaVozila.getVozila().getIdVozila());
			ps.setInt(3, karticaVozila.getZahtjev().getBrojZahtjeva());
			ps.setInt(4, karticaVozila.getUkupanBrojServisa());
			ps.setDate(5, karticaVozila.getDatumPoslednjegServisa());
			ps.setString(6, karticaVozila.getOpisRanijihPopravki());
			ps.setString(7, "na cekanju");
			
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
	public boolean azurirajKarticaVozila(KarticaVozilaDTO KarticaVozila) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean obrisiKarticaVozila(int idKarticaVozila) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ObservableList<KarticaVozilaDTO> karticaVozila(int idKarticaVozila) {
		// TODO Auto-generated method stub
		return null;
	}

}
