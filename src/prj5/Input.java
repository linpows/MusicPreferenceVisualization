package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Reads data and stores it
 * 
 * @author Griffin College griffc1
 * @author Swopnil Joshi linpows
 * @version Jun 21, 2017
 */
public class Input {
    /**
     * compares by title
     */
    public static Input.TitleComparator comparatorTitle = new Input.TitleComparator();
    /**
     * compares by genre
     */
    public static Input.GenreComparator comparatorGenre = new Input.GenreComparator();
    /**
     * compares by artist
     */
    public static Input.ArtistComparator comparatorArtist = new Input.ArtistComparator();
    /**
     * compares by year
     */
    public static Input.DateComparator comparatorDate = new Input.DateComparator();

    private static ArrayList<Person> surveyResults;
    private static LinkedList<Song> musicList;
    private static Scanner file;
    private final static int BUFFER = 5;

    /**
     * Comparator for Song titles
     * 
     * @author Griffin College griffc1
     * @author Swopnil Joshi linpows
     * @version Jun 21, 2017
     */
    private static class TitleComparator implements Comparator<Song> {

        /**
         * Compares two strings alphabetically
         * 
         * @return 0 if strings are the same, positive if s1 comes before s2,
         *         negative if s1 comes after s2
         */
        public int compare(Song s1, Song s2) {
            if (s1.getTitle().equals(s2.getTitle())) {
                return 0;
            }

            for (int i = 0; i < s1.getTitle().length()
                    && i < s2.getTitle().length(); i++) {
                if (s1.getTitle().charAt(i) != (s2.getTitle().charAt(i))) {
                    return s1.getTitle().charAt(i) - s2.getTitle().charAt(i);
                }
            }

            return s1.getTitle().length() - s2.getTitle().length();
        }
    }

    /**
     * Comparator for Song genres
     * 
     * @author Griffin College griffc1
     * @author Swopnil Joshi linpows
     * @version Jun 21, 2017
     */
    private static class GenreComparator implements Comparator<Song> {

        /**
         * Compares two strings alphabetically
         * 
         * @return 0 if strings are the same, positive if s1 comes before s2,
         *         negative if s1 comes after s2
         */
        public int compare(Song s1, Song s2) {
            if (s1.getGenre().equals(s2.getGenre())) {
                return 0;
            }

            for (int i = 0; i < s1.getGenre().length()
                    && i < s2.getGenre().length(); i++) {
                if (s1.getGenre().charAt(i) != (s2.getGenre().charAt(i))) {
                    return s1.getGenre().charAt(i) - s2.getGenre().charAt(i);
                }
            }

            return s1.getGenre().length() - s2.getGenre().length();
        }
    }

    /**
     * Comparator for Song Artists
     * 
     * @author Griffin College griffc1
     * @author Swopnil Joshi linpows
     * @version Jun 21, 2017
     */
    private static class ArtistComparator implements Comparator<Song> {

        /**
         * Compares two strings alphabetically
         * 
         * @return 0 if strings are the same, positive if s1 comes before s2,
         *         negative if s1 comes after s2
         */
        public int compare(Song s1, Song s2) {
            if (s1.getArtist().equals(s2.getArtist())) {
                return 0;
            }

            for (int i = 0; i < s1.getArtist().length()
                    && i < s2.getArtist().length(); i++) {
                if (s1.getArtist().charAt(i) != (s2.getArtist().charAt(i))) {
                    return s1.getArtist().charAt(i) - s2.getArtist().charAt(i);
                }
            }

            return s1.getArtist().length() - s2.getArtist().length();
        }
    }

    /**
     * Comparator for Song Artists
     * 
     * @author Griffin College griffc1
     * @author Swopnil Joshi linpows
     * @version Jun 21, 2017
     */
    private static class DateComparator implements Comparator<Song> {

        /**
         * Compares two strings alphabetically
         * 
         * @return 0 if strings are the same, positive if s1 comes before s2,
         *         negative if s1 comes after s2
         */
        public int compare(Song s1, Song s2) {
            return s1.getYear() - s2.getYear();
        }
    }

    /**
     * Reads input files and creates lists
     * 
     * @param music
     *            name of music file
     * @param survey
     *            name of survey file
     */
    public static void main(String args[]) {
        surveyResults = new ArrayList<>();
        musicList = new LinkedList<>();
        readMusic(args[1]);
        readSurvey(args[0]);
        musicList.setComparator(comparatorTitle);
        musicList.sortList();
        analyzeData();
        musicList.setComparator(comparatorGenre);
        musicList.sortList();
        writeHobby();
        musicList.setComparator(comparatorTitle);
        musicList.sortList();
        writeHobby();
    }

    /**
     * Reads survey and stores in surveyResults
     * 
     * @param survey
     *            name of the survey
     */
    private static void readSurvey(String survey) {
        try {// Can throw FileNotFoundException
            file = new Scanner(new File(survey));
        } 
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if (file.hasNextLine()) {
            file.nextLine();
        }

        while (file.hasNextLine()) {
            String[] read = file.nextLine().split(",");
            if (read.length != musicList.size() * 2 + BUFFER) {
                String[] temp = new String[musicList.size() * 2 + BUFFER];

                for (int i = 0; i < read.length; i++) {
                    temp[i] = read[i];
                }

                for (int i = 0; i < musicList.size() * 2; i++) {
                    if (temp[i + 5] == null) {
                        temp[i + 5] = "";
                    }
                }
                read = temp;
            }

            Person person = new Person(null, null, null);
            String major = "";
            String state = "";
            String hobby = "";

            if (read[2] != null) {
                major = read[2];
            }
            if (read[3] != null) {
                state = read[3];
            }
            if (read[4] != null) {
                hobby = read[4];
            }

            switch (major) {
            case "Computer Science":
                person.setMajor(MajorEnum.CS);
                break;
            case "Math or CMDA":
                person.setMajor(MajorEnum.MCMDA);
                break;
            case "Other Engineering":
                person.setMajor(MajorEnum.OENG);
                break;
            case "Other":
                person.setMajor(MajorEnum.OTHER);
                break;
            default:
                person.setMajor(MajorEnum.NA);
                break;
            }

            switch (state) {
            case "Northeast":
                person.setState(StateEnum.NORTHEAST);
                break;
            case "Southeast":
                person.setState(StateEnum.SOUTHEAST);
                break;
            case "United States (other than Southeast or Northwest)":
                person.setState(StateEnum.RESTOFUS);
                break;
            case "Outside of United States":
                person.setState(StateEnum.OUTSIDE);
                break;
            default:
                person.setState(StateEnum.NA);
                break;
            }

            switch (hobby.toLowerCase()) {
            case "reading":
                person.setHobby(HobbyEnum.READ);
                break;
            case "art":
                person.setHobby(HobbyEnum.ARTS);
                break;
            case "sports":
                person.setHobby(HobbyEnum.SPORTS);
                break;
            case "music":
                person.setHobby(HobbyEnum.MUSIC);
                break;
            default:
                person.setHobby(HobbyEnum.NA);
                break;
            }

            for (int i = 0; i < musicList.size() * 2; i++) {
                if (read[i + BUFFER].equalsIgnoreCase("yes")) {
                    person.surveyAnswers.add("yes");
                } 
                else if (read[i + BUFFER].equalsIgnoreCase("no")) {
                    person.surveyAnswers.add("no");
                } 
                else {
                    person.surveyAnswers.add("");
                }
            }

            surveyResults.add(person);
        }
    }

    /**
     * Reads music file and stores in musicList
     * 
     * @param music
     *            name of music file
     */
    private static void readMusic(String music) {
        musicList = new LinkedList<>();

        try {// Can throw FileNotFoundException
            file = new Scanner(new File(music));
        } 
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if (file.hasNextLine()) {
            file.nextLine();
        }

        while (file.hasNextLine()) {
            String[] read = file.nextLine().split(",");

            Song song = new Song(read[0], read[1], read[3],
                    Integer.parseInt(read[2]));

            musicList.add(song);
        }
    }

    /**
     * Analyzes survey results and stores statistics in Songs
     */
    public static void analyzeData() {
        for (int i = 0; i < musicList.size(); i++) {
            Song temp = musicList.get(i);
            for (int j = 0; j < surveyResults.size(); j++) {
                Person person = surveyResults.get(j);
                switch (person.surveyAnswers.get(i * 2 + 1)) {
                case "yes":
                    switch (person.getHobby()) {
                    case ARTS:
                        temp.demoTotals[3]++;
                        temp.surveyTally[3]++;
                        break;
                    case MUSIC:
                        temp.demoTotals[7]++;
                        temp.surveyTally[7]++;
                        break;
                    case READ:
                        temp.demoTotals[1]++;
                        temp.surveyTally[1]++;
                        break;
                    case SPORTS:
                        temp.demoTotals[5]++;
                        temp.surveyTally[5]++;
                        break;
                    default:
                        break;
                    }

                    switch (person.getMajor()) {
                    case CS:
                        temp.demoTotals[9]++;
                        temp.surveyTally[9]++;
                        break;
                    case MCMDA:
                        temp.demoTotals[13]++;
                        temp.surveyTally[13]++;
                        break;
                    case OENG:
                        temp.demoTotals[11]++;
                        temp.surveyTally[11]++;
                        break;
                    case OTHER:
                        temp.demoTotals[15]++;
                        temp.surveyTally[15]++;
                        break;
                    default:
                        break;
                    }

                    switch (person.getState()) {
                    case NORTHEAST:
                        temp.demoTotals[17]++;
                        temp.surveyTally[17]++;
                        break;
                    case OUTSIDE:
                        temp.demoTotals[23]++;
                        temp.surveyTally[23]++;
                        break;
                    case RESTOFUS:
                        temp.demoTotals[21]++;
                        temp.surveyTally[21]++;
                        break;
                    case SOUTHEAST:
                        temp.demoTotals[19]++;
                        temp.surveyTally[19]++;
                        break;
                    default:
                        break;
                    }
                    break;
                case "no":
                    switch (person.getHobby()) {
                    case ARTS:
                        temp.demoTotals[3]++;
                        break;
                    case MUSIC:
                        temp.demoTotals[7]++;
                        break;
                    case READ:
                        temp.demoTotals[1]++;
                        break;
                    case SPORTS:
                        temp.demoTotals[5]++;
                        break;
                    default:
                        break;
                    }

                    switch (person.getMajor()) {
                    case CS:
                        temp.demoTotals[9]++;
                        break;
                    case MCMDA:
                        temp.demoTotals[13]++;
                        break;
                    case OENG:
                        temp.demoTotals[11]++;
                        break;
                    case OTHER:
                        temp.demoTotals[15]++;
                        break;
                    default:
                        break;
                    }

                    switch (person.getState()) {
                    case NORTHEAST:
                        temp.demoTotals[17]++;
                        break;
                    case OUTSIDE:
                        temp.demoTotals[23]++;
                        break;
                    case RESTOFUS:
                        temp.demoTotals[21]++;
                        break;
                    case SOUTHEAST:
                        temp.demoTotals[19]++;
                        break;
                    default:
                        break;
                    }
                default:
                    break;
                }

                switch (person.surveyAnswers.get(i * 2)) {
                case "yes":
                    switch (person.getHobby()) {
                    case ARTS:
                        temp.demoTotals[2]++;
                        temp.surveyTally[2]++;
                        break;
                    case MUSIC:
                        temp.demoTotals[6]++;
                        temp.surveyTally[6]++;
                        break;
                    case READ:
                        temp.demoTotals[0]++;
                        temp.surveyTally[0]++;
                        break;
                    case SPORTS:
                        temp.demoTotals[4]++;
                        temp.surveyTally[4]++;
                        break;
                    default:
                        break;
                    }

                    switch (person.getMajor()) {
                    case CS:
                        temp.demoTotals[8]++;
                        temp.surveyTally[8]++;
                        break;
                    case MCMDA:
                        temp.demoTotals[12]++;
                        temp.surveyTally[12]++;
                        break;
                    case OENG:
                        temp.demoTotals[10]++;
                        temp.surveyTally[10]++;
                        break;
                    case OTHER:
                        temp.demoTotals[14]++;
                        temp.surveyTally[14]++;
                        break;
                    default:
                        break;
                    }

                    switch (person.getState()) {
                    case NORTHEAST:
                        temp.demoTotals[16]++;
                        temp.surveyTally[16]++;
                        break;
                    case OUTSIDE:
                        temp.demoTotals[22]++;
                        temp.surveyTally[22]++;
                        break;
                    case RESTOFUS:
                        temp.demoTotals[20]++;
                        temp.surveyTally[20]++;
                        break;
                    case SOUTHEAST:
                        temp.demoTotals[18]++;
                        temp.surveyTally[18]++;
                        break;
                    default:
                        break;
                    }
                    break;
                case "no":
                    switch (person.getHobby()) {
                    case ARTS:
                        temp.demoTotals[2]++;
                        break;
                    case MUSIC:
                        temp.demoTotals[6]++;
                        break;
                    case READ:
                        temp.demoTotals[0]++;
                        break;
                    case SPORTS:
                        temp.demoTotals[4]++;
                        break;
                    default:
                        break;
                    }

                    switch (person.getMajor()) {
                    case CS:
                        temp.demoTotals[8]++;
                        break;
                    case MCMDA:
                        temp.demoTotals[12]++;
                        break;
                    case OENG:
                        temp.demoTotals[10]++;
                        break;
                    case OTHER:
                        temp.demoTotals[14]++;
                        break;
                    default:
                        break;
                    }

                    switch (person.getState()) {
                    case NORTHEAST:
                        temp.demoTotals[16]++;
                        break;
                    case OUTSIDE:
                        temp.demoTotals[22]++;
                        break;
                    case RESTOFUS:
                        temp.demoTotals[20]++;
                        break;
                    case SOUTHEAST:
                        temp.demoTotals[18]++;
                        break;
                    default:
                        break;
                    }
                default:
                    break;
                }
            }

            for (int j = 0; j < temp.surveyPercent.length; j++) {
                if (temp.demoTotals[j] != 0) {
                    temp.surveyPercent[j] = temp.surveyTally[j] * 100
                            / temp.demoTotals[j];
                }
            }
        }
    }

    /**
     * Outputs the results by title
     */
    public static void writeHobby() {
        for (int i = 0; i < musicList.size(); i++) {
            System.out.print("Song Title: ");
            System.out.println(musicList.get(i).getTitle());
            System.out.print("Song Artist: ");
            System.out.println(musicList.get(i).getArtist());
            System.out.print("Song Genre: ");
            System.out.println(musicList.get(i).getGenre());
            System.out.print("Song Year: ");
            System.out.println(musicList.get(i).getYear());

            System.out.println("Heard");
            System.out.print("reading:");
            System.out.print(musicList.get(i).surveyPercent[0]);
            System.out.print(" art:");
            System.out.print(musicList.get(i).surveyPercent[2]);
            System.out.print(" sports:");
            System.out.print(musicList.get(i).surveyPercent[4]);
            System.out.print(" music:");
            System.out.println(musicList.get(i).surveyPercent[6]);

            System.out.println("Likes");
            System.out.print("reading:");
            System.out.print(musicList.get(i).surveyPercent[1]);
            System.out.print(" art:");
            System.out.print(musicList.get(i).surveyPercent[3]);
            System.out.print(" sports:");
            System.out.print(musicList.get(i).surveyPercent[5]);
            System.out.print(" music:");
            System.out.println(musicList.get(i).surveyPercent[7]);

            System.out.println();
        }
    }

    /**
     * Accessor for surveyResults
     * 
     * @return surveyResults
     */
    public static ArrayList<Person> getSurveyResults() {
        return surveyResults;
    }

    /**
     * Acessor for musicList
     * 
     * @return musicList
     */
    public static LinkedList<Song> getMusicList() {
        return musicList;
    }
}
