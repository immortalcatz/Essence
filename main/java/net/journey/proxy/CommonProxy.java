package net.journey.proxy;

import net.journey.*;
import net.journey.achievement.event.JourneyMineEvent;
import net.journey.achievement.event.JourneyOnCraftEvent;
import net.journey.blocks.tileentity.*;
import net.journey.client.BarTickHandler;
import net.journey.dimension.*;
import net.journey.enums.*;
import net.journey.event.*;
import net.journey.misc.*;
import net.journey.util.*;
import net.journey.util.EntityRegistry;
import net.journey.util.recipes.*;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.*;
import net.minecraft.stats.Achievement;
import net.minecraft.world.*;
import net.minecraftforge.common.*;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.event.*;
import net.minecraftforge.fml.common.registry.*;
import net.minecraftforge.oredict.*;
import net.slayer.api.*;

public class CommonProxy {

	public static Achievement achievementore;
	public static Achievement achievementGem;
	public static Achievement achievementSapphireSword;
	public void updateDarkEnergy(int amount) { }
	public void updateEssence(int amount) { }
	public void updatePower(int amount) { }
	public void registerClient() { }
	public void clientInit(FMLInitializationEvent event) { }
	public void clientPreInit() { }
	public void registerSounds() { }
	public void spawnParticle(EnumParticlesClasses particle, World worldObj, double x, double y, double z, boolean b) { }
	public void registerModModels() { }
	
	public void preInit(FMLPreInitializationEvent event) {
		Config.init(event);
		//Essence.tropicalWater.setBlock(EssenceBlocks.tropicalWater);
		EntityRegistry.init();
		JourneyMaterialRecipes.init();
		JourneyBlockRecipes.init();
		JourneyMiscRecipes.init();
		JourneySmeltingRecipes.init();
		JourneyWeaponRecipes.init();
		DimensionHelper.init();
		DimensionHelper.addSpawns();
		JourneyTabs.init();
		
		if(SlayerAPI.DEVMODE) LangRegistry.instance.register();
		addOreDictionary();
		SlayerAPI.registerEvent(new ArmorAbilityEvent());
		SlayerAPI.registerEvent(new PlayerEvent());
		SlayerAPI.registerEvent(new BarTickHandler());
		GameRegistry.registerTileEntity(TileEntityGrindstone.class, "grindstone");
		GameRegistry.registerTileEntity(TileEntityKnowledgeTable.class, "Knowledge Table");
		GameRegistry.registerTileEntity(TileEntitySummoningTable.class, "Summoning Table");
		GameRegistry.registerTileEntity(TileEntityTrophyTable.class, "Trophy Table");
		GameRegistry.registerTileEntity(TileEntityJourneyChest.class, "Journey Chest");
		GameRegistry.registerTileEntity(TileEntityNetherFurnace.class, "Nether Furnace");
		//SlayerAPI.addMapGen(MapGenBoilVillage.Start.class, "Boil Village");
		//SlayerAPI.addMapGen(MapGenBoilBridge.Start.class, "Boil Bridge");
		//StructureBoilBridgePieces.registerBoilFortressPieces();
		//StructureBoilVillagePieces.registerVillagePieces();
		MinecraftForge.addGrassSeed(new ItemStack(JourneyItems.tomatoSeeds), 5);
		FMLCommonHandler.instance().bus().register(new JourneyOnCraftEvent());
		FMLCommonHandler.instance().bus().register(new JourneyMineEvent());
	}
	public void init(FMLInitializationEvent event) {
		achievementore = (Achievement) new Achievement("achievement.ore", "ore", 0, 0, new ItemStack(JourneyItems.sapphire), (Achievement)null).initIndependentStat().registerStat();
		achievementGem = (Achievement) new Achievement("Gemstone Obtainer", "ore", -2, 0, new ItemStack(JourneyItems.blueGem), (Achievement)null).initIndependentStat().registerStat();
		achievementSapphireSword = (Achievement) new Achievement("achievement.sapphireSword", "sapphireSword", 0, 2, new ItemStack(JourneyItems.sapphireSword), achievementore).registerStat();	
		AchievementPage ap = new AchievementPage("Journey Achievements", new Achievement[]
				{achievementore, 
				 achievementSapphireSword, 
				 achievementGem});
		AchievementPage.registerAchievementPage(ap);
		GameRegistry.registerWorldGenerator(new WorldGenEssence(), 2);
		SlayerAPI.registerEvent(new PlayerEvent());
		//EssenceAchievements.init();
	}
	
	public void postInit(FMLPostInitializationEvent event) {

	}
	
	public void serverStarting(FMLServerStartingEvent event) {
		SlayerAPI.registerCommand(new EssenceCommands());
		SlayerAPI.registerCommand(new DimensionCommand());
	}
	
	private void addOreDictionary() {
		OreDictionary.registerOre("oreAshual", JourneyBlocks.ashualOre);
		OreDictionary.registerOre("oreCelestium", JourneyBlocks.celestiumOre);
		OreDictionary.registerOre("oreLunium", JourneyBlocks.luniumOre);
		OreDictionary.registerOre("oreShadium", JourneyBlocks.shadiumOre);
		OreDictionary.registerOre("oreFlairium", JourneyBlocks.flairiumOre);
		OreDictionary.registerOre("oreSapphire", JourneyBlocks.sapphireOre);
		OreDictionary.registerOre("ash", JourneyItems.ash);
		OreDictionary.registerOre("ingotCelestium", JourneyItems.celestiumIngot);
		OreDictionary.registerOre("ingotLunium", JourneyItems.luniumIngot);
		OreDictionary.registerOre("ingotShadium", JourneyItems.shadiumIngot);
		OreDictionary.registerOre("ingotFlairium", JourneyItems.flairiumIngot);
		OreDictionary.registerOre("gemSapphire", JourneyItems.sapphire);
	}
	
	public EntityPlayer getClientPlayer() { 
		return Minecraft.getMinecraft().thePlayer;
	}
}