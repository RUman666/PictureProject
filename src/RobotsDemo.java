import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.ImageObserver;
import java.util.ArrayList;



public class RobotsDemo extends FlexiblePictureExplorer implements ImageObserver
{
	
	private final String splashPath = "RobotPics/loadingscreen.png";
	private final String title = "Robots";
	private final Color bgColor = Color.gray;
	
	//game settings ; how many robots there are & how many to add each round
	private int robotsToAdd = 30;
	private final int robotsIncrement = 10;
	private final int robotsMax = 1000;
	
	private final static int statsHeight = 80;//how many pixels  we need to print teleports and points
	private final static int textPadding = statsHeight/2;
	//goal is the width/height we want, program will round to closest value based on gridWidth
	private final static int goalImageWidth = 720;
	private final static int goalGridImgWidth = goalImageWidth - statsHeight;
	
	//calculated bounds of the gui
	private int gridWidth;
	private int imageHeight;
	private int imageWidth;
	private int gridImgWidth;
	private int gridImgHeight;
	private int tileWidth;
	
	private Grid grid;

	private int availableTeleports = 9999;
	private boolean isGameOver = false;
	private boolean lockUserAction = true;
	
	private int playerPoints = 0;


	
	public RobotsDemo(int gridWidth) 
	{
		super(new Picture(closestMultiple(gridWidth) + statsHeight, closestMultiple(gridWidth)));
		this.gridWidth = gridWidth;
		
		imageWidth = closestMultiple(gridWidth);
		imageHeight = imageWidth + statsHeight;
		gridImgWidth = imageWidth;
		gridImgHeight = gridImgWidth;
		
		tileWidth = gridImgWidth / gridWidth;
		
		grid = new Grid(gridWidth, robotsToAdd, tileWidth);
		
		activateSplash();
		
		updateVisual();
	}
	
	//rounds imageWidth to the closest multiple of gridWidth to prevent rounding errors in the picture
	public static int closestMultiple(int gridWidth)
	{
		int mod = goalGridImgWidth % gridWidth;
		if(mod > gridWidth / 2)
			return goalGridImgWidth + gridWidth - mod;
		else
			return goalGridImgWidth - mod;
	}

	//set the screen to preset splash image
	private void activateSplash()
	{
		Picture baseImg = new Picture(splashPath);
		double xFactor = (double) gridImgWidth / baseImg.getWidth();
		double yFactor = (double) gridImgHeight / baseImg.getHeight();
				
		Picture img = new Picture(splashPath).scale(xFactor, yFactor);
		setImage(img);
		setTitle(title);
	}
	
	private void drawBgColor(Picture pic)
	{
		Pixel[][] pixels = pic.getPixels2D();
		for(int x=0 ; x<gridImgWidth ; x++)
			for(int y=0 ; y<gridImgHeight ; y++)
				pixels[y][x].setColor(bgColor);
	}
	
	private void drawGridLines(Picture pic)
	{
		Pixel[][] pixels = pic.getPixels2D();
		for(int x=0 ; x<gridImgWidth ; x+=tileWidth)
			for(int y=0 ; y<gridImgHeight ; y++)
				pixels[y][x].setColor(Color.black);
		
		for(int x=0 ; x<gridImgWidth ; x++)
			for(int y=0 ; y<gridImgHeight ; y+=tileWidth)
				pixels[y][x].setColor(Color.black);

		for(int x=0 ; x<gridImgWidth ; x++)
			pixels[gridImgHeight-1][x].setColor(Color.black);
	}
	
	//remakes the image based on new robots and human positions
	private void updateVisual()
	{
		//dont let user move while creating picture
		lockUserAction = true;
		
		Picture disp = new Picture(imageHeight, imageWidth);
		Actor[][] actors = grid.getGrid();
		drawBgColor(disp);
		
		//draw humans, robots and junk heaps
		for(int col=0 ; col<gridWidth ; col++)
		{
			for(int row=0 ; row<gridWidth ; row++)
			{
				Actor actor = actors[col][row];
				if(actor != null)
					disp.copy(actor.getSprite(), row * tileWidth, col * tileWidth);
			}
		}
		
		drawStats(disp);
		drawGridLines(disp);
		
		setImage(disp);
		setTitle(title);
		//set image resets the title so must call setTitle after every setImage call
		
		lockUserAction = false;
	}

	//uses Graphics class to create image with (Strings) of info
	private void drawStats(Picture img)
	{		
		Picture statsImg = new Picture(statsHeight, imageWidth);
		Graphics g = statsImg.getGraphics();
		g.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		g.setColor(Color.blue);
		
		g.drawString(getTeleportDesc(), textPadding, statsHeight - textPadding/2);
		g.drawString(getPointDesc(), imageWidth/2 + textPadding, statsHeight - textPadding/2);
		
		if(isGameOver)
		{
			g.setColor(new Color(20, 20, 20));
			g.setFont(new Font("Times New Roman", Font.BOLD, 20));
			g.drawString("Game Over", imageWidth/2, textPadding/2);
		}
		
		img.copy(statsImg, gridImgHeight, 0);
	}
	
	private String getPointDesc()
	{
		return "Points: " + playerPoints;
	}
	
	private String getTeleportDesc()
	{
		return "Teleports left: " + availableTeleports;
	}

	private void move(Point newHumanLoc)
	{
		grid.getHuman().setLoc(newHumanLoc);
		
		moveRobots();
		
		if(grid.isGameOver())
			isGameOver = true;
		
		updateVisual();
		

	}
	
	private void moveRobots()
	{
		ArrayList<Point> robotDests = calculateRobotMoves();
		
		for(int i=0 ; i<robotDests.size() ; i++)
		{
			if(grid.isJunkHeap(robotDests.get(i)))
			{
				robotDests.remove(i);
				grid.getRobots().remove(i);
				i--;
				
				playerPoints++;
			}
			else if(containsDupe(robotDests, robotDests.get(i)))
			{
				grid.getJunkHeaps().add(new JunkHeap(robotDests.get(i), tileWidth));
				
				robotDests.remove(i);
				grid.getRobots().remove(i);
				i--;
				
				playerPoints++;
			}
			else
			{
				grid.getRobots().get(i).setLoc(robotDests.get(i));
			}
			
		}

	}
	
	//locs is expected to contain the point already, this checks if it occurs twice
	private boolean containsDupe(ArrayList<Point> locs, Point suspect)
	{
		boolean foundOnce = false;
		
		for(int i=0 ; i<locs.size() ; i++)
		{
			if(locs.get(i).equals(suspect))
			{
				if(foundOnce)
					return true;
				else
					foundOnce = true;
			}
		}
		
		return false;
	}
	
	private ArrayList<Point> calculateRobotMoves()
	{
		ArrayList<Point> moves = new ArrayList<Point>(grid.getRobots().size());
		for(int i=0 ; i<grid.getRobots().size() ; i++)
		{
			moves.add(getRobotMove(grid.getRobots().get(i)));
		}
		
		return moves;
	}
	
	private Point getRobotMove(Robot robby)
	{
		Point loc = robby.getLoc();
		Point humanLoc = grid.getHuman().getLoc();
		int destX = loc.x, destY = loc.y;
		
		if(loc.x != humanLoc.x)
			destX += humanLoc.x > loc.x ? 1 : -1;

		if(loc.y != humanLoc.y)
			destY += humanLoc.y > loc.y ? 1 : -1;
		
		return new Point(destX, destY);
	}

	private boolean isAdjacent(Point a, Point b)
	{
		 ArrayList<Point> adjacentCandidates = getAdjacentTiles(a);
		 return adjacentCandidates.contains(b);
	}
	
	private ArrayList<Point> getAdjacentTiles(Point loc)
	{
		ArrayList<Point> tiles = new ArrayList<Point>(8);

		for(int i=-1 ; i<=1 ; i++)
			for(int j=-1 ; j<=1 ; j++)
				if(! ((i == 0) && (j == 0)))
					tiles.add(new Point(loc.x+i, loc.y+j));
						
		return tiles;
	}
	
	private boolean isAdjacentToRobot(Point loc)
	{
		ArrayList<Point> adjacentTiles = getAdjacentTiles(loc);
		for(Point tile : adjacentTiles)
			if(isValidTile(tile) && grid.isRobot(tile))
				return true;
		
		return false;
	}

	@Override
	public void mouseClickedAction(DigitalPicture pict, Pixel pixel) 
	{
		if(isGameOver || lockUserAction)
			return;
		
		Point clickedLoc = getGridLoc(pixel);
		
		if(grid.isJunkHeap(clickedLoc))//you cant walk into a junk heap
		{
			return;
		}
		else if(grid.isRobot(clickedLoc))//can not walk into a robot
		{
			return;
		}
		else if(clickedLoc.equals(grid.getHuman().getLoc()))
		{
			if(isAdjacentToRobot(grid.getHuman().getLoc()) && (availableTeleports > 0))//not allowed
				return;
			
			playerPoints++;//you get a point for staying still
			move(clickedLoc);
		}
		else if(isAdjacent(clickedLoc, grid.getHuman().getLoc()))
		{
			if(isAdjacentToRobot(clickedLoc) && (availableTeleports > 0))//not allowed
				return;
			
			move(clickedLoc);
		}
		else
		{
			if(! isValidTile(clickedLoc))
				return;
			
			if(availableTeleports > 0)
				teleport();
			else
				return;

		}

		if(grid.getRobots().size() < 1 && (! isGameOver))
		{
			resetGrid();
			updateVisual();
		}
	}
	
	private void resetGrid()
	{		
		if((robotsToAdd + robotsIncrement) <= robotsMax)
			robotsToAdd += robotsIncrement;
		
		grid = new Grid(gridWidth, robotsToAdd, tileWidth);
		
		availableTeleports += 2;

	}
	
	private void teleport()
	{
		availableTeleports--;
		
		Point teleLoc;
		do
		{
			teleLoc = grid.getRandomUnoccupiedTile();
		}
		while(isAdjacentToRobot(teleLoc));
		
		move(teleLoc);
	}
	
	private boolean isValidTile(Point tile)
	{
		if(tile.x < 0 || tile.x >= gridWidth)
			return false;
		if(tile.y < 0 || tile.y >= gridWidth)
			return false;
		
		return true;
	}
	
	private Point getGridLoc(Pixel pixel)
	{
		int x = pixel.getX() / tileWidth;
		int y = pixel.getY() / tileWidth;
		
		return new Point(x, y);
	}	
	
	public static void main(String[] args)
	{
		new RobotsDemo(40);
	}

	@Override
	public boolean imageUpdate(Image arg0, int arg1, int arg2, int arg3,int arg4, int arg5) {
		//method from implementing ImageObserver (the input is not needed)
		return false;
	}
	
}
