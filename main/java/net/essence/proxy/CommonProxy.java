package net.essence.proxy;

import net.essence.*;
import net.essence.blocks.tileentity.*;
import net.essence.dimension.*;
import net.essence.dimension.boil.gen.fortress.MapGenBoilBridge;
import net.essence.dimension.boil.gen.fortress.StructureBoilBridgePieces;
import net.essence.dimension.boil.gen.village.MapGenBoilVillage;
import net.essence.dimension.boil.gen.village.StructureBoilVillagePieces;
import net.essence.event.*;
import net.essence.items.tileentity.TileEntityBackpack;
import net.essence.misc.*;
import net.essence.util.*;
import net.essence.util.*;
import net.essence.util.EntityRegistry;
import net.essence.util.recipes.RecipeHelper;
import net.minecraftforge.oredict.*;
import net.slayer.api.*;
import cpw.mods.fml.common.event.*;
import cpw.mods.fml.common.registry.*;

public class CommonProxy {

	public void registerClient() { }
	public void clientInit(FMLInitializationEvent event) { }
	public void registerSounds() { }
	
	public static void preInit(FMLPreInitializationEvent event) {
		Config.init(event);
		EntityRegistry.init();
		RecipeHelper.init();
		DimensionHelper.init();
		DimensionHelper.addSpawns();
		EssenceTabs.init();
		addOreDictionary();
		SlayerAPI.addEventBus(new ArmorAbilityEvent());
		SlayerAPI.addForgeEventBus(new ArmorAbilityEvent());
		SlayerAPI.addEventBus(new PlayerEvent());
		SlayerAPI.addForgeEventBus(new PlayerEvent());
		GameRegistry.registerTileEntity(TileEntityStatue.class, "EssenceStatue");
		GameRegistry.registerTileEntity(TileEntityEnrichedTable.class, "Enriched table");
		GameRegistry.registerTileEntity(TileEntityIncubator.class, "incubator");
		GameRegistry.registerTileEntity(TileEntityBackpack.class, "backpack");
		SlayerAPI.addMapGen(MapGenBoilVillage.Start.class, "Boil Village");
		SlayerAPI.addMapGen(MapGenBoilBridge.Start.class, "Boil Bridge");
		StructureBoilBridgePieces.registerBoilFortressPieces();
		StructureBoilVillagePieces.registerVillagePieces();
	}
	
	public static void init(FMLInitializationEvent event) {
		GameRegistry.registerWorldGenerator(new WorldGenEssence(), 10);
		SlayerAPI.addForgeEventBus(new PlayerEvent());
		SlayerAPI.addEventBus(new PlayerEvent());
		//EssenceAchievements.init();
	}
	
	public static void postInit(FMLPostInitializationEvent event) { }
	
	public static void serverStarting(FMLServerStartingEvent event) {
		SlayerAPI.registerCommand(new EssenceCommands());
	}
	
	private static void addOreDictionary() {
		OreDictionary.registerOre("oreAshual", EssenceBlocks.ashual);
		OreDictionary.registerOre("oreCelestium", EssenceBlocks.celestiumOre);
		OreDictionary.registerOre("oreLunium", EssenceBlocks.luniumOre);
		OreDictionary.registerOre("oreShadium", EssenceBlocks.shadiumOre);
		OreDictionary.registerOre("oreFlairium", EssenceBlocks.flairiumOre);
		OreDictionary.registerOre("oreSapphire", EssenceBlocks.sapphireOre);
		OreDictionary.registerOre("ash", EssenceItems.ash);
		OreDictionary.registerOre("ingotCelestium", EssenceItems.celestiumIngot);
		OreDictionary.registerOre("ingotLunium", EssenceItems.luniumIngot);
		OreDictionary.registerOre("ingotShadium", EssenceItems.shadiumIngot);
		OreDictionary.registerOre("ingotFlairium", EssenceItems.flairiumIngot);
		OreDictionary.registerOre("gemSapphire", EssenceItems.sapphire);
	}
}