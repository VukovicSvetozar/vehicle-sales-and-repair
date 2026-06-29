package table;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.ConnectionPool;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utility.DBUtilities;

public class MySQLTableVoziloUVlasnistvu {

	public static ObservableList<TableVoziloUVlasnistvu> tabelaVoziloUVlasnistvu() {
		ObservableList<TableVoziloUVlasnistvu> retVal = FXCollections.observableArrayList();

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String query = "select * from prikaz_vozila_u_vlasnistvu";
		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next()) {
				retVal.add(new TableVoziloUVlasnistvu(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4),
						rs.getDate(5), rs.getDouble(6), rs.getString(7)));
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
