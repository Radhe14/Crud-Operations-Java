package logic;

import java.util.Scanner;

import ben.hospital;
import dao.dboperation;

public class Operate {
	public static void main(String[] args) {
		int v =  10;
		Scanner sc  = new Scanner(System.in);
		hospital h =new hospital();
		System.out.println("Press 1 to insert data\npress 2 to update data\npress 3 to delete data\npress 4 to view data");
        v=sc.nextInt();
        switch(v)
        {
         
        case 1 : System.out.println("Enter your id : ");
                 h.setId(sc.nextInt());
                 System.out.println("Enter your name : ");
                 h.setName(sc.next());
                 System.out.println("Enter your age : ");
                 h.setAge(sc.nextInt());
                 System.out.println("Enter your ward : ");
                 h.setWard(sc.nextInt());
                 System.out.println("Enter your doctor name : ");
                 h.setDoctor(sc.next());
                 System.out.println("Enter your admit date : ");
                 h.setDate(sc.next());
                 dboperation.insert(h);
                 break;
                 
        case 2 : System.out.println("Enter your id : ");
                 h.setId(sc.nextInt());
                 System.out.println("Enter your name : ");
                 h.setName(sc.next());
                 System.out.println("Enter your age : ");
                 h.setAge(sc.nextInt());
                 System.out.println("Enter your ward : ");
                 h.setWard(sc.nextInt());
                 System.out.println("Enter your doctor name : ");
                 h.setDoctor(sc.next());
                 System.out.println("Enter your admit date : ");
                 h.setDate(sc.next());
                 dboperation.update(h);
                 break;   
        case 3 : System.out.println("Enter your id : ");
                 dboperation.delete(sc.nextInt());
                 break;
        case 4 : dboperation.view();
                 break;
                 default : System.out.println("Invalid Data Insert");
        }
	}
}
