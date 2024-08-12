package com.comfast.crm.generic.fileutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DataBaseUtility {
	Connection con;
	public void getDbconnection(String url,String username,String password)throws SQLException {
		try {
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			con=DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void getDbconnection()throws SQLException {
		try {
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			con=DriverManager.getConnection("jsbc:mysql://localhost:3306/projects","admin","admin");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void closeDbconnection()throws SQLException {
		try {
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	public ResultSet executeSelectQuery(String query) throws Throwable{
		ResultSet result=null;
		try {
			Statement stat=con.createStatement();
			result=stat.executeQuery(query);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}
	public int executeNonSelectQuery(String query) throws Throwable{
		int result=0;
		try {
			Statement stat=con.createStatement();
			result=stat.executeUpdate(query);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}
	

}
