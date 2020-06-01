package prj5;

import java.awt.Color;
import CS2114.Button;
import CS2114.Shape;
import CS2114.TextShape;
import CS2114.Window;
import CS2114.WindowSide;

/**
 * Class for creating GUI
 * 
 * @author Griffin College
 * @author Swopnil Joshi
 * @version Jun 21, 2017
 */
public class GUIGameWindow {

    private Window window;
    private int currentIndex;
    private String currentSort;
    private String currentRepresentation;
    private Button prevButton;
    private Button nextButton;

    /**
     * inititalizes all GUI variables for display on screen
     */
    public GUIGameWindow() {
        currentIndex = 0;// keeps track of current page
        currentRepresentation = "Hobby"; // tracking demographic represented
        currentSort = "Song Title";// tracks which sort the user selected

        window = new Window("visualizer");
        window.setSize(1200, 750);
        

        // -------------Buttons below glyphs---------------//
        Button quitButton = new Button("Quit");
        Button hobbyButton = new Button("Represent Hobby");
        Button majorButton = new Button("Represent Major");
        Button regionButton = new Button("Represent Region");

        quitButton.onClick(this, "clickedQuit");
        hobbyButton.onClick(this, "clickedRepresentation");
        majorButton.onClick(this, "clickedRepresentation");
        regionButton.onClick(this, "clickedRepresentation");

        window.addButton(hobbyButton, WindowSide.SOUTH);
        window.addButton(majorButton, WindowSide.SOUTH);
        window.addButton(regionButton, WindowSide.SOUTH);
        window.addButton(quitButton, WindowSide.SOUTH);

        // ------------------------------------------------//

        // -------------Buttons above glyphs---------------//
        prevButton = new Button("< Prev");
        nextButton = new Button("Next >");
        Button artistButton = new Button("Sort by Artist Name");
        Button titleButton = new Button("Sort by Song Title");
        Button yearButton = new Button("Sort by Release Year");
        Button genreButton = new Button("Sort by Genre");

        prevButton.onClick(this, "clickedPrev");
        nextButton.onClick(this, "clickedNext");
        artistButton.onClick(this, "clickedSort");
        titleButton.onClick(this, "clickedSort");
        yearButton.onClick(this, "clickedSort");
        genreButton.onClick(this, "clickedSort");

        prevButton.disable();// button disabled initially

        window.addButton(prevButton, WindowSide.NORTH);
        window.addButton(artistButton, WindowSide.NORTH);
        window.addButton(titleButton, WindowSide.NORTH);
        window.addButton(yearButton, WindowSide.NORTH);
        window.addButton(genreButton, WindowSide.NORTH);
        window.addButton(nextButton, WindowSide.NORTH);
        // ------------------------------------------------//

        createGlyph();// produces initital glyphs

    }

    /**
     * method for accessing the gui window
     * 
     * @return current GUI window
     */
    public Window getWindow() {
        return window;
    }

    /**
     * enables previous button and creates new set of glyphs if there are no
     * more glyphs the next button is disabled
     * 
     * @param button
     *            next button
     */
    public void clickedNext(Button button) {

        prevButton.enable();
        currentIndex += 9;
        if (currentIndex + 9 >= Input.getMusicList().size()) {
            button.disable();

        }

        createGlyph();
    }

    /**
     * moves to a previous set of glyphs if there is some enables next button
     * which is effective when the next button reaches the end of the song list
     * 
     * @param button
     *            previous button
     */
    public void clickedPrev(Button button) {
        nextButton.enable();
        currentIndex -= 9;
        if (currentIndex - 9 <= 0) {
            button.disable();
        }
        createGlyph();
    }

    /**
     * exits the gui
     * 
     * @param button
     *            quit button
     */
    public void clickedQuit(Button button) {
        System.exit(0);
    }

    /**
     * sorts the glyphs based on which sort button is chosen
     * 
     * @param button
     *            chosen sort button
     */
    public void clickedSort(Button button) {
        // sets the current sort to the button title minus "Sort by"
        currentSort = button.getTitle().replaceFirst("Sort by ", "");

        switch (currentSort) {
        case "Artist Name":
            Input.getMusicList().setComparator(Input.comparatorArtist);
            break;
        case "Song Title":
            Input.getMusicList().setComparator(Input.comparatorTitle);
            break;
        case "Release Year":
            Input.getMusicList().setComparator(Input.comparatorDate);
            break;
        case "Genre":
            Input.getMusicList().setComparator(Input.comparatorGenre);
            break;
        }
        Input.getMusicList().sortList();

        createGlyph();

    }

    /**
     * changes the demographic represented on the screen
     * 
     * @param button
     *            chosen demographic
     */
    public void clickedRepresentation(Button button) {
        // sets current representation to chosen demographic
        currentRepresentation = button.getTitle().replaceFirst("Represent ",
                "");
        createGlyph();
    }

    /**
     * creates a legend based on the current demographic
     * 
     * @param representation
     *            the chosen demographic
     */
    private void createLegend(String representation) {
        // sets the legend to be on the side of the screen with a buffer of 10
        Shape legendBox = new Shape(window.getGraphPanelWidth() - 210,
                window.getGraphPanelHeight() - 210, 200, 200, Color.WHITE);
        // creates a box behind the legendbox for a border effect
        Shape border = new Shape(legendBox.getX() - 3, legendBox.getY() - 3,
                legendBox.getWidth() + 6, legendBox.getHeight() + 6,
                Color.BLACK);

        TextShape legendTitle = new TextShape(0, 0, representation + " Legend");
        legendTitle.setBackgroundColor(Color.WHITE);
        legendTitle.setX(legendBox.getX()
                + ((legendBox.getWidth() - legendTitle.getWidth()) / 2));
        legendTitle.setY(legendBox.getY() + legendTitle.getHeight() + 3);

        TextShape keyTitle = new TextShape(0, 0, "Song Title");
        keyTitle.setBackgroundColor(Color.WHITE);

        TextShape key = new TextShape(0, 0, "Heard    Likes");
        key.setBackgroundColor(Color.WHITE);

        TextShape attribute1 = new TextShape(0, 0, "");
        TextShape attribute2 = new TextShape(0, 0, "");
        TextShape attribute3 = new TextShape(0, 0, "");
        TextShape attribute4 = new TextShape(0, 0, "");

        // colors all of the text and sets the backgrounds to be invisible
        attribute1.setForegroundColor(Color.magenta);
        attribute2.setForegroundColor(Color.blue);
        attribute3.setForegroundColor(Color.orange);
        attribute4.setForegroundColor(Color.red);
        attribute1.setBackgroundColor(Color.WHITE);
        attribute2.setBackgroundColor(Color.WHITE);
        attribute3.setBackgroundColor(Color.WHITE);
        attribute4.setBackgroundColor(Color.WHITE);

        if (representation.equals("Hobby")) {
            attribute1.setText("Read");
            attribute2.setText("Art");
            attribute3.setText("Sports");
            attribute4.setText("Music");
        } else if (representation.equals("Major")) {
            attribute1.setText("Computer Science");
            attribute2.setText("Other Engineering");
            attribute3.setText("Math/CMDA");
            attribute4.setText("Other");
        } else if (representation.equals("Region")) {
            attribute1.setText("Northeast");
            attribute2.setText("Southeast");
            attribute3.setText("Other US");
            attribute4.setText("Outside US");
        }

        attribute1.setX(legendBox.getX() + 5);
        attribute1.setY(legendTitle.getY() + legendTitle.getHeight() + 10);
        attribute2.setX(legendBox.getX() + 5);
        attribute2.setY(attribute1.getY() + attribute2.getHeight() + 3);
        attribute3.setX(legendBox.getX() + 5);
        attribute3.setY(attribute2.getY() + attribute3.getHeight() + 3);
        attribute4.setX(legendBox.getX() + 5);
        attribute4.setY(attribute3.getY() + attribute4.getHeight() + 3);

        keyTitle.setX(legendBox.getX()
                + ((legendBox.getWidth() - keyTitle.getWidth()) / 2));
        keyTitle.setY(attribute4.getY() + keyTitle.getHeight() + 3);

        key.setX(legendBox.getX()
                + ((legendBox.getWidth() - key.getWidth()) / 2));
        key.setY(keyTitle.getY() + 35);
        // creates a divider in the middle of the key
        Shape divider = new Shape(key.getX() + ((key.getWidth() / 2) + 3),
                key.getY() - 35, 6, 70, Color.BLACK);

        // all the shapes are added in a specific order
        window.addShape(attribute1);
        window.addShape(attribute2);
        window.addShape(attribute3);
        window.addShape(attribute4);
        window.addShape(keyTitle);
        window.addShape(divider);
        window.addShape(key);
        window.addShape(legendTitle);
        window.addShape(legendBox);
        window.addShape(border);

    }

    /**
     * creates a glpyh representations on the screen
     */
    private void createGlyph() {
        window.removeAllShapes();
        createLegend(currentRepresentation);
        int x = 250;
        int y = 150;
        // loops create 3 glyphs per row then 3 rows based on current index
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3 && i * 3 + j + currentIndex < Input
                    .getMusicList().size(); j++) {

                GUIGlyph newGlyph = new GUIGlyph(
                        Input.getMusicList().get(i * 3 + j + currentIndex),
                        currentRepresentation, x + (x * j), y + (y * i));
                for (Shape s : newGlyph.getShapes()) {
                    window.addShape(s);
                }
            }
        }
    }
}
