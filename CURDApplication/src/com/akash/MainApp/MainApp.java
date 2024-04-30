package com.akash.MainApp;



import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

import com.akash.controller.IStudentController;
import com.akash.dataobject.StudentVo;
import com.akash.factory.StudentControllerFactory;

public class MainApp {
	public static void main(String[]args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		IStudentController controller=StudentControllerFactory.getControllerObj();
	   
	
		while(true) {
			System.out.println("******************************************************************");
			System.out.print("1 INSSERT\t");
			System.out.print("2 READ\t");
			System.out.print("3 UPDATE\t");
			System.out.print("4 DELETE\t");
			System.out.println("5 EXIT");
			System.out.println("******************************************************************");
			System.out.println("********************WELCOME IN APPLICATION*************************");
			String option=br.readLine();
			
			switch (option) {
			case "1":
				insertRecordData(br,controller);
				break;
			case "2":
				readRecordData(br,controller);
				break;
			case "3":
				updateRecordData(br,controller);
				break;
			case "4":
			     deleteRecordData(br,controller);
				break;
			case "5":
				System.out.println("YOU ARE LOGOUT ");
				System.exit(0);
				break;
			default:
				System.out.println("YOU ARE NOT ENTER THE CORRECT CHOICE");
				break;
			}
			
			
		}
		
		
	}

	private static void deleteRecordData(BufferedReader br, IStudentController controller) throws IOException {
		System.out.println("Enter the id::");
		String sid=br.readLine();
		StudentVo stuVo=controller.readRecord(sid);
		
		String status="";
		if(stuVo!=null) {
		  	
		  	status=controller.deleteRecord(sid);
		  	if(status.equalsIgnoreCase("Success")) {
		  		System.out.println("DATA DELETE SUCCESSFULLY::");
		  	}else {
		  		System.out.println(status);
		  	}
		  	
		}
		
		
	}

	private static void readRecordData(BufferedReader br, IStudentController controller) throws IOException {
		System.out.println("Enter the id::");
		String sid=br.readLine();
		
		StudentVo stuVo=controller.readRecord(sid);
		System.out.println(stuVo);
		
		
	}

	private static void updateRecordData(BufferedReader br, IStudentController controller) throws IOException {
		
		System.out.print("Enter the id::");
		String sid=br.readLine();
		
		StudentVo stuVo=controller.readRecord(sid);
	    StudentVo stuUpdate=new StudentVo();
	
		if(stuVo!=null) {
			
			System.out.println("Given id::"+stuVo.getSid());
			stuUpdate.setSid(stuVo.getSid());
			
			System.out.println("Given name::"+stuVo.getName()+" Enter the update name::");
			String name=br.readLine();
			if(name.equals("")||name=="") {
				stuUpdate.setName(stuVo.getName());
				
			}else {
				stuUpdate.setName(name);
			}
			
			System.out.println("Given age::"+stuVo.getAge()+" Enter the update age::");
			String age=br.readLine();
			if(age.equals("")||age=="") {
				stuUpdate.setAge(stuVo.getAge());
				
			}else {
				stuUpdate.setAge(age);
			}

			
			System.out.println("Given address::"+stuVo.getAddress()+" Enter the update address::");
			String address=br.readLine();
			if(address.equals("")||address=="") {
				stuUpdate.setAddress(stuVo.getAddress());
				
			}else {
				stuUpdate.setAddress(address);
			}

			
			String status=controller.updateRecord(stuUpdate);
			if(status.equalsIgnoreCase("success")) {
				System.out.println("DATA UPDATE SUCCESSFULLY");
			}else{
				System.out.println("YOU ARE ENTER THE ID::"+sid);
			}
		
		}
		
		
		
	}

	private static void insertRecordData(BufferedReader br,IStudentController controller) throws IOException {
		System.out.println("Enter the name:");
		String name=br.readLine();
		
		System.out.println("Enter the age :");
		String age=br.readLine();

		System.out.println("Enter the address :");
		String address=br.readLine();

		StudentVo stVo=new StudentVo();
		stVo.setName(name);
		stVo.setAge(age);
		stVo.setAddress(address);
		
		String status=controller.insertRecord(stVo);
		if(status.equalsIgnoreCase("success")) {
			System.out.println("DATA INSER SUCCESSFULLY");
		}else {
			System.out.println(status);
		}
		
		
		  
		
	}

}
