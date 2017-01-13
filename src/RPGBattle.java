public class RPGBattle extends FlexiblePictureExplorer {

	public RPGBattle(Picture backGround, Picture[] warriorSprites,
			Picture[][] warriorMenu, Picture[] ninjaSprites,
			Picture[][] ninjaMenu, Picture[] healerSprites,
			Picture[][] healerMenu, Picture[] wizardSprites, Picture[][] wizardMenu,
			Picture[] enemyPics) {
		super(backGround);
		setTitle("RBG battle");
		bg = backGround;
		war1 = new Warrior(warriorSprites, warriorMenu);
		nin1 = new Ninja(ninjaSprites, ninjaMenu);
		heal1 = new Healer(healerSprites, healerMenu);
		wiz1 = new Wizard(wizardSprites, wizardMenu);
		enemy = new Enemy(enemyPics, 1);
		turn = 1;
		setCharacters();
		setMenu();
	}

	private Warrior war1;
	private Ninja nin1;
	private Healer heal1;
	private Wizard wiz1;
	private Enemy enemy;

	private Picture bg;
	public int turn;
	public final int NINJA = 1;
	public final int HEALER = 2;
	public final int MAGE = 3;
	public final int WARRIOR = 4;
	public final int ENEMY = 5;

	private void setCharacters() {
		bg.copy(war1.getPic(), 200, 100);
		drawFriendlyHP(war1, 100, 200);
		bg.copy(nin1.getPic(), 250, 75);
		drawFriendlyHP(nin1, 75, 250);
		bg.copy(heal1.getPic(), 190, 25);
		drawFriendlyHP(heal1, 25, 190);
		bg.copy(wiz1.getPic(), 140, 75);
		drawFriendlyHP(wiz1, 75, 140);
		bg.copy(enemy.getPic(), 175, 250);
		drawEnemyHP(enemy, 250, 175);
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
		if (area == 8) {
			wiz1.tookHit(100);
			System.out.println("Wizard HP: " + wiz1.HP + "/" + wiz1.maxHP);
		}
		if (area == 9){
			enemy.tookHit(100);
			System.out.println("Enemy HP: " + enemy.HP + "/" + enemy.maxHP);
		}
		setCharacters();
	}

	public Warrior getWar() {
		return war1;
	}

	public Ninja getNin() {
		return nin1;
	}

	public Healer getHeal() {
		return heal1;
	}
	
	public Wizard getWiz() {
		return wiz1;
	}
	
	public Picture getBackGround(){
		return bg;
	}
	
	public RPGBattle get(){
		return this;
	}
	
	private void drawFriendlyHP(Friendly friend, int xcoord, int ycoord){
		int last = xcoord;
		Pixel storage;
		for (int i = xcoord; i < xcoord + (50 * friend.HP / friend.maxHP); i++){
			for (int j = ycoord - 10; j <= ycoord; j++){
				storage = bg.getPixel(i, j);
				storage.setBlue(0);
				storage.setGreen(0);
				storage.setRed(255);
			}
			last = i;
		}
		for (int i = last; i < xcoord + 50; i++){
			for (int j = ycoord - 10; j <= ycoord; j++){
				storage = bg.getPixel(i, j);
				storage.setBlue(53);
				storage.setRed(171);
				storage.setGreen(211);
			}
		}
	}
	
	public void drawEnemyHP(Enemy enemy, int xcoord, int ycoord){
		int last = xcoord;
		Pixel storage;
		for (int i = xcoord; i < xcoord + (150 * enemy.HP / enemy.maxHP); i++){
			for (int j = ycoord - 10; j <= ycoord; j++){
				storage = bg.getPixel(i, j);
				storage.setBlue(0);
				storage.setGreen(0);
				storage.setRed(255);
			}
			last = i;
		}
		for (int i = last; i < xcoord + 150; i++){
			for (int j = ycoord - 10; j <= ycoord; j++){
				storage = bg.getPixel(i, j);
				storage.setBlue(53);
				storage.setRed(171);
				storage.setGreen(211);
			}
		}
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
		if (pix.getCol() > 25 && pix.getCol() < 75 && pix.getRow() > 190
				&& pix.getRow() < 240)
			output = 7;
		if (pix.getCol() > 75 && pix.getCol() < 125 && pix.getRow() > 140
				&& pix.getRow() < 190)
			output = 8;
		if (pix.getCol() > 250 && pix.getCol() < 400 && pix.getRow() > 175
			&& pix.getRow() < 275)
			output = 9;
			
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
		Picture[] wizardPics = { new Picture(basepath + "Person4Healthy.jpg"),
				new Picture(basepath + "Person4Wounded.jpg"),
				new Picture(basepath + "Person4Down.jpg")};
		Picture[] enemyPics = { new Picture(basepath + "Enemy1.jpg")};
		
		Picture[][] warriorMenu = { {
				new Picture(basepath + "FightButton.jpg"),
				new Picture(basepath + "BlockButton.jpg"),
				new Picture(basepath + "ItemButton.jpg"),
				new Picture(basepath + "TechButton.jpg") } };
		Picture[][] ninjaMenu = { { new Picture(basepath + "FightButton.jpg"),
				new Picture(basepath + "BlockButton.jpg"),
				new Picture(basepath + "ItemButton.jpg"),
				new Picture(basepath + "TechButton.jpg") } };
		Picture[][] healerMenu = { { new Picture(basepath + "FightButton.jpg"),
				new Picture(basepath + "BlockButton.jpg"),
				new Picture(basepath + "ItemButton.jpg"),
				new Picture(basepath + "HealButton.jpg") } };
		Picture[][] wizardMenu = { { new Picture(basepath + "FightButton.jpg"),
				new Picture(basepath + "BlockButton.jpg"),
				new Picture(basepath + "ItemButton.jpg"),
				new Picture(basepath + "MagicButton.jpg")
		} };

		Picture backGround = new Picture(basepath + "BackGround.jpg"); // BackGround
																		// size:
																		// 500x500
		new RPGBattle(backGround, warriorPics, warriorMenu,
				ninjaPics, ninjaMenu, healerPics, healerMenu, wizardPics, wizardMenu,
				enemyPics);

	}

}
