package SorryBoardGame.Model.Square;

import SorryBoardGame.Model.Pawn;

public class InternalSlideSquare extends SlideSquare{

    /**
     * Constructor of {@code InternalSlideSquare} Class.<br>
     * <b>Pre-Condition:</b> The correct color is given from {@code Resources} Class.<br>
     * <b>Post-Condition:</b> Initializes a Slider Square that represents the inside of the slider.
     * @class InternalSlideSquare
     * @param Color the Color of the Slide Square
     */
    public InternalSlideSquare(int Color){
        super(Color);
    }

    /**
     * Accessor method of {@code InternalSlideSquare} Class.<br>
     * <b>Post-Condition:</b> Returns a String with the path to the icon of the slide part according to its color.
     * @class InternalSlideSquare
     */
    public String getIcon(){return "SorryBoardGame/Assets/slides/" + getIconColor() + "SlideMedium.png";}

    /**
     * Transformer method of {@code InternalSlideSquare} Class.<br>
     * <b>Post-Condition:</b> Inserts a Pawn into the InternalSlideSquare.
     * @class InternalSlideSquare
     * @param pawn the pawn to be placed in the InternalSlideSquare
     */
    @Override
    public void setPawn(Pawn pawn) {}
}
