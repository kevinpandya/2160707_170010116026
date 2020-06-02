package com.kevin;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.*;

public class FilterServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
		HttpSession ss = req.getSession();
		String userAgent = req.getHeader("user-agent");
		if (userAgent.indexOf("MSIE") > -1) {
			ss.setAttribute("Er", "Your browser is Microsoft Internet Explorer");
		}
		res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        String er_no = req.getParameter("er_no");
        out.println("Welcome "+er_no);
    }
}
