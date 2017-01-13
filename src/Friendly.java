
public class Friendly extends Character{
	
	Picture[][] abilityButtons;
	
	public int mag, vit, intel;
	public boolean block;
	private int menu;
	Friendly(Picture[] Sprites, Picture[][] menuButtons) {
		super(Sprites);
		abilityButtons = new Picture[menuButtons.length][4];
		for (int i = 0; i < abilityButtons.length; i++) {
			abilityButtons[i] = new Picture[4];
			for (int j = 0; j < 4; j++) {
				abilityButtons[i][j] = menuButtons[i][j];
			}
		}
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

	public Picture[] sendMenu() {
		return abilityButtons[0];
	}
	
	public int tookHit(int enemyAtt){
		int output = super.tookHit(enemyAtt);
		if (block)
			output = (int) (output * (2 / 3));
		return output;
	}
	/*
	public void drawHP() {
		// TODO Auto-generated method stub
		
	}
	*/
}
