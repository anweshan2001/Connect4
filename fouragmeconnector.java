package fourgameconnector;
import javax.swing.*;
public class fouragmeconnector {

	public static void main(String[] args) {
		Board b=new Board();
       connect4logic game=new connect4logic("R","Y");
       game.startGame();
      Connect4GUI g=new Connect4GUI();

       
       
	}
	}
