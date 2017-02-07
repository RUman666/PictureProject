import java.lang.Math;

public abstract class Character {

	Picture[] charPics;
	RPGBattle battle;
	
	public int maxHP, HP, str, luck, def;
	
	public int strUp, defUp;

	Character(Picture[] Sprites, RPGBattle init) {
		charPics = new Picture[Sprites.length];
		for (int i = 0; i < charPics.length; i++) {
			charPics[i] = Sprites[i];
		}
		battle = init;
	}

	public abstract Picture getPic();
	
	public void tookHit(int enemyAtt) {
		int chance = (int) (Math.random() * 100);
		int output = enemyAtt;
		output = (int) (output * (1.0 - (double) (def * 2.0 / 100.0)));
		if (chance < luck)
			output = 0;
		HP -= output;
	}

	public int basicAttack() {
		return (str * 15);
	}
	
	public abstract void turn(int area);

	
}
