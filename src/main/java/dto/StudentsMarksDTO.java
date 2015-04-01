package dto;

public class StudentsMarksDTO {

    private int id;
    private int idStudent;
    private int idSubject;
    private int mark;

    public StudentsMarksDTO(){
    }

    public StudentsMarksDTO(int idStudent, int idSubject, int mark){
        this.setIdStudent(idStudent);
        this.setIdSubject(idSubject);
        this.setMark(mark);
    }

    public StudentsMarksDTO(int id, int idStudent, int idSubject, int mark){
        this.setId(id);
        this.setIdStudent(idStudent);
        this.setIdSubject(idSubject);
        this.setMark(mark);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public int getIdSubject() {
        return idSubject;
    }

    public void setIdSubject(int idSubject) {
        this.idSubject = idSubject;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }
}
