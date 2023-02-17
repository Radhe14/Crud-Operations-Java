package logic;

import java.util.Scanner;

import ben.Employee;
import dao.dboperation;

public class Operate {
	public static void main(String[] args) {
		int v = 10;
		Scanner  sc = new Scanner(System.in);
	    Employee e = new  Employee();
	    System.out.println("press 1 to insert\npress 2 to update\n press 3 to view\npress 4 to delet");
	    v=sc.nextInt();
	    switch(v)
	    {
	    case 1: System.out.println("Enter id : ");
	            e.setId(sc.nextInt());
	            System.out.println("Enter name : ");
	            e.setName(sc.next()+sc.nextLine());
	            System.out.println("Enter departmen : ");
	            e.setDepartment(sc.next());
	            System.out.println("Enter salary : ");
	            e.setSalary(sc.nextInt());
	            dboperation.insert(e);
	            break;
	         
    	case 2: System.out.println("Enter id : ");
                e.setId(sc.nextInt());
                System.out.println("Enter name : ");
                e.setName(sc.next()+sc.nextLine());
                System.out.println("Enter departmen : ");
                e.setDepartment(sc.next());
                System.out.println("Enter salary : ");
                e.setSalary(sc.nextInt());
                dboperation.update(e);
                break;
	    
	    case 3: dboperation.view();
         	    break;
	    case 4: System.out.println("Enter id : ");
	            dboperation.delete(sc.nextInt());
	    default: System.out.println("Invalid choice");
	    }
	 }
}
