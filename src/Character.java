import java.lang.Math;

public abstract class Character {

	Picture[] charPics;
	Picture[][] abilityButtons;
	public int maxHP, HP, str, mag, vit, luck, def, intel;
	public boolean block;
	public int strUp, defUp;
	private int menu;

	Character(Picture[] Sprites, Picture[][] menuButtons) {
		charPics = new Picture[Sprites.length];
		abilityButtons = new Picture[menuButtons.length][4];
		for (int i = 0; i < charPics.length; i++)
			charPics[i] = Sprites[i];
		for (int i = 0; i < abilityButtons.length; i++)
			for (int j = 0; j < abilityButtons[0].length; j++)
			abilityButtons[j][i] = menuButtons[j][i];
	}

	public Picture getPic() {
		int output = 0;
		if ((double) HP / (double) maxHP > (double) 1 / (double) 3)
			output = 0;
		else if ((double) HP / maxHP <= 0)
			output = 2;
		else if ((double) HP / (double) maxHP <= (double) 1 / (double) 3)
			output = 1;
		return charPics[output];
	}

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

	public Picture[] sendMenu() {
		return abilityButtons[0];
	}
}
