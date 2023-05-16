package CollegeLib;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Library {
	public static void main(String [] args) throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/collegelibrary","root", "root");
		
		Scanner sc = new Scanner (System.in);
		for(;;) {
		System.out.println("1.Admin               2.User");
		switch(sc.nextInt()) {
		case 1:{
			System.out.println("1.Add Book       2.View Book By id       3.View all Book 	    4.Update Book          5. Delete Book");
			switch(sc.nextInt()) {
			case 1:{
				//1.ADD BOOK 
				PreparedStatement ps1= con.prepareStatement("insert into book (id,bookname,author, genre) values(?,?,?,?)");
				System.out.println("Ente the Id");
				int id = sc.nextInt();
				System.out.println("Ente the Book Name");
				String bookname = sc.next();
				System.out.println("Ente the Author name");
				String author = sc.next();
				System.out.println("Ente the Ganre name");
				String genre = sc.next();
				ps1.setInt(1, id);
				ps1.setString(2, bookname);
				ps1.setString(3, author);
				ps1.setString(4, genre);
				ps1.execute();
				System.err.println("Book Added Successfully...");
				return;
			}
			case 2:{
				//2.View Book By Id  
				PreparedStatement ps=con.prepareStatement("select * from book where id =?");
				
				System.out.println("Enter the Id to find");
				int id =sc.nextInt();
				
				ps.setInt(1, id);;
				ResultSet rs = ps.executeQuery();
				if(rs.next()) {
					System.out.println(rs.getInt(1));
					System.out.println(rs.getString(2));
					System.out.println(rs.getString(3));
					System.out.println(rs.getString(4));
					
				}else {
					System.err.println("Id is Not present into database");
					
				}
				return;
				
			}
			// ---------------------------------------------------------------------------------------------------end case2
			
			
			case 3:{
				//3.View All Book 
				Statement st =  con.createStatement();
				ResultSet rs = st.executeQuery("select * from book");
				
				while(rs.next()) {
					System.out.println(rs.getInt(1));
					System.out.println(rs.getString(2));
					System.out.println(rs.getString(3));
					System.out.println(rs.getString(4));
					System.out.println("-----------------------------------------------");
				   
				}
				return;
				
			}
			//---------------------------------------------------------------------------------------------------------end of case3
			
	
			case 4:{
				//UPDATE BOOK
				System.out.println("1.Update Book Name		2.Update Book Author		3.Update Book Ganre");
				switch(sc.nextInt()) {
				case 1 :{
					PreparedStatement ps=con.prepareStatement("update book set bookname=? where id=?");
					System.out.println("Enter the New name to Book");
					String bookname =sc.next();
					System.out.println("Enter the ID to Update");
					int id = sc.nextInt();
					ps.setString(1,bookname); 
					ps.setInt(2, id);
					ps.execute();
					System.out.println("Book Name Updated Successfully...");
					return;
					
				}//case 1 of Udate Book name
				case 2 :{
					PreparedStatement ps=con.prepareStatement("update book set author=? where id=?");
					System.out.println("Enter the New Author Name to Book");
					String author =sc.next();
					System.out.println("Enter the ID to Update");
					int id = sc.nextInt();
					ps.setString(1,author);
					ps.setInt(2, id);
					ps.execute();
					System.out.println("Author Name Updated Successfully...");
					return;
					
				}//-------update book author name
				
				case 3 :{
					PreparedStatement ps=con.prepareStatement("update book set genre=? where id=?");
					System.out.println("Enter the New Ganre Name to Book");
					String genre =sc.next();
					System.out.println("Enter the ID to Update");
					int id = sc.nextInt();
					ps.setString(1,genre);
					ps.setInt(2, id);
					ps.execute();
					System.out.println("Ganre Name Updated Successfully...");
					return;
					
				}//-------update book Ganre name
				
				}
				
				
			}
			//---------------------------------------------------------------------------------------------------------------end of case 4.
			
			
			case 5:{
				// 5.Delete Book.
				
				PreparedStatement ps=con.prepareStatement("delete from book where id =?");
				System.out.println("Enter the Id");
				int id =sc.nextInt();
				ps.setInt(1, id);
				ps.execute();
				System.out.println("Book is deleted Successfully...");
				
				
			}
			
			
			
			
			}
			// INNER SWITCH END in case 1----------------------------------
			
			break;
			}
		
		//--------------------------------------------------------------------------------------------------------------------------------------
         //------------------------------------------------------------------------------------------------------------------------------------
		
		case 2:{
			System.out.println("1.Create Acc      2.View Book By Id      3.View Book By Author        4.View Book by Book Name      5.View User By Name ");
			switch(sc.nextInt()) {
			case 1:{
				//1.Create Acc 
				PreparedStatement ps= con.prepareStatement("insert into user (id,name,gmail) values(?,?,?)");
				System.out.println("Ente the Id");
				int id = sc.nextInt();
				System.out.println("Ente the Name");
				String name = sc.next();
				System.out.println("Ente the Gmail");
				String gmail = sc.next();
				ps.setInt(1, id);
				ps.setString(2, name);
				ps.setString(3, gmail);
				ps.execute();
				System.err.println("Account created Successfully...");
				return;
			
		}//end case 1
			case 2:{
//				2.View Book By Id  
				//this case searching from book id number not user id number
				PreparedStatement ps=con.prepareStatement("select * from book where id =?");
				
				System.out.println("Enter the Id to find");
				int id =sc.nextInt();
				
				ps.setInt(1, id);;
				ResultSet rs = ps.executeQuery();
				if(rs.next()) {
					System.out.println(rs.getInt(1));
					System.out.println(rs.getString(2));
					System.out.println(rs.getString(3));
					System.out.println(rs.getString(4));
					
				}else {
					System.err.println("Id is Not present into database");
					
				}
				return;
				
			}// end case2
			
			case 3:{
				//3.View Book By Author 
				PreparedStatement ps=con.prepareStatement("select * from book where author =?");
				
				System.out.println("Enter the Author to find");
				String  author =sc.next();
				
				ps.setString(1, author);;
				ResultSet rs = ps.executeQuery();
				if(rs.next()) {
					System.out.println(rs.getInt(1));
					System.out.println(rs.getString(2));
					System.out.println(rs.getString(3));
					System.out.println(rs.getString(4));
					
				}else {
					System.err.println("Author name book is Not present into database");
					
				}
				return;
			}//ende case 3
			
			case 4:{
				// 4.View Book by Book name 
				PreparedStatement ps=con.prepareStatement("select * from book where bookname =?");
				
				System.out.println("Enter the Book Name to find");
				String  bookname =sc.next();
				
				ps.setString(1, bookname);;
				ResultSet rs = ps.executeQuery();
				if(rs.next()) {
					System.out.println(rs.getInt(1));
					System.out.println(rs.getString(2));
					System.out.println(rs.getString(3));
					System.out.println(rs.getString(4));
					
				}else {
					System.err.println("Book is Not present into database");
					
				}
				return;
				
				
			} //---- end case 4
			
			case 5:{
				// 4.View Book by Book name 
				PreparedStatement ps=con.prepareStatement("select * from user where name =?");
				
				System.out.println("Enter the User Name to find");
				String  name =sc.next();
				
				ps.setString(1, name);;
				ResultSet rs = ps.executeQuery();
				if(rs.next()) {
					System.out.println(rs.getInt(1));
					System.out.println(rs.getString(2));
					System.out.println(rs.getString(3));
					
				}else {
					System.err.println("this  Name User is Not present into database");
					
				}
				return;
				
			}//----- end case 5.
				}
			}
		}
		//	OUTER SWITCH END------------------------------------
		}
	}
		
}

