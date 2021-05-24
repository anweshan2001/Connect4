package fourgameconnector;
public class Board
{
private final int rows=6, colums=7;	
Piece [][] brd=new Piece[rows][colums];
 int  getcol()
{
	return colums;
}
 boolean checkwinner(int col,String wc)
	{ boolean someonewin=false;
	for(int r=0;r<rows;r++)
	{
		if(brd[r][col]!=null)
		{ 
			int winingstreak=3;
			//downward checking
		for(int winrow=r+1;winrow<rows;winrow++)
		{
			if(brd[winrow][col].getc()==wc)
			{
				winingstreak--;
				if(winingstreak==0)
				{
					someonewin=true;
				}
			}
			else
			{
				winingstreak=3;
			}
		} // for any other type of check
		winingstreak=4;
		
		//horizontal
		for(int wincol=col-3;wincol<col+3;wincol++)
		{
			if(wincol<0)
				{continue;}
			if(wincol>=colums)
			{break;}
			if(brd[r][wincol]!=null && brd[r][wincol].getc()==wc)
			{
				winingstreak--;
				if(winingstreak==0)
				{
					someonewin=true;
				}
			}
			else
			{
				winingstreak=4;
			}
		}
		winingstreak=4;
		
		//left diagonal
		for(int winrow=r-3,wincol=col-3;winrow<=r+3 && wincol<=col+3;winrow++,wincol++)
		{
			if(winrow<0||wincol<0)
			continue;
			
		if(winrow>=rows||wincol>=colums)
		break;
		if(brd[winrow][wincol]!=null && brd[winrow][wincol].getc()==wc)
		{
			winingstreak--;
			
			if(winingstreak==0)
			{
				someonewin=true;
			}
		}
		else
		{
			winingstreak=4;
		}
		
	   }
		winingstreak=4;//right diagonal
		for(int winrow=r-3,wincol=col+3;winrow<=r+3 && wincol>=col-3;winrow++,wincol--)
		{
			if(winrow<0||wincol>=colums)
			{continue;}
		if(winrow>=r||wincol<0)
		{break;}
		if(brd[winrow][wincol]!=null && brd[winrow][wincol].getc()==wc)
		{
			winingstreak--;
			
			if(winingstreak==0)
			{
				someonewin=true;
			}
		}
		else
		{
			winingstreak=4;
		}
		
	   }
		
		
		break;
		}
	
	}
	return someonewin;
	
	}

public int addpiece(int coladd,String color)
{ 
	if(coladd>=0 &&coladd<=colums)
	{
		if(brd[0][coladd]==null)
		{boolean addedpiece=false;
		int addedrow=-1;
			for(int r=rows-1;r>=0;r--)
			{
				if(brd[r][coladd]==null)
				{
					brd[r][coladd]=new Piece();
					brd[r][coladd].setc(color);
				addedpiece=true;
				addedrow=r;
				break;
				} }
			return addedrow;}
		
			    else
		        {
					System.out.println("filled up. goto next");
					return -1;
				}
	     }	
			
	     else
		{
			System.out.println("out of filling up. goto next");
			return -1;
		}
	
	}
	

public void prntBoard()
{for(int j=0;j<colums+2;j++)
	System.out.print("-");
System.out.println();
	for(int i=0;i<rows;i++)
	{ System.out.print("|");
		for(int j=0;j<colums;j++)
		{
			if(brd[i][j]==null)
			{
				System.out.print("_");
			}
			
			else
			{
				System.out.print(brd[i][j].getc());
			}
			System.out.print("|");
			}
	System.out.println();
	}
	for(int j=0;j<colums+2;j++)
		System.out.print("-");
	System.out.println();
}
public Board()
{
	for(int i=0;i<rows;i++)
	{
		for(int j=0;j<colums;j++)
		{
			brd[i][j]=null;
		}
	}
}
}