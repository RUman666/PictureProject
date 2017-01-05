import java.lang.Math;
public class Character {
	
	Picture[] charPics;
	Picture[] abilityButtons;
	public int maxHP,HP,str,mag,vit,luck,def,intel;
	public boolean block;
	
	public Picture getPic(){
		int output = 0;
		if((double)HP/maxHP > (double)(1/3))
			output = 0;
		else if((double)HP/maxHP <= 0)
			output = 2;
		else if((double)HP/maxHP <= (double)(1/3))
			output = 1;
		return charPics[output];
	}
	
	public int tookHit(int enemyAtt){
		int chance = (int)(Math.random()*100);
		int output = enemyAtt;
		output = (int)(output *(1.0 - (double)(def * 2.0 / 100.0)));
		if (block)
			output = (int)(output * (2/3));
		if (chance < luck)
			output = 0;
		HP -= output;
		return output;
	}
	
	public int basicAttack(){
		return (str * 15);
	}
	public Picture[] sendMenu(){return null;}
}
