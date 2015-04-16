<%@ page import="java.util.Map, dto.StudentDTO, dto.SubjectDTO, dto.StudentsMarksDTO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Results of student</title>
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
<h2 class="h2" align="center">Results of student</h2>
<table align="center">
    <form action="Servlets.WebAppServlet">
        <tr>
            <td>ID Student <input type="text" name="id_student" value="" size="2"></td>
            <td><input type="hidden" name="formName" value="addMark">
            <td><input type="submit" value="Show results"></td>
        </tr>
    </form>
</table>
<br>
<table align="center" border width=25%>
    <th>Second Name</th>
    <th>First Name</th>
    <th>Subject</th>
    <th>Mark</th>
</table>

<form action="University.html">
    <br><br><br>

    <h2 align="center"><input type="submit" value="Back to main"></h2>
</form>
</body>
</html>