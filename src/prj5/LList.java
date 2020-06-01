package prj5;

/**
 * interface for a linked list methods needed are provided common methods may
 * not, because they are unneeded
 * 
 * @author Griffin College
 * @author Swopnil Joshi
 * @version Jun 21, 2017
 * @param <E>
 *            data type held by list
 */
public interface LList<E>
{

    /**
     * Gets the number of elements in the list
     *
     * @return the number of elements
     */
    public abstract int size();

    /**
     * Adds the object to the end of the list.
     *
     * @param obj
     *            the object to add
     */
    public abstract void add(E obj);

    /**
     * Checks if the array is empty
     *
     * @return if the array is empty
     */
    public abstract boolean isEmpty();

    /**
     * Gets the object at the given position
     *
     * @param index
     *            where the object is located
     * @return The object at the given position
     */
    public abstract E get(int index);

    /**
     * Checks if the list contains the given object
     *
     * @param obj
     *            the object to check for
     * @return true if it contains the object
     */
    public abstract boolean contains(E obj);

    /**
     * Removes all of the elements from the list
     *
     * @postcondition size = 0 and all of the nodes are removed
     */
    public abstract void clear();

    /**
     * Returns a string representation of the list If a list contains A, B, and
     * C, the following should be returned "{A, B, C}" (Without the quotations)
     *
     * @return a string representing the list
     */
    public abstract String toString();
}
