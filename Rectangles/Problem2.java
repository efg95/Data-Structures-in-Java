import java.util.Arrays;

/*
 * Created by Ecclesiastes on 1/27/2017.
 * uni:efg2123
 */
public class Problem2{
    public static void main(String[] args) { 
        
    	//creates a rectangle array with 7 rectangles
    	Rectangle [] a = new Rectangle [7];
    	//randomly fills them up with random widths and lengths
        for(int i = 0; i<a.length; i++){
        	int width = (int)(Math.random() * 10);
        	int length = (int)(Math.random() * 10);
        	a[i] = new Rectangle(width, length);
        }
        //creates a rectangle not inside of an array 
        //for testing purposes to find -1
        int width = (int)(Math.random() * 10);
	    int length = (int)(Math.random() * 10);
        Rectangle b = new Rectangle(width, length);
        System.out.println("This is a special rectangle b with " + b);
        //end of creation of special rectangle
        
        //sorting the array and seeing the sorted result
        System.out.println("");
        System.out.println("The Sorted Array can be found below");
        Arrays.sort(a);
        for(int i = 0; i<a.length; i++){
        System.out.println(a[i]);
        }//end of sorting results
        
        //beginning of my test
        System.out.println("");
        System.out.println("I am looking for rectangle with similar perimeter" 
        + " as rectangle b," 
        +" in my arrays of rectangles.");
        //Rectangle B's perimeter
        System.out.println("Rectangle B's perimeter is: " + b.getPerimeter());
        //checking if there are alike rectangles found in array
        System.out.println("I have found a rectangle that is similar at" 
        + " a specific index");
        System.out.println("or if -1 "
        + "is returned there is no rectangle of that perimeter found: ");  
        System.out.println("array index found: " + binarySearch(a , b));
    }
    //made code copied from Assignment page
    public static <AnyType extends Comparable<AnyType>>       
    int binarySearch(AnyType[] a, AnyType x){
        return binarySearchRecursion(a, 0, a.length-1, x);
    }
    //the helper binary recursive method that makes everything click
    private static <AnyType extends Comparable<AnyType>>
    int binarySearchRecursion(AnyType[] a, int start, int stop, AnyType x){
        
    	int mid;
        while(start<=stop){
            mid = (start + stop)/2;

            if(a[mid].compareTo(x) < 0 ){
                return binarySearchRecursion(a, mid + 1, stop, x);
            }
            else if(a[mid].compareTo(x) > 0) {
                return binarySearchRecursion(a, start, mid - 1, x);
            }
            else{
                return mid;
            }
        }//end of while
        return - 1;
    }


}