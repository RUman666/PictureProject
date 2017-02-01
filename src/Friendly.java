
public abstract class Friendly extends Character{
	
	Picture[][] abilityButtons;
	Picture[][] itemButtons;
	
	Inventory items;
	public int mag, vit, intel;
	public int menu;
	public boolean block;
	public boolean firstAction = true;

	
	Friendly(Picture[] Sprites, Picture[][] menuButtons, Inventory inven, RPGBattle init) {
		super(Sprites, init);
		abilityButtons = new Picture[menuButtons.length][4];
		for (int i = 0; i < abilityButtons.length; i++) {
			abilityButtons[i] = new Picture[4];
			for (int j = 0; j < 4; j++) {
				abilityButtons[i][j] = menuButtons[i][j];
			}
		}
		resetMenu();
		items = inven;
		battle = init;
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
	
	

	public Picture[] getMenu() {
		if (menu < 3){
			return abilityButtons[menu];
		}else {
			return itemButtons[menu-3];
		}
	}
	
	public void resetMenu(){
		menu = 0;
	}
	
	public void resetTurn(){
		firstAction = true;
	}
	
	public int tookHit(int enemyAtt){
		int output = super.tookHit(enemyAtt);
		if (block)
			output = (int) (output * (2 / 3));
		return output;
	}
	
	public void turn(int area){
		if (firstAction){
			resetMenu();
			battle.setMenu(getMenu());
			block = false;
			if (strUp > 0){
				strUp--;
			}if (strUp < 0){
				strUp++;
			}if (defUp > 0){
				defUp--;
			}if (defUp < 0){
				defUp++;
			}HP += (int)((double)(vit/50 * maxHP));
			if (HP > maxHP){
				HP = maxHP;
			}
		}
		
	}
	
}
