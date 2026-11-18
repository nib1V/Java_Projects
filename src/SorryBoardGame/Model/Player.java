package SorryBoardGame.Model;

public class Player {
    private String name;
    private Pawn[] pawns = new Pawn[2];
    private boolean myTurn;

    public Player(){

    }


    public String getName(){return name;}

    public boolean getTurn(){return myTurn;}
    private void setTurn(boolean val){myTurn = val;}
}
