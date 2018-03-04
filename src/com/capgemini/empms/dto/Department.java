package com.capgemini.empms.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;
@Entity
@Table
public class Department 
{
	@Id
	private int dept_Id;
	@NotEmpty(message="Please select atleast one department")
	private String dept_Name;
	
	@Override
	public String toString()
	{
		return "Department [dept_Id=" + dept_Id + ", dept_Name=" + dept_Name+ "]";
	}
	
	public int getDept_Id() 
	{
		return dept_Id;
	}
	public void setDept_Id(int dept_Id) 
	{
		this.dept_Id = dept_Id;
	}
	public String getDept_Name() 
	{
		return dept_Name;
	}
	public void setDept_Name(String dept_Name) 
	{
		this.dept_Name = dept_Name;
	}	
}
