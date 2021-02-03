package za.co.myapp.web;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*")
public class StatsAndErrorFilter implements Filter {

    int requestCounter;
    int errorCounter;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.requestCounter = 0;
        this.errorCounter = 0;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String showCounter = request.getParameter("stats");

        if (showCounter != null && showCounter.equals("true")) {
            response.getWriter().println("Requests:" + requestCounter);
            response.getWriter().println("Errors:" + errorCounter);
        } else {
            this.requestCounter++;
            try {
                chain.doFilter( request, response );
            } catch ( IllegalArgumentException ex ) {
                this.errorCounter++;
                HttpServletResponse resp = (HttpServletResponse) response;
                resp.setStatus(400);
                resp.setContentType("application/json");
                resp.getWriter().print("Illegal Argument - " + ex.getMessage()); 
            } catch ( Throwable t ) {
                this.errorCounter++;
                HttpServletResponse resp = (HttpServletResponse) response;
                resp.setStatus(500);
                resp.setContentType("application/json");
                resp.getWriter().print(t.getMessage());
            }
        }
    }

    @Override
    public void destroy() {

    }
}
