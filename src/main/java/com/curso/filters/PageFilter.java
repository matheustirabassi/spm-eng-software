package com.curso.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.jboss.logging.Logger;
import com.curso.controller.LoginBean;
import com.curso.modelo.Login;

@WebFilter(urlPatterns = "/restricted/*", servletNames = "{Faces Servlet}")
public class PageFilter implements Filter {
  private Logger log = Logger.getLogger(LoginBean.class);

  public void destroy() {
    // Nunca usado

  }

  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    HttpSession session = ((HttpServletRequest) request).getSession();
    Login administrador = (Login) session.getAttribute("user");

    if (administrador == null || session.isNew()) {
      log.debug("Sessão não iniciada...");
      ((HttpServletRequest) request).getContextPath();
      RequestDispatcher dispatcher = request.getRequestDispatcher("/login.xhtml");
      dispatcher.forward(request, response);
    } else {
      chain.doFilter(request, response);
    }

  }

  public void init(FilterConfig arg0) throws ServletException {
    // Nunca usado

  }

}
