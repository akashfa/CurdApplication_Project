package com.akash.factory;

import com.akash.service.IStudentService;
import com.akash.service.StudentServiceImp;

public class StudetnServiceFactory {
  private static IStudentService service=null;
  
  public static IStudentService getServiceObj() {
	  
	  if(service==null) {
		  service=new StudentServiceImp();
	  }
	  return service;
  }
  
}
