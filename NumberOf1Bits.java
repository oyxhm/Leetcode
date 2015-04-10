/*
Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).

For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.
*/

public class NumberOf1Bits {
	// you need to treat n as an unsigned value
    public static int hammingWeight(int n) {
    	int count = 0;
	    for(int i = 1; i < 33; i++){
	        if(getBit(n, i) == true){
	            count++;
	        }
	    }
	    return count;
	}
 
	public boolean getBit(int n, int i){
	    return (n & (1 << i)) != 0;
	}

	public static void main(String[] args) {
		System.out.println(hammingWeight(11));
		System.out.println(hammingWeight(2147483648));
	}
}

