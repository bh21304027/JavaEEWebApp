package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class loginFilter   implements Filter{
	public void init(FilterConfig config)throws ServletException{}
	public void destroy(){}

	public void doFilter(ServletRequest req, ServletResponse res,FilterChain chain) throws IOException,ServletException{
		HttpSession session = ((HttpServletRequest)req).getSession();

		String flag = (String)session.getAttribute("userid");
		System.out.println(flag);

		if(flag==null){
			System.out.println("filter");
			RequestDispatcher disp = req.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
			disp.forward(req,res);

		}else{
			chain.doFilter(req,res);
		}
	}
}







