package prj5;

import student.TestCase;

/**
 * Tests Song class
 * 
 * @author Griffin College
 * @author Swopnil Joshi
 * @version Jun 21, 2017
 */
public class SongTest extends TestCase
{
    private Song song;

    /**
     * Sets up tests
     */
    public void setUp()
    {
        song = new Song("Test", "Testers", "Rock", 2017);
    }

    /**
     * Tests getTitle method
     */
    public void testGetTitle()
    {
        assertEquals("Test", song.getTitle());
    }

    /**
     * Tests getArtist method
     */
    public void testGetArtist()
    {
        assertEquals("Testers", song.getArtist());
    }

    /**
     * Tests getGenre method
     */
    public void testGetGenre()
    {
        assertEquals("Rock", song.getGenre());
    }

    /**
     * Tests getYear method
     */
    public void testGetYear()
    {
        assertEquals(2017, song.getYear());
    }

    /**
     * Tests setTitle method
     */
    public void testSetTitle()
    {
        song.setTitle("Boom Boom Pow");
        assertEquals("Boom Boom Pow", song.getTitle());
    }

    /**
     * Tests setArtist method
     */
    public void testSetArtist()
    {
        song.setArtist("Black Eyed Peas");
        assertEquals("Black Eyed Peas", song.getArtist());
    }

    /**
     * Tests setGenre method
     */
    public void testSetGenre()
    {
        song.setGenre("Pop");
        assertEquals("Pop", song.getGenre());
    }

    /**
     * Tests setYear method
     */
    public void testSetYear()
    {
        song.setYear(2008);
        assertEquals(2008, song.getYear());
    }
}
