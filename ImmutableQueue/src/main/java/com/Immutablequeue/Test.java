package main.java.com.Immutablequeue;


/**
 * Test class for ImmutableQueue
 * @author Satya
 */
public class Test {

	@SuppressWarnings({ "unchecked" })
	public static void main(String[] args) {
		Queue<Integer> q = ImmutableQueue.getEmptyQueue();
		try{
				
			q = q.enQueue(5);
			printQueue(q);
			q = q.enQueue(10);
			printQueue(q);
			q = q.enQueue(20);
			printQueue(q);
			q = q.enQueue(30);
			printQueue(q);
			q = q.enQueue(60);
			printQueue(q);
			q = q.deQueue();
			printQueue(q);
			q = q.deQueue();
			printQueue(q);
			q = q.deQueue();
			printQueue(q);
			q = q.deQueue();
			printQueue(q);
			System.out.println("Is queue empty ? " + q.isEmpty());
			q = q.deQueue();
			System.out.println("Is queue empty ? " + q.isEmpty());
		}
		catch(Exception e){

			System.out.println("Exception occured: "+e);
		}
	}
	
	private static void printQueue(Queue<Integer> q) throws Exception{
		while(q != null && !q.isEmpty()){
			System.out.print(q.head() + "-->");
			q = q.deQueue();
		}
		System.out.println();
	}

}
