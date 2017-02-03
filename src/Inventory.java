
public class Inventory {

	private int revive;
	private int smallHP;
	private int bigHP;
	private int smallMP;
	private int bigMP;
	
	public final int REVIVE = 0;
	public final int SMALLHP = 1;
	public final int BIGHP = 2;
	public final int SMALLMP = 3;
	public final int BIGMP = 4;
	public final int BACK = -1;
	public final int NEXT = -2;
	
	private boolean reviveAdded = false;
	private boolean smallHPAdded = false;
	private boolean bigHPAdded = false;
	private boolean smallMPAdded = false;
	private boolean bigMPAdded = false;
	
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
	Picture backButton = new Picture(basepath + "BackButton.jpg");
	Picture nextButton = new Picture(basepath + "NextButton.jpg");
	Picture[][] itemButtons;
	int[][] itemStorage;
	
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
	
	public Picture getBigMPPic(){
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
		if (revive == 0){reviveAdded = true;}
		if (smallHP == 0){smallHPAdded = true;}
		if (bigHP == 0){bigHPAdded = true;}
		if (smallMP == 0){smallMPAdded = true;}
		if (bigMP == 0){bigMPAdded = true;}
		
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
		itemStorage = new int[pages][4];
		for (int i = 0; i < pages; i++){
			int j = 0;
			if (itemsLeft == 3){
				if (!reviveAdded){
					itemButtons[i][j] = getRevivePic();
					itemStorage[i][j] = REVIVE;
					reviveAdded = true;
					j++;
					itemsLeft--;
				}if (!smallHPAdded){
					itemButtons[i][j] = getSmallHPPic();
					itemStorage[i][j] = SMALLHP;
					smallHPAdded = true;
					j++;
					itemsLeft--;
				}if (!bigHPAdded){
					itemButtons[i][j] = getBigHPPic();
					itemStorage[i][j] = BIGHP;
					bigHPAdded = true;
					j++;
					itemsLeft--;
				}if (!smallMPAdded){
					itemButtons[i][j] = getSmallMPPic();
					itemStorage[i][j] = SMALLMP;
					smallMPAdded = true;
					j++;
					itemsLeft--;
				}if (!bigMPAdded){
					itemButtons[i][j] = getBigMPPic();
					itemStorage[i][j] = BIGMP;
					bigMPAdded = true;
					j++;
					itemsLeft--;		
				}itemButtons[i][3] = backButton;
				itemStorage[i][3] = BACK;
			}else if (itemsLeft > 3){
				if (!reviveAdded && j < 2){
					itemButtons[i][j] = getRevivePic();
					itemStorage[i][j] = REVIVE;
					reviveAdded = true;
					j++;
					itemsLeft--;
				}if (!smallHPAdded && j < 2){
					itemButtons[i][j] = getSmallHPPic();
					itemStorage[i][j] = SMALLHP;
					smallHPAdded = true;
					j++;
					itemsLeft--;
				}if (!bigHPAdded && j < 2){
					itemButtons[i][j] = getBigHPPic();
					itemStorage[i][j] = BIGHP;
					bigHPAdded = true;
					j++;
					itemsLeft--;
				}if (!smallMPAdded && j < 2){
					itemButtons[i][j] = getSmallMPPic();
					itemStorage[i][j] = SMALLMP;
					smallMPAdded = true;
					j++;
					itemsLeft--;
				}if (!bigMPAdded && j < 2){
					itemButtons[i][j] = getBigMPPic();
					itemStorage[i][j] = BIGMP;
					bigMPAdded = true;
					j++;
					itemsLeft--;		
				}itemButtons[i][2] = backButton;
				itemStorage[i][2] = BACK;
				itemButtons[i][3] = nextButton;
				itemStorage[i][3] = NEXT;
			}else if (itemsLeft < 3){
				if (!reviveAdded && j < 2){
					itemButtons[i][j] = getRevivePic();
					itemStorage[i][j] = REVIVE;
					reviveAdded = true;
					j++;
					itemsLeft--;
				}if (!smallHPAdded && j < 2){
					itemButtons[i][j] = getSmallHPPic();
					itemStorage[i][j] = SMALLHP;
					smallHPAdded = true;
					j++;
					itemsLeft--;
				}if (!bigHPAdded && j < 2){
					itemButtons[i][j] = getBigHPPic();
					itemStorage[i][j] = BIGHP;
					bigHPAdded = true;
					j++;
					itemsLeft--;
				}if (!smallMPAdded && j < 2){
					itemButtons[i][j] = getSmallMPPic();
					itemStorage[i][j] = SMALLMP;
					smallMPAdded = true;
					j++;
					itemsLeft--;
				}if (!bigMPAdded && j < 2){
					itemButtons[i][j] = getBigMPPic();
					itemStorage[i][j] = BIGMP;
					bigMPAdded = true;
					j++;
					itemsLeft--;		
				}itemButtons[i][2] = backButton;
				itemButtons[i][3] = blankItem;
			}
		}
	}
	
	public Picture[][] getItemButtons(){
		setItems();
		return itemButtons;
	}
	
	public int getItem(int page, int area){
		return itemStorage[page][area];
	}
	
}
