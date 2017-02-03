
public abstract class Friendly extends Character{
	
	Picture[][] abilityButtons;
	
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
		if (menu < 2){
			return abilityButtons[menu];
		}else {
			return items.getItemButtons()[menu-2];
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
	public void useRevive(){
		System.out.println("Used Revive");
		resetMenu();
		battle.nextTurn();
		battle.setMenu(getMenu());
	}
	public void useSmallHP(){
		System.out.println("Used SmallHP");
		resetMenu();
		battle.nextTurn();
		battle.setMenu(getMenu());
	}
	public void useBigHP(){
		System.out.println("Used BigHP");
		resetMenu();
		battle.nextTurn();
		battle.setMenu(getMenu());
	}	
	public void useSmallMP(){
		System.out.println("Used smallMP");
		resetMenu();
		battle.nextTurn();
		battle.setMenu(getMenu());
	}
	public void useBigMP(){
		System.out.println("Used BigMP");
		resetMenu();
		battle.nextTurn();
		battle.setMenu(getMenu());
	}
}
