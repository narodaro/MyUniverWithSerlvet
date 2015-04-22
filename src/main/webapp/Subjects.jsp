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

        .myButton {
            -moz-box-shadow: 0px 1px 5px 1px #9fb4f2;
            -webkit-box-shadow: 0px 1px 5px 1px #9fb4f2;
            box-shadow: 0px 1px 5px 1px #9fb4f2;
            background:-webkit-gradient(linear, left top, left bottom, color-stop(0.05, #7892c2), color-stop(1, #476e9e));
            background:-moz-linear-gradient(top, #7892c2 5%, #476e9e 100%);
            background:-webkit-linear-gradient(top, #7892c2 5%, #476e9e 100%);
            background:-o-linear-gradient(top, #7892c2 5%, #476e9e 100%);
            background:-ms-linear-gradient(top, #7892c2 5%, #476e9e 100%);
            background:linear-gradient(to bottom, #7892c2 5%, #476e9e 100%);
            filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#7892c2', endColorstr='#476e9e',GradientType=0);
            background-color:#7892c2;
            -moz-border-radius:14px;
            -webkit-border-radius:14px;
            border-radius:14px;
            border:2px solid #4e6096;
            display:inline-block;
            cursor:pointer;
            color:#ffffff;
            font-family:Trebuchet MS;
            font-size:17px;
            font-weight:bold;
            padding:8px 16px;
            text-decoration:none;
            text-shadow:0px 0px 0px #283966;
        }
        .myButton:hover {
            background:-webkit-gradient(linear, left top, left bottom, color-stop(0.05, #476e9e), color-stop(1, #7892c2));
            background:-moz-linear-gradient(top, #476e9e 5%, #7892c2 100%);
            background:-webkit-linear-gradient(top, #476e9e 5%, #7892c2 100%);
            background:-o-linear-gradient(top, #476e9e 5%, #7892c2 100%);
            background:-ms-linear-gradient(top, #476e9e 5%, #7892c2 100%);
            background:linear-gradient(to bottom, #476e9e 5%, #7892c2 100%);
            filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#476e9e', endColorstr='#7892c2',GradientType=0);
            background-color:#476e9e;
        }
        .myButton:active {
            position:relative;
            top:1px;
        }

        .add {
            -moz-box-shadow: 3px 4px 0px 0px #899599;
            -webkit-box-shadow: 3px 4px 0px 0px #899599;
            box-shadow: 3px 4px 0px 0px #899599;
            background:-webkit-gradient(linear, left top, left bottom, color-stop(0.05, #ededed), color-stop(1, #69e650));
            background:-moz-linear-gradient(top, #ededed 5%, #69e650 100%);
            background:-webkit-linear-gradient(top, #ededed 5%, #69e650 100%);
            background:-o-linear-gradient(top, #ededed 5%, #69e650 100%);
            background:-ms-linear-gradient(top, #ededed 5%, #69e650 100%);
            background:linear-gradient(to bottom, #ededed 5%, #69e650 100%);
            filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#ededed', endColorstr='#69e650',GradientType=0);
            background-color:#ededed;
            -moz-border-radius:15px;
            -webkit-border-radius:15px;
            border-radius:15px;
            border:1px solid #d6bcd6;
            display:inline-block;
            cursor:pointer;
            color:#3a8a9e;
            font-family:Trebuchet MS;
            font-size:17px;
            font-weight:bold;
            padding:0px 25px;
            text-decoration:none;
            text-shadow:0px 1px 0px #e1e2ed;
        }
        .add:hover {
            background:-webkit-gradient(linear, left top, left bottom, color-stop(0.05, #69e650), color-stop(1, #ededed));
            background:-moz-linear-gradient(top, #69e650 5%, #ededed 100%);
            background:-webkit-linear-gradient(top, #69e650 5%, #ededed 100%);
            background:-o-linear-gradient(top, #69e650 5%, #ededed 100%);
            background:-ms-linear-gradient(top, #69e650 5%, #ededed 100%);
            background:linear-gradient(to bottom, #69e650 5%, #ededed 100%);
            filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#69e650', endColorstr='#ededed',GradientType=0);
            background-color:#69e650;
        }
        .add:active {
            position:relative;
            top:1px;
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
            <td><input class='add' type="submit" value="Add new subject"></td>
        </tr>
        <td><input type="hidden" name="formName" value="addSubject"></td>
    </form>
</table>
<form action="University.html">
    <br><br><br>

    <h2 align="center"><input class='myButton' type="submit" value="Back to main"></h2>
</form>
</body>
</html>
