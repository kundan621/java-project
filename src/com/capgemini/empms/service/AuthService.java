package com.capgemini.empms.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.capgemini.empms.dto.User_Master;
import com.capgemini.empms.exception.EmployeeMaintenanceException;

@Service
public interface AuthService
{
	/*********************** Employee details validation(Admin Operations) ***********************/

	public boolean isValidUserId(String userId);
	public boolean isValidUserName(String userName);
	public boolean isValidUserPassword(String userPass);
	public boolean isValidUserType(String userType);	
	public boolean isValidDeptId(String deptId);
	public boolean isValidDeptName(String deptName);	
	public boolean isValidGradeCode(String gradeCode);
	public boolean isValidEmpId(String empId);
	public boolean isValidEmpFname(String empFname);
	public boolean isValidEmpLname(String empLname);
	public boolean isValidEmpDob(String empDob);
	public boolean isValidEmpDoj(String empDoj,String empDob);
	public boolean isValidEmpDesig(String empDesig);
	public boolean isValidEmpBasic(String empBasic,String gradeCode);
	public boolean isValidEmpGender(String empGender);
	public boolean isValidEmpMarital(String empMstatus);
	public boolean isValidEmpAddress(String empAddress);
	public boolean isValidEmpContact(String empContact);
	
	/*********************** Validate User with credentials ****************************************/
	
	public List<User_Master> validateUser(String username,String password,String usertype) throws EmployeeMaintenanceException;

}
