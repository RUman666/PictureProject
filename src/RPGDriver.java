
public class RPGDriver {

	public static void main(String args){
		String basepath = "IndependentPictures\\";
		Picture[] warriorPics = { new Picture(basepath + "Person1Healthy.jpg"),
				new Picture(basepath + "Person1Wounded.jpg"),
				new Picture(basepath + "Person1Down.jpg") };
		Picture[] ninjaPics = { new Picture(basepath + "Person2Healthy.jpg"),
				new Picture(basepath + "Person2Wounded.jpg"),
				new Picture(basepath + "Person2Down.jpg") };
		Picture[] healerPics = { new Picture(basepath + "Person3Healthy.jpg"),
				new Picture(basepath + "Person3Wounded.jpg"),
				new Picture(basepath + "Person3Down.jpg") };
		Picture[] wizardPics = { new Picture(basepath + "Person4Healthy.jpg"),
				new Picture(basepath + "Person4Wounded.jpg"),
				new Picture(basepath + "Person4Down.jpg")};
		Picture[] enemyPics = { new Picture(basepath + "Enemy1.jpg")};
		
		Picture[][] warriorMenu = { {
				new Picture(basepath + "FightButton.jpg"),
				new Picture(basepath + "BlockButton.jpg"),
				new Picture(basepath + "ItemButton.jpg"),
				new Picture(basepath + "TechButton.jpg") },
				//{},
				{new Picture(basepath + "TechTest1.jpg"),
				new Picture(basepath + "TechTest2.jpg"),
				new Picture(basepath + "TechTest3.jpg"),
				new Picture(basepath + "BackButton.jpg")
				}};
		Picture[][] ninjaMenu = { { new Picture(basepath + "FightButton.jpg"),
				new Picture(basepath + "BlockButton.jpg"),
				new Picture(basepath + "ItemButton.jpg"),
				new Picture(basepath + "TechButton.jpg") },
				//{},
				{new Picture(basepath + "TechTest1.jpg"),
				new Picture(basepath + "TechTest2.jpg"),
				new Picture(basepath + "TechTest3.jpg"),
				new Picture(basepath + "BackButton.jpg") }
				};
		Picture[][] healerMenu = { { new Picture(basepath + "FightButton.jpg"),
				new Picture(basepath + "BlockButton.jpg"),
				new Picture(basepath + "ItemButton.jpg"),
				new Picture(basepath + "HealButton.jpg") } };
		Picture[][] wizardMenu = { { new Picture(basepath + "FightButton.jpg"),
				new Picture(basepath + "BlockButton.jpg"),
				new Picture(basepath + "ItemButton.jpg"),
				new Picture(basepath + "MagicButton.jpg")
		} };

		Picture backGround = new Picture(basepath + "BackGround.jpg"); // BackGround
																		// size:
																		// 500x500
		RPGBattle test = new RPGBattle(backGround, warriorPics, warriorMenu,
				ninjaPics, ninjaMenu, healerPics, healerMenu, wizardPics, wizardMenu,
				enemyPics);
		
		test.mouseClickedAction(test.getBg(), new Pixel(test.getBg(), 125, 350));
	}
}
