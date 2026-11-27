package SorryBoardGame.Model.Square;

import SorryBoardGame.Model.Pawn;

public class EndSlideSquare extends SlideSquare{

    /**
     * Constructor of {@code EndSlideSquare} Class.<br>
     * <b>Pre-Condition:</b> The correct color is given from {@code Resources} Class.<br>
     * <b>Post-Condition:</b> Initializes a Slider Square that represents the end of the slider.
     * @class EndSlideSquare
     * @param Color the Color of the Slide Square
     */
    public EndSlideSquare(int Color){
        super(Color);
    }

    /**
     * Accessor method of {@code EndSlideSquare} Class.<br>
     * <b>Post-Condition:</b> Returns a String with the path to the icon of the slide part according to its color.
     * @class EndSlideSquare
     */
    public String getIcon(){return "SorryBoardGame/Assets/slides/" + getIconColor() + "SlideEnd.png";}

    /**
     * Transformer method of {@code EndSlideSquare} Class.<br>
     * <b>Post-Condition:</b> Inserts a Pawn into the EndSlideSquare.
     * @class EndSlideSquare
     * @param pawn the pawn to be placed in the EndSlideSquare
     */
    @Override
    public void setPawn(Pawn pawn) {}
}
