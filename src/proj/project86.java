//------------------------------ Assignment -----------------------------------
//  	Programmer:John-Henry Carey		     Course-Section: BP
//  	E-mail address:john_henry_carey@yahoo.com    Assignment: project 8-6
//	Creation Date:4/23/12                        Last Modified:
//-----------------------------------------------------------------------------
//	PURPOSE:
//-----------------------------------------------------------------------------
//	INPUT:
//-----------------------------------------------------------------------------
//	OUTPUT:
//-----------------------------------------------------------------------------
//	NOTES: 1. No error checking is done on the information provided by user.
//-----------------------------------------------------------------------------
package proj;

//swhts = student with highest test score
//swhta = student with highest test average

import proj.Student;
import javax.swing.*;
import BreezySwing.*;

public class project86 extends GBFrame
{
    //declare window objects --------------------------------

    private JButton addButton, modifyButton, firstButton,
                    previousButton, nextButton, lastButton, swhtsButton, swhtaButton;

    private JLabel blankLinel, nameLabel, test1Label, test2Label,
                   test3Label, averageLabel, blankLine2, countLabel,
                   indexLabel;

    private JTextField nameField, modNameField;

    private IntegerField test1Field, test2Field, test3Field,
                         averageField, countField, indexField, modTest1Field, modTest2Field, modTest3Field, classavgField;

    //Other instance variables----------------------------

    private Student[] students;         //Array of students
    private int indexSelectedStudent;   //position of current student
    private int studentCount;           //to count # of students(elements) in array

    //Constructor------------------------------------------

    public project86()
    {
        //initialize data
        indexSelectedStudent = -1;
        studentCount = 0;
        students = new Student[10];

        //instantiate window objects
        addButton     = addButton ("Add"   ,2,4,1,1);   //create "add" button to GUI (,row,column,width,height)
        modifyButton  = addButton ("Modify",3,4,1,1);   //create "modify" button to GUI

        blankLinel    = addLabel (""  , 6,1,1,1);  //,r,c,w,h
        firstButton   = addButton("<<", 7,1,1,1);
        previousButton= addButton("<" , 7,2,1,1);
        nextButton    = addButton(">" , 7,3,1,1);
        lastButton    = addButton(">>", 7,4,1,1);
        swhtsButton   = addButton("highest score", 5,4,1,1);
        swhtaButton   = addButton("highest average", 4,4,1,1);
        //classavgField = addIntegerField(0,4,1,1,1);

        nameLabel    = addLabel ("Name"    ,1,1,1,1);
        test1Label   = addLabel ("Test 1"  ,2,1,1,1);
        test2Label   = addLabel ("Test 2"  ,3,1,1,1);
        test3Label   = addLabel ("Test 3"  ,4,1,1,1);

        averageLabel   = addLabel ("Average"     ,5,1,1,1);
        nameField    = addTextField     ("",1,2,2,1);
        test1Field   = addIntegerField  (0 ,2,2,1,1);
        test2Field   = addIntegerField  (0 ,3,2,1,1);
        test3Field   = addIntegerField  (0 ,4,2,1,1);
        averageField   = addIntegerField  (0 ,5,2,1,1);
        blankLine2     = addLabel         (""               ,8,1,1,1);
        countLabel     = addLabel         ("Count"          ,9,1,1,1);
        countField     = addIntegerField  (0                ,9,2,1,1);
        indexLabel     = addLabel         ("Current Index"  ,9,3,1,1);
        indexField     = addIntegerField  (-1               ,9,4,1,1);

        //These fields are read-only, you cant edit
        averageField.setEditable (false);
        countField.setEditable (false);
        indexField.setEditable (false);
        //runs method display current student
        displayCurrentStudent();
    }

    //buttonClicked method-------------------------------------------

    public void buttonClicked (JButton buttonObj)
    {
        if      (buttonObj == addButton)     add();
        else if (buttonObj == modifyButton)  modify();
        else if (buttonObj == firstButton)   displayFirst();
        else if (buttonObj == previousButton)displayPrevious ();
        else if (buttonObj == nextButton)    displayNext();
        else if (buttonObj == lastButton)    displayLast();

     }

    //Private Methods-------------------------------------------------

    private void add()
    {
        if (studentCount == students.length)
        {
            messageBox ("SORRY: student array is full");
            return;
        }

        Student stu = getDataOnScreen();
        String str = stu.validateData();

        if (str != null)        //if the data is invalid
        {
            messageBox (str);   //then exit method without
            return;             //adding the student
        }

        students[studentCount] = stu;
        indexSelectedStudent = studentCount;
        studentCount++;

        displayCurrentStudent();
    }

        private Student getDataOnScreen()
        {
            String nm = nameField.getText().trim();

            int[] tests = new int[3];
            tests[0] = test1Field.getNumber();
            tests[1] = test2Field.getNumber();
            tests[2] = test3Field.getNumber();

            Student stu = new Student (nm, tests);
            return stu;
        }

        private void modify()
        {
            Student stu = this.students[indexSelectedStudent];
            stu.setScore(1,test1Field.getNumber());
            stu.setScore(2,test2Field.getNumber());
            stu.setScore(3,test3Field.getNumber());
            displayCurrentStudent();
        }
          /*private double displayClassAverage()
        {
            int classAvg = 0;

            for (int i = 0; i <= (studentCount - 1); i++)
            {
                if (classAvg += this.students[i].getAverage());

            }
            classAvg = classAvg/studentCount;
             return classAvg;
        }*/



        /*private double displayClassAverage()
        {
            int highAvg = 0;
            int studentAvg = 0;
            for (int i = 0; i <= (studentCount - 1); i++)
            {
                if (highAvg < this.students[i].getAverage());
                studentAvg = i;
            }

             return classAvg;
        }*/




        private void displayFirst()
        {
            if (studentCount == 0)
                indexSelectedStudent = -1;
            else
                indexSelectedStudent = 0;
            displayCurrentStudent();
        }

        private void displayPrevious()
        {
            //completion of this method...
        }

        private void displayNext()
        {
            if (studentCount == 0)
                indexSelectedStudent = -1;
            else
                indexSelectedStudent
                    = Math.min (studentCount - 1, indexSelectedStudent + 1);
            displayCurrentStudent();
        }

        private void displayLast()
        {
            //completion of this methos....
        }

        private void displayCurrentStudent()
        {
            if (indexSelectedStudent == -1)
            {
                nameField.setText("");
                test1Field.setNumber(0);
                test2Field.setNumber(0);
                test3Field.setNumber(0);
                averageField.setNumber(0);
            }else{
                Student stu = students[indexSelectedStudent];
                nameField.setText(stu.getName());
                test1Field.setNumber(stu.getScore(1));
                test2Field.setNumber(stu.getScore(2));
                test3Field.setNumber(stu.getScore(3));
                averageField.setNumber(stu.getAverage());
            }

            countField.setNumber(studentCount);
            indexField.setNumber(indexSelectedStudent);
        }


    public static void main(String[] args)
    {
        project86 theGUI = new project86();
        theGUI.setSize(400,250);
        theGUI.setVisible(true);
    }

}
