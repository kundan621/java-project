package com.capgemini.empms.dao;

import java.util.List;
import com.capgemini.empms.dto.Department;
import com.capgemini.empms.dto.Employee;
import com.capgemini.empms.exception.EmployeeMaintenanceException;

//Validations
/********************************************************************************************

- Function name		:	Search Details
- Input Parameters	:	String columnname,String choice
- Return Type		:	List<Employee>
- Throws			: 	EmployeeMaintainanceException
- Author			:   Capgemini
- Creation date		:   20/09/2017
- Description		:   Returns result for specified search queries

********************************************************************************************/
public interface IEmployeeSearchDAO
{
	List<Employee> getEmpDetailsOnId(String columname, String choice) throws EmployeeMaintenanceException;
	List<Employee> getEmpDetailsOnWildCardId(String columnname, String choice) throws EmployeeMaintenanceException;
	List<Employee> getEmpDetailsOnDepartment(Department dept) throws EmployeeMaintenanceException;
	List<Employee> getEmpDetailsOnGrade(Employee emp) throws EmployeeMaintenanceException;
	List<Employee> getEmpDetailsOnMstatus(Employee emp) throws EmployeeMaintenanceException;
}


