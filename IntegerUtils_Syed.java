package utils;
import java.math.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public interface IntegerUtils_Syed {
	
	public static boolean isEven(int k)	{
		// Uses modulus to determine if the integer 'k' is even or not, returning true if the number has no remainder
		if (k % 2  == 0) {
			return true;
		}
		
		else {
			return false;		
		}
	}
	
	public static boolean isOdd(int k) {
		// Uses modulus to determine if the integer is odd, returning true is the number isn't evenly divisible by 2
		if (k % 2  != 0) {
			return true;
		}
		else {
			return false;		
		}
	}
	
	public static boolean isPrime(int k) {
		if (k <=1) {
			return false;  // Checks if the integer 'k' is less than or equal to 1, as 1 is not a prime number
		}
		
		if (k <= 3) {
			return true;  // Checks if the integer is 2 or 3, as both are prime 
		}

		if (k % 2 == 0 || k % 3 == 0) {
			return false;  // Checks if numbers are divisible by 2 or 3, making them not prime
		}
		
		// Uses 5 as i because the numbers 2 & 3 have been checked. The loop continues if the number i squared is less than the input 'k'
		for (int i = 5; i * i <= k; i += 6) {
			if (k % i == 0 || i % (i + 2) == 0) {
				return false; // Numbers divisible by i or i + 2 are not prime. The loop increments by 6 to skip even numbers
			}
		}
		
		return true;
	}
	
	public static int greatestCommonFactor(int m, int n) {
		m = Math.abs(m);  // Finds the greatest common factor for the two inputs 'm' and 'n' 
		n = Math.abs(n);  // Ensures 'm' and 'n' are positive
		
		while (n != 0) {  // Using while loop to ensure that n becomes 0 
			int temp = n;
			n = m % n;
			m = temp;  
		}
		
		return m;
	}
	
	public static int getGreatestConstrainedMultiple(int k, int maximum) {
		
		while (maximum % k !=0 && maximum > 0) {  // Set a while loop condition for if the maximum input divided by k has no remainder AND is over 0
			maximum -= 1;  // increments by -1 
		}
		
		return maximum;
	}
	
	public static int getIntegerH(int h_q_3, int h_r_5) {
		int h = 3 * h_q_3;  // Checks if a number is divisible by three and has a remainder of 5, integer 'h' is made by multiplying 'h_q_3' by 3
		
		if (h % 5 == h_r_5) {
			return h;  // If it has a remainder of 5
		}
		
		else {
			return -1;  // If the number is not divisible by three and has a remainder of 5
		}
	}
	
	public static int getMaximum(Set<Integer> integerSet) {  // Takes a set of integers are returns the maximum integer
		int maxNum = Integer.MIN_VALUE; //  Sets the variable to the minimum, to sort through and find the max
		
		for (Integer temp : integerSet) {
			if (temp > maxNum) {
				maxNum = temp;
			}
		}
		
		return maxNum;
	}
	
	public static int getMinimum(int[] intArray) {
		int minNum = intArray[0];  // Takes an array of integers and returns the minimum
		
		for (int i = 1; i < intArray.length; i++) {
			
			if(minNum > intArray[i]) {
				minNum = intArray[i];  // If the int 'minNum' is less than i, it becomes i
			}
		}
		
		return minNum;
	}
	public static boolean isSorted(int[] intArray) {
		for (int i = 1; i < intArray.length; i++) { // Uses a for loop to check if an array is sorted throughout
			if(intArray[i-1] >= intArray[i]) { 
				return false;
			}
		}
		return true;  // Returns false if the previous number is larger than the current, and true if the list is sorted throughout.
	}
	
	public static int getSmallestIndexOfMatch(int[] intArray, int target) {
		int index = 0;
		
		for (int i = 0; i < intArray.length; i++) {  // Using for loop to see where the given number is in an array, and returning -1 if it's not there
			if(intArray[i] == target) {
				
				index = i;
				
				break;
			}
			else {
				index = -1;
			}
		}
		return index;
	}
	
	public static int reverse(int k) {
		int reversed = 0;  // The number used to return the reversed number
		
		while (k != 0) {  // Used while loop to build the reversed number, digit by digit. Exits loop once all digits of the original number are processed
			int num = k % 10;
			reversed = reversed * 10 + num;
			
			k /= 10;
		}
		
		return reversed;
	}
	
	public static int sumthing(long k) {
		int sum = 0;  // Finds the sum of the long number 'k'
		
		while (k > 0 || sum > 9) {  // Checks to see if the integer returns a number between 0-9, no more and no less
			
			if (k == 0) {
				k = sum;
				sum = 0;
			}
			
			sum += k % 10;
			k /= 10;
		}
		
		return sum;
	}
	
	public static void main(String[] args) {
		Set<Integer> straightforward = new HashSet<Integer>();  // Made new sets to test 'getMaximum'
		straightforward.add(15);
		straightforward.add(62);
		straightforward.add(193);
		Object sfMaxSet = Collections.max(straightforward);
		
		Set<Integer> extreme = new HashSet<Integer>();
		extreme.add(-1);
		extreme.add(-2);
		extreme.add(-3);
		extreme.add(-4);
		Object extremeMaxSet = Collections.max(extreme);
		
		Set<Integer> exotic = new HashSet<Integer>();
		exotic.add(0);
		exotic.add(1 + 3 - 4);
		exotic.add(16 / 4 - 4);
		Object exoticMaxSet = Collections.max(exotic);
		
		int[] sfArray = {15,62,193};  // Arrays to test 'getMinimum'
		int[] extremeArray = {-1,-2,-3,-4};
		int[] exoticArray = {0, (1+3-4), (16/4-4)};
		
		int[] sfIndex = {1, 2, 3, 4, 5};  // Arrays to test 'getSmallestIndexOfMatch'
		int[] extremeIndex = {1, -2, 3, -4, 5};
		int[] exoticIndex = {0, 1, 0, 1, 0, 1};
		
		// Each method is testing three cases, the first being straightforward, the next extreme, and the third as exotic/bizarre as stated in the rules
		System.out.println("Method 'isEven':");
		System.out.println("Answer = false | Output = "+ isEven(10));
		System.out.println("Answer = true  | Output = "+ isEven(-666));
		System.out.println("Answer = true | Output = "+ isEven((int)Math.sqrt(4)) + "\n");
		
		System.out.println("Method 'isOdd':");
		System.out.println("Answer = true  | Output = "+ isOdd(11));
		System.out.println("Answer = false | Output = "+ isOdd(8));
		System.out.println("Answer = true | Output = "+ isOdd(-277) + "\n");
		
		System.out.println("Method 'isPrime':");
		System.out.println("Answer = true  | Output = "+ isPrime(2));
		System.out.println("Answer = false  | Output = "+ isPrime(234));
		System.out.println("Answer = false | Output = "+ isPrime(0) + "\n");
		
		System.out.println("Method 'greatestCommonFactor':");
		System.out.println("Answer = 9  | Output = "+ greatestCommonFactor(9, 9));
		System.out.println("Answer = 4  | Output = "+  greatestCommonFactor(20, 4328));
		System.out.println("Answer = 7 | Output = "+ greatestCommonFactor((int) Math.sqrt(49), 0) + "\n");
		
		System.out.println("Method 'greatestConstrainedMultiple':");
		System.out.println("Answer = 64  | Output = "+ getGreatestConstrainedMultiple(8, 65));
		System.out.println("Answer = 4  | Output = "+  getGreatestConstrainedMultiple(45, 987));
		System.out.println("Answer = 0 | Output = "+ getGreatestConstrainedMultiple(6, 0) + "\n");
		
		System.out.println("Method 'getIntegerH':");
		System.out.println("Answer = -1 | Output = "+ getIntegerH(5,9));
		System.out.println("Answer = 180 | Output = "+ getIntegerH(60,0));
		System.out.println("Answer = -1 | Output = "+ getIntegerH(11,-11) + "\n");
		
		System.out.println("Method 'getMaximum':");
		System.out.println("Answer = 193 | Output = "+ sfMaxSet);
		System.out.println("Answer = -1 | Output = "+ extremeMaxSet);		
		System.out.println("Answer = 0 | Output = "+ exoticMaxSet + "\n");
		
		System.out.println("Method 'getMinimum':");
		System.out.println("Answer = 15 | Output = " + getMinimum(sfArray));
		System.out.println("Answer = -4 | Output = " + getMinimum(extremeArray));
		System.out.println("Answer = 0 | Output = " + getMinimum(exoticArray) + "\n");
		
		System.out.println("Method 'getSmallestIndexOfMatch'");
		System.out.println("Answer = 2 | Output = " + getSmallestIndexOfMatch(sfIndex, 3));
		System.out.println("Answer = -1 | Output = " + getSmallestIndexOfMatch(extremeIndex, -5));
		System.out.println("Answer = 1 | Output = " + getSmallestIndexOfMatch(exoticIndex, 1) + "\n");
		
		System.out.println("Method 'reverse':");
		System.out.println("Answer = 14 | Output = " + reverse(41));
		System.out.println("Answer = -813 | Output = " + reverse(-318));
		System.out.println("Answer = 61483 | Output = "+ reverse((int) Math.pow(14, 4)) + "\n");
		
		System.out.println("Method 'sumthing':");
		System.out.println("Expected = 6 Received: "+sumthing(483));
		System.out.println("Expected = 0 Received: "+sumthing(0));
		System.out.println("Expected = 9 Received: "+sumthing(48*96));
	}
}
