package HeistGame.exception;

public class DeadCharacterException extends Exception{
    public DeadCharacterException(String name){
        super("The Character: " + name + " is Dead");
    }
}
