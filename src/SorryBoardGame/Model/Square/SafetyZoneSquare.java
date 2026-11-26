package SorryBoardGame.Model.Square;

import SorryBoardGame.Model.Pawn;

public class SafetyZoneSquare extends Square{

    /**
     * Constructor of {@code SafetyZoneSquare} Class.<br>
     * <b>Pre-Condition:</b> The given Color is correct: either Yellow or Red.<br>
     * <b>Post-Condition:</b> The SafetyZoneSquare is Initialized.
     * @class SafetyZoneSquare
     * @param Color the Color of the SafetyZoneSquare
     */
    public SafetyZoneSquare(int Color){
        super();
        setColor(Color);
    }

    /**
     * Transformer of {@code SafetyZoneSquare} Class.<br>
     * <b>Pre-Condition:</b> The Given Pawn must align to the game's state.<br>
     * <b>Post-Condition:</b> The Pawn is placed in the square.
     * @class SafetyZoneSquare
     * @param pawn the pawn that is going to be in the square.
     */
    @Override
    public void setPawn(Pawn pawn) {}
}
