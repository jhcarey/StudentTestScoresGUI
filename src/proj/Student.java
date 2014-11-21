

package proj;


public class Student
{
    //instance variables
    private String name;
    private int[] tests = new int[3];

    //constructor method
    public Student()
    {
        //initialize a new studnts's name to the empy string and the test scores to 0
        name = "";
        for (int i = 0; i < 3; i++)
            tests[i] = 0;

    }

    //other methods
    public Student(String nm, int[] t)
    {

        name = nm;
        for (int i = 0; i < 3; i++)
            tests[i] = t[i];
    }

    public Student(Student s)
    {
        name = s.name;
        for(int i = 0; i < 3; i++)
            tests[i] = s.tests[i];

    }

    public void setName(String nm)
    {
        name = nm;
    }

    public String getName()
    {
        return name;
    }


    public void setScore(int i, int score)
    {
       tests[i - 1] = score;
    }

        public int getScore(int i)
    {
        return tests [i - 1];
    }
        public int getAverage()
    {
        int sum = 0;
        for (int i = 0; i < 3; i++)
            sum += tests[i];
        return sum / 3;
    }

        public int getHighScore()
        {
            //Determine and return high score
            int highScore;
            highScore = tests[0];
            for (int i = 1; i < 3; i++){
                highScore = Math.max (highScore, tests[i]);
            }
            return highScore;
        }


        public String toString()
        {
            //construct and return a string representation
            String str;
            str = "Name:    " + name  + "\n";    //"\n" denotes a newline
            for (int i = 0; i < 3; i++){
                str += "test " + i + ":  " + tests[i] + "\n";
            }
            str += "Average: " + getAverage();
            return str;
        }

        public String validateData()
        {
            //returns null if there are no errors else returns
            //an appropriate error message
            if (name.equals("")) return "SORRY: name required";
            for (int i = 0; i < 3; i++)
            {
                if (tests[i] < 0 || tests [i] > 100){
                    String str = "SORRY must have " + 0
                            + " <= test score <= " + 100;
                    return str;
                }
            }
            return null;
        }
}//end

