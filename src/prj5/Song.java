package prj5;

/**
 * Each song will be stored in this class with a title, artist, genre, and year
 * 
 * @author Griffin College
 * @author Swopnil Joshi
 * @version Jun 21, 2017
 */
public class Song
{
    /**
     * Counts "Yes" answers to questions
     * 
     * numDemographics * 2 indexes 2 per demographic/attribute
     * 
     * read, art, sports, music, cs, other eng, mcdma, other, northeast,
     * southeast, rest us, outside
     */
    public int[] surveyTally;
    /**
     * Stores percent "Yes" out of total answers
     * 
     * numDemographics * 2 indexes 2 per demographic/attribute
     * 
     * read, art, sports, music, cs, other eng, mcdma, other, northeast,
     * southeast, rest us, outside
     */
    public int[] surveyPercent;
    /**
     * Counts total answers to questions per demographic
     * 
     * numDemographics * 2 indexes 2 per demographic/attribute
     * 
     * read, art, sports, music, cs, other eng, mcdma, other, northeast,
     * southeast, rest us, outside
     */
    public int[] demoTotals;

    private String title;
    private String artist;
    private String genre;
    private int year;
    private final int numDemographics = 12;

    /**
     * Constructor for Song
     * 
     * @param title
     *            title of the song
     * @param artist
     *            artist of the song
     * @param genre
     *            genre of the song
     * @param year
     *            year of song's release
     */
    public Song(String title, String artist, String genre, int year)
    {
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.year = year;
        surveyTally = new int[numDemographics * 2];
        surveyPercent = new int[numDemographics * 2];
        demoTotals = new int[numDemographics * 2];
    }

    /**
     * Accessor for title
     * 
     * @return the title
     */
    public String getTitle()
    {
        return title;
    }

    /**
     * Accessor for artist
     * 
     * @return the artist
     */
    public String getArtist()
    {
        return artist;
    }

    /**
     * Accessor for genre
     * 
     * @return the genre
     */
    public String getGenre()
    {
        return genre;
    }

    /**
     * Accessor for year
     * 
     * @return the year
     */
    public int getYear()
    {
        return year;
    }

    /**
     * Mutator for title
     * 
     * @param title
     *            new title
     */
    public void setTitle(String title)
    {
        this.title = title;
    }

    /**
     * Mutator for artist
     * 
     * @param artist
     *            new artist
     */
    public void setArtist(String artist)
    {
        this.artist = artist;
    }

    /**
     * Mutator for genre
     * 
     * @param genre
     *            new genre
     */
    public void setGenre(String genre)
    {
        this.genre = genre;
    }

    /**
     * Mutator for year
     * 
     * @param year
     *            new year
     */
    public void setYear(int year)
    {
        this.year = year;
    }
}
