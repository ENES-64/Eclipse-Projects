package databasesqlite;

import java.sql.*;
import java.util.Scanner;

public class DatabaseSQLite {
	public static void main(String[] args) throws Exception {
		//Driver that talks with the database.
		Class.forName("org.sqlite.JDBC");
		//Connection to the driver.
		Connection con = DriverManager.getConnection("jdbc:sqlite:C:\\users\\enesy\\myjava\\eclipse\\myeclipse\\sqlite\\univ.db");
		//The statement that the connection returns from the connection.
		Statement stm = con.createStatement();
		//Storing the statement.
		ResultSet rs = stm.executeQuery("select * from dept");
		
		int dno;
		String dname;
		while(rs.next()) {
			dno = rs.getInt("deptno");
			dname = rs.getString("dname");
			System.out.println(dno + " | " + dname);
		}
		System.out.println();
		ResultSet rs2 = stm.executeQuery("select * from students");
		while(rs2.next()) {
			System.out.print(rs2.getInt("roll") + " | ");
			System.out.print(rs2.getString("name") + " | ");
			//We can give the column number instead.
			System.out.print(rs2.getString(3) + " | ");
			System.out.println(rs2.getInt(4));
		}
		//Prepared statements are useful if your query has a parameter. 
		//Prepared statements' queries are predefined and '?' is used for identfying the parameters.
		PreparedStatement pstm = con.prepareStatement("select * from students where deptno=?");
		
		Scanner sc =new Scanner(System.in);
		System.out.println("\nEnter department number: ");
		dno = sc.nextInt();
		
		pstm.setInt(1, dno);
		ResultSet rs3 = pstm.executeQuery();
		
		while(rs3.next()) {
			System.out.print(rs3.getInt(1) + " | ");
			System.out.print(rs3.getString(2) + " | ");
			System.out.print(rs3.getString(3) + " | ");
			System.out.println(rs3.getInt(4));
		}
		System.out.println();
		//DML - Data Manipulation Langauge
		//DML is used for adding, deleting, or changing the data.
		stm.executeUpdate("insert into dept values(60,'chem')");
		stm.executeUpdate("delete from dept where deptno>=60");
		stm.executeUpdate("update dept set dname='Chem' where deptno=50");
		
		stm.executeUpdate("update dept set dname='Areo' where deptno=50");
		
		//DML using prepared statement.
		PreparedStatement pstm2 = con.prepareStatement("insert into students values(?,?,?,?)");
		int roll = 7;
		String name = "Jack";
		String city = "AL";
		dno = 50;
		pstm2.setInt(1, roll);
		pstm2.setString(2, name);
		pstm2.setString(3, city);
		pstm2.setInt(4, dno);
		
		pstm2.executeUpdate();
		
		ResultSet rs4 = stm.executeQuery("select * from students");
		
		while(rs4.next()) {
			System.out.print(rs4.getInt(1) + " | ");
			System.out.print(rs4.getString(2) + " | ");
			System.out.print(rs4.getString(3) + " | ");
			System.out.println(rs4.getInt(4));
		}
		
		stm.executeUpdate("delete from students where roll>=7");
		
		//DDL - Data Definition Language
		//This is used for creating or deleting a table.
		//Since creating and deleting a table is not frequently done, it's preferable
		//to do it on a prompt of a database rather than doing it in a program.
		//Adding a table.
		stm.executeUpdate("create table temp(a integer, b float)");
		//Deleting a table.
		stm.executeUpdate("drop table temp");
		
		//Closing everything.
		stm.close();
		pstm.close();
		pstm2.close();
		con.close();
		sc.close();
	}
}