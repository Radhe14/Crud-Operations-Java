package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import ben.hospital;

public class dboperation {
   static Connection con = null;
	public static void conncect()
	{
		String url = "jdbc:mysql://localhost:3306/hospital";
		String uname = "root";
		String upass = "123456789";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,uname,upass);
		}
		catch (Exception e) 
		{
         e.printStackTrace();
		}
	}
	

       public static void  insert(hospital p)
       {
              conncect();
              try {
				PreparedStatement ps = con.prepareStatement("insert into patient value(?,?,?,?,?,?)");
				ps.setInt(1,p.getId());
				ps.setString(2,p.getName());
				ps.setInt(3,p.getAge());
				ps.setInt(4,p.getWard());
				ps.setString(5,p.getDoctor());
				ps.setString(6,p.getDate());
				
				if (!ps.execute()) {
					System.out.println("Data Inserted");
				}
				else {
					System.out.println("Data not instered");
				}
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
              
       }
       public static void delete(int id)
       {
    	   conncect();
    	   try {
			PreparedStatement ps =con.prepareStatement("delete from patient where  id = ?");
			ps.setInt(1, id);
			if (!ps.execute()) 
			{
			System.out.println("Data Deleted");	
			}
			else {
				System.out.println("Data Not Deleted");
			}
    	   con.close();	   
		} catch (Exception e) {
			e.printStackTrace();
	}
 }
    
      public static void view()
           {
    	  conncect();
    	  try {
			PreparedStatement ps = con.prepareStatement("select * from patient");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getInt(4)+" "+rs.getString(5)+" "+rs.getString(6));
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
	    	}
           }

    public static int update(hospital h)
    {
    	conncect();
    	int v =0;
    	try {
			PreparedStatement ps =  con.prepareStatement("update patient set name = ?, age = ?, ward = ?, doctor = ?, date = ? where id = ?");
			ps.setString(1, h.getName());
			ps.setInt(2, h.getAge());
			ps.setInt(3, h.getWard());
			ps.setString(4,h.getDoctor());
			ps.setString(5, h.getDate());
			ps.setInt(6, h.getId());
			 if(!ps.execute())
			   {
				   System.out.println("data updated ");
			   }
			   else
			   {
				   System.err.println("could not perform update data");
			   }
			   con.close();
					
		} catch (Exception e) {
			e.printStackTrace();
		}
   return v;
    }
    

}









