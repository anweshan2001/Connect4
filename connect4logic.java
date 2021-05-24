package fourgameconnector;

import java.util.Random;
import java.util.Scanner;

public class connect4logic {
	private Board board;
	private String c1;
	private String c2;
	boolean p1plays;
	public boolean p1plays()
	{
		return p1plays;
	}
	connect4logic(String c1,String c2)
	{
		this.board=new Board();
		this.c1=c1;
		this.c2=c2;
		p1plays=(new Random()).nextBoolean();
		
	}
	public int round(int column)
	{ int row =-1;
	String color;
	boolean isrun=true;
	
	
		if(p1plays)
		{ 
			color=c1;
		System.out.println("Its p1's turn");
		}
		else
		{
			color=c2;
		System.out.println("It's p2's turn");
		}	
		row=board.addpiece(column, color);
		if(row!=-1) 
		{ 
			
		p1plays=!p1plays;
	    }
	return row;
	}
	boolean somewiningui(int column)
	{
		String winningcolor;
		if(p1plays)
		winningcolor=c1;
		else
		winningcolor=c2;
		
		return board.checkwinner(column,winningcolor);	
	}
	boolean somewin(int column)
	{
	
	String winningcolor;
	if(p1plays)
	winningcolor=c1;
	else
	winningcolor=c2;
	
	return board.checkwinner(column,winningcolor);
	
	}
	void reset()
	{
		this.board=new Board();
	}
void startGame()
{ String color;
	boolean isrun=true;
	
	while(isrun)
	{ board.prntBoard();
		if(p1plays)
		{ 
			color=c1;
		System.out.println("Its p1's turn");
		}
		else
		{
			color=c2;
		System.out.println("It's p2's turn");
		}
		System.out.println("Choose which column you want to put your piece");
		System.out.println("Choose between 1 and "+board.getcol());
		Scanner input=new Scanner(System.in);
		int col=input.nextInt()-1;
		int success=board.addpiece(col, color);
		
		if(success!=-1) 
		{ 
			if(somewin(col))
		{ board.prntBoard();
			
			
			if(p1plays)
			System.out.println("Player one wins");
			else
			System.out.println("Player two wins");
		System.out.println("Would like to play another round");
		System.out.println("Y for yes ");
		input.nextLine();
		String oncemore=input.nextLine();
		if(oncemore.toLowerCase().equals("y"))
		{
			reset();
		}
		else
		{
			isrun=false;
		}
		}
		p1plays=!p1plays;
	    }
}
}
}
