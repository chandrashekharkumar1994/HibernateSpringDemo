package com.landq.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.landq.bean.Employee;
import com.landq.dao.EmpDAO;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

@Controller
public class MVCController {
	@Autowired
	EmpDAO objDAO;
	
	@RequestMapping("/hello")
	public String load(){
		return "page2";
   }
	//Login
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String load1(@RequestParam("user") String name,@RequestParam("password") String pass,Model m){
		String MSG,page;
		//System.out.println("Inside login controller");
		if(pass.equals("password")&&name.equals("Shekhar")){
			
			MSG="<h1 style='color:blue;'>welcome "+name+"</h1>";
			page="welcome";
		}
		else{
			MSG="Invalid User/Password";
			page="../../index";
		}
		m.addAttribute("MSG",MSG);
		return page;
	}
	//view employee list
	@RequestMapping("/view_emp")
	public String viewEmp(Model m){
		//System.out.println("This is viewEmp");
		List<Employee> list=objDAO.getEmployees();
		m.addAttribute("emp_list", list);
		return "view";
	}
	//delete by id
	@RequestMapping(value="/delete_emp/{id}",method=RequestMethod.GET)
	public String deleteEmp(@PathVariable int id){
		int i=0;
		i=objDAO.deleteEmp(id);
		if(i>=1){
			return "redirect:/view_emp";
		}
		else{
			return "redirect:/view_emp?msg=failed to delete !";
		}
	}
	//add employee form
	@RequestMapping(value="/emp_form")
	public String empForm(Model m){
		m.addAttribute("command", new Employee());
		return "emp_form";
	}
	
	//when a file upload is required instead of normal form data
	/*public String addEmp(@ModelAttribute("emp") Employee emp,@RequestParam CommonsMultipartFile file,HttpSession session)throws Exception{
		ServletContext context = session.getServletContext();  
	    String path = context.getRealPath(upload_directory);  
	    String filename = file.getOriginalFilename(); 
		String file_name=path + File.separator + filename;
		System.out.println(file_name);
	    byte[] bytes = file.getBytes();  
	    BufferedOutputStream stream =new BufferedOutputStream(new FileOutputStream(  
	         new File(path + File.separator + filename)));  
	    stream.write(bytes);  
	    stream.flush();  
	    stream.close();  
		int i=0;
		i=objDAO.addEmployee(emp);
		if(i>0) return "redirect:/view_emp";
		else return "emp_form?MSG=failed to save !";
	}*/
	//Save Employee
	@RequestMapping(value="/add_emp",method=RequestMethod.POST)
	public String addEmp(@ModelAttribute("emp") Employee emp){
		int i=0;
		i=objDAO.addEmployee(emp);
		if(i>0) return "redirect:/view_emp";
		else return "emp_form?MSG=failed to save !";
	}
	//Edit employee form
	@RequestMapping(value="/edit_emp/{id}")
	public String editEmp(@PathVariable int id,Model m){
		Employee e=objDAO.getEmployeeByID(id);
		m.addAttribute("command",e);
		return "edit_emp";
	}
	//save edited employee form
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String saveEdit(@ModelAttribute("emp") Employee emp ){
		//System.out.println("Reaches..");
		int i=objDAO.updateEmployee(emp);
		if(i>=1)
		return "redirect:/view_emp";
		else
			return "redirect:/view_emp?msg=Failed to update !";
	}
}