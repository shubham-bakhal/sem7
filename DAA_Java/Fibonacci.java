
public class Fibonacci {
	
	// iterative way- TC = O(N) & SC = O(1)
	public static void fibI(int n) {
		int num1 = 0;
		int num2 = 1;
		int counter = 0;
		
		while(counter < n) {
			System.out.println(num1 + " ");
			
			int num3 = num1 + num2;
			num1 = num2;
			num2 = num3;
			++counter;
		}
	}
	
	
	// recursive way - TC = O(2^N) & SC = O(1)
	public static int fibR(int n) {
		if (n <= 1) {
			return n;
		}
		return fibR(n-1)+fibR(n-2);
	}
	
	// dynamic programming - TC = O(N) & SC = O(N)
	public static int fibD(int n) {
		int[] f = new int[n+2];
		f[0] = 0;
		f[1] = 1;
		
		for(int i = 2; i <= n; i++) {
			// Add the previous 2 numbers
            // in the series and store it
			f[i] = f[i-1] + f[i-2];
		}
		return f[n];
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 10;
//		fibI(n);
		
		// recursive way
//		for(int i = 0; i < n; i++) {
//			System.out.println(fibR(i) + " ");
//		}
		
		// DP way
		for(int i = 0; i < n; i++) {
			System.out.println(fibD(i) + " ");
		}
	}

}
