package dao.interfaces;

import dto.StudentDTO;
import dto.StudentsMarksDTO;
import dto.SubjectDTO;
import myExceptions.DAOExceptions;

import java.util.List;
import java.util.Map;

public interface ObligationStudentsMark {

    public StudentsMarksDTO create(StudentsMarksDTO mark) throws DAOExceptions;

    public Map<StudentDTO, Map<SubjectDTO, StudentsMarksDTO>> read(int key) throws DAOExceptions;

    public void delete(int key) throws DAOExceptions;

    public void update(StudentsMarksDTO mark) throws DAOExceptions;

    public List<StudentsMarksDTO> readall() throws DAOExceptions;

}
