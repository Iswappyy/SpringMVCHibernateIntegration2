package com.pro.wings.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pro.wings.entity.Employee;
import com.pro.wings.service.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	EmployeeService empService;

	@RequestMapping(value ="/addEmployee", method = RequestMethod.POST)
	public ModelAndView addEmployee(@RequestParam("name") String empname, @RequestParam("salary") String empSalary) {
		ModelAndView mv = new ModelAndView();

		mv.setViewName("welcome");

		Employee emp1 = new Employee();
		emp1.setEmpname(empname);
		emp1.setEmpSalary(Integer.parseInt(empSalary));

		boolean storedEmp = empService.addEmployee(emp1);
		String result = null;

		if (storedEmp) {
			result = "Employee stored Succesfully...";
			mv.addObject("result", result);
		} else {
			result = "Employee NOT stored Succesfully...!";
			mv.addObject("result", result);
		}
		return mv;
	}
}
