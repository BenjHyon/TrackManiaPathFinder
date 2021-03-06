package pathfinder;

import java.util.ArrayList;

public class checkPoint {

	private int[] sens1;
	private int[] sens2;
	private int len1;
	private int len2;
	private int cpId;
	
	public checkPoint(int cpId,int[] sens1, int[] sens2,int len1, int len2)
	{
		this.cpId = cpId;
		this.sens1 = sens1;
		this.sens2 = sens2;
		this.len1 = len1;
		this.len2 = len2;
	}
	
	public int nextCP(int LastCP, ArrayList<Integer> Verboten)
	{
		int[] inTo;
		int leninTo;
		if(Contains(sens1,len1,LastCP))
		{
			inTo = sens2;
			leninTo = len2;
		}
		else if(Contains(sens2,len2,LastCP))
		{
			inTo = sens1;
			leninTo = len1;
		}
		else{
			return -1;
		}
		
		for(int i = 0; i<leninTo; i++)
		{
			int CP = inTo[i];
			if(!Verboten.contains(CP))
			{
				return CP;
			}
		}
		return -1;
	}
	
	public int getCPID()
	{
		return this.cpId;
	}
	
	private Boolean Contains(int[] liste,int size,int valeur)
	{
		for(int i =0; i<size;i++)
		{
			if(liste[i]==valeur)
			{
				return true;
			}
		}
		return false;
	}

}
