package com.akash.controller;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import com.akash.dataobject.StudentDto;
import com.akash.dataobject.StudentVo;
import com.akash.factory.StudetnServiceFactory;
import com.akash.service.IStudentService;

public class StudentControllerImp implements IStudentController,Serializable{
	
	//changing data VO-> to Dto
	
     public String insertRecord(StudentVo stuVo) {
     StudentDto stuDto=new StudentDto();
	 IStudentService service=StudetnServiceFactory.getServiceObj();
	 
	 stuDto.setName(stuVo.getName());
	 stuDto.setAge( Integer.parseInt(stuVo.getAge()));
	 stuDto.setAddress(stuVo.getAddress());
	 return service.insertRecord(stuDto);
	   
   }

	@Override
	public String updateRecord(StudentVo stuUpdate) {
		//convert vo to dto
		 StudentDto stuDto=new StudentDto();
		 stuDto.setSid(Integer.parseInt(stuUpdate.getSid()));
		 stuDto.setName(stuUpdate.getName());
		 stuDto.setAge( Integer.parseInt(stuUpdate.getAge()));
		 stuDto.setAddress(stuUpdate.getAddress());
		 IStudentService service=StudetnServiceFactory.getServiceObj();
		return service.updateRecord(stuDto);
	}

	@Override
	public StudentVo readRecord(String sid) {
    IStudentService service=StudetnServiceFactory.getServiceObj();	
    StudentVo vo=null;
    StudentDto dto=null;
   dto= service.readRecord(Integer.parseInt(sid));
   if(dto==null) {
	   return vo;
   }else {
	   vo=new StudentVo();
	   //convert dto to vo
	   try {
		BeanUtils.copyProperties(vo, dto);
	} catch (IllegalAccessException | InvocationTargetException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
   return vo;
    
    
	
	}

	@Override
	public String deleteRecord(String sid) {
		StudentDto stuDto=new StudentDto();
		stuDto.setSid(Integer.parseInt(sid));
		IStudentService service=StudetnServiceFactory.getServiceObj();
		return service.deleteRecord(stuDto);
	}
}

