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

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		try (PrintWriter pw = response.getWriter();) {
			VotingDaoImpl vdao=new VotingDaoImpl();
			Voter v = vdao.authenticateVoter(request.getParameter("vemail"), request.getParameter("vpass"));
			if (v == null) {
				pw.write("<h3>Invalid Email or Password! <a href='login.html'>Retry</a></h3>");
			} else {
				// create session
				HttpSession hs = request.getSession();
				// set the attributes
				hs.setAttribute("voterDetails", v);
				hs.setAttribute("votingDao", vdao);
				pw.write("<h2>Login Success!</h2>");
				pw.write("Details:" + v);
				if (v.getStatus().equals("N")) {
					pw.write("<h2><a href='candidateList'>Vote Now</a></h2>");
				}
				pw.write("<h2><a href='logout'>Logout</a></h2>");
			}
		} catch (Exception e) {
			throw new ServletException("Error in doGet: " + getClass().getName(), e);
		}
	}
}
