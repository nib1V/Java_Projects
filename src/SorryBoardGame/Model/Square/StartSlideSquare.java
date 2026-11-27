package SorryBoardGame.Model.Square;

import SorryBoardGame.Model.Pawn;

public class StartSlideSquare extends SlideSquare{

    /**
     * Constructor of {@code StartlideSquare} Class.<br>
     * <b>Pre-Condition:</b> The correct color is given from {@code Resources} Class.<br>
     * <b>Post-Condition:</b> Initializes a Slider Square that represents the start of the slider.
     * @class StartSlideSquare
     * @param Color the Color of the Slide Square
     */
    public StartSlideSquare(int Color){
        super(Color);
    }

    /**
     * Accessor method of {@code StartSlideSquare} Class.<br>
     * <b>Post-Condition:</b> Returns a String with the path to the icon of the slide part according to its color.
     * @class StartSlideSquare
     */
    public String getIcon(){return "SorryBoardGame/Assets/slides/" + getIconColor() + "SlideStart.png";}

    /**
     * Transformer method of {@code StartSlideSquare} Class.<br>
     * <b>Post-Condition:</b> Inserts a Pawn into the StartSlideSquare.
     * @class StartSlideSquare
     * @param pawn the pawn to be placed in the StartSlideSquare
     */
    @Override
    public void setPawn(Pawn pawn) {}
}
