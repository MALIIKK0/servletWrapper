

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

/**
 * Servlet Filter implementation class WebFilterWrapper
 */
@WebFilter("/*")
public class WebFilterWrapper extends HttpFilter implements Filter {
       
    

	
	public void destroy() {
		// TODO Auto-generated method stub
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub

		HttpServletResponseWrapper res = new HttpServletResponseWrapper ((HttpServletResponse) response);

		HttpServletRequestWrapper req = new HttpServletRequestWrapper ((HttpServletRequest) request) {
		  public String getParameter(String name) {
            
              String parameterValue = super.getParameter(name);
              System.out.println(parameterValue);
              return parameterValue != null ? parameterValue.toUpperCase() : null;
          }
		};
		HttpServletResponseWrapper responseWrapper = new HttpServletResponseWrapper((HttpServletResponse) response) {
            @Override
            public void setStatus(int sc) {
                
                super.setStatus(sc + 100); // Adding 100 to the status code
            }
        };
        System.out.println("Before");
		
		chain.doFilter(req, res);
		
		System.out.println("After");
		
	}


	
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
