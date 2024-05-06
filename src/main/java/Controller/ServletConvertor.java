package Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletConvertor extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        // Retrieve the input from the user
        String numParameter = req.getParameter("num");
        String binarys= req.getParameter("bn");
        String hexas = req.getParameter("hex");
        String octals = req.getParameter("oct");
        String clr = req.getParameter("Clr");

        if (numParameter != null && !numParameter.isEmpty()) {
            int decimalNumber = Integer.parseInt(numParameter);

            // Set the appropriate values in the response
            if("Binary".equals(binarys)) {
                String tobinary = Integer.toBinaryString(decimalNumber);
                req.setAttribute("numbers",decimalNumber);
                req.setAttribute("result", tobinary);
                req.setAttribute("status", "Decimal number To Binary");
                RequestDispatcher dispatcher = req.getRequestDispatcher("number_converter.jsp");
                dispatcher.forward(req,res);
            } else if ("Hexa".equals(hexas)) {
                String tohexa = Integer.toHexString(decimalNumber);
                req.setAttribute("numbers",decimalNumber);
                req.setAttribute("result", tohexa);
                req.setAttribute("status", "Decimal number To Hexa");
                RequestDispatcher dispatcher = req.getRequestDispatcher("number_converter.jsp");
                dispatcher.forward(req,res);
            } else if ("Octal".equals(octals)) {
                String  toctal = Integer.toOctalString(decimalNumber);
                req.setAttribute("numbers",decimalNumber);
                req.setAttribute("result", toctal);
                req.setAttribute("status", "Decimal number To Octal");
                RequestDispatcher dispatcher = req.getRequestDispatcher("number_converter.jsp");
                dispatcher.forward(req,res);
            }else if("Clear".equals(clr)){
                numParameter = "";
            }

        } else {
            res.setContentType("text/html");
            res.getWriter().println("<html><body>");
            res.getWriter().println("<h2>Error</h2>");
            res.getWriter().println("<p>Invalid input. Please provide a valid number.</p>");
            res.getWriter().println("</body></html>");
        }
    }
}

