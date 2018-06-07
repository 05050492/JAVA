import java.lang.*;
import java.io.*;

public class lab11     
{
    public static void main(String args[])
    {    	  
    	     String str1=new String();
			 
    	     test even = new test();
    	     test2 three = new test2();    
    	     
    	     even.start(); 
			 three.start(); 
    }        
}

class test extends Thread
{
	int i;
	public void serving()		//案计
	{
		System.out.println("案计:" + i);
	}
	public void run()
	{
			for(i=2;i<=100;i++){
			if(i%2 == 0)
				try
				{
					sleep(200);
				}
			catch(InterruptedException e){}
			serving();
			}
	}
}
class test2 extends Thread
{
	int j;
	public void serving1()		//案计
	{
		System.out.println("3计:" + j);
	}
	public void run()
	{
			for(j=3;j<=100;j++){
			if(j%3 == 0)
				try
				{
					sleep(300);
				}
			catch(InterruptedException e){}
			serving1();
			}
	}
}


    
