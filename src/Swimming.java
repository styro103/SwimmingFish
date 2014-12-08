/*
 * The class that figures out how many fish are left alive given their sizes and direction.
 * This has a time complexity of O(N).
 */

import java.util.Stack; //To Call Stack Function for Keeping Track of Fish

class Swimming
{
    public int getLiving(int[] A, int[] B) 
    {
    	if (A.length==1) //Only One Fish
            return 1; //One Fish Left Standing
        
        int N = A.length; //Number of Fish
        int alive = N; //Count of Living, All Fish Initially Alive
        int t = -1; //To Hold Position of First Fish Swimming Downstream
        boolean nm = true; //Boolean to Check If Any Fish Will Meet
        Stack<Integer>Fish = new Stack<Integer>(); //Keep Track of Downstream Fish
        
        //Base Case and Edge Cases
        for (int i=0; i<N; i++) //Loop Through Array
        {
        	/* In Order for Fish to Meet, There Must be at Least 
        	 * One Swimming Upstream After One Swimming Downstream
        	 * If Not, All Fish Alive
        	 */
        	switch (B[i]) //Act Depending on Direction
        	{
        		case 0: //Upstream Fish
        			if (t>-1) //If After Downstream Fish
        				nm = false; //At Least One Pair of Fish Will Meet
        			break;
        		case 1: //Downstream Fish
        			if (t<0) //If No Prior Fish Swimming Downstream
        				t = i; //Mark Fish Location
        			break;
        	}
        	if (!nm) //If At Least One Pair of Meeting Fish
        		break; //Stop Checking
        }
        
        if (nm) //If No Pairs of Fish Will Meet
        	return alive; //All Will Live

        Fish.add(A[t]); //Add Instance of Downstream Fish to Stack
        
        for (int i=++t; i<N; i++) //Loop Through Remaining Fish
        {
            if (B[i]==1) //If Downstream Fish
                Fish.add(A[i]); //Add to Stack
            else if (!Fish.isEmpty()) //If Upstream Fish With Prior Downstream Fish
            {
                while (!Fish.isEmpty() && A[i]>Fish.peek()) //If Upstream Fish Bigger Than Downstream Fishes
                {
                    Fish.pop(); //Remove Fish From Stack
                    alive--; //Decrement Alive Count
                }
                if (!Fish.isEmpty()) //If Still Fish in Stack
                    alive--; //Upstream Fish Gets Eaten       
            }
        }
        
        return alive; //Return Remaining Alive Count
    }
}