/*
 * MyStack Class created by Ecclesiastes Gan 2/17/2017
 */
public class MyStack<AnyType> implements Stack<AnyType>{
	private Node topOfStack;
	private int size;
	private AnyType top;

private class Node {
	AnyType data;//stores the DATA DUH
	Node next; //pushes to next node
}
	
	public MyStack(){
		topOfStack = null;//sets head of list to null
		 size = 0;//size track to 0
	}
	@Override
	public void push(AnyType data){
		Node previousHead = topOfStack ;//pushes the original head back
		topOfStack = new Node();//so now the top of the stack is this new node
		topOfStack.data = data;//assign the node with the new data
		topOfStack.next = previousHead;//assigns head.next as the original head that got pushed to the btm
		size++;//increment size
	}
	@Override
	public AnyType pop(){
		if(isEmpty())
		{
			System.out.println("Stack underflow");
			System.exit(0);
		}
			top = topOfStack.data;//get the top
			topOfStack = topOfStack.next;//go next
			size --;//decrement size
			return top;//pop the top
		
		
	}//end of pop
	@Override
	public int size(){
		return size;//checks size DUH
	}
	@Override
	public boolean isEmpty(){
		return (size == 0);//checks for system underflow
	}
	@Override
	public AnyType peek(){
		top = topOfStack.data;
		return top;
	}
	

}
