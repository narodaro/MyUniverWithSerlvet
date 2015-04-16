<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List, dto.StudentDTO, dao.StudentDAO" %>
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
<h2 class="h2" align="center">List of students</h2>
<table align="center" border width=40%>
    <th></th>
    <th></th>
    <th>ID</th>
    <th>First Name</th>
    <th>Last Name</th>
    <%
        StudentDAO studentDAO = new StudentDAO();
        List<StudentDTO> l = studentDAO.readall();
        for (StudentDTO st : l) { %>
    <tr>
        <td><a href="UpdateStudent.jsp?UpdateStudent&id=<%= st.getId() %>">Edit</a></td>
        <td><a href="DeleteStudent.jsp?DeleteStudent&id=<%= st.getId() %>">Delete</a></td>
        <td><%= st.getId() %>
        </td>
        <td><%= st.getFirstName() %>
        </td>
        <td><%= st.getSecondName() %>
        </td>
    </tr>
    <% } %>
</table>
<br/>
<table align="center">
    <form action="Servlets.WebAppServlet">
        <tr>
            <td>First Name <input type="text" name="FirstName" value=""/></td>
        </tr>
        <tr>
            <td>Last Name <input type="text" name="SecondName" value=""/></td>
        </tr>
        <td><input type="hidden" name="formName" value="addStudent"/></td>
        <tr>
            <td><input type="submit" value="Add new student"/></td>
        </tr>
    </form>
</table>
<form action="University.html">
    <br><br><br>

    <h2 align="center"><input type="submit" value="Back to main"/></h2>
</form>
</body>
</html>
