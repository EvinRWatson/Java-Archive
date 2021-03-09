import java.util.*;
public class CitySim
{
	  public static void main(String[]args)
	  {
		//Variables
			Scanner scan = new Scanner(System.in);
			Random rng = new Random();
			String difficulty, input, input2;
			int diffTurn = 0, turn = 1, pop = 1, money = 0, errCHK = 1, errCHK2 = 1;
			double popHappy = 20, popFood, popWater, tax = 0;
		//Randomizing Beginning Food and Water Values
			popFood = (int) Math.round(rng.nextDouble() * 25);
			popWater = (int) Math.round(rng.nextDouble() * 25);     
		//Introducing User   
			System.out.println("\n\nWelcome the CitySim, the text based city building game! \n" +
							   "The object of the game is to build the perfect city! \n\n\n" +
							   "Choose Difficulty Setting:        easy        medium        hard");
			
		//Difficulty Setting
		 while(errCHK == 1)
		  {
		   difficulty = scan.next();
		   
		   if(difficulty.toLowerCase().equals("easy"))
		   {
		  diffTurn = 100;
		  errCHK = 0;
		  money = 10000;
		   }
		   else if(difficulty.toLowerCase().equals("medium"))
		   {
		  diffTurn = 50;
		  errCHK = 0;
		  money = 7500;
		   }
		   else if(difficulty.toLowerCase().equals("hard"))
		   {
		  diffTurn = 25;
		  errCHK = 0;
		  money = 5000;
		  
		   }
		   else if(difficulty.toLowerCase().equals("test"))
		   {
		  diffTurn = 3;
		  errCHK = 0;
		  money = 10;
		   }
		   else
		   {
		   System.out.println("Try again");
		   }
	   }

	  //Providing Tips
	  System.out.println("\n\n########## Instructions ##########\n" +
		"-Food and Water affect Happiness and Population\n" +
	   "-Amenities increase Happiness but nothing else" +
	   "-Tax is collected after every turn, which is dependant on Population and Happiness\n"+
	   "-You lose if you run out of money\n" +
	   "-You win if you get Happiness, Food and Water to 100%\n" +
	   "-Remember that large upgrades cause traffic due to construction, which may decrease the\n" +
	   "happiness of the population. \n" + 
	   "############################## \n\n");
		 //Loading
		 System.out.println("Loading");
		 System.out.print("I");
		 int loadTime = 0;
		 while(loadTime <= 40)
		 {
		 System.out.print("#");
		 try{ Thread.sleep(10);
		} 
		catch (InterruptedException ie){
		 System.out.println("Calculating... \n");
		}
		loadTime = loadTime + 1;
		 }
		 System.out.print("I\n\n\n");     

	  //Turn Loop    
	   boolean contCond = true;
	   while(contCond == true)
	   {
	  System.out.println("Turn: " + turn +
	   "\nTurns Left: " + (diffTurn-turn) + 
	   "\n....................................................\n" +
	   "Population: " + pop + "\n" +
	   "Happiness: " + popHappy + "%\n" +
	   "Food: " + popFood + "%\n" +
	   "Water: " + popWater + "%\n" +
	   "Tax Dollars Earned: " + tax + "\n" +
	   "Money Availible: "  + money + "\n" +
	   "....................................................\n" +
	   "What would you like to do next? \n" +
	   "Commands Available:      wait      upgF (food upgrade)     upgW (water upgrade)" +
	   "        upgA (amenities upgrade)");
	  input = scan.next();
		errCHK = 0;
		errCHK2 = 0;
		  while(errCHK == 0)
		  {
		 if(input.toLowerCase().equals("wait")){
		 errCHK = 1;
		 }else if(input.toLowerCase().equals("upgf"))
		 {
		 System.out.println("What size upgrade would you like? \n \"small\" ($1000) \n \"medium\" ($2500) \n \"large\" ($5000)");
		while(errCHK2 == 0)
		{
		 input2 = scan.next();
		 if(input2.toLowerCase().equals("small")){
		 popFood = (popFood + 2.5);
		 popHappy = popHappy + 5;
		 money = money - 1000;
		 errCHK2 = 1;
		 }
		 else if(input2.toLowerCase().equals("medium")){
		 popFood = (popFood + 5);
		 money = money - 2500;
		 errCHK2 = 1;
		 }
		 else if(input2.toLowerCase().equals("large")){
		  popFood = (popFood + 7.5);
		  popHappy = popHappy - 5;
		 money = money - 5000;
		 errCHK2 = 1;
		 }else{
		 System.out.println("Error - Try Again");
		 }
		}
		 errCHK = 1;
		 }
		 else if(input.toLowerCase().equals("upgw"))
		 {
		errCHK2 = 0;
		 System.out.println("What size upgrade would you like? \n \"small\" ($750) \n \"medium\" ($2000) \n \"large\" ($3500)");
		while(errCHK2 == 0){
		 input2 = scan.next();
		 if(input2.toLowerCase().equals("small")){
		   popWater = (popWater + 2.5);
		   popHappy = popHappy + 5;
		 money = money - 750;
		 errCHK2 = 1;
		 }
		 else if(input2.toLowerCase().equals("medium")){
		   popWater = (popWater + 5);
		   money = money - 2000;
		   errCHK2 = 1;
		 }
		 else if(input2.toLowerCase().equals("large")){
		  popWater = (popWater + 7.5);
		  popHappy = popHappy - 5;
		  money = money - 3500;
		  errCHK2 = 1;
		 }else{
		 System.out.println("Error");  
		 }
		 }
		 errCHK = 1;
		 }
		 else if(input.toLowerCase().equals("upga"))
		 {
		 System.out.println("What size upgrade would you like? \n \"small\" ($3000) \n \"medium\" ($6000) \n \"large\" ($12000)");
		 errCHK2 = 0;
		while(errCHK2 == 0){
		 input2 = scan.next();
		 if(input2.toLowerCase().equals("small")){
		 popHappy = popHappy + 5;
		 money = money - 3000;
		 popFood = (popFood - 2);
		 popWater = (popWater - 2);
		 errCHK2 = 1;
		 }
		 else if(input2.toLowerCase().equals("medium")){
		 popHappy = popHappy + 10;
		 money = money - 6000;
		 popFood = (popFood - 3);
		 popWater = (popWater - 3);
		 errCHK2 = 1;
		 }
		 else if(input2.toLowerCase().equals("large")){
		 popHappy = popHappy + 20;
		 money = money - 12000;
		 popFood = (popFood - 4);
		 popWater = (popWater - 4);
		 errCHK2 = 1;
		 }else{
		 System.out.println("Error");
		 }
		 }
		 errCHK = 1;        
		 }
		 else if(input.toLowerCase().equals("autoWin"))
		 {
		 popFood = 100;
		 popWater = 100;
		 popHappy = 100;  
		 }else{
		 System.out.println("Try again (check spelling)");
		 input = scan.next();
		 }
		 }
		 
	   //Making sure values do not exceed 100%
	   if(popHappy > 100)
		popHappy = 100;
	   if(popFood > 100)
		popFood = 100;
	   if(popWater > 100)
		popWater = 100;
	   
		
	  if(((diffTurn - turn) == 0) || (money < 0))
	  {
		 System.out.println("\n\n****************************GAME OVER****************************");
		 System.out.println("You Lose, :(\n" + 
		  "Turns: " + turn + 
		  "\nMoney: " + money + "\n\n");
		 contCond = false;
	  }
	  else if(popHappy >= 100 && popFood >= 100 && popWater >= 100)
	  {
		 System.out.println("\n\nYou Win, Yay!\n\n");
		 contCond = false;
	  }
	  else{
		pop = (int) (pop + (popWater/2) + (popFood/2) + (popHappy/3));                
		tax = (((popHappy * 2) * pop) + 100);   
		money = (int) (money + tax);
		System.out.println("\n\n");
		turn = turn + 1;
	  }
	   }
  }
  }

