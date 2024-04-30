package com.akash.controller;

import com.akash.dataobject.StudentVo;

public interface IStudentController {
	
	public String insertRecord(StudentVo stuVo);
	public String updateRecord(StudentVo stuUpdate);
	public StudentVo readRecord(String sid);
	public String deleteRecord(String sid);

}
