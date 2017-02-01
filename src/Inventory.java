
public class Inventory {

	private int revive;
	private int smallHP;
	private int bigHP;
	private int smallMP;
	private int bigMP;
	
	Inventory(){
		revive = 2;
		smallHP = 2;
		bigHP = 2;
		smallMP = 2;
		bigMP = 2;
	}
	
	static String basepath = "IndependentPictures\\";
	
	Picture blankItem = new Picture(basepath + "BlankItem.jpg");
	Picture smallHP1 = new Picture(basepath + "SmallHP1.jpg");
	Picture smallHP2 = new Picture(basepath + "SmallHP2.jpg");
	Picture bigHP1 = new Picture(basepath + "BigHP1.jpg");
	Picture bigHP2 = new Picture(basepath + "BigHP2.jpg");
	Picture revive1 = new Picture(basepath + "Revive1.jpg");
	Picture revive2 = new Picture(basepath + "Revive2.jpg");
	Picture smallMP1 = new Picture(basepath + "SmallMP1.jpg");
	Picture smallMP2 = new Picture(basepath + "SmallMP2.jpg");
	Picture bigMP1 = new Picture(basepath + "BigMP1.jpg");
	Picture bigMP2 = new Picture(basepath + "BigMP2.jpg");
	Picture[][] itemButtons;
	
	public int getRevive(){return revive;}
	public int getSmallHP(){return smallHP;}
	public int getBigHP(){return bigHP;}
	public int getSmallMP(){return smallMP;}
	public int getBigMP(){return bigMP;}
	
	public Picture getRevivePic(){
		Picture output;
		if (revive == 2){
			output = revive2;
		}else if (revive == 1){
			output = revive1;
		}else {
			output = blankItem;
		}
		return output;
	}
	public Picture getSmallMPPic(){
		Picture output;
		if (smallMP == 2){
			output = smallMP2;
		}else if (smallMP == 1){
			output = smallMP1;
		}else {
			output = blankItem;
		}
		return output;
	}
	
	public Picture getbigMPPic(){
		Picture output;
		if (bigMP == 2){
			output = bigMP2;
		}else if (bigMP == 1){
			output = bigMP1;
		}else {
			output = blankItem;
		}
		return output;
	}
	
	public Picture getSmallHPPic(){
		Picture output;
		if (smallHP == 2){
			output = smallHP2;
		}else if (smallHP == 1){
			output = smallHP1;
		}else {
			output = blankItem;
		}
		return output;
	}
	
	public Picture getBigHPPic(){
		Picture output;
		if (bigHP == 2){
			output = bigHP2;
		}else if (bigHP == 1){
			output = bigHP1;
		}else {
			output = blankItem;
		}
		return output;
	}
	
	private int howMany() {
		int output = 0;
		if (revive > 0){
			output++;
		}if (smallHP > 0){
			output++;
		}if (bigHP > 0){
			output++;
		}if (smallMP > 0){
			output++;
		}if (bigMP > 0){
			output++;
		}
		return output;
	}
	
	private void setItems(){
		int itemsLeft = howMany();
		int pages = 0;
		for (int i = itemsLeft; i > 0;){
			if (pages == 0 && i <= 3){
				pages++;
				i = 0;
			}else if (i > 3) {
				i -= 2;
				pages++;
			}else if (i <= 3){
				i = 0;
				pages++;
			}
		}
		itemButtons = new Picture[pages][4];
		for (int i = 0; i < pages; i++){
			for (int j = 0; j < 4; j++){
				if (itemsLeft > 3){
					
				}
			}
		}
	}
	
	public Picture[][] getItemButtons(){
		setItems();
		return itemButtons;
	}
	
}
