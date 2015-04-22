package dao;

import dao.interfaces.ObligationStudent;
import dto.StudentDTO;
import myExceptions.DAOExceptions;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO extends DaoObjects implements ObligationStudent {

    private static final String SQL_INSERT = "INSERT INTO STUDENTS(FIRST_NAME,SECOND_NAME) values(?, ?)";
    private static final String SQL_DELETE = "DELETE FROM STUDENTS WHERE ID = ?";
    private static final String SQL_UPDATE = "UPDATE STUDENTS SET FIRST_NAME = ?, SECOND_NAME = ? WHERE ID = ?";
    private static final String SQL_READ = "SELECT * FROM STUDENTS WHERE ID = ?";
    private static final String SQL_READALL = "SELECT * FROM STUDENTS";

    public StudentDTO create(StudentDTO student) throws DAOExceptions {
        try {
            getPSCreate();
            psINSERT.setString(1, student.getFirstName());
            psINSERT.setString(2, student.getSecondName());
            psINSERT.executeUpdate();
        } catch (SQLException e) {
            throw new DAOExceptions("Dao error", e);
        }
        return student;
    }

    public StudentDTO read(int key) throws DAOExceptions {
        StudentDTO student;
        try {
            getPSRead();
            psREAD.setInt(1, key);
            ResultSet res = psREAD.executeQuery();

            student = new StudentDTO();
            while (res.next()) {
                student.setId(res.getInt("id"));
                student.setFirstName(res.getString("First_Name"));
                student.setSecondName(res.getString("Second_Name"));
            }
            res.close();
        } catch (SQLException e) {
            throw new DAOExceptions("Dao error", e);
        }
        return student;
    }

    public void delete(int key) throws DAOExceptions {
        try {
            getPSDelete();
            psDELETE.setInt(1, key);
            psDELETE.executeUpdate();
        } catch (SQLException e) {
            throw new DAOExceptions("Dao error", e);
        }
    }

    public void update(StudentDTO student, int key) throws DAOExceptions {
        try {
            getPSUpdate();
            psUPDATE.setString(1, student.getFirstName());
            psUPDATE.setString(2, student.getSecondName());
            psUPDATE.setInt(3, key);
            psUPDATE.executeUpdate();
        } catch (SQLException e) {
            throw new DAOExceptions("Dao error", e);
        }
    }

    public List<StudentDTO> readall() throws DAOExceptions {
        List<StudentDTO> students = null;
        try {
            getPSReadAll();

            students = new ArrayList<StudentDTO>();
            ResultSet res = psREADALL.executeQuery();

            while (res.next()) {
                StudentDTO student = new StudentDTO();
                student.setId(res.getInt("id"));
                student.setFirstName(res.getString("First_Name"));
                student.setSecondName(res.getString("Second_Name"));
                students.add(student);
            }
            res.close();
        } catch (SQLException e) {
            throw new DAOExceptions("Dao error", e);
        }
        return students;
    }

    private PreparedStatement getPSCreate() throws SQLException {
        if (psINSERT == null) {
            psINSERT = conn.prepareStatement(SQL_INSERT);
        }
        return psINSERT;
    }

    private PreparedStatement getPSRead() throws SQLException {
        if (psREAD == null) {
            psREAD = conn.prepareStatement(SQL_READ);
        }
        return psREAD;
    }

    private PreparedStatement getPSDelete() throws SQLException {
        if (psDELETE == null) {
            psDELETE = conn.prepareStatement(SQL_DELETE);
        }
        return psDELETE;
    }

    private PreparedStatement getPSUpdate() throws SQLException {
        if (psUPDATE == null) {
            psUPDATE = conn.prepareStatement(SQL_UPDATE);
        }
        return psUPDATE;
    }

    private PreparedStatement getPSReadAll() throws SQLException {
        if (psREADALL == null) {
            psREADALL = conn.prepareStatement(SQL_READALL);
        }
        return psREADALL;
    }
}