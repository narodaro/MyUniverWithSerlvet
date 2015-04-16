<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Subject</title>
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
<h2 class="h2" align="center">Update Subject</h2>
<table align="center">
    <form action="Servlets.WebAppServlet">
        <%
            String sbID = request.getParameter("id");
        %>
        <tr>
            <td>Subject <input type="text" name="subject_name" value=""/></td>
        </tr>
        <tr>
            <td>ID <input type="text" name="id" value="<%= sbID %>" readonly="readonly" size="2"/></td>
        </tr>
        <td><input type="hidden" name="formName" value="updateSubject"/></td>
        <tr>
            <td><input type="submit" value="Edit"/></td>
        </tr>
    </form>
</table>
</body>
</html>