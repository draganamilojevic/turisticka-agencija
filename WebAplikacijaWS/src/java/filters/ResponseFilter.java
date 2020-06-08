package filters;

import java.io.IOException;
import java.util.logging.Logger;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

@WebFilter(filterName = "AddHeaderFilter", urlPatterns = {"/*"})
public class ResponseFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (response instanceof HttpServletResponse) {
            HttpServletResponse http = (HttpServletResponse) response;
            http.addHeader("Access-Control-Allow-Origin", "*");
            http.addHeader("Access-Control-Allow-Credentials", "true");
            http.addHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
            http.addHeader("Access-Control-Allow-Headers", "content-type");
        }
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }
}
