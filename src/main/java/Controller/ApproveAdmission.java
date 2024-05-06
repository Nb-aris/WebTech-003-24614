package Controller;

import Model.Admission;
import Service.Implement.AdmissionServiceIMP;
import Services.AdmissionService;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet("/ApproveAdmission")
public class ApproveAdmission extends HttpServlet {
    private AdmissionService service;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        service = (AdmissionService) new AdmissionServiceIMP(HibernateUtil.getSessionFactory());
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        String action = request.getParameter("action");
        String email = request.getParameter("email");

        if("Approve".equals(action)) {
            Admission theUpdate = service.updateapprover(id,"Approved");
        }else if("Deny".equals(action)){
            Admission theUpdate = service.updateapprover(id,"Deny");
        }

//        JavaMailServlets emailServlet = new JavaMailServlets();
//        emailServlet.javaMail(email);

        response.sendRedirect("dashboard.jsp");

    }
}