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

import com.app.dao.VoterDao;
import com.app.pojos.Voter;

@Controller
@RequestMapping("/voter")
public class VoterController {
	// dependency controller: Dao

	@Autowired // byType //field level injection
	private VoterDao vdao;

	public VoterController() {
		System.out.println("inside voter controller ctor");
	}

	@RequestMapping("/login")
	public String showLoginForm() {
		System.out.println("inside showLoginForm");
		return "/voter/login";
	}

	@PostMapping("/login")
	public String processLoginForm(@RequestParam String email, @RequestParam String password, Model map,
			RedirectAttributes rat, HttpSession hs) {
		System.out.println("inside processLoginForm");
		Voter v = null;
		try {
			v = vdao.authenticateVoter(email, password);
			hs.setAttribute("voter", v);
		} catch (RuntimeException e) {
			System.out.println("login failed branch");
			map.addAttribute("msg", "Invaid Login Please retry!");
			return "/voter/login";
		}

		// success
		if (v.getStatus().equals("N")) {
			rat.addFlashAttribute("msg", "Woohoo! You're logged in!");
			return "redirect:/candidate/listCandidate";
		} else {
			rat.addFlashAttribute("status","AV");
			return "redirect:/voter/status";
		}

	}

	@GetMapping("/status")
	public String showVoteStatus(Model map, HttpSession hs) {
		String st = map.getAttribute("status") + "";
		System.out.println("st=" + st);
		if (st.equals("AV")) {
			map.addAttribute("status", "You have already cast your vote!....:-|");
			return "/voter/status";
		}
		if (st.equals("Y")) {
			String s = vdao.updateVotingStatus((Voter) hs.getAttribute("voter"));
			System.out.println("s=" + s);
			if (s.equals("1")) {
				map.addAttribute("status", "Vote cast successfully!....:-D");
				return "/voter/status";
			}
		}
		map.addAttribute("status", "Vote could not be cast...:-(");
		return "/voter/status";
	}
	
	@RequestMapping("/goback")
	public String gooBack() {
		return "redirect:/login";
	}
}
