package com.capgemini.empms.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.empms.dao.IEmployeeSearchDAO;
import com.capgemini.empms.dto.Department;
import com.capgemini.empms.dto.Employee;
import com.capgemini.empms.exception.EmployeeMaintenanceException;

@Service("employeeserviceimpl")
public class EmployeeServiceImpl implements EmployeeService
{
	@Autowired
	IEmployeeSearchDAO empDao;
		
	@Override
	public List<Employee> getEmpDetailsOnId(String columnname,String choice) throws EmployeeMaintenanceException 
	{
		return empDao.getEmpDetailsOnId(columnname, choice);
	}

	@Override
	public List<Employee> getEmpDetailsOnWildCardId(String columnname,String choice) throws EmployeeMaintenanceException 
	{
		return empDao.getEmpDetailsOnWildCardId(columnname, choice);
	}

	@Override
	public List<Employee> getEmpDetailsOnDepartment(Department dept) throws EmployeeMaintenanceException 
	{
		return empDao.getEmpDetailsOnDepartment(dept);
	}

	@Override
	public List<Employee> getEmpDetailsOnGrade(Employee emp)
			throws EmployeeMaintenanceException {
		// TODO Auto-generated method stub
		return empDao.getEmpDetailsOnGrade(emp);
	}

	@Override
	public List<Employee> getEmpDetailsOnMstatus(Employee emp)
			throws EmployeeMaintenanceException {
		// TODO Auto-generated method stub
		return empDao.getEmpDetailsOnMstatus(emp);
	}
}
