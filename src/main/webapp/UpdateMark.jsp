<%@ page import="dao.StudentsMarksDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Mark</title>
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
<h2 class="h2" align="center">Update Mark</h2>
<table align="center">
    <form action="Servlets.WebAppServlet">
        <%
            String idStud = request.getParameter("id_student");
            String idSubj = request.getParameter("id_subject");
        %>
        <tr>
            <td>ID Student <input type="text" name="id_student"
                                  value="<%= idStud%>" readonly="readonly"
                                  size="2"/></td>
        </tr>
        <tr>
            <td>ID_Subject <input type="text" name="id_subject"
                                  value="<%= idSubj%>" readonly="readonly"
                                  size="2"/></td>
        </tr>
        <tr>
            <td>Mark <input type="text" name="Mark" value="" size="2"></td>
        </tr>
        <td><input type="hidden" name="formName" value="updateMark"/></td>
        <tr>
            <td><input type="submit" value="Edit"/></td>
        </tr>
    </form>
</table>
</body>
</html>
