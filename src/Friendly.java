
public abstract class Friendly extends Character{
	
	Picture[][] abilityButtons;
	
	public int mag, vit, intel;
	public int menu;
	public boolean block;
	public boolean firstAction = true;
	Friendly(Picture[] Sprites, Picture[][] menuButtons) {
		super(Sprites);
		abilityButtons = new Picture[menuButtons.length][4];
		for (int i = 0; i < abilityButtons.length; i++) {
			abilityButtons[i] = new Picture[4];
			for (int j = 0; j < 4; j++) {
				abilityButtons[i][j] = menuButtons[i][j];
			}
		}
		resetMenu();
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
		return abilityButtons[menu];
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
	
	public void turn(RPGBattle battle, int area){
		if (firstAction){
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
		if (menu == 0){
			if (area == 0){
				battle.getEnemy().tookHit(basicAttack());
				battle.setMenu(getMenu());
				battle.nextTurn();
				resetTurn();
			}if (area == 1){
				block = true;
				battle.nextTurn();
				battle.setMenu(getMenu());
				resetTurn();
			}if (area == 2){
				menu = 1;
				battle.setMenu(getMenu());
				firstAction = false;
			}if (area == 3){
				menu = 2;
				battle.setMenu(getMenu());
				firstAction = false;
			}
		}
	}
	
}
