
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
import javax.servlet.http.HttpSession;
import java.io.IOException;

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

        String inputParameter = request.getParameter("formName");

        if (inputParameter == null || inputParameter.equals("")) {
            response.sendRedirect("/");
            return;
        }

        switch (inputParameter) {
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
                    response.sendRedirect("ErrorMessage.html");
                    daoExceptions.printStackTrace();
                }
                response.sendRedirect("Students.jsp");
                break;

            case "updateStudent":
                String studIDEdit = request.getParameter("ID");
                studentDTO.setFirstName(request.getParameter("firstName"));
                studentDTO.setSecondName(request.getParameter("secondName"));
                response.sendRedirect("Students.jsp");
                try {
                    studentDAO.update(studentDTO, Integer.parseInt(studIDEdit));
                } catch (DAOExceptions daoExceptions) {
                    response.sendRedirect("ErrorMessage.html");
                    daoExceptions.printStackTrace();
                }
                break;

            case "deleteStudent":
                String studIDDel = request.getParameter("ID");
                try {
                    studentDAO.delete(Integer.parseInt(studIDDel));
                } catch (DAOExceptions daoExceptions) {
                    response.sendRedirect("ErrorMessage.html");
                    daoExceptions.printStackTrace();
                }
                response.sendRedirect("Students.jsp");
                break;

            case "addSubject":
                subjectDTO.setSubject_name(request.getParameter("Subject"));
                try {
                    subjectDAO.create(subjectDTO);
                } catch (DAOExceptions daoExceptions) {
                    response.sendRedirect("ErrorMessage.html");
                    daoExceptions.printStackTrace();
                }
                response.sendRedirect("Subjects.jsp");
                break;

            case "updateSubject":
                String sbIDEdit = request.getParameter("id");
                subjectDTO.setSubject_name(request.getParameter("subject_name"));
                try {
                    subjectDAO.update(subjectDTO, Integer.parseInt(sbIDEdit));
                } catch (DAOExceptions daoExceptions) {
                    response.sendRedirect("ErrorMessage.html");
                    daoExceptions.printStackTrace();
                }
                response.sendRedirect("Subjects.jsp");
                break;

            case "deleteSubject":
                String sbjIDDel = request.getParameter("id");
                try {
                    subjectDAO.delete(Integer.parseInt(sbjIDDel));
                    response.sendRedirect("Subjects.jsp");
                } catch (DAOExceptions daoExceptions) {
                    response.sendRedirect("ErrorMessage.html");
                    daoExceptions.printStackTrace();
                }
                break;

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
                    response.sendRedirect("ErrorMessage.html");
                    daoExceptions.printStackTrace();
                }
                response.sendRedirect("Marks.jsp");
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
                    response.sendRedirect("Marks.jsp");
                } catch (DAOExceptions daoExceptions) {
                    response.sendRedirect("ErrorMessage.html");
                    daoExceptions.printStackTrace();
                }
                break;

            case "deleteMark":
                String delIdMark = request.getParameter("id");
                try {
                    studentsMarksDAO.delete(Integer.parseInt(delIdMark));
                    response.sendRedirect("Marks.jsp");
                } catch (DAOExceptions daoExceptions) {
                    response.sendRedirect("ErrorMessage.html");
                    daoExceptions.printStackTrace();
                }
                break;
        }
        daoObjects.psClose();
        dbConnection.closeConnection();
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