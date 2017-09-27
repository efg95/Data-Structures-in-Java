/*
 * TwoStackQueue generic <AnyType> implements DataStructures homework supplementary
 * file given MyQueue
 * models the ADT of a QUEUE using two stacks as the abstract data type within the queue
 * done By Ecclesiastes Gan 2/20/2017
 */
public class TwoStackQueue<AnyType> implements MyQueue<AnyType>{
	private MyStack <AnyType> stackOne;//enqueue input stack
	private MyStack <AnyType> stackTwo;//dequeue output stack
	private int size;//instance variable to keep track of the size of the queue
	
	public TwoStackQueue(){
		//creating my stack
		stackOne = new MyStack<>();
		stackTwo = new MyStack<>();
	}
	@Override
	public void enqueue(AnyType data){
		stackOne.push(data);//pushing data on the first stack when enqueue is called
		size++;//i increment queue size
	}
	@Override
	/*
	 * I wasn't sure how to return a null result if the operator was to dequeue an empty output stackTwo
	 * So i Googled; it I was originally throwing an exception
	 * is that ok?? http://introcs.cs.princeton.edu/java/43stack/ <-- source
	 * it wasn't even an implemented code it was just i didn't know i could just assign null.
	 */
	public AnyType dequeue(){
		AnyType Output = null;//sets the original output
		if(stackTwo.isEmpty()){//i check if stack two is empty
			while(!stackOne.isEmpty()){//and stack one is not empty
				stackTwo.push(stackOne.pop());//i technically pop all the elements of stack one onto stack two.
				//thus the last element that came into stack one becomes the first element inside stacktwo
				//so that the original first element that went INTO the QUEUE becomes the first element dequeued from the QUEUE
			}
		}
		if(!stackTwo.isEmpty()){//if stack two is not empty 
			Output = stackTwo.pop();//i dequeued the queue
			size--;//decrement the QUEUE size
		}
		return Output;//returns the dequeued element
	}
	@Override
	public boolean isEmpty(){
		return size == 0;//checks for is empty
	}
	@Override
	public int size(){
		return size;//checks for size of queue
	}
}