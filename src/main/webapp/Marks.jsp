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
            <td><input class='add' type="submit" value="Add new mark"></td>
        </tr>
    </form>
</table>
<form action="University.html">
    <br><br><br>

    <h2 align="center"><input class='myButton' type="submit" value="Back to main"></h2>
</form>
</body>
</html>
