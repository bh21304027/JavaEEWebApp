package applicationcontroller;


import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import command.CommandFactory;
import command.AbstractCommand;
import context.RequestContext;
import context.ResponseContext;
import context.WebRequestContext;
import context.WebResponseContext;

public class WebApplicationController implements ApplicationController {
	public RequestContext getRequest(Object request){
		RequestContext reqc = new WebRequestContext();
		
		reqc.setRequest(request);
		
		return reqc;
	}
	
	public ResponseContext handleRequest(RequestContext req){
		AbstractCommand command = CommandFactory.getCommand(req);
		command.init(req);
		
		ResponseContext resc = command.execute(new WebResponseContext());
		
		return resc;
	}
	
	public void handleResponse(RequestContext req,ResponseContext res){
		HttpServletRequest request = (HttpServletRequest)req.getRequest();
		HttpServletResponse response = (HttpServletResponse)res.getResponse();
		
		request.setAttribute("data",res.getResult());
		
		RequestDispatcher rd = request.getRequestDispatcher(res.getTarget());
		
		try{
			rd.forward(request,response);
			
		}catch(ServletException e){
			throw new RuntimeException(e.getMessage(),e);
		}catch(IOException e){
			throw new RuntimeException(e.getMessage(),e);
		}
	}
}

