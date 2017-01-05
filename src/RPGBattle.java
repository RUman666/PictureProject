
public class RPGBattle extends FlexiblePictureExplorer {
	
	public RPGBattle(Picture[] menuPictures, Picture backGround, Picture[] warriorSprites) {
		super(backGround);
		
		Warrior war1 = new Warrior(warriorSprites, menuPictures);
	}

	Warrior war1;
	Ninja nin1;
	private Picture[] cPics;
	private Picture[] menuPics;
	private Picture bg;
	private int menu = 1;
	public final int WARRIOR = 1;
	public final int ROGUE = 2;
	public final int HEALER = 3;
	public final int MAGE = 4;
	public final int ENEMY = 5;

	private void setCharacters(){
		bg.copy(war1.getPic(), 200, 100);
		bg.copy(nin1.getPic(), 250, 75);
	}
	private void resetMenu(){
		menu = 1;
		bg.copy(menuPics[0], 300, 25);
		bg.copy(menuPics[1], 300, 250);
		bg.copy(menuPics[2], 400, 25);
		bg.copy(menuPics[3], 400, 250);
	}

	@Override
	public void mouseClickedAction(DigitalPicture pict, Pixel pix) {
		
	}

	private int whichArea(Pixel pix){
		int output = 0;
		if (pix.getCol() > 25 && pix.getCol() < 250 && pix.getRow() > 300 && pix.getRow() < 400)
			output = 1;
		if (pix.getCol() > 250 && pix.getCol() < 475 && pix.getRow() > 300 && pix.getRow() < 400)
			output = 2;
		if (pix.getCol() > 25 && pix.getCol() < 250 && pix.getRow() > 400 && pix.getRow() < 500)
			output = 3;
		if (pix.getCol() > 250 && pix.getCol() < 475 && pix.getRow() > 400 && pix.getRow() < 500)
			output = 4;
		return output;
	}
	
	public static void main(String[] args) {
		String basepath = "IndependentPictures\\";
		Picture[] menuPictures = {
				new Picture(basepath + "FightButton.jpg"),
				new Picture(basepath + "BlockButton.jpg"),
				new Picture(basepath + "ItemButton.jpg"),
				new Picture(basepath + "MagicButton.jpg")
		};

		
		//Picture backGround = new Picture(basepath + "BackGround.jpg");
		//RPGBattle battle = new RPGBattle(menuPictures, backGround, characterPictures);
		Picture[] warriorPics = {
				new Picture(basepath + "Person1Healthy.jpg"),
				new Picture(basepath + "Person1Wounded.jpg"),
				new Picture(basepath + "Person1Down.jpg")
		};
		

		}
	

}
