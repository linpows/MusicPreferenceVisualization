/**
 * 
 */
package prj5;

import java.awt.Color;
import java.util.ArrayList;

import CS2114.Shape;
import CS2114.TextShape;

/**
 * Creates graphical representation of data
 * 
 * @author Griffin College
 * @author Swopnil Joshi
 * @version Jun 21, 2017
 */
public class GUIGlyph {
    private static final int INITITALWIDTH = 50;
    private static final int HEIGHT = 12;
    private Shape blackBar;
    private ArrayList<Shape> glyphList;

    /**
     * inititalizes all glyph variables
     * 
     * @param song
     *            current glpyh song
     * @param representation
     *            chosen demographic
     * @param x
     *            of the gylph
     * @param y
     *            of the glyph
     */
    public GUIGlyph(Song song, String representation, int x, int y) {
        // array list of all shapes and texts for each glyph (in order)
        glyphList = new ArrayList<Shape>();

        blackBar = new Shape(x, y, 6, 48, Color.BLACK);
        blackBar.setForegroundColor(Color.BLACK);

        TextShape artist = new TextShape(0, 0, "by " + song.getArtist());
        artist.setX(blackBar.getX() - (artist.getWidth() / 2));
        artist.setY(blackBar.getY() - (blackBar.getHeight() / 2));
        artist.setBackgroundColor(Color.WHITE);
        glyphList.add(artist);

        TextShape title = new TextShape(0, 0, song.getTitle());
        title.setX(blackBar.getX() - (title.getWidth() / 2));
        title.setY(artist.getY() - title.getHeight() - 3);
        title.setBackgroundColor(Color.WHITE);
        glyphList.add(title);

        // index of arrat for survey results
        int index = 0;
        if (representation.equals("Major")) {
            index = 8;
        } else if (representation.equals("Region")) {
            index = 16;
        }
        // creates 8 bars 4 for like and 4 for heard
        // passes in a color int for bar
        for (int i = 0; i < 8; i++) {
            bar(i, barWidth(song.surveyPercent[index + i]),
                    blackBar.getY() + blackBar.getHeight() / 4 * (i / 2));
        }

        glyphList.add(blackBar);
    }

    /**
     * determines the bar width based on survey results
     * 
     * @param percentage
     *            from survey results
     * @return a double width
     */
    public double barWidth(int percentage) {
        return (INITITALWIDTH * percentage) / 100;
    }

    /**
     * creates a bar on a specific side of divider
     * 
     * @param color
     *            an int for detemining which color a bar is
     * @param width
     *            from barwidth
     * @param y
     *            for the height placement of bar
     */
    private void bar(int color, double width, int y) {
        Shape newBar = new Shape(0, y, (int) width, HEIGHT);

        // divides color by 2 because it is int a whole number is chosen
        switch (color / 2) {
        case 0:
            newBar.setBackgroundColor(Color.magenta);
            break;
        case 1:
            newBar.setBackgroundColor(Color.BLUE);
            break;
        case 2:
            newBar.setBackgroundColor(Color.ORANGE);
            break;
        case 3:
            newBar.setBackgroundColor(Color.RED);
            break;
        }

        // if the color int has no remainder it is on left
        if (color % 2 == 0) {
            newBar.setX(blackBar.getX() - newBar.getWidth());
        }
        // else it is on right
        else {
            newBar.setX(blackBar.getX() + blackBar.getWidth());
        }
        // removes border of bar
        newBar.setForegroundColor(Color.WHITE);
        glyphList.add(newBar);

    }

    /**
     * accessor for all of the shapes in one glyph display
     * 
     * @return
     */
    public ArrayList<Shape> getShapes() {

        return glyphList;
    }

}
