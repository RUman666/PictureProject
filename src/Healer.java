public class Healer extends Friendly {

	Healer(Picture[] Sprites, Picture[][] menuButtons) {
		super(Sprites, menuButtons);
		maxHP = (int) (Math.random() * 200 + 1000);
		HP = maxHP;
		str = 1;
		mag = (int) (Math.random() * 5 + 12);
		intel = (int) (Math.random() * 2 + 32);
		vit = (int) (Math.random() * 3 + 10);
		luck = (int) (Math.random() * 3 + 6);
		def = (int) (Math.random() * 3 + 10);
	}
}
