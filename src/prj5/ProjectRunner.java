/**
 * 
 */
package prj5;

/**
 * A class for running the gui
 * 
 * @author Griffin College
 * @author Swopnil Joshi
 * @version Jun 21, 2017
 */
public class ProjectRunner
{
    /**
     * @param args csv files to be read
     */
    public static void main(String[] args)
    {
        
        if (args.length < 2)
        {
            String arg[] = {"MusicSurveyData2017S.csv",
            "SongList2017S.csv"};
            Input.main(arg);
        }
        else
        {

            Input.main(args);
        }
        GUIGameWindow gameWindow = new GUIGameWindow();
       
    }

}
