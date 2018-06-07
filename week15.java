import java.lang.*;
import java.io.*;

public class week15       
{
    public static void main(String args[])
    {    	  
    	     String str1=new String();
    	     
    	     CDinner Soup = new CDinner("´ö");
    	     CDinner Salad = new CDinner("¨F©Ô");
    	     CDinner Entree = new CDinner("¥Dµæ");
    	     CDinner Dessert = new CDinner("²¢ÂI");    	     
    	     
    	     Soup.start(); 
    	     Salad.start(); 
    	     Entree.start();  
    	     Dessert.start();    	     
    }        
}

class CDinner extends Thread
{
	String food;
	public CDinner(String str)
	{
		food = str;
	}
	private void serving()
	{
		System.out.println("¤Wµæ:" + food);
	}
	public void run()
	{
			try
			{
				sleep(1000);
			}
			catch(InterruptedException e){}
			serving();
	}
}


    
