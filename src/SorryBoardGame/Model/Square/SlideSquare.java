package SorryBoardGame.Model.Square;

import static SorryBoardGame.Model.Resources.*;

public abstract class SlideSquare extends Square{

    /**
     * Constructor of {@code SlideSquare} Class.<br>
     * <b>Pre-Condition:</b> The given color is anything but white.<br>
     * <b>Post-Condition:</b> Initializes the Slide Square for one of its subclasses.
     * @class SlideSquare
     * @param Color the color of the SlideSquare
     */
    public SlideSquare(int Color){
        super();
        setColor(Color);
    }

    /**
     * Accessor method of {@code SlideSquare} Class.<br>
     * <b>Post-Condition:</b> Returns the SlideSquares' color in string form to be
     * used in order to generate the source of the .png file containing the slide in its given
     * color.
     * @class SlideSquare
     */
    public String getIconColor() {
        String s = "";
        switch (getColor()) {
            case GREEN:
                s = "green";
                break;
            case BLUE:
                s = "blue";
                break;
            case YELLOW:
                s = "yellow";
                break;
            case RED:
                s = "red";
                break;
            default:
                return "";
        }
        return s;
    }
}
