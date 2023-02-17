package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import ben.Employee;

public class dboperation {
	static Connection con = null;
	public static void conncect()
	{
		String url = "jdbc:mysql://localhost:3306/java330";
		String uname = "root";
		String upass = "123456789";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con  =  DriverManager.getConnection(url,uname,upass);
		}
		catch(Exception e)
		{
			
		}
	}
	public static void insert(Employee e)
	{
		conncect();
		try {
			PreparedStatement ps =  con.prepareStatement("insert into Employee value(?,?,?,?)");
		    ps.setInt(1, e.getId());
		    ps.setString(2, e.getName());
		    ps.setString(3, e.getDepartment());
		    ps.setInt(4, e.getSalary());
		    if(!ps.execute())
		    {
		    	System.out.println("Data inserted");
		    }
		    else 
		    {
		    	System.out.println("Data not inserted");
		    }
		    con.close();
		}
		catch (Exception f)
		{
		
			f.printStackTrace();
		}
	}

public static void update(Employee e1)
{
	conncect();
	try {
		PreparedStatement ps  = con.prepareStatement("select * from Employee where id = ?");
	    ps.setInt(1, e1.getId());
	    ResultSet rs = ps.executeQuery();
	    rs.next();
	    Employee e = new Employee();
	    e.setName(rs.getString(2));
	    e.setDepartment(rs.getString(3));
	    e.setSalary(rs.getInt(4));
	    if(e1.getName().equals("null"))
	   {
		   e.setName(e1.getName());
	   }
	   if(e1.getDepartment().equals("null"))
	   {
		   e.setDepartment(e1.getDepartment());
	   }
	   if(e1.getSalary()!=0)
	   {
		   e.setSalary(e1.getSalary());
	   }
	   ps = con.prepareStatement("update Employee set name  = ?, Department = ? , salary =  ? where id=?");
	   ps.setString(1, e.getName());
	   ps.setString(2, e.getDepartment());
	   ps.setInt(3, e.getSalary());
	   ps.setInt(4, e1.getId());
	   if(!ps.execute())
	   {
		   System.out.println("data updated ");
	   }
	   else
	   {
		   System.err.println("could not perform update data");
	   }
	   con.close();
	}
	catch (Exception f) 
	{
	  f.printStackTrace();	
	}
}


public static void delete(int id)
{
	
	conncect();
	try {
		PreparedStatement ps = con.prepareStatement("delete from Employee where  id = ?");
		ps.setInt(1, id);
		if(!ps.execute())
		{
			System.out.println("Record deleted");
		}
		con.close();
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
  }
public static void view()
{
	conncect();
	try {
		PreparedStatement ps = con.prepareStatement("select * from employee");
		ResultSet rs  =  ps.executeQuery();
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+"   "+rs.getString(2)+"  "+rs.getString(3)+"  " +rs.getInt(4));
		}
		con.close();
	}
	catch (Exception e) {
		System.out.println();
	}
	}
	
}




















