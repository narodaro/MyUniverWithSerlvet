<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Mark</title>
    <style type="text/css">
        h1 {
            color: #003e80
        }

        h2 {
            color: green;
        }

        .sure {
            color: red;
        }

        body {
            background-color: #FFEE8C
        }
    </style>
</head>
<body>
<h1 class="h1" align="center">My University</h1>
<hr>
<h2 class="h2" align="center">Delete Student</h2>

<h2 class="sure" align="center">You sure?</h2>
<table align="center">
    <form action="Servlets.WebAppServlet">
        <%
            String sbjID = request.getParameter("id");
        %>
        <tr>
            <td>ID <input type="text" name="id" value="<%= sbjID %>" + readonly="readonly" size="2"/></td>
        </tr>
        <tr>
            <td><input type="hidden" name="formName" value="deleteMark"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Delete"/>
    </form>
</body>
</table>
</html>
