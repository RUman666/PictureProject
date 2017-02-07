public class RPGBattle extends FlexiblePictureExplorer {

	public RPGBattle(Picture backGround, Picture victory, Picture defeat,Picture[] warriorSprites,
			Picture[][] warriorMenu, Picture[] ninjaSprites,
			Picture[][] ninjaMenu, Picture[] healerSprites,
			Picture[][] healerMenu, Picture[] wizardSprites, Picture[][] wizardMenu,
			Picture[] enemyPics, Inventory inven) {
		super(backGround);
		level = 1;
		setTitle("RBG battle");
		bg = backGround;
		victoryScreen = victory;
		defeatScreen = defeat;
		war1 = new Warrior(warriorSprites, warriorMenu, inven, this);
		nin1 = new Ninja(ninjaSprites, ninjaMenu, inven, this);
		heal1 = new Healer(healerSprites, healerMenu, inven, this);
		wiz1 = new Wizard(wizardSprites, wizardMenu, inven, this);
		enemy = new Enemy(enemyPics, level, this);
		turn = NINJA;
		setCharacters();
		setMenu(nin1.getMenu());
	}

	private Warrior war1;
	private Ninja nin1;
	private Healer heal1;
	private Wizard wiz1;
	private Enemy enemy;
	
	private Picture blankPointer = new Picture("IndependentPictures\\" + "Blank.jpg");
	private Picture arrow = new Picture("IndependentPictures\\" + "Pointer.jpg");
	
	private Picture victoryScreen;
	private Picture defeatScreen;
	private Picture bg;
	public int turn;
	public int level;
	public final int NINJA = 1;
	public final int HEALER = 3;
	public final int WIZARD = 2;
	public final int WARRIOR = 4;
	public final int ENEMY = 5;
	private boolean gameOver = false;
	
	private void setCharacters() {
		if (!(gameOver)){
			bg.copy(war1.getPic(), 200, 100);
			drawFriendlyHP(war1, 100, 200);
			drawFriendlyMP(war1, 100, 200);
			bg.copy(nin1.getPic(), 250, 75);
			drawFriendlyHP(nin1, 75, 250);
			drawFriendlyMP(nin1, 75, 250);
			bg.copy(heal1.getPic(), 190, 25);
			drawFriendlyHP(heal1, 25, 190);
			drawFriendlyMP(heal1, 25, 190);
			bg.copy(wiz1.getPic(), 140, 75);
			drawFriendlyHP(wiz1, 75, 140);
			drawFriendlyMP(wiz1, 75, 140);
			bg.copy(enemy.getPic(), 175, 250);
			drawEnemyHP(enemy, 250, 175);
			drawpointer();
		}
	}
	
	private void drawpointer(){
		if (turn == WARRIOR) 
			bg.copy(arrow, 180, 120); 
		else 
			bg.copy(blankPointer, 180, 120);
		if (turn == NINJA)
			bg.copy(arrow, 230, 95);
		else
			bg.copy(blankPointer, 230, 95);
		if (turn == HEALER)
			bg.copy(arrow, 170, 45);
		else
			bg.copy(blankPointer, 170, 45);
		if (turn == WIZARD)
			bg.copy(arrow, 120, 95);
		else
			bg.copy(blankPointer, 120, 95);
		
	}

	public void newEnemy(){
		if (level != enemy.getPics().length){
			level++;
			enemy = new Enemy(enemy.getPics(), level,  this);
		}else {
			endGame();
		}
		
	}
	
	public void endGame(){
		if (enemy.HP <= 0){
			bg.copy(victoryScreen, 0, 0);
		}else {
			bg.copy(defeatScreen, 0, 0);
		}
		gameOver = true;
	}
	
	public void mouseClickedAction(DigitalPicture pict, Pixel pix) {
		if (!(gameOver)){
			int area = whichArea(pix);
			if (turn == ENEMY){
				if (enemy.HP > 0){
					enemy.turn();
				}else {
					nextTurn();
				}	
			}
			else if (turn == NINJA){
				if (nin1.HP > 0)
				nin1.turn(area);
				else {
					nextTurn();
				}
			}
			else if (turn == WIZARD){
				if (wiz1.HP > 0){
					wiz1.turn(area);
				}else {
					nextTurn();
				}
			}
			else if (turn == HEALER){
				if (heal1.HP > 0){
					heal1.turn(area);
				}else {
					nextTurn();
				}
			}
			else if (turn == WARRIOR){
				if (war1.HP > 0){
					war1.turn(area);
				}else {
					nextTurn();
				}
			}
			setCharacters();
		}
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
	
	public Enemy getEnemy(){
		return enemy;
	}
	
	public Picture getBg(){
		return bg;
	}
	
	public RPGBattle get(){
		return this;
	}
	
	public void nextTurn(){
		if (turn == ENEMY){
			turn = NINJA;
		}else {
			turn++;
		}
	}
	
	private void drawFriendlyHP(Friendly friend, int xcoord, int ycoord){
		int last = xcoord;
		Pixel storage;
		for (int i = xcoord; i < xcoord + (50 * friend.HP / friend.maxHP); i++){
			for (int j = ycoord - 5; j <= ycoord; j++){
				storage = bg.getPixel(i, j);
				storage.setBlue(0);
				storage.setGreen(0);
				storage.setRed(255);
			}
			last = i;
		}
		for (int i = last; i < xcoord + 50; i++){
			for (int j = ycoord - 5; j <= ycoord; j++){
				storage = bg.getPixel(i, j);
				storage.setBlue(53);
				storage.setRed(171);
				storage.setGreen(211);
			}
		}
	}
	
	private void drawFriendlyMP(Friendly friend, int xcoord, int ycoord){
		int last = xcoord;
		Pixel storage;
		for (int i = xcoord; i < xcoord + (50 * friend.HP / friend.maxHP); i++){
			for (int j = ycoord - 10; j <= ycoord - 5; j++){
				storage = bg.getPixel(i, j);
				storage.setBlue(255);
				storage.setGreen(0);
				storage.setRed(0);
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
		int output = -1;
		if (pix.getCol() > 25 && pix.getCol() < 250 && pix.getRow() > 300
				&& pix.getRow() < 400)
			output = 0;
		if (pix.getCol() > 250 && pix.getCol() < 475 && pix.getRow() > 300
				&& pix.getRow() < 400)
			output = 1;
		if (pix.getCol() > 25 && pix.getCol() < 250 && pix.getRow() > 400
				&& pix.getRow() < 500)
			output = 2;
		if (pix.getCol() > 250 && pix.getCol() < 475 && pix.getRow() > 400
				&& pix.getRow() < 500)
			output = 3;
		if (pix.getCol() > 100 && pix.getCol() < 150 && pix.getRow() > 200
				&& pix.getRow() < 250)
			output = 4;
		if (pix.getCol() > 75 && pix.getCol() < 125 && pix.getRow() > 250
				&& pix.getRow() < 300)
			output = 5;
		if (pix.getCol() > 25 && pix.getCol() < 75 && pix.getRow() > 190
				&& pix.getRow() < 240)
			output = 6;
		if (pix.getCol() > 75 && pix.getCol() < 125 && pix.getRow() > 140
				&& pix.getRow() < 190)
			output = 7;
		if (pix.getCol() > 250 && pix.getCol() < 400 && pix.getRow() > 175
			&& pix.getRow() < 275)
			output = 8;
		return output;
	}


	public void setMenu(Picture[] menu) {
		if (!(gameOver)){
			bg.copy(menu[0], 300, 25);
			bg.copy(menu[1], 300, 250);
			bg.copy(menu[2], 400, 25);
			bg.copy(menu[3], 400, 250);
		}
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
		Picture[] enemyPics = { new Picture(basepath + "Enemy1.jpg"),
				new Picture(basepath + "Enemy2.jpg")};
		
		Picture[][] warriorMenu = { {
				new Picture(basepath + "FightButton.jpg"),
				new Picture(basepath + "BlockButton.jpg"),
				new Picture(basepath + "ItemButton.jpg"),
				new Picture(basepath + "TechButton.jpg") },
				{new Picture(basepath + "TechTest1.jpg"),
				new Picture(basepath + "TechTest2.jpg"),
				new Picture(basepath + "TechTest3.jpg"),
				new Picture(basepath + "BackButton.jpg")
				}};
		Picture[][] ninjaMenu = { { new Picture(basepath + "FightButton.jpg"),
				new Picture(basepath + "BlockButton.jpg"),
				new Picture(basepath + "ItemButton.jpg"),
				new Picture(basepath + "TechButton.jpg") },
				{new Picture(basepath + "TechTest1.jpg"),
				new Picture(basepath + "TechTest2.jpg"),
				new Picture(basepath + "TechTest3.jpg"),
				new Picture(basepath + "BackButton.jpg") }
				};
		Picture[][] healerMenu = { { new Picture(basepath + "FightButton.jpg"),
				new Picture(basepath + "BlockButton.jpg"),
				new Picture(basepath + "ItemButton.jpg"),
				new Picture(basepath + "HealButton.jpg") },
				{new Picture(basepath + "HealTest1.jpg"),
				new Picture(basepath + "HealTest2.jpg"),
				new Picture(basepath + "HealTest3.jpg"),
				new Picture(basepath + "BackButton.jpg") }
				};
		Picture[][] wizardMenu = { { new Picture(basepath + "FightButton.jpg"),
				new Picture(basepath + "BlockButton.jpg"),
				new Picture(basepath + "ItemButton.jpg"),
				new Picture(basepath + "MagicButton.jpg")},
				{new Picture(basepath + "MagTest1.jpg"),
				new Picture(basepath + "MagTest2.jpg"),
				new Picture(basepath + "MagTest3.jpg"),
				new Picture(basepath + "BackButton.jpg")
				}};

		Picture backGround = new Picture(basepath + "BackGround.jpg"); // BackGround
																		// size:
																		// 500x500
		Picture victoryScreen = new Picture(basepath + "VictoryScreen.jpg");
		Picture defeatScreen = new Picture(basepath + "DefeatScreen.jpg");
		
		new RPGBattle(backGround, victoryScreen, defeatScreen, warriorPics, warriorMenu,
				ninjaPics, ninjaMenu, healerPics, healerMenu, wizardPics, wizardMenu,
				enemyPics, new Inventory());

	}

}
