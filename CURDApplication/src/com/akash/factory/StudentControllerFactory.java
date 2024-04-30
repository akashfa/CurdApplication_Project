package com.akash.factory;

import com.akash.controller.IStudentController;
import com.akash.controller.StudentControllerImp;

public class StudentControllerFactory {
	private static IStudentController controller=null;
	
	
	public static IStudentController getControllerObj() {
		
		if(controller==null) {
			controller=new StudentControllerImp();
		}
		return controller;
	}

}
