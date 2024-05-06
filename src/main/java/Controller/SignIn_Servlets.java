package Controller;
import Model.SignUp;
import Service.Implement.SignUpServiceIMP;
import Services.SignUpService;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/SignIn_Servlets")
public class SignIn_Servlets extends HttpServlet {

    private SignUpService signUpService;

    @Override
    public void init() {
        signUpService = new SignUpServiceIMP(HibernateUtil.getSessionFactory());
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String emails = request.getParameter("email");
        String passwd = request.getParameter("password");
        String role = request.getParameter("admins");

        if(role != null && role.equals("admin")) {
            // Authenticate user using the SignUpService
            SignUp theLogin = signUpService.login(emails, passwd, role);
            if (theLogin != null) {
                // Create a session and store the email
                HttpSession session = request.getSession(true);
                session.setAttribute("email", emails);

                // Redirect to the admission page
                response.sendRedirect("dashboard.jsp");

            }else {
            System.out.println("No no");
            // If authentication fails, redirect back to the sign-in page
            response.sendRedirect("signin.jsp");

        }
        }else if (role == null || !role.equals("admin")){
            String roles="Student";
            SignUp theLogin = signUpService.login(emails, passwd, roles);
            if (theLogin != null ) {
                // Create a session and store the email
                HttpSession session = request.getSession(true);
                session.setAttribute("email", emails);
                // Redirect to the admission page
                response.sendRedirect("Admission.jsp");

            } else {
                System.out.println("No no");
                // If authentication fails, redirect back to the sign-in page
                response.sendRedirect("signin.jsp");

            }
        }
    }
}
