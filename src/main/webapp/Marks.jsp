<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List, dto.StudentsMarksDTO, dao.StudentsMarksDAO" %>
<html>
<head>
    <title>Marks Information</title>
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
<h2 class="h2" align="center">List of Marks</h2>
<table align="center" border width=30%>
    <th></th>
    <th></th>
    <th>ID</th>
    <th>ID_Student</th>
    <th>ID_Subject</th>
    <th>Mark</th>
    <%
        StudentsMarksDAO studentsMarksDAO = new StudentsMarksDAO();
        List<StudentsMarksDTO> l = studentsMarksDAO.readall();
        for (StudentsMarksDTO allMarks : l) { %>
    <tr>
        <td><a href="UpdateMark.jsp?formName=confirmUpdateMark&id_student=<%= allMarks.getIdStudent()%>&id_subject=<%= allMarks.getIdSubject() %>">Edit</a></td>
        <td><a href="DeleteMark.jsp?formName=confirmDeleteMark&id=<%= allMarks.getId() %>">Delete</a></td>
        <td><%= allMarks.getId() %>
        </td>
        <td><%= allMarks.getIdStudent() %>
        </td>
        <td><%= allMarks.getIdSubject() %>
        </td>
        <td><%= allMarks.getMark() %>
        </td>
    </tr>
    <% } %>
</table>
<br>
<table align="center">
    <form action="Servlets.WebAppServlet">
        <tr>
            <td>ID Student <input type="text" name="id_student" value=""></td>
        </tr>
        <tr>
            <td>ID Subject <input type="text" name="id_subject" value=""></td>
        </tr>
        <td>Mark <input type="text" name="mark" value=""></td>
        <td><input type="hidden" name="formName" value="addMark"></td>
        <tr>
            <td><input type="submit" value="Add new mark"></td>
        </tr>
    </form>
</table>
<form action="University.html">
    <br><br><br>

    <h2 align="center"><input type="submit" value="Back to main"></h2>
</form>
</body>
</html>
