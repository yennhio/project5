
public interface StackInterface<T> {

    /** Adds a new entry to the top of the stack
     * @param newEntry An object to be added
     */
    public void push(T newEntry);

    /** Removes and returns the top entry
     * @return the object at the top of the stack
     * @throws EmptyStackException if the stack is empty before the operation.
     */
    public T pop();

    /** Retrieves the top entry
     * @return The object at the top of the stack
     * @throws EmptyStackException if the stack is empty
     */
    public T peek();

    /** Detects whether stack is empty
     * @return True if stack is empty
     */
    public boolean isEmpty();

    /** Removes all entries from stack */
    public void clear();


    /** Gets precedence of operators in the infix expression
     * @param order The operator character being evaluated
     * @return 0,1,2 or 3 depending on the precedence of the operator
     */
    public int getPrecedence(char order);


}