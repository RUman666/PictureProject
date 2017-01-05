
public class Ninja extends Character{
	
	Ninja(Picture[] Sprites, Picture[] menuButtons){
		charPics = new Picture[Sprites.length];
		abilityButtons = new Picture[menuButtons.length];
		for (int i = 0; i < charPics.length; i++)
			charPics[i] = Sprites[i];
		for (int i = 0; i < abilityButtons.length; i++)
			abilityButtons[i] = menuButtons[i];
		maxHP = (int)(Math.random()*200 + 800);
		HP = maxHP;
		str = (int)(Math.random()*5 + 20);
		mag = (int)(Math.random()*2 + 8);
		intel = (int)(Math.random()*2 + 3);
		vit = (int)(Math.random()*3 + 5);
		luck = (int)(Math.random()*10 + 25);
		def = (int)(Math.random()*3 + 8);
	}

}
