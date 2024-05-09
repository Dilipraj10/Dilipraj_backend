package DAY7;


import java.sql.*;
import java.util.Scanner;

public class Studentjdbc {
	
	private void selectRecord() throws SQLException
	{
		System.out.println();
	}

	public static void main(String[] args) {
		try {
			Scanner scan = new Scanner(System.in);
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/jdbc";
			String user = "root";
			String pass = "Sa123";
			Connection con = DriverManager.getConnection(url,user,pass);
//			String query = "insert into student (name, percentage, address) values ('john',78.2,'banglore')";
			String query = "insert into student (name, percentage, address) values (?,?,?)"; //dynamic data
			PreparedStatement ps = con.prepareStatement(query);
			System.out.println("please enter the name");
			ps.setString(1, scan.next());
			System.out.println("please enter the percentage");
			ps.setDouble(2, scan.nextDouble());
			System.out.println("please enter the address");
			ps.setString(3, scan.next());
			
			int execute = ps.executeUpdate();
			System.out.println(execute);
			

			}
		catch(ClassNotFoundException | SQLException e){
			e.printStackTrace();
		}
		
	}

}
