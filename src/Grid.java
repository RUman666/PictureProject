import java.awt.Point;
import java.util.ArrayList;


public class Grid 
{
	
	private Human human;
	private ArrayList<Robot> robots = new ArrayList<Robot>();
	private ArrayList<JunkHeap> junkHeaps = new ArrayList<JunkHeap>();
	
	private int width;

	public Grid(int width, int robotCount, int imgWidth)
	{
		this.width = width;
		
		human = new Human(new Point(0, 0), imgWidth);
		
		for(int i=1 ; i<=robotCount ; i++)
		{			
			robots.add(new Robot(getRandomUnoccupiedTile(), imgWidth));
		}
		
		human.setLoc(getRandomUnoccupiedTile());
		
	}
	
	public Human getHuman()
	{
		return human;
	}
	
	public ArrayList<Robot> getRobots()
	{
		return robots;
	}
	
	public ArrayList<JunkHeap> getJunkHeaps()
	{
		return junkHeaps;
	}
	
	public Actor[][] getGrid()
	{
		Actor[][] grid = new Actor[width][width];
		grid[human.getLoc().x][human.getLoc().y] = human;
		for(Robot a : robots){
			grid[a.getLoc().x][a.getLoc().y] = a;
		}
		for(JunkHeap a : junkHeaps){
			grid[a.getLoc().x][a.getLoc().y] = a;
		}
		return grid;
	}
	
	public boolean isHuman(Point loc){
		return loc.equals(human.getLoc());
	}
	
	public boolean isRobot(Point loc){
		for(Robot a : robots)
			if(loc.equals(a.getLoc()))
				return true;
		return false;
	}
	
	public boolean isJunkHeap(Point loc){
		for(JunkHeap a : junkHeaps)
			if(loc.equals(a.getLoc()))
				return true;
		return false;
	}
	
	public boolean isGameOver()
	{
		for(Robot robot : robots)
			if(robot.getLoc().equals(human.getLoc()))
				return true;
		
		for(JunkHeap junkHeap : junkHeaps)
			if(junkHeap.getLoc().equals(human.getLoc()))
				return true;
		
		return false;
	}
	
	public Point getRandomUnoccupiedTile()
	{
		Actor[][] actors = getGrid();
		
		int x, y;
		do
		{
			x = (int) (Math.random() * width);
			y = (int) (Math.random() * width);
		}
		while (actors[x][y] != null);
		
		return new Point(x, y);
	}
	
}





