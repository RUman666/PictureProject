
public class Wizard extends Friendly {

	Wizard(Picture[] Sprites, Picture[][] menuButtons) {
		super(Sprites, menuButtons);
		maxHP = (int) (Math.random() * 200 + 1000);
		HP = maxHP;
		str = (int) (Math.random() * 2 + 4);
		mag = (int) (Math.random() * 5 + 18);
		intel = (int) (Math.random() * 2 + 32);
		vit = (int) (Math.random() * 3 + 10);
		luck = (int) (Math.random() * 3 + 6);
		def = (int) (Math.random() * 3 + 10);
	}
	
	

}
