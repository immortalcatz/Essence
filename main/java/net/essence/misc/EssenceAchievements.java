package net.essence.misc;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

public class EssenceAchievements {
    
    private static Achievement addAchievement(String name, int x, int y, Block image, Achievement haveFirst, boolean isSpecial){
		return isSpecial ? new Achievement(name, name, x, y, image, (Achievement)haveFirst).registerStat() : new Achievement(name, name, x, y, image, (Achievement)haveFirst).registerStat().setSpecial();
	}
	
	private static Achievement addAchievement(String name, int x, int y, Item image, Achievement haveFirst, boolean isSpecial){
		return isSpecial ? new Achievement(name, name, x, y, image, (Achievement)haveFirst).registerStat() : new Achievement(name, name, x, y, image, (Achievement)haveFirst).registerStat().setSpecial();
	}
    
    //public static AchievementPage page = new AchievementPage("Essence Of The Gods", );
    
    public static void init(){
		//AchievementPage.registerAchievementPage(page);
	}
}