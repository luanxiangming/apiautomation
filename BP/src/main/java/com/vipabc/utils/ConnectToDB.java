package com.vipabc.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import shelper.db.Oracle;

public class ConnectToDB {

	private Connection conn;

	public ConnectToDB() {
		String driver = "com.mysql.jdbc.Driver";

		String url = "jdbc:mysql://192.168.1.5:3306/hoss";

		String user = "hoss";

		String password = "hoss123";

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			if (!conn.isClosed())
				System.out.println("Succeeded connecting to the Database!");
		} catch (ClassNotFoundException e) {

			System.out.println("Sorry,can't find the Driver!");
			e.printStackTrace();

		} catch (SQLException e) {

			e.printStackTrace();

		} catch (Exception e) {

			e.printStackTrace();

		}
	}

	public String query(String table, String key) throws SQLException {
		Statement statement = conn.createStatement();

		ResultSet rs = statement.executeQuery("select * from " + table);
		String str = null;
		while (rs.next()) {
			str = rs.getString(key);
			System.out.println(str);
			return str;
		}
		rs.close();
		conn.close();
		return null;
	}

	public String query(String sql) throws SQLException {
		Statement statement = conn.createStatement();

		ResultSet rs = statement.executeQuery(sql);
		String str = null;
		while (rs.next()) {
			str = rs.toString();
			System.out.println(str);
			return str;
		}
		rs.close();
		return null;
	}

	public void insert(String sql) throws SQLException {
		Statement statement = conn.createStatement();
		statement.executeUpdate(sql);
	}
	public void update(String sql) throws SQLException {
		Statement statement = conn.createStatement();
		statement.executeUpdate(sql);
	}
	public void delete(String sql) throws SQLException {
		Statement statement = conn.createStatement();
		statement.executeUpdate(sql);
	}
	  public void closeDBcon(){
	        try {
	            conn.close();
	        } catch (SQLException ex) {
	             Logger.getLogger(Oracle.class.getName()).log(Level.SEVERE, null, ex);
	        }
	      }

	public static void main(String args[]) throws SQLException {
		ConnectToDB cdb = new ConnectToDB();
		cdb.query("visit_identitify_code", "code_value");
		cdb.query("visit_identitify_code", "status");
//		cdb.insert("INSERT INTO visit_identitify_code"
//				+ "   (`id`, `creater`, `create_time`, `modifier`, `modify_time`, `version`, `code_value`, `follow_id`, `status`, `client_linkman_id`)"
//				+ "VALUES   (3, -1, '2014/5/29 17:00:00', NULL, NULL, 0, '4321', 1, 'visiting', 1);");
	}
}
