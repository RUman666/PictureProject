public class Enemy extends Character {
	
	Picture currentEnemy;
	private int xcoord = 250;
	private int ycoord = 175;
	
	RPGBattle battle;
	Enemy(Picture[] Sprites, int level) {
		super(Sprites);
		currentEnemy = Sprites[level - 1];
		maxHP = (int) (Math.random() * 500 + 1000 + (500 * level));
		HP = maxHP;
		str = (int) (Math.random() * 10 + 65 + (10 * level));
		luck = (int) (Math.random() * 3 + 7 + (2 * level));
		def = (int) (Math.random() * 3 + 15 + (2 * level));
	}

	public Picture getPic() {
		return currentEnemy;
	}
	/*
	public void drawHP(){
		int storage;
		for(int i = xcoord; i < (150 * HP / maxHP); i++){
			for (int j = ycoord + 10; j > ycoord; j--){
				Pixel red = battle.getBackGround().getPixel(i, j);
				red.setBlue(0);
				red.setGreen(0);
				red.setRed(255);
			}
			storage = i;
		}
		for (int i = storage; i < 400; i++){
			for (int j = ycoord + 10; i > ycoord; j--) {
				Pixel green = battle.getBackGround().getPixel(i, j);
				green.setBlue(53);
				green.setRed(171);
				green.setGreen(211);
			}
		}
	}
	*/

	
}
