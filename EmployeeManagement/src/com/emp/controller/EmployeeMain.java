package com.emp.controller;

import java.util.Scanner;

import com.emp.beans.Employee;
import com.emp.repository.Database;
import com.emp.services.Service;
import com.emp.services.HashServiceImpli;
import com.emp.services.JDBCServiceImpl;

public class EmployeeMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Employee emp=new Employee();
		Database d=new Database();
		Service ser = new HashServiceImpli();
		Service serc = new JDBCServiceImpl();
		String b;
		System.out.println("1 . HashMap");
		System.out.println("2 . JDBC");
		System.out.println("Which Operation want to perform?");
		int r = sc.nextInt();

		if(r==1)
		{
			do
			{
				System.out.println("1 . Insert the Data of Employee");
				System.out.println("2 . Update the Data of Employee");
				System.out.println("3 . View Details of Employee");
				System.out.println("4 . Delete the Data of Employee");
				System.out.println("5 . Get All Employee Details");

				System.out.println("Enter number to perform Operations :");
				int n = sc.nextInt();

				switch (n)
				{

				case 1:
					System.out.println("Enter emp id");
					emp.setId(Integer.parseInt(sc.nextLine()));

					System.out.println("Enter name");
					emp.setName(sc.nextLine());
					System.out.println("Enter Email");
					emp.setEmail(sc.nextLine());
					System.out.println("Enter password");
					emp.setPassword(sc.nextLine());


					boolean res = ser.createEmployee(emp);
					if(res)
					{
						System.out.println("Employee Successfully Added");
					}
					else
					{
						System.err.println("Failedd to Add");

					}
					break;



				case 2:

					System.out.println("Enter the ID which You want to Update that Data");
					int id2 = sc.nextInt();

					System.out.println("Enter The new NAme");
					String name1 = sc.next();
					System.out.println("Enter the new Email");
					String email1 = sc.next();
					System.out.println("Enter the new password");
					String pass1= sc.next();

				

					emp.setName(name1);
					emp.setPassword(pass1);
					emp.setEmail(email1);
					emp.setId(id2);
					boolean up=ser.updateEmployee(emp);
					if(up)
					{
						System.out.println("Successfully Updated");
					}
					else
					{
						System.err.println("Employee with id "+id2+" does not exists");
					}
					break;

				case 3:

					System.out.println("Enter the Id to View Data");
					int id3= sc.nextInt();

					Employee em = ser.getEmployee(id3);
					if(em!=null)
					{
						System.out.println(em);
					}
					else
					{
						System.err.println("ID doesnt Exist");
						System.exit(0);
					}
					break;
				case 4:

					System.out.println("Enter the ID to Delete data");
					int id4 = sc.nextInt();
					boolean res3 = ser.deleteEmployee(emp);	

					if(res3)
					{
						System.out.println("Successfully Deleted");
					}
					else
					{
						System.err.println("User Doesn't Exist");
					}

					break;
				case 5:
					d.getAllEmploee();
					break;

				default :
					System.err.println("Incoreect Number");
					break;


				}

				System.out.println("Do u want to continue(y/n)???");

				b = sc.next();
			}while(b.equals("y"));

		}
		else if(r==2) {
			do
			{
				System.out.println("1 . Insert the Data of Employee");
				System.out.println("2 . Update the Data of Employee");
				System.out.println("3 . View Details of Employee");
				System.out.println("4 . Delete the Data of Employee");
				//System.out.println("5 . Get All Employee Details");

				System.out.println("Enter number to perform Operations :");
				int a = sc.nextInt();

				switch (a)
				{

				case 1:
					System.out.println("Enter emp id");
					int empid = sc.nextInt();
					System.out.println("Enter name");
					String empname = sc.next();
					System.out.println("Enter Email");
					String empemail = sc.next();
					System.out.println("Enter password");
					String emppass = sc.next();

					emp=new Employee();
					emp.setId(empid);
					emp.setName(empname);
					emp.setPassword(emppass);
					emp.setEmail(empemail);


					boolean res = serc.createEmployee(emp);
					if(res)
					{
						System.out.println("Employee Successfully Added");
					}
					else
					{
						System.err.println("Somethimg went wrong");

					}
					break;



				case 2:

					System.out.println("Enter UserID and Password to Update ur Data");
					System.out.println("Enter user_id :" );
					emp.setId(sc.nextInt());

					System.out.println("Enter Password :");
					emp.setPassword(sc.next());


					System.out.println("Enter new Username :");
					emp.setName((sc.next()));


					System.out.println("Enter new Email :");
					emp.setEmail(sc.next());

					
					boolean c = serc.updateEmployee(emp);

					if(c)
					{
						System.out.println("Profil Updated...");
					}
					else
					{
						System.err.println("Failed to Update Profile...");
					}

					break;

				case 3:

					Employee e = serc.getEmployee(emp.getId());
					break;
				case 4:

					System.out.println("Enter UserID and Password to Delete ur Data");
					System.out.println("Enter user_id :" );
					emp.setId(sc.nextInt());

					System.out.println("Enter Password :");
					emp.setPassword(sc.next());
					
					boolean p = serc.deleteEmployee(emp);
					
					if(p)
					{
						System.out.println("Profil Deleted...");
					}
					else
					{
						System.err.println("Failed to Delete Profile...");
					}


					break;
					//						case 5:
					//							d.getAllEmploee();
					//							break;

				default :
					System.err.println("Incoreect Number");
					break;


				}

				System.out.println("Do u want to continue(y/n)???");

				b = sc.next();
			}while(b.equals("y"));

		}
		else
		{
			System.err.println("Incorrect Number");
		}







	}
}



