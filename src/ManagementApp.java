

import java.util.InputMismatchException;
import java.util.Scanner;

public class ManagementApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManagementSystem mgSystem = new StudentManagementSystem();
        // TODO Auto-generated method stub
        int choice;
        do {
            try {
                System.out.println("\nStudent Management System");
                System.out.println("1. Add a new student");
                System.out.println("2. Remove a student");
                System.out.println("3. Search for a student");
                System.out.println("4. Display all students");
                System.out.println("5. Record Student Grades");
                System.out.println("6. Exit");
                System.out.println("Enter your Choice : ");
                choice = sc.nextInt();

                switch (choice) {
                    case 1: {
                        System.out.println("Enter Roll Number for Student : ");
                        int rollNumber = 0;
                        while (true) {
                            try {
                                rollNumber = sc.nextInt();
                                break;
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid input. Please enter a valid integer for roll number.");
                                sc.next(); // consume invalid input
                            }
                        }
                        System.out.println("Enter First Name of Student : ");
                        String firstName = sc.next();
                        System.out.println("Enter Last Name of Student : ");
                        String lastName = sc.next();

                        if (firstName.trim().isEmpty() || lastName.trim().isEmpty()) {
                            System.out.println("Name  cannot be empty. Try again.");
                            break;
                        }

                        mgSystem.addNewStudent(new Student(rollNumber, firstName, lastName));
                        break;
                    }
                    case 2: {
                        System.out.println("Enter Roll Number of Student to be Remove : ");
                        int rollNumber = sc.nextInt();
                        mgSystem.removeStudent(rollNumber);
                        break;
                    }
                    case 3: {
                        System.out.println("Enter RollNumber of Student to Search particular Student ");
                        int rollNumber = sc.nextInt();
                        Student foundstudent = mgSystem.searchStudent(rollNumber);
                        if (foundstudent != null) {
                            System.out.println("Student Found : " + foundstudent);
                        } else {
                            System.out.println("Searched Student not Found");
                        }
                        break;
                    }
                    case 4: {
                        System.out.println("All Students : ");
                        mgSystem.displayStudents();
                        break;
                    }
                    case 5: {
                        mgSystem.studentgrades();
                      break;


                    }
                    case 6: {
                        System.out.println("Exiting from Management System...");
                        System.exit(0);
                        break;
                    }
                    default: {
                        System.out.println("Invalid Choice, Please try again.");
                    }
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer for your choice.");
                sc.next(); // consume invalid input
                choice = -1;
            }
        } while (choice != 5);


        sc.close();

    }

}
