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
		if (menu == 2){
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
			}if (area == 4){
				resetMenu();
				battle.setMenu(getMenu());
			}
		}
	}

	
}
