package main.java.com.Immutablequeue;


/**
 * Interface for an Immutable Queue (First-In-First-Out)
 * @author Satya
 * @param <T> generic type queue elements
 */
public interface Queue<T> {

	/**
	 * @param element generic type for the elements of the queue
	 * @return the new queue after inserting the element to the beginning of the queue
	 * @throws Exception 
	 */
	public Queue<T> enQueue(T element) throws Exception;

	/**
	 * @return the new queue after removing the element from the beginning of the queue
	 */
	public Queue<T> deQueue() throws Exception;

	/**
	 * @return the head element of the queue
	 * @throws Exception when queue is empty
	 */
	public T head() throws Exception;

	/**
	 * @return true when queue is empty, otherwise return false
	 */
	public boolean isEmpty();
}
