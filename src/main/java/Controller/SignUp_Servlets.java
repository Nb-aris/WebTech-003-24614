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
@WebServlet("/SignUp_Servlets")
public class SignUp_Servlets extends HttpServlet {
    private SignUpService service;
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        service = (SignUpService) new SignUpServiceIMP(HibernateUtil.getSessionFactory());
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

     String email = request.getParameter("email");
     String password = request.getParameter("password");
     String name = request.getParameter("name");
     String type_of_user = request.getParameter("type_of_user");

     SignUp sign = new SignUp();

        sign.setEmail(email);
        sign.setPassword(password);
        sign.setFullname(name);
        sign.setType_of_user("Student");

       SignUp success = service.addUser(sign); // Assuming your service method returns a boolean indicating success

        if(success != null ){

         response.sendRedirect("signin.jsp");
     }else{
         response.sendRedirect("signup.jsp");
     }
    }
}
