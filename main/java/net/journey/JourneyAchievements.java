/**
package net.journey;

import java.util.HashMap;

import net.journey.achievement.event.JourneyMineEvent;
import net.journey.achievement.event.JourneyOnCraftEvent;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraft.stats.AchievementList;
import net.minecraft.stats.StatBase;
import net.minecraft.util.StatCollector;
import net.minecraftforge.common.AchievementPage;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

public class JourneyAchievements {
	
	public static Achievement achievementore;
	public static Achievement achievementGem;
	public static Achievement achievementSapphireSword;
	
	@EventHandler
	public void preInitAchievements(FMLPreInitializationEvent e) {
		FMLCommonHandler.instance().bus().register(new JourneyOnCraftEvent());
		FMLCommonHandler.instance().bus().register(new JourneyMineEvent());
	}

	@EventHandler
	public void initAchievements(FMLInitializationEvent event) {
		achievementore = (Achievement) new Achievement("achievement.ore", "ore", 0, 0, new ItemStack(JourneyItems.sapphire), (Achievement)null).initIndependentStat().registerStat();
		achievementGem = (Achievement) new Achievement("Gemstone Obtainer", "ore", -2, 0, new ItemStack(JourneyItems.blueGem), (Achievement)null).initIndependentStat().registerStat();
		achievementSapphireSword = (Achievement) new Achievement("achievement.sapphireSword", "sapphireSword", 0, 2, new ItemStack(JourneyItems.sapphireSword), achievementore).registerStat();	
		AchievementPage ap = new AchievementPage("Journey Achievements", new Achievement[] {
			achievementore, 
			achievementSapphireSword, 
			achievementGem
			});
		AchievementPage.registerAchievementPage(ap);
		}
	}
*/