package com.app.content;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.dao.VotingDao;
import com.app.dao.VotingDaoImpl;
import com.app.pojos.Candidate;

@WebServlet("/candidateList")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		try (PrintWriter pw = response.getWriter();) {
			HttpSession hs=request.getSession();
			VotingDao vd=(VotingDaoImpl)hs.getAttribute("votingDao");
			List<Candidate> lop=vd.getCandidateList();
			pw.print("<form action='castVote'>");
			for (Candidate c : lop) {
				pw.print("<div><input type=radio name=candidate value=" + c.getId() + ">" + c.getName() + " " + c.getPolitical_party()+"</div>");
			}
			pw.print("<input type=submit value='Vote'>");
			pw.print("</form>");
		} catch (Exception e) {
			throw new ServletException("err in doGet: "+getClass().getName(), e);
		}
	}
}
