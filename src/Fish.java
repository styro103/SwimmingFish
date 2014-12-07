/*
 * Shaun Mbateng
 * Swimming Fish
 * This program finds how many fish are left alive after being given
 * 		their sizes, position, and direction of travel.
 * It has a time complexity of O(N).
 */

import java.util.Scanner;

public class Fish 
{
	public static void main(String[] args) 
	{
		int [] size; //Array for Sizes of Fish
		int [] dir; //Array for Direction of Fish Travel
		int nof; //Number of Fish
		int living; //Number of Fish Left Alive
		Swimming fish = new Swimming(); //New Instance of Fish Swimming
		Scanner cin = new Scanner(System.in); //For Inputting Sizes and Directions
		
		//Enter and Set Array Length
		System.out.print("Enter the Number of Fish: ");
		nof = cin.nextInt();
		size = new int [nof];
		dir = new int [nof];
		
		//Fill Array Data
		for (int i=0; i<nof; i++)
		{
			System.out.print("Enter Size of Fish at Position "+i+": ");
			size[i] = cin.nextInt();
			System.out.print("Enter Direction of Fish at Position "+i+": ");
			dir[i] = cin.nextInt();
		}
		
		cin.close(); //No More Inputs Needed
		living = fish.getLiving(size, dir); //Get Fish Left Living After Swimming
		System.out.println(); //Line Space
		System.out.println("After the "+nof+" Fish go Swimming, There are "+living+" Left Alive"); //Print Result
	}
}
