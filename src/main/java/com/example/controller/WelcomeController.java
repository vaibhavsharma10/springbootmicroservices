package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.bean.Employee;

@RestController
public class WelcomeController {
	
	public static List<Employee> employeeList = new ArrayList<>();
	
	@GetMapping("/helloservice2")
	public @ResponseBody String hello() {
		return "I am testing Jenkins again";
	}
	
	@GetMapping("/getEmployees")
	public @ResponseBody List<Employee> getEmployees(){
		return employeeList;
	}
	
	@PostMapping("/postEmployee")
	public @ResponseBody String postEmployee(@RequestParam("empId") String empId, @RequestParam("empName") String empName) {
		Employee emp = new Employee();
		emp.setEmpId(empId);
		emp.setEmpName(empName);
		
		if(!employeeList.contains(emp)) {
			employeeList.add(emp);
			return "Employee added Successfully";
		}else {
			return "Employee already exist";
		}
	}
}
