package com.capgemini.empms.controller;

import java.util.ArrayList;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.capgemini.empms.dto.Department;
import com.capgemini.empms.dto.Employee;
import com.capgemini.empms.dto.User_Master;
import com.capgemini.empms.exception.EmployeeMaintenanceException;
import com.capgemini.empms.service.AuthService;
import com.capgemini.empms.service.EmployeeService;
import org.springframework.validation.BindingResult;

@Controller
@Scope("session")
public class EmployeeMaintenanceController 
{
	@Autowired
	AuthService aService;
	@Autowired
	EmployeeService eService;
	
	List<Employee> emplist1=new ArrayList<Employee>();
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String home(@ModelAttribute("validate") User_Master user)
	{		
		return "home";
	}
	
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logout(HttpSession sess)
	{		
		sess.invalidate();		
		return "index";
	}
	
	@RequestMapping("/validatelogin")
	public ModelAndView showHome(@Valid @ModelAttribute("validate") User_Master user,BindingResult result,HttpServletRequest req)
	{	
		if(result.hasErrors()){
			System.out.println("result has errors............."+result.hasErrors());
			return new ModelAndView("home");
		}
		try 
		{
			List<User_Master> users=aService.validateUser(user.getUserId(),user.getUserPassword(),user.getUserType());
			System.out.println("size......................"+users.size());
			
			if(user.getUserType().equalsIgnoreCase("employee") && users.size()==1)
			{
				
				req.getSession().setAttribute("isLoggedIn", true);
				req.getSession().setAttribute("user", users);
				
				return new ModelAndView("employee");
			}
			else if(user.getUserType().equalsIgnoreCase("admin") && users.size()==1)
			{
				return new ModelAndView("admin");
			}
			else
			{
				String str="loginerror";
				return new ModelAndView("error","msg",str);
			}
		}
		catch (EmployeeMaintenanceException e) 
		{
			System.out.println(e.getMessage());
		}	
		return new ModelAndView("");
	}
		
	@RequestMapping(value="/populatefsearchpara",method=RequestMethod.GET)
	public ModelAndView PopulateFsearch(@ModelAttribute("my") Employee emp)
	{
		List<String> fsearch=new ArrayList<String>();
		fsearch.add("ID");
		fsearch.add("First Name");
		fsearch.add("Last Name");
		fsearch.add("Marital Status");
		fsearch.add("Grade");
		fsearch.add("Department");
		return new ModelAndView("fsearch","fieldsearch",fsearch);
	}
	
	@RequestMapping(value="/populatewsearchpara",method=RequestMethod.GET)
	public ModelAndView PopulateWsearch(@ModelAttribute("my") Employee emp)
	{
		List<String> wsearch=new ArrayList<String>();
		wsearch.add("ID");
		wsearch.add("First Name");
		wsearch.add("Last Name");
		return new ModelAndView("wsearch","wildsearch",wsearch);
	}
	
	@RequestMapping(value="/searchby",method=RequestMethod.POST)
	public ModelAndView searchBy( @ModelAttribute("my") Employee emp,@RequestParam("FieldSearch") String fieldsearch,@RequestParam("search") String search, Map<String,Object> model )
	{		
		String columnname;
		try
		{
			switch(fieldsearch)
			{
				case "ID":	columnname="emp_id";
							emplist1=eService.getEmpDetailsOnId(columnname, search);
							System.out.println("list................................"+emplist1);
							if(emplist1.size()==0)
							{
								model.put("myq","No data available for corresponding employee Id");
							}						
							return new ModelAndView("Empdisplay","emplist",emplist1);
					
				case "First Name":	columnname="emp_first_name";
									emplist1=eService.getEmpDetailsOnId(columnname, search);
							        System.out.println("list................................"+emplist1);
							        if(emplist1.size()==0)
							        {
										model.put("myq","No data available for corresponding First name");
									}
							        return new ModelAndView("Empdisplay","emplist",emplist1);
							
				case "Last Name":	columnname="emp_last_name";
				        			emplist1=eService.getEmpDetailsOnId(columnname, search);
							        System.out.println("list................................"+emplist1);
							        if(emplist1.size()==0)
							        {
										model.put("myq","No data available for corresponding last name");
									}
							        return new ModelAndView("Empdisplay","emplist",emplist1);
							        
				case "Marital Status":	columnname="emp_marital_status";
				        				emplist1=eService.getEmpDetailsOnId(columnname, search);
								        System.out.println("list................................"+emplist1);
								        if(emplist1.size()==0)
								        {
											model.put("myq","No data available for corresponding marital status");
										}
								        return new ModelAndView("Empdisplay","emplist",emplist1);

				case "Grade":			columnname="emp_grade";
				         				emplist1=eService.getEmpDetailsOnId(columnname, search);
								         System.out.println("list................................"+emplist1);
								         if(emplist1.size()==0)
								         {
												model.put("myq","No data available for corresponding Grade");
								         }
								         return new ModelAndView("Empdisplay","emplist",emplist1);
				
				case "Department":		columnname="emp_dept_id";
							          	emplist1=eService.getEmpDetailsOnId(columnname, search);
							          	System.out.println("list................................"+emplist1);
							          	if(emplist1.size()==0)
							          	{
											model.put("myq","No data available for corresponding department Id");
										}
							          	return new ModelAndView("Empdisplay","emplist",emplist1);
							          	
				default:System.out.println("Please Select proper Option");
					break;
			}		
			System.out.println(fieldsearch);
			System.out.println(search);
		}
		catch (EmployeeMaintenanceException e) 
		{
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	@RequestMapping(value="/searchby1",method=RequestMethod.POST)
	public ModelAndView searchBy1( @ModelAttribute("my")  Employee emp,@RequestParam("WildSearch") String fieldsearch,@RequestParam("search") String search , Map<String,Object> model )
	{		
		String columnname;
		try
		{
			switch(fieldsearch)
			{
				case "ID":	columnname="emp_id";			
							emplist1= eService.getEmpDetailsOnWildCardId(columnname, search);
							System.out.println("list................................"+emplist1);
							 if(emplist1.size()==0)
							 {
									model.put("myq","No data available for corresponding Employee  Id");
							 }
							return new ModelAndView("Empdisplay1","emplist",emplist1);
					
				case "First Name":	columnname="emp_first_name";			
									emplist1= eService.getEmpDetailsOnWildCardId(columnname, search);
							        System.out.println("list................................"+emplist1);
							        if(emplist1.size()==0)
							        {
											model.put("myq","No data available for corresponding First Name");
									}
							        return new ModelAndView("Empdisplay1","emplist",emplist1);
				
				case "Last Name":	columnname="emp_last_name";
									emplist1= eService.getEmpDetailsOnWildCardId(columnname, search);
							        System.out.println("list................................"+emplist1);
							        if(emplist1.size()==0)
							        {
										model.put("myq","No data available for corresponding Last Name");
									}
							        return new ModelAndView("Empdisplay1","emplist",emplist1);
									
				default:			System.out.println("Please Select proper Option");
									break;
			}
			System.out.println(fieldsearch);
			System.out.println(search);
		}
		catch (EmployeeMaintenanceException e) 
		{
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	@RequestMapping(value="/multidept",method=RequestMethod.GET)
	public ModelAndView home(@ModelAttribute("multidept") Department dept)
	{		
		List<String> departmentchkbox=new ArrayList<>();
		departmentchkbox.add("Systems");
		departmentchkbox.add("Java Development");
		departmentchkbox.add("Business Intelligence");
		departmentchkbox.add("Mainframes");
		departmentchkbox.add("Cloud Computing");
		departmentchkbox.add("Testing");
		return new ModelAndView("deptchkbox","deptcbox",departmentchkbox);		
	}
	
	@RequestMapping(value="/mdepartment",method=RequestMethod.POST)
	public ModelAndView mdepart(@Valid@ModelAttribute("multidept") Department dept,BindingResult result,Map<String,Object> model) 
	{		
		if(result.hasErrors())
		{			
			List<String> departmentchkbox=new ArrayList<>();
			departmentchkbox.add("Systems");
			departmentchkbox.add("Java Development");
			departmentchkbox.add("Business Intelligence");
			departmentchkbox.add("Mainframes");
			departmentchkbox.add("Cloud Computing");
			departmentchkbox.add("Testing");
			return new ModelAndView("deptchkbox","deptcbox",departmentchkbox);
		}
		System.out.println(dept);
			try 
			{
				emplist1= eService.getEmpDetailsOnDepartment(dept);
			} 
			catch (EmployeeMaintenanceException e1) 
			{
				System.out.println(e1.getMessage());
			}	
			 if(emplist1.size()==0)
			 {				 
					model.put("myq","No data available for corresponding Last Name");
			 }
			return new ModelAndView("Multipledeptdisplay","emplist",emplist1);		   
	}
	
	@RequestMapping(value="/multigrade",method=RequestMethod.GET)
	public ModelAndView homegrade(@ModelAttribute("multigrade") Employee emp)
	{		
		List<String> departmentchkbox=new ArrayList<>();
		departmentchkbox.add("M1");
		departmentchkbox.add("M2");
		departmentchkbox.add("M3");
		departmentchkbox.add("M4");
		departmentchkbox.add("M5");
		departmentchkbox.add("M6");
		departmentchkbox.add("M7");
		return new ModelAndView("gradechkbox","deptcbox",departmentchkbox);
	}
	
	@RequestMapping(value="/mgrade",method=RequestMethod.POST)
	public ModelAndView mgrade(@Valid @ModelAttribute("multigrade") Employee emp,BindingResult result,Map<String,Object> model) 
	{		
		if(result.hasErrors())
		{
			System.out.println("error is in ............grade"+result.hasErrors());
			List<String> departmentchkbox=new ArrayList<>();
			departmentchkbox.add("M1");
			departmentchkbox.add("M2");
			departmentchkbox.add("M3");
			departmentchkbox.add("M4");
			departmentchkbox.add("M5");
			departmentchkbox.add("M6");
			departmentchkbox.add("M7");
			return new ModelAndView("gradechkbox","deptcbox",departmentchkbox);
		}		
		System.out.println(emp);
		try 
		{
			emplist1= eService.getEmpDetailsOnGrade(emp);
		} 
		catch (EmployeeMaintenanceException e1) 
		{
			e1.printStackTrace();
		}	
		if(emplist1.size()==0)
		{			 
			model.put("myq","No data available for corresponding grades");
	    } 
	    return new ModelAndView("Multipledeptdisplay","emplist",emplist1);
	}
	
	@RequestMapping(value="/multimarital",method=RequestMethod.GET)
	public ModelAndView homeMstatus(@ModelAttribute("multistatus") Employee emp)
	{		
		List<String> departmentchkbox=new ArrayList<>();
		departmentchkbox.add("M");
		departmentchkbox.add("S");
		departmentchkbox.add("s");
		departmentchkbox.add("W");
		departmentchkbox.add("D");		
		return new ModelAndView("mstatuschkbox","deptcbox",departmentchkbox);		
	}
	
	@RequestMapping(value="/mstatus",method=RequestMethod.POST)
	public ModelAndView mStatus(@Valid@ModelAttribute("multistatus") Employee emp,BindingResult result,Map<String,Object> model) 
	{		
		if(result.hasErrors()){
			System.out.println("error is in ............marital"+result.hasErrors());
			List<String> departmentchkbox=new ArrayList<>();
			departmentchkbox.add("M");
			departmentchkbox.add("S");
			departmentchkbox.add("s");
			departmentchkbox.add("W");
			departmentchkbox.add("D");			
			return new ModelAndView("mstatuschkbox","deptcbox",departmentchkbox);
		}
		System.out.println(emp);
			try 
			{
				emplist1= eService.getEmpDetailsOnMstatus(emp);
			} 
			catch (EmployeeMaintenanceException e1) 
			{
				e1.printStackTrace();
			}			
			if(emplist1.size()==0)
			{				 
				model.put("myq","No data available for corresponding Marital status");
		    }
		    return new ModelAndView("Multipledeptdisplay","emplist",emplist1);
	}
}
