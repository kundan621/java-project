package com.capgemini.empms.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import com.capgemini.empms.dto.User_Master;
import com.capgemini.empms.exception.EmployeeMaintenanceException;

@Repository("IUserValidateDAOImpl")
public class IUserValidateDAOImpl implements IUserValidateDAO 
{
	Logger logger=Logger.getLogger(IUserValidateDAOImpl.class);
	@PersistenceContext
	private EntityManager em;	
	
	@Override
	public List<User_Master> validateUser(String userid, String password,String usertype) throws EmployeeMaintenanceException 
	{

		Query validQuery=em.createQuery("FROM User_Master WHERE userid=:userid AND userpassword=:userpassword AND usertype=:usertype");
		validQuery.setParameter("userid",userid);
		validQuery.setParameter("userpassword",password);
		validQuery.setParameter("usertype",usertype);		
		
		List<User_Master> list=validQuery.getResultList();
		return list;		
	}	
}
