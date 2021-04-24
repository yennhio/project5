import java.util.Iterator;
import java.util.NoSuchElementException;


public class LinkedListWithIterator<T> implements ListWithIteratorInterface<T>
{
    private Node firstNode; // Head reference to first node 
    private Node lastNode; // Tail reference to last node 
    private int numberOfEntries;

   public LinkedListWithIterator()
   {
      initializeDataFields();
   } // end default constructor

   public void clear() {
       initializeDataFields();
   }

   private void initializeDataFields() {
    firstNode = null; 
    lastNode = null; 
    numberOfEntries = 0;
    } // end initializeDataFields

   private Node getNodeAt(int givenPosition)
    {
    // Assertion: (firstNode != null) &&
    // (1 <= givenPosition) && (givenPosition <= numberOfNodes)
 
        Node currentNode = firstNode;
    // Traverse the chain to locate the desired node
    // (skipped if givenPosition is 1)
        for (int counter = 1; counter < givenPosition; counter++)
            currentNode = currentNode.getNextNode(); // Assertion: currentNode != null
        return currentNode;
    } // end getNodeAt

    public int getLength() {
        return numberOfEntries;
    }
    public void add(int givenPosition, T newEntry) {
        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries + 1)) {
            Node newNode = new Node(newEntry); 
            if (isEmpty())
            {
                firstNode = newNode;
                lastNode = newNode; }
            else if (givenPosition == 1) {
                newNode.setNextNode(firstNode);
                firstNode = newNode; }
            else if (givenPosition == numberOfEntries + 1) {
                lastNode.setNextNode(newNode);
                lastNode = newNode; }
            else
            {
                Node nodeBefore = getNodeAt(givenPosition - 1); 
                Node nodeAfter = nodeBefore.getNextNode(); 
                newNode.setNextNode(nodeAfter); 
                nodeBefore.setNextNode(newNode);
        } // end if
        numberOfEntries++; }
        else
            throw new IndexOutOfBoundsException(
            "Illegal position given to add operation.");
        } // end add
        

    public void add(T newEntry) {
        Node newNode = new Node(newEntry); 
        if (isEmpty())
            firstNode = newNode;
        else
            lastNode.setNextNode(newNode); 
            lastNode = newNode; numberOfEntries++;
    } // end add

    public boolean isEmpty() {
        boolean result;
        if (numberOfEntries == 0) 
        // Or getLength() == 0 
        {
        // Assertion: firstNode == null
            result = true; 
        }
        else
        {
            // Assertion: firstNode != null
            result = false; 
        } // end if
        return result;
    }

    public T[] toArray() {
        // The cast is safe because the new array contains null entries
        @SuppressWarnings("unchecked")
        T[] result = (T[])new Object[numberOfEntries]; 
        int index = 0;
        Node currentNode = firstNode;
        while ((index < numberOfEntries) && (currentNode != null)) {
            result[index] = currentNode.getData(); 
            currentNode = currentNode.getNextNode(); index++;
        } // end while
        return result; 
    } // end toArray

    public T remove(int givenPosition) {
        T result = null; // Return value
        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
        // Assertion: !isEmpty()
           if (givenPosition == 1) {
                result = firstNode.getData(); 
                firstNode = firstNode.getNextNode(); 
                
                if (numberOfEntries == 1) 
                lastNode = null;
        // Case 1: Remove first entry // Save entry to be removed
        // Solitary entry was removed
        // Case 2: Not first entry
        }
        else
        {
        Node nodeBefore = getNodeAt(givenPosition - 1); 
        Node nodeToRemove = nodeBefore.getNextNode(); 
        Node nodeAfter = nodeToRemove.getNextNode(); 
        nodeBefore.setNextNode(nodeAfter);
        result = nodeToRemove.getData();
        if (givenPosition == numberOfEntries)
        lastNode = nodeBefore; } // end if
        numberOfEntries--; }
        else
        throw new IndexOutOfBoundsException(
        "Illegal position given to remove operation.");
        return result; // Return removed entry 
    } // end remove

    public T replace(int givenPosition, T newEntry) {
        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
        // Assertion: !isEmpty()
            Node desiredNode = getNodeAt(givenPosition); 
            T originalEntry = desiredNode.getData(); 
            desiredNode.setData(newEntry);
            return originalEntry;
        }
        else
            throw new IndexOutOfBoundsException(
            "Illegal position given to replace operation.");
    } // end replace

    public T getEntry(int givenPosition) {
        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
            // Assertion: !isEmpty()
                return getNodeAt(givenPosition).getData(); 
            }
        else
                throw new IndexOutOfBoundsException(
                "Illegal position given to getEntry operation."); 
        } // end getEntry

        public boolean contains(T anEntry) {
            boolean found = false;
            Node currentNode = firstNode;
            while (!found && (currentNode != null)) {
                if (anEntry.equals(currentNode.getData())) 
                    found = true;
                else
                    currentNode = currentNode.getNextNode(); } // end while
            return found; } // end contains
   
   public Iterator<T> iterator()
   {
	   return new IteratorForLinkedList();
   } // end iterator

	public Iterator<T> getIterator()
	{
	   return iterator();
	} // end getIterator
   
	private class IteratorForLinkedList implements Iterator<T>
	{
      private Node nextNode;

		private IteratorForLinkedList()
		{
			nextNode = firstNode;
		} // end default constructor
		
        public T next() {
            T result;
            if (hasNext()) {
            result = nextNode.getData(); 
            nextNode = nextNode.getNextNode();
            // Advance iterator
            }
            else
                throw new NoSuchElementException("Illegal call to next(); " +
                "iterator is after end of list."); return result; // Return next entry in iteration
            } // end next

            public boolean hasNext() {
                return nextNode != null; 
            } // end hasNext
	} // end IteratorForLinkedList
	
	private class Node
	{
      private T    data; // Entry in list
      private Node next; // Link to next node
      
      private Node(T dataPortion)
      {
         data = dataPortion;
         next = null;
      } // end constructor
      
      private Node(T dataPortion, Node nextNode)
      {
         data = dataPortion;
         next = nextNode;
      } // end constructor
      
      private T getData()
      {
         return data;
      } // end getData
      
      private void setData(T newData)
      {
         data = newData;
      } // end setData
      
      private Node getNextNode()
      {
         return next;
      } // end getNextNode
      
      private void setNextNode(Node nextNode)
      {
         next = nextNode;
      } // end setNextNode
	} // end Node
} // end LinkedListWithIterator



