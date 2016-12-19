package tools.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import tools.core.model.TableColumnDesc;

/**
 * 
 * @author zhuss
 *
 */
public class MySQLConnect {
	
	public static Connection con;
	static {
		String url = "jdbc:mysql://localhost:3306/blog";
		String username = "root";
		String password = "zhushunshan123";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static List<String> getAllTables(String sql, String dbName)
			throws SQLException {
		List<String> list = new ArrayList<String>();
		Statement stt = con.createStatement();
		ResultSet rs = stt.executeQuery(sql);
		while (rs.next()) {
			list.add(rs.getString("Tables_in_" + dbName));
		}
		return list;
	}

	public static List<TableColumnDesc> getColumns(String sql) throws SQLException{
		List<TableColumnDesc> result = new ArrayList<TableColumnDesc>();
		Statement stt = con.createStatement();
		System.out.println(sql);
		ResultSet rs =  stt.executeQuery(sql);
		while (rs.next()) {
			TableColumnDesc tcd = new TableColumnDesc();
			tcd.setField(rs.getString("FIELD"));
			tcd.setType(rs.getString("TYPE"));
			tcd.setIsKey(rs.getString("KEY"));
			tcd.setIsNull(rs.getString("NULL"));
			tcd.setExtra(rs.getString("EXTRA"));
			tcd.setDefault_(rs.getString("DEFAULT"));
			result.add(tcd);
			System.out.println(tcd);
		}
		return result;
	}
	

}
