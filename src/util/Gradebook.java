package util;

import java.util.ArrayList;
import java.util.Arrays;

public class Gradebook {

    private ArrayList<Student> listOfStudents;

    public Gradebook() {                    // this is a constructor for a gradebook, which we use in the main class to create an instance of a Gradebook
        this.listOfStudents = new ArrayList<Student>();
    }

    public void addStudent(Student student){ // this adds a student instance into the arraylist of student
        listOfStudents.add(student);
    }

    public int minScore(){ // this returns the value of the minimum score in the gradebook
        Student minScoreStudent = null; // we first initialize a student instance called minScoreStudent
        int minScore = 0;               // we also initialize an int which we will return at the end of this method
        for(Student min: listOfStudents){   // this enhanced for loop will go through every student in the arraylist listOfStudents
            if(minScoreStudent == null){    // if our student instance is still null we will make it equal to a student that is stored in the arraylist
                minScoreStudent = min;
                minScore = min.getGrade().getScore(); // this initializes minScore to a score value from the arrayList
            }
            if(minScoreStudent != null && minScoreStudent.getGrade().getScore() > min.getGrade().getScore()){ // this gets us the minimum score
                minScore = min.getGrade().getScore();   // if our current student instance is greater than the next student in the arraylist we set our student instance to min since it's score is less than our current one
            }
        }
        return minScore;
    }

    public int maxScore(){ // this is similar to minScore but instead we find the maximum score of the gradebook
        Student maxScoreStudent = null;
        int maxScore = 0;
        for(Student max: listOfStudents){
            if(maxScoreStudent == null){
                maxScoreStudent = max;
                maxScore = max.getGrade().getScore();
            }
            if(maxScoreStudent != null && maxScoreStudent.getGrade().getScore() < max.getGrade().getScore()){ // if our current maxScoreStudent is less than the student instance we are going through we will set it equal to that student instance
                maxScore = max.getGrade().getScore();   // we set our maxScore into the score value of the student instance we are parsing through
            }
        }
        return maxScore;
    }

    public void letterScore(int PID){ // this finds the user's PID input and prints out the letter grade of the student
        for(Student s : listOfStudents){
            if(PID == s.getPid()){ // this makes sure that the user's PID is equal to the student since we are parsing through every student in the arraylist list of students
                System.out.println(s.getGrade().getLetterGrade());
            }
        }
    }

    public void nameSearch(int PID){ // this method finds the user's PID input and prints out the name of the student from the gradebook
        for(Student s : listOfStudents){ // enhanced for loop which goes through every single student
            if(PID == s.getPid()){
                System.out.println(s.getFirstName() + " " + s.getLastName()); // prints out firstname and lastname of the student that has the same PID as the user's input
            }
        }
    }

    public void changeGrade(int PID, int newGrade){ // this changes the grade of the student according to the user's PID input and int newGrade
        for(Student s : listOfStudents){  // similar to our previous methods using an enhanced for loop to go through every student
            if(PID == s.getPid()){
                s.setGrade(newGrade); // we use the method setGrade from the student class in order to change the grade of the student the user is looking for according to the int grade input
            }
        }
    }

    public double calculateAvg() { // this calculates the average score
        double sum = 0;
        for(Student s: listOfStudents)
            sum += s.getGrade().getScore();
        return sum / listOfStudents.size();
    }
    public float calculateMedian() { // this calculates the median score
        int i = 0, n = listOfStudents.size();
        int[] scores = new int[n];
        for(Student s: listOfStudents)
            scores[i++] = s.getGrade().getScore();
        Arrays.sort(scores);
        if (n % 2 == 0)
            return (scores[n / 2] + scores[n / 2 - 1]) / 2.0f;
        else
            return scores[n / 2];
    }
    public void printAllStudents() { // this method prints out every student by using an enhanced for loop to go through every student and print out its variables
        for(Student s: listOfStudents)
            System.out.printf("%s\t\t%s\t\t%d\t\t%d\n", s.getFirstName(), s.getLastName(), s.getPid(), s.getGrade().getScore());
    }

    public void printAllLetters() { // this method performs the same function as printAllStudents but instead of a score it gives the letter grade
        for(Student s: listOfStudents)
            System.out.printf("%s\t\t%s\t\t%d\t\t%s\n", s.getFirstName(), s.getLastName(), s.getPid(), s.getGrade().getLetterGrade());
    }

}
