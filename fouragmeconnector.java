package fourgameconnector;
import javax.swing.*;
import java.util.Scanner;
public class fouragmeconnector {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Board b=new Board();
		System.out.println("Red(R) Yellow(Y) colors available ");
		System.out.println("Player 1 : Choose your color");
		
		String p1=sc.nextLine();
		
		System.out.println("Player 2 : Choose your color");
		String p2=sc.nextLine();
		
       connect4logic game=new connect4logic(p1,p2);
       game.startGame();
      

       
       
	}
	}
