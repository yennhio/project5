public class ArrayQueue<T> implements QueueInterface<T> {
    private T[] queue;
    private int frontIndex;
    private int backIndex;
    private boolean integrityOK;
    private static final int DEFAULT_CAPACITY = 3;
    private static final int MAX_CAPACITY = 10000;

    public ArrayQueue() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayQueue(int initialCapacity) {
        integrityOK = false;
        ensureCapacity(initialCapacity);

        @SuppressWarnings("unchecked")
        T[] tempQueue = (T[]) new Object[initialCapacity + 1];
        queue = tempQueue;
        frontIndex = 0;
        backIndex = initialCapacity;
        integrityOK = true;
    }

    private void checkCapacity() {

    }
    
    public void enqueue(T newEntry) {
        checkIntegrity();
        ensureCapacity();   
        backIndex = (backIndex + 1) % queue.length;
        queue[backIndex] = newEntry;     
    }

    private void ensureCapacity() {
        if (frontIndex == ((backIndex + 2) % queue.length)) {
            T[] oldQueue = queue;
            int oldSize = oldQueue.length;
            int newSize = 2 * oldSize;
            checkCapacity(newSize);
            integrityOK = false;

            @SuppressWarnings("unchecked")
            T[] tempQueue = (T[]) new Object[newSize];
            queue = tempQueue;
            for (int index = 0; index < oldSize - 1; index++) {
                queue[index] = oldQueue[frontIndex];
                frontIndex = (frontIndex + 1) % oldSize;
            }
            frontIndex = 0;
            backIndex = oldSize - 2;
            integrityOK = true;
        }
    }

    private void checkIntegrity() {
    }

    public T dequeue() {
        checkIntegrity();
        if (isEmpty())
            throw new EmptyQueueException();
        else {
            T front = queue[frontIndex];
            queue[frontIndex] = null;
            frontIndex = (frontIndex + 1 % queue.length);
            return front;
        }
    }

    public T getFront() {
        checkIntegrity();
        if (isEmpty())
            throw new EmptyQueueException();
        else
            return queue[frontIndex];
    }

    public boolean isEmpty() {
        checkIntegrity();
        return frontIndex == ((backIndex + 1) % queue.length);
    }

    public void clear() {
        checkIntegrity();   
        if (!isEmpty()) {
            for (int index = frontIndex; index != backIndex; index = (index + 1) % queue.length) {
                queue[index] = null;
            }
            queue[backIndex] = null;
        }  
        frontIndex = 0;
        backIndex = queue.length - 1;   
    }

}