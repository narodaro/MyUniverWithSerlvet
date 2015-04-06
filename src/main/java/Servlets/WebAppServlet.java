
package Servlets;

import dao.DaoObjects;
import dao.StudentDAO;
import dao.StudentsMarksDAO;
import dao.SubjectDAO;
import dbConnection.DBConnection;
import dto.StudentDTO;
import dto.StudentsMarksDTO;
import dto.SubjectDTO;
import myExceptions.DAOExceptions;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class WebAppServlet extends HttpServlet {

    private static StudentDAO studentDAO = new StudentDAO();
    private static StudentDTO studentDTO = new StudentDTO();
    private static SubjectDAO subjectDAO = new SubjectDAO();
    private static SubjectDTO subjectDTO = new SubjectDTO();
    private static StudentsMarksDAO studentsMarksDAO = new StudentsMarksDAO();
    private static StudentsMarksDTO studentsMarksDTO = new StudentsMarksDTO();

    private static DaoObjects daoObjects = new DaoObjects();
    private static DBConnection dbConnection = new DBConnection();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");
        PrintWriter pw = response.getWriter();

        String inputParameter = request.getParameter("formName");

        if (inputParameter == null || inputParameter.equals("")) {
            response.sendRedirect("/");
            return;
        }

        switch (inputParameter) {
            case "Students":
                showAllStudents(studentDAO, pw);
                break;

            case "Subjects":
                showAllSubjects(subjectDAO, pw);
                break;

            case "Marks":
                showAllMarks(studentsMarksDAO, pw);
                break;

            case "BackToStudents":
                response.sendRedirect("Servlets.WebAppServlet?Students=Students&formName=Students");
                break;

            case "BackToSubjects":
                response.sendRedirect("Servlets.WebAppServlet?Subjects=Subjects&formName=Subjects");
                break;

            case "BackToMarks":
                response.sendRedirect("Servlets.WebAppServlet?Marks=Show+all+marks&formName=Marks");
                break;

//            case "AllMarksOneStudent":
//                String results = request.getParameter("ID");
//                Map<StudentDTO,Map<SubjectDTO,StudentsMarksDTO>> allmarks = null;
//                try {
//                    allmarks = mark.read(studentDTO.getId());
//                } catch (DAOExceptions daoExceptions) {
//                    daoExceptions.printStackTrace();
//                }
//                showAllTheMarksOfOneStudent(allmarks, pw);
//                break;

            case "addStudent":
                studentDTO.setFirstName(request.getParameter("FirstName"));
                studentDTO.setSecondName(request.getParameter("SecondName"));
                try {
                    studentDAO.create(studentDTO);
                } catch (DAOExceptions daoExceptions) {
                    MessegeStudents(pw);
                    daoExceptions.printStackTrace();
                }
                response.sendRedirect("Servlets.WebAppServlet?Students=Students&formName=Students");
                break;

            case "updateStudent":
                String studIDEdit = request.getParameter("ID");
                studentDTO.setFirstName(request.getParameter("firstName"));
                studentDTO.setSecondName(request.getParameter("secondName"));
                response.sendRedirect("Servlets.WebAppServlet?Students=Students&formName=Students");
                try {
                    studentDAO.update(studentDTO, Integer.parseInt(studIDEdit));
                } catch (DAOExceptions daoExceptions) {
                    MessegeStudents(pw);
                    daoExceptions.printStackTrace();
                }
                break;

            case "confirmUpdateStudent":
                String stID = request.getParameter("id");
                pw.print("<h2>Update Student</h2>");
                pw.print("<form action=\"Servlets.WebAppServlet\">");
                pw.print("ID <input type=\"text\" name=\"ID\" value=\"" + stID + "\" readonly=\"readonly\"><br>");
                pw.print("First Name <input type=\"text\" name=\"firstName\" value=\"\"><br>");
                pw.print("Last Name <input type=\"text\" name=\"secondName\" value=\"\"><br>");
                pw.print("<input type=\"hidden\" name=\"formName\" value=\"updateStudent\">");
                pw.print("<input type=\"submit\" value=\"Edit\">");
                pw.print("</form>");
                break;

            case "deleteStudent":
                String studIDDel = request.getParameter("ID");
                try {
                    studentDAO.delete(Integer.parseInt(studIDDel));
                } catch (DAOExceptions daoExceptions) {
                    MessegeStudents(pw);
                    daoExceptions.printStackTrace();
                }
                response.sendRedirect("Servlets.WebAppServlet?Students=Students&formName=Students");
                break;

            case "confirmDelStudent":
                String studID = request.getParameter("id");
                pw.print("<h2>You sure? </h2>");
                pw.print("<form action=\"Servlets.WebAppServlet\">");
                pw.print("ID <input type=\"text\" name=\"ID\" value=\"" + studID + "\" readonly=\"readonly\"><br>");
                pw.print("<input type=\"hidden\" name=\"formName\" value=\"deleteStudent\">");
                try {
                    pw.print("<input type=\"submit\" value=\"Delete " + studentDAO.read(Integer.parseInt(studID)).getFirstName()
                            + " " + studentDAO.read(Integer.parseInt(studID)).getSecondName() + "\">");
                } catch (DAOExceptions daoExceptions) {
                    MessegeStudents(pw);
                    daoExceptions.printStackTrace();
                }
                pw.print("</form>");
                break;

            case "showAllStudents":
                showAllStudents(studentDAO, pw);
                break;

            case "addSubject":
                subjectDTO.setSubject_name(request.getParameter("Subject"));
                try {
                    subjectDAO.create(subjectDTO);
                } catch (DAOExceptions daoExceptions) {
                    MessageSubjects(pw);
                    daoExceptions.printStackTrace();
                }
                response.sendRedirect("Servlets.WebAppServlet?Subjects=Subjects&formName=Subjects");
                break;

            case "updateSubject":
                String sbIDEdit = request.getParameter("id");
                subjectDTO.setSubject_name(request.getParameter("subject_name"));
                try {
                    subjectDAO.update(subjectDTO, Integer.parseInt(sbIDEdit));
                } catch (DAOExceptions daoExceptions) {
                    MessageSubjects(pw);
                    daoExceptions.printStackTrace();
                }
                response.sendRedirect("Servlets.WebAppServlet?Subjects=Subjects&formName=Subjects");
                break;

            case "confirmUpdateSubject":
                String sbID = request.getParameter("id");
                pw.print("<h2>Update Subject</h2>");
                pw.print("<form action=\"Servlets.WebAppServlet\">");
                pw.print("ID <input type=\"text\" name=\"id\" value=\"" + sbID + "\" readonly=\"readonly\"><br>");
                pw.print("Subject <input type=\"text\" name=\"subject_name\" value=\"\"><br>");
                pw.print("<input type=\"hidden\" name=\"formName\" value=\"updateSubject\">");
                pw.print("<input type=\"submit\" value=\"Edit\">");
                pw.print("</form>");
                break;

            case "deleteSubject":
                String sbjIDDel = request.getParameter("ID");
                try {
                    subjectDAO.delete(Integer.parseInt(sbjIDDel));
                    response.sendRedirect("Servlets.WebAppServlet?Subjects=Subjects&formName=Subjects");
                } catch (DAOExceptions daoExceptions) {
                    MessageSubjects(pw);
                    daoExceptions.printStackTrace();
                }
                break;

            case "confirmDelSubject":
                String sbjID = request.getParameter("id");
                pw.print("<h2>You sure? </h2>");
                pw.print("<form action=\"Servlets.WebAppServlet\">");
                pw.print("ID <input type=\"text\" name=\"ID\" value=\"" + sbjID + "\" readonly=\"readonly\"><br>");
                pw.print("<input type=\"hidden\" name=\"formName\" value=\"deleteSubject\">");
                try {
                    pw.print("<input type=\"submit\" value=\"Delete " + subjectDAO.read(Integer.parseInt(sbjID)).getSubject_name() + "\">");
                } catch (DAOExceptions daoExceptions) {
                    MessageSubjects(pw);
                    daoExceptions.printStackTrace();
                }
                pw.print("</form>");
                break;

            case "showAllSubjects":
                showAllStudents(studentDAO, pw);
                break;

//            case "addStudent":
//                studentDTO.setFirstName(request.getParameter("FirstName"));
//                studentDTO.setSecondName(request.getParameter("SecondName"));
//                try {
//                    studentDAO.create(studentDTO);
//                } catch (DAOExceptions daoExceptions) {
//                    daoExceptions.printStackTrace();
//                }
//                response.sendRedirect("Servlets.WebAppServlet?Students=Students&formName=Students");
//                break;

            case "addMark":
                String idStudent = request.getParameter("id_student");
                String idSubject = request.getParameter("id_subject");
                String mark = request.getParameter("mark");
                studentsMarksDTO.setIdStudent(Integer.parseInt(idStudent));
                studentsMarksDTO.setIdSubject(Integer.parseInt(idSubject));
                studentsMarksDTO.setMark(Integer.parseInt(mark));
                try {
                    studentsMarksDAO.create(studentsMarksDTO);
                } catch (DAOExceptions daoExceptions) {
                    MessageMarks(pw);
                    daoExceptions.printStackTrace();
                }
                response.sendRedirect("Servlets.WebAppServlet?Marks=Show+all+marks&formName=Marks");
                break;

            case "updateMark":
                String idSt = request.getParameter("id_student");
                String idSub = request.getParameter("id_subject");
                String upMark = request.getParameter("Mark");
                studentsMarksDTO.setIdStudent(Integer.parseInt(idSt));
                studentsMarksDTO.setIdSubject(Integer.parseInt(idSub));
                studentsMarksDTO.setMark(Integer.parseInt(upMark));
                try {
                    studentsMarksDAO.update(studentsMarksDTO);
                    response.sendRedirect("Servlets.WebAppServlet?Marks=Show+all+marks&formName=Marks");
                } catch (DAOExceptions daoExceptions) {
                    MessageMarks(pw);
                    daoExceptions.printStackTrace();
                }
                break;

            case "confirmUpdateMark":
                String idStud = request.getParameter("id_student");
                String idSubj = request.getParameter("id_subject");
                pw.print("<h2>Update Mark</h2>");
                pw.println("<form action=\"Servlets.WebAppServlet\">");
                pw.println("ID_Student <input type=\"text\" name=\"id_student\" value=\"" + idStud + "\" readonly=\"readonly\"><br>");
                pw.println("ID_Subject <input type=\"text\" name=\"id_subject\" value=\"" + idSubj + "\" readonly=\"readonly\"><br>");
                pw.println("Mark <input type=\"text\" name=\"Mark\" value=\"\"><br>");
                pw.println("<input type=\"hidden\" name=\"formName\" value=\"updateMark\">");
                pw.println("<input type=\"submit\" value=\"Edit\"><br>");
                pw.println("</form>");
                break;

            case "deleteMark":
                String delIdMark = request.getParameter("id");
                try {
                    studentsMarksDAO.delete(Integer.parseInt(delIdMark));
                    response.sendRedirect("Servlets.WebAppServlet?Marks=Show+all+marks&formName=Marks");
                } catch (DAOExceptions daoExceptions) {
                    MessageMarks(pw);
                    daoExceptions.printStackTrace();
                }
                break;

            case "confirmDeleteMark":
                String delIDmark = request.getParameter("id");
                pw.print("<h2>You sure? </h2>");
                pw.print("<form action=\"Servlets.WebAppServlet\">");
                pw.print("ID <input type=\"text\" name=\"id\" value=\"" + delIDmark + "\" readonly=\"readonly\"><br>");
                pw.print("<input type=\"hidden\" name=\"formName\" value=\"deleteMark\">");
                pw.print("<input type=\"submit\" value=\"Delete\">");
                pw.print("</form>");
                break;

        }
        daoObjects.psClose();
        dbConnection.closeConnection();
    }

    private void MessageMarks(PrintWriter pw) {
        pw.println("<form action=\"Servlets.WebAppServlet\">");
        pw.println("<h2 style=\"color:red;\">Error</h2>");
        pw.println("<input type=\"submit\" value=\"Back\"><br>");
        pw.println("<input type=\"hidden\" name=\"formName\" value=\"BackToMarks\">");
        pw.println("</form>");
    }

    private void MessageSubjects(PrintWriter pw) {
        pw.println("<form action=\"Servlets.WebAppServlet\">");
        pw.println("<h2 style=\"color:red;\">Error</h2>");
        pw.println("<input type=\"submit\" value=\"Back\"><br>");
        pw.println("<input type=\"hidden\" name=\"formName\" value=\"BackToSubjects\">");
        pw.println("</form>");
    }

    private void MessegeStudents(PrintWriter pw) {
        pw.println("<form action=\"Servlets.WebAppServlet\">");
        pw.println("<h2 style=\"color:red;\">Error</h2>");
        pw.println("<input type=\"submit\" value=\"Back\"><br>");
        pw.println("<input type=\"hidden\" name=\"formName\" value=\"BackToStudents\">");
        pw.println("</form>");
    }

    private void showAllStudents(StudentDAO student, PrintWriter pw) throws ServletException {
        pw.println("<h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;List of students</h3>");
        pw.println("<table border width=30%>");
        try {
            List<StudentDTO> l = student.readall();
            pw.print("<th></th>");
            pw.print("<th></th>");
            pw.print("<th>ID</th>");
            pw.print("<th>First Name</th>");
            pw.print("<th>Second Name</th>");
            for (StudentDTO st : l) {
                pw.println("<tr>");
                pw.println("<td><a href=\"Servlets.WebAppServlet?formName=confirmUpdateStudent&id=" + st.getId() + "\">Edit</a></td>");
                pw.println("<td><a href=\"Servlets.WebAppServlet?formName=confirmDelStudent&id=" + st.getId() + "\">Delete</a></td>");
                pw.println("<td>" + st.getId() + "</td>");
                pw.println("<td>" + st.getFirstName() + "</td>");
                pw.println("<td>" + st.getSecondName() + "</td>");
                pw.println("</tr>");
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
        pw.println("</table><br>");
        pw.println("<form action=\"Servlets.WebAppServlet\">");
        pw.println("First Name <input type=\"text\" name=\"FirstName\" value=\"\"><br>");
        pw.println("Last Name <input type=\"text\" name=\"SecondName\" value=\"\"><br>");
        pw.println("<input type=\"hidden\" name=\"formName\" value=\"addStudent\">");
        pw.println("<input type=\"submit\" value=\"Add new student\"><br>");
        pw.println("</form><p>");
        pw.println("<form action=\"http://localhost:8080/University.html\">");
        pw.println("<input type=\"submit\" value=\"Back to main\"><br>");
        pw.println("</form><p>");
    }

    private void showAllSubjects(SubjectDAO subject, PrintWriter pw) throws ServletException {
        pw.println("<h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;List of subjects</h3>");
        pw.println("<table border width=25%>");
        try {
            List<SubjectDTO> l = subject.readall();
            pw.print("<th></th>");
            pw.print("<th></th>");
            pw.print("<th>ID</th>");
            pw.print("<th>Subject</th>");
            for (SubjectDTO sb : l) {
                pw.println("<tr>");
                pw.println("<td><a href=\"Servlets.WebAppServlet?formName=confirmUpdateSubject&id=" + sb.getId() + "\">Edit</a></td>");
                pw.println("<td><a href=\"Servlets.WebAppServlet?formName=confirmDelSubject&id=" + sb.getId() + "\">Delete</a></td>");
                pw.println("<td>" + sb.getId() + "</td>");
                pw.println("<td>" + sb.getSubject_name() + "</td>");
                pw.println("</tr>");
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
        pw.println("</table><br>");
        pw.println("<form action=\"Servlets.WebAppServlet\">");
        pw.println("Subject <input type=\"text\" name=\"Subject\" value=\"\"><br>");
        pw.println("<input type=\"submit\" value=\"Add new subject\"><br>");
        pw.println("<input type=\"hidden\" name=\"formName\" value=\"addSubject\">");
        pw.println("</form>");
        pw.println("<form action=\"http://localhost:8080/University.html\">");
        pw.println("<input type=\"submit\" value=\"Back to main\"><br>");
        pw.println("</form><p>");
    }

    private void showAllMarks(StudentsMarksDAO marks, PrintWriter pw) throws ServletException {
        pw.println("<h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;List of Marks</h3>");
        pw.println("<table border width=25%>");
        try {
            List<StudentsMarksDTO> l = marks.readall();
            pw.print("<th></th>");
            pw.print("<th></th>");
            pw.print("<th>ID</th>");
            pw.print("<th>ID_Student</th>");
            pw.print("<th>ID_Subject</th>");
            pw.print("<th>Mark</th>");
            for (StudentsMarksDTO allMarks : l) {
                pw.println("<tr>");
                pw.println("<td><a href=\"Servlets.WebAppServlet?formName=confirmUpdateMark&id_student="
                        + allMarks.getIdStudent() + "&id_subject=" + allMarks.getIdSubject() + "\">Edit</a></td>");
                pw.println("<td><a href=\"Servlets.WebAppServlet?formName=confirmDeleteMark&id=" + allMarks.getId() + "\">Delete</a></td>");
                pw.println("<td>" + allMarks.getId() + "</td>");
                pw.println("<td>" + allMarks.getIdStudent() + "</td>");
                pw.println("<td>" + allMarks.getIdSubject() + "</td>");
                pw.println("<td>" + allMarks.getMark() + "</td>");
                pw.println("</tr>");
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
        pw.println("</table><br>");
        pw.println("<form action=\"Servlets.WebAppServlet\">");
        pw.println("ID Student <input type=\"text\" name=\"id_student\" value=\"\"><br>");
        pw.println("ID Subject <input type=\"text\" name=\"id_subject\" value=\"\"><br>");
        pw.println("Mark <input type=\"text\" name=\"mark\" value=\"\"><br>");
        pw.println("<input type=\"hidden\" name=\"formName\" value=\"addMark\">");
        pw.println("<input type=\"submit\" value=\"Add new mark\"><br>");
        pw.println("</form>");
        pw.println("<form action=\"http://localhost:8080/University.html\">");
        pw.println("<input type=\"submit\" value=\"Back to main\"><br>");
        pw.println("</form><p>");
        pw.println("</table>");
    }

//    private void showAllTheMarksOfOneStudent(Map<StudentDTO,Map<SubjectDTO,StudentsMarksDTO>> allmarks, PrintWriter pw) throws ServletException {
//        pw.println("<h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Results of student</h3>");
//        pw.println("<table border width=25%>");
//
//        for (Map.Entry<StudentDTO, Map<SubjectDTO, StudentsMarksDTO>> allst : allmarks.entrySet()) {
//            pw.print("<th>Second Name</th>");
//            pw.print("<th>First Name</th>");
//            pw.print("<th>Subject</th>");
//            pw.print("<th>Mark</th>");
//            StudentDTO student = allst.getKey();
//            pw.print("<th>" + student.getFirstName() + "</th>");
//            pw.print("<th>" + student.getSecondName() + "</th>");
//            Map<SubjectDTO, StudentsMarksDTO> subsMarks = allst.getValue();
//            for (Map.Entry<SubjectDTO, StudentsMarksDTO> all : subsMarks.entrySet()) {
//                SubjectDTO subj = all.getKey();
//                StudentsMarksDTO marks = all.getValue();
//                pw.print("<th>" + subj.getSubject_name() + "</th>");
//                pw.print("<th>" + marks.getMark() + "</th>");
//                pw.println("</table>");
//            }
//        }
//    }

}