package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.dao.CandidateDao;

@Controller
@RequestMapping("/candidate")
public class CandidateController {

	@Autowired
	private CandidateDao cdao;

	@GetMapping("/listCandidate")
	public String getCandidatesList(Model map) {
		map.addAttribute("candidateList", cdao.getCandidateList());
		return "/candidate/listCandidate";
	}

	@RequestMapping("/castvote")
	public String castVote(@RequestParam String candid, RedirectAttributes rat) {
		String status = cdao.incVotes(Integer.parseInt(candid));
		System.out.println("status="+status);
		rat.addFlashAttribute("status", status);
		return "redirect:/voter/status";
	}
}
