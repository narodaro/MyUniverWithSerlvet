<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List, dao.SubjectDAO" %>
<%@ page import="dto.SubjectDTO" %>
<html>
<head>
    <title>Student Information</title>
    <style type="text/css">
        h1 {
            color: #003e80
        }

        h2 {
            color: green;
        }

        body {
            background-color: #FFEE8C
        }
    </style>
</head>
<body>
<h1 class="h1" align="center">My University</h1>
<hr>
<h2 class="h2" align="center">List of subjects</h2>
<table align="center" border width=30%>
    <th></th>
    <th></th>
    <th>ID</th>
    <th>Subject</th>
    <%
        SubjectDAO subjectDAO = new SubjectDAO();
        List<SubjectDTO> l = subjectDAO.readall();
        for (SubjectDTO sb : l) {
    %>
    <tr>
        <td><a href="UpdateSubject.jsp?UpdateSubject&id=<%= sb.getId() %>">Edit</a></td>
        <td><a href="DeleteSubject.jsp?DeleteSubject&id=<%= sb.getId() %>">Delete</a></td>
        <td><%= sb.getId() %>
        </td>
        <td><%= sb.getSubject_name() %>
        </td>
    </tr>
    <% } %>
</table>
<br>
<table align="center">
    <form action="Servlets.WebAppServlet">
        <tr>
            <td>Subject <input type="text" name="Subject" value=""></td>
        </tr>
        <tr>
            <td><input type="submit" value="Add new subject"></td>
        </tr>
        <td><input type="hidden" name="formName" value="addSubject"></td>
    </form>
</table>
<form action="University.html">
    <br><br><br>

    <h2 align="center"><input type="submit" value="Back to main"></h2>
</form>
</body>
</html>
