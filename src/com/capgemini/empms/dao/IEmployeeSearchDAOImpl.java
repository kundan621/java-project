
package com.capgemini.empms.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import com.capgemini.empms.dto.Department;
import com.capgemini.empms.dto.Employee;
import com.capgemini.empms.exception.EmployeeMaintenanceException;

@Repository("IEmployeeSearchDAO")

public class IEmployeeSearchDAOImpl implements IEmployeeSearchDAO
{
	//Logger logger=Logger.getLogger(IEmployeeSearchDAOImpl.class);
	@PersistenceContext
	private EntityManager em;	
	
/*************************************************************************************************************
	
	- Function name		:	getEmpDetailsOnId(String columnname, String choice)
	- Input Parameters	:	String columnname, String choice
	- Return Type		:	List
	- Throws			: 	EmployeeMaintainanceException
	- Author			:   Capgemini
	- Creation date		:   15/09/2017
	- Description		:   Displays all the Records of Employee from Employee Table based on Employee-Id

**************************************************************************************************************/
	
	@Override
	public List<Employee> getEmpDetailsOnId(String columnname, String choice) throws EmployeeMaintenanceException 
	{
		Query validQuery=null;
		try {
		        if(!columnname.equals("emp_dept_id")){	
		              validQuery = em.createQuery("FROM Employee WHERE "+columnname+"=:abc");
		               validQuery.setParameter("abc",choice);
		        }
		        else{
		        	 validQuery = em.createQuery("select dept_Id from Department where dept_Name=:abc");
		               validQuery.setParameter("abc",choice);
		               Integer deptid=(Integer) validQuery.getSingleResult();
		               
		               System.out.println("department id is :"+deptid);
		               String dept=Integer.toString(deptid);
		               if(deptid>0){
		            	   validQuery = em.createQuery("FROM Employee WHERE emp_Dept_Id=:xyz");
		            	   validQuery.setParameter("xyz",deptid);
		               }
		               else
		               {
		            	   System.out.println("not found");
		               }
		        }	
		    	List<Employee> list= validQuery.getResultList();
		return list;
		} 
		catch (Exception e) 
		{
			throw new EmployeeMaintenanceException("Employee details are not found");
		}
	}

@Override
public List<Employee> getEmpDetailsOnWildCardId(String columnname, String choice)throws EmployeeMaintenanceException 
{	
	Query validQuery=null;
	try
	{
		validQuery = em.createQuery("FROM Employee where "+columnname+" LIKE '"+choice+"'");
		List<Employee> list= validQuery.getResultList();		
		return list;		
	} 
	catch (Exception e) 
	{
		throw new EmployeeMaintenanceException("Employee details are not found");
	}
}

@Override
public List<Employee> getEmpDetailsOnDepartment(Department dept) throws EmployeeMaintenanceException
{
	List<Employee> list=new ArrayList<Employee>();
	List<Employee> list1=new ArrayList<Employee>();
	try
	{
		String[] depts = dept.getDept_Name().split(",");	
		for(String d : depts)
		{		
			Query validQuery=null;
	        System.out.println(d);
	        try
	        {
				validQuery = em.createQuery("select dept_Id from Department where dept_Name=:abc");
		        validQuery.setParameter("abc",d);
		        Integer deptid=(Integer) validQuery.getSingleResult();
		        System.out.println(deptid);
		        if(deptid>0)
		        {
		     	   validQuery = em.createQuery("FROM Employee WHERE emp_Dept_Id=:xyz");
		     	   validQuery.setParameter("xyz",deptid);
		        }
		        else
		        {
		     	   System.out.println("not found");
		        }	 	
		        list= validQuery.getResultList();
	      }
	      catch(Exception e)
	      {
	    	  throw new EmployeeMaintenanceException("No employee details found..");
	      }
		 list1.addAll(list);
}//for closes
	}
	catch(NullPointerException e)
	{
		throw new EmployeeMaintenanceException("No department selected..");
	}
	return list1;	
}	

@Override
public List<Employee> getEmpDetailsOnGrade(Employee emp) throws EmployeeMaintenanceException
{
	List<Employee> list=new ArrayList<Employee>();
	List<Employee> list1=new ArrayList<Employee>();
	try
	{
		String[] depts = emp.getEmp_Grade().split(",");
		for(String d : depts)
		{		
			Query validQuery=null;
	        System.out.println(d);
	        try
	        {			
	     	   validQuery = em.createQuery("FROM Employee WHERE emp_Grade=:xyz");
	     	   validQuery.setParameter("xyz",d);
	     	   list= validQuery.getResultList();
	        }       
	        catch(Exception e)
	        {
	        	throw new EmployeeMaintenanceException("Employee details are not found");
	        }
	        list1.addAll(list);
}//for closes
	}
	catch(NullPointerException e)
	{
		throw new EmployeeMaintenanceException("No grade selected..");
	}
	return list1;	
}	

@Override
public List<Employee> getEmpDetailsOnMstatus(Employee emp) throws EmployeeMaintenanceException
{
	List<Employee> list=new ArrayList<Employee>();
	List<Employee> list1=new ArrayList<Employee>();
	try
	{
		String[] depts = emp.getEmp_Marital_Status().split(",");
		for(String d : depts)
		{		
			Query validQuery=null;
	        System.out.println(d);
	        try
	        {			
	     	   validQuery = em.createQuery("FROM Employee WHERE emp_Marital_Status=:xyz");
	     	   validQuery.setParameter("xyz",d);
	     	   list= validQuery.getResultList();
	     	}       
	        catch(Exception e)
	        {
	        	throw new EmployeeMaintenanceException("Employee details are not found");
	        }
	        list1.addAll(list);
}//for closes
	}
	catch(NullPointerException e)
	{
		throw new EmployeeMaintenanceException("No marital status selected..");
	}
	return list1;	
}		
		
}


