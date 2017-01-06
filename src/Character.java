import java.lang.Math;

public abstract class Character {

	Picture[] charPics;
	
	public int maxHP, HP, str, luck, def;
	public boolean block;
	public int strUp, defUp;
	private int menu;

	Character(Picture[] Sprites) {
		charPics = new Picture[Sprites.length];
		for (int i = 0; i < charPics.length; i++) {
			charPics[i] = Sprites[i];
		}
	}

	public abstract Picture getPic();
	
	public int tookHit(int enemyAtt) {
		int chance = (int) (Math.random() * 100);
		int output = enemyAtt;
		output = (int) (output * (1.0 - (double) (def * 2.0 / 100.0)));
		if (block)
			output = (int) (output * (2 / 3));
		if (chance < luck)
			output = 0;
		HP -= output;
		return output;
	}

	public int basicAttack() {
		return (str * 15);
	}

	
}
