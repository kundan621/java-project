package com.capgemini.empms.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.capgemini.empms.dto.Department;
import com.capgemini.empms.dto.Employee;
import com.capgemini.empms.exception.EmployeeMaintenanceException;

@Service
public interface EmployeeService 
{
	List<Employee> getEmpDetailsOnId(String columnname, String choice) throws EmployeeMaintenanceException;
	List<Employee> getEmpDetailsOnWildCardId(String columnname, String choice) throws EmployeeMaintenanceException;
	List<Employee> getEmpDetailsOnDepartment(Department dept) throws EmployeeMaintenanceException;
	List<Employee> getEmpDetailsOnGrade(Employee emp) throws EmployeeMaintenanceException;
	List<Employee> getEmpDetailsOnMstatus(Employee emp) throws EmployeeMaintenanceException;
}
