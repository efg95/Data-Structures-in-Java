/*
 * Created by Ecclesiastes on 1/25/2017.
 * uni:efg2123
 */
public class Problem1 {
    public static void main(String[] args) {
    	//rectangle array of 6 rectangles
        Rectangle Rec[] = new Rectangle[6];
        //randomly fills the rectangle with random width and length
        //NO NON NEGATIVE NUMBERS
        for(int i = 0; i<Rec.length; i++){
        	int width = (int)(Math.random() * 10);
        	int length = (int)(Math.random() * 10);
        	Rec[i] = new Rectangle(width, length);
        }
        //prints out the unsorted rectangle list
        System.out.println("The Rectangles in the array are:");
                for(int i = 0; i<Rec.length; i++){
                System.out.println("Rectangle " + (i+1)+ " " +Rec[i]);
                }
        System.out.println("");
        //gets the largest rectangle by comparing perimeters
        System.out.println("Largest Rectangle has a " + findMax(Rec).toString());
    }
    //method copied from the assignment section
    public static <AnyType extends Comparable<AnyType>>  AnyType findMax(AnyType[] arr) {
        int maxIndex = 0;
        for (int i = 1; i < arr.length; i++)
            if ( arr[i].compareTo(arr[maxIndex]) > 0 )
                maxIndex = i;
        return arr[maxIndex];
    }
}
