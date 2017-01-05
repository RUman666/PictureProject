import java.awt.Point;



public abstract class Actor 
{

	private Point loc;
	
	private int width, height;
	
	private Picture sprite;
	
	public Actor(String imgPath, int newWidth, Point loc)
	{
		this.loc = loc;
		this.width = newWidth;
		this.height = newWidth;
		
		sprite = new Picture(imgPath);
		
		int imgWidth = sprite.getWidth(), imgHeight = sprite.getHeight();
		sprite = sprite.scale((double) width / imgWidth, (double) height / imgHeight);
	}
	
	public Picture getSprite()
	{
		return sprite;
	}
	
	public Point getLoc()
	{
		return loc;
	}
	
	public void setLoc(Point newLoc)
	{
		loc = newLoc;
	}

}
