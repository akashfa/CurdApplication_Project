



package com.akash.service;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import com.akash.Repo.IStudentRepo;
import com.akash.dataobject.StudentBo;
import com.akash.dataobject.StudentDto;
import com.akash.factory.StudentRepoFactory;

public class StudentServiceImp implements IStudentService ,Serializable{
	@Override
	public String insertRecord(StudentDto stuDto) {
		StudentBo stuBo=new StudentBo();
		
		stuBo.setName(stuDto.getName());
		stuBo.setAge(stuDto.getAge());
		stuBo.setAddress(stuDto.getAddress());
		
		if(stuBo.getAge()<=18) {
			stuBo.setStatus("child");
		}else {
			stuBo.setStatus("man");
		}
		
		IStudentRepo repo=StudentRepoFactory.getRepoObject();
		return repo.insertRecord(stuBo);
	}

	@Override
	public  StudentDto readRecord(Integer sid) {
		StudentBo bo=null;
		StudentDto dto=null;
	    IStudentRepo repo=StudentRepoFactory.getRepoObject();
	
	 bo=repo.readRecordData(sid);
	 if(bo==null) {
		 return dto;
	 }else {
		 //convert bo to dto
		 dto=new StudentDto();
		 try {
			BeanUtils.copyProperties(dto, bo);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	return dto;
	
	}

	@Override
	public String updateRecord(StudentDto stuDto) {
		//convert dto to bo object
		StudentBo stuBo=new StudentBo();
		stuBo.setSid(stuDto.getSid());
		stuBo.setName(stuDto.getName());
		stuBo.setAge(stuDto.getAge());
		stuBo.setAddress(stuDto.getAddress());
		
		if(stuBo.getAge()<=18) {
			stuBo.setStatus("child");
		}else {
			stuBo.setStatus("man");
		}
		 IStudentRepo repo=StudentRepoFactory.getRepoObject();
		return repo.updateRecord(stuBo);
	}

	@Override
	public String deleteRecord(StudentDto stuDto) {
		StudentBo stuBo=new StudentBo();
		stuBo.setSid(stuDto.getSid());
		
		IStudentRepo repo=StudentRepoFactory.getRepoObject();
		return repo.deleteRecord(stuBo);
	}
	

}
