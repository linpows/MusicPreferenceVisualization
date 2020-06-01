package prj5;

import java.util.ArrayList;

/**
 * Class for reach person who took the survey
 * 
 * @author Griffin College griffc1
 * @author Swopnil Joshi linpows
 * @version Jun 21, 2017
 */
public class Person
{
    /**
     * Person's answers to survey
     */
    public ArrayList<String> surveyAnswers;

    private HobbyEnum hobby;
    private MajorEnum major;
    private StateEnum state;

    /**
     * Contstructor for Person
     * 
     * @param hobby
     *            the person's hobby
     * @param major
     *            the person's major
     * @param state
     *            the person's location
     */
    public Person(HobbyEnum hobby, MajorEnum major, StateEnum state)
    {
        this.hobby = hobby;
        this.major = major;
        this.state = state;
        surveyAnswers = new ArrayList<>();
    }

    /**
     * Accessor for hobby
     * 
     * @return hobby
     */
    public HobbyEnum getHobby()
    {
        return hobby;
    }

    /**
     * Accessor for major
     * 
     * @return major
     */
    public MajorEnum getMajor()
    {
        return major;
    }

    /**
     * Accessor for state
     * 
     * @return state
     */
    public StateEnum getState()
    {
        return state;
    }

    /**
     * Mutator for hobby
     * 
     * @param hobby
     *            new hobby
     */
    public void setHobby(HobbyEnum hobby)
    {
        this.hobby = hobby;
    }

    /**
     * Mutator for major
     * 
     * @param major
     *            new major
     */
    public void setMajor(MajorEnum major)
    {
        this.major = major;
    }

    /**
     * Mutator for state
     * 
     * @param state
     *            new state
     */
    public void setState(StateEnum state)
    {
        this.state = state;
    }
}
