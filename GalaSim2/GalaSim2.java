import java.io.*;
import java.util.*;
public class GalaSim2
{
  public static void main(String[]args) throws IOException
  {
    Scanner scan = new Scanner(System.in);
    GS2functions f = new GS2functions();
    PrintStream writer = new PrintStream("SimOutput.txt");
    //Input Var
    String strInput = "";
    int intInput = 0, inputYear = 0;
    float floatInput = 0;
    //Value Var
    float carbonDSTY, rockDSTY, hydrogenDSTY, heliumDSTY, starDSTY;
    carbonDSTY = rockDSTY = hydrogenDSTY = heliumDSTY = starDSTY = 1;
    int totalStar, totalPlanet, totalMoon, totalPLSB, totalBF;
    totalStar = totalPlanet = totalMoon = totalPLSB = totalBF = 0;
    
    //Program Start
    System.out.println("How many years would you like to simulate?");
    inputYear = scan.nextInt();
    while(inputYear > 1000)
    {
      System.out.println("Oops try again (Max Years = 1000)");
        inputYear = scan.nextInt();
    }
    
    //Next
    System.out.println("Would you like to enter variable values or have a random simulation? \n" + 
                       "Enter \"input\" for option one or \"random\" for option two (without quotes)");
    String inputIOR = scan.next();
    byte errCHK = 0;
    while(errCHK == 0)
    {
      if(inputIOR.equals("input")){
        f.setRandom(false);
        System.out.println("You selected the input option");    
// Asking for a Hydrogen Density Value
        System.out.println("Please enter desired hydrogen density (0-2)");
        f.setHydrogenDSTY(scan.nextFloat());   
        hydrogenDSTY = f.getHydrogenDSTY();
// * Helium Density Value
        System.out.println("Please enter desired helium density (0-2)");
        f.setHeliumDSTY(scan.nextFloat());  
        heliumDSTY = f.getHeliumDSTY();
// * Rock Density Value
        System.out.println("Please enter desired rock density (0-2)");
        f.setRockDSTY(scan.nextFloat());   
        rockDSTY = f.getRockDSTY();
// * Carbon Density Value
         System.out.println("Please enter desired carbon density (0-2)");
         f.setCarbonDSTY(scan.nextFloat());  
         carbonDSTY = f.getCarbonDSTY();
          errCHK = 1;
   }
      else if(inputIOR.equals("random"))
      {
        f.setRandom(true);
        System.out.println("You selected the random option");
            errCHK = 1;
      }
      else
      {
        System.out.println("Try Again");
            inputIOR = scan.next();
      }      
    }
//Running Calculation 
    for (int i = 0; i < inputYear; i++)
    {
      f.calculation();
      System.out.println(f.getCycleIO());
      writer.print(f.getCycleIO());
    }
    
    System.out.println(f.printTotals());
    writer.print(f.printTotals());
    
  }
}