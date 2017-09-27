/*
 * Created by Ecclesiastes on 1/25/2017.
 * uni: efg2123
 */
public class Rectangle implements Comparable<Rectangle> {

    private int length;
    private int width;

    public Rectangle(int w, int l){//constructor
        width = w;
        length = l;
    }
    
    private int getLength(){
        return length;
    }
    
    private int getWidth(){
        return width;
    }
    
    public int getPerimeter(){//perimeter method
        return (2 * getLength()) + ( 2 * getWidth());
    }
    
    public String toString(){
    	return "width of " + width + " and length of " + length 
            		+ " With a perimeter of " + getPerimeter();
    }


    @Override
    //my compare to method
    //Credits to Professor Blaer's code of Person compareTo
    public int compareTo(Rectangle other){

       if(this.getPerimeter()>other.getPerimeter()){
           return 1;

       }
       else if(this.getPerimeter()<other.getPerimeter()){
           return -1;

       }
        else
            return 0;



    }
}
