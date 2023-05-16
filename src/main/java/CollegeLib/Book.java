package CollegeLib;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Book {

	public static void main(String[] args) 
		 throws SQLException {
				// TODO Auto-generated method stub
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/collegelibrary", "root", "root");
				System.out.println("Connection Established Successfully....");
				
				Statement st = con.createStatement();
				System.out.println("Statement Created Successfully...");
				
				
				
				st.execute("create table book (id int, bookname varchar(20), author varchar(10), genre varchar(10))");
				System.out.println("Book table created inside collegelibrary database");
				

			

	}

}
