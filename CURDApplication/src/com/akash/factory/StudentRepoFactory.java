package com.akash.factory;

import com.akash.Repo.IStudentRepo;
import com.akash.Repo.StudentRepoImp;

public class StudentRepoFactory {
	private static IStudentRepo repo=null;
	
	public static IStudentRepo getRepoObject() {
		
		if(repo==null) {
			repo=new StudentRepoImp();
		}
		return repo;
	}

}
