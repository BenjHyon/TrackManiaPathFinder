package pathfinder;

import java.util.ArrayList;

public class Race {
	
	private ArrayList<ArrayList<Integer>> Verboten;
	private int Nbmax;
	private int current;
	private int startCP_id;
	private ArrayList <Integer> Path;
	private ArrayList <ArrayList<Integer>> PathFound;
	private ArrayList <checkPoint> CP;
	private int nbPath;
	private int endCP;
	
	public Race(int nbMax, int startCP, ArrayList <checkPoint> CP, int nbCp, int endCP)
	{
	    Verboten = new ArrayList<ArrayList<Integer>>();
		Nbmax = nbMax;
		this.CP = CP;
		this.startCP_id = startCP;
		for(int i = 0; i<Nbmax; i++) {
            Verboten.add(new ArrayList<Integer>());
        }
        this.Path = new ArrayList<Integer>();
		this.endCP = endCP;
		this.PathFound = new ArrayList<ArrayList<Integer>>();
	}
	
	public int Run()
	{

		Path.add(0);
		Path.add(startCP_id);
		current = 1;
		int next_Cp;
		while(true){
			next_Cp = CP.get(Path.get(current)-1).nextCP(Path.get(current-1),Verboten.get(current));
			if(next_Cp != -1)
			{
				Path.add(next_Cp);
				current += 1;
			}
			if(next_Cp == -1 || Nbmax-3 < current)
			{
                stepBack();
            }


            if (next_Cp == endCP && allChecked())
			{
				System.out.println("a path has been found !");
                printPath();
                System.out.println("\n");
				PathFound.add(makeDeepCopyInteger(this.Path));
				stepBack();
			}
			else if (next_Cp == endCP && !allChecked())
			{
				stepBack();
			}

			if(current == 0 && next_Cp == -1)
            {
                return 0;
            }

            if(next_Cp == 0)
            {
                stepBack();
            }


		}



		
	}

    private ArrayList<Integer> makeDeepCopyInteger(ArrayList<Integer> old)
    {
        ArrayList<Integer> copy = new ArrayList<Integer>(old.size());
        for(Integer i : old){
            copy.add(new Integer(i));
        }
        return copy;
    }

	public void printPathFound()
    {
        nbPath = 0;
        for(int i =0; i<PathFound.size();i++)
        {

            Path = PathFound.get(i);
			System.out.println("size: "+Path.size());
            printPath();
            System.out.println("\n");
        }
    }
	private void stepBack()
	{
		Verboten.get(current-1).add(Path.get(current));
		Verboten.remove(current);
        Verboten.add(new ArrayList<Integer>());
		Path.remove(current);
		current -= 1;
	}

	private void printPath()
    {
        this.nbPath += 1;
        System.out.println("printing path number "+nbPath);
        for (int i = 0; i<this.Path.size();i++)
        {
            System.out.print(" "+Path.get(i)+" ");
        }
        System.out.println("");
    }

	private Boolean allChecked()
	{
		for(int i =0; i < CP.size(); i++)
		{
			if(!Path.contains(CP.get(i).getCPID()))
			{
				return false;
			}
		}
		return true;
	}

}
