/**
 * 
 */
package prj5;

import java.util.Comparator;

/**
 * Linked list data structure
 * 
 * @author Griffin College
 * @author Swopnil Joshi
 * @version Jun 21, 2017
 * @param <E>
 *            data type held by list
 */
public class LinkedList<E> implements LList<E>
{

    /**
     * An inner node class
     * 
     * @author Griffin College
     * @author Swopnil Joshi
     * @version Jun 28, 2017
     */
    private class Node<D>
    {

        // The data element stored in the node.
        private D data;

        // The next node in the sequence.
        private Node<D> next;

        /**
         * Creates a new node with the given data
         *
         * @param d
         *            data for node
         */
        public Node(D d)
        {
            data = d;
        }

        /**
         * Sets the node after this node
         *
         * @param n
         *            the node after this one
         */
        public void setNext(Node<D> n)
        {
            next = n;
        }

        /**
         * Gets the next node
         *
         * @return the next node
         */
        public Node<D> next()
        {
            return next;

        }

        /**
         * Gets the data in the node
         *
         * @return the data in the node
         */
        public D getData()
        {
            return data;
        }

        /**
         * Sets the data in the node
         * 
         * @param data
         *            the new data
         */
        public void setData(D data)
        {
            this.data = data;
        }
    }

    // the head of the linked list
    private Node<E> head;

    // the size of the linked list
    private int size;

    // Comparator for sorts
    private Comparator<? super E> comparator;

    /**
     * the constructor for the linked list
     */
    public LinkedList()
    {
        head = null;
        size = 0;
    }

    /**
     * size accessor
     * 
     * @return size of list
     */
    @Override
    public int size()
    {
        return size;
    }

    /**
     * adds to the linked list
     */
    @Override
    public void add(E obj)
    {
        Node<E> newNode = new Node<>(obj);

        newNode.setNext(head);
        head = newNode;
        size++;
    }

    /**
     * checks if the list is empty
     * 
     * @return true if it is empty
     */
    @Override
    public boolean isEmpty()
    {
        return (size == 0);
    }

    /**
     * gets an object at a specific index
     * 
     * @return data in node
     */
    @Override
    public E get(int index)
    {
        Node<E> current = head;

        for (int i = 0; i < index; i++)
        {
            current = current.next();
        }

        return current.getData();
    }

    /**
     * checks if the list contains an object
     * 
     * @return true if the list contains it
     */
    @Override
    public boolean contains(Object obj)
    {
        Node<E> current = head;
        while (current != null)
        {
            if (obj.equals(current.data))
            {
                return true;
            }
            current = current.next();
        }

        return false;
    }

    /**
     * clears the list
     */
    @Override
    public void clear()
    {
        head = null;
        size = 0;

    }

    /**
     * gets the node at a specific index
     * 
     * @param index
     *            of node desired
     * @return the node
     */
    private Node<E> getNodeAt(int index)
    {
        Node<E> current = head;

        for (int i = 0; i < index; i++)
        {
            current = current.next();
        }

        return current;
    }

    /**
     * sets list comparison object
     * 
     * @param comp
     *            desired comparator
     */
    public void setComparator(Comparator<? super E> comp)
    {
        comparator = comp;
    }

    /**
     * a sort method using a variation of insertion sort
     */
    public void sortList()
    {
        E temp;

        for (int i = 1; i < this.size(); i++)
        {
            int j = i - 1;
            while (j >= 0 && comparator.compare(get(j), (get(i))) > 0)
            {
                temp = get(i);
                this.getNodeAt(i).setData(get(j));
                this.getNodeAt(j).setData(temp);
                i = j;
                j--;
            }
        }
    }
}
