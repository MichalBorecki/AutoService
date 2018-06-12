package pl.coderslab.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class MySQLHelper {

	public static ResultSet executeQuery(Connection con, String sql, String... conditions) throws SQLException {
		PreparedStatement stm = con.prepareStatement(sql);
		for (int i = 1; i <= conditions.length; i++) {
			stm.setString(i, conditions[i - 1]);
		}
		ResultSet rs = stm.executeQuery();
		return rs;
	}

	public static ResultSet executeQueryInt(Connection con, String sql, int... conditions) throws SQLException {
		PreparedStatement stm = con.prepareStatement(sql);
		for (int i = 1; i <= conditions.length; i++) {
			stm.setInt(i, conditions[i - 1]);
		}
		ResultSet rs = stm.executeQuery();
		return rs;
	}

	public static void executeUpdate(Connection con, String sql, String... conditions) throws SQLException {
		PreparedStatement stm = con.prepareStatement(sql);
		for (int i = 1; i <= conditions.length; i++) {
			stm.setString(i, conditions[i - 1]);
		}
		stm.executeUpdate();
	}

	public static void executeUpdate(Connection con, String sql, int... conditions) throws SQLException {
		PreparedStatement stm = con.prepareStatement(sql);
		for (int i = 1; i <= conditions.length; i++) {
			stm.setInt(i, conditions[i - 1]);
		}
		stm.executeUpdate();
	}

	public static void printResultSet(ResultSet rs) throws SQLException {
		ResultSetMetaData meta = rs.getMetaData();
		while (rs.next()) {
			for (int i = 1; i <= meta.getColumnCount(); i++) {
				System.out.print(String.format("%s: %s, ", meta.getColumnName(i), rs.getString(i)));
			}
			System.out.println();
		}
	}

}
