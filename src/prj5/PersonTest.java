package prj5;

import student.TestCase;

/**
 * Tests Person Class
 * 
 * @author Griffin College griffc1
 * @author Swopnil Joshi linpows
 * @version Jun 21, 2017
 */
public class PersonTest extends TestCase
{
    private Person person;

    /**
     * Sets up tests
     */
    public void setUp()
    {
        person = new Person(HobbyEnum.MUSIC, MajorEnum.CS, StateEnum.NORTHEAST);
    }

    /**
     * Tests getHobby method
     */
    public void testGetHobby()
    {
        assertEquals(HobbyEnum.MUSIC, person.getHobby());
    }

    /**
     * Tests getMajor method
     */
    public void testGetMajor()
    {
        assertEquals(MajorEnum.CS, person.getMajor());
    }

    /**
     * Tests getState method
     */
    public void testGetState()
    {
        assertEquals(StateEnum.NORTHEAST, person.getState());
    }

    /**
     * Tests setHobby method
     */
    public void testSetHobby()
    {
        person.setHobby(HobbyEnum.ARTS);
        assertEquals(HobbyEnum.ARTS, person.getHobby());
    }

    /**
     * Tests setMajor method
     */
    public void testSetMajor()
    {
        person.setMajor(MajorEnum.MCMDA);
        assertEquals(MajorEnum.MCMDA, person.getMajor());
    }

    /**
     * Tests setState method
     */
    public void testSetState()
    {
        person.setState(StateEnum.OUTSIDE);
        assertEquals(StateEnum.OUTSIDE, person.getState());
    }
}
