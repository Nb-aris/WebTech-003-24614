package Controller;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class FilterAuthentication implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        // Get the session
        HttpSession session = httpRequest.getSession(false);

        // Allow access to login page and sign-up page without authentication
        String loginURI = httpRequest.getContextPath() + "/signin.jsp";
        String signUpURI = httpRequest.getContextPath() + "/signup.jsp";
        boolean loggedIn = session != null && session.getAttribute("email") != null;
        boolean loginRequest = httpRequest.getRequestURI().equals(loginURI);
        boolean signUpRequest = httpRequest.getRequestURI().equals(signUpURI);

        if (loggedIn || loginRequest || signUpRequest) {
            chain.doFilter(request, response); // User is authenticated or accessing login or sign-up page
        } else {
            // Redirect to login page for other pages
            httpResponse.sendRedirect(loginURI);
        }
    }

    // Other methods of the Filter interface (init, destroy) can be left unimplemented
}



