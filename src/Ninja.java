public class Ninja extends Friendly {

	Ninja(Picture[] Sprites, Picture[][] menuButtons) {
		super(Sprites, menuButtons);
		maxHP = (int) (Math.random() * 200 + 800);
		HP = maxHP;
		str = (int) (Math.random() * 5 + 20);
		mag = (int) (Math.random() * 2 + 8);
		intel = (int) (Math.random() * 2 + 3);
		vit = (int) (Math.random() * 3 + 5);
		luck = (int) (Math.random() * 10 + 25);
		def = (int) (Math.random() * 3 + 8);
	}

}
