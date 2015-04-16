<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Student</title>
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
<h2 class="h2" align="center">Update Student</h2>
<table align="center">
    <form action="Servlets.WebAppServlet">
        <% String stID = request.getParameter("id"); %>
        <tr>
            <td>First Name <input type="text" name="firstName" value=""/></td>
        </tr>
        <tr>
            <td>Last Name <input type="text" name="secondName" value=""/></td>
        </tr>
        <tr>
            <td>ID <input type="text" name="ID" value="<%= stID %>" readonly="readonly" size="2"/></td>
        </tr>
        <td><input type="hidden" name="formName" value="updateStudent"/></td>
        <tr>
            <td><input type="submit" value="Edit"/></td>
        </tr>
    </form>
</table>
</body>
</html>
