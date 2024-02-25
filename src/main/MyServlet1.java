import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.*;
import java.util.*;
@WebServlet("/Myserv")
public class MyServlet1 extends GenericServlet
{
    public void service (ServletRequest request, ServletResponse response) throws ServletException, IOException
    {
        response.setContentType ("text/html");// Response type
        PrintWriter out = response.getWriter ();
        System.out.println ("Servlet is called");
        Locale loc = response.getLocale ();
        out.println ("Locale set for this application is " + loc.toString ());
    }
}