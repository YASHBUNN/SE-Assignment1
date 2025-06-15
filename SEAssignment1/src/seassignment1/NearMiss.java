/* Title: Fermat's Last Theorem - Near Miss
 * Java File holds the code: NeartMiss
 * 
 * Programmers' Names: 
 * 1. Vamshi Krishna Akuthota - VamshiKrishnaAkuth@lewisu.edu
 * 2. Yashwanth Narakula - YashwanthNarakula@lewisu.edu
 * 
 * Course: SU25-CPSC-60500-001
 * 
 * Date: June 15, 2025
 * 
 * Explanation:
 * take k and n from user as user input, k is range, n is power, k is greater than or equal to 10, n is gretaer than or equal to 3
 * Used nested for loop to compute all combinations of x and y
 * in this nested loop, first calculated the x^n + y^n value
 * then gets the value for z after taking the nth root  of x^n + y^n
 * then near miss is calculated for z and z+1 Formula ==> ((x^n + y^n)-z^n) ((z+1)^n-(x^n + y^n))
 * then relative missed is found
 * and then in last by using if else we found the smallest possible miss.   
 * 
 */
package seassignment1;
import java.util.Scanner;
import java.lang.Math;

public class NearMiss {
	
	//Main Function

	public static void main(String[] args) 
	{ 
            long x=0;
	    long y = 0;
	    long z = 0;
	    long x1 = 0;
	    long y1 = 0;
	    //k data member for taking range from user
	    int k = 0;
	    //k data member for taking power from user
	    int n = 0;
	    
	    //user input scanner object
	    Scanner userinput = new Scanner(System.in);
	    
	    
	    //do while loop to make sure user enters valid input
	    do {
	    	System.out.println("Enter n, n>2 and n<12 :: ");
		    n = userinput.nextInt();
	    }while(n<3 || n>11);
	    
	  //do while loop to make sure user enters valid input
	    do {
	    	System.out.println("Enter K, K>=10 :: ");
		    k = userinput.nextInt();
	    }while(k<10);
	    
	    
	    double smallestmiss = 999999999999.99; 
	    
	    
	    //for loop will execute all the possible combinations of x and y
	    for (x = 10; x<=k; x++) 
	    {
	    	for (y = 10; y<=k; y++)
	    	{
	        	
	    		//getting results for x^n + y^n
	    		long xpowernplusypowern = (long)((Math.pow (x, n))+(Math.pow (y, n)));
	    		
	        
	    		//nth root according to equation of fermat theorem
	    		z = (int) Math.pow (xpowernplusypowern, 1.0/n);
	    		
	        
	    		//For z, Getting near miss by subtracting z^n from x^n + y^n
	    		long nearmissz = (long)(xpowernplusypowern - Math.pow (z, n));
	    		
	    		//For z+1, Getting near miss by subtracting (z+1)^n from x^n + y^n
	    		long nearmisszplusone = (long)(Math.pow (z+1, n) - xpowernplusypowern);
	        
	    		
	        
	    		long nearmiss = 0;
	    		//near miss, it can be from z or z+1
	    		if(nearmissz<nearmisszplusone)
	    		{
	    			nearmiss = nearmissz;
	    		}
	    		else
	    		{
	    			nearmiss = nearmisszplusone;
	    		}
	        
	    		//Applying relative miss formula according to given instructions
	    		double relativemiss = 1. * nearmiss / xpowernplusypowern;
	    		
	        
	        
	    		//smallest possible miss
	    		if(relativemiss<smallestmiss)
	    		{
	    			x1=x;
	    			y1=y;
	    			smallestmiss=relativemiss;
	    		}
	           
	        }
	    }
	    System.out.println(" x = "+ x1 +" and y = "+ y1 +" So, Relative Difference = " + String.format("%.7f", smallestmiss));
	}
}



