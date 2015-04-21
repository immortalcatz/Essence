package net.essence.proxy;

import net.essence.*;
import net.essence.blocks.tileentity.*;
import net.essence.dimension.*;
import net.essence.enums.*;
import net.essence.event.*;
import net.essence.items.tileentity.*;
import net.essence.misc.*;
import net.essence.util.*;
import net.essence.util.EntityRegistry;
import net.essence.util.recipes.*;
import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraftforge.common.*;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.event.*;
import net.minecraftforge.fml.common.registry.*;
import net.minecraftforge.oredict.*;
import net.slayer.api.*;

public class CommonProxy {

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
		RecipeHelper.init();
		DimensionHelper.init();
		DimensionHelper.addSpawns();
		EssenceTabs.init();
		addOreDictionary();
		SlayerAPI.registerEvent(new ArmorAbilityEvent());
		SlayerAPI.registerEvent(new PlayerEvent());
		SlayerAPI.registerEvent(new KnowledgeEvent());
		GameRegistry.registerTileEntity(TileEntityStatue.class, "EssenceStatue");
		GameRegistry.registerTileEntity(TileEntityEnrichedTable.class, "Enriched table");
		GameRegistry.registerTileEntity(TileEntityIncubator.class, "incubator");
		GameRegistry.registerTileEntity(TileEntityBackpack.class, "backpack");
		GameRegistry.registerTileEntity(TileEntityGrindstone.class, "grindstone");
		GameRegistry.registerTileEntity(TileEntityCorbaPortal.class, "Corba Portal");
		GameRegistry.registerTileEntity(TileEntityEssenceSign.class, "Essence Sign");
		GameRegistry.registerTileEntity(TileEntityKnowledgeTable.class, "Knowledge Table");
		GameRegistry.registerTileEntity(TileEntitySummoningTable.class, "Summon Table");
		//SlayerAPI.addMapGen(MapGenBoilVillage.Start.class, "Boil Village");
		//SlayerAPI.addMapGen(MapGenBoilBridge.Start.class, "Boil Bridge");
		//StructureBoilBridgePieces.registerBoilFortressPieces();
		//StructureBoilVillagePieces.registerVillagePieces();
		MinecraftForge.addGrassSeed(new ItemStack(EssenceItems.tomatoSeeds), 5);
	}
	
	public void init(FMLInitializationEvent event) {
		GameRegistry.registerWorldGenerator(new WorldGenEssence(), 2);
		SlayerAPI.registerEvent(new PlayerEvent());
		SlayerAPI.registerEvent(new KnowledgeEvent());
		//EssenceAchievements.init();
	}
	
	public void postInit(FMLPostInitializationEvent event) {

	}
	
	public void serverStarting(FMLServerStartingEvent event) {
		SlayerAPI.registerCommand(new EssenceCommands());
		SlayerAPI.registerCommand(new DimensionCommand());
	}
	
	private void addOreDictionary() {
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