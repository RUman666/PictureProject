public class Healer extends Friendly {

	Healer(Picture[] Sprites, Picture[][] menuButtons, Inventory inven, RPGBattle init) {
		super(Sprites, menuButtons, inven, init);
		maxHP = (int) (Math.random() * 200 + 1000);
		HP = maxHP;
		str = 1;
		mag = (int) (Math.random() * 5 + 12);
		intel = (int) (Math.random() * 2 + 32);
		vit = (int) (Math.random() * 3 + 10);
		luck = (int) (Math.random() * 3 + 6);
		def = (int) (Math.random() * 3 + 10);
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
		}else if (menu == 2){
			if (area == 0){
				System.out.println("Pressed item1");
				resetMenu();
				battle.nextTurn();
			}if (area == 1){
				System.out.println("Pressed item2");
				resetMenu();
				battle.nextTurn();
			}if (area == 2){
				System.out.println("Pressed item3");
				resetMenu();
				battle.nextTurn();
			}if (area == 3){
				resetMenu();
				battle.setMenu(getMenu());
			}
		}else if (menu == 1){
			if (area == 0){
				System.out.println("Pressed heal1");
				resetMenu();
				battle.nextTurn();
			}if (area == 1){
				System.out.println("Pressed heal2");
				resetMenu();
				battle.nextTurn();
			}if (area == 2){
				System.out.println("Pressed heal3");
				resetMenu();
				battle.nextTurn();
			}if (area == 3){
				resetMenu();
				battle.setMenu(getMenu());
			}
		}
	}

	
}
