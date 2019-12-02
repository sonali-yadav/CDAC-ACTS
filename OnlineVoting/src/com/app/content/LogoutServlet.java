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

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		try (PrintWriter pw = resp.getWriter();) {
			HttpSession hs = req.getSession();
			Voter v = (Voter) hs.getAttribute("voterDetails");
			if (v != null) {
				VotingDaoImpl vdao = (VotingDaoImpl) hs.getAttribute("votingDao");
				vdao.cleanUp();
				hs.invalidate();
				pw.write("<h1>Logged Out Successfully</h1>");
				pw.write("<h3><a href='login.html'>Login</a></h3>");
			}
		} catch (Exception e) {
			throw new ServletException("error in doGet: " + getClass().getName(), e);
		}
	}
}
