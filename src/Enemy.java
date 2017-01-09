
public class Enemy extends Character {
	
	Picture currentEnemy;
	
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

	
}
