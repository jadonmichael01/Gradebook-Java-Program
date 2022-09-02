package util;

public class Grade {

    public Grade(int score) { // this creates a constructor for the class and we use it in the main class to create an instance of a grade
        this.score = score;
    }

    private int score;
    private String letterGrade;
    public int getScore() { // returns the score
        return score;
    }
    public String getLetterGrade() { // this gives us a letter grade based on the if and else if statements that correspond to
        if(score >= 90){             // the class syllabus grading system
            letterGrade = ("A");
        }else if(score >= 85){
            letterGrade = ("A-");
        }else if(score >= 80){
            letterGrade = ("B+");
        }else if(score >= 75 ){
            letterGrade = ("B");
        }else if(score >= 70){
            letterGrade = ("B-");
        }else if(score >= 65){
            letterGrade = ("C+");
        }else if(score >= 60){
            letterGrade = ("C");
        }else if(score >= 50){
            letterGrade = ("D");
        }else{
            letterGrade = ("F");
        }
        return letterGrade;
    }

    public void setScore(int score){ // this allows us to change the score which we wil use in the change grade in the student class
        this.score = score;
    }

}
