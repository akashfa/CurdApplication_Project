package com.akash.Repo;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.akash.dataobject.StudentBo;
import com.akash.utility.jdbcUtility;

public class StudentRepoImp implements IStudentRepo,Serializable{
    private static Connection connection=null;
	private static PreparedStatement insertPtms=null;
	private static PreparedStatement readPtms=null;
	private static PreparedStatement updatePtms=null;
	private static PreparedStatement deletePtms=null;
	
	
	private static final String SQL_INSERT_QUERY = "insert into user1(`studentName`,`studentAge`,`studentAddress`,`studentStatus`) values(?,?,?,?) ";
	private static final String SQL_SELECT_QUERY = "select studentId,studentName,studentAge,studentAddress,studentStatus from user1 where studentId =? ";
	private static final String SQL_UPDATE_QUERY = "update user1 set studentName=?,studentAge=?,studentAddress=?,studentStatus=? where studentId=?";
	private static final String SQL_DELETE_QUERY = "delete from user1 where studentId=?";
	
	
	static {
		try {
			connection = jdbcUtility.getDbConnection();
			if(connection!=null) {
				insertPtms=connection.prepareStatement(SQL_INSERT_QUERY);
				
			}if(connection!=null) {
			 readPtms=connection.prepareStatement(SQL_SELECT_QUERY);
			}if(connection!=null) {
				updatePtms=connection.prepareStatement(SQL_UPDATE_QUERY);	
			}if(connection!=null) {
				deletePtms=connection.prepareStatement(SQL_DELETE_QUERY);	
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public String insertRecord(StudentBo stuBo) {
	
		String status=null;
		try {
			if(insertPtms!=null) {
			
			  insertPtms.setString(1, stuBo.getName());  
			  insertPtms.setInt(2, stuBo.getAge());
			  insertPtms.setString(3, stuBo.getAddress());
			  insertPtms.setString(4, stuBo.getStatus());
			                 //  ptms.setBoolean(4, stuBo.isMarried());
			  int result= insertPtms.executeUpdate();
			  if(result==1) {
            	  status="success";
              }               
			}
			               
		
		}  catch (SQLException se) {
			int errorCode = se.getErrorCode();
			if (errorCode == 1064) {
				status = "some error in db operation";
			} else if (errorCode == 2006) {
				status = "connection lost at dbside";
			} else if (errorCode == 1045) {
				status = "acess denied for the user wrong credentialsm";
			} else if (errorCode == 1044) {
				status = "access denied for the user to database";
			} else {
				status = "Some Error at database side";
			}
			System.out.println(se);
		} catch (Exception e) {
			status = "Some Unknown Exception ";
			return status;
		}
		return status;
	}
	@Override
	public StudentBo readRecordData(Integer id) {
		StudentBo bo=null;
		try {
	
			
			if(readPtms!=null) {	
			readPtms.setInt(1, id);
			ResultSet result= readPtms.executeQuery();
			if(result!=null) {
			
			
			if(result.next()) {
				bo=new StudentBo();
				bo.setSid(result.getInt(1));
				bo.setName(result.getString(2));
				bo.setAge(result.getInt(3));
				bo.setAddress(result.getString(4));
				bo.setStatus(result.getString(5));
				
			
			}
			}
		}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return bo;
	

}
	@Override
	public String updateRecord(StudentBo stuBo) {
		String status="";
		try {
			if(updatePtms!=null) {
			updatePtms.setString(1,stuBo.getName());
			updatePtms.setInt(2, stuBo.getAge());
			updatePtms.setString(3, stuBo.getAddress());
			updatePtms.setString(4, stuBo.getStatus());
			updatePtms.setInt(5,stuBo.getSid());
			updatePtms.executeUpdate();
			status="success";
		}
		}catch (SQLException e) {
			status = "SOME PROBLEM WITH DATABASE";
			e.printStackTrace();
		}
		return status;
	}
	@Override
	public String deleteRecord(StudentBo stuBo) {
		String status="";
		if(deletePtms!=null) {
		try {
			deletePtms.setInt(1, stuBo.getSid());
			deletePtms.executeUpdate();
			status="Success";
			
		} catch (SQLException e) {
			status="some other problem";
			e.printStackTrace();
		}
		}
		return status;
	}
	}