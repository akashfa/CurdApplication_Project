package com.akash.service;

import com.akash.dataobject.StudentDto;

public interface IStudentService {
	
	public String insertRecord(StudentDto stuDto);

	public StudentDto  readRecord(Integer sId);

	public String updateRecord(StudentDto stuDto);

	public String deleteRecord(StudentDto stuDto);

}
