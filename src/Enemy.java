import java.lang.Math;
public class Enemy extends Character {
	
	Picture currentEnemy;
	private int xcoord = 250;
	private int ycoord = 175;
	
	RPGBattle battle;
	Enemy(Picture[] Sprites, int level) {
		super(Sprites);
		currentEnemy = Sprites[level - 1];
		maxHP = (int) (Math.random() * 500 + 1000 + (500 * level));
		HP = maxHP;
		str = (int) (Math.random() * 10 + 65 + (10 * level));
		luck = (int) (Math.random() * 3 + 7 + (2 * level));
		def = (int) (Math.random() * 3 + 15 + (2 * level));
	}

	public Picture getPic() {
		return currentEnemy;
	}
	
	public void turn(RPGBattle battle, int area){ }
	
	public void turn(RPGBattle battle){
		int war, wiz, nin, heal;
		war = battle.getWar().HP;
		wiz = battle.getWiz().HP;
		nin = battle.getNin().HP;
		heal = battle.getHeal().HP;
		if (heal > 0 && heal < 100){
			battle.getHeal().tookHit(basicAttack());
		}else if (nin > 0 && nin < 100){
			battle.getNin().tookHit(basicAttack());
		}else if (wiz > 0 && wiz < 100){
			battle.getWiz().tookHit(basicAttack());
		}else if (war > 0 && war < 100){
			battle.getWar().tookHit(basicAttack());
		}else {
			int output;
			if (war > 0 && heal > 0 && wiz > 0 && nin > 0){
				boolean valid = false;
				while (!valid){
					output = (int)(Math.random() * 4 + 1);
					if (output == 1 && nin > 0){
						battle.getNin().tookHit(basicAttack());
						valid = true;
					}else if (output == 2 && wiz > 0){
						battle.getWiz().tookHit(basicAttack());
						valid = true;
					}else if (output == 3 && heal > 0){
						battle.getHeal().tookHit(basicAttack());
						valid = true;
					}else if (output == 4 && war > 0){
						battle.getWar().tookHit(basicAttack());
						valid = true;
					}
				}
			}
		}
		battle.nextTurn();

	}
	
}
