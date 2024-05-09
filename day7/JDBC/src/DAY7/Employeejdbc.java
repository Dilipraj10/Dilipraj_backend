package DAY7;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Employeejdbc {
	
	private static Connection con;
	private static Scanner scan=new Scanner(System.in);
	
	public void insertEmployee() throws SQLException
	{
		while(true) {
			String query = "insert into employee (name, sal, dept) values (?,?,?)"; //dynamic data
			PreparedStatement ps = con.prepareStatement(query);
			System.out.println("please enter the name");
			ps.setString(1, scan.next());
			System.out.println("please enter the Salary");
			ps.setDouble(2, scan.nextDouble());
			System.out.println("please enter the department");
			ps.setString(3, scan.next());
			
			int row= ps.executeUpdate();
			if(row != 0) {
				System.out.println("Record inserted to table");
			}
			System.out.println("Want to insert another Data");
			String value=scan.next();
			if(value.equalsIgnoreCase("no"))
				break;
		}
	}
	
	
	public void selectEmployee() throws SQLException
	{
		System.out.println("Enter the rollnumber to find record");
		int rollumber = Integer.parseInt(scan.nextLine());
		String query = "select * from employee where id =" + rollumber;
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		if(rs.next()) {
			int rollnumber = rs.getInt("Id");
			String name = rs.getString("name");
			double salary = rs.getDouble("sal");
			String department = rs.getString("dept");
			
			System.out.println("rollnumber: " +rollnumber);
			System.out.println("Name: " +name);
			System.out.println("Salary: " +salary);
			System.out.println("Department: " +department);
		}
		else {
			System.out.println("No record founded");
		}
		
	}
	
	public void selectAllEmployee() throws SQLException
	{
		String query = "select * from employee";
		Statement cs = con.createStatement();
		ResultSet rs = cs.executeQuery(query);
		while(rs.next()) {
			int rollnumber = rs.getInt("Id");
			String name = rs.getString("name");
			double salary = rs.getDouble("sal");
			String department = rs.getString("dept");
			
			System.out.println("rollnumber: " +rollnumber);
			System.out.println("Name: " +name);
			System.out.println("Salary: " +salary);
			System.out.println("Department: " +department);
		}	
	}
	
	public void updateEmployee() throws SQLException
	{
		System.out.println("enter the Id to upadate");
		int rollNumber=Integer.parseInt(scan.nextLine());
		String query = "select * from employee where id= " +rollNumber;
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		if(rs.next()) {
			int rollNumber1 = rs.getInt("Id");
			String name = rs.getString("name");
			double salary = rs.getDouble("sal");
			String department = rs.getString("dept");
			
			System.out.println("rollnumber: " +rollNumber1);
			System.out.println("Name: " +name);
			System.out.println("Salary: " +salary);
			System.out.println("Department: " +department);
		}
		else {
			System.out.println("No record founded");
		}
		
		System.out.println("1.For Update Name\n2.For Update Salray\n3.For Update Department");
		int ch= Integer.parseInt(scan.nextLine());
		System.out.println();
		String updateQuery = "Update employee Set";
		
		switch(ch) {
		case 1:
			System.out.println("enter the new name");
			String newName = scan.nextLine();
			updateQuery = updateQuery + " name = ? where id = " + rollNumber; 
			PreparedStatement ps = con.prepareStatement(updateQuery);
			ps.setString(1,newName);
			int row = ps.executeUpdate();
			if(row != 0)
				System.out.println("record updated");
			break;
		
		case 2:
			System.out.println("enter the new salary");
			int newSalray = Integer.parseInt(scan.nextLine());
			updateQuery = updateQuery + " sal = ? where id = " + rollNumber; 
			PreparedStatement ps2 = con.prepareStatement(updateQuery);
			ps2.setInt(1,newSalray);
			int row2 = ps2.executeUpdate();
			if(row2 != 0)
				System.out.println("record updated");
			break;
			
		case 3:
			System.out.println("enter the new department");
			String newdept = scan.nextLine();
			updateQuery = updateQuery + " dept = ? where id = " + rollNumber; 
			PreparedStatement ps3 = con.prepareStatement(updateQuery);
			ps3.setString(1,newdept);
			int row3 = ps3.executeUpdate();
			if(row3 != 0)
				System.out.println("record updated");
			break;
		default:
			System.out.println("invalid");
		}
	}
	
	
	public void deleteEmployee() throws SQLException
	{
		System.out.println("enter the rollnumber to delete");
		int rollNumber = Integer.parseInt(scan.nextLine());
		String sql = " delete from employee where id= " + rollNumber;
		Statement st = con.createStatement();
		int row = st.executeUpdate(sql);
		if(row != 0)
		System.out.println("Record deleted");
	}

	public static void main(String[] args) throws SQLException {
		
		Scanner scan = new Scanner(System.in);
		Employeejdbc ob = new Employeejdbc();
		try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				String url="jdbc:mysql://localhost:3306/jdbc";
				String user = "root";
				String pass = "Sa123";
				con = DriverManager.getConnection(url,user,pass);
			}
		catch(ClassNotFoundException | SQLException e){
			e.printStackTrace();
		}
		
		System.out.println("Enter your choice");
		System.out.println("1.InsertEmployee\n2.SelectEmployee\n3.SelectAllEmployee\n4.UpdateEmployee\n5.DeleteEmployee");
		
		int ch=scan.nextInt();
		switch(ch)
		{
		case 1:
			ob.insertEmployee();
			break;
		case 2:
			ob.selectEmployee();
			break;
		case 3:
			ob.selectAllEmployee();
			break;
		case 4:
			ob.updateEmployee();
			break;
		case 5:
			ob.deleteEmployee();
			break;
			
		default:
			System.out.println("invalid selection");
		}
		
		
	}

}
