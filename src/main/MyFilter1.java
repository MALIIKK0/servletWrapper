import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;

@WebFilter("/Myserv")
public class MyFilter1 implements Filter {


    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void destroy() {
    }

    // This method is called each time a client requests for a web resource preprocessing request
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<b> <i>Filtering request and passing it to Wrapper class</i> </b> <br/>");
        System

        // Wrapping the request
        RequestWrapper requestWrapper = new RequestWrapper(request);
        // Wrapping the response
        ResponseWrapper responseWrapper = new ResponseWrapper(response);

        // This method calls the next filter in the chain
        chain.doFilter(requestWrapper, responseWrapper);

        // You can perform any post-processing here if needed before sending the response to the client

        responseWrapper.getWriter().println("Post-processing");
    }
}
