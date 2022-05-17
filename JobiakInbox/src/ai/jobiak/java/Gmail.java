package ai.jobiak.java;

import java.sql.DriverManager;
import java.sql.ResultSet;


import java.sql.*;
import java.util.Scanner;


public class Gmail
{
	
	public void creatingmail() throws SQLException
	{
		String userName = "root";
		String password = "admin";
		String url = "jdbc:mysql://localhost:3306/assignment2";

		Connection conn = DriverManager.getConnection(url,userName,password);
		System.out.println("Connected to db...");
		
		Statement st1 = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
		
		String createSQL="CREATE TABLE assignment2.mail"+"(mailid INT NOT NULL,"+"mailfrom VARCHAR(45) NOT NULL," +""+"mailsubject VARCHAR(45) NOT NULL," +""+"content VARCHAR(45) NOT NULL,"+""+"size DOUBLE NOT NULL,"+ ""+"PRIMARY KEY (mailid))";
		st1.execute(createSQL);
		System.out.println("Table is Created");
				
		String mailfrom[]= {"Sai@jobiak.com","happy@jobiak.com","Mani@jobiak.com","lakshmi@jobiak.com","Sri@jobiak","Srujana@jobiak"};
		String mailsubject[] = {"congrats on your selection","Greetings on your welcome","welcome to jobiak family","Happy 1st day","Keep going"}; 
		String content[] = {"wish you all the best","keep going","welcome on 1st day","Happy 1st day","welcome to jobiak","congrats on your work"};
		double size[] = {100,120,140,80,60};
		for(int i=1;i<mailfrom.length;i++)
		{
		PreparedStatement pstmt = conn.prepareStatement("insert into mail values(?,?,?,?,?)");
		pstmt.setInt(1, i+0);
		pstmt.setString(2,mailfrom[i]);
		pstmt.setString(3,mailsubject[i]);
		pstmt.setString(4,content[i]);
		pstmt.setDouble(5,size[i]);
		int count = pstmt.executeUpdate();
		System.out.println(count+"Record Inserted");
		}
	}
	public void first() throws SQLException
	{
		String userName = "Srujana";
		String password = "sAi@2235#dk";
		String url = "jdbc:mysql://localhost:3306/sys";
		Connection conn = DriverManager.getConnection(url,userName,password);
		Statement st1 = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
		String selectSQL = "select * from mail";
		ResultSet rs = st1.executeQuery(selectSQL);
		rs.first();
		System.out.println(rs.getString(1)+"::"+rs.getString(2)+"::"+rs.getString(3)+"::"+rs.getString(3)+"::"+rs.getString(4)+"::"+rs.getString(5));
	}
	public void next() throws SQLException
	{
		String userName = "Srujana";
		String password = "sAi@2235#dk";
		String url = "jdbc:mysql://localhost:3306/sys";
		Connection conn = DriverManager.getConnection(url,userName,password);
		Statement st1 = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
		String selectSQL = "select * from mail";
		ResultSet rs = st1.executeQuery(selectSQL);
		rs.first();
		rs.next();
		System.out.println(rs.getString(1)+"::"+rs.getString(2)+"::"+rs.getString(3)+"::"+rs.getString(3)+"::"+rs.getString(4)+"::"+rs.getString(5));	
	}
	public void previousmail() throws SQLException
	{
		String userName = "Srujana";
		String password = "sAi@2235#dk";
		String url = "jdbc:mysql://localhost:3306/sys";
		Connection conn = DriverManager.getConnection(url,userName,password);
		Statement st1 = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
		String selectSQL = "select * from mail";
		ResultSet rs = st1.executeQuery(selectSQL);
		rs.first();
		rs.next();
		rs.previous();
		System.out.println(rs.getString(1)+"::"+rs.getString(2)+"::"+rs.getString(3)+"::"+rs.getString(3)+"::"+rs.getString(4)+"::"+rs.getString(5));	
	}
	public void lastmail() throws SQLException
	{
		String userName = "Srujana";
		String password = "sAi@2235#dk";
		String url = "jdbc:mysql://localhost:3306/sys";
	  Connection conn = DriverManager.getConnection(url,userName,password);
		Statement st1 = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
		String selectSQL = "select * from mail";
		ResultSet rs = st1.executeQuery(selectSQL);
		rs.last();
		System.out.println(rs.getString(1)+"::"+rs.getString(2)+"::"+rs.getString(3)+"::"+rs.getString(3)+"::"+rs.getString(4)+"::"+rs.getString(5));	
	}
	public void gotomail() throws SQLException
	{
		String userName = "Srujana";
		String password = "sAi@2235#dk";
		String url = "jdbc:mysql://localhost:3306/sys";
		Connection conn = DriverManager.getConnection(url,userName,password);
		Statement st1 = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
		String selectSQL = "select * from mail";
		ResultSet rs = st1.executeQuery(selectSQL);
		System.out.println("Enter value");
		int mailnumber;
		Scanner sc = new Scanner(System.in);
		mailnumber = sc.nextInt();
		rs.absolute(mailnumber);
		System.out.println(rs.getString(1)+"::"+rs.getString(2)+"::"+rs.getString(3)+"::"+rs.getString(3)+"::"+rs.getString(4)+"::"+rs.getString(5));	
	}
	public void detailsDisplay() throws SQLException
	{
		int ch;
		System.out.println("");
		System.out.println("1.First \n 2.Next \n 3.Pervious \n 4.Last \n 5.Go To \6.Exit");
		System.out.println("Select:");
		Scanner sc = new Scanner(System.in);
		ch = sc.nextInt();
		switch (ch)
		{
		case 1:
			System.out.println("First Mail");
			Gmail a1 = new Gmail();
			a1.first();
			break;
		case 2:
			System.out.println("Next Mail");
			Gmail a2 = new Gmail();
			a2.next();
			break;
		case 3:
			System.out.println("Pervious Mail");
			Gmail a3 = new Gmail();
			a3.previousmail();
			break;
		case 4:
			System.out.println("Last Mail");
			Gmail a4 = new Gmail();
			a4.lastmail();
			break;
		
		case 5:
			System.out.println("Thank You");
			break;
		}
		while(ch!=6);
	}	
	public static void main(String[] args) throws SQLException 
	{
		Gmail a = new Gmail();
		a.detailsDisplay();
	}
}