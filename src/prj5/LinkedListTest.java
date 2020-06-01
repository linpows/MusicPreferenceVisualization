/**
 * 
 */
package prj5;

import java.util.Comparator;

import student.TestCase;

/**
 * @author Griffin College
 * @author Swopnil Joshi
 * @version Jun 27, 2017
 */
public class LinkedListTest extends TestCase
{
    private LinkedList<String> list;
    private LinkedList<String> emptyList;

    /**
     * Initializes all variables for testing a linked list
     */
    public void setUp()
    {
        list = new LinkedList<String>();
        for (int i = 0; i < 5; i++)
        {
            list.add(Integer.toString(i));
        }
        emptyList = new LinkedList<String>();
    }

    /**
     * tests adding an object
     */
    public void testAdd()
    {
        emptyList.add("Test");
        assertEquals("Test", emptyList.get(0));
    }

    /**
     * tests clearing the list
     */
    public void testClear()
    {
        list.clear();
        assertTrue(list.isEmpty());
    }

    /**
     * tests whether the list contains an object
     */
    public void testContains()
    {
        assertTrue(list.contains("0"));
        assertFalse(list.contains("6"));

    }

    /**
     * tests getting data from list
     */
    public void testGet()
    {
        assertEquals("4", list.get(0));

    }

    /**
     * tests whether list is empty
     */
    public void testIsEmpty()
    {
        assertTrue(emptyList.isEmpty());
        assertFalse(list.isEmpty());
    }

    /**
     * tests setting the list comparator
     */
    public void testSetComparator()
    {
        list.setComparator(new StringComparator());
        list.sortList();
        assertEquals("0", list.get(0));
    }

    /**
     * tests getting the size of the linked list
     */
    public void testSize()
    {
        assertEquals(5, list.size());

    }

    /**
     * tests sorting the list
     */
    public void testSortList()
    {
        list.setComparator(new StringComparator());
        list.sortList();
        assertEquals("0", list.get(0));
    }

    /**
     * Tests comparator
     */
    public void testCompare()
    {
        String s1 = "Apple";
        String s2 = "Banana";
        String s3 = "Appler";
        String s4 = "Apple";
        assertEquals(0, new StringComparator().compare(s1, s1));
        assertTrue(0 < new StringComparator().compare(s2, s1));
        assertTrue(0 > new StringComparator().compare(s1, s2));
        assertTrue(0 < new StringComparator().compare(s3, s1));
        assertTrue(0 > new StringComparator().compare(s1, s3));
        assertEquals(0, new StringComparator().compare(s1, s4));
    }

    /**
     * a private comparator for strings used only for testing
     * 
     * @author Griffin College
     * @version Jun 28, 2017
     */
    private class StringComparator implements Comparator<String>
    {

        /**
         * Compares two strings alphabetically
         * 
         * @return 0 if strings are the same, positive if s1 comes before s2,
         *         negative if s1 comes after s2
         */
        public int compare(String s1, String s2)
        {
            if (s1.equals(s2))
            {
                return 0;
            }

            for (int i = 0; i < s1.length() && i < s2.length(); i++)
            {
                if (s1.charAt(i) != (s2.charAt(i)))
                {
                    return s1.charAt(i) - s2.charAt(i);
                }
            }

            return s1.length() - s2.length();
        }
    }
}
