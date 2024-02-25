import javax.servlet.*;
public class RequestWrapper extends ServletRequestWrapper
{


    public RequestWrapper(ServletRequest request) {
        super(request);
    }

    public String getParameter (String str)
    {
        //Calling the superclass method i.e. ServletRequest's getParameter(String) method.
        String name = super.getParameter (str);
        if (name.equals (""))
        {
            name = "Please, enter your name in the form";
        }
        return name;
    }
}