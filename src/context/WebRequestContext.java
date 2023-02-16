package context;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class WebRequestContext implements RequestContext {
    private Map<String, String[]> _parameters;
    private HttpServletRequest _request;
    public WebRequestContext(){}

    public void setRequest(Object request){
        _request = (HttpServletRequest)request;
        _parameters =_request.getParameterMap();
    }

    public Object getRequest(){
        return _request;
    }

    public String getCommandPath(){
        String servletPath = _request.getServletPath();
    	String commandPath = servletPath.substring(1);
        return commandPath;
    }

    public String[] getParameter(String key){
        return (String[])_parameters.get(key);
    }
}