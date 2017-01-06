
public class RPGBattle extends FlexiblePictureExplorer {

	public RPGBattle(Picture backGround, Picture[] warriorSprites,
			Picture[][] warriorMenu, Picture[] ninjaSprites, Picture[][] ninjaMenu,
			Picture[] healerSprites, Picture[][] healerMenu) {
		super(backGround);
		setTitle("RBG battle");
		bg = backGround;
		war1 = new Warrior(warriorSprites, warriorMenu);
		nin1 = new Ninja(ninjaSprites, ninjaMenu);
		heal1 = new Healer(healerSprites, healerMenu);
		turn = 1;

		System.out.println("Warrior HP: " + war1.HP);
		System.out.println("Ninja HP: " + nin1.HP);
		System.out.println("Healer HP: " + heal1.HP);
		setCharacters();
		setMenu();
	}

	Warrior war1;
	Ninja nin1;
	Healer heal1;

	private Picture bg;
	public int turn;
	public final int NINJA = 1;
	public final int HEALER = 2;
	public final int MAGE = 3;
	public final int WARRIOR = 4;
	public final int ENEMY = 5;

	private void setCharacters() {
		bg.copy(war1.getPic(), 200, 100);
		bg.copy(nin1.getPic(), 250, 75);
		bg.copy(heal1.getPic(), 150, 50);
	}

	@Override
	public void mouseClickedAction(DigitalPicture pict, Pixel pix) {
		int area = whichArea(pix);
		if (area == 5) {
			war1.tookHit(100);
			System.out.println("Warrior HP: " + war1.HP + "/" + war1.maxHP);
		}
		if (area == 6) {
			nin1.tookHit(100);
			System.out.println("Ninja HP: " + nin1.HP + "/" + nin1.maxHP);
		}
		if (area == 7) {
			heal1.tookHit(100);
			System.out.println("Healer HP: " + heal1.HP + "/" + heal1.maxHP);
		}
		setCharacters();
	}

	private int whichArea(Pixel pix) {
		int output = 0;
		if (pix.getCol() > 25 && pix.getCol() < 250 && pix.getRow() > 300
				&& pix.getRow() < 400)
			output = 1;
		if (pix.getCol() > 250 && pix.getCol() < 475 && pix.getRow() > 300
				&& pix.getRow() < 400)
			output = 2;
		if (pix.getCol() > 25 && pix.getCol() < 250 && pix.getRow() > 400
				&& pix.getRow() < 500)
			output = 3;
		if (pix.getCol() > 250 && pix.getCol() < 475 && pix.getRow() > 400
				&& pix.getRow() < 500)
			output = 4;
		if (pix.getCol() > 100 && pix.getCol() < 150 && pix.getRow() > 200
				&& pix.getRow() < 250)
			output = 5;
		if (pix.getCol() > 75 && pix.getCol() < 125 && pix.getRow() > 250
				&& pix.getRow() < 300)
			output = 6;
		if (pix.getCol() > 50 && pix.getCol() < 100 && pix.getRow() > 150
				&& pix.getRow() < 200)
			output = 7;
		return output;
	}

	public Picture[] getMenu() {
		Picture[] output = new Picture[4];
		if (turn == NINJA) {
			for (int i = 0; i < 4; i++)
				output[i] = nin1.sendMenu()[i];
		}
		if (turn == WARRIOR) {
			for (int i = 0; i < 4; i++)
				output[i] = war1.sendMenu()[i];
		}
		if (turn == HEALER) {
			for (int i = 0; i < 4; i++)
				output[i] = heal1.sendMenu()[i];
		}
		return output;
	}

	private void setMenu() {
		Picture[] display = new Picture[4];
		for (int i = 0; i < 4; i++)
			display[i] = getMenu()[i];
		bg.copy(display[0], 300, 25);
		bg.copy(display[1], 300, 250);
		bg.copy(display[2], 400, 25);
		bg.copy(display[3], 400, 250);
	}

	public static void main(String[] args) {
		String basepath = "IndependentPictures\\";
		Picture[] warriorPics = { new Picture(basepath + "Person1Healthy.jpg"),
				new Picture(basepath + "Person1Wounded.jpg"),
				new Picture(basepath + "Person1Down.jpg") };
		Picture[] ninjaPics = { new Picture(basepath + "Person2Healthy.jpg"),
				new Picture(basepath + "Person2Wounded.jpg"),
				new Picture(basepath + "Person2Down.jpg") };
		Picture[] healerPics = { new Picture(basepath + "Person3Healthy.jpg"),
				new Picture(basepath + "Person3Wounded.jpg"),
				new Picture(basepath + "Person3Down.jpg") };
		Picture[][] warriorMenu = { {new Picture(basepath + "FightButton.jpg"),
				new Picture(basepath + "BlockButton.jpg"),
				new Picture(basepath + "ItemButton.jpg"),
				new Picture(basepath + "TechButton.jpg")} };
		Picture[][] ninjaMenu = { {new Picture(basepath + "FightButton.jpg"),
				new Picture(basepath + "BlockButton.jpg"),
				new Picture(basepath + "ItemButton.jpg"),
				new Picture(basepath + "TechButton.jpg")} };
		Picture[][] healerMenu = { {new Picture(basepath + "FightButton.jpg"),
				new Picture(basepath + "BlockButton.jpg"),
				new Picture(basepath + "ItemButton.jpg"),
				new Picture(basepath + "HealButton.jpg")} };

		Picture backGround = new Picture(basepath + "BackGround.jpg"); // BackGround
																		// size:
																		// 500x500
		RPGBattle battle = new RPGBattle(backGround, warriorPics, warriorMenu,
				ninjaPics, ninjaMenu, healerPics, healerMenu);

	}

}
