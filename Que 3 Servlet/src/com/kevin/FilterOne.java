package com.kevin;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.Filter;

public class FilterOne implements Filter{
    @Override
    public void init(FilterConfig config){
        
    }

    @Override
    public void doFilter(ServletRequest req,ServletResponse res, FilterChain chain) throws IOException, ServletException{
        PrintWriter out = res.getWriter();
        StringBuilder reverse = new StringBuilder();
        reverse.append(req.getParameter("er_no"));
        reverse = reverse.reverse();
        req.setAttribute("rev_er_no", reverse);
        chain.doFilter(req, res);
        out.println("Your reverse Enrollment No.: "+reverse);
    }
    @Override
    public void destroy(){
        
    }
}