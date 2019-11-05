package main.java.com.Immutablequeue;
/**
 * Immutable Queue concrete class.
 * 
 * forwards and backwards stack is used to keep track of the elements.
 * for enQueue elements backwards stack keeps track and for deQueued  elements forwards stack keeps track.
 * 
 * @author Satya
 *
 * @param <T> generic type elements for the queue 
 */
public final class ImmutableQueue<T> implements Queue<T>{
	
	private final Stack<T> backwards;
    private final Stack<T> forwards;
     
    private ImmutableQueue(Stack<T> forwards, Stack<T> backwards)
    {
        this.forwards = forwards;
        this.backwards = backwards;
    }
    
	public final Queue<T> enQueue(T element) throws Exception{
		return new ImmutableQueue<T>(forwards, backwards.push(element));
	}
	
	@SuppressWarnings("unchecked")
	public final Queue<T> deQueue() throws Exception{
		Stack<T> f = forwards.pop();

        if (!f.isEmpty()){
        	
            return new ImmutableQueue<T>(f, backwards);
        }
        else if (backwards.isEmpty()){
            return ImmutableQueue.getEmptyQueue();
        }
        else {
            return new ImmutableQueue<T>(ImmutableQueue.reverseStack(backwards), ImmutableStack.getEmptyStack());
        }
	}
    /**
     * Reverses the provided stack.
     * @param stack
     * @return
     * @throws Exception
     */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public final static Stack reverseStack(Stack stack) throws Exception
    {
        Stack r = ImmutableStack.getEmptyStack();
        while(!stack.isEmpty()){
        	r = r.push(stack.head());   
        	stack = stack.pop();
        }
      
        return r;
    }
	
	@SuppressWarnings({ "rawtypes" })
	public final static Queue getEmptyQueue(){
		return EmptyQueue.getInstance();
	}
	

	
	public final T head() throws Exception{
		return forwards.head();
	}
	
	public final boolean isEmpty(){
		return false;
	}
	
	/**
	 * Empty queue. This is a singleton.
	 * @param <T> generic type element
	 */
	private static final class EmptyQueue<T> implements Queue<T>{
		
		@SuppressWarnings("rawtypes")
		private final static EmptyQueue emptyQueue = new EmptyQueue();
		
		@SuppressWarnings("rawtypes")
		public final static EmptyQueue getInstance(){
			return emptyQueue;
		}
		
		@SuppressWarnings("unchecked")
		public final Queue<T> enQueue(T element){
			return new ImmutableQueue<T>(ImmutableStack.getEmptyStack().push(element), ImmutableStack.getEmptyStack());
		}
		
		public final Queue<T> deQueue() throws Exception{
			throw new Exception("Queue is empty.");
		}
		
		public final T head() throws Exception{
			throw new Exception("Queue is empty.");
		}
		
		public final boolean isEmpty(){
			return true;
		}
	}
}
