package dao.interfaces;

import dto.SubjectDTO;
import myExceptions.DAOExceptions;

import java.util.List;

public interface ObligationSubject {

    public SubjectDTO create(SubjectDTO Subject) throws DAOExceptions;

    public SubjectDTO read(int key) throws DAOExceptions;

    public void delete(int key) throws DAOExceptions;

    public void update(SubjectDTO Subject, int key) throws DAOExceptions;

    public List<SubjectDTO> readall() throws DAOExceptions;
}
