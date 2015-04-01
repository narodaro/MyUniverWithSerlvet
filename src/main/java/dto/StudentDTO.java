package dto;

public class StudentDTO{

    private int id;
    private String firstName;
    private String secondName;

    public StudentDTO(){
    }

    public StudentDTO(String firstName, String secondName){
        this.setFirstName(firstName);
        this.setSecondName(secondName);
    }

    public StudentDTO(int id, String firstName, String secondName){
        this.setId(id);
        this.setFirstName(firstName);
        this.setSecondName(secondName);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }
}
