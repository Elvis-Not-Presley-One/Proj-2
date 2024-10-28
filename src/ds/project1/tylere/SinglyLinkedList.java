
package ds.project1.tylere;

/**
 *
 * @author Tyler
 * @param <E>
 */
public class SinglyLinkedList<E> //implements Comparable
{
     private Node<E> head;
    private Node<E> tail;
    private int numElements;

    /**
     * The SinglyLinkedList() constructor gets the inputs and sets them to the
     * private attributes
     *
     */
    public SinglyLinkedList() 
    {
        head = null;
        tail = null;
        numElements = 0;
    }

    /**
     * The getSize() method gets the size of the bag
     *
     * @return the size of the bag
     */
    public int getSize()
    {
        //return the # of el
        return numElements;
    }

    /**
     * the appendList() method appends to the end of the list
     *
     * @param newElement the new obj that is being added to the list
     */
     @SuppressWarnings("Convert2Diamond")
    public void appendList(E newElement) 
    {
        // if tail is null, list must be empty 
        if (tail == null) 
        {
            // create a new head and set the tail to the head since only 1 
            //element
            head = new Node<E>(newElement, null);
            tail = head;
        } 
        else 
        {
            // else set prev and cursor to the start of the list 
            Node<E> cursor = head;
            Node<E> previous = null; 
            boolean found = false;
            
            
            LooneyTunesCharacters newCharacter = (LooneyTunesCharacters) newElement;
            
            // while cursor does not reach to or not found 
            while (cursor != null && !found)
            {
            // find the obj of the data where cursor is 
             LooneyTunesCharacters currentCharacter = (LooneyTunesCharacters) cursor.getData();
             
             //compare the obj if its greater than 0 it must be equal to 
             // or greater then the prev obj in the list also finds where 
             //it belongs in the list 
                if (currentCharacter.compareTo(newCharacter) > 0)
                {
                    // if the correct spot is found stop going through the list 
                   found = true; 
                }
                
                // else move previous and cursor to the next node 
                previous = cursor;
                cursor = cursor.getNext();
                
            }
                        
            // if theres nothing create a new head/ adding ahead of head 
            if (previous == null)
            {
                head = new Node<E>(newElement, cursor);
            }
            
            else 
            {
                //esle set set the next node 
                previous.setNext(new Node<E>(newElement, cursor));
            }
            
            
            if (cursor == null)
            {
                // if adding to the end create a new tail 
                tail = new Node<E>(newElement, cursor);
            }
 
        }
        //# of elements must go up 
        numElements++;
    }

    /**
     * The prependList() method adds to the beginning of the list
     *
     * @param newElement the new obj that is being added to the list
     */
    /*
    public void prependList(E newElement) 
    {
        //add new node infornt of the head and make it the new head
        head = new Node<E>(newElement, head);
        numElements++;
    }
*/
    /**
     * the exists() method checks to see if an element exists in the bag
     *
     * @param target element that is being looked for
     * @return if the target was found
     */
    public boolean exists(E target) 
    {
        boolean found = false;
        Node<E> cursor = head;

        //march through list until its gone or found 
        while (cursor != null && !found) 
        {
            //.equals() since its obj being passed
            if (cursor.getData().equals(target))
            {
                //if the cursor pos = target stop since we found if item exists
                found = true;
            } 
            else 
            {
                // else move the cursor to the next node 
                cursor = cursor.getNext();
            }

        }
        return found;
    }

    /**
     * The countOccurences() method counts how many times an occurences happens
     *
     * @param target element that is being looked for
     * @return numOccur, number of occurences
     */
    public int countOccurences(E target)
    {
        int numOccur = 0;
        Node<E> cursor = head;

        //while cursor is not past the tail 
        while (cursor != null) 
        {
            //use .equals() since its obj being passed 
            if (cursor.getData().equals(target)) 
            {
                //if cursor equals data # of occur must go up 
                numOccur++;
            }
            //move to the next node untill empty 
            cursor = cursor.getNext();
        }

        return numOccur;
    }

    /**
     * The remove() method removes an element form the list
     *
     * @param target element that wanted to be removed
     * @return found, if the element was found
     */
    public boolean remove(E target)
    {
        Node<E> cursor = head, previous = null;
        boolean found = false;

        //go through list untill its found or end of the list 
        while (cursor != null && !found)
        {
            //use .equals since obj being passed 
            if (cursor.getData().equals(target))
            {
                //if target is found stop the loop 
                found = true;
            } 
            else
            {
                //move previous to cursor pos and move cursor to the next el
                previous = cursor;
                cursor = cursor.getNext();
            }
            //if its found but not at the end of the list 
            if (found && cursor != null) 
            {
                // if previous is the head 
                if (previous == null) 
                {
                    //move the head to the next thing 
                    head = head.getNext();
                } 
                else 
                {
                    //set the previous to ahead of the cursor 
                    previous.setNext(cursor.getNext());
                }
                //if at the tail/end of the list 
                if (tail == cursor) 
                {
                    //set the tail to the previous 
                    tail = previous;
                }
                //removing el so it must go down 
                numElements--;
            }
        }

        return found;
    }

    /**
     * the iteratorPrototype method "copies" the linked list and passes the
     * copied linked list to a new Lister<E>
     *
     * @return a Lister<E> using a copy of the linked list
     */
    public Lister<E> iterator() 
    {
        // declare variables
        Node headOfListToReturn; // beginning of new "copied" list
        Node cursorOfListToCopy; // active node of list to copy
        Node lastNodeOfListToReturn; // end of new "copied" list

        // establish the copied list
        headOfListToReturn = null;

        if (head != null) 
        {
            // create the head of the new list
            headOfListToReturn = new Node(head.getData(), null);
            // use lastNodeOfListToReturn as a pointer to the last node in the copied list
            lastNodeOfListToReturn = headOfListToReturn;
            // use currentCursor as the pointer to the existing list
            cursorOfListToCopy = head.getNext();
            // if we have a node...
            while (cursorOfListToCopy != null) 
            {
                // create a new node from the end of the new list
                lastNodeOfListToReturn.setNext(new Node(cursorOfListToCopy.getData(), null));
                // move lastNodeOfListToReturn to the new last node
                lastNodeOfListToReturn = lastNodeOfListToReturn.getNext();
                // move the cursorOfListToCopy to the next node
                cursorOfListToCopy = cursorOfListToCopy.getNext();
            }
        }

        return new Lister(headOfListToReturn);
    }
}
