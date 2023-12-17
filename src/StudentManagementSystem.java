

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class StudentManagementSystem
{
    private ArrayList<Student> studentList;
    private static final String fileName = "students_data.dat";

    public StudentManagementSystem()
    {
        super();
        // TODO Auto-generated constructor stub
        studentList=new ArrayList<Student>();
        loadStudentsFromFile();

    }
    private void loadStudentsFromFile()
    {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName)))
        {
            studentList = (ArrayList<Student>) ois.readObject();
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File not found. Starting fresh.");
        }
        catch (IOException e)
        {
            System.out.println("No existing data found. Starting fresh.");
        }
        catch(ClassNotFoundException e)
        {
            System.out.println("No existing data found. Starting fresh.");
        }
    }
    private void saveStudentsToFile()
    {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName)))
        {
            oos.writeObject(studentList);
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File not found when saving students.");
            e.printStackTrace();
        }
        catch (IOException e)
        {
            System.out.println("Error writing to file.");
            e.printStackTrace();
        }
    }
    public void addNewStudent(Student student)
    {
        boolean addedSuccessfully=studentList.add(student);

        if(addedSuccessfully)
        {
            System.out.println("Student added Successfully.");
            saveStudentsToFile();
        }
        else
        {
            System.out.println("Failed to add new student. so please try again.");
        }

    }
    public void setGrade(Student student)
    {

//      Student s= searchStudent(student.getRollNo());
      Iterator<Student> it= studentList.iterator();
      while(it.hasNext()){
          Student s=it.next();
          if(s.getRollNo()==student.getRollNo()){
              s.setGrade(student.getGrade());
          }
      }


         System.out.println("grades recorded Successfully.");
            saveStudentsToFile();



    }
    public void updateGrade(Student student)
    {

//      Student s= searchStudent(student.getRollNo());
        Iterator<Student> it= studentList.iterator();
        while(it.hasNext()){
            Student s=it.next();
            if(s.getRollNo()==student.getRollNo()){
                s.setGrade(student.getGrade());
            }
        }


        System.out.println("grades updated Successfully.");
        saveStudentsToFile();



    }
    public void removeStudent(int rollNumber)
    {
        Iterator<Student> it=studentList.iterator();
        boolean studentFound = false;
        while(it.hasNext())
        {
            Student s=it.next();
            if(s.getRollNo()==rollNumber)
            {
                it.remove();
                System.out.println("Student Removed.");
                studentFound = true;
                break;
            }
        }
        if (!studentFound)
        {
            System.out.println("Student Not Found for removal.");
        }
        saveStudentsToFile();
    }
    public Student searchStudent(int rollNumber)
    {
        for (Student student : studentList)
        {
            if(student.getRollNo()==rollNumber)
            {
                return student;
            }
        }
        System.out.println("Searched Student not Found.");
        return null;
    }
    public void displayStudents()
    {
        if(studentList.isEmpty())
        {
            System.out.println("No students Available.");
        }
        else
        {
            for (Student student : studentList)
            {
                System.out.println(student);
            }
        }
    }
   public void studentgrades(){
        Scanner sc=new Scanner(System.in);
        int ch;
       System.out.println("1.Record Grades\n2.Update Grades");
       ch=sc.nextInt();
       int roll=0;
       Student foundstudent=null;
       switch (ch){

           case 1:
               System.out.println("enter student roll number to record grades");
              roll =sc.nextInt();
                foundstudent=searchStudent(roll);
               if(foundstudent==null){
                   System.out.println("Enter roll number Again");
                   sc.next();
               }
               System.out.println("enter grade");
               String grade=sc.next();
               foundstudent.setGrade(grade);
               setGrade(foundstudent);
               break;

           case 2:
               System.out.println("enter Student roll number to update grades");
                roll=sc.nextInt();
                foundstudent=searchStudent(roll);
               if(foundstudent==null){
                   System.out.println("Enter roll number Again");
                   sc.next();
               }
               System.out.println("enter grade");
               String grade1=sc.next();
               foundstudent.setGrade(grade1);
               updateGrade(foundstudent);
             break;

       }

   }

}

