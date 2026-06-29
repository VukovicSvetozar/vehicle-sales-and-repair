package table;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.ConnectionPool;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utility.DBUtilities;

public class MySQLTableProdataVozila {

	public static ObservableList<TableProdataVozila> tabelaProdatihVozila() {
		ObservableList<TableProdataVozila> retVal = FXCollections.observableArrayList();

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String query = "SELECT pv.IdVozila, Proizvodjac, Model, pr.IdKlijenta, Status_za_naplatu, DatumProdaje, CijenaProdaje, UkupnoNaplaceno, SledecaUplata, IdProdaja FROM prodata_vozila pv\r\n"
				+ "				inner join prodaja pr on pv.IdVozila=pr.IdVozila left outer join vozila vo\r\n"
				+ "			on pv.IdVozila=vo.IdVozila; ";
		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next()) {
				TableProdataVozila prodatoVozilo = new TableProdataVozila();

				prodatoVozilo.setIdVozila(rs.getInt(1));
				prodatoVozilo.setModel(rs.getString(2) + " " + rs.getString(3));
				prodatoVozilo.setIdKlijenta(rs.getInt(4));
				prodatoVozilo.setStatus_za_naplatu(rs.getString(5));
				prodatoVozilo.setDatumProdaje(rs.getDate(6));
				prodatoVozilo.setCijenaProdaje(rs.getDouble(7));
				prodatoVozilo.setUkupnoNaplaceno(rs.getString(8));
				prodatoVozilo.setSledecaUplata(rs.getString(9));
				prodatoVozilo.setIdProdaja(rs.getInt(10));

				retVal.add(prodatoVozilo);
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
