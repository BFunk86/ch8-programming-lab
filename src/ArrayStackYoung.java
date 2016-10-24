/**CSC 1600 Data Structures
 * CH2 Programming Lab
 *
 * The ArrayStackYoung Class implements the ADT Stack by using an Array Stack to
 * contain its entities.
 *
 * @author Brandon Young
 */
// File Name: ArrayStackYoung.java
public class ArrayStackYoung<T> implements StackInterface<T>{

    // The size of the beginning stack
    final int STACK_START = 5;
    private Object[] items;
    private int top;

    /**
     * Default constructor for the ArrayStackYoung Class
     */
    public ArrayStackYoung() {
        items = new Object[STACK_START];
        top = items.length;
    } // end default constructor

    /**
     * Checks to see if the stack is full
     * Precondition: None
     * Post Condition: returns true if items is full and false if not
     * @return (boolean) true if the array is full, false otherwise.
     */
    private boolean isFull() {
        return top == 0;
    } // end isFull

    /**
     * Resize the array to double its original size. Adds the current items in the array
     * to the end of the new array.
     * Precondition: none
     * Post condition: returns a new array double the size with the items in the array at the end.
     */
    private void resize() {
        // creates a new Array double the size of the original
        Object[] newArray = new Object[items.length * 2];
        // copies the contents of the array to the end of the newArray
        for (int index = items.length - 1; index >= 0; index--) {
            newArray[index] = items[index];
        } // end for loop
        // set items to newArray
        items = newArray;
        // sets top to the top item in the stack again
        top = items.length / 2;
    } // end resize

    @Override
    public void push(T newEntry) {
        // check to see if stack is full if so resize stack
        if ( isFull() ) {
            resize();
        } // end if
        // push's newEntry to the stack and updates top
        items[--top] = newEntry;
    } // end push

    @Override
    public T pop() {
        if ( isEmpty() ) {
            return null;
        } else {
            // returns the item at the top while also updating top
            return (T) items[top++];
        } // end if else
    } // end pop

    @Override
    public T peek() {
        if ( isEmpty() ) {
            return null;
        } else {
            // retrieves the top item, but does not remove it
            return (T) items[top];
        } // end if else
    } // end peek

    @Override
    public boolean isEmpty() {
        return top == items.length;
    } // end isEmpty

    @Override
    public void clear() {
        // resets the stack
        items = new Object[STACK_START];
        top = items.length;
    } // end clear
} // end ArrayStackYoung
