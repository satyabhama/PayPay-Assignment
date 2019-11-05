package main.java.com.Immutablequeue;


/**
 * Immutable Stack class which implements all methods of Stack interface(concrete class).
 * 
 * @author Satya
 *
 * @param <T> generic type elements of the stack
 */
public final class ImmutableStack<T> implements Stack<T>{
	
	private final T head;
	private final Stack<T> tail;
	
	private ImmutableStack(T head, Stack<T> tail){
		this.head = head;
		this.tail = tail;
	}
	
	public final Stack<T> push(T element){		
		return new ImmutableStack<T>(element, this);
	}
	
	public final Stack<T> pop(){
		return tail;
	}
	
	public final T head(){
		return head;
	}
	
	public final boolean isEmpty(){
		return false;
	}
	 
	@SuppressWarnings("rawtypes")
	public final static Stack getEmptyStack(){
		return EmptyStack.getInstance();
	}
	
	/**
	 * This is a singleton class for empty stack.
	 * 
	 * @author Satya
	 *
	 * @param <T> generic type 
	 */
	private static final class EmptyStack<T> implements Stack<T>{
		
		@SuppressWarnings("rawtypes")
		private final static EmptyStack emptyStack = new EmptyStack();
		
		@SuppressWarnings("rawtypes")
		public final static EmptyStack getInstance(){
			return emptyStack;
		}
		
		public final Stack<T> push(T element){			
			return new ImmutableStack<T>(element, this);
		}
		
		public final Stack<T> pop() throws Exception{
			throw new Exception("Stack is empty.");
		}
		
		public final T head() throws Exception{
			throw new Exception("Stack is empty.");
		}
		
		public final boolean isEmpty(){
			return true;
		}
	}
}

