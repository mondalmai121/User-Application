package org.jsp.userApp.Dto;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class CreateUserTable {

	public static void main(String[] args) {

		Connection con = null;
		Statement st = null;
		Properties p = new Properties();
		FileInputStream fin = null;
		String qry = "create table user(id int not null, name varchar(45) not null, phone bigint(20) not null unique, email varchar(45) not null unique, password varchar(45) not null, primary key(id))";

		try {
			fin = new FileInputStream("D:\\Java Codes\\JDBC\\Class Code\\jdbc.properties");
			p.load(fin);
			Class.forName(p.getProperty("driverClass"));
			con = DriverManager.getConnection(p.getProperty("url"), p);
			st = con.createStatement();
			st.execute(qry);
			System.out.println("user table created");

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (fin != null) {
				try {
					fin.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
