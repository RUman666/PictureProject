public class Ninja extends Friendly {

	Ninja(Picture[] Sprites, Picture[][] menuButtons) {
		super(Sprites, menuButtons);
		maxHP = (int) (Math.random() * 200 + 800);
		HP = maxHP;
		str = (int) (Math.random() * 5 + 20);
		mag = (int) (Math.random() * 2 + 8);
		intel = (int) (Math.random() * 2 + 3);
		vit = (int) (Math.random() * 3 + 5);
		luck = (int) (Math.random() * 10 + 25);
		def = (int) (Math.random() * 3 + 8);
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
