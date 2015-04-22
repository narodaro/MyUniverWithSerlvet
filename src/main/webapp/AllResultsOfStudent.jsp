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
            <td><input type="hidden" name="formName" value="AllMarksOneStudent">
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

    <h2 align="center"><input class='myButton' type="submit" value="Back to main"></h2>
</form>
</body>
</html>