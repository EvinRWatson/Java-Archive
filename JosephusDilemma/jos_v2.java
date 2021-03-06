import java.io.File;
import java.io.IOException;
import java.io.*;
import java.util.*;
public class jos_v2
{
  public static void main(String[]args) throws IOException
  {
    PrintStream writer = new PrintStream(new File("saveFile.txt"));
    System.getProperty("line.separator");
    Scanner scan = new Scanner(System.in);
    Calc josephus = new Calc(0, 0, "", "");
    
    System.out.println("How many positions do you want to caluclate for:");
    int sMax = scan.nextInt();
    
    System.out.println("Would you like to save to a file? y/n (saveFile.txt)");
    String input = scan.next();
    boolean saveCalc = false;
    
    System.out.println("Num. People\t:\tOptimal Position");
    if(input.toLowerCase().equals("y"))
    {
      saveCalc = true;
    }
    if(input.toLowerCase().equals("n"))
    {
      saveCalc = false;
    }
       
    for(int i = 1; i <= sMax; i++)
    {
    System.out.println(josephus.startCalc(i));
    if(saveCalc == true)
    {
      writer.print("\n" + josephus.startCalc(i));
    }
    }
    
  }
}