package com.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.daos.IEmployeeDao;
import com.app.pojos.Employee;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private IEmployeeDao edao;

	public EmployeeController() {
		System.out.println("inside EmployeeController() ctor");
	}

	@GetMapping("/hire")
	public String showRegForm(@RequestParam int deptid, Employee emp, Model map) {
		System.out.println("inside showRegForm() method");
		map.addAttribute("deptId", deptid);
		return "/employee/hire";
	}

	@PostMapping("/hire")
	public String processRegForm(Employee transientEmp, @RequestParam int deptId, HttpSession hs, RedirectAttributes rat) {
		System.out.println("inside processRegForm() method");
		//String s = edao.hireEmployee(transientEmp, Integer.parseInt(hs.getAttribute("deptId") + ""));
		String s = edao.hireEmployee(transientEmp, deptId);
		rat.addFlashAttribute("msg", s.equals("Y")? "Successfully hired!":"Could not hire!");
		return "redirect:/department/departments";
	}
}
