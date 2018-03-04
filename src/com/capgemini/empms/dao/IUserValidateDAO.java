package com.capgemini.empms.dao;

import java.util.List;
import com.capgemini.empms.dto.User_Master;
import com.capgemini.empms.exception.EmployeeMaintenanceException;

//Validations
/********************************************************************************************

- Function name		:	Validate Details
- Input Parameters	:	String columnname,String password,String usertype
- Return Type		:	boolean
- Throws			: 	EmployeeMaintainanceException
- Author			:   Capgemini
- Creation date		:   20/09/2017
- Description		:   Validates the Existing Users 

********************************************************************************************/
public interface IUserValidateDAO 
{
	List<User_Master> validateUser(String username, String password,String usertype) throws EmployeeMaintenanceException;
}
