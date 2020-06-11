package com.company;
import java.util.Scanner;
import java.util.Random;

public class HomeWorkRandomAndGuessNum {
	public static void main(String[] args) {
	System.out.println("game (To guess number from 0 to 100)");
	LogicFirstGame game = new LogicFirstGame();
	game.logicGame();
	
	System.out.println("randomizer");
	randomizerLogic rand = new randomizerLogic();
	rand.rand();
}
}

class LogicFirstGame {
	private Scanner in;
	private Random rand;
	
	public LogicFirstGame(){
		in = new Scanner(System.in);
		rand = new Random();
	}
	
	public void logicGame () {
		boolean exitFromW = true;
		int rand = callRandomValue();
		System.out.println("!for developer! random value is - " + rand);
		int oldRange = 0;
		int tries = 5;
		String respounseClient = greeting();
		if (!respounseClient.equals("yes")) {
		exitFromW = false;
		}
		
		
		while (exitFromW) {	
		int valueOfUser = valueInputedOfUser();
		int range = valueInsertedFromUser (rand, valueOfUser);
		if (valueOfUser == rand) {
			System.out.println("congratulation !YOU ARE LACKY!");	
			break;
		}
		String check = warmCold(range, oldRange);
		oldRange = range;
		switch (check) {
		case "warm":
			System.out.println("You are become nearly, you have " + tries + " tries");
			tries--;
			break;
		case "cold":
			System.out.println("You are become far, you have " + tries + " tries");
			tries--;
			break;
		case "congradulation":
			System.out.println("congratulation !YOU ARE LUCKY!");
			exitFromW = false;
			break;
		}
		if (tries == 0) {
			System.out.println("I'm sorry !YOU ARE LOOOOOSER!");
			exitFromW = false;
		}
		}	
	}	
	
	
	private String greeting() {
		System.out.println("Hello, i want to play game (to guess number) Do you want play too? yes/no");
		String respounse = in.next();
		return respounse;
	}
	
	private int callRandomValue() {
		int randomNum = rand.nextInt(100);
		return randomNum;
	}
	
	private int valueInputedOfUser() {
		System.out.println("please input vale");
		int valueInputedOfUser = in.nextInt();
		return valueInputedOfUser;
	}
	
	private int valueInsertedFromUser (int randValue, int valueInputedOfUser) {
		int comparedValue = randValue - valueInputedOfUser;
		return Math.abs(comparedValue);
	}
	
	private String warmCold (int comparedValue, int oldComparedValue) {
		if (oldComparedValue > comparedValue) {
			return "warm";
		}
		else if (oldComparedValue < comparedValue){
			return "cold";
		}else{
			return "congratulation";
		}
	}
}

class randomizerLogic {
	
	 	private Scanner in;
	    private Random rand;
	    
	    private int minVal;
	    private int maxVal;
	    private int range;
	    private int random;
	    private int[] arr;
	    private boolean exitFromWone;
	    private boolean exitFromWtwo;
	    private boolean checkRepeat;
	    private int index = 0;
	    
	public randomizerLogic () {
	        in = new Scanner(System.in);
	        rand = new Random();
	        exitFromWone = true;
	        exitFromWtwo = true;
	    }
	
	public void rand () {
		System.out.println("Please enter the min number");
		minVal = in.nextInt();
		System.out.println("Please enter the max number");
		maxVal = in.nextInt(); 
		range = maxVal - minVal;
		arr = new int[range];
		
		while (exitFromWone) {
			
			exitFromWtwo = questionForUser (in);
			
			if (exitFromWtwo == false) {
				exitFromWone = false;
			}
			
		while(exitFromWtwo) {
			random = randomVal (rand, range, minVal);
			checkRepeat = checkRepeatNumberInArr(arr, random);
			if (checkRepeat == true) {
			arr[index] = random;
			System.out.println("your random number is - " + random);
			index++;
			exitFromWtwo = false;
			}
		}
		if (index == arr.length) {
			System.out.println("That's all");
			exitFromWone = false;
		}
		}
		
	}
	
	private int randomVal (Random rand, int range, int minVal) {
		return rand.nextInt(range) + minVal;
 	}
	
	private boolean questionForUser (Scanner in) {
		System.out.println("Do you want to know the random number? yes/no");
		String responseUser = in.next();
		return (responseUser.equals("yes")) ?  true : false;
	}
	
	private boolean checkRepeatNumberInArr (int[] arr, int rand) {
		boolean check = true;
		for (int indexOfArr = 0; indexOfArr < arr.length; indexOfArr++) {
			if (arr[indexOfArr] == rand) {
			 check = false;
			}
		}
		return check;
	}
}
