package challenges.solution;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MyQueueTest {
    static MyQueue<Integer> myQueue;

    @BeforeAll
    public static void init() {
        myQueue = new MyQueue<>();
        myQueue.enqueue(2);
        myQueue.enqueue(3);
        myQueue.enqueue(4);
    }

    @Test
    public void should_peek_first_element() {
        Integer expectedElement = 2;

        Integer actualElement = myQueue.peek();

        assertThat(actualElement, is(expectedElement));
    }

    @Test
    public void should_dequeue_first_element() {
        Integer expectedElement = 2;

        Integer actualElement = myQueue.peek();

        assertThat(actualElement, is(expectedElement));
    }
}
