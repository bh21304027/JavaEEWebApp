package context;

import javax.servlet.http.HttpServletResponse;

public class WebResponseContext implements ResponseContext{
    private String target;
    private Object result;
    private HttpServletResponse _response;

    public WebResponseContext(){}

    public void setTarget(String transferInfo){
        target="/WEB-INF/jsp/"+transferInfo+".jsp";
    }
    public void setTargetcommand(String transferInfo){
        target=transferInfo;
    }

    public String getTarget(){
        return target;
    }

    public void setResult(Object bean){
        result=bean;
    }

    public Object getResult(){
        return result;
    }

    public void setResponse(Object obj){
        _response =(HttpServletResponse)obj;
    }
    public Object getResponse(){
        return _response;
    }
}