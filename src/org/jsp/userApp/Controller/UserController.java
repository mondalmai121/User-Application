package org.jsp.userApp.Controller;

import java.util.List;
import java.util.Scanner;

import org.jsp.userApp.Dao.UserDao;
import org.jsp.userApp.Dto.User;

public class UserController {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		UserDao dao = new UserDao();
		System.out.println("<<//==================WELCOME TO USER MANAGEMENT SYSTEM==================\\>>");
		boolean f = true;

		while (f) {
			System.out.println("<<***** 1.Save User *****>>");
			System.out.println("<<***** 2.Update User using id *****>>");
			System.out.println("<<***** 3.Verify user by phone & password *****>>");
			System.out.println("<<***** 4.Verify user by email & password *****>>");
			System.out.println("<<***** 5.Verify user by id & password *****>>");
			System.out.println("<<***** 6.find user by id *****>>");
			System.out.println("<<***** 7.find user by phone *****>>");
			System.out.println("<<***** 8.find user by id & name *****>>");
			System.out.println("<<***** 9.Delete user by id *****>>");
			System.out.println("<<***** 10.Delete user by password *****>>");
			System.out.println("<<***** 11.Display All the users *****>>");
			System.out.println("<<***** 12.Exit *****>>");
 
			switch (sc.nextInt()) {

			case 1: {
				System.out.println("Enter the user id, user name, user phone, user email, user password");
				int id = sc.nextInt();
				String name = sc.next();
				long phone = sc.nextLong();
				String email = sc.next();
				String password = sc.next();
				User u=new User(id,name,phone,email,password);
				String message = dao.SaveUser(u);
				System.out.println(message);
				break;
			}

			case 2:{
				System.out.println("Update the user name, user phone, user email, user password using id");
				String name = sc.next();
				long phone = sc.nextLong();
				String email = sc.next();
				String password = sc.next();
				int id= sc.nextInt();
				User u=new User(id,name,phone,email,password);
				String message=dao.UpdateUser(u);
				System.out.println(message);
				break;
			}
			case 3:{
				    System.out.println("Verify the user using user phone & user password");
			        long phone=sc.nextLong();
			        String password=sc.next();
			        User u=dao.VerifyUser(phone, password);
			        if(u!=null) {
			        	System.out.println("user verified successfully....");
			        	System.out.println("User id: "+u.getId());
			        	System.out.println("User name: "+u.getName());
			        	System.out.println("User email: "+u.getEmail());
			        	System.out.println("====================");
			        	
			        }else {
			        	System.err.println("user not verified.......");
			        }
			        break;
			}
			case 4: {
				    System.out.println("Verify the user using user email & user password");
			        String email=sc.next();
			        String password=sc.next();
			        User u=dao.VerifyUser(email, password);
			        if(u!=null) {
			        	System.out.println("user verified successfully....");
			        	System.out.println("User id: "+u.getId());
			        	System.out.println("User name: "+u.getName());
			        	System.out.println("User phone no: "+u.getPhone());
			        	System.out.println("====================");
			        }else {
			        	System.err.println("user not verified.......");
			        }
			        break;
			}
			case 5:{
				    System.out.println("Verify user using user id & user password");
				    int id=sc.nextInt();
				    String password=sc.next();
				    User u=dao.verifyUser(id, password);
				    if(u!=null) {
				    	System.out.println("User verified successfully.....");
				    	System.out.println("User name: "+u.getName());
				    	System.out.println("User email: "+u.getEmail());
				    	System.out.println("User phone no: "+u.getPhone());
				    	System.out.println("====================");
				    }else {
				    	System.err.println("user not verified......");
				    }
				    break;
			}
			case 6:{
				    System.out.println("Enter the user id to find");
				    int id=sc.nextInt();
				    User u=dao.findUser(id);
				    if(u!=null) {
				    	System.out.println("user found successfully.......");
				    	System.out.println("User id: "+u.getId());
			        	System.out.println("User name: "+u.getName());
			        	System.out.println("User phone no: "+u.getPhone());
			        	System.out.println("User email: "+u.getEmail());
			        	System.out.println("User password: "+u.getPassword());
			        	System.out.println("====================");
				    }else {
				    	System.err.println("user not found.......");
				    }
				    break;
			}
			case 7:{
				    System.out.println("Enter the user phone no to find");
				    long phone=sc.nextLong();
				    User u=dao.findUser(phone);
				    if(u!=null) {
				    	System.out.println("user found successfully.......");
				    	System.out.println("User id: "+u.getId());
			        	System.out.println("User name: "+u.getName());
			        	System.out.println("User phone no: "+u.getPhone());
			        	System.out.println("User email: "+u.getEmail());
			        	System.out.println("User password: "+u.getPassword());
			        	System.out.println("====================");
				    }else {
				    	
				    	System.err.println("user not found.......");
				    }
				    break;
			}
			
			case 8:{
				    System.out.println("Enter the user id & user name to find");
				    int id=sc.nextInt();
				    String name=sc.next();
				    User u=dao.findUser(id, name);
				    if(u!=null) {
				    	System.out.println("user found successfully.......");
				    	System.out.println("User id: "+u.getId());
			        	System.out.println("User name: "+u.getName());
			        	System.out.println("User phone no: "+u.getPhone());
			        	System.out.println("User email: "+u.getEmail());
			        	System.out.println("User password: "+u.getPassword());
			        	System.out.println("====================");
				    }else {
				    	System.err.println("user not found.......");
				    }
				    break;
			}
			case 9: {
				    System.out.println("Delete the user value using id");
				    int id=sc.nextInt();
				    User u=dao.deleteUser(id);
				    if(u!=null) {
				    	System.out.println("user deleted successfully.......");
				    }else {
				    	System.err.println("entered wrong Id......");
				    }
				    break;
			}
			case 10:{
				    System.out.println("Delete the user value using password");
				    String password=sc.next();
				    User u=dao.deleteUser(password);
				    if(u!=null) {
				    	System.out.println("user deleted successfully......");
				    }else {
				    	System.err.println("Entered wrong password......");
				    }
				    break;
			}
			case 11:{
				List<User> users=dao.findAll();
				if(users.size()>0) {
					for(User u:users) {
						System.out.println("user found successfully.......");
				    	System.out.println("User id: "+u.getId());
			        	System.out.println("User name: "+u.getName());
			        	System.out.println("User phone no: "+u.getPhone());
			        	System.out.println("User email: "+u.getEmail());
			        	System.out.println("User password: "+u.getPassword());
			        	System.out.println("============================");
					}
				}else {
					System.err.println("No user present in database.......");
				}
				break;
			}
			case 12:{
				f = false;
				try {
					System.out.println(dao.exit());
					sc.close();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			}
		}
	}
}
