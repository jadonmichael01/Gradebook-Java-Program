//NAME: JADONMICHAEL DE JESUS

package main;

import util.*;
import java.util.Scanner;
import java.lang.*;

public class Main {
    // this method will validate the criteria for the user's inputs
    private static boolean isValid(String firstName, String lastName, String pid, int grade) {
        if (!Character.isUpperCase(firstName.charAt(0))) // checks if the first character of firstname is uppercase
            return false;
        for (char c : firstName.toCharArray()) // checks if firstname only has alphabetical letters
            if (!Character.isLetter(c))
                return false;
        if (!Character.isUpperCase(lastName.charAt(0))) // checks if the lastname is uppercase
            return false;
        for (char c : lastName.toCharArray()) // checks if lastname only has alphabetical letters
            if (!Character.isLetter(c))
                return false;
        if (pid.length() != 7 || Integer.parseInt(pid) < 1000000){ // makes sure pid has 7 digits and no leading zeroes
            return false;
        }
        if (!(grade >= 0 && grade <= 100)) { // this makes sure that the input of grade is in a range from 0-100 and does not exceed from it
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to my grade book!");
        System.out.println("Please enter the information of the first student using the following format:");
        System.out.println("“firstName lastName PID grade”.");
        System.out.println("Press Enter when you are done.");
        Scanner keyboard = new Scanner(System.in);
        String command = "";
        Gradebook book = new Gradebook();
        while(true) { // this is our first loop for the input handling phase
            command = keyboard.next();
            if(command.equals("DONE")) // this will break this first while loop, so we can enter the program handling phase
                break;
            String firstName, lastName, pid; // initialize the variables for firstname, lastname and pid
            int grade; // initialize the grade variable
            firstName = command; // this will be the first input in the same line
            lastName = keyboard.next(); // next input and so on and so forth
            pid = keyboard.next();
            grade = keyboard.nextInt();
            if(isValid(firstName, lastName, pid, grade)) { // we call the method we made in the beginning to validate the user's inputs
                book.addStudent(new Student(firstName, lastName, Integer.parseInt(pid), grade));
                System.out.println("Please enter the information of the next student using the same format."); // this will repeat after the first student was inputted by the user
                System.out.println("If there is no more students, please enter the keyword “DONE”.");
                System.out.println("Press Enter when you are done.");
                continue; // if the user satisfies the criteria we add the student instance into the gradebook that we made
            }               // then we continue the first while loop
            System.out.println("Please try again!"); // if the user fails meeting the criteria the program will ask it to try again and continue looping
          ;

        }


        while(true) { // this is the second while loop that deals with the command handling phase
            System.out.println("Please enter new command");
            command = keyboard.next();
            switch(command) { // we are using a switch case method for the user's inputs
                case "min": // if the user first inputs min they have a series of if statements to match their inputs
                    String secondWord = keyboard.next();
                    if(secondWord.equals("score")) // if the user inputs: "min score" the program prints the minimum score by calling the method from the gradebook class
                        System.out.println(book.minScore());
                    else if(secondWord.equals("letter")) // if the user inputs "min letter" the program will print the minimum letter grade by creating an instance of a grade and calling the minscore method with getlettergrade from grade class
                        System.out.println(new Grade(book.minScore()).getLetterGrade());
                    else
                        System.out.println("Invalid command! try again!");
                    break;
                case "max": // the next case deals with the user's input of max
                    String nextWord = keyboard.next();
                    if(nextWord.equals("score")) // if the user inputs "max score" the program will print the minimum score from the gradebook by calling the maxscore method from gradebook
                        System.out.println(book.maxScore());
                    else if(nextWord.equals("letter")) // if the user inputs "max letter" the program will print the minimum letter from the gradebook
                        System.out.println(new Grade(book.maxScore()).getLetterGrade()); // it will create a new grade instance with the method of minScore from the gradebook class and call the getLetterGrade method from the Grade class
                    else
                        System.out.println("Invalid command! try again!");
                    break;
                case "letter": // this allows the user to input letter with a specific PID
                    int searchPID = keyboard.nextInt(); // this will let the user find the letter grade of a specific student according to the PID
                    book.letterScore(searchPID); // we initialize the user's next input by an int to use in the parameters of the letterScore method in Gradebook class
                    break;
                case "name": // this allows the user to find a student's name by searching with a specific PID
                    int searchPID1 = keyboard.nextInt(); // similar to the letter case we initialize the user's next input to
                    book.nameSearch(searchPID1);
                    break;
                case "change": // this allows the user to change a grade of a student
                    int searchPID2 = keyboard.nextInt(); // we initialize the nextInt to a searchPid
                    int newGrade = keyboard.nextInt(); // we initialize the nextInt as the new grade for the student
                    book.changeGrade(searchPID2, newGrade); // we then call the changeGrade method from Gradebook class and utilize the user's inputs
                    break;
                case "average": // this calculates the average of the gradebook
                    String secondWord1 = keyboard.next();
                    if(secondWord1.equals("score")) // if the user inputs: average score, we print out the average grade score
                        System.out.printf("%.2f\n", book.calculateAvg()); // we call the calculateAvg method from the Gradebook
                    if(secondWord1.equals("letter")) // if the user inputs: "average letter", we print out the average letter grade
                        if(book.calculateAvg() >= 90.00){  // this string will be equal to a letter grade that is according to the class syllabus
                            System.out.println("A");       // if the score is equal to one of the following if and else if statements we print out the letter value
                        }else if(book.calculateAvg() >= 85.00){
                            System.out.println("A-");
                        }else if(book.calculateAvg() >= 80.00){
                            System.out.println("B+");
                        }else if(book.calculateAvg() >= 75.00){
                            System.out.println("B");
                        }else if(book.calculateAvg() >= 70.00){
                            System.out.println("B-");
                        }else if(book.calculateAvg() >= 65.00){
                            System.out.println("C+");
                        }else if(book.calculateAvg() >= 60.00){
                            System.out.println("C");
                        }else if(book.calculateAvg() >= 50.00){
                            System.out.println("D");
                        }else{
                            System.out.println("F");
                        }
                    break;
                case "median": // this calculates the median score of the gradebook
                    String secondWord2 = keyboard.next();
                    if(secondWord2.equals("score")) // if the user inputs: "median score" the program will print out the median grade score of the gradebook
                        System.out.printf("%.2f\n",book.calculateMedian()); // we call the calculateMedian method from the gradebook class
                    if(secondWord2.equals("letter")) // if the user inputs: "median letter" the program will print out the median letter grade
                        if(book.calculateMedian() >= 90.00){  // we use if and else if statements to print according to the score's value
                            System.out.println("A"); // we compare the calculateMedian score to our class syllabus grading system according to letter grade
                        }else if(book.calculateMedian() >= 85.00){
                            System.out.println("A-");
                        }else if(book.calculateMedian() >= 80.00){
                            System.out.println("B+");
                        }else if(book.calculateMedian() >= 75.00){
                            System.out.println("B");
                        }else if(book.calculateMedian() >= 70.00){
                            System.out.println("B-");
                        }else if(book.calculateMedian() >= 65.00){
                            System.out.println("C+");
                        }else if(book.calculateMedian() >= 60.00){
                            System.out.println("C");
                        }else if(book.calculateMedian() >= 50.00){
                            System.out.println("D");
                        }else{
                            System.out.println("F");
                        }
                    break;
                case "tab": // this will make the program print the list of all students
                    String secondWord3 = keyboard.next();
                    if(secondWord3.equals("scores")) { // if the user inputs: "tab scores" we will print a list of the students by first name, last name, pid, and score
                        System.out.println("First Name" + "\t" + "Last Name" + "\t" + "PID" + "\t\t\t" + "Grade"); // this will print out a separated table to form a sort of columns to separate the labels
                        book.printAllStudents(); // we call the printAllStudents method from Gradebook class
                    }
                    if(secondWord3.equals("letters")){ // if the user inputs: "tab letters" we will perform a similar function as "tab scores", however we print out the letter grade instead of a score
                        System.out.println("First Name" + "\t" + "Last Name" + "\t" + "PID" + "\t\t\t" + "Grade");
                        book.printAllLetters(); // we call the printAllLetters method from Gradebook class to print out every student's labels with a letter grade score
                    }
                    break;
                case "quit": // if the user inputs "quit" the program will stop asking for commands and quit
                    return;
                default: // if the user inputs an invalid command that is not according to the command phrases it will default to printing this:
                    System.out.println("Invalid command! try again!");
            }
        }
    }



    }
