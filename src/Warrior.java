public class Warrior extends Friendly {

	Warrior(Picture[] Sprites, Picture[][] menuButtons, Inventory inven, RPGBattle init) {
		super(Sprites, menuButtons, inven, init);
		maxHP = (int) (Math.random() * 200 + 1200);
		HP = maxHP;
		str = (int) (Math.random() * 3 + 9);
		mag = (int) (Math.random() * 2 + 3);
		intel = (int) (Math.random() * 2 + 3);
		vit = (int) (Math.random() * 4 + 15);
		luck = (int) (Math.random() * 3 + 7);
		def = (int) (Math.random() * 3 + 15);
	}

	@Override
	public void turn(int area) {
		super.turn(area);
		if (menu == 0){
			if (area == 0){
				battle.getEnemy().tookHit(basicAttack());
				battle.setMenu(getMenu());
				battle.nextTurn();
				resetTurn();
			}else if (area == 1){
				block = true;
				battle.nextTurn();
				battle.setMenu(getMenu());
				resetTurn();
			}else if (area == 2){
				menu = 2;
				battle.setMenu(getMenu());
				firstAction = false;
			}else if (area == 3){
				menu = 1;
				battle.setMenu(getMenu());
				firstAction = false;
			}
		}else if (menu == 1){
			if (area == 0){
				System.out.println("Pressed tech1");
				resetMenu();
				battle.nextTurn();
			}if (area == 1){
				System.out.println("Pressed tech2");
				resetMenu();
				battle.nextTurn();
			}if (area == 2){
				System.out.println("Pressed tech3");
				resetMenu();
				battle.nextTurn();
			}if (area == 3){
				resetMenu();
				battle.setMenu(getMenu());
			}
		}else if (menu >= 2){
			
			int whichItem = items.getItem(menu - 2, area);
			if (whichItem == items.REVIVE){
				useRevive();
			}else if (whichItem == items.SMALLHP){
				useSmallHP();
			}else if (whichItem == items.BIGHP){
				useBigHP();
			}else if (whichItem == items.SMALLMP){
				useSmallMP();
			}else if (whichItem == items.BIGMP){
				useBigMP();
			}else if (whichItem == items.BACK){
				if (menu == 2){
					resetMenu();
					battle.setMenu(getMenu());
				}else{
					menu--;
					battle.setMenu(getMenu());
				}
			}else if (whichItem == items.NEXT){
				menu++;
				battle.setMenu(getMenu());
			}
		}
	}

	
}
