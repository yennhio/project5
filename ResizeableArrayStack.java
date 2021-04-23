import java.util.Arrays;
import java.util.EmptyStackException;

public class ResizeableArrayStack<T> implements StackInterface<T> {
    
    private T[] stack;
    private int topIndex;
    private boolean integrityOK = false;
    private static final int DEFAULT_CAPACITY = 50;
    private static final int MAX_CAPACITY = 10000;

    public ResizeableArrayStack() {
        this(DEFAULT_CAPACITY);
    } //default constructor

    public ResizeableArrayStack(int initialCapacity) {
        integrityOK = false;
        checkCapacity(initialCapacity);

            @SuppressWarnings("unchecked")
            T[] tempStack = (T[])new Object[initialCapacity];
            stack = tempStack;
            topIndex = -1;
            integrityOK = true;
    } //constructor

    /** Throws an exception if object is not initialized. */
    private void checkIntegrity() {
        if (!integrityOK) {
            throw new SecurityException("ArrayStack object is corrupt.");
        }
    }

    /** Throws an exception if the client requests a capacity that's too large. */
    private void checkCapacity(int capacity) {
        if (capacity > MAX_CAPACITY)
            throw new IllegalStateException("Attempt to create a stack" +
                                            " whose capacity exceeds " + MAX_CAPACITY);
    }

    /** Adds a new entry to the top of the stack
     * @param newEntry An object to be added
     */
    public void push(T newEntry) {
        checkIntegrity();
        ensureCapacity();
        stack[topIndex+1] = newEntry;
        topIndex++;
    }

    /** Doubles the array size if it's full. */
    private void ensureCapacity() {
        if (topIndex >= stack.length-1) {
            int newLength = 2 * stack.length;
            checkCapacity(newLength);
            stack = Arrays.copyOf(stack, newLength);
        }
    }

    /** Removes and returns the top entry
     * @return the object at the top of the stack
     * @throws EmptyStackException if the stack is empty before the operation.
     */
    public T pop() {
        checkIntegrity();
        if(isEmpty())
            throw new EmptyStackException();
        else {
            T top = stack[topIndex];
            stack[topIndex] = null;
            topIndex--;
            return top;
        }
    }

    /** Retrieves the top entry
     * @return The object at the top of the stack
     * @throws EmptyStackException if the stack is empty
     */
    public T peek() {
        checkIntegrity();
        if (isEmpty())
            throw new EmptyStackException();
        else
            return stack[topIndex];
    }

    /** Detects whether stack is empty
     * @return True if stack is empty
     */
    public boolean isEmpty() {
        return topIndex < 0;
    }

    /** Removes all entries from stack */
    public void clear() {
        checkIntegrity();

        //Removes references to the objects in the stack
        //but does not deallocate the array
        while (topIndex > -1) {
            stack[topIndex] = null;
            topIndex--;
        }
    } //assertion: topIndex is -1

    @Override
    public int getPrecedence(char order) {
        return 0;
    }

}
