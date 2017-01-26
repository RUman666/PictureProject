public class Healer extends Friendly {

	Healer(Picture[] Sprites, Picture[][] menuButtons) {
		super(Sprites, menuButtons);
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
		}
	}

	
}
