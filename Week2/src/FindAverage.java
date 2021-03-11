import java.util.*;
public class FindAverage 
{
   public static void main (String[] args) 
   {
      Scanner console = new Scanner(System.in);
      int mark, sum = 0, num = 0;
      System.out.println("Enter marks (-1) to terminate");
      mark = console.nextInt();	
      
      // while you don't enter -1; Scanner input takes each mark and adds it to the sum.
      // num (number of entries in total) increases by 1.
      
      while ( mark != -1) 
      {
	   sum += mark;
          num++; 				
	   mark = console.nextInt();		   	
      }
      if (num == 0)
         System.out.println("No students in class");
      else 
         System.out.println("Aver = " +(double)sum/num); // the sum of all the marks is divided by the number of them.
   }
}

