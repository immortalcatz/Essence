package net.essence.proxy;

import net.essence.EssenceBlocks;
import net.essence.EssenceItems;
import net.essence.EssenceTabs;
import net.essence.blocks.tileentity.TileEntityEnrichedTable;
import net.essence.blocks.tileentity.TileEntityIncubator;
import net.essence.blocks.tileentity.TileEntityStatue;
import net.essence.client.render.EnumParticlesClasses;
import net.essence.dimension.DimensionHelper;
import net.essence.dimension.WorldGenEssence;
import net.essence.dimension.boil.gen.fortress.MapGenBoilBridge;
import net.essence.dimension.boil.gen.fortress.StructureBoilBridgePieces;
import net.essence.dimension.boil.gen.village.MapGenBoilVillage;
import net.essence.dimension.boil.gen.village.StructureBoilVillagePieces;
import net.essence.event.ArmorAbilityEvent;
import net.essence.event.ParticleEvent;
import net.essence.event.PlayerEvent;
import net.essence.items.tileentity.TileEntityBackpack;
import net.essence.misc.EssenceCommands;
import net.essence.util.Config;
import net.essence.util.EntityRegistry;
import net.essence.util.recipes.RecipeHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.slayer.api.SlayerAPI;

public class CommonProxy {

	public void registerClient() { }
	public void clientInit(FMLInitializationEvent event) { }
	public void clientPreInit() { }
	public void registerSounds() { }
	public void spawnParticle(EnumParticlesClasses particle, World worldObj, double x, double y, double z, boolean b) { }
	public void registerModModels() { }
	
	public void preInit(FMLPreInitializationEvent event) {
		Config.init(event);
		EssenceBlocks.addBlockNames();
		EssenceItems.addItemNames();
		EntityRegistry.init();
		RecipeHelper.init();
		DimensionHelper.init();
		DimensionHelper.addSpawns();
		EssenceTabs.init();
		addOreDictionary();
		SlayerAPI.addEventBus(new ArmorAbilityEvent());
		SlayerAPI.addForgeEventBus(new ArmorAbilityEvent());
		SlayerAPI.addEventBus(new ParticleEvent());
		SlayerAPI.addForgeEventBus(new ParticleEvent());
		SlayerAPI.addEventBus(new PlayerEvent());
		SlayerAPI.addForgeEventBus(new PlayerEvent());
		GameRegistry.registerTileEntity(TileEntityStatue.class, "EssenceStatue");
		GameRegistry.registerTileEntity(TileEntityEnrichedTable.class, "Enriched table");
		GameRegistry.registerTileEntity(TileEntityIncubator.class, "incubator");
		GameRegistry.registerTileEntity(TileEntityBackpack.class, "backpack");
		//SlayerAPI.addMapGen(MapGenBoilVillage.Start.class, "Boil Village");
		//SlayerAPI.addMapGen(MapGenBoilBridge.Start.class, "Boil Bridge");
		//StructureBoilBridgePieces.registerBoilFortressPieces();
		//StructureBoilVillagePieces.registerVillagePieces();
	}
	
	public void init(FMLInitializationEvent event) {
		GameRegistry.registerWorldGenerator(new WorldGenEssence(), 10);
		SlayerAPI.addForgeEventBus(new PlayerEvent());
		SlayerAPI.addEventBus(new PlayerEvent());
		//EssenceAchievements.init();
	}
	
	public void postInit(FMLPostInitializationEvent event) { }
	
	public void serverStarting(FMLServerStartingEvent event) {
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