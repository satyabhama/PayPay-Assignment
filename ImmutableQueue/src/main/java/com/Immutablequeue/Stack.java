package main.java.com.Immutablequeue;


/**
 * Interface for an Immutable Stack (First-In-First-Out)
 * @author Satya
 * @param <T> generic type for the stack elements
 */
public interface Stack<T> {
	/**
	 * 
	 * @param element generic type for the elements of the stack
	 * @return the new stack after inserting the element to end of the stack
	 */
	
	public Stack<T> push(T element);
	/**
	 * 
	 * @return the new stack after removing last element from the stack 
	 */
	public Stack<T> pop() throws Exception;
	
	/**
     * 
     * @return the head element of the stack
     * @throws Exception when queue is empty
     */
	public T head() throws Exception;
	
	/**
    * 
    * @return true when stack is empty, otherwise return false
    */
	public boolean isEmpty();
}