package dao.interfaces;

import dto.StudentDTO;
import myExceptions.DAOExceptions;

import java.util.List;

public interface ObligationStudent {

    public StudentDTO create(StudentDTO student) throws DAOExceptions;

    public StudentDTO read(int key) throws DAOExceptions;

    public void delete(int key) throws DAOExceptions;

    public void update(StudentDTO student, int key) throws DAOExceptions;

    public List<StudentDTO> readall() throws DAOExceptions;
}