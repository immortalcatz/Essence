package net.journey;

import java.util.HashMap;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraft.util.StatCollector;
import net.minecraftforge.common.AchievementPage;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

public class JourneyAchievements {

	private static AchievementPage achievementsPage;
	private static HashMap<String, Achievement> achievementsList = new HashMap<String, Achievement>();
	private static HashMap<String, AchievementCondition> achievementItems = new HashMap<String, AchievementCondition>();

	public static void addAchievement (String n, Achievement a, ItemStack s, String tc) {
		if (s == null || s.getItem() == null) return;
		achievementsList.put(n, (Achievement) a.registerStat());
		achievementItems.put(s.getUnlocalizedName(), new AchievementCondition(n, tc));
	}

	public static void addAchievement (String name, Achievement achievement, String triggerCondition) {
		addAchievement(name, achievement, achievement.theItemStack, triggerCondition);
	}

	public static void addAchievement (String name, Achievement achievement) {
		addAchievement(name, achievement, achievement.theItemStack, "null");
	}

	public static Achievement getAchievement (String name) {
		return achievementsList.get(name);
	}

	public static void triggerAchievementEvent (EntityPlayer p, String n) {
		Achievement a = getAchievement(n);
		if (a != null) {
			p.triggerAchievement(a);
		}
	}

	public static void addAchievements() {
		int x = 5;
		addAchievement("Digging Deeper", ((Achievement) new Achievement("diggingDeeper", "diggingDeeper", -10+x, 0, JourneyItems.sapphire, null).initIndependentStat()).setSpecial(), "diggingDeeper");;

	}


	public static void registerAchievementPane () {
		Achievement[] achievements = new Achievement[achievementsList.size()];

		achievements = achievementsList.values().toArray(achievements);
		achievementsPage = new AchievementPage(StatCollector.translateToLocal("Journey Achievements"), achievements);
		AchievementPage.registerAchievementPage(achievementsPage);
	}

	@SubscribeEvent
	public void entityPickupEvent(EntityItemPickupEvent event) {
		ItemStack stack = event.item.getEntityItem().copy();
		stack.stackSize = 1;
		if (achievementItems.containsKey(stack.getUnlocalizedName()) && achievementItems.get(stack.getUnlocalizedName()).isCorrectCondition("pickup")){
			triggerAchievementEvent(event.entityPlayer, achievementItems.get(stack.getUnlocalizedName()).getName());
		}
	}

	@SubscribeEvent
	public void craftEvent(PlayerEvent.ItemCraftedEvent event) {
		ItemStack stack = event.crafting.copy();
		stack.stackSize = 1;
		if (achievementItems.containsKey(stack.getUnlocalizedName()) && achievementItems.get(stack.getUnlocalizedName()).isCorrectCondition("craft")){
			triggerAchievementEvent(event.player, achievementItems.get(stack.getUnlocalizedName()).getName());
		}
	}

	@SubscribeEvent
	public void smeltEvent(PlayerEvent.ItemSmeltedEvent event) {
		ItemStack stack = event.smelting.copy();
		stack.stackSize = 1;
		if (achievementItems.containsKey(stack.getUnlocalizedName()) && achievementItems.get(stack.getUnlocalizedName()).isCorrectCondition("smelt")){
			triggerAchievementEvent(event.player, achievementItems.get(stack.getUnlocalizedName()).getName());
		}
	}

	private static class AchievementCondition {
		private final String name;
		public final String condition;
		public AchievementCondition(String n, String c){
			name = n;
			condition = c;
		}

		public boolean isCorrectCondition(String s) { 
			return s.equals(condition); 
			
			}

		public String getName() { 
			
			return name; 
		}
	}

}