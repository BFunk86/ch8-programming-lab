/**CSC 1600
 * Data Structures
 *
 * The ResizingQueueArrayBasedYoung class implements the QueueInterface class.
 *
 * @author Brandon Young
 */
// File Name: ResizingQueueArrayBasedYoung.java
public class ResizingQueueArrayBasedYoung implements QueueInterface{

    // Starting size of the Queue and size after the Array is resized
    private int queueSize = 10;
    private Object[] items;
    private int front, back, count;

    public ResizingQueueArrayBasedYoung() {
        items = new Object[queueSize];
        front = 0;
        back = queueSize - 1;
        count = 0;
    } // end default constructor

    @Override
    public boolean isEmpty() {
        return count == 0;
    } // end isEmpty

    /**
     * Checks to see if the Queue is full
     * Precondition: none
     * Post Condition: Returns true if the Queue is full, false otherwise.
     * @return (boolean): True if the Queue is full, false otherwise.
     */
    private boolean isFull() {
        return count == queueSize;
    } // end isFull

    /**
     * The resize method doubles the size of the current array. It adds the current items in the
     * array to their respective place in the array.
     * Precondition: None
     * Post Condition: doubles the current arrays size and all items stay at their current index
     */
    private void resize() {
        // creates a new array double the size of the original
        Object[] newArray = new Object[items.length * 2];
        // copies the contents of the old array to the new array
        for (int index = 0; index < items.length; index++) {
            newArray[index] = items[index];
        } // end for loop
        // changes the reference of the original array to the new array
        queueSize = items.length * 2;
        items = newArray;
    } // end resize

    @Override
    public void enqueue(Object newItem) {
        // if array is full resize the array
        if( isFull() ) {
            resize();
        } // end if
        back = (back + 1) % (queueSize);
        items[back] = newItem;
        ++count;
    } // end enqueue

    @Override
    public Object dequeue() throws QueueException {
        if( isEmpty() ) {
            throw new QueueException("QueueException on dequeue: " + "Queue empty");
        } else {
            Object queueFront = items[front];
            front = (front + 1) % (queueSize);
            --count;
            return queueFront;
        } // end if else
    } // end dequeue

    @Override
    public void dequeueAll() {
        // resets the Queue
        items = new Object[queueSize];
        front = 0;
        back = queueSize - 1;
        count = 0;
    } // end dequeueAll

    @Override
    public Object peek() throws QueueException {
        if( isEmpty() ) {
            throw new QueueException("QueueException on peek: " + "Queue empty");
        } else {
            return items[front];
        }
    } // end peek
} // end resizingQueueArrayBasedYoung
