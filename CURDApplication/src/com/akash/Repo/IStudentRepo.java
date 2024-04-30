package com.akash.Repo;

import com.akash.dataobject.StudentBo;

public interface IStudentRepo {
	
	 public String insertRecord(StudentBo stuBo);

	

	public StudentBo readRecordData(Integer sid);



	public String updateRecord(StudentBo stuBo);



	public String deleteRecord(StudentBo stuBo);

}
