public class Warrior extends Friendly {

	Warrior(Picture[] Sprites, Picture[][] menuButtons) {
		super(Sprites, menuButtons);
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
	public void turn(RPGBattle battle, int area) {
		super.turn(battle, area);
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
				menu = 1;
				battle.setMenu(getMenu());
				firstAction = false;
			}else if (area == 3){
				menu = 2;
				battle.setMenu(getMenu());
				firstAction = false;
			}
		}else if (menu == 2){
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
		}
	}

	
}
