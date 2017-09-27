/*
 * Test for TwoStackQueue.java done by Ecclesiastes Gan
 * 2/20/2017
 */
public class Program2 {

	public static void main(String[] args) {
		TwoStackQueue<Integer> i = new TwoStackQueue<Integer>();
		TwoStackQueue<String> q = new TwoStackQueue<String>();
	
		i.enqueue(10);//ignoring the first enqueue as well for the same reason as the first dequeue.
		
		
		long StartTimeEnq = System.nanoTime();
		i.enqueue(20);
		long EndTimeEnq = System.nanoTime();
		long Duration = EndTimeEnq - StartTimeEnq;
		System.out.println(Duration);
		
		long StartTimeEnq1 = System.nanoTime();
		i.enqueue(300);
		long EndTimeEnq1 = System.nanoTime();
		long Duration1 = EndTimeEnq1 - StartTimeEnq1;
		System.out.println(Duration1);
		
		long stenq = System.nanoTime();
		i.enqueue(4000);
		long etenq = System.nanoTime();
		long d = etenq - stenq;
		System.out.println(d);
		
		long stenq1 = System.nanoTime();
		i.enqueue(4000);
		long etenq1 = System.nanoTime();
		long d1 = etenq1 - stenq1;
		System.out.println(d1);
		
		long stenq2 = System.nanoTime();
		i.enqueue(2);
		long etenq2 = System.nanoTime();
		long d2 = etenq2 - stenq2;
		System.out.println(d2);
		i.enqueue(1);
		
		i.dequeue();//ignoring the first dequeue timings because it is significantly more than what is normal of an O(N)
		
		long StartTimeDeq = System.nanoTime();
		i.dequeue();
		long EndTimeDeq = System.nanoTime();
		long DurationDeq = EndTimeDeq - StartTimeDeq;
		System.out.println("Dequeue: "+ DurationDeq);
		
		long StartTimeDeq1 = System.nanoTime();
		i.dequeue();
		long EndTimeDeq1 = System.nanoTime();
		long DurationDeq1 = EndTimeDeq1 - StartTimeDeq1;
		System.out.println("Dequeue: " + DurationDeq1);
		
		
		long StartTimeDeq2 = System.nanoTime();
		i.dequeue();
		long EndTimeDeq2 = System.nanoTime();
		long DurationDeq2 = EndTimeDeq2 - StartTimeDeq2;
		System.out.println("Dequeue: " + DurationDeq2);
		
		long StartTimeDeq3 = System.nanoTime();
		i.dequeue();
		long EndTimeDeq3 = System.nanoTime();
		long DurationDeq3 = EndTimeDeq3 - StartTimeDeq3;
		System.out.println("Dequeue: " + DurationDeq3);
		
		q.enqueue("Superman"); //first guy to queue for Macdonalds
		q.enqueue("Batman");
		q.enqueue("Flash");
		q.enqueue("Wonder Woman");
		q.enqueue("Green Lantern");
		
		q.enqueue("Iron Man");
		q.enqueue("Thor");
		q.enqueue("Hulk");
		q.enqueue("Captain Trump");
		q.enqueue("Black Widow");
		//total String enqueues 10
		//total String dequeues 10
		System.out.println("First guy to queue for Macdonalds, first guy to leave: " + q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		//test for dequeue empty queue
		System.out.println("I WILL PRINT NULL");
		long StartTimeNULL = System.nanoTime();
		System.out.println(q.dequeue());// should return null
		long endTimeNULL = System.nanoTime();
		long durationNULL = endTimeNULL - StartTimeNULL;
		System.out.println(durationNULL);
		
		/* The enqueue function reflects O(1)
		 * The dequeue function reflects O(1) WHEN there are items in the queue
		 * HOWEVER, the dequeue function reflects O(N) when there are NULL items in the queue
		 * Therefore the dequeue function is still O(N)
		 * THEREFORE THE OVERALL TIME COMPLEXITY OF THE QUEUE IS STILL O(N)
		 */
	}

}
