package prj5;

import java.util.Comparator;

import student.TestCase;

/**
 * Tests comparators from input
 * 
 * @author Griffin College
 * @author Swopnil Joshi
 * @version Jun 27, 2017
 **/
public class ComparatorTest extends TestCase
{
    private Comparator<Song> comparator;
    private Song s1;
    private Song s2;
    private Song s3;
    private Song s4;

    /**
     * Sets up tests
     */
    public void setUp()
    {
        s1 = new Song("Apple", "Apple", "Apple", 1);
        s2 = new Song("Banana", "Banana", "Banana", 2);
        s3 = new Song("Appler", "Appler", "Appler", 3);
        s4 = new Song("Apple", "Apple", "Apple", 1);
    }

    /**
     * Tests title comparator
     */
    public void testTitleComparator()
    {
        comparator = Input.comparatorTitle;
        assertEquals(0, comparator.compare(s1, s1));
        assertTrue(0 < comparator.compare(s2, s1));
        assertTrue(0 > comparator.compare(s1, s2));
        assertTrue(0 < comparator.compare(s3, s1));
        assertTrue(0 > comparator.compare(s1, s3));
        assertEquals(0, comparator.compare(s1, s4));
    }

    /**
     * Tests artist comparator
     */
    public void testArtistComparator()
    {
        comparator = Input.comparatorArtist;
        assertEquals(0, comparator.compare(s1, s1));
        assertTrue(0 < comparator.compare(s2, s1));
        assertTrue(0 > comparator.compare(s1, s2));
        assertTrue(0 < comparator.compare(s3, s1));
        assertTrue(0 > comparator.compare(s1, s3));
        assertEquals(0, comparator.compare(s1, s4));
    }

    /**
     * Tests genre comparator
     */
    public void testGenreComparator()
    {
        comparator = Input.comparatorGenre;
        assertEquals(0, comparator.compare(s1, s1));
        assertTrue(0 < comparator.compare(s2, s1));
        assertTrue(0 > comparator.compare(s1, s2));
        assertTrue(0 < comparator.compare(s3, s1));
        assertTrue(0 > comparator.compare(s1, s3));
        assertEquals(0, comparator.compare(s1, s4));
    }

    /**
     * Tests date comparator
     */
    public void testDateComparator()
    {
        comparator = Input.comparatorDate;
        assertEquals(0, comparator.compare(s1, s1));
        assertTrue(0 < comparator.compare(s2, s1));
        assertTrue(0 > comparator.compare(s1, s2));
        assertTrue(0 < comparator.compare(s3, s1));
        assertTrue(0 > comparator.compare(s1, s3));
        assertEquals(0, comparator.compare(s1, s4));
    }

    /**
     * Runs input.main
     */
    public void testMain()
    {
        Input.main(new String[]
        {
            "MusicSurveyData.csv", "SongList.csv"
        });
        assertEquals("Apple", s1.getTitle());
    }
}
