package table;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.ConnectionPool;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utility.DBUtilities;

public class MySQLTablePregledVozila {

	public static ObservableList<TablePregledVozila> tabelaVozila() {
		ObservableList<TablePregledVozila> retVal = FXCollections.observableArrayList();

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String query = "SELECT * from prikaz_vozila";
		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next()) {
				TablePregledVozila vozilo = new TablePregledVozila();

				vozilo.setIdVozila(rs.getInt(1));
				vozilo.setTipVozila(rs.getString(2));
				vozilo.setModel(rs.getString(3) + " " + rs.getString(4));
				vozilo.setGodinaProizvodnje(rs.getInt(5));
				vozilo.setVrstaGoriva(rs.getString(6));
				vozilo.setBrojRegistracije(rs.getString(7));
				vozilo.setFotografija(rs.getString(8));
				
				if (rs.getString(9) == null) { 
					vozilo.setStatus("Na servisu");
					vozilo.setCijenaNabavke("Servis");
					vozilo.setCijenaProdaje("Servis");
				}
				else if (rs.getString(9).contains("."))	{
					vozilo.setStatus("Prodato");
					Integer cijenaNabavke = rs.getInt(10);
					vozilo.setCijenaNabavke(cijenaNabavke.toString());
					vozilo.setCijenaProdaje(rs.getString(9));
				}
				else {
					vozilo.setStatus("U ponudi");
					Integer cijenaNabavke = rs.getInt(10);
					vozilo.setCijenaNabavke(cijenaNabavke.toString());
					vozilo.setCijenaProdaje("Nije prodato");
				}

				retVal.add(vozilo);
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

}
