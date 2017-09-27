/* Problem 3 class created by
 * Ecclesiastes Forrest Gan ShengGuang
 * UNI:efg2123, date: 1/30/2017
 */

public class Problem3 {

	public static void main(String[] args) {
		
		//array of testing variables
		int arr [] = {1, 1, 100, 1000, 10000};
		//for loops to test different fragments
		for(int i = 0; i<arr.length; i++){
			fragmentA(arr[i]);
		}
		for(int i = 0; i<arr.length; i++){
			fragmentB(arr[i]);
		}
		for(int i = 0; i<arr.length; i++){
			long startTime = System.nanoTime();
			foo(arr[i], 2);
			long endTime = System.nanoTime();
			long duration = endTime - startTime;
			System.out.println("The Duration for foo: " + duration);
			
		}//end of for loops that test run times
		
	}
	public static void fragmentA(int n){//code fragment A
		long starTime = System.nanoTime();
		int sum = 0;
		for ( int i = 0; i < 23; i ++){
		    for ( int j = 0; j < n ; j ++){
		        sum = sum + 1;
		    }
		}
		long endTime = System.nanoTime();
		long duration = endTime - starTime;
		System.out.println("The Time for fragment A is: " + duration);
		}
	public static void fragmentB(int n){//code fragment B
		long starTime = System.nanoTime( );
		int sum = 0;
		for ( int i = 0; i < n ; i ++){
		    for ( int k = i ; k < n ; k ++){
		        sum = sum + 1;
		    }
		}
		long endTime = System.nanoTime( );
		long duration = endTime - starTime;
		System.out.println("The Time for fragment B is: " + duration);
	}
	//fragment C
	public static int foo(int n, int k) {
		if(n<=k)
	        return 1;
	    else
	        return foo(n/k,k) + 1;
	}
}
