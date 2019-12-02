package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.pojos.Student;
import com.app.service.IStudentService;

//STUDENT CONTROLLER AUTOWIRED TO THE STUDENT SERVICE

@Controller
@RequestMapping("/student")
public class StudentController {
	
	public StudentController() {
	System.out.println("StudentController()");
	}

	@Autowired
	private IStudentService studService;
	
	//REQUEST HANDLING METHOD TO RENDER THE REGISTRATION FORM
	@GetMapping("/add")
	public String showAdmissionForm(Model map,Student s,@RequestParam int cid) {
		map.addAttribute("courseId", cid);
		return "/student/register";
	}
	
	//REQUEST HANDLING METHOD TO HANDLE THE FORM SUBMISSION
	@PostMapping("/add")
	public String processAdmissionForm(Student transientStudent, @RequestParam int courseId, RedirectAttributes rat) {
		System.out.println("inside processAdmissionForm() value of courseId="+courseId);
		
		//CALLING THE SERVICE METHOD TO ADD THE NEW TRANSIENT STUDENT REF
		String status=studService.admitNewStudent(transientStudent,courseId);
		
		//Y OR N IS RETURNED IF THE INPUTS WERE VALID [Y=SUCCESS,N=FAILURE]
		//IN THAT CASE WE HAD TO REDIRECT TO COURSES LIST PAGE
		if ((status.equals("Y") || status.equals("N"))) {
			rat.addFlashAttribute("status", status.equals("Y")?"Successfully Admitted!":"Could not register!");
			return "redirect:/courses/list";
		}
		
		//A STATUS MSG IS RETURNED IF ANY OF THE VALIDATIONS FAIL
		//IN THIS CASE, REDIRECT BACK TO THE FORM WITH THE MSG
		else {
			rat.addFlashAttribute("status",status);
			return "redirect:/student/add?cid="+courseId;
		}
	}
}
