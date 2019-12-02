package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.service.ICourseService;

//COURSE CONTROLLER AUTOWIRED TO COURSE SERVICE

@Controller
@RequestMapping("/courses")
public class CourseController {

	public CourseController() {
	System.out.println("CourseController()");
	}
	
	@Autowired
	private ICourseService cservice;
	
	//REQUEST HANDLING METHOD TO RENDER COURSE LIST
	@GetMapping("/list")
	public String getCourseList(Model map) {
		map.addAttribute("courseList", cservice.getCourseList());
		return "/courses/list";
	}
	
	//REQUEST HANDLING METHOD TO DELETE A COURSE
	@GetMapping("/delete")
	public String deleteCourse(@RequestParam int cid) {
		cservice.deleteCourse(cid);
		return "redirect:/courses/list";
	}
}
