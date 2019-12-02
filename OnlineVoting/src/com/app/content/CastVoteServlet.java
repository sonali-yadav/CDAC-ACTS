package com.app.content;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.dao.VotingDaoImpl;
import com.app.pojos.Voter;

@WebServlet("/castVote")
public class CastVoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		try (PrintWriter pw = response.getWriter();) {
			HttpSession hs=request.getSession();
			Voter v=(Voter)hs.getAttribute("voterDetails");
			VotingDaoImpl vdao=(VotingDaoImpl)hs.getAttribute("votingDao");
			String candidateId=request.getParameter("candidate");
			String status=vdao.incVotesUpdateStatus(Integer.parseInt(candidateId),v.getId());
			pw.write(status.equals("true")?"<h2>Vote Cast Successfully!</h2>":"<h2>Could not vote!</h2>");
			pw.write("<a href='login.html'>Login Again</a>");
			vdao.cleanUp();
			hs.invalidate();
		} catch (Exception e) {
			throw new ServletException("err in doGet: "+getClass().getName(), e);
		}
	}
}