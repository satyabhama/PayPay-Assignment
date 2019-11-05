import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import main.java.com.Immutablequeue.ImmutableQueue;
import main.java.com.Immutablequeue.Queue;

/**
 * 
 */

/**
 * Immutable queue Test class
 * @author Satya
 *
 */
public class ImmutableQueueTest {

	/**
	 * @throws java.lang.Exception
	 */
	private Queue<Integer> queue ;
	
	@Rule
    public ExpectedException thrown = ExpectedException.none();
 
	 
	@SuppressWarnings("unchecked")
	@Before	
	public void init()
	{
		queue = ImmutableQueue.getEmptyQueue();
	}

	@Test
	public void testIsEmptyOnEmpty() {
		assertTrue(queue.isEmpty());
	}
	@Test
	public void testIsEmptyOnNonEmpty() throws Exception {
		queue=queue.enQueue(5);
		assertFalse(queue.isEmpty());
	}
	
	@Test
	public void testOneEnqueue() throws Exception {
		queue=queue.enQueue(5);
		assertTrue(5==queue.head());
	}
	
	@Test
	public void testOneDequeue() throws Exception {
		queue=queue.enQueue(5);
		queue = queue.enQueue(10);
		queue=queue.deQueue();
		assertTrue(10==queue.head());
	}
	
	@Test
	public void testEnqueueDequeue() throws Exception {
		queue=queue.enQueue(5);
		queue=queue.enQueue(15);
		queue=queue.deQueue();
		queue=queue.enQueue(25);
		assertTrue(15==queue.head());
	}
	
    @Test
    public void throwsExceptionWhenQueueIsEmpty() throws Exception {
        thrown.expectMessage("Queue is empty.");
        queue.deQueue();
    }
    
    @Test
	public void throwsExceptionWhenQueueIsEmptyWithOperations() throws Exception {
        thrown.expectMessage("Queue is empty.");
		queue=queue.enQueue(5);
		queue=queue.enQueue(15);
		queue=queue.deQueue();
		queue=queue.enQueue(25);
		queue=queue.deQueue();
		queue=queue.deQueue();
		queue=queue.deQueue();
	}
}
