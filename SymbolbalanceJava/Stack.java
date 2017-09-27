/*
* Stack Interface editted by Ecclesiastes Gan
*  UNI efg2123
*/
public interface Stack <T> {
	
	public void push(T data);
	
	public T pop();
	
	public int size();
	
	public boolean isEmpty();
	
	public T peek();
}
