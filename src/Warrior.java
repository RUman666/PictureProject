
public class Warrior extends Character {

	Warrior(Picture[] Sprites, Picture[] menuButtons){
		charPics = new Picture[Sprites.length];
		abilityButtons = new Picture[menuButtons.length];
		for (int i = 0; i < charPics.length; i++)
			charPics[i] = Sprites[i];
		for (int i = 0; i < abilityButtons.length; i++)
			abilityButtons[i] = menuButtons[i];
		maxHP = (int)(Math.random()*200 + 1200);
		HP = maxHP;
		str = (int)(Math.random()*3 + 9);
		mag = (int)(Math.random()*2 + 3);
		intel = (int)(Math.random()*2 + 3);
		vit = (int)(Math.random()*4 + 15);
		luck = (int)(Math.random()*3 + 7);
		def = (int)(Math.random()*3 + 15);
		
	}




	public Picture[] sendMenu() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
