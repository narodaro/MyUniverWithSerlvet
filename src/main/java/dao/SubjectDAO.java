package dao;

import dto.SubjectDTO;
import dao.interfaces.ObligationSubject;
import myExceptions.DAOExceptions;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SubjectDAO extends DaoObjects implements ObligationSubject {

    private static final String SQL_INSERT = "INSERT INTO SUBJECTS(SUBJECT_NAME) values(?)";
    private static final String SQL_DELETE = "DELETE FROM SUBJECTS WHERE ID = ?";
    private static final String SQL_UPDATE = "UPDATE SUBJECTS SET SUBJECT_NAME = ? WHERE ID = ?";
    private static final String SQL_READ = "SELECT * FROM SUBJECTS WHERE ID = ?";
    private static final String SQL_READALL = "SELECT * FROM SUBJECTS";

    public SubjectDTO create(SubjectDTO Subject) throws DAOExceptions {
        try {
            if (psINSERT == null) {
                psINSERT = conn.prepareStatement(SQL_INSERT);
            }
            psINSERT.setString(1, Subject.getSubject_name());
            psINSERT.executeUpdate();
        } catch (SQLException e) {
            throw new DAOExceptions("Dao error", e);
        }
        return Subject;
    }

    public SubjectDTO read(int key) throws DAOExceptions {
        ResultSet res;
        SubjectDTO subject;
        try {
            if (psREAD == null) {
                psREAD = conn.prepareStatement(SQL_READ);
            }
            psREAD.setInt(1, key);
            res = psREAD.executeQuery();

            subject = new SubjectDTO();
            while (res.next()) {
                subject.setId(res.getInt("id"));
                subject.setSubject_name(res.getString("Subject_Name"));
            }
            res.close();
        } catch (SQLException e) {
            throw new DAOExceptions("Dao error", e);
        }
        return subject;
    }

    public void delete(int key) throws DAOExceptions {
        try {
            if (psDELETE == null) {
                psDELETE = conn.prepareStatement(SQL_DELETE);
            }
            psDELETE.setInt(1, key);
            psDELETE.executeUpdate();
        } catch (SQLException e) {
            throw new DAOExceptions("Dao error", e);
        }
    }

    public void update(SubjectDTO Subject, int key) throws DAOExceptions {
        try {
            if (psUPDATE == null) {
                psUPDATE = conn.prepareStatement(SQL_UPDATE);
            }
            psUPDATE.setString(1, Subject.getSubject_name());
            psUPDATE.setInt(2, key);
            psUPDATE.executeUpdate();
        } catch (SQLException e) {
            throw new DAOExceptions("Dao error", e);
        }
    }

    @Override
    public List<SubjectDTO> readall() throws DAOExceptions {
        List<SubjectDTO> subjects;
        try {
            if (psREADALL == null) {
                psREADALL = conn.prepareStatement(SQL_READALL);
            }

            subjects = new ArrayList<>();
            ResultSet res = psREADALL.executeQuery();

            while (res.next()) {
                SubjectDTO subject = new SubjectDTO();
                subject.setId(res.getInt("id"));
                subject.setSubject_name(res.getString("Subject_name"));
                subjects.add(subject);
            }
            res.close();
        } catch (SQLException e) {
            throw new DAOExceptions("Dao error", e);
        }
        return subjects;
    }
}
