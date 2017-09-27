/*
 * Created By Ecclesiastes Gan 15/2/17
 */
public class twoStacksOneArray {
	private int [] oneArray;
	private int top1;
	private int top2;
	private int size1;
	private int size2;
	public twoStacksOneArray(int n){
		int length = n;
		oneArray = new int [length];//creates an array of size n
		System.out.println(length + " is the size of the array");//shows me the size inputted
		top1 = -1; //why negative one? Because when I push the array's first position starts at 0.
		top2 = length; // why length? same as above its just the other direction
		
	}
	//pushing for left side of the array
	public void push1(int data){
		if(top1 == top2 -1){
			//if to the right of stack 1 does not have space
			throw new StackOverflowError ("Stack Overflow! You Have Pushed push1 till the end of the list");
		}
		//else increment top of stack1 because going towards right
		//increment size of stack1
		top1++;
			oneArray[top1] = data;
			size1++;
			System.out.println("Check 1: " + data);
			
			
			
	}
	//pushing for the right side of the array
	public void push2(int data){
		if(top2 - 1 == top1){
			//if the left does not have any more space!
			throw new StackOverflowError ("Stack Overflow! You Have Pushed push2 till the end of the list");
		}
		//else decrement top of stack 2 because going towards left
		//and increment size of stack2
		top2--;
		size2++;
			oneArray[top2] = data;
			System.out.println("Check 2: " + data);
			
		}
	
	public int pop1(){
		if(isEmpty1()){
			//if there is nothing left to pop from stack1 print this exception
			System.out.println("EmptyStackException! There is Nothing left to Pop for Pop1");
			System.out.println("I Have Exited You from the program because you were naughty");
			System.exit(0);
		}
			//else decrement stack1 and decrement stack1 size
			size1--;
			//returns the element to the console
			return oneArray[top1--];
			
	}
	//same as above except its the other STACK
	public int pop2(){
		
			if(isEmpty2()){
				System.out.println("EmptyStackException! There is Nothing left to Pop for Pop2");
				System.out.println("I Have Exited You from the program because you were naughty");
				System.exit(0);
			}
			size1--;
			return oneArray[top2++];
		
		
	}
	//checks for empty only difference is that equal 0 because thats where the array begins
	public boolean isEmpty1(){
		if(top1 >= 0){
			return false;
		}
			return true;
		}
	public boolean isEmpty2(){
		if(top2 < oneArray.length){
			return false;
		}
			return true;
	}
	//peeks at the top of stacks respectively
	public void peek1(){
		System.out.println("This is the top of stack1:" + oneArray[top1]);
	}
	public void peek2(){
		System.out.println("This is the top of stack2: " + oneArray[top2]);
	}
	//keeps track of the respective sizes
	public void size1(){
		System.out.println("This is the current size of stack1: " + size1);	
	}
	public void size2(){
		System.out.println("This is the current size for stack2: " + size2);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		twoStacksOneArray theStack = new twoStacksOneArray(5);
		
		
		theStack.push2(10); 
		theStack.push2(3);
		theStack.size2();
		//
		theStack.push1(50);
		theStack.push1(45);
		theStack.push1(55);
		//theStack.push1(100);
		//theStack.push2(1000);
		theStack.size1();
		
		//End of push
		System.out.println("");
		theStack.peek1();
		theStack.peek2();
		System.out.println("");
		System.out.println("This is the start of the popping");

		
		
		System.out.println(theStack.pop2());
		theStack.size1();
		System.out.println(theStack.pop2());
		
	
		System.out.println(theStack.pop1());
		theStack.size1();
		System.out.println(theStack.pop1());
		System.out.println(theStack.pop1());
		
		
			
	}
}
