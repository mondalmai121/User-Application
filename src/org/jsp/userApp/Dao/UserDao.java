package org.jsp.userApp.Dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.jsp.userApp.Dto.User;

public class UserDao {

	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs = null;

	{
		Properties p = new Properties();
		FileInputStream fin = null;
		try {
			fin = new FileInputStream("D:\\Java Codes\\JDBC\\Class Code\\jdbc.properties");
			p.load(fin);
			con = DriverManager.getConnection(p.getProperty("url"), p);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fin != null) {
				try {
					fin.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public String SaveUser(User u) {
		String qry = "insert into user values(?,?,?,?,?)";
		try {
			pst = con.prepareStatement(qry);
			pst.setInt(1, u.getId());
			pst.setString(2, u.getName());
			pst.setLong(3, u.getPhone());
			pst.setString(4, u.getEmail());
			pst.setString(5, u.getPassword());
			pst.executeUpdate();
			return "user values inserted successfully......";
		} catch (Exception e) {
			return "unable to insert user values........";
		}
	}

	public String UpdateUser(User u) {
		String qry = "update user set name=?, phone=?, email=?, password=?  where id=?";
		try {
			pst = con.prepareStatement(qry);
			pst.setString(1, u.getName());
			pst.setLong(2, u.getPhone());
			pst.setString(3, u.getEmail());
			pst.setString(4, u.getPassword());
			pst.setInt(5, u.getId());
			pst.executeUpdate();
			return "user values updated successfully.......";
		} catch (Exception e) {
			return "unable to update user values........";
		}
	}

	public User VerifyUser(long phone, String password) {
		String qry = "select * from user where phone=? and password=?";
		try {
			pst = con.prepareStatement(qry);
			pst.setLong(1, phone);
			pst.setString(2, password);
			rs = pst.executeQuery();
            User u=new User();
			
            if (rs.next()) {
				u.setId(rs.getInt("id"));
				u.setName(rs.getString("name"));
				u.setEmail(rs.getString("email"));
				return u;
			} else {
				return null;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public User VerifyUser(String email, String password) {
		String qry = "select * from user where email=? and password=?";
		try {
			pst = con.prepareStatement(qry);
			pst.setString(1, email);
			pst.setString(2, password);
			rs = pst.executeQuery();
			User u=new User();

			   if (rs.next()) {
					u.setId(rs.getInt("id"));
					u.setName(rs.getString("name"));
					u.setPhone(rs.getLong("phone"));
					return u;
				} else {
					return null;
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				return null;
		}
	}
	
	public User verifyUser(int id, String password) {
		String qry="select * from user where id=? and password=?";
		try {
			pst=con.prepareStatement(qry);
			pst.setInt(1, id);
			pst.setString(2, password);
			rs=pst.executeQuery();
			User u=new User();
			if(rs.next()) {
				u.setName(rs.getString("name"));
				u.setEmail(rs.getString("email"));
				u.setPhone(rs.getLong("phone"));
				return u;
			}else {
				return null;
			}
		}catch(Exception e) {
	     e.printStackTrace();
	     return null;
	}
}

	public User findUser(int id) {
		String qry = "select * from user where id=?";
		try {
			pst = con.prepareStatement(qry);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			User u=new User();

			if (rs.next()) {
				u.setName(rs.getString("name"));
				u.setPhone(rs.getLong("phone"));
				u.setEmail(rs.getString("email"));
				u.setPassword(rs.getString("password"));
				u.setId(rs.getInt("id"));
				System.out.println("========================");
				return u;
			} else {
				return null;
			}
		
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public User findUser(long phone) {
		String qry="select * from user where phone=?";
		try {
			pst=con.prepareStatement(qry);
			pst.setLong(1, phone);
			rs=pst.executeQuery();
			User u=new User();
			
			if(rs.next()) {
				u.setId(rs.getInt("id"));
				u.setName(rs.getString("name"));
				u.setPhone(rs.getLong("phone"));
				u.setEmail(rs.getString("email"));
				u.setPassword(rs.getString("password"));
				return u;
		     }else {
		    	 return null;
		     }
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public User findUser(int id, String name) {
		String qry="select * from user where id=? and name=?";
		try {
			pst=con.prepareStatement(qry);
			pst.setInt(1, id);
			pst.setString(2, name);
			rs=pst.executeQuery();
			User u=new User();
			if(rs.next()) {
				u.setId(rs.getInt("id"));
				u.setName(rs.getString("name"));
				u.setPhone(rs.getLong("phone"));
				u.setEmail(rs.getString("email"));
				u.setPassword(rs.getString("password"));
				return u;
		     }else {
		    	 return null;
		     }
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public User deleteUser(int id) {
		String qry = "delete from user where id=?";
		try {
			pst = con.prepareStatement(qry);
			pst.setInt(1, id);
			int r = pst.executeUpdate();
			User u=new User();
			if (r == 1) {
				return u;
			}else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public User deleteUser(String password) {
		String qry="delete from user where password=?";
		try {
			pst=con.prepareStatement(qry);
			pst.setString(1, password);
			int n=pst.executeUpdate();
			User u=new User();
			if(n==1) {
				return u;
			}else {
				return null;
			}
		}catch(Exception e ) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<User> findAll() {
		String qry="select * from user";
		List<User> users=new ArrayList<>();
		try {
			pst=con.prepareStatement(qry);
			rs=pst.executeQuery();
			while(rs.next()) {
				User u=new User();
				u.setId(rs.getInt("id"));
				u.setName(rs.getString("name"));
				u.setPhone(rs.getLong("phone"));
				u.setEmail(rs.getString("email"));
				u.setPassword(rs.getString("password"));
				users.add(u);
			}
			return users;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String exit() throws Exception {

		if (con != null)
			con.close();
		if (pst != null)
			pst.close();
		if (rs != null)
			rs.close();

		for (int i=0;i<8;i++) {
			System.err.print("*");
			Thread.sleep(500);
		}

		return "Application Closed.......!!!!!!";
	}
}
