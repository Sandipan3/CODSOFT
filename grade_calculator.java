/*
 Input: Take marks obtained (out of 100) in each subject.
Calculate Total Marks: Sum up the marks obtained in all subjects.
Calculate Average Percentage: Divide the total marks by the total number of subjects to get the
average percentage.
Grade Calculation: Assign grades based on the average percentage achieved.
Display Results: Show the total marks, average percentage, and the corresponding grade to the user.
 */



/* For grading I am using this system:
A = 90+

B= 75–89

C= 60–74

D= 40–59

E= below 40*/

import java.util.Scanner;
class grade_calculator{

static double average , percentage;
static char grade;
    public static double average(int s1,int s2,int s3,int s4,int s5)
    {
        return ((s1+s2+s3+s4+s5)/5);
        // this function takes the marks as parameters and returns the average rounded off to nearest integer
    }
    
    public static double percentage(int s1,int s2,int s3,int s4,int s5)
    {
        return ((s1+s2+s3+s4+s5)*100/500);
        // this function takes the marks as parameters and returns the percentage rounded off to nearest integer
    }
    
    public static boolean is_valid_marks(int s1,int s2,int s3,int s4,int s5)
    {
        return ((s1 < 101) && (s2 < 101) && (s3 < 101) && (s4 < 101) && (s5 < 101));
        // this function is important as it ensures that marks entered per subject do not exceed 100(top marks here) 
    }


    public static char grade(double avg)
    {
        if (avg>90)
            {   grade= 'A';}

        else if((avg>74)&&(avg<=90))
        {   grade= 'B';}

        else if((avg>60)&&(avg<=74))
        {   grade= 'C';}

        else if((avg>40)&&(avg<=59))
        {   grade= 'D';}

        else
        {   grade = 'E';}

        return grade;

        // this function returns grade based on average marks
    }
    public static void main(String[]args)
    {
        Scanner sc =new Scanner(System.in);
        System.out.println("Please enter the marks out of 100");
        System.out.println("Enter the marks in Mathematics");
        int math = sc.nextInt()  ;
        System.out.println("Enter the marks in English");
        int eng =  sc.nextInt(); 
        System.out.println("Enter the marks in Computer Science");
        int cs= sc.nextInt();
        System.out.println("Enter the marks in History, Civics and Geography");
        int hcg = sc.nextInt();
        System.out.println("Enter the marks in 2nd Language");
        int lang_2 = sc.nextInt();
        // here we take input from user marks scored in 5 subjects

        
         if(is_valid_marks(math, eng, cs, hcg, lang_2)){

            System.out.printf("The average marks scored is : %.2f \n",average(math, eng, cs, hcg, lang_2));
            System.out.printf("The average marks scored is :  %.2f \n",percentage(math, eng, cs, hcg, lang_2));
            System.out.println("The grade of the student is : "+grade(average(math, eng, cs, hcg, lang_2)));
           // this parts runs only if marks are entered correctly
        }
            else{
                System.out.println("Error !! Please enter the marks correctly");
                // if user enters marks incorrectly we promt the user to enter the marks correctly
             }
        sc.close();
    }
}