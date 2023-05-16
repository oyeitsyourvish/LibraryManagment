package CollegeLib;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class User {

	public static void main(String[] args) 
		 throws SQLException {
				// TODO Auto-generated method stub
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/collegelibrary", "root", "root");
				System.out.println("Connection Established Successfully....");
				
				Statement st = con.createStatement();
				System.out.println("Statement Created Successfully...");
				
				
				
				st.execute("create table user (id int, name varchar(20), gmail varchar(30))");
				System.out.println("User table created inside collegelibrary database");
				

			

	}

}
