package Controller;

import Model.Admission;
import Service.Implement.AdmissionServiceIMP;
import Service.Implement.SignUpServiceIMP;
import Services.AdmissionService;
import Services.SignUpService;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet("/AdmisionServlets")
public class AdmisionServlets extends HttpServlet {
    private AdmissionService service;
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        service = (AdmissionService) new AdmissionServiceIMP(HibernateUtil.getSessionFactory());
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // Get other form parameters
        String fullName = request.getParameter("name");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        String bd = request.getParameter("bd");
        String course = request.getParameter("course");
        String status = request.getParameter("status");
        String passportPicture = request.getParameter("passportPicture");
        String otherDocument = request.getParameter("otherDocument");


        Admission admission = new Admission();
        admission.setFullname(fullName);
        admission.setEmail(email);
        admission.setBd(bd);
        admission.setGender(gender);
        admission.setCourse(course);
        admission.setStatus("Pending");
        admission.setPassportPicture(passportPicture.getBytes());
        admission.setAdmissionDocument(otherDocument.getBytes());

        Admission theAdmission = service.addStudent(admission);
        if (theAdmission != null) {

            request.setAttribute("name", fullName);
//            JavaMailServlets emailServlet = new JavaMailServlets();
//            emailServlet.javaMail(email);
            getServletContext().getRequestDispatcher("/Confirmation.jsp").forward(request, response);
        }

    }

}

