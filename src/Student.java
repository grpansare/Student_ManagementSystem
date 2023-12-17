

import java.io.Serializable;

public class Student implements Serializable {
    private int rollNo;
    private String firstName;
    private String lastName;
    private String grade = "Not Recorded";

    public Student() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Student(int rollNo, String firstName, String lastName, String grade) {
        super();
        this.rollNo = rollNo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
    }

    public Student(int rollNumber, String firstName, String lastName) {
        this.rollNo = rollNumber;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student [rollNo=" + rollNo + ", Full Name=" + firstName + " " + lastName + ", grade=" + grade
                + "]";
    }

}
