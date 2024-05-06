<%@ page import="Model.Admission" %>
<%@ page import="Services.AdmissionService" %>
<%@ page import="Service.Implement.AdmissionServiceIMP" %>
<%@ page import="Controller.HibernateUtil" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Dashboard</title>
</head>
<body>
<h1>Admissions Dashboard</h1>
<form action="DashboardServlet" method="get">
<table border="3">
    <thead>
    <tr>
        <th>Name</th>
        <th>Email</th>
        <th>Gender</th>
        <th>Course</th>
        <th>Status</th>
        <th>Document</th>
        <th>Passport</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <%
        AdmissionService service;
        service = new AdmissionServiceIMP(HibernateUtil.getSessionFactory());
        List<Admission> admissions = service.allStudent();
    %>
    <%
        for(Admission admission: admissions){
    %>
        <tr>
            <td><%=admission.getFullname()%></td>
            <td><%=admission.getEmail()%></td>
            <td><%=admission.getGender()%></td>
            <td><%=admission.getCourse()%></td>
            <td><%=admission.getStatus()%></td>
            <td><%=admission.getAdmissionDocument()%></td>
            <td><%=admission.getPassportPicture()%></td>
            <td>
                <a href="ApproveAdmission?id=<%= admission.getStud_id() %>&action=Approve&email=<%= admission.getEmail() %>">Approve</a>&nbsp;&nbsp;
                <a href="ApproveAdmission?id=<%= admission.getStud_id() %>&action=Deny&email=<%= admission.getEmail() %>">Deny</a>
            </td>
        </tr>
       <%
        }
        %>
    </tbody>
</table>
</form>
</body>
</html>
