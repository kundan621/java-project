package com.capgemini.empms.dto;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Employee implements Serializable
{
	private static final long SerialVersionUID=1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String emp_Id;
	private String emp_First_Name;
	private String emp_Last_Name;
	private String emp_Date_Of_Birth;
	private String emp_Date_Of_Joining;

	private int emp_Dept_Id;
    @NotEmpty(message="Please check any one of the grades")
	private String emp_Grade;
	private String emp_Designation;
	private int emp_Basic;
	private String emp_Gender;
	  @NotEmpty(message="Please check atleast one status")
	private String emp_Marital_Status;
	private String emp_Home_Address;
	private String emp_Contact_Num;
	
	
	
	@Override
	public String toString() 
	{
		return "Employee [emp_Id=" + emp_Id + ", emp_First_Name="
				+ emp_First_Name + ", emp_Last_Name=" + emp_Last_Name
				+ ", emp_Date_Of_Birth=" + emp_Date_Of_Birth
				+ ", emp_Date_Of_Joining=" + emp_Date_Of_Joining
				+ ", emp_Dept_Id=" + emp_Dept_Id + ", emp_Grade=" + emp_Grade
				+ ", emp_Designation=" + emp_Designation + ", emp_Basic="
				+ emp_Basic + ", emp_Gender=" + emp_Gender
				+ ", emp_Marital_Status=" + emp_Marital_Status
				+ ", emp_Home_Address=" + emp_Home_Address
				+ ", emp_Contact_Num=" + emp_Contact_Num + "]";
	}

	public String getEmp_Id() 
	{
		return emp_Id;
	}
	
	public void setEmp_Id(String emp_Id) 
	{
		this.emp_Id = emp_Id;
	}
	
	public String getEmp_First_Name() 
	{
		return emp_First_Name;
	}

	public void setEmp_First_Name(String emp_First_Name) 
	{
		this.emp_First_Name = emp_First_Name;
	}

	public String getEmp_Last_Name() {
		return emp_Last_Name;
	}

	public void setEmp_Last_Name(String emp_Last_Name) {
		this.emp_Last_Name = emp_Last_Name;
	}

	public String getEmp_Date_Of_Birth() {
		return emp_Date_Of_Birth;
	}

	public void setEmp_Date_Of_Birth(String emp_Date_Of_Birth) {
		this.emp_Date_Of_Birth = emp_Date_Of_Birth;
	}

	public String getEmp_Date_Of_Joining() {
		return emp_Date_Of_Joining;
	}

	public void setEmp_Date_Of_Joining(String emp_Date_Of_Joining) {
		this.emp_Date_Of_Joining = emp_Date_Of_Joining;
	}

	public int getEmp_Dept_Id() {
		return emp_Dept_Id;
	}

	public void setEmp_Dept_Id(int emp_Dept_Id) {
		this.emp_Dept_Id = emp_Dept_Id;
	}

	public String getEmp_Grade() {
		return emp_Grade;
	}

	public void setEmp_Grade(String emp_Grade) {
		this.emp_Grade = emp_Grade;
	}

	public String getEmp_Designation() {
		return emp_Designation;
	}

	public void setEmp_Designation(String emp_Designation) {
		this.emp_Designation = emp_Designation;
	}

	public int getEmp_Basic() {
		return emp_Basic;
	}

	public void setEmp_Basic(int emp_Basic) {
		this.emp_Basic = emp_Basic;
	}

	public String getEmp_Gender() {
		return emp_Gender;
	}

	public void setEmp_Gender(String emp_Gender) {
		this.emp_Gender = emp_Gender;
	}

	public String getEmp_Marital_Status() {
		return emp_Marital_Status;
	}

	public void setEmp_Marital_Status(String emp_Marital_Status) {
		this.emp_Marital_Status = emp_Marital_Status;
	}

	public String getEmp_Home_Address() {
		return emp_Home_Address;
	}

	public void setEmp_Home_Address(String emp_Home_Address) {
		this.emp_Home_Address = emp_Home_Address;
	}

	public String getEmp_Contact_Num() {
		return emp_Contact_Num;
	}

	public void setEmp_Contact_Num(String emp_Contact_Num) {
		this.emp_Contact_Num = emp_Contact_Num;
	}
}
