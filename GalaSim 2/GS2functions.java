import java.util.*;
public class GS2functions
{
  Scanner scan = new Scanner(System.in);
  Random rng = new Random();
  //Var Dec.
  String strInput = "", output = "";
  int intInput = 0, inputYear = 0, currentYear = 0;
  float carbonDSTY, rockDSTY, hydrogenDSTY, heliumDSTY, starDSTY;
  int totalStar, totalPlanet, totalMoon, totalPLSB, totalBF;
  boolean random = true;
  public GS2functions()
  {
    //Var Init.
    carbonDSTY = rockDSTY = hydrogenDSTY = heliumDSTY = starDSTY = 1;
    totalStar= totalPlanet = totalMoon = totalPLSB = totalBF = 0;
  }
  
  public void setHydrogenDSTY(float input)
  {
    hydrogenDSTY = input;
    while(hydrogenDSTY > 2){
      System.out.println("Try again (Must be a number value between 0 and 2)");
      hydrogenDSTY = scan.nextFloat();
    } 
  }
  
  public float getHydrogenDSTY()
  {
    return hydrogenDSTY;
  }
  
  public void setHeliumDSTY(float input)
  {
    heliumDSTY = input;
    while(heliumDSTY > 2){
      System.out.println("Try again (Must be a number value between 0 and 2)");
      heliumDSTY = scan.nextFloat();
    } 
  }
  
  public float getHeliumDSTY()
  {
    return heliumDSTY;
  }
  
  public void setRockDSTY(float input)
  {
    rockDSTY = input;
    while(rockDSTY > 2){
      System.out.println("Try again (Must be a number value between 0 and 2)");
      rockDSTY = scan.nextFloat();
    } 
  }
  
  public float getRockDSTY()
  {
    return rockDSTY;
  }
  
  public void setCarbonDSTY(float input)
  {
    carbonDSTY = input;
    while(carbonDSTY > 2){
      System.out.println("Try again (Must be a number value between 0 and 2)");
      carbonDSTY = scan.nextFloat();
    } 
  }
  
  public float getCarbonDSTY()
  {
    return carbonDSTY;
  }
  
  public void setRandom(boolean input)
  {
    random = input;
  }
  
    public void calculation()
  {
      System.out.println("Year: " + currentYear);
//Optional Random Values
          if(random == true)
          {
          carbonDSTY = rng.nextFloat();
          hydrogenDSTY = rng.nextFloat();
          heliumDSTY = rng.nextFloat();
          rockDSTY = (float) (rng.nextFloat() * .5);
          }
//Random Values
    float starANMLY = (rng.nextFloat() /6);
          int avgBodyVelocity = (rng.nextInt(90000) + 1);
          starDSTY = (hydrogenDSTY + heliumDSTY + starANMLY) / 2;
//Output Values
          double newStar = 1000 * (starDSTY + starANMLY) ;
          double newPlanet = (rockDSTY + (avgBodyVelocity * .01));
          double planetsInHZ = (newPlanet * .08);
          double newMoons = (newPlanet * rockDSTY);
          double newPLSB = newPlanet * (planetsInHZ * carbonDSTY * .0002);
//Rounding to Ints
          int rNewStar = (int) Math.round(newStar);
          int rNewPlanet = (int) Math.round(newPlanet);
          int rNewMoons = (int) Math.round(newMoons);
          int rNewPLSB = (int) Math.round(newPLSB);
          int totalNewBF = (rNewStar + rNewPlanet + rNewMoons + rNewPLSB);
//Console Output
          output = ("New Stars: " + rNewStar + 
          "\nNew Planets: " + rNewPlanet + 
          "\nNew Moons: " + rNewMoons + 
          "\nNew Possibly Life Sustaining Bodies (PLSBs): " + rNewPLSB + 
          "\nTotal New Bodies Formed: " + totalNewBF + 
          "\n------------------------------------------\n");
//Adding Total Values
      totalStar = totalStar + rNewStar;
      totalPlanet = totalPlanet + rNewPlanet;
      totalMoon = totalMoon + rNewMoons;
      totalPLSB = totalPLSB + rNewPLSB;
      totalBF = totalBF + totalNewBF;
     
     currentYear = currentYear + 1;
  }
    
    public String getCycleIO()
    {
      return output;
    }
    
    public String printTotals()
    {
      String strTotals = ("////////////////////////////////////////// " +
                   "\nTotal Stats" +  
                   "\nTotal Stars Formed: " + totalStar + 
                   "\nTotal Planets Formed: " + totalPlanet + 
                   "\nTotal Moons Formed: " + totalMoon + 
                   "\nTotal PLSBs Formed: " + totalPLSB + 
                   "\nTotal Bodies Formed: " + totalBF +
                   "\n////////////////////////////////////////// ");
      return strTotals;
    }
} 