package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojo.Employee;
import com.app.service.EmployeeServiceImp;

@RestController // @Controller + @ResponceBody = @RestController
@CrossOrigin(origins = "*")
public class EmployeeController {

	public EmployeeController() {
		System.out.println("In EmployeeController class Constructor :-  " + getClass());
	}

	@Autowired
	private EmployeeServiceImp empService;

	@PostMapping(value = "/addEmp")
	public ResponseEntity<String> addEmp( @RequestBody Employee e) {
		boolean res = empService.addEmployees(e);

		if (res == true)
			return new ResponseEntity<String>("Employee added Sucessefully", HttpStatus.CREATED);
		else
			return new ResponseEntity<String>("failed !!", HttpStatus.BAD_REQUEST);

	}

	
	@GetMapping(value = "/getAllEmployee")
	public ResponseEntity<List<Employee>> getAllEmployess() {

		List<Employee> allEmp = empService.getEmployees();
		if(allEmp != null) {
			return new ResponseEntity<List<Employee>>(allEmp, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Employee>>(HttpStatus.BAD_REQUEST);
		}
	}

	
	@GetMapping("/getOneEmployee")
	public ResponseEntity<Employee> getOneEmployee(@RequestParam Integer id) {
		
		Employee emp = empService.getPerticularEmployee(id);
		
		if (emp != null)
			return new ResponseEntity<Employee>(emp, HttpStatus.OK);
		else
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
	}
	
	
	@DeleteMapping("/deleteById/{id}")
	public @ResponseBody ResponseEntity<String> deleteByIDs(@RequestBody @PathVariable("id") Integer id){
		
		boolean flag = empService.deleteEmp(id);
		
		if(flag == true) {
			return new ResponseEntity<String>("Employee Deleted Sucessfully !!", HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("Employee Not Found !!", HttpStatus.BAD_REQUEST);
		}
	}
	
	
	@PatchMapping("/locationUpdate")
	public @ResponseBody ResponseEntity<? extends String> updateOnlyLocation(@RequestParam Integer id, @RequestBody Employee emp){
			
		boolean result = empService.updatLocation(id, emp);
		
		if(result == true)
			return new ResponseEntity<String>("Employee Location Chanaged !!",HttpStatus.CREATED);
		else
			return new ResponseEntity<String>("Update Error !!", HttpStatus.BAD_REQUEST);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
