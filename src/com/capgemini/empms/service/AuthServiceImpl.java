package com.capgemini.empms.service;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.empms.dao.IUserValidateDAO;
import com.capgemini.empms.dto.Employee;
import com.capgemini.empms.dto.User_Master;
import com.capgemini.empms.exception.EmployeeMaintenanceException;

@Service
public class AuthServiceImpl implements AuthService 
{
	@Autowired
	IUserValidateDAO dao;
	
//Validations
/********************************************************************************************
	
	- Function name		:	Validate Details
	- Input Parameters	:	String columnname
	- Return Type		:	boolean
	- Throws			: 	EmployeeMaintainanceException
	- Author			:   Capgemini
	- Creation date		:   15/09/2017
	- Description		:   Validates the input 

********************************************************************************************/
	
	
	@Override
	public boolean isValidUserId(String userId) 
	{
		String pattern="[a-z]{3}[0-9]{3}";
		boolean res=Pattern.matches(pattern,userId);
		return res;
	}

	@Override
	public boolean isValidUserName(String userName) 
	{
		String pattern="[A-Z][a-z]{4,20}";
		boolean res=Pattern.matches(pattern,userName);
		return res;
	}

	@Override
	public boolean isValidUserPassword(String userPass) 
	{		
		String pattern="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
		boolean res=Pattern.matches(pattern,userPass);
		return res;	
	}

	@Override
	public boolean isValidUserType(String userType) 
	{
			if(userType.equals("admin") || userType.equals("employee"))
			{
				return true;
			}
			else
			{
				return false;
			}		
	}

	@Override
	public boolean isValidDeptId(String deptId) 
	{
		if(deptId.equals("101") || deptId.equals("102") || deptId.equals("103") || deptId.equals("104") || deptId.equals("105") ||
				deptId.equals("106"))
		{
			return true;
		}
		else
		{
			return false;
		}	
	}

	@Override
	public boolean isValidDeptName(String deptName) 
	{
		if(deptName.equalsIgnoreCase("JEE") || deptName.equalsIgnoreCase("Mainframes") || deptName.equalsIgnoreCase("rdbms") ||
				deptName.equalsIgnoreCase("IoT") || deptName.equalsIgnoreCase("SAP") || deptName.equalsIgnoreCase("systems"))
		{
			return true;
		}
		else
		{
			return false;
		}	
	}

	@Override
	public boolean isValidGradeCode(String gradeCode) {

		if(!gradeCode.equals(null) && gradeCode.equals("M1")||gradeCode.equals("M2")||gradeCode.equals("M3")
				||gradeCode.equals("M4")||	gradeCode.equals("M5")||gradeCode.equals("M6")||gradeCode.equals("M7"))
		{
			return true;
		}
		else
		{
			return false;
		}		
	}

	@Override
	public boolean isValidEmpId(String empId) 
	{
		String pattern="[1-9][0-9]{5}";
		boolean res=Pattern.matches(pattern, empId);
		return res;
	}

	@Override
	public boolean isValidEmpFname(String empFname) 
	{
		String pattern="[A-Z][a-z]{4,20}";
		boolean res=Pattern.matches(pattern, empFname);
		return res;
	}

	@Override
	public boolean isValidEmpLname(String empLname) 
	{
		String pattern="[A-Z][a-z]{4,20}";
		boolean res=Pattern.matches(pattern, empLname);
		return res;
	}

	@Override
	public boolean isValidEmpDob(String empDob)  
	{
		try
		{
    		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd-MMM-yyyy");
			LocalDate l2=LocalDate.now();
			LocalDate l1=LocalDate.parse(empDob,dtf);
			Period p=Period.between(l1,l2);
			int age=p.getYears();
			System.out.println("Employee age is : "+age+" years");
			if(age>=18 && age<=58)
			{
				System.out.println("Employee is eligible...");
				return true;
			}
			else
			{
				System.out.println("Employee not eligible...");
				return false;
			}
		}
		catch(Exception e)
		{
			System.err.println("Check date properly");
		}
		return false;
	}

	@Override
	public boolean isValidEmpDoj(String empDoj,String empDob) 
	{
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd-MMM-yyyy");
		LocalDate l1=LocalDate.parse(empDoj,dtf);
		LocalDate l2=LocalDate.parse(empDob);
		Period p=Period.between(l2,l1);
		int diff=p.getYears();
		if(diff > 18)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean isValidEmpDesig(String empDesig) 
	{
		String pattern="[A-Za-z]{0,50}";
		boolean res=Pattern.matches(pattern, empDesig);
		return res;
	}

	@Override
	public boolean isValidEmpBasic(String empBasic,String gradeCode) 
	{
    	int basicPay=Integer.parseInt(empBasic);
		Employee emp=new Employee();
		if(gradeCode.equals("M1") && basicPay>=10000 && basicPay<=15000)
		{
			emp.setEmp_Basic(basicPay);	
			return true;
		}
		else if(gradeCode.equals("M2")&& basicPay>=15000 && basicPay<=20000)
		{
			emp.setEmp_Basic(basicPay);	
			return true;
		}
		else if(gradeCode.equals("M3")&& basicPay>=20000 && basicPay<=35000)
		{
			emp.setEmp_Basic(basicPay);	
			return true;
		}
		else if(gradeCode.equals("M4")&& basicPay>=35000 && basicPay<=40000)
		{
			emp.setEmp_Basic(basicPay);	
			return true;
		}
		else if(gradeCode.equals("M5")&& basicPay>=40000 && basicPay<=55000)
		{
			emp.setEmp_Basic(basicPay);	
			return true;
		}	
		else if(gradeCode.equals("M6")&& basicPay>=55000 && basicPay<=75000)
		{
			emp.setEmp_Basic(basicPay);	
			return true;
		}	
		else if(gradeCode.equals("M7")&& basicPay>=75000 && basicPay<=100000)
		{
			emp.setEmp_Basic(basicPay);
			return true;
		}
		else
		{
			return false;
		}				
	}

	@Override
	public boolean isValidEmpGender(String empGender) 
	{
		if(empGender.equalsIgnoreCase("M") || empGender.equalsIgnoreCase("F"))
		{
			return true;
		}
		else
		{
			return false;
		}		
	}

	@Override
	public boolean isValidEmpMarital(String empMstatus) 
	{
		if(empMstatus.equals("S")||empMstatus.equals("M")||empMstatus.equals("D")||empMstatus.equals("s")||empMstatus.equals("W"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean isValidEmpAddress(String empAddress) 
	{
		String pattern="[A-Za-z0-9]{0,50}";
		boolean res=Pattern.matches(pattern,empAddress);
		return res;
	}

	@Override
	public boolean isValidEmpContact(String empContact) 
	{
		String pattern="[0-9]{10}";
		boolean res=Pattern.matches(pattern,empContact);
		return res;
	}

	/*********************** Login validation for users ******************************/
	
	@Override
	public List<User_Master> validateUser(String username, String password,String usertype) throws EmployeeMaintenanceException 
	{		
		return dao.validateUser( username, password,usertype);
	}
}
