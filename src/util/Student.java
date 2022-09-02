package util;

public class Student {

    public Student(String firstName, String lastName, int pid, int grade) { // this is a student constructor which we use in the main class to create an instance of a student
        this.firstName = firstName;
        this.lastName = lastName;
        this.pid = pid;
        this.grade = new Grade(grade);
    }

    private String firstName;
    private String lastName;
    private int pid;
    private Grade grade;
    public String getFirstName() { // returns the string firstName
        return firstName;
    }
    public String getLastName() { // returns the string lastName
        return lastName;
    }
    public int getPid() { // returns the int pid
        return pid;
    }
    public Grade getGrade() { // returns the grade
        return grade;
    }

    public void setGrade(int newGrade){ // this changes the grade by using the setScore method in the grade class
        grade.setScore(newGrade);
    }

}
